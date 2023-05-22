package team09;

import java.awt.Color;
import java.awt.EventQueue;
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

public class JoinPage extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextField jtf_id = new JTextField();
	JPasswordField jtf_pw = new JPasswordField();
	JTextField jtf_name = new JTextField();
	JTextField jtf_email = new JTextField();

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
		JPanel jp = new JPanel();
		JLabel jl_join = new JLabel("회 원 가 입");
		JLabel jl_id = new JLabel("아이디");
		JLabel jl_pw = new JLabel("비밀번호");
		JLabel jl_name = new JLabel("이름");
		JLabel jl_email = new JLabel("이메일");
		add(jl_join);
		add(jl_id);
		add(jl_pw);
		add(jl_name);
		add(jl_email);

		add(jtf_id);
		add(jtf_pw);
		add(jtf_name);
		add(jtf_email);

		jl_join.setBounds(150, 20, 150, 40);
		jl_join.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));

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
		btnSubmit.setFont(new Font("Aharoni 굵게", Font.PLAIN, 17));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBounds(130, 250, 150, 30);

		add(jp);
		setSize(400, 350);
		setTitle("회원가입");
		setVisible(true);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = jtf_id.getText();
				String pw = jtf_pw.getText();
				String name = jtf_name.getText();
				String Email = jtf_email.getText();

				int joinSuccess = sendInfo(id, pw, name, Email);

				if (joinSuccess == 1) {
					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
					dispose();
				}
			}
		});

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