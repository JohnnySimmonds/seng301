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
	
}
