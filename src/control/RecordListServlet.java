package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecordDAO;
import model.Errcheck;
import model.RecordBean;

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

		//ログインチェック追加（arakawa）
		HttpSession session = request.getSession();

		if(session.getAttribute("user_name") == null) {
			String msg = "ログイン状態ではありません。再度ログインしてください。";
			session.setAttribute("msg", msg);
			response.sendRedirect("/login");

		}else {

			Errcheck errcheck = new Errcheck(); //エラーチェック
			String msg = ""; //メッセージ

			String user_id = (String)session.getAttribute("userId");

			//日付
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");

			String date = year + "/" + month + "/" + day;

			if (year != null || month != null || day != null) {
				msg = errcheck.searchDateCheck(date);
			}
			//		//日付
			//		String[] year = request.getParameterValues("year");
			//		String[] month = request.getParameterValues("month");
			//		String[] day = request.getParameterValues("day");
			//
			//		//身長
			//		String strHeightFrom = request.getParameter("heightFrom");
			//		String strHeightTo = request.getParameter("heightTo");
			//		//体重
			//		String strWeightFrom = request.getParameter("weightFrom");
			//		String strWeightTo = request.getParameter("weightTo");
			//		//体温
			//		String strTempFrom = request.getParameter("tempFrom");
			//		String strTempTo = request.getParameter("tempTo");

			//チェックボックス
			String checked = request.getParameter("checkbox");

			//DBから呼び出し
			RecordDAO dao = new RecordDAO();
			List<RecordBean> recordList;

			//チェックボックス確認
			if (checked != "") {
				recordList = dao.findAll(user_id); //すべてのデータ呼び出し
				request.setAttribute("recordList", recordList);
			} else if (checked == "") {
				recordList = dao.findByDate();
				request.setAttribute("recordList", recordList);
			}

			//失敗時
			request.setAttribute("msg", msg);

			//記録一覧画面へフォワード
			String forwardPath = null;
			forwardPath = "/WEB-INF/jsp/recordList.jsp?no=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}

}
