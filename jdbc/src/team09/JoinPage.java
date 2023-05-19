package team09;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldID;
	private JPasswordField textFieldPW;
	private JTextField textFieldName;
	private JTextField textFieldEmail;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinPage frame = new JoinPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 프레임
	public JoinPage() {
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("아이디 "));
		textFieldID = new JTextField(20);
		c.add(textFieldID);
		
		c.add(new JLabel("비밀번호 "));
		textFieldPW = new JPasswordField(18);
		c.add(textFieldPW);
		
		c.add(new JLabel("이름 "));
		textFieldName = new JTextField(20);
		c.add(textFieldName);
		
		c.add(new JLabel("이메일 "));
		textFieldEmail = new JTextField(20);
		c.add(textFieldEmail);

		setSize(300, 180);
		setVisible(true);

		JButton btnSubmit = new JButton("가입하기");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = textFieldID.getText();
				String pw = textFieldPW.getText();
				String name = textFieldName.getText();
				String Email = textFieldEmail.getText();

				sendInfo(id, pw, name, Email);

			}
		});
		btnSubmit.setBounds(64, 395, 97, 23);
		contentPane.add(btnSubmit);
	}
	
	

	public void sendInfo(String id, String pw, String name, String Email) {

		// 아이디 정규 표현식
		if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 반드시 입력해 주세요.");
			textFieldID.requestFocus();
			return;
		}

		String idReg = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
		if (!Pattern.matches(idReg, id)) {
			JOptionPane.showMessageDialog(this, "영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하의 아이디를 작성해주세요.");
			textFieldID.requestFocus();
			return;
		}
		
		// 비밀번호 정규표현식
		if (pw.equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 반드시 입력해 주세요.");
			textFieldPW.requestFocus();
			return;
		}

		String pwReg = "^[A-Za-z0-9]{6,12}$";
		if (!Pattern.matches(pwReg, pw)) {
			JOptionPane.showMessageDialog(this, "숫자와 문자를 포함한 6~12자리 이내의 비밀번호를 작성해주세요.");
			textFieldPW.requestFocus();
			return;
		}
		
		// 이름 정규표현식
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			textFieldName.requestFocus();
			return;
		}

		String nameReg = "^[가-힣]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "한글로만 이름을 작성해주세요.");
			textFieldName.requestFocus();
			return;
		}
		
		// 이메일 정규표현식
		if (Email.equals("")) {
			JOptionPane.showMessageDialog(this, "이메일을 반드시 입력해 주세요.");
			textFieldEmail.requestFocus();
			return;
		}

		String EmailReg = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		if (!Pattern.matches(EmailReg, Email)) {
			JOptionPane.showMessageDialog(this, "올바른 형식으로 이메일을 작성해주세요.");
			textFieldEmail.requestFocus();
			return;
		}
		
		UserDTO user = new UserDTO();
		user.setUSER_ID(id);
		user.setUSER_PW(pw);
		user.setUSER_NAME(name);
		user.setUSER_EMAIL(Email);

		int rows = UserDAOImpl.getDao().insertUser(user);

		System.out.println(rows + "명의 유저 정보를 삽입했습니다.");
		
		dispose();

	}

}