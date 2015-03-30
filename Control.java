package D5;

public class Control {

	private user name;
	public userArray uArray;
	public fakeData fakeIt;

	public Control()
	{
	name = new user();
	uArray = new userArray();
	fakeIt = new fakeData(uArray);
	}
	
	public void loginButton(String userName, String password)
	{
		name.setName(userName);
		//check password here? or face book will do this for us
		//next check password? add user to the user array if its not there, otherwise log in. if new user send to new user menu, otherwise go to driver/passenger choice screen
		//the check should probably be done in user?
	}
	public void driverButton()
	{
		name.setDriver();
	}
	
	public void passengerButton()
	{
		name.setPassenger();
	}
	
	public void editBioButton(String newBio)
	{
		name.setBio(newBio);
	}
	
	public void logoutButton()
	{
		name.offline();
	}
	public void userRating(int rating)
	{
		name.addRating(rating);
	}
	
	public void nextButton(String newBio)
	{
		name.setBio(newBio);
	}
	
	public String passengerSend (String message, String driver)
	{
		user temp = uArray.findUser(driver);		///for finding driver user
		
		if(name.findConvo(temp) == null) //figure out how we know if this is the first instance of a convo
		{
			conversation newConvo = new conversation(temp, name);
			newConvo.passengerMessage(message);
			name.addConvo(newConvo);
			return printConvo(newConvo);
		}
		else
		{
			conversation tempConvo = name.findConvo(temp);
			tempConvo.passengerMessage(message);
			name.updateConvo(tempConvo, temp);
			return printConvo(tempConvo);
		}
		
	}
	public String driverSend(String message, String passenger)
	{
		user temp = uArray.findUser(passenger);
		
		conversation tempConvo = temp.findConvo(name);
		tempConvo.driverMessage(message);
		temp.updateConvo(tempConvo, name);
		return printConvo(tempConvo);
	}
	/*
	 * TODO this is probably not part of control?
	 */
	public String printConvo(conversation currConvo)
	{
		message fullConvo = null;
		fullConvo = currConvo.getConvo();
		String printConvo = "";
		while(fullConvo != null)
		{
		printConvo = fullConvo.getsender().getName() + ": " + printConvo + " \n" + fullConvo.getContents();
		fullConvo = fullConvo.getNext();
		}
		return printConvo;
	}
	public user getUser()
	{
		return name;
	}
	public double getRating() {
		return name.getRating();
	}
	public void setRating(double rating) {
		name.addRating(rating);
	}
	public String getUserName() {
		return name.getName();
	}
	public void setUserName(String userName) {
		name.setName(userName);
	}
	public String getBio() {
		return name.getBio();
	}
	public void setBio(String bio) {
		name.setBio(bio);
	}
}
