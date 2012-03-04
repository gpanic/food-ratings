package foodratings.servlet.kategorija;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodratings.client.DataManagerProxy;

/**
 * Servlet implementation class DeleteKategorijaServlet
 */
public class DeleteKategorijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKategorijaServlet() {
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
		String referer = request.getHeader("Referer");
		
		if(request.getParameter("idItem")!=null) {
			int id=Integer.parseInt(request.getParameter("idItem"));
			DataManagerProxy dmp=new DataManagerProxy();
			dmp.deleteKategorija(id);
		}
		
		if(referer!=null) {
			response.sendRedirect(referer);
		} else {
			response.sendRedirect("/FoodRatings/admin/admin_kategorije.jsp");
		}
	}

}
