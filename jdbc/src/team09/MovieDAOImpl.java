package team09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl extends JdbcDAO implements MovieDAO {
	private static MovieDAOImpl _dao;

	static {
		_dao = new MovieDAOImpl();
	}

	public static MovieDAOImpl getDao() {
		return _dao;
	}

	public MovieDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MovieDTO> selectTitleMoiveList(String name) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieDTO> movieList = new ArrayList<>();
		try {
			con = getConnection();

			String sql = "select * from MOVIE_INFO where REPLACE(MOVIE_TITLE,' ', '') like '%'||?||'%' order by MOVIE_NO";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieDTO movie = new MovieDTO();
				movie.setMOVIE_NO(rs.getInt("MOVIE_NO"));
				movie.setMOVIE_TITLE(rs.getString("MOVIE_TITLE"));
				movie.setMOVIE_GENRE(rs.getString("MOVIE_GENRE"));
				movie.setMOVIE_TIME(rs.getString("MOVIE_TIME"));
				movie.setMOVIE_COUNTRY(rs.getString("MOVIE_COUNTRY"));
				movie.setMOVIE_DIRECTOR(rs.getString("MOVIE_DIRECTOR"));

				movieList.add(movie);

			}
		} catch (SQLException e) {
			System.out.println("[에러]selectTitleMoiveList() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}

		return movieList;
	}

	@Override
	public List<MovieDTO> selectAllMovieList() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieDTO> movieList = new ArrayList<>();
		try {
			con = getConnection();

			String sql = "select * from MOVIE_INFO order by MOVIE_NO";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieDTO movie = new MovieDTO();
				movie.setMOVIE_NO(rs.getInt("MOVIE_NO"));
				movie.setMOVIE_TITLE(rs.getString("MOVIE_TITLE"));
				movie.setMOVIE_GENRE(rs.getString("MOVIE_GENRE"));
				movie.setMOVIE_TIME(rs.getString("MOVIE_TIME"));
				movie.setMOVIE_COUNTRY(rs.getString("MOVIE_COUNTRY"));
				movie.setMOVIE_DIRECTOR(rs.getString("MOVIE_DIRECTOR"));

				movieList.add(movie);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudentList() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return movieList;
	}

	@Override

	public int insertMovie(MovieDTO movie) {

		Connection con = null;

		PreparedStatement pstmt = null;

		int rows = 0;

		try {

			con = getConnection();

			String sql = "insert into MOVIE_INFO(MOVIE_NO,MOVIE_TITLE, MOVIE_GENRE, MOVIE_TIME, MOVIE_COUNTRY, MOVIE_DIRECTOR) values(MOVIE_SEQ.NEXTVAL, ?, ?, ?, ?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, movie.getMOVIE_TITLE());

			pstmt.setString(2, movie.getMOVIE_GENRE());

			pstmt.setString(3, movie.getMOVIE_TIME());

			pstmt.setString(4, movie.getMOVIE_COUNTRY());

			pstmt.setString(5, movie.getMOVIE_DIRECTOR());

			rows = pstmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println("error) insertMovie() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {

			close(con, pstmt);

		}

		return rows;

	}

	@Override
	public int updateMovie(MovieDTO movie) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		// List<MovieDTO> movieList = new ArrayList<>();
		int movieList = 0;

		try {
			con = getConnection();

			String sql = "update MOVIE_INFO set MOVIE_TITLE=?, MOVIE_GENRE=?, MOVIE_TIME=?, MOVIE_COUNTRY=?, MOVIE_DIRECTOR=? where MOVIE_NO=?";
			pstmt = con.prepareStatement(sql);
			// pstmt.setInt(1, movieList.getUSER_NO());
			pstmt.setString(1, movie.getMOVIE_TITLE());
			pstmt.setString(2, movie.getMOVIE_GENRE());
			pstmt.setString(3, movie.getMOVIE_TIME());
			pstmt.setString(4, movie.getMOVIE_COUNTRY());
			pstmt.setString(5, movie.getMOVIE_DIRECTOR());
			pstmt.setInt(6, movie.getMOVIE_NO());

			movieList = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error) updateUser() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {
			close(con, pstmt);
		}
		return movieList;
	}

	@Override
	public MovieDTO selectMovie(String no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MovieDTO movie = null;
		try {
			con = getConnection();

			String sql = "select * from MOVIE_INFO where MOVIE_NO = ? order by MOVIE_NO";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				movie = new MovieDTO();
				movie.setMOVIE_NO(rs.getInt("MOVIE_NO"));
				movie.setMOVIE_TITLE(rs.getString("MOVIE_TITLE"));
				movie.setMOVIE_GENRE(rs.getString("MOVIE_GENRE"));
				movie.setMOVIE_TIME(rs.getString("MOVIE_TIME"));
				movie.setMOVIE_COUNTRY(rs.getString("MOVIE_COUNTRY"));
				movie.setMOVIE_DIRECTOR(rs.getString("MOVIE_DIRECTOR"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudentList() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return movie;
	}

	@Override

	public int deleteMovie(int movie) {

		Connection con = null;

		PreparedStatement pstmt = null;

		int rows = 0;

		try {

			con = getConnection();

			String sql = "delete from MOVIE_INFO where MOVIE_NO=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, movie);

			rows = pstmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println("error) deleteMovie() 메소드의 SQL 오류 = " + e.getMessage());

		} finally {

			close(con, pstmt);

		}

		return rows;

	}

}
