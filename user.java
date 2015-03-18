package D5;

public class user {
	
	private String name;
   private int id;
	private double rating;
	private int numRatings;
	private String bio;
	private Boolean isDriver;
	private Boolean isPassenger;
	
	
	public user(){
		name = "";
      id = 0;           //we can use something else for IDs later, an int works for now, start at 0 and add 1 for each user
		rating = 0;
		bio = "";
		numRatings = 0;
		isDriver = false;
		isPassenger = false;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
   
   public int getID(){
      return id;
   }
   
   public void setID(int id){
      this.id = id;
   }
	
	public double getRating(){
		return rating;
	}
	
	public int getNum(){
		return numRatings;
	}
	
	public void addRating(double newRating){
		if (numRatings == 0){
			rating = newRating;
		}
		else {
			double oldRating = rating*numRatings;
			rating = (oldRating + newRating)/(numRatings + 1);
		}
		numRatings += 1;

	}
	
	public String getBio(){
		return bio;
	}
	
	public void setBio(String bio){
		this.bio = bio;
	}
	
	public void setPassenger(){
		isPassenger = true;
		isDriver = false;
	}
	
	public void setDriver(){
		isDriver = true;
		isPassenger = false;
	}
   
   public void offline(){
      isDriver = false;
      isPassenger = false;
   }
	
	//Returns True if Passenger or False if Driver, or null if neither
	public Boolean role(){
		if(isPassenger == true)
			return true;
		else if(isDriver == true)
			return false;
      else
         return null;
	}
}