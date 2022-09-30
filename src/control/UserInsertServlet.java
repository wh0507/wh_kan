package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User_Erroer;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/userInsert")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String forwardPath = null;
		forwardPath = "/WEB-INF/jsp/userList.jsp?no=4";
		//MainMenuへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String pass = request.getParameter("pass");

		String msg = "";

		User_Erroer E = new User_Erroer();


		//ログインチェック追加（arakawa）
		HttpSession session = request.getSession();

		if(session.getAttribute("user_name") == null) {
			msg = "ログイン状態ではありません。再度ログインしてください。";
			session.setAttribute("msg", msg);
			response.sendRedirect("/login");
		}else {
			//空欄チェック
			msg = E.empty_check(user_id, user_name, pass);

			if(msg.isEmpty() || msg == null) {

				try {
					UserDao uDao = new UserDao();
					//IDの重複チェック
					msg = uDao.user_id_check(user_id);
					if(msg.isEmpty() || msg == null) {
						//新規登録処理
						uDao.insert(user_id, user_name, pass);
						response.sendRedirect("/userList");
					}else {
						request.setAttribute("msg", msg);
						session.setAttribute("user_id", user_id);
						session.setAttribute("user_name", user_name);
						session.setAttribute("pass", pass);

						String forwardPath = null;
						forwardPath = "/userInput";
						//記録入力画面へフォワード
						RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
						dispatcher.forward(request, response);
					}


				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}else {

				String forwardPath = null;
				request.setAttribute("msg", msg);
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_name", user_name);
				session.setAttribute("pass", pass);


				forwardPath = "/userInput";
				//記録入力画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);

			}
		}

	}
}
