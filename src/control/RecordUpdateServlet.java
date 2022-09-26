package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;
import model.Errcheck;

/**
 *UPDATEコントローラー
 */
@WebServlet("/recordUpdate")
public class RecordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Errcheck errcheck = new Errcheck();
		String msg = "";

		String height = request.getParameter("height");
		msg = errcheck.heightCheck(height);

		String weight = request.getParameter("weight");
		msg = errcheck.weightCheck(weight);

		String temp = request.getParameter("temp");
		msg = errcheck.tempCheck(temp);

		if (!msg.isEmpty()) {
			//失敗時
			request.setAttribute("msg", msg);

			String forwardPath = null;
			forwardPath = "/recordChange";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);

		} else {
			//成功時
			request.setCharacterEncoding("UTF-8");

			int id = Integer.parseInt(request.getParameter("id"));
			double height1 = Double.parseDouble(request.getParameter("height"));
			double weight1 = Double.parseDouble(request.getParameter("weight"));
			double temp1 = Double.parseDouble(request.getParameter("temp"));
			String note = request.getParameter("note");

			//		ArrayList<RecordBean> rcBean = new ArrayList<RecordBean>();
			RecordDAO rcDao = new RecordDAO();
			rcDao.update(id, height1, weight1, temp1, note);

			//		request.setAttribute("rcBean", rcBean);

			//記録一覧画面へリダイレクト
			response.sendRedirect("/recordList");
		}

	}

}
