//package com.css.webservice;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.css.addbase.apporgan.service.BaseAppUserService;
//import com.css.app.db.business.entity.SubDocInfo;
//import com.css.app.db.business.service.SubDocInfoService;
//import com.css.app.db.config.entity.AdminSet;
//import com.css.app.db.config.service.AdminSetService;
//import com.css.app.db.util.DbDocStatusDefined;
//import com.css.base.utils.CurrentUser;
//import com.css.base.utils.Response;
//import com.css.base.utils.StringUtils;
//
//@RestController
//@RequestMapping("/api")
//public class ToDoApiController {
//    @Autowired
//    private AdminSetService adminSetService;
//    @Autowired
//    private SubDocInfoService subDocInfoService;
//    @Autowired
//    private BaseAppUserService baseAppUserService;
//
//    /**
//     * 督办待办数app
//     */
//
//    @ResponseBody
//    @RequestMapping("/db/todo")
//    public void dbNumSum() {
//        int dbNumSum = 0;
//        String loginUserId = CurrentUser.getUserId();
//        Map<String, Object> value = new HashMap<String, Object>();
//        String userMenuIds = this.getUserMenu(loginUserId);
//        if(StringUtils.isBlank(userMenuIds)) {
//        	value.put("result", "success");
//            value.put("count", dbNumSum);
//            Response.json(value);
//            return;
//        }
//        if(userMenuIds.contains("002")) {
//        	int  grdbNum= getPersonTodoCount(loginUserId);
//    		dbNumSum = dbNumSum+grdbNum;
//        }
//        if(userMenuIds.contains("003")) {
//        	int  jndbNum= getUnitTodoCount(loginUserId);
//    		dbNumSum = dbNumSum+jndbNum;
//        }
//
//        value.put("result", "success");
//        value.put("count", dbNumSum);
//        Response.json(value);
//    }
//
//    // 个人待办数
//    private int getPersonTodoCount(String loginUserId) {
//        int grdbNum = 0;
//        Map<String, Object> personalMap = new HashMap<>();
//        if (StringUtils.isNotBlank(loginUserId)) {
//            personalMap.put("loginUserId", loginUserId);
//        }
//        personalMap.put("receiver", "receiver");
//        List<SubDocInfo> subDocInfoPersonalList = subDocInfoService.queryPersonList1(personalMap);
//        if (subDocInfoPersonalList != null && subDocInfoPersonalList.size() > 0) {
//            grdbNum = subDocInfoPersonalList.size();
//        }
//    	return grdbNum;
//    }
//    // 局内待办数
//    private int getUnitTodoCount(String loginUserId) {
//    	 int jndbNum = 0;
//         Map<String, Object> jumap = new HashMap<>();
//         String orgId = baseAppUserService.getBareauByUserId(loginUserId);
//         if (StringUtils.isNotBlank(orgId)) {
//             jumap.put("orgId", orgId);
//         }
//         jumap.put("docStatus", DbDocStatusDefined.DAI_ZHUAN_BAN);
//         // 查询列表数据
//         List<SubDocInfo> subDocInfoList = subDocInfoService.queryList(jumap);
//         if (subDocInfoList != null && subDocInfoList.size() > 0) {
//             jndbNum = subDocInfoList.size();
//         }
//    	return jndbNum;
//    }
//
//    //获取当前登录人的菜单
//    private String getUserMenu(String loginUserId){
//		String menuIds = "002";
//		Map<String, Object> map = new HashMap<>();
//		map.put("adminType", "2");
//		map.put("userId", loginUserId);
//		List<AdminSet> list = adminSetService.queryList(map);
//		if(!list.isEmpty()) {
//			menuIds=menuIds+",003";
//		}
//		return menuIds;
//    }
//
//}
//
