package phone;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
	
	private static Scanner scanner;
	private static ArrayList<Contact> contacts;
	
	public MobilePhone(){
		this.contacts = new ArrayList<Contact>();
	}
	
	public static void main(String[] args){
		boolean quit = false;
		int choice = 0;
		printMenu();
	}
	
	public static void printMenu(){
		System.out.println("\nWelcome! Enter a number to select and action");
		System.out.println("\tPress 1: to list all the contacts");
		System.out.println("\tPress 2: to add a new contact");
		System.out.println("\tPress 3: to edit an existing contact");
		System.out.println("\tPress 4: to delete an existing contact");
		System.out.println("\tPress 5: to find a contact");
		System.out.println("\tPress 6: to quit the menu");
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
	
	public void removeContact(String name){
		Contact contact = findContactByName(name);
		int indexToDelete = this.contacts.indexOf(contact);
		this.contacts.remove(indexToDelete);
	}

}
