package control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Errcheck;
import model.RecordBean;
import model.RecordDAO;

@WebServlet("/recordInsert")
public class RecordInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Errcheck errcheck = new Errcheck();
		String msg = "";
		//リクエストパラメータを取得
		String date = request.getParameter("date");
		//		msg = errcheck.dateCheck(date);

		String height = request.getParameter("height");
		//		msg = errcheck.heightCheck(height);

		String weight = request.getParameter("weight");
		//		msg = errcheck.weightCheck(weight);

		String temp = request.getParameter("temp");
		//		msg = errcheck.tempCheck(temp);

		String note = request.getParameter("note");

		//		//失敗時
		//		String forwardPath = null;
		//		forwardPath = "/recordInput";
		//		//MainMenuへフォワード
		//		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		//		dispatcher.forward(request, response);

		//入力値をプロパティに設定
		RecordBean rcBean = new RecordBean();
		rcBean.setUserId("admin");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.parse(date, formatter); //

		rcBean.setInputDate(localDate); //LocalDate typeに変更
		rcBean.setHeight(Double.parseDouble(height));
		rcBean.setHeight(Double.parseDouble(height));
		rcBean.setWeight(Double.parseDouble(weight));
		rcBean.setTemperature(Double.parseDouble(temp));
		rcBean.setNote(note);

		//DBへ保存
		RecordDAO rcDao = new RecordDAO();
		rcDao.insert(rcBean);

		//成功時
		response.sendRedirect("/recordList");

	}

}
