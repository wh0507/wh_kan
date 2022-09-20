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
		List<RecordBean> recordList = dao.findAll();
		request.setAttribute("recordList", recordList);

		//日付
		String[] year = request.getParameterValues("year");
		String[] month = request.getParameterValues("month");
		String[] day = request.getParameterValues("day");

		//身長
		String strHeightFrom = request.getParameter("heightFrom");
		String strHeightTo = request.getParameter("heightTo");
		//体重
		String strWeightFrom = request.getParameter("weightFrom");
		String strWeightTo = request.getParameter("weightTo");
		//体温
		String strTempFrom = request.getParameter("tempFrom");
		String strTempTo = request.getParameter("tempTo");

		//チェックボックス
		String checked = request.getParameter("checkbox");

		//記録一覧画面へフォワード
		String forwardPath = null;
		forwardPath = "/WEB-INF/jsp/recordList.jsp?no=1";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

}
