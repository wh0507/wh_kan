package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBean;

/**
 * Servlet implementation class UserDeleatServlet
 */
@WebServlet("/userDelete")
public class UserDeleatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleatServlet() {
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

		UserBean uBean = new UserBean();
		String user_id = request.getParameter("user_id");
		uBean.setUser_id(user_id);
		UserDao Dao = new UserDao();

		//削除メソッド呼び出し
		Dao.Delete(uBean.getUser_id());
		//同じユーザーIDをheight_weight_recordから削除
		Dao.delete_user_all(user_id);

		response.sendRedirect("/userList");
	}

}
