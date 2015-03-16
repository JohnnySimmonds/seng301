package D5;

import static org.junit.Assert.*;

import org.junit.Test;

public class userTest{
	
	user testUser = new user();
		
	@Test
	public void test_name(){
		testUser.setName("Ethan");
		String name = testUser.getName();
		if(name.equals("Ethan"))
	}
	
   @Test
	public void test_bio(){
		testUser.setBio("Hi I'm Ethan");
		String bio = testUser.getBio();
		if(bio.equals("Hi I'm Ethan"))
	}
   
   @Test
	public void test_rating(){
		testUser.setRating(5);
      testUser.setRating(4);
      testUser.setRating(4);
      testUser.setRating(2);
      testUser.setRating(3);
		Float rating = testUser.getRating();
		if(rating == 3.6)
	}
   
   @Test
   public void test_driver(){
		testUser.setDriver();
		if(testUser.role == False)
	}
	
   @Test
   public void test_passenger(){
		testUser.setPassenger();
		if(testUser.role == True)
	}
   
   @Test
   public void test_offline(){
      testUser.offline();
      if(testUser.role == null)
   }
   
   
)