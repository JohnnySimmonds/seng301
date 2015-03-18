package D5;

import org.junit.*;
import static org.junit.Assert.*;

public class userTest{
	
	user testUser = new user();
		
	@Test
	public void test_name(){
		testUser.setName("Ethan");
		String name = testUser.getName();
		assertTrue("Name should be Ethan", name.equals("Ethan"));
	}
	
   @Test
	public void test_bio(){
		testUser.setBio("Hi I'm Ethan");
		String bio = testUser.getBio();
		assertTrue("Bio is not equal", bio.equals("Hi I'm Ethan"));
	}
   
   @Test
	public void test_rating(){
		testUser.addRating(5);
		testUser.addRating(4);
		testUser.addRating(4);
		testUser.addRating(2);
		testUser.addRating(3);
		double rating = testUser.getRating();
		assertTrue(rating == 3.6);
	}
   
   @Test
   public void test_driver(){
		testUser.setDriver();
		assertTrue(testUser.role() == false);
	}
	
   @Test
   public void test_passenger(){
		testUser.setPassenger();
		assertTrue(testUser.role() == true);
	}
   
   @Test
   public void test_offline(){
      testUser.offline();
      assertTrue(testUser.role() == null);
   }
}