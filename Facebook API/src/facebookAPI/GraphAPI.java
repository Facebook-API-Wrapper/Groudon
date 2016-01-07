package facebookAPI;

import java.util.Date;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GraphAPI {
	
	static final String URL = "https://graph.facebook.com/v2.5/?";
	public final String accessToken;
	final String NAME_PARAM = "name";
	final String BIRTHDAY_PARAM = "birthday";
	
	public GraphAPI(String accessToken){
		this.accessToken = accessToken;
	}
	
	private JsonNode getField(String id, String field) throws UnirestException {
		return Unirest.get(URL)
				.queryString("access_token",accessToken)
				.queryString("ids", id)
				.queryString("fields", field)
				.asJson()
				.getBody();
	}
	
	public String getName(String id) throws UnirestException{
		JSONObject info = (JSONObject) this.getField(id, NAME_PARAM).getObject().get(id);
		return info.getString(NAME_PARAM);
	}
	
	public Date getBirthday(String id) throws UnirestException{
		JSONObject info = (JSONObject) this.getField(id, BIRTHDAY_PARAM)
				.getObject()
				.get(id);
		String date = info.getString(BIRTHDAY_PARAM);
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(3,5));
		int year = Integer.parseInt(date.substring(6,10));
		Date birthday = new Date(year-1900, month-1, day);
		return birthday;
	}
	
	public static void main(String[] args) throws UnirestException{
		try{
			GraphAPI test = new GraphAPI("CAACEdEose0cBAIzo93CdC5QA4ZBm2bCZASsJzeaUfqNgdYNuWzRGdx3YKZAdGb1tE29MPUV17zC9toFfkRdfii1uGlh1Y6Qcp2HxfXgvxpm4LzasVhi19hrKKjyZBQPKKnZAPOevITIq136RCrIGZAXnPEMpQnudZCtwMrVWhZCWbkzV8ZBPvZB77oCorTBZB8DWh8exy7wWR8Rkh09B0JRvtwW");
			System.out.println(test.getName("613415685427880"));
			System.out.println(test.getBirthday("613415685427880"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
