import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Item t1;
	
	private ArrayList<Item> itemList;

	@Before
	public void setUp() throws Exception {
		t1 = new Item ("Penci case", "Storage is good", 2.50,"15/4/2020","17/4/2020");
		itemList= new ArrayList<Item>();
	}

	@After
	public void tearDown() throws Exception {
		t1 = null;
		itemList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Test
	public void addItem() {
			// Item list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid Item arraylist to add to", itemList);
			//Given an empty list, after adding 1 item, the size of the list is 1 - normal
			//The item just added is as same as the first item of the list
			Item.addItem(itemList, t1);
			assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
			assertSame("Check that Item is added", t1, itemList.get(0));
			
			//Add another item. test The size of the list is 2? -normal
			//The item just added is as same as the second item of the list
		}
	@Test
	public void retrieveAllitem() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);
		
		//test if the list of Item retrieved from the SourceCentre is empty - boundary
		String allItem= Item.retrieveAllitem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItemlist", testOutput, allItem);
		
		//Given an empty list, after adding 1 items, test if the size of the list is 1 - normal
		Item.addItem(itemList, t1);
		assertEquals("Test that Item arraylist size is 1", 1, itemList.size());
		
		//test if the expected output string same as the list of item retrieved from the SourceCentre	
		allItem= Item.retrieveAllitem(itemList);
		testOutput = String.format("%-10s %-30s %-10.2f %-10s %-20s\n","Penci case", "Storage is good", 2.50,"15/4/2020","17/4/2020");

	
		assertEquals("Test that ViewAllItemlist", testOutput, allItem);
		
	}

}
