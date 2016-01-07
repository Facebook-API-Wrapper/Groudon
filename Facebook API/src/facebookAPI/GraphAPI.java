package facebookAPI;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GraphAPI {
	
	static final String URL = "https://graph.facebook.com/v2.5/?";
	public final String ACCESS_TOKEN;
	final String NAME_PARAM = "name";
	final String BIRTHDAY_PARAM = "birthday";
	
	public GraphAPI(String accessToken){
		ACCESS_TOKEN = accessToken;
	}
	
	private JsonNode getField(String id, String field) throws UnirestException {
		return Unirest.get(URL)
				.queryString("access_token",ACCESS_TOKEN)
				.queryString("ids", id)
				.queryString("fields", field)
				.asJson()
				.getBody();
	}
	
	public JSONObject getName(String id) throws UnirestException{
		return this.getField(id, NAME_PARAM).getObject();
	}
	
	public JsonNode getBirthday(String id) throws UnirestException{
		return this.getField(id, BIRTHDAY_PARAM);
	}
	
	
	
}
