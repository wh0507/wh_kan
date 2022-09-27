package control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;
import model.Errcheck;
import model.RecordBean;

@WebServlet("/recordInsert")
public class RecordInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Errcheck errcheck = new Errcheck(); //エラーチェック
		String msg = ""; //メッセージ

		//リクエストパラメータを取得
		String date = request.getParameter("date");
		msg = errcheck.dateCheck(date);

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
			forwardPath = "/recordInput";
			//記録入力画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		} else {
			//成功時
			doPost(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータを取得
		String date = request.getParameter("date");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String temp = request.getParameter("temp");
		String note = request.getParameter("note");

		//入力値をプロパティに設定
		RecordBean rcBean = new RecordBean();
		rcBean.setUserId("admin");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.parse(date, formatter);

		rcBean.setInputDate(localDate); //LocalDate typeに変更
		rcBean.setHeight(Double.parseDouble(height));
		rcBean.setHeight(Double.parseDouble(height));
		rcBean.setWeight(Double.parseDouble(weight));
		rcBean.setTemperature(Double.parseDouble(temp));
		rcBean.setNote(note);

		//DBへ保存
		RecordDAO rcDao = new RecordDAO();
		rcDao.insert(rcBean);

		//記録一覧画面へリダイレクト
		response.sendRedirect("/recordList");

	}

}
