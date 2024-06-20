package test;

import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDao;
import model.cat;
import util.HibernateUtil;

public class TestCat {

	// SESSION đại diện cho phiên làm việc với CSDL
	// TRANSACTION là giao dịch
	public static void main(String[] args) {
		cat c = CatDao.getCatDao().selectByIdd(1);
		System.out.println(c);
	}

}