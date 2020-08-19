//Created by Hykal at 19/9/2020

public class bid {
	
	private int bid_id;
	private double bid_price;
	private String item_name;
	private String seller_email;
	private String buyer_email;
	
	public bid(int bid_id, double bid_price, String item_name, String seller_email, String buyer_email) {

		this.bid_id = bid_id;
		this.bid_price = bid_price;
		this.item_name = item_name;
		this.seller_email = seller_email;
		this.buyer_email = buyer_email;
	}

	public double getBid_price() {
		return bid_price;
	}

	public void setBid_price(float bid_price) {
		this.bid_price = bid_price;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getBid_id() {
		return bid_id;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	
	
}

