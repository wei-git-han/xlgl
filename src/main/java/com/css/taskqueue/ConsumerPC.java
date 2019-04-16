package com.css.taskqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;
import com.css.addbase.token.TokenConfig;


/**
 * 消费者消费队列中的任务，当队列为空时，消费者阻塞自己，唤醒生产者
 * notify()是随机唤醒等待队列中的一个线程
 *
 */

public class ConsumerPC  extends Thread{
	private RestTemplate restTemplate = new  RestTemplate();
	
	private Queue<Map<String, Object>> queue;
	private int maxSize;
	private static final Queue<Map<String, Object>> queue2 = new LinkedBlockingQueue<>();//创建一个存储消费队列
	String msgUrl;
	String accessToken;
	String appId;
	String appSecret;
	String urlAccessToken;
	Object result = null;
	Object httpEntity  = null;
	
	public ConsumerPC(Queue<Map<String, Object>> queue,int maxSize,String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		while(true) {
			while(queue.isEmpty()) {
				System.out.println("当前队列中没有PC端消息任务，消费者进入阻塞状态");
				try {
					synchronized (queue) {
						queue.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			queue2.addAll(queue);
			queue.clear();
			try {			
				Map<String, Object> map = queue2.remove();//移除并返回队列头部的元素
				accessToken=(String)map.get("accessToken");
				appId=(String)map.get("appId");
				appSecret=(String)map.get("appSecret");
				msgUrl=(String)map.get("url");
				urlAccessToken=msgUrl+accessToken;
				httpEntity = map.get("httpEntity");
				result = restTemplate.postForEntity(urlAccessToken, map.get("httpEntity"), (Class<Object>)map.get("clazz"));
			}catch (Exception e) {
				e.printStackTrace();
				TokenConfig.removeToken(accessToken);
				if (StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(appSecret)) {
					accessToken = TokenConfig.token(appId, appSecret);
				}
				if (StringUtils.isBlank(accessToken)) {
					accessToken = TokenConfig.token();
				}
				System.out.println("PC发送消息请求路径:"+ urlAccessToken);
				result = restTemplate.postForEntity(msgUrl + accessToken, httpEntity, String.class);
				
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("result", result);
				queue.add(map2);
				synchronized (queue) {
					queue.notifyAll();
				}
				
			}
			System.out.println("PC发送消息返回结果:{}"+ result);
		}
	}
}
