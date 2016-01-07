package facebookAPI;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import com.mashape.unirest.http.exceptions.UnirestException;

public class graphAPITest {
	final String accessToken = "CAACEdEose0cBABPtEzKoUL5or4SxZAaHZAZCGAMB8SP7M7j8o61ivyjqzBtwEyuMX2DMKcBj6tVVJy9OGpOj002yJiqCYEiJwhaFu8Byx8YICpPZBrPXvskXXaosyJpZCYXsldQaKOVhq8bTYck4N9U53pvhkWXqYnxiekQAQiucmdOruZBkmNZATG0uWYCQrkBUfUkNHBeVZBJezFAQJf6z";
	GraphAPI API = new GraphAPI(accessToken);
	
	@Test
	public void testsGetName() throws UnirestException {
		String name = API.getName("613415685427880");
		assertEquals("Alex Rosh", name);
	}
	
	@Test
	public void testsGetBirthday() throws UnirestException{
		Date actual = API.getBirthday("613415685427880");
		Date expected = new Date(1996-1900, 3-1, 28);
		assertEquals(expected, actual);
	}

}
