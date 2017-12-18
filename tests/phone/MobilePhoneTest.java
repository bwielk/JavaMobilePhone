package phone;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MobilePhoneTest {
	
	private Contact contact;
	private Contact contact2;
	private Contact contact3;
	private MobilePhone phone;

	@Before
	public void before(){
		contact = new Contact("John","07893456244");
		contact2 = new Contact("Mother", "O9873452111");
		contact3 = new Contact("Mike", "O7234221109");
		phone = new MobilePhone();
		
	}
	@Test
	public void canStoreContacts() {
		phone.getContacts().clear();
		phone.addContact(contact);
		phone.addContact(contact2);
		assertEquals(2, phone.getContacts().size());
	}
	
	@Test
	public void phoneCanStoreOnly150Contacts(){
		for(int i=0; i<150; i++){
			String name = "name"+i;
			String number = "" + i + "";
			phone.addContact(new Contact(name, number));
		}
		assertEquals("The phone can store only 150 contacts", phone.addContact(contact));
	}
	
	@Test
	public void phoneContactCanBeEdited(){
		phone.addContact(contact);
		phone.addContact(contact2);
		phone.addContact(contact3);
		phone.editContactName(contact, "Mark");
		assertEquals("Mark", phone.findContactByName("Mark").getName());
	}
	
	@Test
	public void phoneCanRemoveAContact(){
		phone.getContacts().clear();
		phone.addContact(contact);
		phone.addContact(contact2);
		phone.addContact(contact3);
		phone.removeContact("John");
		assertEquals(2, phone.getContacts().size());
	}
	
	@Test
	public void phoneCanFindAContact(){
		phone.addContact(contact);
		phone.addContact(contact2);
		phone.addContact(contact3);
		assertEquals("07893456244", phone.findContactByName("John").getPhoneNumber());
	}
}
