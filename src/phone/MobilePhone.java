package phone;

import java.util.ArrayList;

public class MobilePhone {
	
	private ArrayList<Contact> contacts;
	private String myPhoneNumber;
	
	public MobilePhone(String myPhoneNumber){
		this.contacts = new ArrayList<Contact>();
		this.myPhoneNumber = myPhoneNumber;
	}

	public boolean addContact(Contact contact){
		if(findContactByName(contact.getName()) >= 0 && contacts.size() <= 150){
			System.out.println("Contact " + contact.getName() + " already exists");
			return false;
		}
		if(findContactByName(contact.getName()) == -1 && contacts.size() >= 150){
			System.out.println("Contact " + contact.getName() + " cannot be added. No spare space in your contact book");
			return false;
		}
		contacts.add(contact);
		System.out.println("Contact " + contact.getName() + " has been succesfully added");
		return true;
	}
	
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
	
	public void showAllContacts() {
		System.out.println("\nHere are your contacts");
		if(contacts.size() == 0){
			System.out.println("The list is empty. Click 2 to enter your first contact");
		}else{
		for(int i=0; i<contacts.size(); i++){
			System.out.println("\t" + contacts.get(i).getName() + ":\t " + contacts.get(i).getPhoneNumber());
			}
		}
	}
	
	private int findContactByPhoneNumber(String phoneNumber){
		for(int i=0; i<contacts.size(); i++){
			Contact contact = contacts.get(i);
			if(contact.getPhoneNumber() == phoneNumber){
				return i;
			}
		}
		return -1;
	}
	
	private int findContactByName(String name){
		for(int i=0; i<contacts.size(); i++){
			Contact currentContact = contacts.get(i);
			if(currentContact.getName().equals(name)){
				return i;
			}
		}
		return -1;
	}
	
	public String queryContact(Contact contact){
		if(findContactByPhoneNumber(contact.getPhoneNumber()) >= 0){
			return contact.getName();
		}
		return null;
	}
	
	public Contact queryContactByName(String name){
		int position = findContactByName(name);
		if(position >=0){
			return contacts.get(position);
		}
		return null;
	}
	
	public boolean editContactName(Contact contactToEdit, String newContactName){
		int foundContact = findContactByPhoneNumber(contactToEdit.getPhoneNumber());
		if(foundContact < 0){
			System.out.println("Contact " + contactToEdit.getName() + " was not found");
			return false;
		}else{
			Contact updatedContact = new Contact(newContactName, contactToEdit.getPhoneNumber());
			System.out.print("Updated contact : " + newContactName + " " + contactToEdit.getPhoneNumber());
			contacts.set(foundContact, updatedContact);
			return true;
		}
	}
	
	public boolean editContactPhoneNumber(Contact contactToEdit, String newPhoneNumber){
		int foundContact = findContactByPhoneNumber(contactToEdit.getPhoneNumber());
		if(foundContact < 0){
			System.out.println("Contact " + contactToEdit.getName() + " was not found");
			return false;
		}else{
			Contact updatedContact = new Contact(contactToEdit.getName(), newPhoneNumber);
			contacts.set(foundContact, updatedContact);
			return true;
		}
	}
	
	public boolean removeContact(Contact contact){
		int foundPosition = findContactByPhoneNumber(contact.getPhoneNumber());
		if(foundPosition<0){
			System.out.println("The contact doesn't exist");
			return false;
		}
		contacts.remove(foundPosition);
		return true;
	}
}