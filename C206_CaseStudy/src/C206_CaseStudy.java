
public class C206_CaseStudy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		menu();
		int option = Helper.readInt("Enter Option > ");
		switch (option) {
		case 1: //Member 1 (Bryent)
			accountMenu();
			int optionAccount = Helper.readInt("Enter Option > ");
			
			
		}
	}
	
	public static void menu() {
		Helper.line(40, "=");
		System.out.println("Campus Online Auction Shop (COAS)");
		System.out.println("1. User account");
		System.out.println("2. Item");
		System.out.println("3. Bid");
		System.out.println("4. Deal");
		System.out.println("5. Category ");
		
	}
	
	//Member 1 (Bryent)
	public static void accountMenu() {
		Helper.line(40, "-");
		System.out.println("User Account Management");
		System.out.println("1. Add user account");
		System.out.println("2. View all users");
		System.out.println("3. Delete user based on email");
	}
	


}
