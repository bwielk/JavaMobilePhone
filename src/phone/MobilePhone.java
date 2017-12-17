package phone;

import java.util.ArrayList;

public class MobilePhone {
	
	private ArrayList<Contact> contacts;
	
	public MobilePhone(){
		this.contacts = new ArrayList<Contact>();
	}
	
	public String addContact(Contact contact){
		if(contacts.size()<150){
			this.contacts.add(contact);
			return "Contact " + contact.getName() + " has been added";
		}
		return "The phone can store only 150 contacts";
	}
	
	public ArrayList<Contact> getContacts(){
		return this.contacts;
	}
	
	public Contact findContactByName(String name){
		for(Contact contact : this.contacts){
			if(contact.getName() == name){
				return contact;
			}
		}
		return null;
	}
	
	public void editContactName(Contact contact, String newName){
		contact.setName(newName);
	}

}
