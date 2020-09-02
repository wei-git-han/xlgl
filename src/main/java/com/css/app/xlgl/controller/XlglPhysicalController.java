package com.css.app.xlgl.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

import cn.com.css.filestore.impl.HTTPFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.PinYinUtil;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.entity.XlglPhysicalRecord;
import com.css.app.xlgl.service.XlglPhysicalRecordService;
import com.css.app.xlgl.service.XlglPhysicalService;
import com.css.base.utils.*;
import org.apache.poi.hssf.eventusermodel.examples.XLS2CSVmra;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 军事体育训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 19:38:37
 */
@Controller
@RequestMapping("/app/xlgl/xlglphysical")
public class XlglPhysicalController {
	@Autowired
	private XlglPhysicalService xlglPhysicalService;

	@Value("${filePath}")
	private String filePath;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglPhysicalRecordService xlglPhysicalRecordService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("userId",CurrentUser.getUserId());
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglPhysical> xlglPhysicalList = xlglPhysicalService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglPhysicalList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglPhysical xlglPhysical = xlglPhysicalService.queryObject(id);
		Response.json("xlglPhysical", xlglPhysical);
	}

	@ResponseBody
	@RequestMapping("/getUserInfo")
	public void getUserInfo(){
		JSONObject jsonObject = new JSONObject();
		String userId = CurrentUser.getUserId();
		String userName = CurrentUser.getUsername();
		jsonObject.put("userId",userId);
		jsonObject.put("userName",userName);
		Response.json(jsonObject);
	}

	//(int age,int up,int sit,int sRun,int tRun,int sex,int type )
	/**
	 * 保存
	 * 页面输入分数，会自动算出所有的分数，按照不同字段传进来就行
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglPhysical xlglPhysical){
		xlglPhysical.setId(UUIDUtils.random());
		xlglPhysical.setCreator(CurrentUser.getUserId());
		xlglPhysical.setName(CurrentUser.getUsername());
		xlglPhysical.setCreatedTime(new Date());
		xlglPhysical.setUserId(CurrentUser.getUserId());
		xlglPhysical.setNormal("0");//1是正式导入，0是自己保存
		xlglPhysicalService.save(xlglPhysical);
		Response.json("result","success");
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglphysical:update")
	public void update(@RequestBody XlglPhysical xlglPhysical){
		xlglPhysicalService.update(xlglPhysical);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		String[] ids = id.split(",");
		xlglPhysicalService.deleteBatch(ids);
		Response.json("result","success");
	}

	public void downloadFile(String fileId) {
		HTTPFile httpFile = new HTTPFile(fileId);
		String fileName = httpFile.getFileName();
		Response.download(fileName, httpFile.getInputSteam());
	}

	/**
	 * 军事体育成绩先导出
	 */
	@ResponseBody
	@RequestMapping("/exportList")
	public void exportList(String fileId,HttpServletResponse response){
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orgId",fileId);
		List<BaseAppUser> infoList = baseAppUserService.queryAllExcelList(map);
		File tempFile = new File(filePath, "军事体育成绩清单.xls");
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is;
		try {
			is = xlglPhysicalService.createExcelInfoFile(infoList, tempFile.getAbsolutePath());
            OutputStream os = null;
            byte[] buff = new byte[1024];
            response.reset();
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(tempFile.getName().getBytes(),"ISO-8859-1"));
            os = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            int i = 0;
            try {
                while ((i = bis.read(buff)) != -1) {
                    os.write(buff, 0, i);
                    os.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                bis.close();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 军事体育成绩导入
	 */

	@ResponseBody
	@RequestMapping("/importExcel")
	public void importExcel(@RequestParam(required = false) MultipartFile file) {
		JSONObject jsonObject = new JSONObject();
		try {
			//文件上传记录
			XlglPhysicalRecord xlglPhysicalRecord = new XlglPhysicalRecord();
			String id = UUIDUtils.random();
			xlglPhysicalRecord.setId(id);
			xlglPhysicalRecord.setUpUserId(CurrentUser.getUserId());
			xlglPhysicalRecord.setUpDeptName(CurrentUser.getOrgName());
			xlglPhysicalRecord.setUpUserName(CurrentUser.getUsername());
			String fileId = FileBaseUtil.fileServiceUpload(file);
			HTTPFile httpFile = new HTTPFile(fileId);
			InputStream inputStream = httpFile.getInputSteam();
			List<XlglPhysical> list = xlglPhysicalService.importExcle(inputStream,id);
			if (list != null && list.size() > 0) {
				for (XlglPhysical xlglPhysical : list) {
					xlglPhysicalService.save(xlglPhysical);
				}
			}

			xlglPhysicalRecord.setCreatedTime(new Date());
			xlglPhysicalRecordService.save(xlglPhysicalRecord);
			Response.json("fileId",fileId);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	/**
	 *  @param age 年龄
	 * @param up  引体向上
	 * @param sit  仰卧起坐
	 * @param sRun 30*2跑
	 * @param tRun 3000米跑
	 * @param sex 性别  0男，1女
	 * @param type 1:一类人员；2：二类人员；3：三类人员
	 */
	@ResponseBody
	@RequestMapping("/getSumCore")
	public void getSumCore(@RequestParam(required = false) String age,@RequestParam(required = false) String ytxs,@RequestParam(required = false) String ywqz,@RequestParam(required = false) String sxp,@RequestParam(required = false) String cpf,@RequestParam(required = false) String cpm,@RequestParam(required = false) String sex,@RequestParam(required = false) String type,@RequestParam(required = false) String wight,@RequestParam(required = false) String high ){
		JSONObject jsonObject = new JSONObject();
		int sum = 0;
		int shang = 0;
		int zuo = 0;
		int pao = 0;
		int changpao = 0;
		float BMI = 0.0f;
		String hg = "";
		int age1 = Integer.parseInt(age);
		float s = 0.0f;
		if(StringUtils.isNotBlank(sxp)){
			s = Float.parseFloat(sxp) * 10;
		}
		int sxp1 = Math.round(s);
		float f = 0.0f;
		String string = "";
		if(StringUtils.isNotBlank(cpm) && StringUtils.isNotBlank(cpf)){
			string = cpf+"."+cpm;
			f = Float.parseFloat(string) * 100;
		}
		int cp1 = Math.round(f);
		int ytxs1 = 0;
		if(StringUtils.isNotBlank(ytxs)){
			ytxs1 = Integer.parseInt(ytxs);
		}
		int ywqz1 = 0;
		if(StringUtils.isNotBlank(ywqz)){
			ywqz1 = Integer.parseInt(ywqz);
		}
		if("0".equals(sex)){
			JSONObject js = new JSONObject();
			js = getManSumCore(age1,ytxs1,ywqz1,sxp1*10,cp1*100);
			sum = (int) js.get("sum");
			shang = (int)js.get("y");
			zuo = (int)js.get("z");
			pao = (int)js.get("s");
			changpao = (int)js.get("r");
			float t = Float.parseFloat(wight) * 10;
			int w = Math.round(t);
			float h1 = Float.parseFloat(high);
			int h = Math.round(h1);
			int j = h * h;
			BMI = w/j;
			if(age1 < 24){
				if(BMI >= 18.5 && BMI <=25.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 25 && age1 <=29){
				if(BMI >= 18.5 && BMI <=26.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 30 && age1 <=39){
				if(BMI >= 18.5 && BMI <=27.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 40 && age1 <=49){
				if(BMI >= 18.5 && BMI <=28.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 50 && age1 <=59){
				if(BMI >= 18.5 && BMI <=29.4){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 60){
				if(BMI >= 18.5 && BMI <=29.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}
		}else {
			JSONObject js = new JSONObject();
			js  = getWomanSumCore(age1,ytxs1,ywqz1,sxp1*10,cp1*100);
			sum = (int) js.get("sum");
			shang = (int)js.get("o");
			zuo = (int)js.get("m");
			pao = (int)js.get("a");
			changpao = (int)js.get("w");
			int w = Integer.parseInt(wight);
			int h = Integer.parseInt(high);
			int j = h * h;
			BMI = w/j;
			if(age1 < 24){
				if(BMI >= 18.5 && BMI <=23.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 25 && age1 <=29){
				if(BMI >= 18.5 && BMI <=24.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 30 && age1 <=39){
				if(BMI >= 18.5 && BMI <=25.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 40 && age1 <=49){
				if(BMI >= 18.5 && BMI <=26.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 50 && age1 <=59){
				if(BMI >= 18.5 && BMI <=27.4){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}else if(age1 >= 60){
				if(BMI >= 18.5 && BMI <=27.9){
					hg = "合格";
				}else {
					hg = "不合格";
				}
			}
		}
		String dj = null;
		if("1".equals(type)){
			if(shang < 65 || zuo < 65 || pao < 65 || changpao < 65 || sum < 260){
				dj = "不及格";
			}else if(sum >= 260 && sum < 340){
				dj = "及格";
			}else if(sum >= 340 && sum < 380){
				dj = "良好";
			}else if(sum >= 380 && sum < 440){
				dj = "优秀";
			}else if(sum >= 440 && sum < 480){
				dj = "特3级";
			}else if(sum >= 480 && sum < 500){
				dj = "特2级";
			}else if(sum > 500){
				dj = "特1级";
			}
		}else if("2".equals(type)){
			if(shang < 60 || zuo < 60 || pao < 60 || changpao < 60 || sum < 240){
				dj = "不及格";
			}else if(sum >= 240 && sum < 320){
				dj = "及格";
			}else if(sum >= 320 && sum < 360){
				dj = "良好";
			}else if(sum >= 360 && sum < 440){
				dj = "优秀";
			}else if(sum >= 440 && sum < 480){
				dj = "特3级";
			}else if(sum >= 480 && sum < 500){
				dj = "特2级";
			}else if(sum > 500){
				dj = "特1级";
			}
		}else if("3".equals(type)){
			if(shang < 55 || zuo < 55 || pao < 55 || changpao < 55 || sum < 220){
				dj = "不及格";
			}else if(sum >= 220 && sum < 300){
				dj = "及格";
			}else if(sum >= 300 && sum < 340){
				dj = "良好";
			}else if(sum >= 340 && sum < 440){
				dj = "优秀";
			}else if(sum >= 440 && sum < 480){
				dj = "特3级";
			}else if(sum >= 480 && sum < 500){
				dj = "特2级";
			}else if(sum > 500){
				dj = "特1级";
			}
		}


		jsonObject.put("score",sum);
		jsonObject.put("dj",dj);
		jsonObject.put("BMI",BMI);
		jsonObject.put("hg",hg);
		jsonObject.put("shang",shang);
		jsonObject.put("zuo",zuo);
		jsonObject.put("pao",pao);
		jsonObject.put("changpao",changpao);
		jsonObject.put("result","success");
		Response.json(jsonObject);

	}

	/**
	 * 男子的成绩
	 * @param up
	 * @param sit
	 * @param sRun
	 * @param tRun
	 * @return
	 */
	public JSONObject getManSumCore(int age,int up,int sit,int sRun,int tRun){
		JSONObject jsonObject = new JSONObject();
		int y =  getManCore(age, up);//男子引体向上
		System.out.println(y);
		int z =  getManywqz(age,sit);//男子仰卧起坐
		System.out.println(z);
		int s =  getManSxRun(age,sRun);//男子 30*2蛇形跑
		System.out.println(s);
		int r =  getManRunCore(age,tRun);//男子3000米跑
		System.out.println(r);
		int sum = y+r+s+z;
		jsonObject.put("y",y);
		jsonObject.put("z",z);
		jsonObject.put("s",s);
		jsonObject.put("r",r);
		jsonObject.put("sum",sum);
		return jsonObject;
	}

	/**
	 * 女子成绩
	 * @param age
	 * @param up
	 * @param sit
	 * @param sRun
	 * @param tRun
	 * @return
	 */
	public JSONObject getWomanSumCore(int age,int up,int sit,int sRun,int tRun){
		JSONObject jsonObject = new JSONObject();
		int o = getWoMenDgqbCore(age,up);//女子单杠曲臂悬垂
		System.out.println(o);
		int m = getWomenCore(age,sit);//女子仰卧起坐
		System.out.println(m);
		int a = getWomenRun(age,sRun);//女子蛇形跑
		System.out.println(a);
		int w = getWomen3Run(age,tRun);//女子3000米跑
		System.out.println(w);
		jsonObject.put("o",o);
		jsonObject.put("m",m);
		jsonObject.put("a",a);
		jsonObject.put("w",w);

		int sum = o+m+a+w;
		jsonObject.put("sum",sum);
		return jsonObject;
	}

	/**
	 * 男子单杠引体向上 俯卧撑
	 *
	 * @param age
	 * @param num
	 */
	@ResponseBody
	@RequestMapping("/getManCore")
	public int getManCore(int age, int num) {
		int s = 0;
		int c = 0;
		if (age <= 24) {
			if ((num >= 10 && num <= 12)) {
				int t = 12 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			} else if (num > 12 && num <= 14) {
				int t = 14 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 75 - s;
			} else if (num == 15) {
				c = 75;
			} else if (num > 15 && num <= 30) {
				int t = 30 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			} else if (num > 30) {
				c = num - 30 + 100;
			}
		} else if (age >= 25 && age <= 27) {
			if (num >= 9 && num <= 11) {
				int t = 11 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			} else if (num > 11 && num <= 13) {
				int t = 13 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			} else if (num > 14 && num <= 16) {
				int t = 16 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 80 - s;
			} else if (num > 16 && num <= 28) {
				int t = 28 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			} else if (num > 28) {
				c = num - 28 + 100;
			}
		} else if (age >= 28 && age <= 30) {
			if (num >= 8 && num <= 12) {
				int t = 12 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			} else if (num > 12 && num <= 14) {
				int t = 14 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 80 - s;
			} else if (num > 14 && num <= 26) {
				int t = 26 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			} else if (num > 26) {
				c = num - 26 + 100;
			}
		} else if (age >= 31 && age <= 33) {
			if (num >= 7 && num <= 11) {
				int t = 11 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			} else if (num > 11 && num <= 17) {
				int t = 17 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			} else if (num > 17 && num <= 23) {
				int t = 23 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			} else if (num > 23) {

				c = num - 23 + 100;
			}
		} else if (age >= 34 && age <= 36) {
			if (num >= 6 && num <= 12) {
				int t = 12 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 85 - s;
			} else if (num > 12 && num <= 14) {
				int t = 14 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			} else if (num > 14 && num <= 20) {
				int t = 20 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			} else if (num > 20) {
				c = num - 20 + 100;
			}
		} else if (age >= 37 && age <= 39) {
			if (num >= 5 && num <= 11) {
				int t = 11 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 85 - s;
			} else if (num > 11 && num <= 17) {
				int t = 17 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 100 - s;
			} else if (num > 17) {
				c = num - 17 + 100;
			}
		} else if (age >= 40 && age <= 42) {
			if (num >= 27 && num <= 29) {
				int t = 29 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			} else if (num > 29 && num <= 39) {
				int t = 39 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 75 - s;
			} else if (num > 39 && num <= 57) {
				int t = 57 - num;
				int d = (57 - num) * 5 % 6;
				if (d == 0) {
					s = (57 - num) * 5 / 6;
				} else {
					s = (57 - num) * 5 / 6 + 1;
				}
				c = 90 - s;
			} else if (num > 57 && num <= 73) {
				int t = 73 - num;
				int d = t * 5 % 8;
				if (d == 0) {
					s = t * 5 / 8;
				} else {
					s = t * 5 / 8 + 1;
				}
				c = 90 - s;
			} else if (age >= 43 && age <= 45) {
				if (num >= 26 && num <= 28) {
					int t = 28 - num;
					int d = (28 - num) * 5 % 1;
					if (d == 0) {
						s = (28 - num) * 5 / 1;
					} else {
						s = (28 - num) * 5 / 1 + 1;
					}
					c = 65 - s;
				} else if (num > 28 && num <= 31) {
					int t = 31 - num;
					int d = t * 5 % 3;
					if (d == 0) {
						s = t * 5 / 3;
					} else {
						s = t * 5 / 3 + 1;
					}
					c = 70 - s;
				} else if (num > 32 && num <= 55) {
					int t = 55 - num;
					int d = t * 5 % 6;
					if (d == 0) {
						s = t * 5 / 6;
					} else {
						s = t * 5 / 6 + 1;
					}
					c = 90 - s;
				} else if (num > 56 && num <= 69) {
					int t = 69 - num;
					int d = t * 5 % 7;
					if (d == 0) {
						s = t * 5 / 7;
					} else {
						s = t * 5 / 7 + 1;
					}
					c = 100 - s;
				}
			} else if (age >= 46 && age <= 48) {
				if (num >= 23 && num <= 25) {
					int t = 25 - num;
					int d = t * 5 % 1;
					if (d == 0) {
						s = t * 5 / 1;
					} else {
						s = t * 5 / 1 + 1;
					}
					c = 65 - s;
				} else if (num > 25 && num <= 30) {
					int t = 30 - num;
					int d = t * 5 % 5;
					if (d == 0) {
						s = t * 5 / 5;
					} else {
						s = t * 5 / 5 + 1;
					}
					c = 70 - s;
				} else if (num > 31 && num <= 54) {
					int t = 54 - num;
					int d = t * 5 % 6;
					if (d == 0) {
						s = t * 5 / 6;
					} else {
						s = t * 5 / 6 + 1;
					}
					c = 90 - s;
				} else if (num > 55 && num <= 68) {
					int t = 68 - num;
					int d = t * 5 % 7;
					if (d == 0) {
						s = t * 5 / 7;
					} else {
						s = t * 5 / 7 + 1;
					}
					c = 100 - s;
				}
			} else if (age >= 49 && age <= 51) {
				if (num >= 21 && num <= 23) {
					int t = 23 - num;
					int d = t * 5 % 1;
					if (d == 0) {
						s = t * 5 / 1;
					} else {
						s = t * 5 / 1 + 1;
					}
					c = 65 - s;
				} else if (num > 23 && num <= 28) {
					int t = 28 - num;
					int d = t * 5 % 5;
					if (d == 0) {
						s = t * 5 / 5;
					} else {
						s = t * 5 / 5 + 1;
					}
					c = 70 - s;
				} else if (num > 29 && num <= 52) {
					int t = 52 - num;
					int d = t * 5 % 6;
					if (d == 0) {
						s = t * 5 / 6;
					} else {
						s = t * 5 / 6 + 1;
					}
					c = 90 - s;
				} else if (num > 53 && num <= 66) {
					int t = 66 - num;
					int d = t * 5 % 7;
					if (d == 0) {
						s = t * 5 / 7;
					} else {
						s = t * 5 / 7 + 1;
					}
					c = 100 - s;
				}
			} else if (age >= 52 && age <= 54) {
				if (num >= 18 && num <= 20) {
					int t = 20 - num;
					int d = t * 5 % 1;
					if (d == 0) {
						s = t * 5 / 1;
					} else {
						s = t * 5 / 1 + 1;
					}
					c = 65 - s;
				} else if (num > 20 && num <= 44) {
					int t = 44 - num;
					int d = t * 5 % 6;
					if (d == 0) {
						s = t * 5 / 6;
					} else {
						s = t * 5 / 6 + 1;
					}
					c = 85 - s;
				} else if (num > 44 && num <= 65) {
					int t = 65 - num;
					int d = t * 5 % 7;
					if (d == 0) {
						s = t * 5 / 7;
					} else {
						s = t * 5 / 7 + 1;
					}
					c = 100 - s;
				} else if (num > 44 && num <= 65) {
					int t = 65 - num;
					int d = t * 5 % 7;
					if (d == 0) {
						s = t * 5 / 7;
					} else {
						s = t * 5 / 7 + 1;
					}
					c = 100 - s;
				}
			} else if (age >= 55 && age <= 57) {
				if (num >= 16 && num <= 18) {
					int t = 18 - num;
					int d = t * 5 % 1;
					if (d == 0) {
						s = t * 5 / 1;
					} else {
						s = t * 5 / 1 + 1;
					}
					c = 65 - s;
				} else if (num > 18 && num <= 48) {
					int t = 48 - num;
					int d = t * 5 % 6;
					if (d == 0) {
						s = t * 5 / 6;
					} else {
						s = t * 5 / 6 + 1;
					}
					c = 90 - s;
				} else if (num > 49 && num <= 62) {
					int t = 62 - num;
					int d = t * 5 % 7;
					if (d == 0) {
						s = t * 5 / 7;
					} else {
						s = t * 5 / 7 + 1;
					}
					c = 100 - s;
				} else if (num > 49 && num <= 62) {
					int t = 62 - num;
					int d = t * 5 % 7;
					if (d == 0) {
						s = t * 5 / 7;
					} else {
						s = t * 5 / 7 + 1;
					}
					c = 100 - s;
				}
			} else if (age >= 58 && age <= 60) {
				if (num >= 10 && num <= 12) {
					int t = 12 - num;
					int d = t * 5 % 1;
					if (d == 0) {
						s = t * 5 / 1;
					} else {
						s = t * 5 / 1 + 1;
					}
					c = 65 - s;
				} else if (num > 12 && num <= 15) {
					int t = 15 - num;
					int d = t * 5 % 3;
					if (d == 0) {
						s = t * 5 / 3;
					} else {
						s = t * 5 / 3 + 1;
					}
					c = 70 - s;
				} else if (num > 15 && num <= 25) {
					int t = 25 - num;
					int d = t * 5 % 5;
					if (d == 0) {
						s = t * 5 / 5;
					} else {
						s = t * 5 / 5 + 1;
					}
					c = 80 - s;
				} else if (num > 25 && num <= 29) {
					int t = 29 - num;
					int d = t * 5 % 4;
					if (d == 0) {
						s = t * 5 / 4;
					} else {
						s = t * 5 / 4 + 1;
					}
					c = 85 - s;
				} else if (num > 29 && num <= 44) {
					int t = 44 - num;
					int d = t * 5 % 5;
					if (d == 0) {
						s = t * 5 / 5;
					} else {
						s = t * 5 / 5 + 1;
					}
					c = 100 - s;
				}
			}

		}
		return c;

	}

	/**
	 * 男子仰卧起坐
	 */
	@ResponseBody
	@RequestMapping("/getManywqz")
	public int getManywqz(int age, int num) {
		int s = 0;
		int c = 0;
		if (age <= 24) {
			if (num >= 46 && num <= 62) {
				int t = 62 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 75 - s;
			} else if (num >= 62 && num <= 87) {
				int t = 87 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 87) {
				c = 100 + (num - 100) / 2;
			}

		} else if (age >= 25 && age <= 27) {
			if (num >= 43 && num <= 67) {
				int t = 67 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 85 - s;
			} else if (num > 67 && num <= 82) {
				int t = 82 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 82) {
				c = 100 + (num - 100) / 2;
			}
		} else if (age >= 28 && age <= 30) {
			if (num >= 41 && num <= 65) {
				int t = 65 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 85 - s;
			} else if (num > 65 && num <= 80) {
				int t = 80 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 80) {
				c = 100 + (num - 100) / 2;
			}
		} else if (age >= 31 && age <= 33) {
			if (num >= 39 && num <= 63) {
				int t = 63 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 85 - s;
			} else if (num > 65 && num <= 80) {
				int t = 80 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 80) {
				c = 100 + (num - 80) / 2;
			}
		} else if (age >= 34 && age <= 36) {
			if (num >= 35 && num <= 55) {
				int t = 55 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 80 - s;
			} else if (num > 55 && num <= 75) {
				int t = 75 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 75) {
				c = 100 + (num - 75) / 2;
			}
		} else if (age >= 37 && age <= 39) {
			if (num >= 30 && num <= 45) {
				int t = 45 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 70 - s;
			} else if (num > 45 && num <= 49) {
				int t = 49 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 75 - s;
			} else if (num > 49 && num <= 74) {
				int t = 74 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			} else if (num > 74) {
				c = (num - 74) / 2 + 100;
			}
		} else if (age >= 40 && age <= 42) {
			if (num >= 28 && num <= 38) {
				int t = 38 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (num > 38 && num <= 41) {
				int t = 41 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 70 - s;
			} else if (num > 41 && num <= 71) {
				int t = 71 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 71) {
				c = (num - 71) / 2 + 100;
			}
		} else if (age >= 43 && age <= 45) {
			if (num >= 25 && num <= 35) {
				int t = 35 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (num > 35 && num <= 39) {
				int t = 39 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 70 - s;
			} else if (num > 39 && num <= 69) {
				int t = 69 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 69) {
				c = (num - 69) / 2 + 100;
			}
		} else if (age >= 46 && age <= 48) {
			if (num >= 23 && num <= 33) {
				int t = 33 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (num > 33 && num <= 37) {
				int t = 37 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 70 - s;
			} else if (num > 37 && num <= 47) {
				int t = 47 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 80 - s;
			} else if (num > 47 && num <= 51) {
				int t = 51 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 85 - s;
			} else if (num > 51 && num <= 66) {
				int t = 66 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 66) {
				c = (num - 69) / 2 + 100;
			}
		} else if (age >= 49 && age <= 51) {
			if (num >= 21 && num <= 26) {
				int t = 26 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 60 - s;
			} else if (num > 26 && num <= 32) {
				int t = 32 - num;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 65 - s;
			} else if (num > 32 && num <= 35) {
				int t = 35 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 70 - s;
			} else if (num > 35 && num <= 39) {
				int t = 39 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 75 - s;
			} else if (num > 39 && num <= 44) {
				int t = 44 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 80 - s;
			} else if (num > 44 && num <= 48) {
				int t = 48 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 85 - s;
			} else if (num > 48 && num <= 63) {
				int t = 63 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 63) {
				c = (num - 63) / 2 + 100;
			}
		} else if (age >= 52 && age <= 54) {
			if (num >= 19 && num <= 29) {
				int t = 29 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (num > 29 && num <= 37) {
				int t = 37 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 75 - s;
			} else if (num > 37 && num <= 42) {
				int t = 42 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 80 - s;
			} else if (num > 42 && num <= 46) {
				int t = 46 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 85 - s;
			} else if (num > 46 && num <= 61) {
				int t = 61 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 61) {
				c = (num - 61) / 2 + 100;
			}
		} else if (age >= 55 && age <= 57) {
			if (num >= 17 && num <= 22) {
				int t = 22 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 60 - s;
			} else if (num > 22 && num <= 26) {
				int t = 26 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 65 - s;
			} else if (num > 26 && num <= 31) {
				int t = 31 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 70 - s;
			} else if (num > 31 && num <= 39) {
				int t = 39 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 80 - s;
			} else if (num > 39 && num <= 59) {
				int t = 59 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 59) {
				c = (num - 59) / 2 + 100;
			}
		} else if (age >= 58 && age <= 60) {
			if (num >= 15 && num <= 17) {
				int t = 17 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 60 - s;
			} else if (num > 17 && num <= 57) {
				int t = 57 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			} else if (num > 57) {
				c = (num - 57) / 2 + 100;
			}
		}
		return c;
	}

	/**
	 * 男子 30*2蛇形跑
	 * @param m
	 * @param age
	 */
	@ResponseBody
	@RequestMapping("/getManSxRun")
	public int getManSxRun(int age, int m) {
		int core = 0;
		if (age < 24) {
			if (m <= 212 && m >= 204) {
				int t = m - 204;
				int d = t * 5 % 8;
				if (d == 0) {
					core = 60 - (t * 5 / 8);
				} else {
					core = 60 - (t * 5 / 8 + 1);
				}
			} else if (m < 204 && m >= 201) {
				int t = m - 201;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 65 - (t * 5 / 3);
				} else {
					core = 65 - (t * 5 / 3 + 1);
				}
			} else if (m < 201 && m >= 195) {
				int t = m - 195;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 80 - (t * 5 / 2);
				} else {
					core = 80 - (t * 5 / 2 + 1);
				}
			} else if (m < 195 && m >= 192) {
				int t = m - 192;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 85 - (t * 5 / 3);
				} else {
					core = 85 - (t * 5 / 3 + 1);
				}
			} else if (m < 192 && m >= 190) {
				int t = m - 190;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 90 - (t * 5 / 2);
				} else {
					core = 90 - (t * 5 / 2 + 1);
				}
			} else if (m < 190 && m >= 187) {
				int t = m - 187;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 95 - (t * 5 / 3);
				} else {
					core = 95 - (t * 5 / 3 + 1);
				}
			} else if (m < 187 && m >= 181) {
				int t = m - 181;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 100 - (t * 5 / 6);
				} else {
					core = 100 - (t * 5 / 6 + 1);
				}
			}
		} else if (age >= 25 && age <= 27) {
			if (m <= 215 && m >= 208) {
				int t = m - 208;
				int d = t * 5 % 7;
				if (d == 0) {
					core = 60 - (t * 5 / 7);
				} else {
					core = 60 - (t * 5 / 7 + 1);
				}
			} else if (m < 208 && m >= 204) {
				int t = m - 204;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 65 - (t * 5 / 4);
				} else {
					core = 65 - (t * 5 / 4 + 1);
				}
			} else if (m < 204 && m >= 198) {
				int t = m - 198;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 80 - (t * 5 / 2);
				} else {
					core = 80 - (t * 5 / 2 + 1);
				}
			} else if (m < 198 && m >= 195) {
				int t = m - 195;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 85 - (t * 5 / 3);
				} else {
					core = 85 - (t * 5 / 3 + 1);
				}
			} else if (m < 195 && m >= 193) {
				int t = m - 193;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 90 - (t * 5 / 2);
				} else {
					core = 90 - (t * 5 / 2 + 1);
				}
			} else if (m < 193 && m >= 189) {
				int t = m - 189;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 95 - (t * 5 / 4);
				} else {
					core = 95 - (t * 5 / 4 + 1);
				}
			} else if (m < 189 && m >= 183) {
				int t = m - 183;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 100 - (t * 5 / 6);
				} else {
					core = 100 - (t * 5 / 6 + 1);
				}
			} else if (m < 183) {
				core = 100 + m - 183;
			}
		} else if (age >= 28 && age <= 30) {
			if (m <= 219 && m >= 211) {
				int t = m - 211;
				int d = t * 5 % 8;
				if (d == 0) {
					core = 60 - (t * 5 / 8);
				} else {
					core = 60 - (t * 5 / 8 + 1);
				}
			} else if (m < 211 && m >= 207) {
				int t = m - 207;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 65 - (t * 5 / 4);
				} else {
					core = 65 - (t * 5 / 4 + 1);
				}
			} else if (m < 207 && m >= 204) {
				int t = m - 204;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 70 - (t * 5 / 3);
				} else {
					core = 70 - (t * 5 / 3 + 1);
				}
			} else if (m < 204 && m >= 200) {
				int t = m - 200;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 80 - (t * 5 / 2);
				} else {
					core = 80 - (t * 5 / 2 + 1);
				}
			} else if (m < 200 && m >= 197) {
				int t = m - 197;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 85 - (t * 5 / 3);
				} else {
					core = 85 - (t * 5 / 3 + 1);
				}
			} else if (m < 197 && m >= 195) {
				int t = m - 195;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 90 - (t * 5 / 2);
				} else {
					core = 90 - (t * 5 / 2 + 1);
				}
			} else if (m < 195 && m >= 191) {
				int t = m - 191;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 95 - (t * 5 / 4);
				} else {
					core = 95 - (t * 5 / 4 + 1);
				}
			} else if (m < 191 && m >= 185) {
				int t = m - 185;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 100 - (t * 5 / 6);
				} else {
					core = 100 - (t * 5 / 6 + 1);
				}
			} else if (m < 185) {
				core = 100 + m - 185;
			}
		} else if (age >= 31 && age <= 33) {
			if (m <= 222 && m >= 213) {
				int t = m - 213;
				int d = t * 5 % 9;
				if (d == 0) {
					core = 60 - (t * 5 / 9);
				} else {
					core = 60 - (t * 5 / 9 + 1);
				}
			} else if (m < 213 && m >= 211) {
				int t = m - 211;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 65 - (t * 5 / 2);
				} else {
					core = 65 - (t * 5 / 2 + 1);
				}
			} else if (m < 211 && m >= 203) {
				int t = m - 203;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 75 - (t * 5 / 4);
				} else {
					core = 75 - (t * 5 / 4 + 1);
				}
			} else if (m < 203 && m >= 197) {
				int t = m - 197;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 90 - (t * 5 / 2);
				} else {
					core = 90 - (t * 5 / 2 + 1);
				}
			} else if (m < 197 && m >= 193) {
				int t = m - 193;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 95 - (t * 5 / 4);
				} else {
					core = 95 - (t * 5 / 4 + 1);
				}
			} else if (m < 193 && m >= 187) {
				int t = m - 187;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 100 - (t * 5 / 6);
				} else {
					core = 100 - (t * 5 / 6 + 1);
				}
			} else if (m < 187) {
				core = 100 + m - 187;
			}
		} else if (age >= 34 && age <= 36) {
			if (m <= 226 && m >= 217) {
				int t = m - 217;
				int d = t * 5 % 9;
				if (d == 0) {
					core = 60 - (t * 5 / 9);
				} else {
					core = 60 - (t * 5 / 9 + 1);
				}
			} else if (m < 217 && m >= 205) {
				int t = m - 205;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 75 - (t * 5 / 4);
				} else {
					core = 75 - (t * 5 / 4 + 1);
				}
			} else if (m < 205 && m >= 202) {
				int t = m - 202;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 80 - (t * 5 / 3);
				} else {
					core = 80 - (t * 5 / 3 + 1);
				}
			} else if (m < 202 && m >= 201) {
				int t = m - 201;
				int d = t * 5 % 1;
				if (d == 0) {
					core = 85 - (t * 5 / 1);
				} else {
					core = 85 - (t * 5 / 1 + 1);
				}
			} else if (m < 201 && m >= 199) {
				int t = m - 199;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 90 - (t * 5 / 2);
				} else {
					core = 90 - (t * 5 / 2 + 1);
				}
			} else if (m < 199 && m >= 195) {
				int t = m - 195;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 95 - (t * 5 / 4);
				} else {
					core = 95 - (t * 5 / 4 + 1);
				}
			} else if (m < 195 && m >= 189) {
				int t = m - 189;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 100 - (t * 5 / 6);
				} else {
					core = 100 - (t * 5 / 6 + 1);
				}
			} else if (m < 189) {
				core = 100 + m - 189;
			}
		} else if (age >= 37 && age <= 39) {
			if (m <= 227 && m >= 218) {
				int t = m - 218;
				int d = t * 5 % 9;
				if (d == 0) {
					core = 60 - (t * 5 / 9);
				} else {
					core = 60 - (t * 5 / 9 + 1);
				}
			} else if (m < 218 && m >= 214) {
				int t = m - 214;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 65 - (t * 5 / 4);
				} else {
					core = 65 - (t * 5 / 4 + 1);
				}
			} else if (m < 214 && m >= 202) {
				int t = m - 202;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 85 - (t * 5 / 3);
				} else {
					core = 85 - (t * 5 / 3 + 1);
				}
			} else if (m < 202 && m >= 201) {
				int t = m - 201;
				int d = t * 5 % 1;
				if (d == 0) {
					core = 90 - (t * 5 / 1);
				} else {
					core = 90 - (t * 5 / 1 + 1);
				}
			} else if (m < 201 && m >= 198) {
				int t = m - 198;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 95 - (t * 5 / 3);
				} else {
					core = 95 - (t * 5 / 3 + 1);
				}
			} else if (m < 198 && m >= 191) {
				int t = m - 191;
				int d = t * 5 % 7;
				if (d == 0) {
					core = 100 - (t * 5 / 7);
				} else {
					core = 100 - (t * 5 / 7 + 1);
				}
			} else if (m < 191) {
				core = 100 + m - 191;
			}
		} else if (age >= 40 && age <= 42) {
			if (m <= 229 && m >= 223) {
				int t = m - 223;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 60 - (t * 5 / 6);
				} else {
					core = 60 - (t * 5 / 6 + 1);
				}
			} else if (m < 223 && m >= 216) {
				int t = m - 216;
				int d = t * 5 % 7;
				if (d == 0) {
					core = 65 - (t * 5 / 7);
				} else {
					core = 65 - (t * 5 / 7 + 1);
				}
			} else if (m < 216 && m >= 212) {
				int t = m - 212;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 70 - (t * 5 / 4);
				} else {
					core = 70 - (t * 5 / 4 + 1);
				}
			} else if (m < 212 && m >= 210) {
				int t = m - 210;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 75 - (t * 5 / 2);
				} else {
					core = 75 - (t * 5 / 2 + 1);
				}
			} else if (m < 210 && m >= 206) {
				int t = m - 206;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 80 - (t * 5 / 4);
				} else {
					core = 80 - (t * 5 / 4 + 1);
				}
			} else if (m < 206 && m >= 200) {
				int t = m - 200;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 95 - (t * 5 / 2);
				} else {
					core = 95 - (t * 5 / 2 + 1);
				}
			} else if (m < 200 && m >= 193) {
				int t = m - 193;
				int d = t * 5 % 7;
				if (d == 0) {
					core = 100 - (t * 5 / 7);
				} else {
					core = 100 - (t * 5 / 7 + 1);
				}
			} else if (m < 193) {
				core = 100 + m - 193;
			}
		} else if (age >= 43 && age <= 45) {
			if (m <= 233 && m >= 224) {
				int t = m - 224;
				int d = t * 5 % 9;
				if (d == 0) {
					core = 60 - (t * 5 / 9);
				} else {
					core = 60 - (t * 5 / 9 + 1);
				}
			} else if (m < 224 && m >= 218) {
				int t = m - 218;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 65 - (t * 5 / 6);
				} else {
					core = 65 - (t * 5 / 6 + 1);
				}
			} else if (m < 218 && m >= 215) {
				int t = m - 215;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 70 - (t * 5 / 3);
				} else {
					core = 70 - (t * 5 / 3 + 1);
				}
			} else if (m < 215 && m >= 213) {
				int t = m - 213;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 75 - (t * 5 / 2);
				} else {
					core = 75 - (t * 5 / 2 + 1);
				}
			} else if (m < 213 && m >= 207) {
				int t = m - 207;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 80 - (t * 5 / 6);
				} else {
					core = 80 - (t * 5 / 6 + 1);
				}
			} else if (m < 207 && m >= 206) {
				core = 85;
			} else if (m < 206 && m >= 202) {
				int t = m - 202;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 95 - (t * 5 / 2);
				} else {
					core = 95 - (t * 5 / 2 + 1);
				}
			} else if (m < 202 && m >= 195) {
				int t = m - 195;
				int d = t * 5 % 7;
				if (d == 0) {
					core = 100 - (t * 5 / 7);
				} else {
					core = 100 - (t * 5 / 7 + 1);
				}
			} else if (m < 195) {
				core = 100 + m - 195;
			}
		} else if (age >= 46 && age <= 48) {
			if (m <= 239 && m >= 226) {
				int t = m - 226;
				int d = t * 5 % 13;
				if (d == 0) {
					core = 60 - (t * 5 / 13);
				} else {
					core = 60 - (t * 5 / 13 + 1);
				}
			} else if (m < 226 && m >= 220) {
				int t = m - 220;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 65 - (t * 5 / 6);
				} else {
					core = 65 - (t * 5 / 6 + 1);
				}
			} else if (m < 220 && m >= 217) {
				int t = m - 217;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 70 - (t * 5 / 3);
				} else {
					core = 70 - (t * 5 / 3 + 1);
				}
			} else if (m < 217 && m >= 215) {
				int t = m - 215;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 75 - (t * 5 / 2);
				} else {
					core = 75 - (t * 5 / 2 + 1);
				}
			} else if (m < 215 && m >= 209) {
				int t = m - 209;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 80 - (t * 5 / 6);
				} else {
					core = 80 - (t * 5 / 6 + 1);
				}
			} else if (m < 209 && m >= 208) {
				core = 85;
			} else if (m < 208 && m >= 204) {
				int t = m - 204;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 95 - (t * 5 / 2);
				} else {
					core = 95 - (t * 5 / 2 + 1);
				}
			} else if (m < 204 && m >= 197) {
				int t = m - 197;
				int d = t * 5 % 7;
				if (d == 0) {
					core = 100 - (t * 5 / 7);
				} else {
					core = 100 - (t * 5 / 7 + 1);
				}
			} else if (m < 197) {
				core = 100 + m - 197;
			}
		} else if (age >= 49 && age <= 51) {
			if (m <= 240 && m >= 228) {
				int t = m - 228;
				int d = t * 5 % 12;
				if (d == 0) {
					core = 60 - (t * 5 / 12);
				} else {
					core = 60 - (t * 5 / 12 + 1);
				}
			} else if (m < 228 && m >= 224) {
				int t = m - 224;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 65 - (t * 5 / 4);
				} else {
					core = 65 - (t * 5 / 4 + 1);
				}
			} else if (m < 224 && m >= 218) {
				int t = m - 218;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 70 - (t * 5 / 6);
				} else {
					core = 70 - (t * 5 / 6 + 1);
				}
			} else if (m < 218 && m >= 217) {
				core = 75;
			} else if (m < 217 && m >= 213) {
				int t = m - 213;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 80 - (t * 5 / 4);
				} else {
					core = 80 - (t * 5 / 4 + 1);
				}
			} else if (m < 213 && m >= 207) {
				int t = m - 207;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 95 - (t * 5 / 2);
				} else {
					core = 95 - (t * 5 / 2 + 1);
				}
			} else if (m < 207 && m >= 199) {
				int t = m - 199;
				int d = t * 5 % 8;
				if (d == 0) {
					core = 100 - (t * 5 / 8);
				} else {
					core = 100 - (t * 5 / 8 + 1);
				}
			} else if (m < 199) {
				core = 100 + m - 199;
			}
		} else if (age >= 52 && age <= 54) {
			if (m <= 245 && m >= 234) {
				int t = m - 234;
				int d = t * 5 % 11;
				if (d == 0) {
					core = 60 - (t * 5 / 11);
				} else {
					core = 60 - (t * 5 / 11 + 1);
				}
			} else if (m < 234 && m >= 222) {
				int t = m - 222;
				int d = t * 5 % 6;
				if (d == 0) {
					core = 70 - (t * 5 / 6);
				} else {
					core = 70 - (t * 5 / 6 + 1);
				}
			} else if (m < 222 && m >= 220) {
				int t = m - 220;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 75 - (t * 5 / 2);
				} else {
					core = 75 - (t * 5 / 2 + 1);
				}
			} else if (m < 220 && m >= 217) {
				int t = m - 217;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 80 - (t * 5 / 3);
				} else {
					core = 80 - (t * 5 / 3 + 1);
				}
			} else if (m < 217 && m >= 211) {
				int t = m - 211;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 90 - (t * 5 / 3);
				} else {
					core = 90 - (t * 5 / 3 + 1);
				}
			} else if (m < 211 && m >= 209) {
				int t = m - 209;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 95 - (t * 5 / 2);
				} else {
					core = 95 - (t * 5 / 2 + 1);
				}
			} else if (m < 209 && m >= 206) {
				int t = m - 206;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 100 - (t * 5 / 3);
				} else {
					core = 100 - (t * 5 / 3 + 1);
				}
			} else if (m < 206) {
				core = 100 + m - 206;
			}
		} else if (age >= 55 && age <= 57) {
			if (m <= 248 && m >= 238) {
				int t = m - 238;
				int d = t * 5 % 10;
				if (d == 0) {
					core = 60 - (t * 5 / 10);
				} else {
					core = 60 - (t * 5 / 10 + 1);
				}
			} else if (m < 238 && m >= 235) {
				int t = m - 235;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 65 - (t * 5 / 3);
				} else {
					core = 65 - (t * 5 / 3 + 1);
				}
			} else if (m < 235 && m >= 233) {
				int t = m - 233;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 70 - (t * 5 / 2);
				} else {
					core = 70 - (t * 5 / 2 + 1);
				}
			} else if (m < 233 && m >= 225) {
				int t = m - 225;
				int d = t * 5 % 8;
				if (d == 0) {
					core = 75 - (t * 5 / 8);
				} else {
					core = 75 - (t * 5 / 8 + 1);
				}
			} else if (m < 225 && m >= 222) {
				int t = m - 222;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 80 - (t * 5 / 3);
				} else {
					core = 80 - (t * 5 / 3 + 1);
				}
			} else if (m < 222 && m >= 220) {
				int t = m - 220;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 85 - (t * 5 / 2);
				} else {
					core = 85 - (t * 5 / 2 + 1);
				}
			} else if (m < 220 && m >= 215) {
				int t = m - 215;
				int d = t * 5 % 5;
				if (d == 0) {
					core = 90 - (t * 5 / 5);
				} else {
					core = 90 - (t * 5 / 5 + 1);
				}
			} else if (m < 215 && m >= 211) {
				int t = m - 211;
				int d = t * 5 % 2;
				if (d == 0) {
					core = 100 - (t * 5 / 2);
				} else {
					core = 100 - (t * 5 / 2 + 1);
				}
			} else if (m < 211) {
				core = 100 + m - 211;
			}
		} else if (age >= 58 && age <= 60) {
			if (m <= 254 && m >= 245) {
				int t = m - 245;
				int d = t * 5 % 9;
				if (d == 0) {
					core = 60 - (t * 5 / 9);
				} else {
					core = 60 - (t * 5 / 9 + 1);
				}
			} else if (m < 245 && m >= 240) {
				int t = m - 240;
				int d = t * 5 % 5;
				if (d == 0) {
					core = 65 - (t * 5 / 5);
				} else {
					core = 65 - (t * 5 / 5 + 1);
				}
			} else if (m < 240 && m >= 237) {
				int t = m - 237;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 70 - (t * 5 / 3);
				} else {
					core = 70 - (t * 5 / 3 + 1);
				}
			} else if (m < 237 && m >= 230) {
				int t = m - 230;
				int d = t * 5 % 7;
				if (d == 0) {
					core = 75 - (t * 5 / 7);
				} else {
					core = 75 - (t * 5 / 7 + 1);
				}
			} else if (m < 230 && m >= 227) {
				int t = m - 227;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 80 - (t * 5 / 3);
				} else {
					core = 80 - (t * 5 / 3 + 1);
				}
			} else if (m < 227 && m >= 223) {
				int t = m - 223;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 85 - (t * 5 / 4);
				} else {
					core = 85 - (t * 5 / 4 + 1);
				}
			} else if (m < 223 && m >= 217) {
				int t = m - 217;
				int d = t * 5 % 3;
				if (d == 0) {
					core = 95 - (t * 5 / 3);
				} else {
					core = 95 - (t * 5 / 3 + 1);
				}
			} else if (m < 217 && m >= 213) {
				int t = m - 213;
				int d = t * 5 % 4;
				if (d == 0) {
					core = 100 - (t * 5 / 4);
				} else {
					core = 100 - (t * 5 / 4 + 1);
				}
			} else if (m < 213) {
				core = 100 + m - 213;
			}
		}
		return core;
	}

	/**
	 * 男子3000米跑
	 */

	@ResponseBody
	@RequestMapping("/getManRunCore")
	public int  getManRunCore(int age, int meter) {
		int c = 0;
		int s = 0;
		if (age < 24) {
			if (meter <= 1340 && meter >= 1330) {
				int t = meter - 1330;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1330 && meter >= 1310) {
				int t = meter - 1310;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1310 && meter >= 1255) {
				int t = meter - 40 - 1255;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1255 && meter >= 1210) {
				int t = meter - 1210;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			} else if (meter < 1210 && meter >= 1155) {
				int t = meter - 40 - 1155;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1155 && meter >= 1130) {
				int t = meter - 1130;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1130) {
				c = (1130 - meter) / 5 + 100;
			}
		} else if (age >= 25 && age <= 27) {
			if (meter <= 1352 && meter >= 1342) {
				int t = meter - 1342;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1342 && meter >= 1322) {
				int t = meter - 1322;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1322 && meter >= 1307) {
				int t = meter - 1307;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1307 && meter >= 1252) {
				int t = meter - 40 - 1252;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 80 - s;
			} else if (meter < 1252 && meter >= 1207) {
				int t = meter - 1207;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1207 && meter >= 1142) {
				int t = meter -40 - 1142;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1142) {
				c = (1142 - meter) / 5 + 100;
			}
		} else if (age >= 28 && age <= 30) {
			if (meter <= 1428 && meter >= 1418) {
				int t = meter - 1418;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1418 && meter >= 1358) {
				int t = meter - 40 - 1358;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1358 && meter >= 1313) {
				int t = meter - 1313;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 85 - s;
			} else if (meter < 1313 && meter >= 1258) {
				int t = meter -40 - 1258;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			} else if (meter < 1258 && meter >= 1243) {
				int t = meter - 1243;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1243 && meter >= 1218) {
				int t = meter - 1218;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1218) {
				c = (1218 - meter) / 5 + 100;
			}
		} else if (age >= 31 && age <= 33) {
			if (meter <= 1500 && meter >= 1455) {
				int t = meter -40 - 1455;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1455 && meter >= 1444) {
				int t = meter - 1444;
				int d = t * 5 % 11;
				if (d == 0) {
					s = t * 5 / 11;
				} else {
					s = t * 5 / 11 + 1;
				}
				c = 65 - s;
			} else if (meter < 1444 && meter >= 1434) {
				int t = meter - 1434;
				int d = t * 5 % 10;
				if (d == 0) {
					s = t * 5 / 10;
				} else {
					s = t * 5 / 10 + 1;
				}
				c = 75 - s;
			} else if (meter < 1434 && meter >= 1404) {
				int t = meter - 1404;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 80 - s;
			} else if (meter < 1404 && meter >= 1349) {
				int t = meter -40 - 1349;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 85 - s;
			} else if (meter < 1349 && meter >= 1319) {
				int t = meter - 1319;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1319 && meter >= 1254) {
				int t = meter -40 - 1254;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1254) {
				c = (1254 - meter) / 5 + 100;
			}
		} else if (age >= 34 && age <= 36) {
			if (meter <= 1540 && meter >= 1530) {
				int t = meter - 1530;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1530 && meter >= 1510) {
				int t = meter - 1510;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1510 && meter >= 1455) {
				int t = meter -40 - 1455;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1455 && meter >= 1410) {
				int t = meter - 1410;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			} else if (meter < 1410 && meter >= 1355) {
				int t = meter -40 - 1355;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1355 && meter >= 1330) {
				int t = meter - 1330;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 100 - s;
			} else if (meter < 1330) {
				c = (1330 - meter) / 5 + 100;
			}
		} else if (age >= 37 && age <= 39) {
			if (meter <= 1600 && meter >= 1555) {
				int t = meter - 40 - 1555;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 60 - s;
			} else if (meter < 1555 && meter >= 1545) {
				int t = meter - 1545;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 70 - s;
			} else if (meter < 1545 && meter >= 1531) {
				int t = meter - 1531;
				int d = t * 5 % 14;
				if (d == 0) {
					s = t * 5 / 14;
				} else {
					s = t * 5 / 14 + 1;
				}
				c = 75 - s;
			} else if (meter < 1531 && meter >= 1501) {
				int t = meter - 1501;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 85 - s;
			} else if (meter < 1501 && meter >= 1446) {
				int t = meter - 40 - 1446;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			} else if (meter < 1446 && meter >= 1431) {
				int t = meter - 1431;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1431 && meter >= 1406) {
				int t = meter - 1406;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1406) {
				c = (1406 - meter) / 5 + 100;
			}
		} else if (age >= 40 && age <= 42) {
			if (meter <= 1658 && meter >= 1648) {
				int t = meter - 1648;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1648 && meter >= 1628) {
				int t = meter - 1628;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1628 && meter >= 1613) {
				int t = meter - 1613;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1613 && meter >= 1558) {
				int t = meter - 40 - 1558;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 80 - s;
			} else if (meter < 1558 && meter >= 1513) {
				int t = meter - 1513;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1513 && meter >= 1448) {
				int t = meter - 40 - 1448;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1448) {
				c = (1448 - meter) / 5 + 100;
			}
		} else if (age >= 43 && age <= 45) {
			if (meter <= 1740 && meter >= 1730) {
				int t = meter - 1730;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1730 && meter >= 1710) {
				int t = meter - 1710;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1710 && meter >= 1655) {
				int t = meter - 40 - 1655;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1655 && meter >= 1610) {
				int t = meter - 1610;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			} else if (meter < 1610 && meter >= 1555) {
				int t = meter - 40 - 1555;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1555 && meter >= 1530) {
				int t = meter - 1530;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 100 - s;
			} else if (meter < 1530) {
				c = (1530 - meter) / 5 + 100;
			}
		} else if (age >= 46 && age <= 48) {
			if (meter <= 1822 && meter >= 1812) {
				int t = meter - 1812;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1812 && meter >= 1752) {
				int t = meter - 40 - 1752;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1752 && meter >= 1707) {
				int t = meter - 1707;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 85 - s;
			} else if (meter < 1707 && meter >= 1652) {
				int t = meter - 40 - 1652;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			} else if (meter < 1652 && meter >= 1637) {
				int t = meter - 1637;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1637 && meter >= 1612) {
				int t = meter - 1612;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1612) {
				c = (1612 - meter) / 5 + 100;
			}
		} else if (age >= 49 && age <= 51) {
			if (meter <= 1904 && meter >= 1859) {
				int t = meter - 40 - 1859;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 60 - s;
			} else if (meter < 1859 && meter >= 1854) {
				int t = meter - 1854;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1854 && meter >= 1834) {
				int t = meter - 1834;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1834 && meter >= 1819) {
				int t = meter - 1819;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1819 && meter >= 1808) {
				int t = meter - 1808;
				int d = t * 5 % 11;
				if (d == 0) {
					s = t * 5 / 11;
				} else {
					s = t * 5 / 11 + 1;
				}
				c = 80 - s;
			} else if (meter < 1808 && meter >= 1749) {
				int t = meter -40 - 1749;
				int d = t * 5 % 19;
				if (d == 0) {
					s = t * 5 / 19;
				} else {
					s = t * 5 / 19 + 1;
				}
				c = 85 - s;
			} else if (meter < 1749 && meter >= 1719) {
				int t = meter - 1719;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1719 && meter >= 1654) {
				int t = meter - 40 - 1654;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1654) {
				c = (1654 - meter) / 5 + 100;
			}
		} else if (age >= 52 && age <= 54) {
			if (meter <= 1946 && meter >= 1936) {
				int t = meter - 1936;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 1936 && meter >= 1916) {
				int t = meter - 1916;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1916 && meter >= 1901) {
				int t = meter - 1901;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1901 && meter >= 1850) {
				int t = meter - 40 - 1850;
				int d = t * 5 % 11;
				if (d == 0) {
					s = t * 5 / 11;
				} else {
					s = t * 5 / 11 + 1;
				}
				c = 80 - s;
			} else if (meter < 1850 && meter >= 1831) {
				int t = meter - 1831;
				int d = t * 5 % 19;
				if (d == 0) {
					s = t * 5 / 19;
				} else {
					s = t * 5 / 19 + 1;
				}
				c = 85 - s;
			} else if (meter < 1831 && meter >= 1801) {
				int t = meter - 1801;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1801 && meter >= 1736) {
				int t = meter - 40 - 1736;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1736) {
				c = (1736 - meter) / 5 + 100;
			}
		} else if (age >= 55 && age <= 57) {
			if (meter <= 2028 && meter >= 2018) {
				int t = meter - 2018;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 2018 && meter >= 1958) {
				int t = meter - 40 - 1916;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			} else if (meter < 1958 && meter >= 1943) {
				int t = meter - 1943;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 1943 && meter >= 1932) {
				int t = meter - 1932;
				int d = t * 5 % 11;
				if (d == 0) {
					s = t * 5 / 11;
				} else {
					s = t * 5 / 11 + 1;
				}
				c = 80 - s;
			} else if (meter < 1932 && meter >= 1913) {
				int t = meter - 1913;
				int d = t * 5 % 19;
				if (d == 0) {
					s = t * 5 / 19;
				} else {
					s = t * 5 / 19 + 1;
				}
				c = 85 - s;
			} else if (meter < 1913 && meter >= 1858) {
				int t = meter - 40 - 1858;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			} else if (meter < 1858 && meter >= 1843) {
				int t = meter - 1843;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1843 && meter >= 1818) {
				int t = meter - 1818;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1818) {
				c = (1818 - meter) / 5 + 100;
			}
		} else if (age >= 58 && age <= 60) {
			if (meter <= 2110 && meter >= 2100) {
				int t = meter - 2100;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			} else if (meter < 2100 && meter >= 2040) {
				int t = meter - 2040;
				int d = t * 5 % 60;
				if (d == 0) {
					s = t * 5 / 60;
				} else {
					s = t * 5 / 60 + 1;
				}
				c = 70 - s;
			} else if (meter < 2040 && meter >= 2025) {
				int t = meter - 2025;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 75 - s;
			} else if (meter < 2025 && meter >= 2014) {
				int t = meter - 2014;
				int d = t * 5 % 11;
				if (d == 0) {
					s = t * 5 / 11;
				} else {
					s = t * 5 / 11 + 1;
				}
				c = 80 - s;
			} else if (meter < 2014 && meter >= 1955) {
				int t = meter - 40 - 1955;
				int d = t * 5 % 19;
				if (d == 0) {
					s = t * 5 / 19;
				} else {
					s = t * 5 / 19 + 1;
				}
				c = 85 - s;
			} else if (meter < 1955 && meter >= 1925) {
				int t = meter - 1925;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			} else if (meter < 1925 && meter >= 1900) {
				int t = meter - 1900;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			} else if (meter < 1900) {
				c = (1900 - meter) / 5 + 100;
			}
		}

		return c;
	}

	/**
	 * 女子单杠曲臂悬垂
	 * age 年龄
	 * m 秒数
	 */

	@ResponseBody
	@RequestMapping("/getWoMenDgqbCore")
	public int getWoMenDgqbCore(int age,int m){
		int c = 0;
		int s = 0;
		if(age < 24){
			if(m >= 30 && m <= 36){
				int t = 36 - m;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m > 36 && m <=42){
				int t = 42 - m;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 65 - s;
			}else if(m > 42 && m <=70){
				int t = 70 - m;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m > 70){
				c = (m-70)/5 + 100;
			}
		}else if(age >=25 && age <=27){
			if(m >= 29 && m <= 35){
				int t = 35 - m;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 60 - s;
			}else if(m > 35 && m <=59){
				int t = 59 - m;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 90 - s;
			}else if(m > 59 && m <=65){
				int t = 65 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 65){
				c = (m-65)/5 + 100;
			}
		}else if(age >=28 && age <=30){
			if(m >= 27 && m <= 33){
				int t = 33 - m;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 60 - s;
			}else if(m > 33 && m <=57){
				int t = 57 - m;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 90 - s;
			}else if(m > 57 && m <=63){
				int t = 63 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 63){
				c = (m-63)/5 + 100;
			}
		}else if(age >=31 && age <=33){
			if(m >= 24 && m <= 30){
				int t = 30 - m;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 60 - s;
			}else if(m > 30 && m <=54){
				int t = 54 - m;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 90 - s;
			}else if(m > 54 && m <=60){
				int t = 60 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 60){
				c = (m-60)/5 + 100;
			}
		}else if(age >=34 && age <=36){
			if(m >= 21 && m <= 27){
				int t = 27 - m;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 60 - s;
			}else if(m > 27 && m <=51){
				int t = 51 - m;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 90 - s;
			}else if(m > 51 && m <=57){
				int t = 57 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 57){
				c = (m-57)/5 + 100;
			}
		}else if(age >=37 && age <=39){
			if(m >= 18 && m <= 24){
				int t = 24 - m;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 60 - s;
			}else if(m > 24 && m <=48){
				int t = 48 - m;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 90 - s;
			}else if(m > 48 && m <=54){
				int t = 54 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 54){
				c = (m-54)/5 + 100;
			}
		}else if(age >=40 && age <=42){
			if(m >= 13 && m <= 17){
				int t = 17 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m > 17 && m <=21){
				int t = 21 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 85 - s;
			}else if(m > 21 && m <=30){
				int t = 30 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 30){
				c = (m-30)/2 + 100;
			}
		}else if(age >=43 && age <=45){
			if(m >= 11 && m <= 13){
				int t = 13 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(m > 13 && m <=15){
				int t = 15 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m > 15 && m <=17){
				int t = 17 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 80 - s;
			}else if(m > 17 && m <=21){
				int t = 21 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m > 21 && m <=27){
				int t = 27 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 27){
				c = (m-27)/2 + 100;
			}
		}else if(age >=46 && age <=48){
			if(m >= 11 && m <= 17){
				int t = 17 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 85 - s;
			}else if(m > 17 && m <=21){
				int t = 21 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 95 - s;
			}else if(m > 21 && m <=24){
				int t = 24 - m;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(m > 24){
				c = (m-24)/2 + 100;
			}
		}else if(age >=49 && age <=51){
			if(m >= 9 && m <= 12){
				int t = 12 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 70 - s;
			}else if(m > 12 && m <=14){
				int t = 14 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 75 - s;
			}else if(m > 14 && m <=17){
				int t = 17 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 90 - s;
			}else if(m > 17 && m <=21){
				int t = 21 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 100 - s;
			}else if(m > 21){
				c = (m-21)/2 + 100;
			}
		}else if(age >=52 && age <=54){
			if(m >= 8 && m <= 12){
				int t = 12 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m > 12 && m <=14){
				int t = 14 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 80 - s;
			}else if(m > 14 && m <=17){
				int t = 17 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 95 - s;
			}else if(m > 17 && m <=19){
				int t = 19 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 100 - s;
			}else if(m > 19){
				c = (m-19)/2 + 100;
			}
		}else if(age >=55 && age <=57){
			if(m >= 7 && m <= 12){
				int t = 12 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 80 - s;
			}else if(m > 12 && m <=14){
				int t = 14 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 85 - s;
			}else if(m > 14 && m <=17){
				int t = 17 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 100 - s;
			}else if(m > 17){
				c = (m-17)/2 + 100;
			}
		}else if(age >=58 && age <=60){
			if(m >= 3 && m <= 5){
				int t = 5 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(m > 5 && m <=7){
				int t = 7 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m > 7 && m <=10){
				int t = 10 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m > 10 && m <=12){
				int t = 12 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 85 - s;
			}else if(m > 12 && m <=14){
				int t = 14 - m;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m > 14 && m <=16){
				int t = 16 - m;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 100 - s;
			}else if(m > 16){
				c = (m-16)/2 + 100;
			}
		}

		return c;
	}

	/**
	 * 女子仰卧起坐
	 */
	@ResponseBody
	@RequestMapping("/getWomenCore")
	public int  getWomenCore(int age,int num){
		int c = 0;
		int s = 0;
		if(age < 24){
			if(num >=41 && num <= 43){
				int t = 43 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num >43 && num <= 53){
				int t = 53 - num;
				int d = t * 5 % 10;
				if (d == 0) {
					s = t * 5 / 10;
				} else {
					s = t * 5 / 10 + 1;
				}
				c = 70 - s;
			}else if(num >53 && num <= 71){
				int t = 71 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 100 - s;
			}else if(num >71){
				c = (num - 71)/2 + 100;
			}
		}else if(age >= 25 && age <=27){
			if(num >=38 && num <= 40){
				int t = 40 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num >40 && num <= 48){
				int t = 48 - num;
				int d = t * 5 % 8;
				if (d == 0) {
					s = t * 5 / 8;
				} else {
					s = t * 5 / 8 + 1;
				}
				c = 70 - s;
			}else if(num >48 && num <= 57){
				int t = 57 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 85 - s;
			}else if(num > 57 && num <= 69){
				int t = 69 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(num > 69){
				c= (num - 69)/2 + num;
			}
		}else if(age >= 28 && age <=30){
			if(num >=36 && num <= 38){
				int t = 38 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 38 && num <= 47){
				int t = 47 - num;
				int d = t * 5 % 9;
				if (d == 0) {
					s = t * 5 / 9;
				} else {
					s = t * 5 / 9 + 1;
				}
				c = 70 - s;
			}else if(num > 47 && num <= 59){
				int t = 59 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 90 - s;
			}else if(num > 59 && num <= 67){
				int t = 67 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(num > 67){
				c= (num - 67)/2 + num;
			}
		}else if(age >= 31 && age <=33){
			if(num >=34 && num <= 36){
				int t = 36 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 36 && num <= 43){
				int t = 43 - num;
				int d = t * 5 % 7;
				if (d == 0) {
					s = t * 5 / 7;
				} else {
					s = t * 5 / 7 + 1;
				}
				c = 70 - s;
			}else if(num > 43 && num <= 46){
				int t = 46 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 75 - s;
			}else if(num > 46 && num <= 66){
				int t = 66 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(num > 66){
				c= (num - 66)/2 + num;
			}
		}else if(age >= 34 && age <=36){
			if(num >=32 && num <= 34){
				int t = 34 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 34 && num <= 40){
				int t = 40 - num;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 70 - s;
			}else if(num > 40 && num <= 64){
				int t = 64 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(num > 64){
				c= (num - 64)/2 + num;
			}
		}else if(age >= 37 && age <=39){
			if(num >=29 && num <= 31){
				int t = 31 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 60 - s;
			}else if(num > 31 && num <= 32){
				int t = 32 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 32 && num <= 38){
				int t = 38 - num;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 70 - s;
			}else if(num > 38 && num <= 58){
				int t = 58 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 95 - s;
			}else if(num > 58 && num <= 63){
				int t = 63 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			}else if(num > 63){
				c= (num - 63)/2 + num;
			}
		}else if(age >= 40 && age <=42){
			if(num >=27 && num <= 29){
				int t = 29 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 60 - s;
			}else if(num > 29 && num <= 30){
				int t = 30 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 30 && num <= 35){
				int t = 35 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 70 - s;
			}else if(num > 35 && num <= 47){
				int t = 47 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 85 - s;
			}else if(num > 47 && num <= 62){
				int t = 62 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			}else if(num > 62){
				c= (num - 62)/2 + num;
			}
		}else if(age >= 43 && age <=45){
			if(num >=24 && num <= 27){
				int t = 27 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 60 - s;
			}else if(num > 27 && num <= 28){
				int t = 28 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 28 && num <= 36){
				int t = 36 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 75 - s;
			}else if(num > 36 && num <= 61){
				int t = 61 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			}else if(num > 61){
				c= (num - 61)/2 + num;
			}
		}else if(age >= 46 && age <=48){
			if(num >=22 && num <= 25){
				int t = 25 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 60 - s;
			}else if(num > 25 && num <= 26){
				int t = 26 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 26 && num <= 30){
				int t = 30 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 70 - s;
			}else if(num > 30 && num <= 60){
				int t = 60 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 100 - s;
			}else if(num > 60){
				c= (num - 60)/2 + num;
			}
		}else if(age >= 49 && age <=51){
			if(num >=19 && num <= 23){
				int t = 23 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(num > 23 && num <= 24){
				int t = 24 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 24 && num <= 28){
				int t = 28 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 70 - s;
			}else if(num > 28 && num <= 33){
				int t = 33 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 75 - s;
			}else if(num > 33 && num <= 37){
				int t = 37 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 80 - s;
			}else if(num > 37 && num <= 47){
				int t = 47 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 90 - s;
			}else if(num > 47 && num <= 59){
				int t = 59 - num;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 100 - s;
			}else if(num > 59){
				c= (num - 59)/2 + num;
			}
		}else if(age >= 52 && age <=54){
			if(num >=17 && num <= 21){
				int t = 21 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(num > 21 && num <= 22){
				int t = 22 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 22 && num <= 25){
				int t = 25 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 70 - s;
			}else if(num > 25 && num <= 29){
				int t = 29 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 75 - s;
			}else if(num > 29 && num <= 39){
				int t = 39 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 85 - s;
			}else if(num > 39 && num <= 57){
				int t = 57 - num;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 100 - s;
			}else if(num > 57){
				c= (num - 57)/2 + num;
			}
		}else if(age >= 55 && age <=57){
			if(num >=15 && num <= 19){
				int t = 19 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(num > 19 && num <= 20){
				int t = 20 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 20 && num <= 26){
				int t = 26 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 75 - s;
			}else if(num > 26 && num <= 56){
				int t = 56 - num;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 100 - s;
			}else if(num > 56){
				c= (num - 56)/2 + num;
			}
		}else if(age >= 58 && age <=60){
			if(num >=13 && num <= 17){
				int t = 17 - num;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(num > 17 && num <= 18){
				int t = 18 - num;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 65 - s;
			}else if(num > 18 && num <= 20){
				int t = 20 - num;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(num > 20 && num <= 23){
				int t = 23 - num;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 75 - s;
			}else if(num > 23 && num <= 30){
				int t = 30 - num;
				int d = t * 5 % 7;
				if (d == 0) {
					s = t * 5 / 7;
				} else {
					s = t * 5 / 7 + 1;
				}
				c = 80 - s;
			}else if(num > 30 && num <= 35){
				int t = 35 - num;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 85 - s;
			}else if(num > 35 && num <= 42){
				int t = 42 - num;
				int d = t * 5 % 7;
				if (d == 0) {
					s = t * 5 / 7;
				} else {
					s = t * 5 / 7 + 1;
				}
				c = 90 - s;
			}else if(num > 42 && num <= 48){
				int t = 48 - num;
				int d = t * 5 % 6;
				if (d == 0) {
					s = t * 5 / 6;
				} else {
					s = t * 5 / 6 + 1;
				}
				c = 95 - s;
			}else if(num > 48 && num <= 55){
				int t = 55 - num;
				int d = t * 5 % 7;
				if (d == 0) {
					s = t * 5 / 7;
				} else {
					s = t * 5 / 7 + 1;
				}
				c = 100 - s;
			}else if(num > 55){
				c= (num - 55)/2 + num;
			}
		}

		return c;
	}

	/**
	 * 女子蛇形跑
	 */
	@ResponseBody
	@RequestMapping("/getWomenRun")
	public int getWomenRun(int age,int m){
		int c = 0;
		int s = 0;
		if(age < 24){
			if(m <= 226 && m >= 222){
				int t = m - 222;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 222 && m >= 219){
				int t = m - 219;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 219 && m >= 217){
				int t = m - 217;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 217 && m >= 216){
				int t = m - 216;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 216 && m >= 213){
				int t = m - 213;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 213 && m >= 209){
				int t = m - 209;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 209 && m >= 204){
				int t = m - 204;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 95 - s;
			}else if(m < 204 && m >= 200){
				int t = m - 200;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 200){
				c = (200 - m)+100;
			}
		}else if(age >=25 && age <=27){
			if(m <=229 && m >= 225){
				int t = m - 225;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 225 && m >= 222){
				int t = m - 222;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 222 && m >= 220){
				int t = m - 220;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 220 && m >= 219){
				int t = m - 219;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 219 && m >= 216){
				int t = m - 216;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 216 && m >= 212){
				int t = m - 212;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 212 && m >= 207){
				int t = m - 207;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 207 && m >= 203){
				int t = m - 203;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 203){
				c = (203-m)+100;
			}
		}else if(age >=28 && age <=30){
			if(m <=232 && m >= 228){
				int t = m - 228;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 228 && m >= 225){
				int t = m - 225;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 225 && m >= 223){
				int t = m - 223;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 223 && m >= 222){
				int t = m - 222;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 222 && m >= 219){
				int t = m - 219;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 219 && m >= 215){
				int t = m - 215;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 215 && m >= 210){
				int t = m - 210;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 210 && m >= 206){
				int t = m - 206;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 206){
				c = (206-m)+100;
			}
		}else if(age >=31 && age <=33){
			if(m <=235 && m >= 231){
				int t = m - 231;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 231 && m >= 228){
				int t = m - 228;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 228 && m >= 226){
				int t = m - 226;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 226 && m >= 225){
				int t = m - 225;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 225 && m >= 222){
				int t = m - 222;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 222 && m >= 218){
				int t = m - 218;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 218 && m >= 213){
				int t = m - 213;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 213 && m >= 209){
				int t = m - 209;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 209){
				c = (209-m)+100;
			}
		}else if(age >=34 && age <=36){
			if(m <=238 && m >= 234){
				int t = m - 234;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 234 && m >= 231){
				int t = m - 231;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 231 && m >= 229){
				int t = m - 229;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 229 && m >= 228){
				int t = m - 228;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 228 && m >= 225){
				int t = m - 225;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 225 && m >= 221){
				int t = m - 221;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 221 && m >= 216){
				int t = m - 216;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 216 && m >= 212){
				int t = m - 212;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 212){
				c = (212-m)+100;
			}
		}else if(age >=37 && age <=39){
			if(m <=241 && m >= 237){
				int t = m - 237;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 237 && m >= 234){
				int t = m - 234;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 234 && m >= 232){
				int t = m - 232;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 232 && m >= 231){
				int t = m - 231;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 231 && m >= 228){
				int t = m - 228;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 228 && m >= 224){
				int t = m - 224;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 224 && m >= 219){
				int t = m - 219;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 219 && m >= 215){
				int t = m - 215;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 215){
				c = (215-m)+100;
			}
		}else if(age >=40 && age <=42){
			if(m <=244 && m >= 240){
				int t = m - 240;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 240 && m >= 237){
				int t = m - 237;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 237 && m >= 235){
				int t = m - 235;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 235 && m >= 234){
				int t = m - 234;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 234 && m >= 231){
				int t = m - 231;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 231 && m >= 227){
				int t = m - 227;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 227 && m >= 222){
				int t = m - 222;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 222 && m >= 218){
				int t = m - 218;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 218){
				c = (218-m)+100;
			}
		}else if(age >=43 && age <=45){
			if(m <=247 && m >= 243){
				int t = m - 243;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 243 && m >= 240){
				int t = m - 240;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 240 && m >= 238){
				int t = m - 238;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 238 && m >= 237){
				int t = m - 237;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 237 && m >= 234){
				int t = m - 234;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 234 && m >= 230){
				int t = m - 230;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 230 && m >= 225){
				int t = m - 225;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 225 && m >= 221){
				int t = m - 221;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 221){
				c = (221-m)+100;
			}
		}else if(age >=46 && age <=48){
			if(m <=250 && m >= 246){
				int t = m - 246;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 246 && m >= 243){
				int t = m - 243;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 243 && m >= 241){
				int t = m - 241;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 241 && m >= 240){
				int t = m - 240;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 240 && m >= 237){
				int t = m - 237;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 237 && m >= 233){
				int t = m - 233;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 233 && m >= 228){
				int t = m - 228;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 228 && m >= 224){
				int t = m - 224;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 224){
				c = (224-m)+100;
			}
		}else if(age >=49 && age <=51){
			if(m <=253 && m >= 249){
				int t = m - 249;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 249 && m >= 246){
				int t = m - 246;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 246 && m >= 244){
				int t = m - 244;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 244 && m >= 243){
				int t = m - 243;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 243 && m >= 240){
				int t = m - 240;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 240 && m >= 236){
				int t = m - 236;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 236 && m >= 231){
				int t = m - 231;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 231 && m >= 227){
				int t = m - 227;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 227){
				c = (227-m)+100;
			}
		}else if(age >=49 && age <=51){
			if(m <=253 && m >= 249){
				int t = m - 249;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 249 && m >= 246){
				int t = m - 246;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 246 && m >= 244){
				int t = m - 244;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 244 && m >= 243){
				int t = m - 243;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 243 && m >= 240){
				int t = m - 240;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 240 && m >= 236){
				int t = m - 236;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 236 && m >= 231){
				int t = m - 231;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 231 && m >= 227){
				int t = m - 227;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 227){
				c = (227-m)+100;
			}
		}else if(age >=52 && age <=54){
			if(m <=256 && m >= 252){
				int t = m - 252;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 252 && m >= 249){
				int t = m - 249;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 249 && m >= 247){
				int t = m - 247;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 247 && m >= 246){
				int t = m - 246;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 246 && m >= 243){
				int t = m - 243;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 243 && m >= 239){
				int t = m - 239;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 239 && m >= 234){
				int t = m - 234;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 234 && m >= 230){
				int t = m - 230;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 230){
				c = (230-m)+100;
			}
		}else if(age >=55 && age <=57){
			if(m <=259 && m >= 255){
				int t = m - 255;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 255 && m >= 252){
				int t = m - 252;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 252 && m >= 250){
				int t = m - 250;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 250 && m >= 249){
				int t = m - 249;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 249 && m >= 246){
				int t = m - 246;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 246 && m >= 242){
				int t = m - 242;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 242 && m >= 237){
				int t = m - 237;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 237 && m >= 233){
				int t = m - 233;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 233){
				c = (233-m)+100;
			}
		}else if(age >=58 && age <=60){
			if(m <=262 && m >= 258){
				int t = m - 258;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 60 - s;
			}else if(m < 258 && m >= 255){
				int t = m - 255;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 65 - s;
			}else if(m < 255 && m >= 253){
				int t = m - 253;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 70 - s;
			}else if(m < 253 && m >= 252){
				int t = m - 252;
				int d = t * 5 % 1;
				if (d == 0) {
					s = t * 5 / 1;
				} else {
					s = t * 5 / 1 + 1;
				}
				c = 75 - s;
			}else if(m < 252 && m >= 249){
				int t = m - 249;
				int d = t * 5 % 3;
				if (d == 0) {
					s = t * 5 / 3;
				} else {
					s = t * 5 / 3 + 1;
				}
				c = 80 - s;
			}else if(m < 249 && m >= 245){
				int t = m - 245;
				int d = t * 5 % 2;
				if (d == 0) {
					s = t * 5 / 2;
				} else {
					s = t * 5 / 2 + 1;
				}
				c = 90 - s;
			}else if(m < 245 && m >= 240){
				int t = m - 240;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 95 - s;
			}else if(m < 240 && m >= 236){
				int t = m - 236;
				int d = t * 5 % 4;
				if (d == 0) {
					s = t * 5 / 4;
				} else {
					s = t * 5 / 4 + 1;
				}
				c = 100 - s;
			}else if(m < 236){
				c = (236-m)+100;
			}
		}

		return c;
	}

	/**
	 * 女子3000米跑
	 */
	@ResponseBody
	@RequestMapping("/getWomen3Run")
	public int getWomen3Run(int age ,int m){
		int s = 0;
		int c = 0;
		if(age < 24){
			if(m <= 1610 && m >= 1600){
				int t = m - 1600;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if( m < 1600 && m >= 1540){
				int t = m -40 - 1540;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if( m < 1540 && m >= 1425){
				int t = m -40 - 1425;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1425 && m >= 1400){
				int t = m - 1400;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1400){
				c = (1400-m) / 5 + 100;
			}
		}else if(age >=25 && age <=27){
			if(m <= 1623 && m >= 1613){
				int t = m - 1613;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 1613 && m >= 1553){
				int t = m - 40 - 1553;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 1553 && m >= 1438){
				int t = m - 40 - 1438;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1438 && m >= 1413){
				int t = m - 1413;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1413){
				c = (1413-m) / 5 + 100;
			}
		}else if(age >=28 && age <=30){
			if(m <= 1702 && m >= 1652){
				int t = m - 40 - 1652;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 1652 && m >= 1632){
				int t = m - 1632;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 1632 && m >= 1517){
				int t = m - 40 - 1517;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1517 && m >= 1452){
				int t = m - 1452;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1452){
				c = (1452-m) / 5 + 100;
			}
		}else if(age >=31 && age <=33){
			if(m <= 1741 && m >= 1731){
				int t = m - 1731;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 1731 && m >= 1711){
				int t = m - 1711;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 1711 && m >= 1661){
				int t = m - 40 - 1661;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 85 - s;
			}else if(m < 1661 && m >= 1556){
				int t = m -40 - 1556;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1556 && m >= 1531){
				int t = m - 1531;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1531){
				c = (1531-m) / 5 + 100;
			}
		}else if(age >=34 && age <=36){
			if(m <= 1820 && m >= 1810){
				int t = m - 1810;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 1810 && m >= 1750){
				int t = m - 40- 1750;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 1750 && m >= 1635){
				int t = m - 40 - 1635;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1635 && m >= 1610){
				int t = m - 1610;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1610){
				c = (1610-m) / 5 + 100;
			}
		}else if(age >=37 && age <=39){
			if(m <= 1859 && m >= 1849){
				int t = m - 1849;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 1849 && m >= 1829){
				int t = m - 1829;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 1829 && m >= 1714){
				int t = m - 40 - 1714;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1714 && m >= 1649){
				int t = m -40 - 1649;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 95 - s;
			}else if(m < 1649){
				c = (1649-m) / 5 + 100;
			}
		}else if(age >=40 && age <=42){
			if(m <= 1938 && m >= 1928){
				int t = m - 1928;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 1928 && m >= 1908){
				int t = m - 1908;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 1908 && m >= 1808){
				int t = m - 40 - 1808;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			}else if(m < 1808 && m >= 1753){
				int t = m -40 - 1753;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1753 && m >= 1728){
				int t = m - 1728;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1728){
				c = (1728-m) / 5 + 100;
			}
		}else if(age >=43 && age <=45){
			if(m <= 2017 && m >= 2007){
				int t = m - 2007;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 2007 && m >= 1947){
				int t = m - 40 - 1947;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 1947 && m >= 1832){
				int t = m - 40 - 1832;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1832 && m >= 1807){
				int t = m - 1807;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 100 - s;
			}else if(m < 1807){
				c = (1807-m) / 5 + 100;
			}
		}else if(age >=46 && age <=48){
			if(m <= 2056 && m >= 2046){
				int t = m - 2046;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 2046 && m >= 2026){
				int t = m - 2026;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 2026 && m >= 1911){
				int t = m - 40 - 2922;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1911 && m >= 1846){
				int t = m -40 - 1846;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1846){
				c = (1846-m) / 5 + 100;
			}
		}else if(age >=49 && age <=51){
			if(m <= 2135 && m >= 2125){
				int t = m - 2125;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 2125 && m >= 2105){
				int t = m - 2105;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 2105 && m >= 2005){
				int t = m - 40 - 2005;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			}else if(m < 2005 && m >= 1950){
				int t = m -40 - 1950;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 1950 && m >= 1925){
				int t = m - 1925;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 1925){
				c = (1925-m) / 5 + 100;
			}
		}else if(age >=52 && age <=54){
			if(m <= 2214 && m >= 2204){
				int t = m - 2204;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 2204 && m >= 2144){
				int t = m - 40 - 2144;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 2144 && m >= 2004){
				int t = m - 40 - 2004;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 100 - s;
			}else if(m < 2004){
				c = (2004-m) / 5 + 100;
			}
		}else if(age >=55 && age <=57){
			if(m <= 2253 && m >= 2243){
				int t = m - 2243;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 2243 && m >= 2223){
				int t = m - 2223;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 2223 && m >= 2108){
				int t = m - 40 - 2108;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 2108 && m >= 2043){
				int t = m -40 - 2043;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 2043){
				c = (2043-m) / 5 + 100;
			}
		}else if(age >=58 && age <=60){
			if(m <= 2332 && m >= 2322){
				int t = m - 2322;
				int d = t * 5 % 5;
				if (d == 0) {
					s = t * 5 / 5;
				} else {
					s = t * 5 / 5 + 1;
				}
				c = 65 - s;
			}else if(m < 2322 && m >= 2302){
				int t = m - 2302;
				int d = t * 5 % 20;
				if (d == 0) {
					s = t * 5 / 20;
				} else {
					s = t * 5 / 20 + 1;
				}
				c = 70 - s;
			}else if(m < 2302 && m >= 2202){
				int t = m - 40 - 2202;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 90 - s;
			}else if(m < 2202 && m >= 2147){
				int t = m -40 - 2147;
				int d = t * 5 % 15;
				if (d == 0) {
					s = t * 5 / 15;
				} else {
					s = t * 5 / 15 + 1;
				}
				c = 95 - s;
			}else if(m < 2147 && m >= 2122){
				int t = m - 2122;
				int d = t * 5 % 25;
				if (d == 0) {
					s = t * 5 / 25;
				} else {
					s = t * 5 / 25 + 1;
				}
				c = 100 - s;
			}else if(m < 2122){
				c = (2122-m) / 5 + 100;
			}
		}

		return c;
	}
}
