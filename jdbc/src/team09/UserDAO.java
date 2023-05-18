package team09;

import java.util.List;

import xyz.itwill.student.StudentDTO;

public interface UserDAO {
	
	int insertUser(UserDTO user);
	int updateUser(UserDTO user);
	int deleteUser(int user);

	UserDTO selectUser(int USER_NO);
	
	List<UserDTO> selectNameUserList(String USER_NAME);

	List<UserDTO> selectAllUserList();
}
