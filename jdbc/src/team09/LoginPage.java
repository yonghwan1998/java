package team09;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 프레임
	public LoginPage() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel img = new JLabel();
		ImageIcon icon = new ImageIcon("src/team09/image/film1.png");
		img.setIcon(icon);
		add(img);

		JLabel minions = new JLabel();
		ImageIcon minionsIcon = new ImageIcon("src/team09/image/minions.png");
		minions.setIcon(minionsIcon);
		add(minions);

		JLabel nimo = new JLabel();
		ImageIcon nimoIcon = new ImageIcon("src/team09/image/nimo.png");
		nimo.setIcon(nimoIcon);
		add(nimo);

		JLabel totoro = new JLabel();
		ImageIcon totoroIcon = new ImageIcon("src/team09/image/totoro.png");
		totoro.setIcon(totoroIcon);
		add(totoro);

		JLabel sad = new JLabel();
		ImageIcon sadIcon = new ImageIcon("src/team09/image/sad.png");
		sad.setIcon(sadIcon);
		add(sad);

		JLabel jl_login = new JLabel("Login ..");
		jl_login.setFont(new Font("Serif", Font.BOLD, 50));
		add(jl_login);

		JLabel jl_id = new JLabel("I D : ");
		jl_id.setFont(new Font("Serif", Font.BOLD, 20));
		add(jl_id);
		JLabel jl_pw = new JLabel("PassWord : ");
		jl_pw.setFont(new Font("Serif", Font.BOLD, 15));
		add(jl_pw);

		JTextField jtf_id = new JTextField(12);
		add(jtf_id);
		JPasswordField jtf_pw = new JPasswordField(12);
		add(jtf_pw);
		JButton btnLogin = new JButton("로그인");
		add(btnLogin);
		JButton btnJoin = new JButton("회원가입");
		add(btnJoin);

		img.setBounds(30, 0, 600, 550);

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int x = 0; x <= 580; x += 20) {
					minions.setBounds(x, 280, 200, 200);

					if (x == 580) {
						x = 0;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int x = 160; x <= 580; x += 20) {

					nimo.setBounds(x, 280, 200, 200);
					if (x == 580) {
						x = 0;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int x = 320; x <= 580; x += 20) {
					totoro.setBounds(x, 280, 200, 200);

					if (x == 580) {
						x = 0;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int x = 480; x <= 580; x += 20) {
					sad.setBounds(x, 280, 200, 200);
					if (x == 580) {
						x = 0;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

		jl_login.setBounds(270, 220, 200, 150);

		jl_id.setBounds(168, 435, 80, 40);
		jl_pw.setBounds(130, 475, 80, 40);

		jtf_id.setBounds(230, 435, 200, 30);
		jtf_pw.setBounds(230, 475, 200, 30);

		btnLogin.setBounds(460, 435, 80, 30);
		btnJoin.setBounds(460, 475, 90, 30);

		add(panel);
		setSize(700, 600);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 화면");
		setVisible(true);

		// 로그인 버튼 이벤트 처리
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = jtf_id.getText();
				String pw = jtf_pw.getText();

				sendIdPw(id, pw);
			}
		});

		// 회원가입 버튼 이벤트 처리
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinPage joinPage = new JoinPage();
				joinPage.setLocation(500, 300);
				joinPage.setVisible(true);
			}
		});
	}

	public void sendIdPw(String id, String pw) {
		UserDTO user = UserDAOImpl.getDao().selectUser(id);

		if (user == null) {
			JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.");
			return;
		}
		if (id.equals(user.getUSER_ID()) && pw.equals(user.getUSER_PW())) {
			JOptionPane.showMessageDialog(this, "환영합니다. " + user.getUSER_NAME() + "님!");
			try {
				dispose();
				MoviePage dialog = new MoviePage();
				dialog.setVisible(true);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "나도 모르는 오류");
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
		}
	}
}