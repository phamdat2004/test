package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.cat;
import util.HibernateUtil;

public class CatDao implements daoInterface<cat>{

	
	public static CatDao getCatDao() {
		return new CatDao();
	}
	@Override
	public List<cat> getAll() {
		ArrayList<cat> list = new ArrayList<cat>();
		try {
			// Đối tượng giao tiếp với CSDL
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				String hql = "from cat";
				Query query = session.createQuery(hql);
				list = (ArrayList<cat>) query.getResultList();
				tr.commit();
				session.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public cat selectById(cat t) {
		ArrayList<cat> list = new ArrayList<cat>();
		try {
			// Tạo ra nhà máy phiên để giao tiếp CSDL
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			String hql = "from cat where id=:id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", t.getId());
			list = (ArrayList<cat>) query.getResultList();
			tr.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(list.size()>0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}

	public boolean saveorUpdate(cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				
				Transaction tr = session.beginTransaction();
				session.saveOrUpdate(t);
				tr.commit();
				session.close();
				return true;		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
	@Override
	public boolean insert(cat t) {
		return saveorUpdate(t);
	}

	@Override
	public boolean update(cat t) {
		return saveorUpdate(t);
	}

	@Override
	public boolean delete(cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				
				Transaction tr = session.beginTransaction();
				session.delete(t);
				tr.commit();
				session.close();
				return true;		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public cat selectByIdd(int id) {
		ArrayList<cat> list = new ArrayList<cat>();
		try {
			// Tạo ra nhà máy phiên để giao tiếp CSDL
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			String hql = "from cat where id=:id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			list = (ArrayList<cat>) query.getResultList();
			tr.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(list.size()>0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}

}
