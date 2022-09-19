package control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RecordBean;
import model.RecordDAO;

@WebServlet("/recordInsert")
public class RecordInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		//失敗時
		//		String forwardPath = null;
		//		forwardPath = "/recordInput";
		//		//MainMenuへフォワード
		//		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		//		dispatcher.forward(request, response);

		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータを取得
		String date = request.getParameter("date");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String temperature = request.getParameter("temperature");
		String note = request.getParameter("note");

		//入力値をプロパティに設定
		RecordBean rcBean = new RecordBean();
		rcBean.setUserId("admin");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		rcBean.setInputDate(localDate); //LocalDate typeに変更

		rcBean.setHeight(Double.parseDouble(height));
		rcBean.setWeight(Double.parseDouble(weight));
		rcBean.setTemperature(Double.parseDouble(temperature));
		rcBean.setNote(note);

		//DBへ保存
		RecordDAO rcDao = new RecordDAO();
		rcDao.insert(rcBean);

		//成功時
		response.sendRedirect("/recordList");
	}

}
