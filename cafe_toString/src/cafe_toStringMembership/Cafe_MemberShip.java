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
////// ȸ������ ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void joinMembership() throws SQLException {

		String name = "";
		String id = "";
		String pwd = "";
		String birthday = "";

		JPanel panel = new JPanel();
		JLabel names = new JLabel("�̸� : ");
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JLabel birthdays = new JLabel("���� : ");

		// �̸��� �Է��ϴ� txt�� �����
		JTextField txtName = new JTextField(20);

		// id�� �Է��ϴ� txt�� �����
		JTextField txtId = new JTextField(20);

		// �н����� �Է��ϴ� txt�� �����
		JPasswordField txtpass = new JPasswordField(20);

		// ������ �Է��ϴ� txt�� ������
		JTextField txtDate = new JTextField(20);
		JButton logbutton = new JButton("ȸ������");

		// ����͵��� �гο� �� �����ְ�
		setTitle("ȸ������");
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

		// �����ְԲ�
		setVisible(true);

		// ����� �Է�
		setSize(600, 400);

		// â�� ��ġ ����
		setLocationRelativeTo(null);

		// â�� ũ�⸦ �ǵ��� ���ϰ�
		setResizable(false);

		// â�� ������ ������ ������
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// ��ư�� ������ �ȿ��ִ� ������ ������ ���̽��� ����
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

					JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ� �Ǿ����ϴ�");
				} catch (SQLException e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "�̹� ���ǰ��ִ� ���̵� �Դϴ�");
				}
			}
		});
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// �α���  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void login() throws SQLException {
		System.out.println("�ݰ����ϴ� �̸��� �Է����ּ���");
		String names = sc.nextLine();

		// �гλ���
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");

		// �гο� ���̵� ���� txt�� ����
		JTextField txtId = new JTextField(10);

		// �гο� �ǹй�ȣ ���� txt�� ����
		JPasswordField txtpass = new JPasswordField(10);

		// ��ư �� �����ϸ� ����Ʈ ���� �����ֱ� ���� ��ư����
		JButton logbutton = new JButton("�α���");

		// �гο� �־��ְ�
		panel.add(label);
		panel.add(txtId);
		panel.add(pswrd);
		panel.add(txtpass);
		panel.add(logbutton);

		add(panel);

		// �г��� �����ְ� ����
		setVisible(true);
		// ������� �������
		setSize(600, 400);
		setLocationRelativeTo(null);
		// ����� ���ǵ��̰� ����
		setResizable(false);
		// ȭ�鸸 ������ ����
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

		// �ֱ� ��ȣ�� ��������Ʈ�� ������ �̾Ƽ�
		int num = 0;
		sql = "select price from orderlist where order_num = (select max(order_num) from orderlist)";
		try (Connection conn = MyConnection.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				num = rs.getInt("price");
			}
		}

		// 10���� ���� point �� �־��ְ�
		int point = num / 10;

		// �׼��� ������ ��ü
		logbutton.addActionListener(new ActionListener() {

			// ��ư�� ������ ���̵�� ��� ��ȣ�� ������ ����Ʈ�� ������Ʈ������
			// Ư���� �׼��� ������ �װ��� ��������ִ� �޼ҵ�
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
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
					JOptionPane.showMessageDialog(null, "����Ʈ ���� �Ϸ�");
				} else {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �����ʽ��ϴ�");
				}

			}
		});
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ����Ʈ ��� //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void pointSelect() throws SQLException {
		// ������ ���̵� �Է¹޾Ƽ�
		System.out.println("����Ʈ�� Ȯ���� ���̵� �Է��ϼ���");
		String id = sc.nextLine();

		// ������ ���� ����Ʈ ���� ���
		String sql = "select member_point from cafe_tostring.member where member_id=?";

		// ����Ʈ�� Ȯ�ν�������
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
