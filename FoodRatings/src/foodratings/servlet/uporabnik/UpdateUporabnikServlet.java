package foodratings.servlet.uporabnik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodratings.client.DataManagerProxy;
import foodratings.client.Uporabnik;

/**
 * Servlet implementation class UpdateUporabnikServlet
 */
public class UpdateUporabnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUporabnikServlet() {
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
		int id=Integer.parseInt(request.getParameter("idItem"));
		String username=request.getParameter("username");
		String role=request.getParameter("admin");
		
		DataManagerProxy dmp=new DataManagerProxy();
		
		Uporabnik u=dmp.readUporabnik(id);
		u.setUsername(username);
		u.setRole(role);

		dmp.updateUporabnik(u);
		response.sendRedirect("/FoodRatings/admin/admin_uporabniki.jsp");
	}

}
