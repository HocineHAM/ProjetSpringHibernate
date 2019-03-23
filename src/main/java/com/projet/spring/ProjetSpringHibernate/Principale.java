package com.projet.spring.ProjetSpringHibernate;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.*;


//import com.JPA.HIBERNATE.App.App;

/**
 * Hello world!
 *
 */
public class Principale {
	public static void main(String[] args) {
		//Logger log = LoggerFactory.getLogger(Principale.class);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			Client monClient = new Client();
			tx = (Transaction) session.beginTransaction();
			session.save(monClient);
			tx.commit();

		}

		catch (Exception ex) {
			try {
				tx.rollback();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			session.close();
		}

	}
}
