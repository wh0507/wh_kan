package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecordUpdateServlet
 */
@WebServlet("/recordUpdate")
public class RecordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		//失敗時
//		String forwardPath = null;
//		forwardPath = "/recordChange";
//		//MainMenuへフォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
//		dispatcher.forward(request, response);

		//成功時
		response.sendRedirect("/recordList");

	}

}
