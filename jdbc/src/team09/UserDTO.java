package team09;

public class UserDTO {
	private int USER_NO;
	private String USER_ID;
	private String USER_PW;
	private String USER_NAME;
	private String USER_EMAIL;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int uSER_NO, String uSER_ID, String uSER_PW, String uSER_NAME, String uSER_EMAIL) {
		super();
		USER_NO = uSER_NO;
		USER_ID = uSER_ID;
		USER_PW = uSER_PW;
		USER_NAME = uSER_NAME;
		USER_EMAIL = uSER_EMAIL;
	}

	public int getUSER_NO() {
		return USER_NO;
	}

	public void setUSER_NO(int uSER_NO) {
		USER_NO = uSER_NO;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PW() {
		return USER_PW;
	}

	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	@Override
	public String toString() {
		return USER_NO + "\t" + USER_ID + "\t" + USER_PW + "\t" + USER_PW + "\t" + USER_EMAIL;
	}
	
}
