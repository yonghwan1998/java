package team09;

import java.util.List;

public interface MovieDAO {
	
	int insertMovie(MovieDTO movie);
	int updateMovie(MovieDTO movie);
	int deleteMovie(int movie);
	MovieDTO selectMovie(String id);
	
	
	List<MovieDTO> selectTitleMoiveList(String name);
	List<MovieDTO> selectAllMovieList();
}
