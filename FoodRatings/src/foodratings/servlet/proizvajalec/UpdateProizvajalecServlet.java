package foodratings.servlet.proizvajalec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodratings.client.DataManagerProxy;
import foodratings.client.Proizvajalec;

/**
 * Servlet implementation class UpdateProizvajalecServlet
 */
public class UpdateProizvajalecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProizvajalecServlet() {
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
		String drzava=request.getParameter("drzava");
		String mesto=request.getParameter("mesto");
		
		DataManagerProxy dmp=new DataManagerProxy();
		
		Proizvajalec p=dmp.readProizvajalec(id);
		p.setId(id);
		p.setNaziv(naziv);
		p.setDrzava(drzava);
		p.setMesto(mesto);
		
		dmp.updateProizvajalec(p);
		response.sendRedirect("/FoodRatings/admin/admin_proizvajalci.jsp");
	}

}
