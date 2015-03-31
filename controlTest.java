package D5;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class controlTest {

	@Test
	public void logInButtonTestNewUser()
	{
		Control test = new Control();
		boolean tester;
		String Name = "Johnny";
		String password = "blahblah";
		tester = test.loginButton(Name, password);
		assertEquals(true, tester);
		assertEquals("Johnny", test.getUser().getName());
		assertEquals(password, test.getUser().getPassword());

	}
	@Test
	public void logInButtonTestOldUserFailed()
	{
		Control test = new Control();
		boolean tester;
		String Name = "Johnny";
		String password = "blahblah";
		tester = test.loginButton(Name, password);
		test.logoutButton();
		password = "blah";
		tester = test.loginButton(Name, password);
		assertEquals(false, tester);
		

	}
	
	@Test
	public void logInButtonTestOldUserPassed()
	{
		Control test = new Control();
		boolean tester;
		String Name = "Johnny";
		String password = "blahblah";
		tester = test.loginButton(Name, password);
		test.logoutButton();
		Name = "Johnny";
		password = "blahblah";
		tester = test.loginButton(Name, password);
		assertEquals(true, tester);
		

	}
	
	@Test
	public void driverButtonTest()
	{

		Control test = new Control();
		test.loginButton("Johnny", "a");
		test.driverButton();
		assertEquals(2, test.getUser().role());
	}
	@Test
	public void passengerButtonTest()
	{
		Control test = new Control();
		test.loginButton("Johnny", "a");
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
		test.loginButton("Johnny", "a");
		test.logoutButton();
		assertEquals(0, test.getUser().role());
	}
	@Test
	public void userRatingButton()
	{
	
		Control test = new Control();
		test.loginButton("Johnny", "a");
		double rating = 4.5;
		
		test.userRating(rating);
		
		assertEquals(4.5, test.getRating(), 0.0);
	}
	@Test
	public void nextButton()
	{
		String newBio = "I am the greatest";
		Control test = new Control();
		test.loginButton("Johnny", "a");
		test.getUser().setBio(newBio);
		
		assertEquals("I am the greatest", test.getUser().getBio());
	
	}
	@Test
	public void passengerSendTest()
	{
		Control test = new Control();
		test.loginButton("Johnny", "Cool");
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
		

		assertEquals(newConvo, "Johnny:  \nHi how are you?\nJohnny: \nThats awesome!\nJohnny: \nCool");
		
	}
	@Test
	public void driverSendTest()
	{
		Control test = new Control();
		
		test.loginButton("Johnny","Cool");
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


		assertEquals(newConvo, "Bob:  \nHi how are you?\nJohnny: \nGood thanks and you?");
		
		
	}
	@Test
	public void inviteRideTest()
	{
		Control test = new Control();
		Control BobT = new Control();
		BobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(BobT.getUser());
		BobT.uArray.addUser(test.getUser());
		BobT.getUser().setDriver();
		test.getUser().setPassenger();
		test.sendInvite(BobT.getUserName());
		
		assertEquals(true, BobT.getUser().getInvite());
	}
	@Test
	public void cancelInviteRideTest()
	{
		Control test = new Control();
		Control BobT = new Control();
		BobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(BobT.getUser());
		BobT.uArray.addUser(test.getUser());
		BobT.getUser().setDriver();
		test.getUser().setPassenger();
		test.sendInvite(BobT.getUserName());
		test.cancelInvite(BobT.getUserName());
		
		assertEquals(false, BobT.getUser().getInvite());
		assertEquals(false, test.getUser().getInvite());
		
		test.sendInvite(BobT.getUserName());
		BobT.cancelInvite(test.getUserName());
		
		assertEquals(false, BobT.getUser().getInvite());
		assertEquals(false, test.getUser().getInvite());
			
	}
	@Test
	public void inRideTest()
	{
		Control test = new Control();
		Control BobT = new Control();
		BobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(BobT.getUser());
		BobT.uArray.addUser(test.getUser());
		BobT.getUser().setDriver();
		test.getUser().setPassenger();

		test.sendInvite(BobT.getUserName());
		BobT.acceptInvite(test.getUserName());
		assertEquals("Johnny is not in ride", true, test.getUser().getInRide());
		assertEquals("Bob is not in ride", true, BobT.getUser().getInRide());
		
	
	}
	@Test
	public void endRideTest()
	{
		Control test = new Control();
		Control BobT = new Control();
		BobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(BobT.getUser());
		BobT.uArray.addUser(test.getUser());
		BobT.getUser().setDriver();
		test.getUser().setPassenger();

		test.sendInvite(BobT.getUserName());
		BobT.acceptInvite(test.getUserName());
		
		BobT.endRide(test.getUserName());
		assertEquals("Bob is still in ride", false, BobT.getUser().getInRide());
		assertEquals("Johnny is still in ride", false, test.getUser().getInRide());
		
	}
	@Test
	public void passCheckTestPass()
	{
		Control test = new Control();
		test.loginButton("Johnny", "g");
		test.logoutButton();
		assertEquals(true, test.passCheck("g", "Johnny"));
		
	}
	@Test
	public void passCheckTestFail()
	{
		Control test = new Control();
		test.loginButton("Johnny", "g");
		test.logoutButton();
		assertEquals(false, test.passCheck("fail", "Johnny"));
		
	}
	
}
