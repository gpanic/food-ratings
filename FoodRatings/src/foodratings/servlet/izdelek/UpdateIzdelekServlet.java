package foodratings.servlet.izdelek;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodratings.client.DataManagerProxy;
import foodratings.client.Izdelek;

/**
 * Servlet implementation class UpdateIzdelekServlet
 */
public class UpdateIzdelekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIzdelekServlet() {
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
		int idKat=Integer.parseInt(request.getParameter("kategorija"));
		int idPro=Integer.parseInt(request.getParameter("proizvajalec"));
		int idDrz=Integer.parseInt(request.getParameter("drzava"));
		String eng=request.getParameter("engName");
		
		DataManagerProxy dmp=new DataManagerProxy();
		
		Izdelek i=dmp.readIzdelek(id);
		i.setNaziv(naziv);
		i.setKategorija(dmp.readKategorija(idKat));
		i.setProizvajalec(dmp.readProizvajalec(idPro));
		i.setDrzavaIzvora(dmp.readDrzava(idDrz));
		i.setEngName(eng);
		
		dmp.updateIzdelek(i);
		response.sendRedirect("/FoodRatings/admin/admin_izdelki.jsp");
	}

}
