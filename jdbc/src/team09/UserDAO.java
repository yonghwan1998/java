package team09;

public interface UserDAO {

	// 로그인
	UserDTO selectUser(String id);

	// 회원가입
	int insertUser(UserDTO user);

}
