import java.util.HashMap;

public class ContactBook {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        Contact c1 = new Contact("Tupac", "0627528394", "tupac.shakur@gmail.com");
        Contact c2 = new Contact("Tupac", "0627528394", "tupac.shakur@gmail.com");

        addContact(c1, contacts);
        addContact(c2, contacts);

        listAllContacts(contacts);
    }

    private static Contact addContact(Contact contact, HashMap<String, Contact> contacts) {
        if(contacts.put(contact.getName(), contact) == null) 
            return contact;
         else return null;
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

        public String toString() {
            return "Contact Info :" + " Name :" + name + " | " + "Phone: " + phone + " | " + "Email: " + email + " |";
        }
    }
}