package control;

import java.io.IOException;

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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession();

		//空欄チェック
		msg = E.empty_check(user_name, pass);

		if(msg.isEmpty() || msg == null) {

			msg = E.userName_check(user_name);
			msg = E.pass_check(pass);

			if(msg.isEmpty() || msg == null) {
				UserDao DAO= new UserDao();
				//更新処理
				DAO.update(user_id, user_name, pass);

				response.sendRedirect("/userList");
			}else {
				request.setAttribute("msg", msg);

				session.setAttribute("user_name", user_name);
				session.setAttribute("pass", pass);

				String forwardPath = null;
				forwardPath = "/WEB-INF/jsp/userChange.jsp";
				//記録入力画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
			}


		}else {

			request.setAttribute("msg", msg);
			session.setAttribute("user_name", user_name);
			session.setAttribute("pass", pass);

			String forwardPath = null;
			forwardPath = "/WEB-INF/jsp/userChange.jsp?no=6";
			//記録入力画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);

		}

	}

}
