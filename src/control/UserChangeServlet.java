package control;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class UserChangeServlet
 */
@WebServlet("/userChange")
public class UserChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserChangeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//ログインチェック追加（arakawa）
		HttpSession session = request.getSession();

		if(session.getAttribute("user_name") == null) {
			String msg = "ログイン状態ではありません。再度ログインしてください。";
			session.setAttribute("msg", msg);
			response.sendRedirect("/login");
		}else {
			try {
				String user_id = request.getParameter("user_id");
				UserDao DAO = new UserDao();

				//IDで絞込、リストに格納
				List<UserBean> list_id = DAO.selectID(user_id);
				session.setAttribute("list_id", list_id);

				String forwardPath = null;
				forwardPath = "/WEB-INF/jsp/userChange.jsp?no=6";
				//記録入力画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

}
