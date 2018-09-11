package br.com.projRevista.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projRevista.data.RevistaDB;
import br.com.projRevista.model.Revista;

@WebServlet("/RevistaCtrl")
public class RevistaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		
		Revista r = new Revista();
		
		r.setNome(request.getParameter("nome"));
		r.setAno(Integer.parseInt(request.getParameter("ano")));
		r.setMes(request.getParameter("mes"));
		r.setQtdPaginas(Integer.parseInt(request.getParameter("qtdPags")));
		
		try {
			msg = new RevistaDB().inserir(r) ? "Revista salva com sucesso." : "Erro ao salvar a revista";
		} catch(SQLException exc) {
			msg = exc.getMessage();
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
