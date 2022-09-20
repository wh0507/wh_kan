package model;

import java.util.regex.Pattern;

public class Errcheck {

	//	public static void main(String[] args) {
	//		Errcheck e = new Errcheck();
	//		System.out.println(e.numCheck("abc", "abc"));
	//		System.out.println(e.numCheck("123", "abc"));
	//		System.out.println(e.numCheck("123", "-123"));
	//
	//	}
	public String numCheck(String id, String kakaku) {
		String msg = "";
		//		String pattern = "^[0-9０-９]+$"; //数字の場合
		String pattern = "^[0-9０-９]+$|-[0-9０-９]+$";
		boolean rId = Pattern.matches(pattern, id); //idが数字の場合　true
		boolean rKakaku = Pattern.matches(pattern, kakaku); //kakakuが数字の場合　true

		if (rId == false || rKakaku == false) {
			msg = "IDと価格には「数字」を入力してください";
		} else {
			msg = "IDと価格には「整数」を入力してください";
		}

		return msg;
	}

}
