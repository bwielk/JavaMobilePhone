package phone;

import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone phone = new MobilePhone("07947927788");

	public static void main(String[] args){
		Contact contact1 = new Contact("John", "07893455321");
		phone.addContact(contact1);
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
		Contact contact = phone.findContactByName(name);
		System.out.println("\t Contact name: " + "\t" + contact.getName());
		System.out.println("\t Contact phone number: " + "\t" + contact.getPhoneNumber());
		
	}

	private static void deleteContact() {
		int sizeOfContacts = phone.getContacts().size();
		System.out.println("\nEnter the contact name to delete");
		String name = scanner.nextLine();
		phone.removeContact(name);
		if(phone.getContacts().size() < sizeOfContacts){
			System.out.println(name + " has been removed");
		}
	}

	private static void editContact() {
		System.out.println("Enter a contact's name");
		String name = scanner.nextLine();
		Contact contact = phone.findContactByName(name);
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
		phone.addContact(contact);
		System.out.print("\nThe contact " + name + " has been added");
	}

	private static void showAllContacts() {
		System.out.println("\nHere are your contacts");
		if(phone.getContacts().size() == 0){
			System.out.println("The list is empty. Click 2 to enter your first contact");
		}else{
		for(int i=0; i<phone.getContacts().size(); i++){
			System.out.println("\t" + phone.getContacts().get(i).getName() + ":\t " + phone.getContacts().get(i).getPhoneNumber());
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

}
