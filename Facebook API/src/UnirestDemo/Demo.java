package UnirestDemo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * This demo hits the simple API located at jsonplaceholder.typicode.com
 */
public class Demo {
	
	private static final String API_ROOT = "http://jsonplaceholder.typicode.com";
	private static final String GET_ENDPOINT = "/posts/1";
	
	public static void main(String[] args) throws UnirestException {
		HttpResponse<JsonNode> response = Unirest.get(API_ROOT + GET_ENDPOINT).asJson();
		JsonNode output = response.getBody();
		
		System.out.println(output.toString());
	}
}
