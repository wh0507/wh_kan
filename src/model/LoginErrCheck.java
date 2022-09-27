package model;

public class LoginErrCheck {

	public static void main(String[] args) {

	}

	String msg = "";

	public String userIdCheck(String userId) {

		if(userId.isEmpty()) {
			msg += "ユーザーIDを入力して下さい。<br>";
		}

		return msg;
	}

}
