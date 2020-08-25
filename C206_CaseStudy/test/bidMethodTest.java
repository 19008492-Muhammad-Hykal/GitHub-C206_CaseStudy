//Created by Hykal at 19/9/2020

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class bidMethodTest {
	
	private bid b1;
	
	private ArrayList<bid> bidList;
	
	public bidMethodTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		b1 = new bid(2,40,"KEYBOARD","seller@mail.com","buyer@mail.com");
		bidList = new ArrayList<bid>();
	}
	
	@Test
	
	public void addBidTest() {
		// Item list is not null, so that can add a new item - Boundary Test
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - Normal Test
		bidMethod.addBid(bidList, b1);		
		assertEquals("Test if that bid arraylist size is 1?", 1, bidList.size());
		
		//The item just added is as same as the first item of the list - Error Test
		assertSame("Test that Bid is added same as 1st item of the list?", b1, bidList.get(0));
		
	}
	
	public void retrieveAllBidTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);
		
		//test if the list of Bid retrieved from the bidMethod is empty
				String allBid= bidMethod.retrieveAllBidding(bidList);
				String testOutput = "";
				assertEquals("Check that ViewAllBidlist", testOutput, allBid);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		bidMethod.addBid(bidList, b1);
	
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, bidList.size());
		
		//test if the expected output string same as the list of Bids retrieved 
		allBid= bidMethod.retrieveAllBidding(bidList); 

		testOutput = String.format("%-10d %-30f %-10s %-10s %-20s\n",2,40,"KEYBOARD","seller@mail.com","buyer@mail.com");
		
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allBid);
		
	}
	
	public void deleteBidTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);
		
		//Given an empty list, after adding 1 Bid, the size of the bidList is 1 - normal
		//The Bid added is as the same as the first bid of the bidList
		bidMethod.addBid(bidList,b1);
		assertEquals("Check that Bid arraylist size is 1", 1, bidList.size());
		assertSame("Check that a bid is added", b1, bidList.get(0));
		
		//With a Bid being added, remove 1 Bid, the size of the bidList  is 0 - normal
		bidMethod.deleteBid(bidList);
		assertEquals("Check that Bid arraylist size is 0", 0, bidList.size());
		assertSame("Check that Bid is removed", null, bidList.get(0));
	}
	
	@Test
	public void searchBid() {
		// Item list is not null, so that can add a bid - boundary
		assertNotNull("Check if there is valid user arraylist to add to", bidList);
		// Given an empty list, after adding 1 bid, the size of the bidlist is 1 -
		// normal
		bidMethod.addBid(bidList,b1);
		assertEquals("Check that user arraylist size is 1", 1, bidList.size());
		assertSame("Check that user is added", b1, bidList.get(0));
		// Search user based on item Name and ensure user exists by comparison
		String Realoutput = bidMethod.searchByItemName(bidList);
		String output = bidList.get(0).toString();
		assertEquals("Check that search returns correct user", Realoutput, output);
	}

	
	public void updateAccount() {
		// Bid list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", bidList);
		// Given an empty list, after adding 1 Bid, the size of the bidlist is 1 -
		// normal
		bidMethod.addBid(bidList,b1);
		assertEquals("Check that bid arraylist size is 1", 1, bidList.size());
		assertSame("Check that Bid is added", b1, bidList.get(0));
		// Update the Bid price and test that the update has gone through
		// by comparison
		bidMethod.updateBid(bidList);
		double id = bidList.get(0).getBid_price();
		assertEquals("Check that query returns updated price", 20, id,0);
	
	}
	
}
