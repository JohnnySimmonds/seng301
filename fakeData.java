package D5;



public class fakeData{
	private user anne;
	private user frank;
	private user ahmed;
	private user michelle;
	private user brandon;
	private Control anneC;
	private Control frankC;
	private Control ahmedC;
	private Control michelleC;
	private Control brandonC;
	private boolean sentInvite;
	
	
	public fakeData(userArray uArray){
		anne = new user();											//creating fake users with names, bios, ratings, and roles
		frank = new user();
		ahmed= new user();
		michelle= new user();
		brandon = new user();
		
		anne.setName("Anne");
		frank.setName("Frank");
		ahmed.setName("Ahmed");
		michelle.setName("Michelle");
		brandon.setName("Brandon");
		
		anne.setPassword("Annee");
		frank.setPassword("Franke");
		ahmed.setPassword("Ahmede");
		michelle.setPassword("Michellee");
		brandon.setPassword("Brandone");
		
		anne.setBio("Hey I'm Anne");
		frank.setBio("I like to drink");
		ahmed.setBio("I'll drive you anywhere :)");
		michelle.setBio("I charge 20 bucks");
		brandon.setBio("Wassup Imma drive u all ovr");
		
		anne.addRating(5);
		frank.addRating(5);
		ahmed.addRating(1);
		michelle.addRating(3);
		brandon.addRating(2);
		
		anne.setPassenger();
		frank.setPassenger();
		ahmed.setDriver();
		michelle.setDriver();
		brandon.setDriver();
		
		anneC = new Control(anne, uArray);											//creating controllers for each fake person
		frankC = new Control(frank, uArray);
		ahmedC = new Control(ahmed, uArray);
		michelleC = new Control(michelle, uArray);
		brandonC = new Control(brandon, uArray);
		
		anneC.loginButton(anne.getName(), "");									//logging them all in
		frankC.loginButton(frank.getName(), "");
		ahmedC.loginButton(ahmed.getName(), "");
		michelleC.loginButton(michelle.getName(), "");
		brandonC.loginButton(brandon.getName(), "");
		
		sentInvite = false;
		
	}
	
	public void fakeDriver(String name){										//when you become a driver, they all message you
		 anneC.passengerSend("Hey!", name);
		 frankC.passengerSend("Watsup ;)", name);
		 if(sentInvite == false){
			frankC.fakeSendInvite(name);													//Frank likes you, wants you to drive him
			sentInvite = true;
		 }
	}	
	
	public void fakePassenger(String name){										//when you become a passenger, they will all accept to drive you
		if(ahmed.findInvite(name) == true){
			ahmedC.acceptInvite(name);
		}
		
		if(michelle.findInvite(name) == true){
			michelleC.acceptInvite(name);
		}
		
		if(brandon.findInvite(name) == true){
			brandonC.acceptInvite(name);
		}
	}
	
	public void fakeEndRide(user name){
		name.addRating(3.5);
	}
}