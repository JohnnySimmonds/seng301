package D5;

public class user {
	
	private String name;
   private int id;
	private Float rating;
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
		isDriver = False;
		isPassenger = False;
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
	
	public Float getRating(){
		return rating;
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
	
	public void setBio(String bio){
		this.bio = bio;
	}
	
	public void setPassenger(){
		isPassenger = True;
		isDriver = False;
	}
	
	public void setDriver(){
		isDriver = True;
		isPassenger = False;
	}
   
   public void offline(){
      isDriver = False;
      isPassenger = False;
   }
	
	//Returns True if Passenger or False if Driver, or null if neither
	public Boolean role(){
		if(isPassenger == True)
			return True;
		else if(isDriver == True)
			return False;
      else
         return null;
	}
}