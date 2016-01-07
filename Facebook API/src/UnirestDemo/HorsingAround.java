package UnirestDemo;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;


public class HorsingAround {

	public static final String ACCESS_TOKEN = "CAACEdEose0cBAPchNyHBXi0G8CKNtxKbF135YCSMg7whWfXZC2e0A2wd5b1DF0zA6ZAa6ZCqpJ5toPJTKSPl9kKd2cGAWZCLPn9STZA3JrUa2XPzqNImPKKi0jRzWykSElc3wDATbQjyi9f2wXI9s6Xg4Uu9s3Dx54wrZCvCnlrZCHJZCEYPIOZAMZCCjW0zuz26DyQKHNZB7KnCIVSDLCILMia";

	public static void main(String[] args) {
		try {
			HttpResponse<JsonNode> get = Unirest.get("https://graph.facebook.com/v2.5/me?access_token="+ACCESS_TOKEN).queryString("fields", "friends").asJson();
			System.out.println(get.getBody());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}