package foodratings.servlet.izdelek;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodratings.client.DataManagerProxy;

/**
 * Servlet implementation class DeleteIzdelekServlet
 */
public class DeleteIzdelekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteIzdelekServlet() {
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
		
		if(request.getParameter("idIzdelek")!=null) {
			int id=Integer.parseInt(request.getParameter("idIzdelek"));
			DataManagerProxy dmp=new DataManagerProxy();
			dmp.deleteIzdelek(id);
		}
		
		if(referer!=null) {
			response.sendRedirect(referer);
		} else {
			response.sendRedirect("/FoodRatings/admin/admin_izdelki.jsp");
		}
	}

}
