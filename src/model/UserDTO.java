package model;

//UserBeans
public class UserDTO {
	private String userId;
	private String userName;
	private String pass;

	public UserDTO() {

	}

	/**
	 * @param userId
	 * @param userName
	 * @param pass
	 */
	public UserDTO(String userId, String userName, String pass) {
		this.userId = userId;
		this.userName = userName;
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
