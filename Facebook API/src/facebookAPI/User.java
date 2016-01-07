package facebookAPI;

import java.util.Date;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class User {
	
	private String accessToken = "CAACEdEose0cBAIzo93CdC5QA4ZBm2bCZASsJzeaUfqNgdYNuWzRGdx3YKZAdGb1tE29MPUV17zC9toFfkRdfii1uGlh1Y6Qcp2HxfXgvxpm4LzasVhi19hrKKjyZBQPKKnZAPOevITIq136RCrIGZAXnPEMpQnudZCtwMrVWhZCWbkzV8ZBPvZB77oCorTBZB8DWh8exy7wWR8Rkh09B0JRvtwW";
	private GraphAPI API = new GraphAPI(accessToken);
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
