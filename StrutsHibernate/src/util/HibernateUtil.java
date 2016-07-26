package util;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateUtil {
	// セッションの取得メソッド
		public static Session getSession() {
			Configuration conf = new Configuration().configure();
			ServiceRegistryBuilder sb = new ServiceRegistryBuilder();
			sb.applySettings(conf.getProperties());
			ServiceRegistry sr = sb.buildServiceRegistry();
			SessionFactory sf = conf.buildSessionFactory(sr);
			Session ses = sf.openSession();
			return ses;
		}
}
