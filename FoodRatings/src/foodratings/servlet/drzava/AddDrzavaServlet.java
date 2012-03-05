package foodratings.servlet.drzava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodratings.client.DataManagerProxy;
import foodratings.client.Drzava;

/**
 * Servlet implementation class AddDrzavaServlet
 */
public class AddDrzavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDrzavaServlet() {
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
		
		String ime=request.getParameter("ime");
		String kra=request.getParameter("kratica");
		
		if(ime.equals("")
				||kra.equals("")) {
			session.setAttribute("fields", false);
			response.sendRedirect("/FoodRatings/admin/admin_drzava_add.jsp");
			
		} else {
			Drzava d=new Drzava();
			d.setIme(ime);
			d.setKratica(kra);
			
			DataManagerProxy dmp=new DataManagerProxy();
			dmp.createDrzava(d);
			
			session.setAttribute("created", true);
			response.sendRedirect("/FoodRatings/admin/admin_drzave.jsp");
		
		}
	}

}
