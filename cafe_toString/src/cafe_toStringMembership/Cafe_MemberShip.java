package cafe_toStringMembership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cafe_toStringDTO.Cafe_member;
import cafe_toStringDTO.Cafe_orderlist;
import mysql_connection.MyConnection;

public class Cafe_MemberShip extends JFrame {
	Scanner sc = new Scanner(System.in);
	Cafe_member logindto = null;
	Cafe_orderlist orderdto = null;
	String sql = "";
	int points = 0;
	String loginUserid = "";
	String loginUserpwd = "";

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// 회원가입 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void joinMembership() throws SQLException {

		String name = "";
		String id = "";
		String pwd = "";
		String birthday = "";

		JPanel panel = new JPanel();
		JLabel names = new JLabel("이름 : ");
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JLabel birthdays = new JLabel("생일 : ");

		// 이름을 입력하는 txt를 만들고
		JTextField txtName = new JTextField(20);

		// id을 입력하는 txt를 만들고
		JTextField txtId = new JTextField(20);

		// 패스워드 입력하는 txt를 만들고
		JPasswordField txtpass = new JPasswordField(20);

		// 생일을 입력하는 txt를 만들자
		JTextField txtDate = new JTextField(20);
		JButton logbutton = new JButton("회원가입");

		// 만들것들을 패널에 다 더해주고
		setTitle("회원가입");
		panel.add(names);
		panel.add(txtName);
		panel.add(label);
		panel.add(txtId);
		panel.add(pswrd);
		panel.add(txtpass);
		panel.add(birthdays);
		panel.add(txtDate);
		panel.add(logbutton);

		add(panel);

		// 볼수있게끔
		setVisible(true);

		// 사이즈를 입력
		setSize(600, 400);

		// 창의 위치 조절
		setLocationRelativeTo(null);

		// 창의 크기를 건들지 못하게
		setResizable(false);

		// 창만 꺼지게 설정을 해주자
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 버튼을 누르면 안에있는 값들을 데이터 베이스에 저장
		logbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String query = "insert into cafe_tostring.member(member_id, member_pwd, member_name, member_birthday) values(?,?,?,?)";
				try (Connection con = MyConnection.getConn(); PreparedStatement pst = con.prepareStatement(query)) {

					pst.setString(1, String.valueOf(txtId.getText()));
					pst.setString(2, String.valueOf(txtpass.getText()));
					pst.setString(3, String.valueOf(txtName.getText()));
					pst.setDate(4, Date.valueOf(txtDate.getText()));

					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "회원가입이 완료 되었습니다");
				} catch (SQLException e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "이미 사용되고있는 아이디 입니다");
				}
			}
		});
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// 로그인  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void login() throws SQLException {
		System.out.println("반갑습니다 이름을 입력해주세요");
		String names = sc.nextLine();

		// 패널생성
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");

		// 패널에 아이디 값을 txt로 받음
		JTextField txtId = new JTextField(10);

		// 패널에 피밀번호 값을 txt로 받음
		JPasswordField txtpass = new JPasswordField(10);

		// 버튼 을 실행하면 포인트 값을 보여주기 위해 버튼생성
		JButton logbutton = new JButton("로그인");

		// 패널에 넣어주고
		panel.add(label);
		panel.add(txtId);
		panel.add(pswrd);
		panel.add(txtpass);
		panel.add(logbutton);

		add(panel);

		// 패널을 볼수있게 설정
		setVisible(true);
		// 사이즈는 마음대로
		setSize(600, 400);
		setLocationRelativeTo(null);
		// 사이즈를 못건들이게 설정
		setResizable(false);
		// 화면만 꺼지게 설정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		List<String> idList = new ArrayList<String>();

		String sql2 = "SELECT * FROM cafe_tostring.member where member_name = '" + names + "'";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql2)) {
			ResultSet rs = pst.executeQuery(sql2);
			while (rs.next()) {
				loginUserid = rs.getString("member_id");
				loginUserpwd = rs.getString("member_pwd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 최근 번호의 오더리스트의 가격을 뽑아서
		int num = 0;
		sql = "select price from orderlist where order_num = (select max(order_num) from orderlist)";
		try (Connection conn = MyConnection.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				num = rs.getInt("price");
			}
		}

		// 10으로 나눠 point 에 넣어주고
		int point = num / 10;

		// 액션을 받으는 객체
		logbutton.addActionListener(new ActionListener() {

			// 버튼을 눌러서 아이디와 비밀 번호가 같으면 포인트를 업데이트해주자
			// 특정한 액션을 받으면 그것을 실행시켜주는 메소드
			@Override
			public void actionPerformed(ActionEvent e) {

				sql = "update cafe_tostring.member set member_point = ? where member_id = ?";
				try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
					pst.setInt(1, point);
					pst.setString(2, loginUserid);
					pst.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (loginUserid.equals(txtId.getText()) && loginUserpwd.equals(txtpass.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 완료");
					JOptionPane.showMessageDialog(null, "포인트 적립 완료");
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 맞지않습니다");
				}

			}
		});
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// 포인트 출력 //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void pointSelect() throws SQLException {
		// 본인의 아이디를 입력받아서
		System.out.println("포인트를 확인할 아이디를 입력하세요");
		String id = sc.nextLine();

		// 이제껏 모은 포인트 값을 출력
		String sql = "select member_point from cafe_tostring.member where member_id=?";

		// 포인트를 확인시켜주자
		try (Connection con = MyConnection.getConn(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					System.out.println(rs.getInt("member_point"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
