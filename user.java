package D5;

public class user {
	
	public String name;
	public Float rating;
	public int numRatings;
	public String bio;
	public Boolean isDriver;
	public Boolean isPassenger;
	
	
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
		return name;
	}
	
	public Float getRating(){
		return Rating;
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
		return bio;
	}
	
	public void setBio(String newBio){
		bio = newBio;
	}
	
	public void setPassenger(){
		isPassenger = True;
		isDriver = False;
	}
	
	public void setDriver(){
		isDriver = True;
		isPassenger = False;
	}
	
	//Returns True if Passenger or False if Driver
	public Boolean role(){
		if(isPassenger == True)
			return True;
		else
			return False;
	}
}