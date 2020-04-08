package cafe_toStringMain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

import cafe_toStringBGM.Cafe_BGM;
import cafe_toStringChat.Client;
import cafe_toStringChat.Lt;
import cafe_toStringDAO.Cafe_DAO;
import cafe_toStringDTO.Cafe_emp;
import cafe_toStringDTO.Cafe_menu;
import cafe_toStringDTO.Cafe_orderlist;
import cafe_toStringImg.Cafe_Img;
import cafe_toStringLogo.Cafe_ConsoleString;
import cafe_toStringMembership.Cafe_MemberShip;

public class Cafe_Main {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Cafe_BGM bgm = new Cafe_BGM();
		Cafe_MemberShip vip = new Cafe_MemberShip();
		String coffee = "";
		String name = "";
		String position = "";
		String ice_hot = "";
		String size = "";
		String total_date = "";
		int emp_id = 0;
		int age = 0;
		int pay = 0;
		int price = 0;
		int menu_id = 0;
		int order_num = 0;
		int shot = 0;

		try {
			Cafe_BGM.mp3();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(
				"！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
		Cafe_ConsoleString.consoleString("Welcome!");
		System.out.println(
				"！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");

		Cafe_ConsoleString.consoleString("cafe_toString");
		System.out.println(
				"！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");

		while (true) {
			System.out.println("1.爽庚  2.朝凪淫軒  3.企鉢号 脊舌 4.陥製拭 臣臆推");
			int choose01 = sc.nextInt();
			sc.nextLine();
			Cafe_DAO dao = Cafe_DAO.getInstance();

			switch (choose01) {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////// 爽庚 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			case 1:
				dao.menuSelect();

				System.out.println("護腰 五敢研 爽庚馬獣畏柔艦猿?");
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
				menu_id = sc.nextInt();
				sc.nextLine();

				System.out.println("痔聖 護腰 蓄亜馬獣畏柔艦猿?");
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
				shot = sc.nextInt();
				sc.nextLine();

				System.out.println("製戟税 紳亀研 識澱背爽室推 [" + dao.menuIce_Hot(menu_id) + "]");
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
				ice_hot = sc.nextLine();

				System.out.println("製戟 紫戚綜研 識澱背爽室推 [" + dao.menuSize(menu_id) + "]");
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
				size = sc.nextLine();

				Cafe_orderlist orderDto = new Cafe_orderlist(menu_id, (int) ((Math.random() * 12 + 1)), shot, ice_hot,
						size);
				dao.orderlistInsert(orderDto);

				try {
					System.out.print("爽庚馬重 五敢研 層搾掻脊艦陥");
					for (int i = 0; i < 3; i++) {
						System.out.print(".....");
						Thread.sleep(1000);
					}
					System.out.println();
					System.out.println("爽庚馬重 五敢 蟹尽柔艦陥!");
					Thread.sleep(1000);
					System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
					Cafe_Img cimg = new Cafe_Img(menu_id, ice_hot);
				} catch (Exception e) {

				}

				break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////// 朝凪 淫軒 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			case 2:
				while (true) {

					System.out.println("1.五敢 淫軒 2.送据 淫軒 3.姥古鎧蝕 淫軒 4.搭域左奄 5.謝還淫軒 6.五昔生稽");
					int choose02 = sc.nextInt();
					sc.nextLine();

					if (choose02 == 6) {
						break;
					}

					switch (choose02) {

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// 五敢 淫軒 ////////////////////////////////////////////////////////////////////////////////////////////////////////////
					case 1:

						System.out.println("1.蓄亜 2.呪舛 3.肢薦 4.左奄 5.宜焼奄奄");
						System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
						int choose03 = sc.nextInt();
						sc.nextLine();

						if (choose03 == 5) {
							break;
						}

						switch (choose03) {

						// 五敢 蓄亜
						case 1:
							System.out.println("五敢 戚硯 : ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							coffee = sc.nextLine();

							System.out.println("五敢 亜維 : ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							price = sc.nextInt();
							sc.nextLine();

							System.out.println("五敢 紫戚綜 [S,R,L] : ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							size = sc.nextLine();

							System.out.println("ice_hot [ice,hot] : ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							ice_hot = sc.nextLine();

							Cafe_menu menuDto = new Cafe_menu(0, coffee, price, size, ice_hot);
							dao.menuInsert(menuDto);
							break;

						// 五敢 呪舛
						case 2:
							dao.menuSelect();
							System.out.println("五敢腰硲 護腰 呪舛?");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							menu_id = sc.nextInt();
							sc.nextLine();
							dao.menuUpdate(menu_id);
							break;

						// 五敢 肢薦
						case 3:
							dao.menuSelect();
							System.out.println("五敢腰硲 護腰 肢薦?");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							menu_id = sc.nextInt();
							sc.nextLine();
							dao.menuDelete(menu_id);
							break;

						// 五敢 左奄
						case 4:
							dao.menuSelect();
							break;

						default:
							break;
						}

						break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// 送据 淫軒 ////////////////////////////////////////////////////////////////////////////////////////////////////////////
					case 2:
						System.out.println("1.蓄亜 2.呪舛 3.肢薦 4.左奄 5.昔湿銅崎 溌昔 6.宜焼奄奄");
						System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
						int choose04 = sc.nextInt();
						sc.nextLine();

						if (choose04 == 6) {
							break;
						}

						switch (choose04) {

						// 送据 蓄亜
						case 1:
							System.out.println("送据 戚硯 : ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							name = sc.nextLine();

							System.out.println("送据 蟹戚 : ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							age = sc.nextInt();
							sc.nextLine();

							System.out.println("送据 送厭 : ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							position = sc.nextLine();

							System.out.println("送据  杉厭: ");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							pay = sc.nextInt();
							sc.nextLine();

							Cafe_emp empDto = new Cafe_emp(emp_id, name, age, position, pay);
							dao.empInsert(empDto);
							break;

						// 送据 呪舛
						case 2:
							dao.empSelect();
							System.out.println("送据腰硲 護腰 呪舛?");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							emp_id = sc.nextInt();
							sc.nextLine();
							dao.empUpdate(emp_id);
							break;

						// 送据 肢薦
						case 3:
							dao.empSelect();
							System.out.println("送据腰硲 護腰 肢薦?");
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							emp_id = sc.nextInt();
							sc.nextLine();
							dao.empDelete(emp_id);
							break;

						// 送据 左奄
						case 4:
							dao.empSelect();
							break;

						// 昔湿銅崎 溌昔
						case 5:
							System.out.println("昔湿銅崎 溌昔 劾促 [YYYY-MM-DD] : ");
							String incentive_date = sc.nextLine();
							System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							dao.empSelect();
							System.out.println("送据腰硲 護腰?");
							emp_id = sc.nextInt();
							dao.empInsentive(incentive_date, emp_id);
							break;

						case 6:
							break;

						default:
							break;
						}

						break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// 姥古鎧蝕 淫軒 /////////////////////////////////////////////////////////////////////////////////////////////////////////
					case 3:
						System.out.println("1.呪舛 2.肢薦 3.左奄 4.宜焼奄奄");
						System.out.println(
								"！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
						int choose05 = sc.nextInt();
						sc.nextLine();

						if (choose05 == 4) {
							break;
						}

						switch (choose05) {

						// 姥古鎧蝕 呪舛
						case 1:
							dao.orderlistSelect();
							System.out.println("姥古腰硲 護腰 呪舛?");
							System.out.println(
									"！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							order_num = sc.nextInt();
							sc.nextLine();
							dao.orderlistUpdate(order_num);
							break;

						// 姥古鎧蝕 肢薦
						case 2:
							dao.orderlistSelect();
							System.out.println("姥古腰硲 護腰 肢薦?");
							System.out.println(
									"！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
							order_num = sc.nextInt();
							sc.nextLine();
							dao.orderlistDelete(order_num);
							break;

						// 姥古鎧蝕 左奄
						case 3:
							dao.orderlistSelect();
							break;

						case 4:
							break;

						default:
							break;
						}
						break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// 搭域 左奄 ////////////////////////////////////////////////////////////////////////////////////////////////////////////		
					case 4:
						System.out.println("搭域研 瑳 劾促研 脊径背爽室推 [YYYY-MM-DD] : ");
						System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
						total_date = sc.nextLine();
						dao.total(total_date);
						break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// 謝還 淫軒 ////////////////////////////////////////////////////////////////////////////////////////////////////////////		
					case 5:
						System.out.println("1.噺据亜脊 2.匂昔闘左奄 3.稽益昔 4.及稽亜奄");
						int choose06 = sc.nextInt();

						switch (choose06) {
						case 1:
							vip.joinMembership();
							break;

						case 2:
							vip.pointSelect();
							break;

						case 3:
							vip.login();
							break;

						default:
							break;
						}

						break;

					default:
						break;
					}

				}
				break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////菰銅棚 什傾球 //////////////////////////////////////////////////////////////////////////////////////////////////////////		
			case 3:
				Client client = new Client();
				client.start();
				break;

			case 4:
				System.exit(0);
				break;

			default:
				break;
			}

		}
	}
}
