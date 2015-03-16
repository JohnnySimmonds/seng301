package easyRideControl;

public class Control {
/*
we should have it so that if driver is true passenger has to be set to false in the model! and vice versa
 */
	public void driverButton(User userName)
	{
		userName.setDriver();
	}
	
	public void passengerButton(User userName)
	{
		userName.setPassenger();
	}
	
	public void editBioButton(User userName, String newBio)
	{
		userName.setBio(newBio);
	}
	// not 100% sure how this will go to view to display it
	public void userBioButton(User userName)
	{
		userName.getName();
		userName.getBio();
		userName.getRating();
	}
	public void logoutButton(User userName)
	{
		userName.Offline();
	}
	public void userRating(User userName, float rating)
	{
		userName.setRating(rating);
	}
}
