
public class bid {
	
	private int bid_id;
	private int buyer_id;
	private float bid_price;
	private String item_name;
	private String buyer_name;
	private String seller_name;
	private String seller_email;
	private String buyer_email;
	
	public bid(int bid_id, int buyer_id, float bid_price, String item_name, String buyer_name, String seller_name, String seller_email, String buyer_email) {

		this.bid_id = bid_id;
		this.buyer_id = buyer_id;
		this.bid_price = bid_price;
		this.item_name = item_name;
		this.buyer_name = buyer_name;
		this.seller_name = seller_name;
		this.seller_email = seller_email;
		this.buyer_email = buyer_email;
	}

	public float getBid_price() {
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

	public int getBuyer_id() {
		return buyer_id;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	
	
}

