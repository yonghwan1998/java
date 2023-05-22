package team09;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MoviePage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;

	JTextField MOVIE_NO_TF, MOVIE_TITLE_TF, MOVIE_GENRE_TF, MOVIE_COUNTRY_TF, MOVIE_TIME_TF, MOVIE_DIRECTOR_TF;
	JButton addB, deleteB, updateB, searchB, cancelB;

	JTable table;

	int cmd;

	public MoviePage() throws Exception {

		setTitle("◆◆◆ 영화 관리 프로그램 ◆◆◆");

		setSize(800, 400);

		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(6, 1));

		JPanel pMOVIE_No = new JPanel();
		pMOVIE_No.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel label = new JLabel("영화 번호");
		pMOVIE_No.add(label);
		pMOVIE_No.add(MOVIE_NO_TF = new JTextField(10));

		JPanel pMOVIE_Name = new JPanel();
		pMOVIE_Name.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel label_1 = new JLabel("영화제목");
		pMOVIE_Name.add(label_1);
		pMOVIE_Name.add(MOVIE_TITLE_TF = new JTextField(10));

		JPanel pMOVIE_Genre = new JPanel();
		pMOVIE_Genre.setLayout(null);
		JLabel label_2 = new JLabel("장르");
		label_2.setBounds(20, 13, 30, 15);
		pMOVIE_Genre.add(label_2);
		pMOVIE_Genre.add(MOVIE_GENRE_TF = new JTextField(10));
		MOVIE_GENRE_TF.setBounds(60, 8, 116, 21);

		JPanel pMOVIE_Time = new JPanel();
		pMOVIE_Time.setLayout(null);
		JLabel label_3 = new JLabel("상영시간");
		label_3.setBounds(5, 15, 52, 15);
		pMOVIE_Time.add(label_3);
		pMOVIE_Time.add(MOVIE_TIME_TF = new JTextField(10));
		MOVIE_TIME_TF.setBounds(60, 10, 116, 21);

		JPanel pMOVIE_Country = new JPanel();
		pMOVIE_Country.setLayout(null);
		JLabel label_4 = new JLabel("국가");
		label_4.setBounds(20, 15, 30, 15);
		pMOVIE_Country.add(label_4);
		pMOVIE_Country.add(MOVIE_COUNTRY_TF = new JTextField(10));
		MOVIE_COUNTRY_TF.setBounds(60, 10, 116, 21);

		JPanel pMOVIE_DIRECTOR = new JPanel();
		pMOVIE_DIRECTOR.setLayout(null);
		JLabel label_5 = new JLabel("감독");

		label_5.setBounds(20, 15, 30, 15);
		pMOVIE_DIRECTOR.add(label_5);
		pMOVIE_DIRECTOR.add(MOVIE_DIRECTOR_TF = new JTextField(10));
		MOVIE_DIRECTOR_TF.setBounds(60, 10, 116, 21);

		left.add(pMOVIE_No);
		left.add(pMOVIE_Name);
		left.add(pMOVIE_Genre);
		left.add(pMOVIE_Time);
		left.add(pMOVIE_Country);
		left.add(pMOVIE_DIRECTOR);

		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(addB = new JButton("등  록"));
		addB.setBackground(Color.BLACK);
		addB.setForeground(Color.WHITE);
		addB.setFont(new Font("Dialog", 1, 15));
		addB.addActionListener(this);

		bottom.add(updateB = new JButton("수  정"));
		updateB.setBackground(Color.BLACK);
		updateB.setForeground(Color.WHITE);
		updateB.setFont(new Font("Dialog", 1, 15));
		updateB.addActionListener(this);

		bottom.add(deleteB = new JButton("삭  제"));
		deleteB.setBackground(Color.BLACK);
		deleteB.setForeground(Color.WHITE);
		deleteB.setFont(new Font("Dialog", 1, 15));
		deleteB.addActionListener(this);

		bottom.add(searchB = new JButton("검  색"));
		searchB.setBackground(Color.BLACK);
		searchB.setForeground(Color.WHITE);
		searchB.setFont(new Font("Dialog", 1, 15));
		searchB.addActionListener(this);

		bottom.add(cancelB = new JButton("초기화"));
		cancelB.setBackground(Color.BLACK);
		cancelB.setForeground(Color.WHITE);
		cancelB.setFont(new Font("Dialog", 1, 15));
		cancelB.addActionListener(this);

		Object[] title = { "No", "영화제목", "장르", "상영시간", "국가", "감독" };

		table = new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(true);

		table.getColumn("No").setPreferredWidth(5);
		table.getColumn("영화제목").setPreferredWidth(150);
		table.getColumn("장르").setPreferredWidth(25);
		table.getColumn("상영시간").setPreferredWidth(10);
		table.getColumn("국가").setPreferredWidth(20);
		table.getColumn("감독").setPreferredWidth(20);

		JScrollPane sp = new JScrollPane(table);

		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		displayAllMovie();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void initialize() {
		MOVIE_NO_TF.setEditable(false);
		MOVIE_TITLE_TF.setEditable(false);
		MOVIE_GENRE_TF.setEditable(false);
		MOVIE_COUNTRY_TF.setEditable(false);
		MOVIE_TIME_TF.setEditable(false);
		MOVIE_DIRECTOR_TF.setEditable(false);
	}

	public void setEditable(int n) {
		switch (n) {
		case ADD:
			MOVIE_TITLE_TF.setEditable(true);
			MOVIE_GENRE_TF.setEditable(true);
			MOVIE_COUNTRY_TF.setEditable(true);
			MOVIE_TIME_TF.setEditable(true);
			MOVIE_DIRECTOR_TF.setEditable(true);
			break;
		case DELETE:
			MOVIE_NO_TF.setEditable(true);
			break;
		case UPDATE:
			MOVIE_NO_TF.setEditable(true);
			break;
		case UPDATE_CHANGE:
			MOVIE_NO_TF.setEditable(false);
			MOVIE_TITLE_TF.setEditable(true);
			MOVIE_GENRE_TF.setEditable(true);
			MOVIE_COUNTRY_TF.setEditable(true);
			MOVIE_TIME_TF.setEditable(true);
			MOVIE_DIRECTOR_TF.setEditable(true);
			break;
		case SEARCH:
			MOVIE_TITLE_TF.setEditable(true);
			break;
		case NONE:
			MOVIE_NO_TF.setEditable(false);
			MOVIE_TITLE_TF.setEditable(false);
			MOVIE_GENRE_TF.setEditable(false);
			MOVIE_COUNTRY_TF.setEditable(false);
			MOVIE_TIME_TF.setEditable(false);
			MOVIE_DIRECTOR_TF.setEditable(false);
		}
	}

	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD);
			cmd = ADD;
			break;
		case DELETE:
			deleteB.setEnabled(true);
			setEditable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			updateB.setEnabled(true);
			setEditable(UPDATE);
			cmd = UPDATE;
			break;
		case UPDATE_CHANGE:
			updateB.setEnabled(true);
			setEditable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;
		case SEARCH:
			searchB.setEnabled(true);
			setEditable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE:
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}

	public void clear() {
		MOVIE_NO_TF.setText("");
		MOVIE_TITLE_TF.setText("");
		MOVIE_GENRE_TF.setText("");
		MOVIE_COUNTRY_TF.setText("");
		MOVIE_TIME_TF.setText("");
		MOVIE_DIRECTOR_TF.setText("");
	}

	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();
	}

	public static void main(String[] args) throws Exception {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoviePage frame = new MoviePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {
				if (cmd != ADD) {
					setEnable(ADD);
				} else {

					addMovie();
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);

				} else if (cmd != UPDATE_CHANGE) {
					searchNoMovie();
				} else {

					modifyMovie();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {
					setEnable(DELETE);
				} else {

					removeMovie();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					searchTitleMovie();
				}
			} else if (c == cancelB) {
				displayAllMovie();
				initDisplay();
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}
	}

	public void displayAllMovie() {
		List<MovieDTO> MovieList = MovieDAOImpl.getDao().selectAllMovieList();

		if (MovieList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 movie정보가 없습니다.");
			return;
		}

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}

		for (MovieDTO movie : MovieList) {
			Vector<Object> rowData = new Vector<>();
			rowData.add(movie.getMOVIE_NO());
			rowData.add(movie.getMOVIE_TITLE());
			rowData.add(movie.getMOVIE_GENRE());
			rowData.add(movie.getMOVIE_TIME() + "분");
			rowData.add(movie.getMOVIE_COUNTRY());
			rowData.add(movie.getMOVIE_DIRECTOR());

			model.addRow(rowData);

		}

	}

	public void searchNoMovie() {
		String noTemp = MOVIE_NO_TF.getText();
		if (noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "영화 번호를 반드시 입력해 주세요.");
			MOVIE_NO_TF.requestFocus();
			return;
		}

		String noReg = "^[0-9]+$";
		if (!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "영화 번호는 숫자로만 입력해주세요.");
			MOVIE_NO_TF.requestFocus();
			return;
		}

		MovieDTO movie = MovieDAOImpl.getDao().selectMovie(noTemp);

		if (movie == null) {
			JOptionPane.showMessageDialog(this, "입력한 번호의 영화정보가 없습니다.");
			MOVIE_NO_TF.requestFocus();
			MOVIE_NO_TF.setText("");
			return;
		}

		MOVIE_NO_TF.setText(movie.getMOVIE_NO() + "");
		MOVIE_TITLE_TF.setText(movie.getMOVIE_TITLE());
		MOVIE_GENRE_TF.setText(movie.getMOVIE_GENRE());
		MOVIE_TIME_TF.setText(movie.getMOVIE_TIME());
		MOVIE_COUNTRY_TF.setText(movie.getMOVIE_COUNTRY());
		MOVIE_DIRECTOR_TF.setText(movie.getMOVIE_DIRECTOR());

		setEnable(UPDATE_CHANGE);
	}

	public void modifyMovie() {

		int MOVIE_NO = Integer.parseInt(MOVIE_NO_TF.getText());

		String MOVIE_TITLE = MOVIE_TITLE_TF.getText();

		if (MOVIE_TITLE.equals("")) {
			JOptionPane.showMessageDialog(this, "영화 제목을 반드시 입력해 주세요.");
			MOVIE_TITLE_TF.requestFocus();
			return;
		}

		String MOVIE_GENRE = MOVIE_GENRE_TF.getText();

		String MOVIE_TIME = MOVIE_TIME_TF.getText();

		String MOVIE_COUNTRY = MOVIE_COUNTRY_TF.getText();

		String MOVIE_DIRECTOR = MOVIE_DIRECTOR_TF.getText();

		MovieDTO movie = new MovieDTO();
		movie.setMOVIE_NO(MOVIE_NO);
		movie.setMOVIE_TITLE(MOVIE_TITLE);
		movie.setMOVIE_GENRE(MOVIE_GENRE);
		movie.setMOVIE_TIME(MOVIE_TIME);
		movie.setMOVIE_COUNTRY(MOVIE_COUNTRY);
		movie.setMOVIE_DIRECTOR(MOVIE_DIRECTOR);

		int movieList = MovieDAOImpl.getDao().updateMovie(movie);

		JOptionPane.showMessageDialog(this, movieList + "개의 영화 정보를 변경 하였습니다.");

		displayAllMovie();
		initDisplay();
	}

	public void searchTitleMovie() {

		String title = MOVIE_TITLE_TF.getText();

		title = title.replaceAll(" ", "");
		if (title.equals("")) {
			JOptionPane.showMessageDialog(this, "제목을 반드시 입력해 주세요.");
			MOVIE_TIME_TF.requestFocus();
			return;
		}

		List<MovieDTO> movieList = MovieDAOImpl.getDao().selectTitleMoiveList(title);

		if (movieList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "검색된 영화정보가 없습니다.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}

		for (MovieDTO movie : movieList) {
			Vector<Object> rowData = new Vector<>();

			rowData.add(movie.getMOVIE_NO());
			rowData.add(movie.getMOVIE_TITLE());
			rowData.add(movie.getMOVIE_GENRE());
			rowData.add(movie.getMOVIE_TIME());
			rowData.add(movie.getMOVIE_COUNTRY());
			rowData.add(movie.getMOVIE_DIRECTOR());

			model.addRow(rowData);
		}
	}

	public void removeMovie() {

		String movieNo = MOVIE_NO_TF.getText();

		if (movieNo.equals("")) {

			JOptionPane.showMessageDialog(this, "영화번호를 반드시 입력해 주세요.");

			MOVIE_NO_TF.requestFocus();
			return;
		}

		String movieNoReg = "^[0-9]+$";

		if (!Pattern.matches(movieNoReg, movieNo)) {

			JOptionPane.showMessageDialog(this, "영화번호는 숫자로만 입력해 주세요.");

			MOVIE_NO_TF.requestFocus();

			return;
		}

		int no = Integer.parseInt(movieNo);

		int rows = MovieDAOImpl.getDao().deleteMovie(no);

		if (rows > 0) {

			JOptionPane.showMessageDialog(this, rows + "개의 영화정보를 삭제 하였습니다.");

			displayAllMovie();

		} else {

			JOptionPane.showMessageDialog(this, "삭제할 영화의 영화번호가 없습니다.");
		}

		initDisplay();

	}

	public void addMovie() {

		String MOVIE_TITLE = MOVIE_TITLE_TF.getText();

		if (MOVIE_TITLE.equals("")) {
			JOptionPane.showMessageDialog(this, "영화제목을 반드시 입력해 주세요.");
			MOVIE_TITLE_TF.requestFocus();
			return;
		}

		String MOVIE_GENRE = MOVIE_GENRE_TF.getText();

		if (MOVIE_GENRE.equals("")) {
			JOptionPane.showMessageDialog(this, "장르를 반드시 입력해 주세요.");
			MOVIE_GENRE_TF.requestFocus();
			return;
		}

		String MOVIE_TIME = MOVIE_TIME_TF.getText();

		if (MOVIE_TIME.equals("")) {
			JOptionPane.showMessageDialog(this, "시간을 반드시 입력해 주세요.");
			MOVIE_TIME_TF.requestFocus();
			return;
		}

		String MOVIE_TIMEReg = "^[0-9]+$";

		if (!Pattern.matches(MOVIE_TIMEReg, MOVIE_TIME)) {
			JOptionPane.showMessageDialog(this, "시간은 숫자로 입력해 주세요.");
			MOVIE_TIME_TF.requestFocus();
			return;
		}

		String MOVIE_COUNTRY = MOVIE_COUNTRY_TF.getText();

		if (MOVIE_COUNTRY.equals("")) {
			JOptionPane.showMessageDialog(this, "국가를 반드시 입력해 주세요.");
			MOVIE_COUNTRY_TF.requestFocus();
			return;
		}

		String MOVIE_DIRECTOR = MOVIE_DIRECTOR_TF.getText();

		if (MOVIE_DIRECTOR.equals("")) {
			JOptionPane.showMessageDialog(this, "감독을 반드시 입력해 주세요.");
			MOVIE_DIRECTOR_TF.requestFocus();
			return;
		}
		MovieDTO movie = new MovieDTO();
		movie.setMOVIE_TITLE(MOVIE_TITLE);
		movie.setMOVIE_GENRE(MOVIE_GENRE);
		movie.setMOVIE_TIME(MOVIE_TIME);
		movie.setMOVIE_COUNTRY(MOVIE_COUNTRY);
		movie.setMOVIE_DIRECTOR(MOVIE_DIRECTOR);

		int rows = MovieDAOImpl.getDao().insertMovie(movie);

		JOptionPane.showMessageDialog(this, rows + "개의 영화정보를 등록 하였습니다.");

		displayAllMovie();
		initDisplay();

	}

}