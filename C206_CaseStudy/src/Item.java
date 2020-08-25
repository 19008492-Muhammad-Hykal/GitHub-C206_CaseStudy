//kaiqi(member 3)
import java.util.ArrayList;


public class Item {
	public String name;
	public String description;
	public double bid_price;
	public String start_date;
	public String end_date;
	
	
	public Item(String name, String description, double bid_price, String start_date, String end_date) {
		super();
		this.name = name;
		this.description = description;
		this.bid_price = bid_price;
		this.start_date = start_date;
		this.end_date = end_date;
		
		
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBid_price() {
		return bid_price;
	}
    
	public void setBid_price(double bid_price) {
		this.bid_price = bid_price;
	}

	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getEnd_date() {
		return end_date;
	}



}
