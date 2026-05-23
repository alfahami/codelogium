import java.util.ArrayList;
import java.util.List;

public class ContactBook {

    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();

        Contact c1 = new Contact("Tupac", "0627528394", "tupac.shakur@gmail.com");
        Contact c2 = new Contact("Tupac", "0627528394", "tupac.shakur@gmail.com");

        addContact(c1, contacts);
        addContact(c2, contacts);

        listAllContacts(contacts);
    }

    private static boolean addContact(Contact contact, List<Contact> contacts) {
        return contacts.add(contact);
    }

    private static void listAllContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    static class Contact {
        private String name;
        private String phone;
        private String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName()  { return this.name;  }
        public String getPhone() { return this.phone; }
        public String getEmail() {return this.email;  }

        public void setName(String name)   { this.name = name;   }
        public void setPhone(String phone) { this.phone = phone; }
        public void setEmail(String email) { this.email = email; }
    }
}