package com.css.addbase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import com.suwell.ofd.custom.agent.callback.BeaconCallback;
import com.suwell.ofd.custom.wrapper.PackException;
import com.suwell.ofd.custom.wrapper.Packet;
import com.suwell.ofd.custom.wrapper.Const.PackType;
import com.suwell.ofd.custom.wrapper.Const.Target;
import com.suwell.ofd.custom.wrapper.model.Common;
import com.suwell.ofd.custom.agent.ConvertCallback;
import com.suwell.ofd.custom.agent.ConvertException;
import com.suwell.ofd.custom.agent.HTTPAgent;

public class OfdUnit {
	@Deprecated
	public static BeaconCallback getInstance(String fileName) {
		return new BeaconCallback(new ConvertCallback() {
			private ByteArrayOutputStream bos = new ByteArrayOutputStream();
			@Override
			public OutputStream openOutput() throws IOException {
				return bos;
			}

			@Override
			public void onSuccess() {
				byte[] bytes = bos.toByteArray();
				InputStream is = new ByteArrayInputStream(bytes);
				String fileId = FileBaseUtil.wpsServiceUpload(is, fileName);
				System.out.println("onSuccess，fileId=" + fileId);
			}

			@Override
			public void onStart() {
				System.out.println("onStart");
			}

			@Override
			public void onFailed(String code, String message) {
				System.out.println("onFailed:" + code);
			}

			@Override
			public void onException(Exception ex) {
				System.out.println(ex.getMessage());
			}

			@Override
			public void onFinally() {
			}
		});
	}
	/**
	 * 1、把数据转换为Word文件，<br/>
	 * 2、把Word文件转换为OFD文件，并存储到文件服务器。<br/>
	 * @param params 数据
	 * @param fileName 文件名称，在存储到文件服务器时使用
	 * @param templateName 模板路径 *.xml
	 * @param ofdUrl 转版服务的URL
	 * @return 返回fileId，即文件在文件服务中的唯一标识。
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public static String Data2Ofd(Map<String, Object> params,String fileName,String templateName,String ofdUrl) {
		long startTime=System.currentTimeMillis();
		ByteArrayOutputStream wordOuts = WordUtils.createDoc(params, templateName);
		byte[] bytes=wordOuts.toByteArray();
		long endTime=System.currentTimeMillis();
		long spanTime=endTime-startTime;
		System.out.println("【生成word耗时】"+(spanTime/1000.0)+"秒");
		//step,把word转换为OFD文件
		HTTPAgent ha = new HTTPAgent(ofdUrl);
		Packet pkg = new Packet(PackType.COMMON, Target.OFD);
		pkg.fileHandler("suwell-custom-handler-suwell-company", "cpcns.convert.mc.impl.FileHandlerBridge");
		try {
			System.out.println("onStart");
			startTime=System.currentTimeMillis();
			InputStream in=new  ByteArrayInputStream(bytes);
			ByteArrayOutputStream bos=new ByteArrayOutputStream(); 
			pkg.file(new Common("1", "doc", in));
			ha.convert(pkg, bos);
			endTime=System.currentTimeMillis();
			spanTime=endTime-startTime;
			System.out.println("【ofd转版耗时】"+(spanTime/1000.0)+"秒");
			bytes = bos.toByteArray();
			InputStream is = new ByteArrayInputStream(bytes);
			startTime=System.currentTimeMillis();
			String fileId = FileBaseUtil.wpsServiceUpload(is, fileName);
			endTime=System.currentTimeMillis();
			spanTime=endTime-startTime;
			System.out.println("【文件服务存储文件耗时】"+(spanTime/1000.0)+"秒");
			System.out.println("onSuccess，fileId=" + fileId);
			return fileId;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PackException e) {
			e.printStackTrace();
		} catch (ConvertException e) {
			e.printStackTrace();
		}
		return null;
	}
}
