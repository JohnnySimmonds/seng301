package D5;

public class message{
	
	//private message head = new message();
	private message next = new message();
	private message prev = new message();
	private user sender = new user();
	private user reciever = new user();
	private String contents;
	
	private message(){												//init for messages used in message class
		sender = null;
		reciever = null;
		contents = null;
		next = null;
		prev = null;
	}
	
	public message(user sender, user reciever, String contents){	//all messages must have sender, reciever, and contents
		this.sender = sender;
		this.reciever = reciever;
		this.contents = contents;
		next = null;
		prev = null;
	}
		
	public String getContents(){									//From here down is basic get/set
		return contents;
	}
	
	public user getsender(){
		return sender;
	}
	
	public user getreciever(){
		return reciever;
	}
	
	public message getNext(){
		return next;
	}
	
	public message getPrev(){
		return prev;
	}
			
	public void setNext(message next){						//sets next message in LinkedList
		this.next = next;
	}
	
	public void setPrev(message prev){						//sets previous message in LinkedList
		this.prev = prev;
	}
	
}