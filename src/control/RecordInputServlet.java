package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 記録入力コントローラー
 */
@WebServlet("/recordInput")
public class RecordInputServlet extends HttpServlet {
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

			String forwardPath = null;
			forwardPath = "/WEB-INF/jsp/recordInput.jsp?no=2";
			//記録入力画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}

}
