package foodratings.servlet.drzava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodratings.client.DataManagerProxy;
import foodratings.client.Drzava;

/**
 * Servlet implementation class UpdateDrzavaServlet
 */
public class UpdateDrzavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDrzavaServlet() {
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
		String ime=request.getParameter("ime");
		String kratica=request.getParameter("kratica");
		
		DataManagerProxy dmp=new DataManagerProxy();
		
		Drzava d=dmp.readDrzava(id);
		d.setIme(ime);
		d.setKratica(kratica);
		
		dmp.updateDrzava(d);
		response.sendRedirect("/FoodRatings/admin/admin_drzave.jsp");
	}

}
