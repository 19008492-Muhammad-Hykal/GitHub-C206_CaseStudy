import java.time.LocalDate;
import java.util.ArrayList;

public class deal {
	
	private int deal_id;
	private String item_name;
	private String seller_email;
	private String buyer_email;
	private double transaction_price;
	private String close_date;
	
	public deal (int deal_id, String item_name, String seller_email, String buyer_email, double transaction_price, String close_date) {
		
		this.deal_id = deal_id;
		this.item_name = item_name;
		this.seller_email = seller_email;
		this.buyer_email = buyer_email;
		this.transaction_price = transaction_price;
		this.close_date = close_date;
	}

	
	public int getDealID() {

		return deal_id;
	}
	
	public int setDealID(int updateDealId) {
		deal_id = updateDealId;
		return deal_id;
	}
	
	public String getItemName() {
		
		return item_name;
	}
	
	public String setItemName(String updateItemName) {
		item_name = updateItemName;
		return item_name;
	}
	
	public String getSellerEmail() {
		
		return seller_email;
	}
	
	public String setSellerEmail(String updateSellerEmail) {
		seller_email = updateSellerEmail;
		return seller_email;
	}
	
	public String getBuyerEmail() {
		
		return buyer_email;
	}
	
	public String setBuyerEmail(String updateBuyerEmail) {
		buyer_email = updateBuyerEmail;
		return buyer_email;
	}
	
	public double getTransactionPrice() {
		
		return transaction_price;
	}
	
	public double setTransactionPrice(double updateTransactionPrice) {
		transaction_price = updateTransactionPrice;
		return transaction_price;
	}
	public String getCloseDate() {
		
		return close_date;
	}
	
	public String setCloseDate(String updateCloseDate) {
		close_date = updateCloseDate;
		return close_date;
	}
}