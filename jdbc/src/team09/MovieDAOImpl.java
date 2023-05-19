package team09;

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
		// TODO Auto-generated method stub
		return null;
	}
}
