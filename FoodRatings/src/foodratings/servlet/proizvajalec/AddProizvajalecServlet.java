package foodratings.servlet.proizvajalec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodratings.client.DataManagerProxy;
import foodratings.client.Proizvajalec;

/**
 * Servlet implementation class AddProizvajalecServlet
 */
public class AddProizvajalecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProizvajalecServlet() {
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
		String drz=request.getParameter("drzava");
		String mes=request.getParameter("mesto");
		
		if(naziv.equals("")
				||drz.equals("")
				||mes.equals("")) {
			session.setAttribute("fields", false);
			response.sendRedirect("/FoodRatings/admin/admin_proizvajalec_add.jsp");
			
		} else {
			Proizvajalec p=new Proizvajalec();
			p.setNaziv(naziv);
			p.setDrzava(drz);
			p.setMesto(mes);
			
			DataManagerProxy dmp=new DataManagerProxy();
			dmp.createProizvajalec(p);
			
			session.setAttribute("created", true);
			response.sendRedirect("/FoodRatings/admin/admin_proizvajalci.jsp");
		
		}
	}

}
