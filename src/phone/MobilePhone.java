package phone;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
	
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	
	public static void main(String[] args){
		boolean quit = false;
		int choice = 0;
		printMenu();
		while(!quit){
			System.out.println("\nEnter your choice");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
			case 0:
				printMenu();
				break;
			case 1:
				showAllContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				editContact();
				break;
			case 4:
				deleteContact();
				break;
			case 5:
				findContactByName();
				break;
			case 6:
				quit = true;
				break;
			}
		}
	}

	private static void findContactByName() {
		// TODO Auto-generated method stub
		
	}

	private static void deleteContact() {
		// TODO Auto-generated method stub
		
	}

	private static void editContact() {
		// TODO Auto-generated method stub
		
	}

	private static void addNewContact() {
		System.out.println("\nEnter the contact name: ");
		String name = scanner.nextLine();
		System.out.println("\nEnter the phone number: ");
		String number = scanner.nextLine();
		contacts.add(new Contact(name, number));
		System.out.print("\nThe contact " + name + " has been added");
	}

	private static void showAllContacts() {
		System.out.println("\nHere are your contacts");
		if(MobilePhone.contacts.size() == 0){
			System.out.println("The list is empty");
		}else{
		for(int i=0; i<MobilePhone.contacts.size(); i++){
			System.out.println("\t" + MobilePhone.contacts.get(i).getName() + ":\t " + MobilePhone.contacts.get(i).getPhoneNumber());
			}
		}
	}

	public static void printMenu(){
		System.out.println("\nWelcome! Enter a number to select and action");
		System.out.println("\tPress 0: to print instructions");
		System.out.println("\tPress 1: to list all the contacts");
		System.out.println("\tPress 2: to add a new contact");
		System.out.println("\tPress 3: to edit an existing contact");
		System.out.println("\tPress 4: to delete an existing contact");
		System.out.println("\tPress 5: to find a contact");
		System.out.println("\tPress 6: to quit the menu");
	}
	
	public String addContact(Contact contact){
		if(contacts.size()<150){
			MobilePhone.contacts.add(contact);
			return "Contact " + contact.getName() + " has been added";
		}
		return "The phone can store only 150 contacts";
	}
	
	public ArrayList<Contact> getContacts(){
		return MobilePhone.contacts;
	}
	
	public Contact findContactByName(String name){
		for(Contact contact : MobilePhone.contacts){
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
		int indexToDelete = MobilePhone.contacts.indexOf(contact);
		MobilePhone.contacts.remove(indexToDelete);
	}

}
