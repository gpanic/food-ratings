package foodratings.servlet.izdelek;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodratings.client.DataManagerProxy;
import foodratings.client.Izdelek;

/**
 * Servlet implementation class AddIzdelekServlet
 */
public class AddIzdelekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIzdelekServlet() {
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
		int kat=Integer.parseInt(request.getParameter("kategorija"));
		int pro=Integer.parseInt(request.getParameter("proizvajalec"));
		int drz=Integer.parseInt(request.getParameter("drzava"));
		String eng=request.getParameter("engName");
		
		if(!naziv.equals("")) {
			DataManagerProxy dmp=new DataManagerProxy();
		
			Izdelek i=new Izdelek();
			i.setNaziv(naziv);
			i.setKategorija(dmp.readKategorija(kat));
			i.setProizvajalec(dmp.readProizvajalec(pro));
			i.setDrzavaIzvora(dmp.readDrzava(drz));
			i.setEngName(eng);
			
			dmp.createIzdelek(i);
			session.setAttribute("created", true);
			response.sendRedirect("/FoodRatings/admin/admin_izdelki.jsp");
			
		} else {
			session.setAttribute("fields", false);
			response.sendRedirect("/FoodRatings/admin/admin_izdelek_add.jsp");
		}
	}

}
