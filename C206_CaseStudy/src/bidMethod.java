//Created by Hykal at 19/9/2020
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class bidMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		ArrayList<bid> bidList = new ArrayList<bid>();
		
		
		int option = 0;

		while (option != 6) {
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
				bidMethod.setHeader("UPDATE BID");
				bidMethod.updateBid(bidList);
			}
			
			else if (option == 5) {
				//DO SEARCH BY NAME METHOD
				bidMethod.setHeader("SEARCH BID BY ITEM NAME");
				bidMethod.searchByItemName(bidList);
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
	
	//Show All Bid
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
	
	
	//Add Bid
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
	
	//Delete Bid
	 public static boolean doDelete(ArrayList<bid> bidList, int id) {
			
			boolean isDelete= false;

			for (int i = 0; i < bidList.size(); i++) {
				
				int delId = bidList.get(i).getBid_id();
				
				if (id == delId) {
					isDelete = true;
					
				}
			}
			return isDelete;
		}

		public static void deleteBid(ArrayList<bid> bidList) {
			bidMethod.viewAllBidding(bidList);
			int delId = Helper.readInt("Enter BID ID to delete > ");
			Boolean isDelete =doDelete(bidList, delId);
			if (isDelete == false) {
				System.out.println("Invalid ID");
			} else {
				
				for(int i =0; i<bidList.size();i++) {
					if(delId == bidList.get(i).getBid_id()) {
						bidList.remove(i);
					}
				}
				
			}
		}
	
	
	
		//Update Bid
		public static void updateBid(ArrayList<bid> bidList) {
	    
	    	bidMethod.viewAllBidding(bidList);
	    	int updateId = Helper.readInt("Enter the ID of the bid you want to update > ");
	    	int updatePrice = Helper.readInt("Enter new price for bidding > ");
	    	for (int i = 0; i < bidList.size(); i++) {
	    		if(updateId == bidList.get(i).getBid_id() && updatePrice > bidList.get(i).getBid_price()) {
	    			
	    			bidList.get(i).setBid_price(updatePrice);
	    			System.out.println("Bid Updated");
	    		}
	    		
	    		else if(updateId != bidList.get(i).getBid_id()) {
	    			System.out.println("Bid ID not found");
	    		}
	    		else if(updatePrice <= bidList.get(i).getBid_price()) {
	    			System.out.println("Please bid higher than the current price");
	    		}
	    	}

		}
		
		//Search Bid by Item Name
		public static String searchByItemName(ArrayList<bid> bidList) {
			String item = Helper.readString("Enter Item name to search > ");
			String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ITEM NAME", "BID ID",
					"BID PRICE", "BUYER EMAIL","SELLER EMAIL");
			
	        for (int i = 0; i < bidList.size(); i++) {
	        	if(item.contains(bidList.get(i).getItem_name()) ) {
	        		output += String.format("%-10s %-30d %-10f %-10s %-20s\n", bidList.get(i).getItem_name(),bidList.get(i).getBid_id(),bidList.get(i).getBid_price(),
	    					bidList.get(i).getBuyer_email(),bidList.get(i).getSeller_email());
	        		System.out.println(output);
	        	}
		}
	        return output;
	}
	
}





