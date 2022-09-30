package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import dao.RecordDAO;

public class Errcheck {

	String msg = "";

	//日付検索のチェック
	public String searchDateCheck(String date) {

		if (date.contains("d")) {
			msg += "日付を選択して下さい。<br>";
			return msg;
		}

		ArrayList<RecordBean> recordList = new ArrayList<>();
		RecordDAO dao = new RecordDAO();
		recordList = dao.findByDate();

		for (int i = 0; i < recordList.size(); i++) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.parse(date, formatter);
			if (recordList.get(i).getInputDate().equals(localDate)) {

				msg += "日付のデータあり<br>";
				return msg;
			}
		}
		msg += "日付は存在する日付を入力してください。<br>";

		return msg;

	}

	//日付チェック
	public String dateCheck(String date) {

		String pattern = "^[0-9]{4}/[0-9]{2}/[0-9]{2}$";
		boolean matDate = Pattern.matches(pattern, date);

		if (date.isEmpty() == true) {
			msg += "日付を入力して下さい。<br>";
			return msg;
		}

		if (matDate == false) {
			msg += "日付は年月日(yyyy/MM/dd)の形式で入力してください。<br>";
			return msg;
		}

		ArrayList<RecordBean> list = new ArrayList<>();
		RecordDAO dao = new RecordDAO();
//		list = dao.findAll(user_id);
		//保存されているデータと比較

		try {
			for (int i = 0; i < list.size(); i++) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.parse(date, formatter);
				if (list.get(i).getInputDate().equals(localDate)) {
					msg += "日付は既に記録されています。別の日付で入力してください。<br>";
				}
			}
		} catch (Exception e) {
			msg += "日付は存在する日付を入力してください。<br>";
		}

		return msg;
	}

	//身長チェック
	public String heightCheck(String height) {

		String pattern = "^([1-9][0-9]{0,2}|0)(?:\\.\\d{1}+)?";
		boolean matHeight = Pattern.matches(pattern, height);

		if (height.isEmpty() == true) {
			msg += "身長を入力して下さい。<br>";
			return msg;
		}

		if (matHeight == false) {
			msg += "身長は半角数値(整数部3桁まで小数部1位まで)で入力して下さい。<br>";
		}
		return msg;
	}

	//体重チェック
	public String weightCheck(String weight) {

		String pattern = "^([1-9][0-9]{0,2}|0)(?:\\.\\d{1}+)?";
		boolean matWeight = Pattern.matches(pattern, weight);

		if (weight.isEmpty() == true) {
			msg += "体重を入力して下さい。<br>";
			return msg;
		}

		if (matWeight == false) {
			msg += "体重は半角数値(整数部3桁まで小数部1位まで)で入力して下さい。<br>";
		}
		return msg;
	}

	//体温チェック
	public String tempCheck(String temp) {

		String pattern = "^([1-9][0-9]{0,1}|0)(?:\\.\\d{1}+)?";
		boolean matTemp = Pattern.matches(pattern, temp);
		if (temp.isEmpty() == true) {
			msg += "体温を入力して下さい。<br>";
			return msg;
		}
		if (matTemp == false) {
			msg += "体温は半角数値(整数部2桁まで小数部1位まで)で入力して下さい。<br>";
		}
		return msg;
	}

	//ログインのエラー処理のため実装（s_arakawa）
	public String login_null_check(String userId, String pass) {
		String msg = "";

		if(userId.isEmpty() || userId == null) {
			msg = "ユーザーIDを入力してください";
		}else if(pass.isEmpty() || pass == null) {
			msg = "パスワードを入力してください";
		}

		return msg;
	}

}
