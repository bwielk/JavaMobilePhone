package phone;

import java.util.ArrayList;

public class MobilePhone {
	
	private ArrayList<Contact> contacts;
	
	public MobilePhone(String myPhoneNumber){
		this.contacts = new ArrayList<Contact>();
	}

	public String addContact(Contact contact){
		if(contacts.size()<150){
			for(int i=0; i<contacts.size(); i++){
				Contact element = contacts.get(i);
				if(element.getName() == contact.getName()){
					return "The contact already exists";
				}
			}
			contacts.add(contact);
			return "Contact " + contact.getName() + " has been added";
		}
		return "The phone can store only 150 contacts";
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
	
	private int findContact(String name){
		for(int i=0; i<contacts.size(); i++){
			Contact contact = contacts.get(i);
			if(contact.getName() == name){
				return i;
			}
		}
		return -1;
	}
	
	private int findContact(Contact contact){
		return contacts.indexOf(contact);
	}
	
	public String queryContact(Contact contact){
		if(findContact(contact) >= 0){
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
		int foundContact = findContact(oldContact);
		if(foundContact< 0){
			System.out.println(oldContact.getName() + " was not found");
			return false;
		}
		contacts.set(foundContact, newContact);
		System.out.println(oldContact.getName() + " has been updated");
		return true;
	}
	
	public boolean removeContact(Contact contact){
		int foundPosition = findContact(contact);
		if(foundPosition<0){
			System.out.println("The contact doesn't exist");
			return false;
		}
		contacts.remove(foundPosition);
		System.out.println("The contact has been deleted");
		return true;
	}
}
