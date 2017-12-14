package phone;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContactTest{
	
	private Contact contact;

	@Before
	public void before(){
		contact = new Contact("Kate", "07891234567");
	}
	
	@Test
	public void contactHasName() {
		assertEquals("Kate", contact.getName());
	}
	
	@Test
	public void contactHasPhoneNumber(){
		assertEquals("07891234567", contact.getPhoneNumber());
	}

}
