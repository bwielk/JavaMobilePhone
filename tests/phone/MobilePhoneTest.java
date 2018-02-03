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
		phone = new MobilePhone("07947927788");
		
	}
	
	@Test
	public void canAddContacts(){
		System.out.println("Test 1");
		assertEquals(0, phone.getContacts().size());
		assertEquals(true, phone.addContact(contact));
		assertEquals(true, phone.addContact(contact2));
		assertEquals(2, phone.getContacts().size());
		assertEquals(false, phone.addContact(contact2));
		assertEquals(2, phone.getContacts().size());
		phone.getContacts().clear();
		assertEquals(0, phone.getContacts().size());
	}
	
	@Test
	public void canStoreContacts() {
		System.out.println("Test 2");
		phone.getContacts().clear();
		phone.addContact(contact);
		phone.addContact(contact2);
		assertEquals(2, phone.getContacts().size());
		phone.addContact(contact3);
		assertEquals(3, phone.getContacts().size());
	}
	
	@Test
	public void phoneCannotAddANewPhoneNumberIfItIsAlreadySaved(){
		System.out.println("Test 3");
		phone.getContacts().clear();
		assertEquals(true, phone.addContact(new Contact("Jane", "08793452211")));
		assertEquals(true, phone.addContact(new Contact("Edith", "03733112321")));
		assertEquals(false, phone.addContact(new Contact("Judy", "03733112321")));
		assertEquals(2, phone.getContacts().size());
	}
	
	@Test
	public void phoneCannotAddANewContactIfTheContactBookIsFull(){
		System.out.println("Test 4");
		for(int i=0; i<150; i++){
			String name = "name"+i;
			String number = "" + i + "";
			phone.addContact(new Contact(name, number));
		}
		assertEquals(false, phone.addContact(contact));
	}
	
	//@Test
	public void phoneContactCanBeEdited(){
		phone.addContact(contact);
		phone.addContact(contact2);
		phone.addContact(contact3);
		Contact contact4 = new Contact("Eve", "09452345667");
		phone.editContact(contact, contact4);
		assertEquals("Eve", phone.queryContact(contact4));
		assertEquals(null, phone.queryContact(contact));
	}
	
	//@Test
	public void phoneCanRemoveAContact(){
		phone.getContacts().clear();
		phone.addContact(contact);
		phone.addContact(contact2);
		phone.addContact(contact3);
		phone.removeContact(contact);
		assertEquals(2, phone.getContacts().size());
	}
}
