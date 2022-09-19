package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RecordBean;
import model.RecordDAO;

/**
 * 記録一覧コントローラー
 */
@WebServlet("/recordList")
public class RecordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//DBから呼び出し
		RecordDAO dao = new RecordDAO();

		//checkbox確認
		String checked = request.getParameter("checkbox");
		if (checked == null) {
			List<RecordBean> recordList = dao.findAll();
			request.setAttribute("recordList", recordList);
		} else if (checked != null) {
			List<RecordBean> dateList = dao.findByDate();
			request.setAttribute("dateList", dateList);
		}

		//記録一覧画面へフォワード
		String forwardPath = null;
		forwardPath = "/WEB-INF/jsp/recordList.jsp?no=1";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

}
