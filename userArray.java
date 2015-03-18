package D5;

import java.util.*;

public class userArray{

   private user[] uArray = new user[500];         //Array of 500 because this app won't go live
   private List<Integer> driverList = new ArrayList<Integer>();      //ArrayList for drivers because it's easier
   private List<Integer> passengerList = new ArrayList<Integer>();   //ditto ^^

   
   public void addUser(user newUser){
      int length = 0;
   
      length = uArray.length;                     //find spot to put new user in
      uArray[length] = newUser;                     //Put user in
      newUser.setID(length);                        //set ID
   }
   
   public user findUser(int id){					//probably useless
      return uArray[id];
   }
   
   public void removeUser(user rUser){				//remove user from userArray
      int id = rUser.getID();
      int counter = id;
      
      uArray[id] = null;                                 //remove user from Array
      while(uArray[counter] != null){                //Move all users after removed user down a slot
         uArray[counter] = uArray[counter + 1];
         uArray[counter+1].setID(counter);              //set new user's ID's
         counter++;
      }
   }
   
   public void addDriver(user newDriver){
      driverList.add(newDriver.getID());                            //add drivers id to driver list
   }
   
   public void removeDriver(user exDriver){
      driverList.remove(exDriver.getID());                         //remove Driver
   }

   public void addPassenger(user newPassenger){
      driverList.add(newPassenger.getID());                            //add passengers id to passenger list
   }
   
   public void removePassenger(user exPassenger){
      driverList.remove(exPassenger.getID());                          //remove passenger
   }
   
   public int[] getDrivers(){											//returns an int array of all driver's IDs
	   for(int i = 0; i < uArray.length; i++){
		   if(uArray[i].role() == false)								//if user == driver add to driverList
			   addDriver(uArray[i]);
	   }
	   Integer[] list =  driverList.toArray(new Integer[driverList.size()]);	//convert to Integer array
	   int dArray[] = new int[list.length];
	   for(int i = 0; i < list.length; i++)										//convert Integer array to int array
		   dArray[i] = list[i].intValue();
	   return dArray;
   }
   
   public int[] getPassengers(){										//returns and int array of all passenger's IDs
	   for(int i = 0; i < uArray.length; i++){					
		   if(uArray[i].role() == true)									//if user == passenger and to passengerList
			   addPassenger(uArray[i]);
	   }
	   Integer[] list =  passengerList.toArray(new Integer[passengerList.size()]);		//convert to Integer array
	   int pArray[] = new int[list.length];
	   for(int i = 0; i < list.length; i++)												//convert Integer array to int array
		   pArray[i] = list[i].intValue();
	   return pArray;
   }
}