package D5;

public class fakeData{
	private user anne;
	private user frank;
	private user ahmed;
	private user michelle;
	private user brandon;
	
	public fakeData(userArray uArray){
		anne = new user();
		frank = new user();
		ahmed= new user();
		michelle= new user();
		brandon = new user();
		
		anne.setName("Anne");
		frank.setName("Frank");
		ahmed.setName("Ahmed");
		michelle.setName("Michelle");
		brandon.setName("Brandon");
		
		anne.setBio("Hey I'm Anne");
		frank.setBio("I like cars");
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
		
		uArray.addUser(anne);
		uArray.addUser(frank);
		uArray.addUser(ahmed);
		uArray.addUser(michelle);
		uArray.addUser(brandon);
	}
	
	public void fakeDriver(user name){
		
	}
	
}