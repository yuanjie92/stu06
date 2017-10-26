package org.jie.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static Session session = null;
	private static Transaction transaction = null;	
	

	public static Session getSession(){
		//1.读取hibernate配置文件
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//2.创建session工厂
		SessionFactory factory = cfg.buildSessionFactory();
		//3.打开session
		session = factory.openSession();
		//4.开启事务
		transaction = session.beginTransaction();
		
		return session;
	}
	
	public static void after(){
		//6.提交事务
		transaction.commit();
		//7.关闭资源
		session.close();
	}
}
