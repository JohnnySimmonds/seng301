package d5;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class controlTest {

	@Test
	public void logInButtonTest()
	{
		Control test = new Control();
		String Name = "Johnny";
		String password = "blahblah";
		
		test.loginButton(Name, password);
		assertEquals("Johnny", test.getUser().getName());

	}
	@Test
	public void driverButtonTest()
	{
		user userName = new user();
		userName.setName("Johnny");
		Control test = new Control();
		test.driverButton(userName);
		assertEquals(false, userName.role());
	}
	@Test
	public void passengerButtonTest()
	{
		user userName = new user();
		userName.setName("Johnny");
		Control test = new Control();
		test.passengerButton(userName);
		assertEquals(true, userName.role());
	}
	@Test
	public void editBioButtonTest()
	{
		user userName = new user();
	
		Control test = new Control();
		test.editBioButton(userName, "Johnny");
		assertEquals("Johnny", userName.getBio());
	}
	
	@Test
	public void userBioButtonTest()
	{
		user userName = new user();
	
		Control test = new Control();
		userName.setName("Johnny");
		userName.setBio("I am sexy");
		userName.setRating(5.0);
		
		test.userBioButton(userName);
		assertEquals("Johnny", test.getUserName());
		assertEquals("I am sexy", test.getBio());
		assertEquals(5.0, test.getRating(), 0.00000);
	}

	@Test
	public void logoutButton()
	{
		user userName = new user();
	
		Control test = new Control();
		test.logoutButton(userName);
		assertEquals(false, userName.role());
	}
	@Test
	public void userRatingButton()
	{
		user userName = new user();
		Control test = new Control();
		float rating = (float) 4.5;
		
		test.userRating(userName, rating);
		assertEquals(4.5, userName.getRating(), 0.000000);
	}
	@Test
	public void nextButton()
	{
		String newBio = "I am the greatest";
		Control test = new Control();
		test.getUser().setBio(newBio);
		
		assertEquals("I am the greatest", test.getUser().getBio());
	
	}
	@Test
	public void passengerSendTest()
	{
		Control test = new Control();
		user Johnny = new user();
		user Bob = new user();
		conversation testConvo = null;
		Bob.setDriver();
		Johnny.setPassenger();
		String passSend = "Hi how are you?";
		String passSend2 = "Thats awesome!";
		String passSend3 = "Cool";
		
		testConvo = test.passengerSend(passSend, Bob, Johnny, testConvo);
		testConvo = test.passengerSend(passSend2, Bob, Johnny, testConvo);
		testConvo = test.passengerSend(passSend3, Bob, Johnny, testConvo);
		message convo = testConvo.getConvo();
		
		
		if(convo != null)
		{
			assertEquals(convo.getContents(), "Hi how are you?");
		}
		if(convo.getNext() != null)
		{
			assertEquals(convo.getNext().getContents(), "Thats awesome!");
		
		}
		if(convo.getNext().getNext() != null)
		{
			assertEquals(convo.getNext().getNext().getContents(), "Cool");
		}
		
	}
	@Test
	public void driverSendTest()
	{
		Control test = new Control();
		user Johnny = new user();
		user Bob = new user();
		conversation testConvo = null;
		Bob.setDriver();
		Johnny.setPassenger();
		String passSend = "Hi how are you?";
		String driveSend = "Good thanks and you?";
		testConvo = test.passengerSend(passSend, Bob, Johnny, testConvo);
		testConvo = test.driverSend(driveSend, testConvo);
		message convo = testConvo.getConvo();
		
		assertEquals(convo.getNext().getContents(), "Good thanks and you?");
		
		
	}
}
