import java.util.ArrayList;
//Bryent (Member 1)
public class UserDB {
	private static ArrayList<User> userList = initUserList();
	
	public static void addUser(User obj, ArrayList<User>userList) {
		userList.add(obj);
		System.out.println("Sucessfully Added");

	}
	
	public static void delUser(String email, ArrayList<User>userList) {
		Helper.line(80, "-");
		for (User a: userList) {
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
	
	public static String viewAllUser(ArrayList<User>userList) {
		Helper.line(80, "-");
		System.out.println("Name,Role,Email,Password");
		String output = "";
		for (User a:userList) {
			output += a.toString();
		}
		return output;
	}
	
	public static void inputUser() {
		String name = Helper.readString("Enter Name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter Email > ");
		String password = Helper.readString("Enter password > ");
		User obj = new User(name,role,email,password);
		addUser(obj,userList);
	}
	
	public static void inputEmail() {
		String email = Helper.readString("Enter Email > ");
		delUser(email,userList);
	}
	
	public static void showUserMenu() {
		Helper.line(80, "-");
		System.out.println("User Menu");
		System.out.println("1. Add user account");
		System.out.println("2. View all users");
		System.out.println("3. Delete user based on email");
		System.out.println("4. Exit");
		
	}
	
	public static void showUserMenuOptions() {
		showUserMenu();
		int option = Helper.readInt("Enter Option > ");
		switch(option) {
		case 1:
			inputUser();
			showUserMenuOptions();
			break;
		case 2:
			System.out.println(viewAllUser(userList));
			showUserMenuOptions();
			break;
		case 3:
			inputEmail();
			showUserMenuOptions();
			break;
		
		case 4:
			System.out.println("Good Bye!");
			C206_CaseStudy.start();
		}
	}
	
	
}
