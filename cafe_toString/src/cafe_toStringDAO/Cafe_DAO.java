package cafe_toStringDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Scanner;

import cafe_toStringDTO.*;
import mysql_connection.*;

public class Cafe_DAO {
	Scanner sc = new Scanner(System.in);
	int choose;

	private static Cafe_DAO dao = new Cafe_DAO();

	private Cafe_DAO() {
		super();
	}

	public static Cafe_DAO getInstance() {
		return dao;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// �޴��� ��ü���� //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void menuSelect() throws SQLException {
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		System.out.println("�������������������������������������������������������޴�������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		System.out.println("���޴� ��ȣ\t��\t�޴� �̸�\t\t�� ����\t �� ������ \t�� ���� �µ���");
		System.out.println("������������������������������������������������������������������������������������������������������������������");

		String sql = "select * from menu";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				System.out.print("��");
				System.out.print(rs.getInt(1) + "\t��");
				System.out.printf("\t" + rs.getString(2) + "\t\t��");
				System.out.print(rs.getInt(3) + "\t�ܦ�");
				System.out.print(rs.getString(4) + "\t��");
				System.out.printf("%8s", rs.getString(5) + "��");
				System.out.println();
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������");
			System.out.println("������������������������������������������������������������������������������������������������������������������");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// �޴��� ���� //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void menuInsert(Cafe_menu dto) throws SQLException {
		String sql = "insert into menu (menu_id, coffee, price, size, ice_hot) values (0,?,?,?,?)";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, dto.getCoffee());
			pst.setInt(2, dto.getPrice());
			pst.setString(3, dto.getSize());
			pst.setString(4, dto.getIce_hot());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		menuSelect();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// �޴��� ������Ʈ //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void menuUpdate(int menu_id) throws SQLException {
		String sql = "";
		// orderlist ������ �÷� ����
		System.out.println("��� �����Ͻðڽ��ϱ�?\n1. coffee 2. price 3. size 4. ice_hot");
		int choose = sc.nextInt();
		sc.nextLine();

		// ������ ��ȣ�� ���� ������ �ۼ�
		switch (choose) {
		case 1:
			sql = "update menu set coffee = ? where menu_id = " + menu_id;
			break;
		case 2:
			sql = "update menu set price = ? where menu_id = " + menu_id;
			break;
		case 3:
			sql = "update menu set size = ? where menu_id = " + menu_id;
			break;
		case 4:
			sql = "update menu set ice_hot = ? where menu_id = " + menu_id;
			break;

		default:
			break;
		}

		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			if (choose == 2) {
				System.out.println("���� �Ͻ� ���� �Է����ּ��� : ");
				pst.setInt(1, sc.nextInt());
				sc.nextLine();
			} else if (choose == 1 || choose == 3 || choose == 4) {
				System.out.println("���� �Ͻ� ���� �Է����ּ��� : ");
				pst.setString(1, sc.nextLine());
			}
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		menuSelect();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// �޴��� ����  //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void menuDelete(int menu_id) throws SQLException {
		String sql = "delete from menu where menu_id = " + menu_id;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		menuSelect();

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////�޴��� ���� �µ� ����  //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String menuIce_Hot(int menu_id) {
		String ice_hot = "";
		String sql = "select ice_hot from menu where menu_id = " + menu_id;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				ice_hot = rs.getString("ice_hot");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ice_hot;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////�޴��� ������ ����  //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String menuSize(int menu_id) {
		String size = "";
		String sql = "select size from menu where menu_id = " + menu_id;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				size = rs.getString("size");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ������� ��ü���� //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void empSelect() {
		String sql = "select * from emp";
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("������������������������������������������������Ρ�������������������������������������������");
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("������ ��ȣ\t�� �̸�\t�� ����\t�� ����\t�� ����\t�� ģ����\t��");
		System.out.println("��������������������������������������������������������������������������������������������������");

		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				System.out.print("��");
				for (int i = 1; i <= 6; i++) {
					System.out.print(rs.getObject(i) + "\t��");
				}
				System.out.println();
			}
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("��������������������������������������������������������������������������������������������������");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ������� ���� //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void empInsert(Cafe_emp dto) {
		String sql = "insert into emp (emp_id, name, age, position, pay) values (0,?,?,?,?)";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getAge());
			pst.setString(3, dto.getPosition());
			pst.setInt(4, dto.getPay());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		empSelect();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ������� ������Ʈ //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void empUpdate(int emp_id) {
		String sql = "";
		// orderlist ������ �÷� ����
		System.out.println("��� �����Ͻðڽ��ϱ�?\n1. name 2. age 3. position 4. pay");
		int choose = sc.nextInt();
		sc.nextLine();

		// ������ ��ȣ�� ���� ������ �ۼ�
		switch (choose) {
		case 1:
			sql = "update emp set name = ? where emp_id = " + emp_id;
			break;
		case 2:
			sql = "update emp set age = ? where emp_id = " + emp_id;
			break;
		case 3:
			sql = "update emp set position = ? where emp_id = " + emp_id;
			break;
		case 4:
			sql = "update emp set pay = ? where emp_id = " + emp_id;
			break;

		default:
			break;
		}

		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			if (choose == 1 || choose == 3) {
				System.out.println("���� �Ͻ� ���� �Է����ּ��� : ");
				pst.setString(1, sc.nextLine());
			} else if (choose == 2 || choose == 4) {
				System.out.println("���� �Ͻ� ���� �Է����ּ��� : ");
				pst.setInt(1, sc.nextInt());
				sc.nextLine();
			}
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		empSelect();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ������� ���� /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void empDelete(int emp_id) {
		ResultSet rs;
		int order_num = 0;
		String sql = "select order_num from orderlist where emp_id = " + emp_id;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			rs = pst.executeQuery();
			while (rs.next()) {
				order_num = rs.getInt("order_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		sql = "delete from emp where emp_id = " + emp_id;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		sql = "update orderlist set emp_id = 999 where emp_id = " + emp_id;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		starUpdate(order_num, 0);
		empSelect();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ���ų��� ���� /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void orderlistInsert(Cafe_orderlist dto) {
		ResultSet rs;
		int price = 0;
		int order_num = 0;
		int star = 0;

		// ���� �޴����� ���� �ֹ��� menu_id�� �̿��Ͽ� menu ���̺� �����Ͽ� price ���� �����´�
		String sql = "select * from menu where menu_id = ?";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, dto.getMenu_id());
			rs = pst.executeQuery();

			while (rs.next()) {
				price = rs.getInt("price");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// orderlist ���̺� - ���ų����� �߰�
		sql = "insert into orderlist (menu_id, emp_id, price, shot, ice_hot, size, order_date, order_num)"
				+ " values(?,?,?,?,?,?,?,?)";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, dto.getMenu_id());
			pst.setInt(2, dto.getEmp_id());
			pst.setInt(3, price);
			pst.setInt(4, dto.getShot());
			pst.setString(5, dto.getIce_hot());
			pst.setString(6, dto.getSize());

			// LocalDateTime.now()�� Date�� �ٲٴ� ���..
			pst.setDate(7,
					new java.sql.Date(dto.getOrder_date().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));

			pst.setInt(8, 0);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// orderlist ���̺��� ���� �ֱ��� ���ų���(���� ū ��, order_num�� �ڵ������̱⶧��)�� ������ �˷��ش�
		sql = "select max(order_num) from orderlist";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println("�ֹ��Ϸ�!\n�ֹ���ȣ�� [" + rs.getInt("max(order_num)") + "]�� �Դϴ�");
				System.out.println("������������������������������������������������������������������������������������������������������������������");
				order_num = rs.getInt("max(order_num)");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("������ ģ������ �Է����ּ��� 1[��] ~ 5[�ڡڡڡڡ�]");
		star = sc.nextInt();
		sc.nextLine();

		sql = "update orderlist set star = " + star + " where order_num = " + order_num;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		starUpdate(order_num, 0);
		System.out.println("�����մϴ�!");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ���ų��� ������Ʈ //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void orderlistUpdate(int order_num) {
		ResultSet rs;
		String sql = "";
		int star = 0;
		int emp_id = 0;

		// orderlist ������ �÷� ����
		System.out.println("��� �����Ͻðڽ��ϱ�?\n1. menu_id 2. emp_id 3. price 4. shot 5. ice_hot 6. size 7. star");
		int choose = sc.nextInt();
		sc.nextLine();

		// ������ ��ȣ�� ���� ������ �ۼ�
		switch (choose) {
		case 1:
			sql = "update orderlist set menu_id = ? where order_num = " + order_num;
			break;
		case 2:
			sql = "select emp_id from orderlist where order_num = " + order_num;
			try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
				rs = pst.executeQuery();
				while (rs.next()) {
					emp_id = rs.getInt("emp_id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			sql = "update orderlist set emp_id = ? where order_num = " + order_num;
			break;
		case 3:
			sql = "update orderlist set price = ? where order_num = " + order_num;
			break;
		case 4:
			sql = "update orderlist set shot = ? where order_num = " + order_num;
			break;
		case 5:
			sql = "update orderlist set ice_hot = ? where order_num = " + order_num;
			break;
		case 6:
			sql = "update orderlist set size = ? where order_num = " + order_num;
			break;
		case 7:
			System.out.println("������ ģ������ �Է����ּ��� 1 ~ 5");
			star = sc.nextInt();
			sc.nextLine();

			sql = "update orderlist set star = " + star + " where order_num = " + order_num;
			try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
				pst.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			starUpdate(order_num, 0);
			break;
		default:
			break;
		}

		// ������ �÷��� ���� �Է¹ް� ������ ����
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {

			if (choose == 1 || choose == 3 || choose == 4) {
				System.out.println("���� �Ͻ� ���� �Է����ּ��� : ");
				pst.setInt(1, sc.nextInt());
				sc.nextLine();
				pst.executeUpdate();
			} else if (choose == 5 || choose == 6) {
				System.out.println("���� �Ͻ� ���� �Է����ּ��� : ");
				pst.setString(1, sc.nextLine());
				pst.executeUpdate();
			} else if (choose == 2) {
				System.out.println("���� �Ͻ� ���� �Է����ּ��� : ");
				pst.setInt(1, sc.nextInt());
				sc.nextLine();
				pst.executeUpdate();
				starUpdate(0, emp_id);
				starUpdate(order_num, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		orderlistSelect();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ���ų��� ���� //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void orderlistDelete(int order_num) {
		ResultSet rs;
		int emp_id = 0;
		String sql = "select emp_id from orderlist where order_num = " + order_num;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			rs = pst.executeQuery();
			while (rs.next()) {
				emp_id = rs.getInt("emp_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql = "delete from orderlist where order_num = " + order_num;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		starUpdate(order_num, emp_id);
		orderlistSelect();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ���ų��� ��ü���� //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void orderlistSelect() {
		String sql = "select * from orderlist";
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("���������������������������������������������������������������������ų���������������������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("������ ��ȣ\t���޴� ��ȣ\t������ ��ȣ\t���޴� ����\t���� ����\t������ �µ�\t��������\t��ģ����\t������ ��¥\t\t��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������");

		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				System.out.print("��");
				for (int i = 1; i <= 9; i++) {
					System.out.print(rs.getObject(i) + "\t��");
				}
				System.out.println();
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ��¥ �� ��躸��  //////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void total(String total_date) {
		String sql = "select sum(price), sum(shot), sum(star), "
				+ "(select count(ice_hot) from orderlist where ice_hot = 'ice' and order_date = '" + total_date
				+ "') as ice_total, (select count(ice_hot) from orderlist where ice_hot = 'hot' and order_date = '"
				+ total_date + "') as hot_total, "
				+ "(select count(size) from orderlist where size ='S' and order_date = '" + total_date + "') as S, "
				+ "(select count(size) from orderlist where size ='R' and order_date = '" + total_date + "') as R, "
				+ "(select count(size) from orderlist where size ='L' and order_date = '" + total_date + "') as L "
				+ "from orderlist where order_date = '" + total_date + "'";

		System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("������������������������������������������������2019-12-13��衪������������������������������������������������������");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("������ ���� \t���� ���� \t��ģ���� \t�����̽� \t�������� \t��S���� \t��R���� \t��L���� \t��");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������");

		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				System.out.print("��");
				for (int i = 1; i <= 8; i++) {
					System.out.print(rs.getObject(i) + "\t��");

				}
				System.out.println();
			}
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// ģ���� ������Ʈ ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void starUpdate(int order_num, int emp_id) {
		String sql = "";
		ResultSet rs;
		int avg = 0;

		if (emp_id == 0) {

			sql = "select emp_id from orderlist where order_num = " + order_num;
			try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
				rs = pst.executeQuery();
				while (rs.next()) {
					emp_id = rs.getInt("emp_id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// ģ���� ��� ���� avg�� ����
		sql = "select avg(star) from orderlist where emp_id = " + emp_id + " and star > 0";
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			rs = pst.executeQuery();
			while (rs.next()) {
				avg = rs.getInt("avg(star)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		sql = "update emp set star = ? where emp_id = " + emp_id;
		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, avg);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////// �μ�Ƽ�� ���� /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void empInsentive(String incentive_date, int emp_id) {
		int star = 0;
		double payInsentive = 0;
		String sql = "select emp_id, sum(star) from orderlist where order_date = '" + incentive_date + "' and emp_id ="
				+ emp_id;

		try (Connection conn = MyConnection.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {

			try (ResultSet rs = pst.executeQuery()) {
				System.out.println("��������������������������������������");
				System.out.println("��������������������������������������");
				System.out.println("�������������� �� Ƽ �ꡪ����������");
				System.out.println("��������������������������������������");
				System.out.println("| ���� ��ȣ  | ģ���� ���� |");
				System.out.println("��������������������������������������");

				System.out.print("|");
				while (rs.next()) {
					System.out.print(rs.getInt("emp_id") + "\t |");
					System.out.print(rs.getInt("sum(star)") + "\t  |\n");
					star = rs.getInt("sum(star)");
				}
				System.out.println("��������������������������������������");
				System.out.println("��������������������������������������");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		sql = "select pay from emp where emp_id =" + emp_id;

		try (Connection conn1 = MyConnection.getConn(); PreparedStatement pst1 = conn1.prepareStatement(sql)) {

			try (ResultSet rs1 = pst1.executeQuery()) {

				while (rs1.next()) {
					payInsentive = rs1.getInt("pay");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if ((star < 20)) {
			System.out.println("������ȣ [" + emp_id + "]���� �μ�Ƽ���  : 0");
		} else if ((star >= 20) && (star < 30)) {
			System.out.println("������ȣ [" + emp_id + "]���� �μ�Ƽ��� : " + payInsentive * ((double) 3 / 100) + "( �޿� 3% )");
		} else {
			System.out.println("������ȣ [" + emp_id + "]���� �μ�Ƽ���  : " + payInsentive * ((double) 5 / 100) + "( �޿� 5% )");
		}
		System.out.println("��������������������������������������������������������������������������������������������������");

	}

}
