

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String vista = "/Login.jsp";
	private Map<String, String> usuariosArr = new TreeMap<String,String>() {{
		put("Juan", "Juan");
		put("Pepe", "Pepe");	

	}}; 

    public Principal() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
//		request.setAttribute("listaPaises", arrayPaises);

    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response); 
	}
/*Hay que usar campos hidden*/
	//https://sites.google.com/site/expertoendesarrollojavajeej11a/k-cookies-y-sesiones
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUser=request.getParameter("idUser");
		String contra=request.getParameter("contra");
		if(usuariosArr.containsKey(idUser)){
			if(usuariosArr.get(idUser).equals(contra)){
				vista="/Inicio.jsp";
				request.setAttribute("idUser",idUser);
				
				Cookie[] galletitas = request.getCookies();
				String visitas = "1";
				if(galletitas!=null) {
					for(int i=0;i<galletitas.length;i++) {
						Cookie cookieActual = galletitas[i];
						String identificador = cookieActual.getName();
						
						if(identificador.equals(idUser)){
							String valor = cookieActual.getValue();
							String[] valores=valor.split("#");
							visitas = ""+(Integer.parseInt(valores[0]) + 1);
							request.setAttribute("genero",valores[1]);
						}
					}
				}
				request.setAttribute("visitas",visitas);
			}else {
				request.setAttribute("loginError","Error: de usuario o contraseña son incorrectos");
			}
		}else {
			request.setAttribute("loginError","Error de usuario o contraseña son incorrectos");
		}
		

		
		
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response); 
//		doGet(request, response);
	}

}
