package team09;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldID;
	private JPasswordField textFieldPW;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 프레임
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelLogin = new JLabel("      로그인");
		labelLogin.setForeground(new Color(0, 128, 255));
		labelLogin.setFont(new Font("굴림", Font.BOLD, 60));
		labelLogin.setBounds(63, 39, 435, 190);
		contentPane.add(labelLogin);

		textFieldID = new JTextField();
		textFieldID.setBounds(157, 261, 232, 21);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		textFieldPW = new JPasswordField();
		textFieldPW.setBounds(157, 292, 232, 21);
		contentPane.add(textFieldPW);

		JButton btnLogin = new JButton("로그인");

		// 로그인 버튼 이벤트 처리
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFieldID.getText();
				String pw = textFieldPW.getText();

				sendIdPw(id, pw);
			}
		});

		btnLogin.setBounds(409, 261, 71, 53);
		contentPane.add(btnLogin);

		// 회원가입 버튼 이벤트 처리
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBounds(304, 323, 85, 21);
		contentPane.add(btnJoin);

		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinPage joinPage = new JoinPage();
				joinPage.setVisible(true);
			}
		});

	}

	public void sendIdPw(String id, String pw) {
		UserDTO user = UserDAOImpl.getDao().selectUser(id);

		if (user == null) {
			System.out.println("No User");
			return;
		}
		if (id.equals(user.getUSER_ID()) && pw.equals(user.getUSER_PW())) {
			try {
				dispose();
				MoviePage dialog = new MoviePage();
				dialog.setVisible(true);

			} catch (Exception e) {
				System.out.print("MoviePage 불러오기 오류 : ");
				e.printStackTrace();
			}
		} else {
			System.out.println("Incorrect contents");
		}
	}
}