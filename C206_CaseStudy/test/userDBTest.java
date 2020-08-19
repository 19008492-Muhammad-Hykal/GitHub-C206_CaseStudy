import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Member 1 (Bryent)
public class userDBTest {
	private User u1;
	
	private ArrayList<User> userList;

	@Before
	public void setUp() throws Exception {
		u1 = new User ("Penny", "Buyer", "penny@gmail.com", "pass12345");
		userList= new ArrayList<User>();
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		userList = null;
	}

	@Test
	public void userDB_test() {
		//fail("Not yet implemented"); 
		assertTrue("userDB_SampleTest ",true);
	}
	@Test
	public void addUser() {
			// user list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid user arraylist to add to", userList);
			//Given an empty list, after adding 1 user, the size of the list is 1 - normal
			//The user just added is as same as the user item of the list
			UserDB.addUser(u1);
			assertEquals("Check that user arraylist size is 1", 1, userList.size());
			assertSame("Check that user is added", u1, userList.get(0));
			
		}
	@Test
	public void viewAllUser() {
		//User list is not null but empty -boundary
		assertNotNull("Test if there is valid Item arraylist to retrieve item", userList);
		
		//Test if the list of users retrieved is empty -boundary
		boolean emptyornot = userList.isEmpty();
		boolean expectedAns = true;
		assertEquals("Check that userList is empty", emptyornot, expectedAns);
		
		//Given an empty list, after adding 1 items, test if the size of the list is 1 - normal
		UserDB.addUser(u1);
		assertEquals("Test that user arraylist size is 1", 1, userList.size());
		
		//test if the expected output string same as the list of user retrieved from the SourceCentre	
		User userobj = userList.get(0);
		User testOutput = new User("Penny","Buyer","penny@gmail.com","pass12345");

	
		assertEquals("Test that ViewAllItemlist", testOutput, userobj);
		
	}
	
	@Test
	public void delUser() {
			// Item list is not null, so that can add a new user - boundary
			assertNotNull("Check if there is valid user arraylist to add to", userList);
			//Given an empty list, after adding 1 user, the size of the userlist is 1 - normal
			//The user just added is as same as the first user of the list
			UserDB.addUser(u1);
			assertEquals("Check that user arraylist size is 1", 1, userList.size());
			assertSame("Check that user is added", u1, userList.get(0));
			
			//Now with user added, remove 1 user, the size of the user list  is 0 - normal
			UserDB.delUser(u1.getEmail());
			assertEquals("Check that user arraylist size is 0", 0, userList.size());
			assertSame("Check that user is removed", null, userList.get(0));
		}
}
