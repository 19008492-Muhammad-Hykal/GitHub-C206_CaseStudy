import java.util.ArrayList;

public class itemdb {

	public static void main(String[] args) {
	
	ArrayList<Item> itemList = new ArrayList<Item>();
	Item t1 = new Item ("Penci case", "Storage is good", 2.50,"15/4/2020","17/4/2020");
	
	
	int option = 0;

	while (option != 6) {

		itemdb.menu();
		option = Helper.readInt("Enter an option > ");

		if (option == 1) {
			// View all items
			itemdb.viewAllitem(itemList);
		} else if (option == 2) {
			// Add a new item
			itemdb.setHeader("ADD");			
			Item addItem = inputItem();
			itemdb.addItem(itemList, addItem);

		} else if (option == 3) {
			// Delete item
			itemdb.setHeader("DELETE");			
			itemdb.deleteItem(itemList);
		} else if (option == 4) {
			// Search item
			itemdb.searchByName(null, itemList);
		}
		else if (option == 5) {
			// Update item
			itemdb.setHeader("UPDATE");	
			itemdb.updateItem(itemList);
		}
		else if (option == 6) {
			System.out.println("Bye!");
		} else {
			System.out.println("Invalid option");
		}
	}
}

  public static void menu() {
	itemdb.setHeader("ITEM");
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

		output += String.format("%-10s %-30s %-10.2f %-10s %-10s\n", itemList.get(i).getName(),
				itemList.get(i).getDescription(),itemList.get(i).getBid_price(), itemList.get(i).getStart_date(),itemList.get(i).getEnd_date());
	}
	return output;
}

public static void viewAllitem(ArrayList<Item> itemList) {
	itemdb.setHeader("ITEM LIST");
	String output = String.format("%-10s %-30s %-10s %-10s %-10s\n", "ITEM NAME", "DESCRIPTION",
			"PRICE", "START DATE","END DATE");
	output += retrieveAllitem(itemList);	
	System.out.println(output);
}

public static Item inputItem() {
	String name = Helper.readString("Enter item name > ");
	String description = Helper.readString("Enter description > ");
	double price = Helper.readDouble("Enter price > ");
	String start_date = Helper.readString("Enter start date > ");
	String end_date = Helper.readString("Enter end date > ");

	Item addItem = new Item(name, description, price,start_date,end_date);
	return addItem;
	
}
public static void addItem(ArrayList<Item> itemList, Item addItem) {
	
	itemList.add(addItem);
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
	itemdb.viewAllitem(itemList);
	String name1 = Helper.readString("Enter item name > ");
	Boolean isDelete =doDelete(itemList, name1);
	if (isDelete == false) {
		System.out.println("Invalid name");
	} else {
		for (int i = 0; i < itemList.size(); i++) {
			if(name1.contains(itemList.get(i).getName())){
				itemList.remove(i);
			}
		}
	}
}
public static String searchByName(String name,ArrayList<Item> itemList) {
	Helper.line(40, "=");
	System.out.println("SEARCH BY ITEM NAME OR DESCRIPTION ");
	Helper.line(40, "=");
	String user1 = Helper.readString("Enter name to search > ");
	String output = String.format("%-10s %-30s %-10s %-10s %-10s\n", "ITEM NAME", "DESCRIPTION",
			"PRICE", "START DATE","END DATE");
    for (int i = 0; i < itemList.size(); i++) {
    	if(user1.contains(itemList.get(i).getName()) || (user1.contains(itemList.get(i).getDescription()))) {
    		output += String.format("%-10s %-30s %-10.2f %-10s %-10s\n", itemList.get(i).getName(),
					itemList.get(i).getDescription(),itemList.get(i).getBid_price(), itemList.get(i).getStart_date(),itemList.get(i).getEnd_date());
    		System.out.println(output);
    	}
    	else {
    		if(user1 != itemList.get(i).getName() || (user1 != itemList.get(i).getDescription()))
    		System.out.println("Invaild");
    	}

}
	return output;
}
public static void updateItem(ArrayList<Item> itemList) {
	boolean isCorrect = false;

	String itemname = Helper.readString("Enter item name to update >");
	for (int i = 0; i < itemList.size(); i++) {
	if(itemname.equals(itemList.get(i).getName())) {
		isCorrect = true;
		String newname = Helper.readString("Enter new item name >");
		String newdec = Helper.readString("Enter new item description >");
		double newprice = Helper.readDouble("Enter new price >");
		String newstart = Helper.readString("Enter new start date >");
		String newend = Helper.readString("Enter new end date >");
		if (newprice == itemList.get(i).getBid_price()) {
			System.out.println("There is no change in your price");
		}
		else if(newname.equals(itemList.get(i).getName())) {
			System.out.println("There is no change in your item name");
		}
		else if(newdec.equals(itemList.get(i).getDescription())) {
			System.out.println("There is no change in your item decscription");
		}
		else if(newstart.equals(itemList.get(i).getStart_date())) {
			System.out.println("There is no change in your start date");
		}
		else if(newend.equals(itemList.get(i).getEnd_date())) {
			System.out.println("There is no change in your end date");
		}
		else {
			itemList.get(i).setName(newname);
			itemList.get(i).setDescription(newdec);
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

