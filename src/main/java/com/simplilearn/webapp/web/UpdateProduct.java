package com.simplilearn.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.webapp.model.Product;
import com.simplilearn.webapp.util.HibernateSessionUtil;

@WebServlet("/update-product")
public class UpdateProduct extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("update-product.html").include(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//add top nav 
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		// fetch data from form
		int productId = Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("name");
		double productPrice = Double.parseDouble(request.getParameter("price"));
		String productDesc = request.getParameter("desc");
		
		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			// 2. create session object
			Session session = factory.openSession();
			
			// 3. create a product object
			Product product = new Product(productId, productName, productPrice, productDesc);
			
			// 4. begin transaction
			Transaction tx = session.beginTransaction();
			
			// 5. update product
			session.update(product);
			
			// 6. commit transaction
			tx.commit();
			
			if(session != null ) {
				out.print("<h3 style='color:green'> Product is updated sucessfully ! </h3>");
			}
		
			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}
}
