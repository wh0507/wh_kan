package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecordDAO;
import model.RecordBean;

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

		//ログインチェック追加（arakawa）
		HttpSession session = request.getSession();

		if(session.getAttribute("user_name") == null) {
			String msg = "ログイン状態ではありません。再度ログインしてください。";
			session.setAttribute("msg", msg);
			response.sendRedirect("/login");
		}else {

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

}
