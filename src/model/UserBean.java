package model;

public class UserBean {
private String user_id, user_name, pass;

public UserBean() {

}

public UserBean(String user_id, String user_name, String pass) {
	this.user_id = user_id;
	this.user_name = user_name;
	this.pass = pass;
}


public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public String getUser_name() {
	return user_name;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}


}
