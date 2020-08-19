import java.util.Date;

public class Item {
	public String name;
	public String description;
	public double bid_price;
	public Date start_date;
	public Date end_date;
	
	public Item(String name, String description, double bid_price, Date start_date, Date end_date) {
		super();
		this.name = name;
		this.description = description;
		this.bid_price = bid_price;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	
	

}
