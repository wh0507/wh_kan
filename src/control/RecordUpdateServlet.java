package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RecordDAO;

/**
 * Servlet implementation class RecordUpdateServlet
 */
@WebServlet("/recordUpdate")
public class RecordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		//失敗時
		//		String forwardPath = null;
		//		forwardPath = "/recordChange";
		//		//MainMenuへフォワード
		//		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		//		dispatcher.forward(request, response);

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		double temperature = Double.parseDouble(request.getParameter("temperature"));
		String note = request.getParameter("note");

		//		ArrayList<RecordBean> rcBean = new ArrayList<RecordBean>();
		RecordDAO rcDao = new RecordDAO();
		rcDao.update(id, height, weight, temperature, note);

		//		request.setAttribute("rcBean", rcBean);

		//成功時
		response.sendRedirect("/recordList");

	}

}
