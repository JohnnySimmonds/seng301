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
	@Test public void nextButtonTest()
	{
		Control test = new Control();
		test.loginButton("Johnny", "g");
		test.firstNextButton("This is the greatest app ever!");
		assertEquals("This is the greatest app ever!", test.getBio());
		
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
		Control bobT = new Control();
		test.loginButton("Johnny", "Cool");
		bobT.loginButton("Bob", "g");
		
		test.uArray.addUser(bobT.getUser());
		String newConvo ="";
		bobT.getUser().setDriver();
		String passSend = "Hi how are you?";
		String passSend2 = "Thats awesome!";
		String passSend3 = "Cool";
		
		newConvo = test.passengerSend(passSend, bobT.getUserName());
		newConvo = test.passengerSend(passSend2, bobT.getUserName());
		newConvo = test.passengerSend(passSend3, bobT.getUserName());
		

		assertEquals(newConvo, "Johnny:  \nHi how are you?\nJohnny: \nThats awesome!\nJohnny: \nCool");
		
	}
	@Test
	public void driverSendTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		test.loginButton("Johnny","Cool");
		bobT.loginButton("Bob", "g");
		
		test.uArray.addUser(bobT.getUser());
		String newConvo ="";
		bobT.getUser().setDriver();
		String passSend = "Hi how are you?";
		String driveSend = "Good thanks and you?";
		String driveSend2 = "I will come getcha";
		conversation tempConvo = new conversation(test.getUser(), bobT.getUser());
		tempConvo.passengerMessage(passSend);
		bobT.getUser().addConvo(tempConvo);
		newConvo = test.driverSend(driveSend, bobT.getUser().getName());
		newConvo = test.driverSend(driveSend2, bobT.getUser().getName());

		assertEquals(newConvo, "Bob:  \nHi how are you?\nJohnny: \nGood thanks and you?\nJohnny: \nI will come getcha");
		
		
	}
	@Test
	public void saveConvoTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		test.loginButton("Johnny", "Cool");
		bobT.loginButton("Bob", "g");
		
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		String newConvo ="";
		bobT.getUser().setDriver();
		String passSend = "Hi how are you?";
		String passSend2 = "Thats awesome!";
		String passSend3 = "Cool";
		
		newConvo = test.passengerSend(passSend, bobT.getUserName());
		newConvo = test.passengerSend(passSend2, bobT.getUserName());
		newConvo = test.passengerSend(passSend3, bobT.getUserName());
		
		newConvo = test.printConvo(test.getUserName(), bobT.getUserName());
		assertEquals("Johnny:  \nHi how are you?\nJohnny: \nThats awesome!\nJohnny: \nCool", newConvo);
	}
	@Test
	public void inviteRideTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		bobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		bobT.getUser().setDriver();
		test.getUser().setPassenger();
		test.sendInvite(bobT.getUserName());
		
		assertEquals(true, bobT.getUser().getInvite());
	}
	@Test
	public void cancelInviteRideTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		bobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		bobT.getUser().setDriver();
		test.getUser().setPassenger();
		test.sendInvite(bobT.getUserName());
		test.cancelInvite(bobT.getUserName());
		
		assertEquals(false, bobT.getUser().getInvite());
		assertEquals(false, test.getUser().getInvite());
		
		test.sendInvite(bobT.getUserName());
		bobT.cancelInvite(test.getUserName());
		
		assertEquals(false, bobT.getUser().getInvite());
		assertEquals(false, test.getUser().getInvite());
			
	}
	@Test
	public void inRideTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		bobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		bobT.getUser().setDriver();
		test.getUser().setPassenger();

		test.sendInvite(bobT.getUserName());
		bobT.acceptInvite(test.getUserName());
		assertEquals("Johnny is not in ride", true, test.getUser().getInRide());
		assertEquals("Bob is not in ride", true, bobT.getUser().getInRide());
		
	
	}
	@Test
	public void endRideTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		bobT.loginButton("Bob", "g");
		test.loginButton("Johnny","Cool");
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		bobT.getUser().setDriver();
		test.getUser().setPassenger();

		test.sendInvite(bobT.getUserName());
		bobT.acceptInvite(test.getUserName());
		
		bobT.endRide(test.getUserName());
		assertEquals("Bob is still in ride", false, bobT.getUser().getInRide());
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
	@Test
	public void driverPassengerListTest() // tests checkDriverMessages
	{
		Control test = new Control();
		Control bobT = new Control();
		bobT.loginButton("Bob", "b");
		test.loginButton("Johnny", "b");
		bobT.getUser().setDriver();
		test.getUser().setPassenger();
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		test.passengerSend("Hi", bobT.getUserName());
		String[] listCheck = bobT.checkDriverMessages();
		String listOfNames = "";
		for(int i =0; listCheck[i] != null; i++)
		{
			listOfNames = listOfNames  + listCheck[i] + "\n";
		}
		System.out.print(listOfNames);
		assertEquals("Johnny\n", listOfNames);
	}
	@Test
	public void driverListTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		bobT.loginButton("Bob", "b");
		test.loginButton("Johnny", "b");
		bobT.getUser().setDriver();
		test.getUser().setPassenger();
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		test.passengerSend("Hi", bobT.getUserName());
		String[] listCheck = test.getDrivers();
		String listOfNames = "";
		for(int i =0; (i < listCheck.length && listCheck[i] != null); i++)
		{
			listOfNames = listOfNames  + listCheck[i] + "\n";
		}
		System.out.print(listOfNames);
		assertEquals("Ahmed\nMichelle\nBrandon\nBob\n", listOfNames);
	}
	@Test
	public void passengerListTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		bobT.loginButton("Bob", "b");
		test.loginButton("Johnny", "b");
		bobT.getUser().setDriver();
		test.getUser().setPassenger();
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		test.passengerSend("Hi", bobT.getUserName());
		String[] listCheck = bobT.getPassengers();
		String listOfNames = "";
		for(int i =0; (i < listCheck.length && listCheck[i] != null); i++)
		{
			listOfNames = listOfNames  + listCheck[i] + "\n";
		}
		System.out.print(listOfNames);
		assertEquals("Anne\nFrank\nJohnny\n", listOfNames);
	}
	@Test
	public void printConvoTest()
	{
		Control test = new Control();
		Control bobT = new Control();
		String convo = "";
		bobT.loginButton("Bob", "b");
		test.loginButton("Johnny", "b");
		test.uArray.addUser(bobT.getUser());
		bobT.uArray.addUser(test.getUser());
		bobT.getUser().setDriver();
		test.getUser().setPassenger();
		convo = test.printConvo(test.getUserName(), bobT.getUserName());
		
		assertEquals("", convo);
	}
}
