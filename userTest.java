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
	
   @Test
	public void test_bio(){
		user.setBio("Hi I'm Ethan");
		String bio = user.getBio();
		if(bio.equals("Hi I'm Ethan"))
	}
   
   @Test
	public void test_rating(){
		user.setRating(5);
      user.setRating(4);
      user.setRating(4);
      user.setRating(2);
      user.setRating(3);
		Float rating = user.getRating();
		if(rating == 3.6)
	}
   
   @Test
   public void test_driver(){
		user.setDriver;
		if(user.role == False)
	}
	
   @Test
   public void test_passenger(){
		user.setPassenger;
		if(user.role == True)
	}
)