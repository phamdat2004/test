package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


		// Lấy ra thông tin đã cấu hình và kết nối CSDL
public class HibernateUtil {
	
	// tạo các đối tượng Session cho việc giao tiếp với CSDL
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Loi khong the tao SessionFactory");
			return null;
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}