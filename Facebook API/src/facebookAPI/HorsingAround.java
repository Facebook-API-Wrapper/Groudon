package facebookAPI;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;


public class HorsingAround {

	public static final String ACCESS_TOKEN = "CAACEdEose0cBAPVndMOzVA7cj1uV82cZBPwelnXeMCbGa51KvZAGbUzNA0VJc7jxKnMyXkEZACOfg6yweKB09CSZChoZBXHkGJPyt0MyqR0VLW2bpvWloeIsGlsstYwdWNF8xGKi3YKWsBFiZAngiy6VnreM41QEuDziTyqDjPunGKZB3RaNnxOKuMVlhNsfuwlaFaUkuQnAZC7sZAxctI8nE";

	public static void main(String[] args) {
		try {
			GetRequest get = Unirest.get("http://graph.facebook.com/v2.5/me");
			get.queryString("access_token", ACCESS_TOKEN);
			get.queryString("fields", "name");
			get.asJson();
			System.out.println(get.getBody());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}