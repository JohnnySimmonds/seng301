package D5;
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

		Control test = new Control();
		test.driverButton();
		assertEquals(2, test.getUser().role());
	}
	@Test
	public void passengerButtonTest()
	{
		Control test = new Control();
		test.passengerButton();
		assertEquals(1, test.getUser().role());
	}
	@Test
	public void editBioButtonTest()
	{
		Control test = new Control();
		test.editBioButton("Johnny");
		assertEquals("Johnny", test.getUser().getBio());
	}
	
	@Test
	public void logoutButton()
	{
		Control test = new Control();
		test.logoutButton();
		assertEquals(0, test.getUser().role());
	}
	@Test
	public void userRatingButton()
	{
	
		Control test = new Control();
		double rating = 4.5;
		
		test.userRating(rating);
		System.out.println(test.getRating());
		
		assertEquals(4.5, test.getRating(), 0.0);
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
		test.getUser().setName("Johnny");
		user Bob = new user();
		test.uArray.addUser(Bob);
		String newConvo ="";
		Bob.setDriver();
		Bob.setName("Bob");
		String passSend = "Hi how are you?";
		String passSend2 = "Thats awesome!";
		String passSend3 = "Cool";
		
		newConvo = test.passengerSend(passSend, Bob.getName());
		newConvo = test.passengerSend(passSend2, Bob.getName());
		newConvo = test.passengerSend(passSend3, Bob.getName());
		
			assertEquals(newConvo, "Johnny:  \nHi how are you?\nJohnny:  \nThats awesome!\nJohnny:  \nCool");
		
	}
	@Test
	public void driverSendTest()
	{
		Control test = new Control();
		
		test.uArray.addUser(test.getUser());
		test.getUser().setName("Johnny");
		user Bob = new user();
		test.uArray.addUser(Bob);
		String newConvo ="";
		Bob.setDriver();
		Bob.setName("Bob");
		String passSend = "Hi how are you?";
		String driveSend = "Good thanks and you?";
		conversation tempConvo = new conversation(test.getUser(), Bob);
		tempConvo.passengerMessage(passSend);
		Bob.addConvo(tempConvo);
		newConvo = test.driverSend(driveSend, Bob.getName());


		assertEquals(newConvo, "Bob:  \nHi how are you?\nJohnny:  \nGood thanks and you?");
		
		
	}
}
