package team09;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class JoinPage extends JFrame {

	//OLD
//	private static final long serialVersionUID = 1L;
	
//	private JPanel contentPane;
//	private JTextField textFieldID;
//	private JPasswordField textFieldPW;
//	private JTextField textFieldName;
//	private JTextField textFieldEmail;

	//NEW 
	JTextField jtf_id = new JTextField();
	JPasswordField jtf_pw = new JPasswordField(); //JPasswordField로 바꿈 - 암호화
	JTextField jtf_name = new JTextField();
	JTextField jtf_email = new JTextField();
	//
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinPage frame = new JoinPage();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 프레임
	public JoinPage() {
		//OLD
//		setBounds(200, 300, 600, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		setTitle("회원가입");
//		Container c = getContentPane();
//		c.setLayout(new FlowLayout());
//
//		c.add(new JLabel("아이디 "));
//		textFieldID = new JTextField(20);
//		c.add(textFieldID);
//
//		c.add(new JLabel("비밀번호 "));
//		textFieldPW = new JPasswordField(18);
//		c.add(textFieldPW);
//
//		c.add(new JLabel("이름 "));
//		textFieldName = new JTextField(20);
//		c.add(textFieldName);
//
//		c.add(new JLabel("이메일 "));
//		textFieldEmail = new JTextField(20);
//		c.add(textFieldEmail);
//		
//		setSize(400, 250);
//		setVisible(true);
		
		//NEW
		JPanel jp = new JPanel();
		JLabel jl_join = new JLabel("회 원 가 입");
		JLabel jl_id = new JLabel("아이디");
		JLabel jl_pw= new JLabel("비밀번호");
		JLabel jl_name = new JLabel("이름");
		JLabel jl_email = new JLabel("이메일");
		add(jl_join);
		add(jl_id);
		add(jl_pw);
		add(jl_name);
		add(jl_email);
		
		//Local -> Global
//		JTextField jt_id = new JTextField();
//		JTextField jt_pw = new JTextField();
//		JTextField jt_name = new JTextField();
//		JTextField jt_email = new JTextField();
		add(jtf_id);
		add(jtf_pw);
		add(jtf_name);
		add(jtf_email);

		jl_join.setBounds(150, 20, 150, 40);
		jl_join.setFont(new Font("Aharoni 굵게",Font.BOLD,25));
		
		jl_id.setBounds(40, 70, 40, 40);
		jl_pw.setBounds(40, 110, 60, 40);
		jl_name.setBounds(40, 150, 60, 40);
		jl_email.setBounds(40, 190, 40, 40);
		
		jtf_id.setBounds(120, 70, 200, 30);
		jtf_pw.setBounds(120, 110, 200, 30);
		jtf_name.setBounds(120, 150, 200, 30);
		jtf_email.setBounds(120, 190, 200, 30);
		
		JButton btnSubmit = new JButton("가입하기");
		add(btnSubmit);
		btnSubmit.setFont(new Font("Aharoni 굵게",Font.PLAIN,17));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBounds(130, 250, 150, 30);
		
		add(jp);
		setSize(400,350);
		setTitle("회원가입");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이 줄 삭제했음
		setVisible(true);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = jtf_id.getText();
				String pw = jtf_pw.getText();
				String name = jtf_name.getText();
				String Email = jtf_email.getText();

				int joinSuccess = sendInfo(id, pw, name, Email);

				if (joinSuccess == 1) {
					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");//new
					dispose();
				}
			}
		});
		
		
		//OLD
//		JButton btnSubmit = new JButton("가입하기");
//		btnSubmit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				String id = textFieldID.getText();
//				String pw = textFieldPW.getText();
//				String name = textFieldName.getText();
//				String Email = textFieldEmail.getText();
//
//				int joinSuccess = sendInfo(id, pw, name, Email);
//
//				if (joinSuccess == 1) {
//					dispose();
//				}
//			}
//		});
//		btnSubmit.setBounds(64, 395, 97, 23);
//		contentPane.add(btnSubmit);
	}

	public int sendInfo(String id, String pw, String name, String Email) {

		// 아이디 정규 표현식
		if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 반드시 입력해 주세요.");
			jtf_id.requestFocus();
			return 0;
		}

		String idReg = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
		if (!Pattern.matches(idReg, id)) {
			JOptionPane.showMessageDialog(this, "영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하의 아이디를 작성해주세요.");
			jtf_id.requestFocus();
			return 0;
		}

		// 비밀번호 정규표현식
		if (pw.equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 반드시 입력해 주세요.");
			jtf_pw.requestFocus();
			return 0;
		}

		String pwReg = "^[A-Za-z0-9]{6,12}$";
		if (!Pattern.matches(pwReg, pw)) {
			JOptionPane.showMessageDialog(this, "숫자와 문자를 포함한 6~12자리 이내의 비밀번호를 작성해주세요.");
			jtf_pw.requestFocus();
			return 0;
		}

		// 이름 정규표현식
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			jtf_name.requestFocus();
			return 0;
		}

		String nameReg = "^[가-힣]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "한글로만 이름을 작성해주세요.");
			jtf_name.requestFocus();
			return 0;
		}

		// 이메일 정규표현식
		if (Email.equals("")) {
			JOptionPane.showMessageDialog(this, "이메일을 반드시 입력해 주세요.");
			jtf_email.requestFocus();
			return 0;
		}

		String EmailReg = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		if (!Pattern.matches(EmailReg, Email)) {
			JOptionPane.showMessageDialog(this, "올바른 형식으로 이메일을 작성해주세요.");
			jtf_email.requestFocus();
			return 0;
		}

		UserDTO user = new UserDTO();
		user.setUSER_ID(id);
		user.setUSER_PW(pw);
		user.setUSER_NAME(name);
		user.setUSER_EMAIL(Email);

		int rows = UserDAOImpl.getDao().insertUser(user);

		System.out.println(rows + "명의 유저 정보를 삽입했습니다.");
		return rows;

	}

}