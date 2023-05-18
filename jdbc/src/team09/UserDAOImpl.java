package team09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public int insertUser(UserDTO user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "insert into USER_INFO values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getUSER_NO());
			pstmt.setString(2, user.getUSER_ID());
			pstmt.setString(3, user.getUSER_PW());
			pstmt.setString(4, user.getUSER_NAME());
			pstmt.setString(5, user.getUSER_EMAIL());

			rows = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error) insertUser() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public int updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "update USER_INFO set USER_NO=?, USER_ID=?, USER_PW=?, USER_NAME=?, USER_EMAIL=? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getUSER_NO());
			pstmt.setString(2, user.getUSER_ID());
			pstmt.setString(3, user.getUSER_PW());
			pstmt.setString(4, user.getUSER_NAME());
			pstmt.setString(5, user.getUSER_EMAIL());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error) updateUser() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public int deleteUser(int user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "delete from user where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user);

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error) deleteUser() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public UserDTO selectUser(int USER_NO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO user = null;

		try {
			con = getConnection();

			String sql = "select * from USER_INFO where USER_NO=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, USER_NO);

			rs = pstmt.executeQuery();

			// ResultSet 객체에 저장된 검색행을 Java 객체로 매핑 처리
			if (rs.next()) { // 검색행이 있는 경우
				user = new UserDTO();
				// 처리행의 컬럼값을 반환받아 DTO 객체의 필드값으로 변경
				user.setUSER_NO(rs.getInt("USER_NO"));
				user.setUSER_ID(rs.getString("USER_ID"));
				user.setUSER_PW(rs.getString("USER_PW"));
				user.setUSER_NAME(rs.getString("USER_NAME"));
				user.setUSER_EMAIL(rs.getString("USER_EMAIL").substring(0, 10));

			}
		} catch (SQLException e) {
			System.out.println("error) selectUser() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {
			close(con, pstmt, rs);
		}
		// 검색행이 없는 경우[NULL], 있는경우 DTO 객체 반환 -> 하나의 검색행 반환
		return user;
	}

	@Override
	public List<UserDTO> selectNameUserList(String USER_NAME) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDTO> UserList = new ArrayList<>();

		try {
			con = getConnection();

			String sql = "select * from USER_INFO where USER_NAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, USER_NAME);

			rs = pstmt.executeQuery();

			// 검색행이 0개 이상인 경우 반복문 사용
			while (rs.next()) {
				// 하나의 검색행을 DTO 객체로 매핑 처리
				UserDTO user = new UserDTO();

				user.setUSER_NO(rs.getInt("USER_NO"));
				user.setUSER_ID(rs.getString("USER_ID"));
				user.setUSER_PW(rs.getString("USER_PW"));
				user.setUSER_NAME(rs.getString("USER_NAME"));
				user.setUSER_EMAIL(rs.getString("USER_EMAIL").substring(0, 10));

				// DTO 객체를 List 객체의 요소로 추가
				UserList.add(user);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNameStudentList() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return UserList;
	}

	@Override
	public List<UserDTO> selectAllUserList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDTO> UserList = new ArrayList<>();

		try {
			con = getConnection();

			String sql = "select * from USER_INFO order by USER_NO";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 검색행이 0개 이상인 경우 반복문 사용
			while (rs.next()) {
				// 하나의 검색행을 DTO 객체로 매핑 처리
				UserDTO user = new UserDTO();
				user.setUSER_NO(rs.getInt("USER_NO"));
				user.setUSER_ID(rs.getString("USER_ID"));
				user.setUSER_PW(rs.getString("USER_PW"));
				user.setUSER_NAME(rs.getString("USER_NAME"));
				user.setUSER_EMAIL(rs.getString("USER_EMAIL").substring(0, 10));

				// DTO 객체를 List 객체의 요소로 추가
				UserList.add(user);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudentList() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}

		return UserList;
	}

}