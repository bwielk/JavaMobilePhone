package phone;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
	
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	
	public static void main(String[] args){
		Contact contact1 = new Contact("John", "0789345532");
		addContact(contact1);
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
		System.out.println("Enter a contact's name to search");
		String name = scanner.nextLine();
		Contact contact = findContactByName(name);
		System.out.println("\t Contact name: " + "\t" + contact.getName());
		System.out.println("\t Contact phone number: " + "\t" + contact.getPhoneNumber());
		
	}

	private static void deleteContact() {
		int sizeOfContacts = contacts.size();
		System.out.println("\nEnter the contact name to delete");
		String name = scanner.nextLine();
		removeContact(name);
		if(contacts.size() < sizeOfContacts){
			System.out.println(name + " has been removed");
		}
	}

	private static void editContact() {
		System.out.println("Enter a contact's name");
		String name = scanner.nextLine();
		Contact contact = findContactByName(name);
		System.out.println("Enter new name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter a new phone number");
		String newNumber = scanner.nextLine();
		contact.setName(newName);
		contact.setPhoneNumber(newNumber);
		System.out.print("Changes has been made");
		}

	private static void addNewContact() {
		System.out.println("\nEnter the contact name: ");
		String name = scanner.nextLine();
		System.out.println("\nEnter the phone number: ");
		String number = scanner.nextLine();
		Contact contact =new Contact(name, number);
		addContact(contact);
		System.out.print("\nThe contact " + name + " has been added");
	}

	private static void showAllContacts() {
		System.out.println("\nHere are your contacts");
		if(contacts.size() == 0){
			System.out.println("The list is empty. Click 2 to enter your first contact");
		}else{
		for(int i=0; i<contacts.size(); i++){
			System.out.println("\t" + contacts.get(i).getName() + ":\t " + contacts.get(i).getPhoneNumber());
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
	
	public static String addContact(Contact contact){
		if(contacts.size()<150){
			contacts.add(contact);
			return "Contact " + contact.getName() + " has been added";
		}
		return "The phone can store only 150 contacts";
	}
	
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
	
	public static Contact findContactByName(String name){
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
	
	public static void removeContact(String name){
		Contact contact = findContactByName(name);
		contacts.remove(contacts.indexOf(contact));
	}

}
