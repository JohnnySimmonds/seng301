package D5;

import org.junit.*;
import static org.junit.Assert.*;

public class testConvo{
	
	user driver = new user();
	user passenger = new user();
	conversation convo = new conversation(driver, passenger);

	@Test
	public void test_no_convo(){
		assertTrue(convo.getConvo() == null);
		
	}
	
	@Test
	public void test_convo(){		
		convo.passengerMessage("This is the head");							//Start new conversation
		message head = convo.getConvo();
		assertTrue("Head is null", head != null);							//Test head and next message
		assertTrue("Next is not null",head.getNext() == null);
		assertTrue("Content is not right", head.getContents() == "This is the head");
		
		convo.driverMessage("This is the second message");					//driver sends message
		head = convo.getConvo();	
		assertTrue("Second message doesn't exist", head.getNext() != null);			//Test message exists in list
		message dMessage = head.getNext();
		assertTrue("second message is not right", dMessage.getContents() == "This is the second message");		//Test contents of message
		
		convo.passengerMessage("This is the third message");					//send new passenger message
		head = convo.getConvo();
		message tMessage = head.getNext().getNext();
		assertTrue("Third message doesn't exist", tMessage != null);					//test if there
		assertTrue("Third message is not right", tMessage.getContents() == "This is the third message");		//test content
		
	}
	
	
	
}