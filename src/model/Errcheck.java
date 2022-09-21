package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Errcheck {

	String msg = "";

	//dateCheck
	public String dateCheck(String date) {

		String pattern = "^[0-9]{4}/[0-9]{2}/[0-9]{2}$";
		boolean matDate = Pattern.matches(pattern, date);

		if (date.isEmpty() == true) {
			msg = "日付を入力してください。";
			return msg;
		}

		if (matDate == false) {
			msg = "日付は年月日(yyyy/MM/dd)の形式で入力してください。";
			return msg;
		}

		ArrayList<RecordBean> list = new ArrayList<>();
		RecordDAO dao = new RecordDAO();
		list = dao.findAll();
		for (int i = 0; i < list.size(); i++) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.parse(date, formatter);
			if (list.get(i).getInputDate().equals(localDate)) {
				msg = "日付は既に記録されています。別の日付で入力してください。";
			}
		}

		return msg;
	}

	//heightCheck
	public String heightCheck(String height) {

		String pattern = "^[1-9]{1}[0-9]{1,2}\\.[0-9]{1}?$";
		boolean matHeight = Pattern.matches(pattern, height);

		if (height.isEmpty() == true) {
			msg = "身長を入力してください。";
			return msg;
		}

		if (matHeight == false) {
			msg = "身長は半角数値(整数部3桁まで小数部1位まで)で入力してください。";
		}
		return msg;
	}

	//weightCheck
	public String weightCheck(String weight) {

		String pattern = "^[1-9]{1}[0-9]{1,2}\\.[0-9]{1}?$";
		boolean matWeight = Pattern.matches(pattern, weight);

		if (weight.isEmpty() == true) {
			msg = "体重を入力してください。";
			return msg;
		}

		if (matWeight == false) {
			msg = "体重は半角数値(整数部3桁まで小数部1位まで)で入力してください。";
		}
		return msg;
	}

	//tempeCheck
	public String tempCheck(String temp) {

		String pattern = "^[1-9]{1}[0-9]{1}\\.[0-9]{1}?$";
		boolean matTemp = Pattern.matches(pattern, temp);
		if (temp.isEmpty() == true) {
			msg = "体温を入力してください。";
			return msg;
		}
		if (matTemp == false) {
			msg = "体温は半角数値(整数部2桁まで小数部1位まで)で入力してください。";
		}
		return msg;
	}

}
