package team09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl extends JdbcDAO implements UserDAO {

	private static UserDAOImpl _dao;

	static {
		_dao = new UserDAOImpl();
	}

	public static UserDAOImpl getDao() {
		return _dao;
	}

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	// 로그인
	@Override
	public UserDTO selectUser(String id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO user = null;
		try {
			con = getConnection();

			String sql = "select * from USER_INFO where USER_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new UserDTO();

				user.setUSER_NO(rs.getInt("USER_NO"));
				user.setUSER_ID(rs.getString("USER_ID"));
				user.setUSER_PW(rs.getString("USER_PW"));
				user.setUSER_NAME(rs.getString("USER_NAME"));
				user.setUSER_EMAIL(rs.getString("USER_EMAIL"));

			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return user;
	}

	// 회원가입
	@Override
	public int insertUser(UserDTO user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "insert into USER_INFO(USER_NO, USER_ID, USER_PW, USER_NAME, USER_EMAIL) values(NO_SEQ.NEXTVAL, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getUSER_ID());
			pstmt.setString(2, user.getUSER_PW());
			pstmt.setString(3, user.getUSER_NAME());
			pstmt.setString(4, user.getUSER_EMAIL());

			rows = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error) insertUser() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {
			close(con, pstmt);
		}
		return rows;
	}

}