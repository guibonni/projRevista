package br.com.projRevista.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projRevista.data.RevistaDB;
import br.com.projRevista.model.Revista;

@WebServlet("/ConsultaServlet")
public class ConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String msg = "";
    	List<Revista> rows = new ArrayList<>();
    	
		try {
			rows = new RevistaDB().getAll(request.getParameter("filtro"));
		} catch(SQLException exc) {
			msg = exc.getMessage();
		}
		
		request.setAttribute("rows", rows);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("consultar.jsp").forward(request, response);
	}

}
