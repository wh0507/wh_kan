package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;

/**
 * 削除コントローラー
 */
@WebServlet("/recordDelete")
public class RecordDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		RecordDAO rcDao = new RecordDAO();
		rcDao.delete(id);	//指定したid(記録)削除

		//記録一覧画面へredirect
		response.sendRedirect("/recordList");

	}

}
