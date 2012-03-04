package foodratings.servlet.kategorija;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodratings.client.DataManagerProxy;
import foodratings.client.Kategorija;

/**
 * Servlet implementation class UpdateKategorijaServlet
 */
public class UpdateKategorijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKategorijaServlet() {
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
		String naziv=request.getParameter("naziv");
		
		DataManagerProxy dmp=new DataManagerProxy();
		
		Kategorija k=dmp.readKategorija(id);
		k.setNaziv(naziv);
		dmp.updateKategorija(k);
		
		response.sendRedirect("/FoodRatings/admin/admin_kategorije.jsp");
	}

}
