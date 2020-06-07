

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Calendario;


@WebServlet("/MonthCtrl")
public class MonthCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MonthCtrl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String mes = request.getParameter("mes");
		int nMes = Calendario.getNumOfMonth(mes);
		
		Calendario calendario = new Calendario(2020, nMes, 1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/wcalendar.jsp");
		request.setAttribute("calendario", calendario);
		dispatcher.forward(request, response);
		
	}

	

}
