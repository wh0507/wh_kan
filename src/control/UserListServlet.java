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

import dao.UserDao;
import model.UserBean;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if(session.getAttribute("user_name") == null) {
			String msg = "ログイン状態ではありません。再度ログインしてください。";
			session.setAttribute("msg", msg);
			response.sendRedirect("/login");
			
		}else {
			UserDao userDao = new UserDao();
			//一覧取得
			List<UserBean> list = userDao.find_user();

			session.setAttribute("list", list);

			String forwardPath = null;
			forwardPath = "/WEB-INF/jsp/userList.jsp?no=4";
			//MainMenuへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("user_name") == null) {
			String msg = "ログイン状態ではありません。再度ログインしてください。";
			session.setAttribute("msg", msg);
			response.sendRedirect("/login");
		}else {

			request.setCharacterEncoding("UTF-8");
			String forwardPath = null;
			forwardPath = "/WEB-INF/jsp/mainMenu.jsp?no=0";
			//MainMenuへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}

}
