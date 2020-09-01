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
	private User u2;
	private ArrayList<User> userList;

	@Before
	public void setUp() throws Exception {
		u1 = new User("Penny", "Buyer", "penny@gmail.com", "pass12345", 0, 50);
		u2 = new User("Sam", "Seller", "sam@gmail.com", "pass12345", 0, 100);
		userList = new ArrayList<User>();
	}

	@Test
	public void userDB_test() {
		// fail("Not yet implemented");
		assertTrue("userDB_SampleTest ", true);
	}

	@Test
	public void addUser() {
		// user list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 user, the size of the list is 1 - normal
		// The user just added is as same as the user item of the list
		UserDB.addUser(u1, userList);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));

	}

	@Test
	public void viewAllUser() {
		// User list is not null but empty -boundary
		assertNotNull("Test if there is valid Item arraylist to retrieve item", userList);

		// Test if the list of users retrieved is empty -boundary
		boolean emptyornot = userList.isEmpty();
		boolean expectedAns = true;
		assertEquals("Check that userList is empty", expectedAns, emptyornot);

		// Given an empty list, after adding 1 items, test if the size of the list is 1
		// - normal
		UserDB.addUser(u1, userList);
		assertEquals("Test that user arraylist size is 1", 1, userList.size());

		// test if the expected output string same as the list of user retrieved from
		// the SourceCentre
		String viewUser = UserDB.viewAllUser(userList);
		String testOutput = String.format("%s,%s,%s,%s,%d,%d\n", "Penny", "Buyer", "penny@gmail.com", "pass12345", 0,
				50);
		assertEquals("Test that ViewAllUsert", testOutput, viewUser);

	}

	@Test
	public void delUser() {
		// User list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 user, the size of the userlist is 1 -
		// normal
		UserDB.addUser(u1, userList);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));

		// Now with user added, remove 1 user, the size of the user list is 0 - normal
		UserDB.delUser(u1.getEmail(), userList);
		assertEquals("Check that user arraylist size is 0", 0, userList.size());

	}

	@Test
	public void searchUser() {
		// User list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 user, the size of the userlist is 1 -
		// normal
		UserDB.addUser(u1, userList);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));
		// Search user based on email and ensure user exists by comparison
		String Realoutput = UserDB.searchUser("penny@gmail.com", userList);
		String output = userList.get(0).toString();
		assertEquals("Check that search returns correct user", Realoutput, output);
	}

	@Test
	public void updateAccount() {
		// User list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 user, the size of the userlist is 1 -
		// normal
		UserDB.addUser(u1, userList);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));
		// Update the user's name and password and test that the update has gone through
		// by comparison
		UserDB.updateAccount(userList.get(0), "Benny", "pswrd123", userList);
		String outputName = userList.get(0).getName();
		String outputPass = userList.get(0).getPassword();
		assertEquals("Check that query returns updated name", "Benny", outputName);
		assertEquals("Check that query returns updated password", "pswrd123", outputPass);
	}

	@Test
	public void loginAccount() {
		// User list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 user, the size of the userlist is 1 -
		// normal
		UserDB.addUser(u1, userList);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));
		// Check that account is blocked after 3 failed password attempts
		UserDB.loginAccount(2, "penny@gmail.com", "password12345", userList); //Starts counting from 0,1,2 - 3 numbers
		int Realoutput = userList.get(0).getBlock();
		int output = 1;
		assertSame("Check that user's block flag is activated with 1", Realoutput, output);
	}

	@Test
	public void MblockAccount() {
		// User list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 user, the size of the userlist is 1 -
		// normal
		UserDB.addUser(u1, userList);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));
		// Check that user account can be blocked manually by choice
		UserDB.MblockAccount("Penny", "penny@gmail.com", userList);
		int Realoutput = userList.get(0).getBlock();
		int output = 1;
		assertSame("Check that user's block flag is activated with 1", Realoutput, output);
	}

	@Test
	public void unblockAccount() {
		// User list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 user, the size of the userlist is 1 -
		// normal
		UserDB.addUser(u1, userList);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));
		// Check that user account can be unblocked manually by choice
		UserDB.MblockAccount("Penny", "penny@gmail.com", userList);
		UserDB.unblockAccount("Penny", "penny@gmail.com", userList);
		int Realoutput = userList.get(0).getBlock();
		int output = 0;
		assertSame("Check that user's block flag is deactivated with 0", Realoutput, output);
	}
	
	@Test
	public void generateReport() {
		// User list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 2 users, the size of the userlist is 2 -
		// normal
		UserDB.addUser(u1, userList);
		UserDB.addUser(u2, userList);
		assertEquals("Check that user arraylist size is 2", 2, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));
		assertSame("Check that user is added", u2, userList.get(1));
		//Check that best seller information is generated in report
		String Realoutput = UserDB.generateReport(userList);
		String output = u2.toString();
		assertEquals("Check that query returns best seller's information", Realoutput, output);
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		userList = null;
	}
}
