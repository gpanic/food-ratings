package foodratings.servlet.drzava;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodratings.client.DataManagerProxy;
import foodratings.client.Drzava;
import foodratings.client.Ocena;

/**
 * Servlet implementation class RateDrzavaServlet
 */
public class RateDrzavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateDrzavaServlet() {
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
		System.out.println("RATE");
		HttpSession session=request.getSession();
		
		
		int userId=Integer.parseInt(request.getParameter("userId"));
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int rating=Integer.parseInt(request.getParameter("rating"));
		
		DataManagerProxy dmp=new DataManagerProxy();
		
		boolean rated=false;
		if(rating>0) {
			Drzava d=dmp.readDrzava(itemId);
			List<Ocena> ocene=d.getOcene();
			for(Ocena o:ocene) {
				if(o.getIdUser()==userId) {
					o.setOcena(rating);
					rated=true;
				}
			}
			
			if(!rated) {
				Ocena o=new Ocena();
				o.setIdUser(userId);
				o.setOcena(rating);
				ocene.add(o);
			}
			dmp.updateDrzava(d);
			
			session.setAttribute("rated", true);
			response.sendRedirect("/FoodRatings/drzave.jsp");
		}
	}

}
