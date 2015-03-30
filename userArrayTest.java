package D5;

import org.junit.*;
import static org.junit.Assert.*;

public class userArrayTest{
	
	private user driver1 = new user();
	user driver2 = new user();
	user passenger1 = new user();
	user passenger2 = new user();
	user offline1 = new user();
	userArray testArray = new userArray();
	
	@Test
	public void test_user_list(){
		testArray.addUser(driver1);
	}

	
	
}