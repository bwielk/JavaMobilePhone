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
			String name = "name"+(i+1);
			String number = "" + (i+1) + "";
			phone.addContact(new Contact(name, number));
		}
		assertEquals(false, phone.addContact(contact));
	}
	
	@Test
	public void phoneCanFindAContact(){
		System.out.println("Test 5");
		phone.getContacts().clear();
		assertEquals(true, phone.addContact(new Contact("Jane", "08793452211")));
		assertEquals(true, phone.addContact(new Contact("Edith", "03733112321")));
		assertEquals(true, phone.addContact(new Contact("Judy", "03323112321")));
		assertEquals("Jane", phone.queryContact(new Contact("Jane", "08793452211")));
		assertEquals("Edith", phone.queryContact(new Contact("Edith", "03733112321")));
		assertNotEquals("Edtih", phone.queryContact(new Contact("Judy", "03323112321")));
	}
	
	@Test
	public void phoneContactNameCanBeEdited(){
		System.out.println("Test 6");
		phone.addContact(contact);
		phone.addContact(contact2);
		phone.addContact(contact3);
		Contact contact4 = new Contact("Eve", "09452345667");
		phone.editContactName(contact, contact4.getName());
		assertEquals("07893456244", phone.queryContactByName("Eve").getPhoneNumber());
		assertEquals(3, phone.getContacts().size());
		assertEquals(null, phone.queryContactByName("John"));
		assertEquals(contact2, phone.queryContactByName("Mother"));
	}
	
	@Test
	public void phoneContactPhoneNumberCanBeEdited(){
		System.out.println("Test 7");
		phone.addContact(contact);
		phone.addContact(contact2);
		Contact contact4 = new Contact("Jordan", "09452345667");
		phone.editContactPhoneNumber(contact2, contact4.getPhoneNumber());
		assertEquals("09452345667", phone.queryContactByName(contact2.getName()).getPhoneNumber());
		assertNotEquals("O9873452111", phone.queryContactByName(contact2.getName()).getPhoneNumber());
		assertEquals(2, phone.getContacts().size());
		assertEquals(null, phone.queryContact(contact2));
	}
	
	
	@Test
	public void phoneContactEditCanFailBecauseOfNotExistingContact(){
		System.out.println("Test 8");
		assertEquals(true, phone.addContact(contact));
		assertEquals(true, phone.addContact(contact2));
		assertEquals(true, phone.addContact(contact3));
		assertEquals(false, phone.editContactName(new Contact("Adam", "07983221132"), contact2.getName()));
		assertEquals(true, phone.addContact(new Contact("Adam", "07983221132")));
		assertEquals(true, phone.editContactPhoneNumber(new Contact("Adam", "07983221132"), "09431123443"));
		assertEquals("09431123443", phone.queryContactByName("Adam").getPhoneNumber());
	}
	
	@Test
	public void phoneCanRemoveAContact(){
		System.out.println("Test 9");
		phone.getContacts().clear();
		phone.addContact(contact);
		phone.addContact(contact2);
		phone.addContact(contact3);
		phone.removeContact(contact);
		assertEquals(2, phone.getContacts().size());
	}
	
	@Test
	public void phoneCanQueryContactByIsName(){
		System.out.println("Test 10");
		assertEquals(true, phone.addContact(contact));
		assertEquals(true, phone.addContact(contact2));
		assertEquals(true, phone.addContact(new Contact("Jersey", "09842221299")));
		assertEquals("O9873452111", phone.queryContactByName("Mother").getPhoneNumber());
		assertEquals("09842221299", phone.queryContactByName("Jersey").getPhoneNumber());
		assertNotEquals("O9873452111", phone.queryContactByName("Jersey").getPhoneNumber());
	}
}
