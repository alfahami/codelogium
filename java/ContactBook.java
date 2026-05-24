import java.util.HashMap;

public class ContactBook {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        Contact c1 = new Contact("Tupac", "0627528394", "tupac.shakur@gmail.com");
        Contact c2 = new Contact("TuPac", "0627528394", "tupac.shakur@gmail.com");
        Contact c3 = new Contact("Biggie", "0606215094", "biggie.notorius@gmail.com");
        Contact c4 = new Contact("Nate Dogg", "0650215032", "nate.big@gmail.com");

        addContact(c1, contacts);
        addContact(c2, contacts);
        addContact(c3, contacts);
        addContact(c4, contacts);

        listAllContacts(contacts);

        Contact retrievdContact = searchByName("Biggie", contacts);

        System.out.println("Retrieve Contact from search by name: " + retrievdContact);

        removeContact("biggie", contacts);

        listAllContacts(contacts);
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

    private static void listAllContacts(HashMap<String, Contact> contacts) {
        for (String key : contacts.keySet()) {
            System.out.println(contacts.get(key).toString());
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