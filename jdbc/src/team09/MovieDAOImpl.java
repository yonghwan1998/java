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

			String sql = "select * from MOVIE_INFO where MOVIE_TITLE like '%'||?||'%' order by MOVIE_NO";
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

}
