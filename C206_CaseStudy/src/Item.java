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
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("Bear", "Cute and Soft", 3.50,"16/4/2020","20/4/2020"));
		
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public double getBid_price() {
		return bid_price;
	}

	public String getStart_date() {
		return start_date;
	}


	public String getEnd_date() {
		return end_date;
	}


	public static void menu() {
		Item.setHeader("ITEM");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add item");
		System.out.println("3. Delete item");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}
	
	public static String retrieveAllitem(ArrayList<Item> itemList) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {

			output += String.format("%-10s %-30s %-10.2f %-10s %-20s\n", itemList.get(i).getName(),
					itemList.get(i).getDescription(),itemList.get(i).getBid_price(), itemList.get(i).getStart_date());
		}
		return output;
	}

	public static void viewAllitem(ArrayList<Item> camcorderList) {
		Item.setHeader("ITEM LIST");
		String output = String.format("%-10s %-30s %-10.2f %-10s %-20s\n", "ITEM NAME", "DESCRIPTION",
				"PRICE", "START DATE","END DATE");
		 
		System.out.println(output);
	}
	
	public static Item inputItem() {
		String name = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		double price = Helper.readInt("Enter price > ");
		String start_date = Helper.readString("Enter start date > ");
		String end_date = Helper.readString("Enter end date > ");

		Item t1= new Item(name, description, price,start_date,end_date);
		return t1;
		
	}
	public static void addItem(ArrayList<Item> itemList, Item t1) {
		
		itemList.add(t1);
		System.out.println("Item added");
	}
}
