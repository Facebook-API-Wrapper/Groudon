
package facebookAPI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class Test {

	
	public static void main(String[] args) {
		try{
			GetRequest get = Unirest.get("http://graph.facebook.com/v2.5/me");
			get.queryString("access_token", "CAACEdEose0cBAMxuKEasnnIBZCvVcbhtptbFa2sEN8mpFNLGM2RDW8xtOmHOvk1l5Uu1cZAbVZCfURZAhEAVHFUq5kIPQywk8J3znSAgJXi6zMcvvAsHBH8p8m8ykaiQEztS1YyuSJmZBKAacptZCDNVZCJMfamZAdrirerZB5kFD0rxOJgQaJeauSULxY6rJTVPg0WYkjOvoAnlUuUDzOPDY");
			get.queryString("fields", "name");
			get.asJson();
			System.out.println(get.getBody());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
