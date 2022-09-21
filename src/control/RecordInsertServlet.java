package control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Errcheck errcheck = new Errcheck();
		String msg = "";

		List<String> msgList = new ArrayList<String>();

		//リクエストパラメータを取得
		String date = request.getParameter("date");
		msg = errcheck.dateCheck(date);
		if (!msg.isEmpty() == true) {
			msgList.add(msg);
		}

		String height = request.getParameter("height");
		if (height.indexOf(".") == -1) {
			height += ".0";
		}

		if (height.isEmpty() || height != null) {
			msg = errcheck.heightCheck(height);
			msgList.add(msg);
		}

		String weight = request.getParameter("weight");
		if (weight.indexOf(".") == -1) {
			weight += ".0";
		}
		if (weight.isEmpty() || weight != null) {
			msg = errcheck.weightCheck(weight);
			msgList.add(msg);
		}

		String temp = request.getParameter("temp");
		if (temp.indexOf(".") == -1) {
			temp += ".0";
		}
		if (temp.isEmpty() || temp != null) {
			msg = errcheck.tempCheck(temp);
			msgList.add(msg);
		}

		String note = request.getParameter("note");
		if (temp == null) {
			note = "";
			msgList.add(msg);
		}

		if (msgList.isEmpty() == false) {
			//失敗時
			request.setAttribute("msgList", msgList);

			String forwardPath = null;
			forwardPath = "/recordInput";
			//MainMenuへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		} else {
			doPost(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//		//リクエストパラメータを取得
		String date = request.getParameter("date");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String temp = request.getParameter("temp");
		String note = request.getParameter("note");

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
