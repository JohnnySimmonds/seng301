package D5;

public class user {
	
	private String name;
	private Float rating;
	private int numRatings;
	private String bio;
	private Boolean isDriver;
	private Boolean isPassenger;
	
	
	public user(){
		name = "";
		rating = 0;
		bio = "";
		numRatings = 0;
		isDriver = False;
		isPassenger = False;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Float getRating(){
		return this.rating;
	}
	
	public void setRating(Float newRating){
		if numRatings == 0{
			rating = newRating;
		}
		else if numRatings == 1{
			rating = (newRating + rating)/2
		}
		else {
			rating = rating*((numRatings-1)/numRatings) + (newRating/numRatings);
			numRatings +=1;
		}

	}
	
	public String getBio(){
		return this.bio;
	}
	
	public void setBio(String newBio){
		this.bio = newBio;
	}
	
	public void setPassenger(){
		this.isPassenger = True;
		this.isDriver = False;
	}
	
	public void setDriver(){
		this.isDriver = True;
		this.isPassenger = False;
	}
   
   public void offline(){
      this.isDriver = False;
      this.isPassenger = False;
   }
	
	//Returns True if Passenger or False if Driver
	public Boolean role(){
		if(isPassenger == True)
			return True;
		else
			return False;
	}
}