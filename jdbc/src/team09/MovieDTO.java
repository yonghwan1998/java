package team09;

public class MovieDTO {

	private int MOVIE_NO;
	private String MOVIE_TITLE;
	private String MOVIE_GENRE;
	private String MOVIE_TIME;
	private String MOVIE_COUNTRY;
	private String MOVIE_DIRECTOR;

	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}

	public MovieDTO(int mOVIE_NO, String mOVIE_TITLE, String mOVIE_GENRE, String mOVIE_TIME, String mOVIE_COUNTRY,
			String mOVIE_DIRECTOR) {
		super();
		MOVIE_NO = mOVIE_NO;
		MOVIE_TITLE = mOVIE_TITLE;
		MOVIE_GENRE = mOVIE_GENRE;
		MOVIE_TIME = mOVIE_TIME;
		MOVIE_COUNTRY = mOVIE_COUNTRY;
		MOVIE_DIRECTOR = mOVIE_DIRECTOR;
	}

	public int getMOVIE_NO() {
		return MOVIE_NO;
	}

	public void setMOVIE_NO(int mOVIE_NO) {
		MOVIE_NO = mOVIE_NO;
	}

	public String getMOVIE_TITLE() {
		return MOVIE_TITLE;
	}

	public void setMOVIE_TITLE(String mOVIE_TITLE) {
		MOVIE_TITLE = mOVIE_TITLE;
	}

	public String getMOVIE_GENRE() {
		return MOVIE_GENRE;
	}

	public void setMOVIE_GENRE(String mOVIE_GENRE) {
		MOVIE_GENRE = mOVIE_GENRE;
	}

	public String getMOVIE_TIME() {
		return MOVIE_TIME;
	}

	public void setMOVIE_TIME(String mOVIE_TIME) {
		MOVIE_TIME = mOVIE_TIME;
	}

	public String getMOVIE_COUNTRY() {
		return MOVIE_COUNTRY;
	}

	public void setMOVIE_COUNTRY(String mOVIE_COUNTRY) {
		MOVIE_COUNTRY = mOVIE_COUNTRY;
	}

	public String getMOVIE_DIRECTOR() {
		return MOVIE_DIRECTOR;
	}

	public void setMOVIE_DIRECTOR(String mOVIE_DIRECTOR) {
		MOVIE_DIRECTOR = mOVIE_DIRECTOR;
	}

	@Override
	public String toString() {
		return MOVIE_NO + "\t" + MOVIE_TITLE + "\t" + MOVIE_GENRE + "\t" + MOVIE_TIME + "\t" + MOVIE_COUNTRY + "\t"
				+ MOVIE_DIRECTOR;
	}

}
