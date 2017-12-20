package phone;

import java.util.ArrayList;

public class MobilePhone {
	
	private String myPhoneNumber;
	private ArrayList<Contact> contacts;
	
	public MobilePhone(String myPhoneNumber){
		this.myPhoneNumber = myPhoneNumber;
		this.contacts = new ArrayList<Contact>();
	}

	public String addContact(Contact contact){
		if(contacts.size()<150){
			contacts.add(contact);
			return "Contact " + contact.getName() + " has been added";
		}
		return "The phone can store only 150 contacts";
	}
	
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
	
	public Contact findContactByName(String name){
		ArrayList<Contact> array = new ArrayList<Contact>();
		for(Contact contact : contacts){
			if(contact.getName() == name){
				array.add(contact);
			}
		}
		return array.get(0);
	}
	
	public void editContactName(Contact contact, String newName){
		contact.setName(newName);
	}
	
	public void removeContact(String name){
		Contact contact = findContactByName(name);
		contacts.remove(contacts.indexOf(contact));
	}
}
