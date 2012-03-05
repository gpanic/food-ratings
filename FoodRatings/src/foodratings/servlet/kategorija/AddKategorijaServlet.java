package foodratings.servlet.kategorija;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodratings.client.DataManagerProxy;
import foodratings.client.Kategorija;

/**
 * Servlet implementation class AddKategorijaServlet
 */
public class AddKategorijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKategorijaServlet() {
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
		
		String naziv=request.getParameter("naziv");
		
		if(naziv.equals("")) {
			session.setAttribute("fields", false);
			response.sendRedirect("/FoodRatings/admin/admin_kategorija_add.jsp");
			
		} else {
			Kategorija k=new Kategorija();
			k.setNaziv(naziv);
			
			DataManagerProxy dmp=new DataManagerProxy();
			dmp.createKategorija(k);
			
			session.setAttribute("created", true);
			response.sendRedirect("/FoodRatings/admin/admin_kategorije.jsp");
		
		}	
	}

}
