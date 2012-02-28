package foodratings.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.icu.impl.UBiDiProps;

import foodratings.client.uporabnik.ManageUporabnikProxy;
import foodratings.client.uporabnik.Uporabnik;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
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
		HttpSession session=request.getSession();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Uporabnik u=new Uporabnik();
		u.setUsername(username);
		u.setPassword(password);
		
		ManageUporabnikProxy mpu=new ManageUporabnikProxy();
		Uporabnik uFull=mpu.loginUporabnik(u);
		if(uFull!=null) {
			session.setAttribute("userId", uFull.getId());
			response.sendRedirect("/FoodRatings");
		} else {
			session.setAttribute("login", false);
			response.sendRedirect("/FoodRatings/signin.jsp");
		}
	}

}
