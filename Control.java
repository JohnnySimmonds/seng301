package D5;

public class Control {

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
	public void userRating(user userName, double rating)
	{
		userName.addRating(rating);
	}
}
