package D5;

import static org.junit.Assert.*;

import org.junit.Test;

public class userTest{
	
	user testUser = new user();
		
	@Test
	public void test_name(){
		user.setName("Ethan");
		String name = user.getName();
		if(name.equals("Ethan"))
	}
	
)