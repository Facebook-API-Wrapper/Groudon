package facebookAPI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class User {
	
	public static final String URL = "https://graph.facebook.com/v2.5/?";
	public static final String ACCESS_TOKEN = "CAACEdEose0cBAGLokLtuYR2jCdOZBu00sHkJ2c0JUZBeCayTZAJFlRoJxFv5aTQKj9Llv9NrFaPILKJnXvQgYlcrRgMJNdxptTlKjZC4BMTXZC1tiTv9XpH0K4U2LuMZAhaLl3VdVkHriP3xCnB9BZCdceSF2RqZCVaZAKkw7paZAsZBAOIZAak3WmIxWZBqZCsIegwyY6NoeipccSnRCqhusjuShk";
	private String id;
	
	public User(String id){
		this.id=id;
	}
	
	public String getId() throws UnirestException{
		return id;
	}
	
	public JsonNode getField(String field) throws UnirestException {
		return Unirest.get(URL+"access_token="+ACCESS_TOKEN).queryString("ids", id).queryString("fields", field).asJson().getBody();
	}
	
	public JsonNode getName() throws UnirestException{
		return this.getField("name");
	}
	
	public JsonNode getBrithday() throws UnirestException{
		return this.getField("birthday");
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
