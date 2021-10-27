package com.bridgelab.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class MasterBook {

	Scanner scanner = new Scanner(System.in);
	HashMap<String, AddressBook> masterBook = new HashMap<>();
	
	public static void main(String [] args) {
		MasterBook masterBook = new MasterBook();
		masterBook.mainMenuMasterBook();
	}
	
	public void mainMenuMasterBook() {
		boolean quite = false;
		int choice = 0;
		printDetails();
		while(!quite) {
			System.out.println("Enter Your Choice : ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 0:
				printDetails();
				break;
			case 1: 
				addAddressBook();
				break;
			case 2: 
				addContactsInAddressBook();
				break;
			case 3: 
				quite = true;
			}
		}
	}
	
	public void printDetails() {
		System.out.println("Welcome to the Master Book.");
		System.out.println("Press : ");
		System.out.println("\t 0 to Print these Choice Options again : ");
		System.out.println("\t 1 to Add new Address Book to the Master Book : ");
		System.out.println("\t 2 to Add contact in the Address Book : ");
		System.out.println("\t 3 to Quite : ");
	}

	public void addAddressBook() {
		System.out.println("Enter the Name of the City for which you want to add Address Book : ");
		String cityName = scanner.nextLine();
		masterBook.put(cityName, new AddressBook());
	}
	
	public void addContactsInAddressBook() {
		System.out.println("Enter the name of address Book in which you want to add contact : ");
		String addressBookName = scanner.nextLine();
		if (masterBook.get(addressBookName) == null) {
			System.out.println("Address Book Not Exist. Create new Address Book.");
		} else {
			masterBook.get(addressBookName).mainMenuAddressBook();
		}
	}

}
