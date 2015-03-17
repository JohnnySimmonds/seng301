package D5;

public class userArray{

   public user[] uArray = new user[1000]

   
   public void addUser(user newUser){
      Boolean flag = False;
      int counter = 0;
      int spot = 0;
      int length = 0;
   
      if(uArray.length == 0)
         uArray[0] = newUser;
      else{
         while(flag == False){
            if(uArray[counter] == null)                        //check if the spot is empty
               uArray[counter] = newUser;
            else if(uArray[counter].getID() < newUser.getID())    //check if the user's ID is less than the newUser's ID
               counter++;
            else{
               spot = uArray.length - counter;                    //number of items from the end to the spot
               length = uArray.length;                
               for(int i = length; i > spot; i--){                //moving each item up until it gets to the spot that the newUser should be at
                  uArray[i] = uArray[i + 1];       
               }
               uArray[spot] = newUser;                            //puts the new user at said spot
               flag = True;
            }  
         }
      }
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
         counter++;
      }
   }

}