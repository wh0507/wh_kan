package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RecordBean;
import model.RecordDAO;

@WebServlet("/recordInsert")
public class RecordInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		//失敗時
		//		String forwardPath = null;
		//		forwardPath = "/recordInput";
		//		//MainMenuへフォワード
		//		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		//		dispatcher.forward(request, response);

		//HttpSessionインスタンス取得
		HttpSession session = request.getSession();

		//セッションスコープからインスタンスを取得
		RecordBean rcBean = (RecordBean) session.getAttribute("rcBean");
		//		int id = rcBean.getId();
		//		String userId = rcBean.getUserId();
		//		Date date = rcBean.getInputDate();
		//		double height = rcBean.getHeight();
		//		double weight = rcBean.getWeight();
		//		String text = rcBean.getText();

		//DBへ保存
		RecordDAO rcDao = new RecordDAO();
		 int result = rcDao.insert(rcBean);

		//成功時
		response.sendRedirect("/recordList");

	}

}
