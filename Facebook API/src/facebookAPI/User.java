package facebookAPI;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class User {
	
	public static final String URL = "https://graph.facebook.com/v2.5/?";
	public static final String ACCESS_TOKEN = "CAACEdEose0cBAL02N78OKYBvTvix4zyOZB65DdHKD0NRipedScf1MB3tv3917xafIw75Xz8ZBUMaVfkQ6LrUYZAaZAfivVaGZBkzlHDAn1JwqmJAmBKrU736v7XVOgPl9ZBhDCZB0n2PIRpkyD7GiUk3HqsB0XJZApsEcZBAT5DshX84yJtXb3hQjZB4lHp7oSIBferkTyTHGCOQJ0UCjjm0MZC";
	private String id;
	
	public User(String id){
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
	
	public JsonNode getField(String field) throws UnirestException {
		return Unirest.get(URL+"access_token="+ACCESS_TOKEN).queryString("ids", id).queryString("fields", field).asJson().getBody();
	}
	
	public JSONObject getName() throws UnirestException{
		return this.getField("name").getObject();
	}
	
	public JSONObject getBrithday() throws UnirestException{
		return this.getField("birthday").getObject();
	}
	
	
	public static void main(String[] args) {
		try{
			User alex = new User("613415685427880");
			System.out.println(alex.getBrithday());
			System.out.println(alex.getName());
			System.out.println(alex.getId());
		}
		catch(UnirestException e){
			System.out.print(e.getMessage());
		}
	}
}
