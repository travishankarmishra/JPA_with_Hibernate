package com.controller;

import java.io.IOException;
import java.util.List;

import com.model.Address;
import com.model.UserModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet({ "/insert", "/show", "/delete" })
@MultipartConfig(fileSizeThreshold = 10000000, maxFileSize = 1000000, maxRequestSize = 1000000)
public class MyController extends HttpServlet {
	EntityManager em = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Data");
		em = emf.createEntityManager();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		String filename = req.getPart("file").getSubmittedFileName();
		for (Part p : req.getParts()) {
			p.write("/home/ducat/Documents/Java_Projects/JPA_with_Hibernate/src/main/webapp/upload/" + filename);
		}

		Address add = new Address("T4561A", "Shiv Temple", "New Delhi", "Delhi", "India");
		
		UserModel um = new UserModel(name, email, password, mobile, filename,add);

		
		
		em.getTransaction().begin();
		em.persist(um); // to save
		em.getTransaction().commit();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getServletPath().equals("/delete")) {
			int sno = Integer.parseInt(req.getParameter("sno"));
			UserModel UserModel;
			Query q = em.createQuery("delete from UserModel where sno=:a");
			q.setParameter("a", sno);
			em.getTransaction().begin();
			q.executeUpdate();
			em.getTransaction().commit();
		} else {
			// UserModel data= em.find(UserModel.class, 1);
			UserModel UserModel;
			Query q = em.createQuery("from UserModel");
			List<UserModel> data = q.getResultList();
			System.out.println(q.getResultList());

			req.setAttribute("data", data);

			RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
			rd.forward(req, resp);

		}

	}

}
