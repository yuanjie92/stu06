package org.jie.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static Session session = null;
	private static Transaction transaction = null;
	private static SessionFactory factory = null;
	static {
		// 1.读取hibernate配置文件
		Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		// 2.创建session工厂
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {

		// 3.打开session
		session = factory.openSession();
		// 4.开启事务
		transaction = session.beginTransaction();

		return session;
	}

	public static void commitAndCloseSession() {
		// 6.提交事务
		transaction.commit();
		// 7.关闭资源
		session.close();
	}
}
