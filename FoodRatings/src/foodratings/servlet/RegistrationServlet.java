package foodratings.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodratings.client.DataManagerProxy;
import foodratings.client.Uporabnik;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REGSERVLET");
		HttpSession session=request.getSession();
		
		String username=request.getParameter("username");
		String pass1=request.getParameter("password");
		String pass2=request.getParameter("password2");
		System.out.println(username+pass1+pass2);
		
		if(username.equals("")
				||pass1.equals("")
				||pass2.equals("")) {
			System.out.println("PRAZNO");
			session.setAttribute("fields", false);
			response.sendRedirect("/FoodRatings/registration.jsp");
		} else {
			if(pass1.equals(pass2)) {
				Uporabnik u=new Uporabnik();
				u.setUsername(username);
				u.setPassword(pass1);
				u.setRole("user");
				
				DataManagerProxy dmp=new DataManagerProxy();
				dmp.createUporabnik(u);
				
				session.setAttribute("reg", true);
				response.sendRedirect("/FoodRatings/signin.jsp");
			} else {
				session.setAttribute("passMatch", false);
				response.sendRedirect("/FoodRatings/registration.jsp");
			}
		}
	}

}
