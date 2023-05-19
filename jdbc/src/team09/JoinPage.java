package team09;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import xyz.itwill.student.StudentDAOImpl;
import xyz.itwill.student.StudentDTO;

public class JoinPage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldPW;
	private JTextField textFieldName;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public JoinPage() {
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelID = new JLabel("아이디");
		labelID.setBounds(68, 32, 57, 15);
		contentPane.add(labelID);

		textFieldID = new JTextField();
		textFieldID.setBounds(68, 60, 116, 21);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		JLabel labelPW = new JLabel("비밀번호");
		labelPW.setBounds(68, 108, 57, 15);
		contentPane.add(labelPW);

		textFieldPW = new JTextField();
		textFieldPW.setColumns(10);
		textFieldPW.setBounds(68, 142, 116, 21);
		contentPane.add(textFieldPW);

		JLabel labelName = new JLabel("이름");
		labelName.setBounds(68, 187, 57, 15);
		contentPane.add(labelName);

		textFieldName = new JTextField();
		textFieldName.setBounds(68, 222, 116, 21);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel labelEmail = new JLabel("이메일");
		labelEmail.setBounds(68, 282, 57, 15);
		contentPane.add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(68, 317, 116, 21);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JButton btnNewButton = new JButton("가입하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textFieldID.getText();
				String pw = textFieldPW.getText();
				String name = textFieldName.getText();
				String Email = textFieldEmail.getText();
				
				sendInfo(id, pw, name,Email);
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(64, 395, 97, 23);
		contentPane.add(btnNewButton);
	}
	
	private void sendInfo(String id, String pw, String name, String Email) {
		
		UserDTO user = new UserDTO();
		user.setUSER_ID(id);
		user.setUSER_PW(pw);
		user.setUSER_NAME(name);
		user.setUSER_EMAIL(Email);
		
		int rows = UserDAOImpl.getDao().insertUser(user);
		
		System.out.println(rows+"명의 유저 정보를 삽입했습니다.");

	}

}