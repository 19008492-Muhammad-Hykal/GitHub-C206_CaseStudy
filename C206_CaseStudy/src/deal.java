import java.time.LocalDate;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19010398, 19 Aug 2020 10:04:43 am
 */
public class deal {
	
	private int deal_id;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double transactionPrice;
	private LocalDate closeDate;
	
	public deal (int deal_id, String itemName, String sellerEmail, String buyerEmail, double transactionPrice, LocalDate closeDate) {
		this.deal_id = deal_id;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.transactionPrice = transactionPrice;
		this.closeDate = closeDate;
	}
	
	public int getDealID() {
		return deal_id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public String getSellerEmail() {
		return sellerEmail;
	}
	
	public String getBuyerEmail() {
		return buyerEmail;
	}
	
	public double getTransactionPrice() {
		return transactionPrice;
	}
	
	public LocalDate getCloseDate() {
		return closeDate;
	}

}
