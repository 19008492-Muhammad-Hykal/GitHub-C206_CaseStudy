import java.util.ArrayList;

public class dealMain {

	/**
	 * 
	 */
	private static final int Update = 5;
	/**
	 * 
	 */
	private static final int Search = 4;
	/**
	 * 
	 */
	private static final int Delete = 3;
	/**
	 * 
	 */
	private static final int Show = 2;
	/**
	 * 
	 */
	private static final int Add = 1;
	/**
	 * 
	 */
	private static final int Quit = 6;
	private static final int Close_Date = 6;
	private static final int Transaction_Price = 5;
	private static final int Buyer_Email = 4;
	private static final int Seller_Email = 3;
	private static final int Item_Name = 2;
	private static final int Deal_ID = 1;

	public static void main(String[] args) {

		ArrayList<bid> dealList = new ArrayList<bid>();

		menu();

		int option = Helper.readInt("Enter an option (1-6): ");

		while (option != Quit) {

			if (option == Add) {
				dealMain.addDeal(dealList, addDeal);
				dealMain.inputDeal();
			}

			else if (option == Show) {
				dealMain.retrieveAllDeals(dealList);
				dealMain.viewAllDeals(dealList);
			}

			else if (option == Delete) {
				dealMain.doDelete(dealList, id);
				dealMain.deleteDeal(dealList);
			}

			else if (option == Search) {
				dealMain.searchByDealId(dealList);
			}

			else if (option == Update) {
				dealMain.updateByDealId(dealList);
			}
		}

		System.out.println("Exited");

	}

	public static void menu() {

		System.out.println("1. Add ");
		System.out.println("2. Show ");
		System.out.println("3. Delete ");
		System.out.println("4. Search ");
		System.out.println("5. Update");
		System.out.println("6. Quit");

	}

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Add deals
	public static deal inputDeal() {
		int id = Helper.readInt("Enter deal id: ");
		String name = Helper.readString("Enter item name: ");
		String seller_email = Helper.readString("Enter seller email: ");
		String buyer_email = Helper.readString("Enter buyer email: ");
		double transaction_price = Helper.readDouble("Enter transaction price: ");
		String close_date = Helper.readString("Enter close date: ");

		deal addDeal = new deal(id, name, seller_email, buyer_email, transaction_price, close_date);
		return addDeal;

	}

	public static void addDeal(ArrayList<deal> dealList, deal addDeal) {
		dealList.add(addDeal);
		System.out.println("Deal added.");
	}

	// Show all deals
	public static String retrieveAllDeals(ArrayList<deal> dealList) {
		String output = "";

		for (int i = 0; i < dealList.size(); i++) {
			output += String.format("%-10s %-30d %-10f %-10s %-20s\n", dealList.get(i).getDealID(),
					dealList.get(i).getDealID(), dealList.get(i).getSellerEmail(), dealList.get(i).getBuyerEmail(),
					dealList.get(i).getTransactionPrice(), dealList.get(i).getCloseDate());

		}

		return output;
	}

	public static void viewAllDeals(ArrayList<deal> dealList) {
		dealMain.setHeader("DEAL LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-10s\n", "DEAL ID", "ITEM NAME", "SELLER EMAIL",
				"BUYER EMAIL", "TRANSACTION PRICE", "CLOSE DATE");
		output += retrieveAllDeals(dealList);
		System.out.println(output);
	}

	// Delete deals
	public static boolean doDelete(ArrayList<deal> dealList, int id) {

		boolean isDelete = false;

		for (int i = 0; i < dealList.size(); i++) {

			int delId = dealList.get(i).getDealID();

			if (id == delId) {
				isDelete = true;
			}
		}
		return isDelete;
	}

	public static void deleteDeal(ArrayList<deal> dealList) {
		dealMain.viewAllDeals(dealList);
		int delId = Helper.readInt("Enter deal ID to delete > ");
		Boolean isDelete = doDelete(dealList, delId);
		if (isDelete == false) {
			System.out.println("Invalid ID");
		} else {

			for (int i = 0; i < dealList.size(); i++) {
				if (delId == dealList.get(i).getDealID()) {
					dealList.remove(i);
				}
			}
		}

	}

	// Search Deals By its ID
	public static void searchByDealId(ArrayList<bid> dealList) {
		int id = Helper.readInt("Enter deal ID to to search: ");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "DEAL ID", "ITEM NAME", "SELLER EMAIL",
				"BUYER EMAIL", "TRANSACTION PRICE", "CLOSE DATE");

		for (int i = 0; i < dealList.size(); i++) {
			if (dealList.get(i).getDealID() == id) {

				output += String.format("%-10s %-30d %-10f %-10s %-20s\n", dealList.get(i).getDealID(),
						dealList.get(i).getItemName(), dealList.get(i).getSellerEmail(),
						dealList.get(i).getBuyerEmail(), dealList.get(i).getTransactionPrice(),
						dealList.get(i).getCloseDate());

				System.out.println(output);
			}
		}
	}

	// Update Deals by its ID
	public static void updateByDealId(ArrayList<bid> dealList) {

		System.out.println("1. Deal ID");
		System.out.println("2. Item Name");
		System.out.println("3. Seller Email");
		System.out.println("4. Buyer Email");
		System.out.println("5. Transaction Price");
		System.out.println("6. Close Date");
		System.out.println("7. Quit");

		int option = Helper.readInt("Enter an option you want to update (1-7): ");
		while (option != 7) {

			if (option == Deal_ID) {
				int updateDealId = Helper.readInt("Enter new deal id: ");
				for (int i = 0; i < dealList.size(); i++) {
					dealList.get(i).setDealID(updateDealId);

				}
			} else if (option == Item_Name) {
				String updateItemName = Helper.readString("Enter new item name: ");
				for (int i = 0; i < dealList.size(); i++) {
					dealList.get(i).setItem_name(updateItemName);
				}
			} else if (option == Seller_Email) {
				String updateSellerEmail = Helper.readString("Enter new seller email: ");
				for (int i = 0; i < dealList.size(); i++) {
					dealList.get(i).setSellerEmail(updateSellerEmail);
				}
			} else if (option == Buyer_Email) {
				String updateBuyerEmail = Helper.readString("Enter new buyer email: ");
				for (int i = 0; i < dealList.size(); i++) {
					dealList.get(i).setBuyerEmail(updateBuyerEmail);
				}
			} else if (option == Transaction_Price) {
				double updateTransactionPrice = Helper.readDouble("Enter new transaction price: ");
				for (int i = 0; i < dealList.size(); i++) {
					dealList.get(i).setTransactionPrice(updateTransactionPrice);
				}
			} else if (option == Close_Date) {
				String updateCloseDate = Helper.readString("Enter new close date: ");
				for (int i = 0; i < dealList.size(); i++) {
					dealList.get(i).setCloseDate(updateCloseDate);
				}
			}

		}

		System.out.println("Exited");

	}

}
