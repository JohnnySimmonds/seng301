package D5;

import org.junit.*;
import static org.junit.Assert.*;

public class userArrayTest{
	
	user driver1 = new user();
	user driver2 = new user();
	user passenger1 = new user();
	user passenger2 = new user();
	user offline1 = new user();
	userArray testArray = new userArray();
	
	@Test
	public void test_user_list(){
		testArray.addUser(driver1);
		testArray.addUser(driver2);
		testArray.addUser(passenger1);
		testArray.addUser(passenger2);
		testArray.addUser(offline1);
		
		user[] returnArray = testArray.getUsers();
		
		assertEquals("User1 does not match", returnArray[0], driver1);
		assertEquals("User2 does not match", returnArray[1], driver2);
		assertEquals("User3 does not match", returnArray[2], passenger1);
		assertEquals("User4 does not match", returnArray[3], passenger2);
		assertEquals("User5 does not match", returnArray[4], offline1);
	}

	@Test
	public void test_find_user(){
		testArray.addUser(driver1);
		testArray.addUser(offline1);
		driver1.setName("Ethan");
		offline1.setName("Johnny");
		
		user ethan = testArray.findUser("Ethan");
		user johnny = testArray.findUser("Johnny");
		
		assertEquals("Ethan doesn't match", ethan, driver1);
		assertEquals("Johnny doesn't match", johnny, offline1);
	}
	
	@Test
	public void test_remove_user(){
		testArray.addUser(driver1);
		testArray.addUser(driver2);
		testArray.addUser(offline1);
		
		testArray.removeUser(driver1);
		user[] arry = testArray.getUsers();
		
		assertEquals("Array doesn't match", driver2, arry[0]);
		assertEquals("Second spot not null", null, arry[2]);
	}
	
	@Test
	public void test_get_drivers(){
		testArray.addUser(driver1);
		testArray.addUser(driver2);
		testArray.addUser(passenger1);
		testArray.addUser(passenger2);
		testArray.addUser(offline1);
		
		driver1.setDriver();
		driver2.setDriver();
		passenger1.setPassenger();
		passenger2.setPassenger();
		user[] arry = testArray.getDrivers();
		
		assertEquals("Driver1 not there", driver1, arry[0]);
		assertEquals("Driver2 not there", driver2, arry[1]);

	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void test_get_driver_outOfBounds(){
		testArray.addUser(driver1);
		driver1.setDriver();
		
		user[] arry = testArray.getDrivers();
		user test = arry[1];
	}
	
	@Test
	public void test_get_passengers(){
		testArray.addUser(driver1);
		testArray.addUser(driver2);
		testArray.addUser(passenger1);
		testArray.addUser(passenger2);
		testArray.addUser(offline1);
		
		driver1.setDriver();
		driver2.setDriver();
		passenger1.setPassenger();
		passenger2.setPassenger();
		user[] arry = testArray.getPassengers();
		
		assertEquals("Passenger1 not there", passenger1, arry[0]);
		assertEquals("passenger2 not there", passenger2, arry[1]);

	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void test_get_passenger_outOfBounds(){
		testArray.addUser(passenger1);
		passenger1.setPassenger();
		
		user[] arry = testArray.getPassengers();
		user test = arry[1];
	}
	
}