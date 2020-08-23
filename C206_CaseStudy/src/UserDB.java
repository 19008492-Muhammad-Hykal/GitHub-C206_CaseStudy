import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Bryent (Member 1)
public class UserDB {
	private static ArrayList<User> userList = initUserList();

	// Add user account (name, role, email, password)
	public static void addUser(User obj, ArrayList<User> userList) {
		userList.add(obj);
		System.out.println("Sucessfully Added");

	}

	// Delete user based on email
	public static void delUser(String email, ArrayList<User> userList) {
		Helper.line(80, "-");
		for (User a : userList) {
			if (a.getEmail().equals(email)) {
				userList.remove(a);
				break;
			}
		}
		System.out.println("Deleted!");
	}

	private static ArrayList<User> initUserList() {
		userList = new ArrayList<User>();
		return userList;
	}

	// View all items
	public static String viewAllUser(ArrayList<User> userList) {
		Helper.line(80, "-");
		System.out.println("Name,Role,Email,Password,Block,Deals");
		String output = "";
		for (User a : userList) {
			output += a.toString();
		}
		return output;
	}

	public static void inputUser(int option) {
		if (option == 1) {
			System.out.println("======Add New User=======");
			String name = Helper.readString("Enter Name > ");
			String role = Helper.readString("Enter role > ");
			String email = Helper.readString("Enter Email > ");
			String password = Helper.readString("Enter password > ");
			User obj = new User(name, role, email, password, 0, 0);
			addUser(obj, userList);

		} else if (option == 5) {
			System.out.println("======Update User=======");
			String name = Helper.readString("Enter Name > ");
			String password = Helper.readString("Enter password > ");
			User targetUser = null;
			for (User a : userList) {
				if (a.getName().equals(name) && a.getPassword().equals(password)) {
					targetUser = a;
					name = Helper.readString("Enter New Name > ");
					password = Helper.readString("Enter New Password > ");
				}
			}
			updateAccount(targetUser, name, password, userList);

		} else if (option == 6) {
			System.out.println("======Login to User=======");
			String email = Helper.readString("Enter Email > ");
			String password = Helper.readString("Enter password > ");
			int count = 0;
			loginAccount(count, email, password, userList);

		} else if (option == 7) {
			System.out.println("======Block User=======");
			String name = Helper.readString("Enter Name > ");
			String email = Helper.readString("Enter Email > ");
			MblockAccount(name, email, userList);

		} else if (option == 8) {
			System.out.println("======unBlock User=======");
			String name = Helper.readString("Enter Name > ");
			String email = Helper.readString("Enter Email > ");
			unblockAccount(name, email, userList);

		} else if (option == 10) {
			System.out.println("======Add deal=======");
			String name = Helper.readString("Enter Name > ");
			String email = Helper.readString("Enter Email > ");
			int numDeals = Helper.readInt("Enter num of successful deals > ");
			addDeals(name, email, numDeals, userList);

		}
	}

	public static void inputEmail(int option) {
		String email = Helper.readString("Enter Email > ");
		if (option == 3) {
			delUser(email, userList);
		} else if (option == 4) {
			String output = searchUser(email, userList);
			System.out.println(output);
		}
	}

	// Search user account based on email
	public static String searchUser(String email, ArrayList<User> userList) {
		Helper.line(80, "-");
		System.out.println("Name,Role,Email,Password,Block,Deals");
		String output = "";
		for (User a : userList) {
			if (a.getEmail().equals(email)) {
				output = a.toString();
				break;
			}
		}
		return output;
	}

	// Update user account (name, password)
	public static void updateAccount(User targetUser, String name, String password, ArrayList<User> userList) {
		targetUser.setName(name);
		targetUser.setPassword(password);
		System.out.println("Updated!");
	}

	// User login with email and password & If user login with incorrect password >
	// 3, the user will be blocked.
	public static void loginAccount(int count, String email, String password, ArrayList<User> userList) {
		for (User a : userList) {
			if (a.getBlock() == 1) {
				System.out.println("Your Account is Blocked! Please contact an administrator.");
				break;
			}

			if (a.getEmail().equals(email) && a.getPassword().equals(password) && a.getBlock() == 0) {
				System.out.println("Welcome " + a.getName() + " !");
				break;
			}

			while (count < 3) {
				if (a.getEmail().equals(email) && a.getBlock() == 0) {
					System.out.println("Wrong Password for " + a.getEmail());
					email = a.getEmail();
					count++;
					password = Helper.readString("Enter Password Again > ");
				}
			}

			if (count == 3) {
				a.setBlock(1);
				System.out.println("Account Blocked!");
				break;
			}
		}
	}

	// Admin can block suspicious seller/buyer.
	public static void MblockAccount(String name, String email, ArrayList<User> userList) {
		for (User a : userList) {
			if (a.getName().equals(name) && a.getEmail().equals(email)) {
				a.setBlock(1);
				break;
			}
		}
	}

	// The user can be unblocked by the admin once his/her identify is verified.
	public static void unblockAccount(String name, String email, ArrayList<User> userList) {
		for (User a : userList) {
			if (a.getName().equals(name) && a.getEmail().equals(email)) {
				a.setBlock(0);
				break;
			}
		}
	}

	// Monthly report on best seller base on the number of successful sells.
	public static String generateReport(ArrayList<User>userList) {
		Helper.line(80, "-");
		System.out.println("Name,Role,Email,Password,Block,Deals");
		int maxdeal = 0;
		User maxUser = null;
		String output = "";
		for (User a : userList) {
			if (a.getNumDeals() > maxdeal) {
				maxdeal = a.getNumDeals();
				maxUser = a;
			}
		}
		output = maxUser.toString();
		return output;
	}

	// To manually append deal data
	public static void addDeals(String name, String email, int numDeals, ArrayList<User> userList) {
		for (User a : userList) {
			if (a.getName().equals(name) && a.getEmail().equals(email))
				a.setNumDeals(numDeals);
		}
	}

	public static void showUserMenu() {
		Helper.line(80, "-");
		System.out.println("User Menu");
		System.out.println("1. Add user account");
		System.out.println("2. View all users");
		System.out.println("3. Delete user based on email");
		System.out.println("=====New User Account Requirements=====");
		System.out.println("4. Search user based on email");
		System.out.println("5. Update user(name,password)");
		System.out.println("6. Login to user account");
		System.out.println("7. Manual Block Account");
		System.out.println("8. Unblock Account");
		System.out.println("9. Generate Monthly Report on best seller");
		System.out.println("10. Manually append Deal data to user");
		System.out.println("11. Exit");

	}

	public static void showUserMenuOptions() {
		showUserMenu();
		int option = Helper.readInt("Enter Option > ");
		switch (option) {
		case 1:
			inputUser(1);
			showUserMenuOptions();
			break;
		case 2:
			System.out.println(viewAllUser(userList));
			showUserMenuOptions();
			break;
		case 3:
			inputEmail(3);
			showUserMenuOptions();
			break;

		case 4:
			inputEmail(4);
			showUserMenuOptions();
			break;

		case 5:
			inputUser(5);
			showUserMenuOptions();
			break;

		case 6:
			inputUser(6);
			showUserMenuOptions();
			break;

		case 7:
			inputUser(7);
			showUserMenuOptions();
			break;

		case 8:
			inputUser(8);
			showUserMenuOptions();
			break;

		case 9:
			System.out.println(generateReport(userList));
			showUserMenuOptions();
			break;

		case 10:
			inputUser(10);
			showUserMenuOptions();
			break;

		case 11:
			System.out.println("Good Bye!");
			C206_CaseStudy.start();
		}
	}

}
