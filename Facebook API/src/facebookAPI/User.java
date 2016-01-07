package facebookAPI;

import java.util.Date;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class User {
	
	private GraphAPI API = new GraphAPI("CAACEdEose0cBACZBJfd2gP9VUAHH20G2LxgkL3apSICZCQ7guFKEiynZC9vXsAEm35tl0oG6sLQWfUeZBjAkcC9ozn9zBuEwDih5h8hrs3sYCMCwORhDF7IgorS4lbYS3L0wuVWZC9s3x5Gr7ljRccdYVwriMwJAtMGf3XZBtlInSuh36w3OjGwO46wekneynAwddo7bt38FhIjwDrIH6z");
	private String id;
	
	public User(String id){
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
	
	
	public String getName() throws UnirestException{
		return API.getName(id);
	}
	
	public Date getBirthday() throws UnirestException{
		return API.getBirthday(id);
	}
	
	
	public static void main(String[] args) {
		try{
			User alex = new User("613415685427880");
			System.out.println(alex.getBirthday());
			System.out.println(alex.getName());
			System.out.println(alex.getId());
		}
		catch(UnirestException e){
			System.out.print(e.getMessage());
		}
	}
}
