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
		if(findContact(contact.getPhoneNumber()) >= 0 && contacts.size() <= 150){
			System.out.println("Contact " + contact.getName() + " already exists");
			return false;
		}
		if(findContact(contact.getPhoneNumber()) == -1 && contacts.size() >= 150){
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
	
	private int findContact(String phoneNumber){
		for(int i=0; i<contacts.size(); i++){
			Contact contact = contacts.get(i);
			if(contact.getPhoneNumber() == phoneNumber){
				return i;
			}
		}
		return -1;
	}
	
	public String queryContact(Contact contact){
		if(findContact(contact.getPhoneNumber()) >= 0){
			return contact.getName();
		}
		return null;
	}
	
	public Contact queryContact(String name){
		int position = findContact(name);
		if(position >=0){
			return contacts.get(position);
		}
		return null;
	}
	
	public boolean editContact(Contact oldContact, Contact newContact){
		int foundContact = findContact(oldContact.getPhoneNumber());
		if(foundContact< 0){
			System.out.println("Contact " + oldContact.getName() + " was not found");
			return false;
		}
		contacts.set(foundContact, newContact);
		System.out.println(oldContact.getName() + " has been updated");
		return true;
	}
	
	public boolean removeContact(Contact contact){
		int foundPosition = findContact(contact.getPhoneNumber());
		if(foundPosition<0){
			System.out.println("The contact doesn't exist");
			return false;
		}
		contacts.remove(foundPosition);
		System.out.println("The contact has been deleted");
		return true;
	}
}