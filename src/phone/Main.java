package phone;

import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone phone = new MobilePhone("07947927788");

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
				phone.showAllContacts();
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
		Contact contact = phone.queryContactByName(name);
		System.out.println("\t Contact name: " + "\t" + contact.getName());
		System.out.println("\t Contact phone number: " + "\t" + contact.getPhoneNumber());
		
	}

	private static void deleteContact() {
		System.out.println("\nEnter the contact name to delete");
		String name = scanner.nextLine();
		Contact contact = phone.queryContactByName(name);
		if(contact == null){
			System.out.println("Contact not found");
			return;
		}
		if(phone.removeContact(contact)){
			System.out.println("Contact deleted");
		}else{
			System.out.println("Fail. Contact doesn't exist");
		}
	}

	private static void editContact() {
		System.out.println("Enter a contact's name");
		String name = scanner.nextLine();
		Contact contact = phone.queryContactByName(name);
		if(contact == null){
			System.out.println("The contact cannot be found");
			return;
		}
		System.out.println("Enter new name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter a new phone number");
		String newNumber = scanner.nextLine();
		Contact newContact = new Contact(newName, newNumber);
			if(phone.editContact(contact, newContact)){
				System.out.print("Changes have been made");
			}else{
				System.out.print("Error updating record");
			}
		}

	private static void addNewContact() {
		System.out.println("\nEnter the contact name: ");
		String name = scanner.nextLine();
		System.out.println("\nEnter the phone number: ");
		String number = scanner.nextLine();
		Contact contact = new Contact(name, number);
		if(phone.addContact(contact)){
			System.out.println("The contact " + contact.getName() + " has been added");
		}else{
			System.out.println("The contact " + contact.getName() + " already exists");
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

}
