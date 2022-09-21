package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RecordBean;
import model.RecordDAO;

/**
 * 記録詳細・更新コントローラー
 */
@WebServlet("/recordChange")
public class RecordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		ArrayList<RecordBean> rcBean = new ArrayList<RecordBean>();
		RecordDAO rcDao = new RecordDAO();
		rcBean = rcDao.findById(id); //登録されたidのデータを受け取る

		request.setAttribute("rcBean", rcBean);

		String forwardPath = null;
		forwardPath = "/WEB-INF/jsp/recordChange.jsp?no=3";
		//記録詳細・更新画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

}
