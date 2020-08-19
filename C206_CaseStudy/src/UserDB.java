import java.util.ArrayList;

public class UserDB {
	private static ArrayList<User> userList = new ArrayList<User>();
	
	public static void addUser(User obj) {
		userList.add(obj);
		System.out.println("Sucessfully Added");
		showUserMenu();
	}
	
	public static void delUser() {
		Helper.line(80, "-");
		String email = Helper.readString("Enter Email of user > ");
		for (User a: userList) {
			if (a.getEmail().equals(email)) {
				userList.remove(a);
				break;
			}
		}
		System.out.println("Deleted!");
		showUserMenu();
	}
		
	public static void viewAllUser() {
		Helper.line(80, "-");
		System.out.println("Name,Role,Email,Password");
		for (User a:userList) {
			System.out.println(a.toString());
		}
		showUserMenu();
	}
	
	public static void inputUser() {
		String name = Helper.readString("Enter Name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter Email > ");
		String password = Helper.readString("Enter password > ");
		User obj = new User(name,role,email,password);
		addUser(obj);
	}
	
	public static void showUserMenu() {
		Helper.line(80, "-");
		System.out.println("User Menu");
		System.out.println("1. Add user account");
		System.out.println("2. View all users");
		System.out.println("3. Delete user based on email");
		System.out.println("4. Exit");
		showUserMenuOptions();
	}
	
	public static void showUserMenuOptions() {
		int option = Helper.readInt("Enter Option > ");
		switch(option) {
		case 1:
			inputUser();
			break;
		case 2:
			viewAllUser();
			break;
		case 3:
			delUser();
			break;
		
		case 4:
			System.out.println("Good Bye!");
		}
	}
	
	
}
