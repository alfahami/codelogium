import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactBook {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();
        HashMap<String, List<Contact>> contactByGroup = new HashMap<>();

        Contact c1 = new Contact("Tupac", "0627528394", "tupac.shakur@gmail.com", "Rapper");
        Contact c2 = new Contact("TuPac", "0627528394", "tupac.shakur@gmail.com", "Rapper");
        Contact c3 = new Contact("Biggie", "0606215094", "biggie.notorius@gmail.com", "Rapper");
        Contact c4 = new Contact("Nate Dogg", "0650215032", "nate.big@gmail.com", "Rapper");
        Contact c5 = new Contact("Brad Traversy", "0534213456", "brad.traversy@gmail.com", "Tech Guy");

        addContact(c1, contacts);
        addContact(c2, contacts);
        addContact(c3, contacts);
        addContact(c4, contacts);
        addContact(c5, contacts);

        listAllContacts(contacts);

        Contact retrievdContact = searchByName("Biggie", contacts);

        System.out.println("Retrieve Contact from search by name: " + retrievdContact);

        removeContact("biggie", contacts);

        listAllContacts(contacts);
        contactByGroup = groupByContacts("Rapper", contacts);
        listAllGroupedContacts(contactByGroup);
    }

    private static Contact addContact(Contact contact, HashMap<String, Contact> contacts) {
        if(contacts.put(contact.getName().toUpperCase(), contact) == null) 
            return contact;
         else return null;
    }

    private static Contact searchByName(String name, HashMap<String, Contact> contacts) {
        Contact contact = contacts.get(name.toUpperCase());
        if(contact == null) {
            System.out.println("Contact : "+ name + " not found");
            return null;
        }
        else return contact;
    }

    private static Contact removeContact(String name, HashMap<String, Contact> contacts) {
        Contact contact = contacts.remove(name.toUpperCase());
        if(contact != null) {
            System.out.println("Contact " + name + " removed succesfully!");
            return contact;
        } else {
            System.out.println("Contact " + name + " is not found!");
            return null;
        }
    }

    private static HashMap<String, List<Contact>> groupByContacts(String category, HashMap<String, Contact> contactHashMap) {
        HashMap<String, List<Contact>> groupedContacts = new HashMap<>();
        List<Contact> contactList = new ArrayList<>();
        
        for(String key : contactHashMap.keySet()) {
            Contact retrievedContact = contactHashMap.get(key);
            if(retrievedContact.getCategory().equalsIgnoreCase(category)) {
                contactList.add(retrievedContact);
            }
        }

        if(contactList != null && !contactList.isEmpty()) groupedContacts.put(category, contactList);
        else System.out.println("Category doesn't exist");

        return groupedContacts;
    }

    private static void listAllContacts(HashMap<String, Contact> contacts) {
        for (String key : contacts.keySet()) {
            System.out.println(contacts.get(key).toString());
        }
    }

    private static void listAllGroupedContacts(HashMap<String, List<Contact>> contacts) {
        List<Contact> groupedContacts = new ArrayList<>();
        for(String key : contacts.keySet()) {
            groupedContacts = contacts.get(key);
        }

        if(groupedContacts != null) {
            System.out.println("\nContacts By Group:");
            for (Contact contact : groupedContacts) {
                System.out.println(contact.toString());
            }
        }
    }

    static class Contact {
        private String name;
        private String phone;
        private String email;
        private String category;

        public Contact(String name, String phone, String email, String category) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.category = category;
        }

        public String getName()  { return this.name;  }
        public String getPhone() { return this.phone; }
        public String getEmail() {return this.email;  }
        public String getCategory() { return this.category; }

        public void setName(String name)   { this.name = name;   }
        public void setPhone(String phone) { this.phone = phone; }
        public void setEmail(String email) { this.email = email; }
        public void setCategory(String category) { this.category = category; }

        public String toString() {
            return "Contact Info :" + " Name :" + name + " | " + "Phone: " + phone + " | " + "Email: " + email + " |" + "Category: " + category;
        }
    }
}