import java.util.ArrayList;

public class bidMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<bid> bidList = new ArrayList<bid>();
		
		
		int option = 0;

		while (option != 5) {
			bidMethod.menu(); 
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				bidMethod.viewAllBidding(bidList);
			}
			
			else if (option == 2) {
				bidMethod.setHeader("ADD BID");
				bid addBid = inputBid();
				bidMethod.addBid(bidList, addBid);
			}
			
			else if (option == 3) {
				bidMethod.setHeader("DELETE BID");
				bidMethod.deleteBid(bidList);
				
			}
			
			else if (option == 4) {
				//DO UPDATE METHOD
			}
			
			else if (option == 5) {
				//DO SEARCH BY NAME METHOD
			}
			
			else if (option == 6) {
				System.out.println("GOODBYE!!");
			}
			
			else {
				System.out.println("INVALID OPTION");
			}
			
		}

		
	}
	
	public static void menu() {
		bidMethod.setHeader("BID SECTION");
		System.out.println("1. Show Bid");
		System.out.println("2. Add Bid");
		System.out.println("3. Delete Bid");
		System.out.println("4. Update Bid"); //New Requirement
		System.out.println("5. Search Bid by name"); //New requirement
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}
	
	public static String retrieveAllBidding(ArrayList<bid> bidList) {
		String output = "";

		for (int i = 0; i < bidList.size(); i++) {

			output += String.format("%-10s %-30d %-10f %-10s %-20s\n", bidList.get(i).getItem_name(),bidList.get(i).getBid_id(),bidList.get(i).getBid_price(),
					bidList.get(i).getBuyer_email(),bidList.get(i).getSeller_email());
				
		}
		return output;
	}
	
	public static void viewAllBidding(ArrayList<bid> bidList) {
		bidMethod.setHeader("BID LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ITEM NAME", "BID ID",
				"BID PRICE", "BUYER EMAIL","SELLER EMAIL");
		 output += retrieveAllBidding(bidList);	
		System.out.println(output);
	}
	
	
	public static bid inputBid() {
		
		int id = Helper.readInt("Enter Bid ID > ");
		double price = Helper.readFloat("Enter price > ");
		String item_name = Helper.readString("Enter item name > ");
		String seller_email = Helper.readString("Enter a seller email > ");
		String buyer_email = Helper.readString("Enter buyer email address > ");
	
		bid addBid = new bid(id,price,item_name,seller_email,buyer_email);
		return addBid;
	}
	
	public static void addBid(ArrayList<bid> bidList, bid addBid) {
		
		bidList.add(addBid);
		System.out.println("Bid added");
	}
	
	public static void deleteBid(ArrayList<bid> bidList) {
		int deleteBidID = Helper.readInt("Enter ID of Bid to Delete > ");
		for(int i =0; i<bidList.size();i++) {
			if(deleteBidID == bidList.get(i).getBid_id()) {
				bidList.remove(i);
			}
			else {
				System.out.println("Invalid ID to, Delete Failed");
			}
		}
	}

}





