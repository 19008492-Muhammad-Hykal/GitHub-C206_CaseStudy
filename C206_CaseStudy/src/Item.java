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
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		
		int option = 0;

		while (option != 4) {

			Item.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				Item.viewAllitem(itemList);
			} else if (option == 2) {
				// Add a new item
				Item.setHeader("ADD");			
				Item t1 = inputItem();
				Item.addItem(itemList, t1);

			} else if (option == 3) {
				// Delete item
				Item.setHeader("DELETE");			
                Item.deleteItem(itemList);
			} else if (option == 4) {
				// Search item
				Item.searchByName(itemList);
			}
			else if (option == 5) {
				// Search item
				Item.updateItem(itemList);
			}
			else if (option == 6) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}
		
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


	public static void menu() {
		Item.setHeader("ITEM");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add item");
		System.out.println("3. Delete item");
		System.out.println("4. Search by name or descrption");
		System.out.println("5. Update item");
		System.out.println("6. Quit");
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
    public static boolean doDelete(ArrayList<Item> itemList, String name) {
		
		boolean isDelete= false;

		for (int i = 0; i < itemList.size(); i++) {
			
			String name1 = itemList.get(i).getName();
			
			if (name.equalsIgnoreCase(name1)) {
				
				isDelete = true;
				name = null;
				
				
			}
		}
		return isDelete;
	}

	public static void deleteItem(ArrayList<Item> itemList) {
		Item.viewAllitem(itemList);
		String name1 = Helper.readString("Enter item name > ");
		Boolean isDelete =doDelete(itemList, name1);
		if (isDelete == false) {
			System.out.println("Invalid name");
		} else {
			
		}
	}
	public static void searchByName(ArrayList<Item> itemList) {
		Helper.line(40, "=");
		System.out.println("SEARCH FOR GAMERS BY NAME");
		Helper.line(40, "=");
		String user = Helper.readString("Enter name to search > ");
		String output = String.format("%-10s %-30s %-10.2f %-10s %-20s\n", "ITEM NAME", "DESCRIPTION",
				"PRICE", "START DATE","END DATE");
        for (int i = 0; i < itemList.size(); i++) {
        	if(user.contains(itemList.get(i).getName()) || (user.equals(itemList.get(i).getDescription()))) {
        		output += String.format("%-10s %-30s %-10.2f %-10s %-20s\n", itemList.get(i).getName(),
    					itemList.get(i).getDescription(),itemList.get(i).getBid_price(), itemList.get(i).getStart_date());
        		System.out.println(output);
        	}

	}
}
	public static void updateItem(ArrayList<Item> itemList) {
    	boolean isCorrect = false;

    	String itemname = Helper.readString("Enter item name to update >");
    	for (int i = 0; i < itemList.size(); i++) {
		if(itemname.equals(itemList.get(i).getName())) {
			isCorrect = true;
			double newprice = Helper.readDouble("Enter new price >");
			String newstart = Helper.readString("Enter new start date >");
			String newend = Helper.readString("Enter new end date >");
			if (newprice == itemList.get(i).getBid_price()) {
				System.out.println("There is no change in your price");
			}
			else if(newstart.equals(itemList.get(i).getStart_date())) {
				System.out.println("There is no change in your start date");
			}
			else if(newend.equals(itemList.get(i).getEnd_date())) {
				System.out.println("There is no change in your end date");
			}
			else {
				itemList.get(i).setBid_price(newprice);
				itemList.get(i).setStart_date(newstart);
				itemList.get(i).setEnd_date(newend);
			}
			
		}
		else {
			System.out.println("***Invaild Item Name!");
			itemname = Helper.readString("Enter item name to update >");
		}
    }
  }
}
