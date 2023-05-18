package team09;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class UserGUIApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;
	
	JTextField USER_NO_TF, USER_ID_TF, USER_PW_TF, USER_NAME_TF, USER_EMAIL_TF;
	JButton addB, deleteB, updateB, searchB, cancelB;
	
	JTable table;
	
	int cmd;
	
	private JPanel contentPane;
	
	
	
	/**
	 * Create the frame.
	 */
	public UserGUIApp() throws Exception{
		setTitle("◆◆◆ 학생 관리 프로그램 ◆◆◆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Dimension : 컴퍼넌트 크기를 저장하기 위한 객체
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
		setContentPane(contentPane);
		
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));
		
		JPanel pUSER_NO = new JPanel();
		pUSER_NO.add(new JLabel("넘버"));
		pUSER_NO.add(USER_NO_TF = new JTextField(10)); 
		
		JPanel pUSER_ID = new JPanel();
		pUSER_ID.add(new JLabel("아이디"));
		pUSER_ID.add(USER_ID_TF = new JTextField(10));

		JPanel pUSER_PW = new JPanel();
		pUSER_PW.add(new JLabel("비밀번호"));
		pUSER_PW.add(USER_PW_TF = new JTextField(10));

		JPanel pUSER_NAME = new JPanel();
		pUSER_NAME.add(new JLabel("이름"));
		pUSER_NAME.add(USER_NAME_TF = new JTextField(10));

		JPanel pUSER_EMAIL = new JPanel();
		pUSER_EMAIL.add(new JLabel("이메일"));
		pUSER_EMAIL.add(USER_EMAIL_TF = new JTextField(10));
		
		left.add(pUSER_NO);
		left.add(pUSER_ID);
		left.add(pUSER_PW);
		left.add(pUSER_NAME);
		left.add(pUSER_EMAIL);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(addB = new JButton("삽  입"));
//		addB.addActionListener(this);

		bottom.add(updateB = new JButton("변  경"));
//		updateB.addActionListener(this);

		bottom.add(deleteB = new JButton("삭  제"));
//		deleteB.addActionListener(this);

		bottom.add(searchB = new JButton("검  색"));
//		searchB.addActionListener(this);

		bottom.add(cancelB = new JButton("초기화"));
//		cancelB.addActionListener(this);
		
		Object[] title = { "넘버", "아이디", "비밀번호", "이름", "이메일" };

		table = new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		JScrollPane sp = new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();
		
		displayAllUser();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void initialize() {
		USER_NO_TF.setEditable(false);
		USER_ID_TF.setEditable(false);
		USER_PW_TF.setEditable(false);
		USER_NAME_TF.setEditable(false);
		USER_EMAIL_TF.setEditable(false);
	}
	
	public void setEditable(int n) {
		switch (n) {
		case ADD:
			USER_NO_TF.setEditable(true);
			USER_ID_TF.setEditable(true);
			USER_PW_TF.setEditable(true);
			USER_NAME_TF.setEditable(true);
			USER_EMAIL_TF.setEditable(true);
			break;
		case DELETE:
			USER_NO_TF.setEditable(true);
			break;
		case UPDATE:
			USER_NO_TF.setEditable(true);
			break;
		case UPDATE_CHANGE:
			USER_NO_TF.setEditable(false);
			USER_ID_TF.setEditable(true);
			USER_PW_TF.setEditable(true);
			USER_NAME_TF.setEditable(true);
			USER_EMAIL_TF.setEditable(true);
			break;
		case SEARCH:
			USER_ID_TF.setEditable(true);
			break;
		case NONE:
			USER_NO_TF.setEditable(false);
			USER_ID_TF.setEditable(false);
			USER_PW_TF.setEditable(false);
			USER_NAME_TF.setEditable(false);
			USER_EMAIL_TF.setEditable(false);
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
		USER_NO_TF.setText("");
		USER_ID_TF.setText("");
		USER_PW_TF.setText("");
		USER_NAME_TF.setText("");
		USER_EMAIL_TF.setText("");
	}
	
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUIApp frame = new UserGUIApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// 미완
	public void displayAllUser() {
//		List<UserDTO> userList = U
	}

	
	// 미완
	public void addUser() {
		String USER_NO_Temp = USER_NO_TF.getText();
		if (USER_NO_Temp.equals("")) {
			JOptionPane.showMessageDialog(this, "넘버를 반드시 입력해 주세요.");
			USER_NO_TF.requestFocus();
			return;
		}
		
		String noReg = "^[1-9][0-9]{3}$";
		if (!Pattern.matches(noReg, USER_NO_Temp)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "학번은 4자리 숫자로만 입력해 주세요.");
			USER_NO_TF.requestFocus();
			return;
		}
		
		int no = Integer.parseInt(USER_NO_Temp);// 문자열을 정수값으로 변환하여 변수에 저장

		
		
		
	}
	
	

}
