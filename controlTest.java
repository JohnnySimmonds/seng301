package d5;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class controlTest {

	@Test
	public void driverButtonTest()
	{
		user userName = new user();
		userName.setName("Johnny");
		Control test = new Control();
		test.driverButton(userName);
		assertEquals(userName.role(), false);
	}
	@Test
	public void passengerButtonTest()
	{
		user userName = new user();
		userName.setName("Johnny");
		Control test = new Control();
		test.passengerButton(userName);
		assertEquals(userName.role(), true);
	}
	@Test
	public void editBioButtonTest()
	{
		user userName = new user();
	
		Control test = new Control();
		test.editBioButton(userName, "Johnny");
		assertEquals(userName.getBio(), "Johnny");
	}
	/*
	@Test
	public void userBioButtonTest()
	{
		user userName = new user();
	
		Control test = new Control();
		userName.setName("Johnny");
		userName.setBio("I am sexy);");
		userName.setRating(5.0);
		
		test.userBioButton(userName);
		
	}
*/ //not exactly sure how to test this yet
	@Test
	public void logoutButton()
	{
		user userName = new user();
	
		Control test = new Control();
		test.logoutButton(userName);
		assertEquals(userName.role(), false);
	}
	@Test
	public void userRatingButton()
	{
		user userName = new user();
		Control test = new Control();
		float rating = (float) 4.5;
		
		test.userRating(userName, rating);
		assertEquals(userName.getRating(), 4.5, 0.000000);
	}
}
