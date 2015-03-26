package d5;

public class Control {

	private user name;


	public Control()
	{
	name = new user();
	}
	public void loginButton(String userName, String password)
	{
		name.setName(userName);
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
	// not 100% sure how this will go to view to display it
	public void userBioButton(user userName)
	{
		userName.getName();
		userName.getBio();
		userName.getRating();
	}
	public void logoutButton(user userName)
	{
		userName.offline();
	}
	public void userRating(user userName, float rating)
	{
		userName.setRating(rating);
	}
	
	public user getUser()
	{
		return this.name;
	}
}
