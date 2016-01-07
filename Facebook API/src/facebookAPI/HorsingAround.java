package facebookAPI;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;


public class HorsingAround {

	public static final String ACCESS_TOKEN = "CAACEdEose0cBAP9PSOcoZCoyXDo80a8N7g1x2ZBJIRmK5KN2psxGEFMjn4zBXEGTbvTQUZCSqZAgh6swIj5XQ74DFSQcXBu5qoIN4J2umGi97sRFVaRk5XtiOcyGicKcb1BVG7hHLT9ISEtyR70uKBOjMsd0HtahanMlOFiQQ6Jft9h5B1ZAZBKNrt8t9U2beLWgZChpeQRwfkzDcPI7ToB";

	public static void main(String[] args) {
		try {
			HttpResponse<JsonNode> get = Unirest.get("https://graph.facebook.com/v2.5/me?access_token="+ACCESS_TOKEN+"&fields=name").asJson();
			System.out.println(get.getBody());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}