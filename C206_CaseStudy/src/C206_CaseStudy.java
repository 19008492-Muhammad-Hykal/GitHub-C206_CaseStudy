
public class C206_CaseStudy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
		
	public static void start() {	
		menu();
		int option = Helper.readInt("Enter Option > ");
		switch (option) {
		case 1: //Member 1 (Bryent)
			UserDB.showUserMenuOptions();
			break;
		case 2: //Member 2 (KaiQi)
			Item.menu();
			break;
		case 3: //Member 3 (Hykal)
			
			break;
		case 4: //Member 4 (TengYik)
			
			break;
		}
		
	}	
	
	public static void menu() {
		Helper.line(40, "=");
		System.out.println("Campus Online Auction Shop (COAS)");
		System.out.println("1. User account");
		System.out.println("2. Item");
		System.out.println("3. Bid");
		System.out.println("4. Deal");
		System.out.println("5. Category");
		System.out.println("6. Exit");
		
	}
	
}
	
