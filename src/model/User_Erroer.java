package model;

public class User_Erroer {

	//ボックスの空チェック（arakawa）
	public String empty_check(String user_id, String user_name, String pass) {
		String msg = "";

		if(user_id == null || user_id.isEmpty()) {
			msg += "ユーザーIDを入力して下さい。";
		}else {
			msg += userID_check(user_id);
		}

		if(user_name == null || user_name.isEmpty()) {
			msg += "ユーザー名を入力して下さい。";
		}else {
			msg += userName_check(user_name);

		}

		if(pass == null || pass.isEmpty()) {
			msg += "パスワードを入力して下さい。";
		}else {
			msg += pass_check(pass);
		}
		return msg;
	}

	//ユーザーIDバリデーションチェック（arakawa）
	public String userID_check(String user_id) {
		String msg = "";
		char [] chars = user_id.toCharArray();

		for(int i = 0; i < chars.length; i++) {
			if(String.valueOf(chars[i]).getBytes().length < 2) {
				msg = "";
			}else {
				msg = "ユーザーIDは半角英数字(10文字以内)で入力してください。";
			}
		}

		if(user_id.length() > 10 && msg.isEmpty()) {
			msg = "ユーザーIDは半角英数字(10文字以内)で入力してください。";
		}

		if(msg.isEmpty() || msg == null) {

		}

		return msg;
	}

	//ユーザー名バリデーションチェック（arakawa）
	public String userName_check(String user_name){
		String msg = "";

		if(user_name.length() > 255) {
			msg = "ユーザー名は255文字以内で入力して下さい。";
		}
		return msg;
	}

	//パスワードバリデーションチェック（arakawa）
	public String pass_check(String pass){
		String msg = "";
		char [] chars = pass.toCharArray();

		for(int i = 0; i < chars.length; i++) {
			if(String.valueOf(chars[i]).getBytes().length < 2) {
				msg = "";
			}else {
				msg = "パスワードは半角英数字(5文字以上10文字以下)で入力して下さい。";
			}
		}

		if((pass.length() < 5 || pass.length() > 10)) {
			msg = "パスワードは半角英数字(5文字以上10文字以下)で入力して下さい。";
		}

		return msg;
	}

	public String empty_check(String user_name, String pass) {
		String msg = "";

		if(user_name == null || user_name.isEmpty()) {
			msg += "ユーザー名を入力して下さい。";
		}else {
			msg += userName_check(user_name);

		}

		if(pass == null || pass.isEmpty()) {
			msg += "パスワードを入力して下さい。";
		}else {
			msg += pass_check(pass);
		}
		return msg;
	}





}
