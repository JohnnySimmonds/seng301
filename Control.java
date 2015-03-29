package d5;

public class Control {

	private user name;
	private String userName;
	private String bio;
	private float rating;

	public Control()
	{
	name = new user();
	}
	public void loginButton(String userName, String password)
	{
		name.setName(userName);
		//check password here? or face book will do this for us
		//next check password? add user to the user array if its not there, otherwise log in. if new user send to new user menu, otherwise go to driver/passenger choice screen
		//the check should probably be done in user?
	}
	public void driverButton(user userName)
	{
		userName.setDriver();
	}
	
	public void passengerButton(user userName)
	{
		userName.setPassenger();
	}
	
	public void editBioButton(user userName, String newBio)
	{
		userName.setBio(newBio);
	}
	
	public void userBioButton(user userName) // and for profile button
	{
		this.setUserName(userName.getName());
		this.setBio(userName.getBio());
		this.setRating((float) userName.getRating());
	}
	public void logoutButton(user userName)
	{
		userName.offline();
	}
	public void userRating(user userName, float rating)
	{
		userName.setRating(rating);
	}
	public void nextButton(String newBio)
	{
		name.setBio(newBio);
	}
	
	public conversation passengerSend (String message, user driver, user passenger, conversation currConvo)
	{
		if(currConvo == null) //figure out how we know if this is the first instance of a convo
		{
		conversation newConvo = new conversation(driver, passenger);
		newConvo.passengerMessage(message);
		return newConvo;
		}
		else
		{
			currConvo.passengerMessage(message);
		}
		return currConvo;
	}
	public conversation driverSend(String message, conversation currConvo)
	{
		currConvo.driverMessage(message);
		return currConvo;
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
		return this.name;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
}
