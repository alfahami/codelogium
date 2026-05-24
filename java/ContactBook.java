import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactBook {
    private HashMap<String, Contact> contacts = new HashMap<>();
    private HashMap<String, List<Contact>> contactByGroup = new HashMap<>();

    public Contact addContact(Contact contact) {
        if(contacts.put(contact.getName().toUpperCase(), contact) == null) 
            return contact;
         else return null;
    }

    public Contact searchByName(String name) {
        Contact contact = contacts.get(name.toUpperCase());
        if(contact == null) {
            System.out.println("Contact : "+ name + " not found");
            return null;
        }
        else return contact;
    }

    public Contact removeContact(String name) {
        Contact contact = contacts.remove(name.toUpperCase());
        if(contact != null) {
            System.out.println("Contact " + name + " removed succesfully!");
            return contact;
        } else {
            System.out.println("Contact " + name + " is not found!");
            return null;
        }
    }

    public HashMap<String, List<Contact>> groupByContacts(String category) {        
        List<Contact> contactList = new ArrayList<>();
        for(String key : contacts.keySet()) {
            Contact retrievedContact = contacts.get(key);
            if(retrievedContact.getCategory().equalsIgnoreCase(category)) {
                contactList.add(retrievedContact);
            }
        }

        if(contactList != null && !contactList.isEmpty()) contactByGroup.put(category, contactList);
        else System.out.println("Category doesn't exist");

        return contactByGroup;
    }

    public void listAllContacts() {
        for (String key : contacts.keySet()) {
            System.out.println(contacts.get(key).toString());
        }
    }

    public void listAllGroupedContacts() {
        List<Contact> groupedContacts = new ArrayList<>();
        for(String key : contactByGroup.keySet()) {
            groupedContacts = contactByGroup.get(key);
        }

        if(groupedContacts != null) {
            System.out.println("\nContacts By Group:");
            for (Contact contact : groupedContacts) {
                System.out.println(contact.toString());
            }
        }
    }  
}