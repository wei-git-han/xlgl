package com.css.taskqueue;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 消费者消费队列中的任务，当队列为空时，消费者阻塞自己，唤醒生产者
 * notify()是随机唤醒等待队列中的一个线程
 * @author zcx
 *
 */
public class Consumer extends Thread{
	private Queue<Map<String, Object>> queue;
	private int maxSize;
	private static final Queue<Map<String, Object>> queue2 = new LinkedBlockingQueue<>();//创建一个存储消费队列
	public Consumer(Queue<Map<String, Object>> queue,int maxSize,String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}
	@Override
	public void run() {
		while(true) {
			while(queue.isEmpty()) {
				System.out.println("当前队列中没有任务，消费者进入阻塞状态");
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
				//用反射调用发短信方法
				Class<?> util = Class.forName("com.css.addbase.SmsUtil");
				Method method = util.getMethod("sendSms",String.class,String.class,String.class);
				Map<String, Object> map = queue2.remove();
				String contentmsm = (String) method.invoke(util.newInstance(), map.get("content"),map.get("tels"),map.get("smsUrl"));
				if (!contentmsm.equals("success")) {
					String[] con = contentmsm.split("&");
					Map<String, Object> map2 = new HashMap<String, Object>();
					map2.put("content", con[0]);
					map2.put("tels", con[1]);
					queue.add(map2);
					synchronized (queue) {
						queue.notifyAll();
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
