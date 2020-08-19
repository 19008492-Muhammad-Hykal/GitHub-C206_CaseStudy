import java.time.LocalDate;
import java.util.ArrayList;

public class deal extends bid,Item
{

	public int dealID;
	private double transactionPrice;

	public deal (String item_name,String seller_email, String buyer_email, String end_date, int dealID, double transactionPrice) {
		
		this.dealID = dealID;
		this.transactionPrice = transactionPrice;
		super(item_name, seller_email, buyer_email, end_date);
		
		
	}

	public int getDealID() {
		return dealID;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public static void menu() {
		System.out.println("1. Add Bids");
		System.out.println("2. Show Bids");
		System.out.println("3. Delete Bids");
		System.out.println("4. Quit");
	}

	ArrayList<bid> bidList = new ArrayList<bid>();

	
	public static void addBids(ArrayList<bid> bidList) {

		while (option != 4) {
			
			//Add bids

			if (option == 1) {

				int deal_id = Helper.readInt("Enter deal id > ");
				String item_name = bidList.getItem_name();
				String seller_email = bidList.getSeller_email();
				String end_date = bidList.getEnd_date();
				bidList.add(new deal(item_name, seller_email, buyer_email, end_date, dealID, transactionPrice));

			}
			
			//Show bids

			else if (option == 2) {

				for (int i = 0; i < bidList.size(); i++) {
					System.out.println(bidList.get(i).getDealID());
					System.out.println(bidList.get(i).getItem_name());
					System.out.println(bidList.get(i).getSeller_email());
					System.out.println(bidList.get(i).getBuyer_email());
					System.out.println(bidList.get(i).getTransactionPrice());
					System.out.println(bidList.get(i).getEnd_date());
				}

			}
			
			//Delete bids
			
			else if (option == 3) {
				
				for (int i = 0; i < bidList.size(); i++) {
					if (deal_id == bidList.get(i).getDealID()) {
						bidList.remove(i);
					}
				}
			}
			
			else {
				
				System.out.println("Thank you.");
			}

		}

	}

}
