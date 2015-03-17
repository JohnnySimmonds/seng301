package D5;

public class userArray{

   public user[] uArray = new user[1000]

   
   public void addUser(user newUser){
      int length = 0;
   
      length = uArray.length();                     //find spot to put new user in
      uArray[length] = newUser;                     //Put user in
      newUser.setID(length);                        //set ID
   }
   
   public user findUser(int id){
      return uArray[id];
   }
   
   public void removeUser(user rUser){
      id = rUser.getID;
      int counter = id;
      
      uArray[id] = null;                                 //remove user from Array
      while(uArray[counter] != null){                //Move all users after removed user down a slot
         uArray[counter] = uArray[counter + 1];
         uArray[counter+1].setID(counter);              //set new user's ID's
         counter++;
      }
   }

}