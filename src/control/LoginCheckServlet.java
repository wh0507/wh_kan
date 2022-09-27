package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.LoginErrCheck;
import model.UserDTO;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		//ユーザーエラーチェック
		LoginErrCheck errCheck = new LoginErrCheck();
		errCheck.userIdCheck(userId);



		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);
		dto.setPass(pass);
		UserDTO result = dao.loginAction(dto);

		HttpSession session = request.getSession();
		if (result != null && result.getUserName() != null) {
			//成功時
			session.setAttribute("userId", result.getUserId());
			session.setAttribute("userName", result.getUserName());
			response.sendRedirect("/mainMenu");
		} else {
			//失敗時
			String forwardPath = null;
			forwardPath = "/login";
			//ログイン画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}

	}

}
