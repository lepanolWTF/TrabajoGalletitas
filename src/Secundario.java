

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Secundario
 */
@WebServlet("/Secundario")
public class Secundario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Secundario() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUser=request.getParameter("idUser");
		String visitas=request.getParameter("visitas");
		String genero=request.getParameter("genero");
		Cookie galletita = new Cookie(idUser,visitas+"#"+genero);

		galletita.setMaxAge(60*60*24);
		response.addCookie(galletita);
		
		String vista = "/Login.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.include(request, response);
//		doGet(request, response);
	}

}
