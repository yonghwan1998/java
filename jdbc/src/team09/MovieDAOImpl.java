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
	public List<MovieDTO> selectAllMovieList() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieDTO> movieList = new ArrayList<>();
		try {
			con = getConnection();

			String sql = "select * from MOVIE_INFO order by no";
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
}
