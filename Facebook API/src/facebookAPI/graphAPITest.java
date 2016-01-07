package facebookAPI;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import com.mashape.unirest.http.exceptions.UnirestException;

public class graphAPITest {
	GraphAPI API = new GraphAPI("CAACEdEose0cBAPO6slZCnZCHwdXcDboWv8wU4pS7UvuiSWrB5pMTv8hRntMei2bibEZCwLZA3ePla172xnyr0ZCBJst4FGLpJ4z6GC8ZCIK8iIjCBasPSPyZCQvZAZCjbRHHLWLrobc2lmmblFJ6cHgKefYLfnSQJWRZCkKofyolYToZBMZBWGJB1a6TnPdvOr9vZBfMFrzjBN712r2TirqY3O2Eh");
	
	@Test
	public void nameTest() throws UnirestException {
		String name = API.getName("613415685427880");
		assertEquals("Alex Rosh", name);
	}
	
	@Test
	public void birthdayTest() throws UnirestException{
		Date birthday = API.getBirthday("613415685427880");
		Date expected = new Date(1996-1900, 3-1, 28);
		assertEquals(expected, birthday);
	}

}
