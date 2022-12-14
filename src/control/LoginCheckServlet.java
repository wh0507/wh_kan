package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecordDAO;
import model.Errcheck;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		String msg = "";
		boolean bool = false;

		Errcheck errcheck = new Errcheck();

		//必須確認（arakawa）
		msg = errcheck.login_null_check(userId, pass);

		HttpSession session = request.getSession();

		if(msg.isEmpty() || msg == null) {
			RecordDAO dao = new RecordDAO();
			//妥当性確認（arakawa）
			bool = dao.login_check(userId, pass);

			if(bool == true){
				//セッションに格納（arakawa）
				session.setAttribute("userId", userId);
				session.setAttribute("pass", pass);
				session.setAttribute("user_name", dao.get_username(userId));
				response.sendRedirect("/mainMenu");

			}else {
				msg = "ユーザーID、またはパスワードが違います。";

				session.setAttribute("userId", userId);
				session.setAttribute("pass", pass);
				request.setAttribute("msg", msg);

				String forwardPath = null;
				forwardPath = "/WEB-INF/jsp/login.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
			}

		}else {
			//エラー表示用メッセージをリクエストに格納（arakawa）
			request.setAttribute("msg", msg);
			session.setAttribute("userId", userId);
			session.setAttribute("pass", pass);

			String forwardPath = null;
			forwardPath = "/WEB-INF/jsp/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}

	}

}
