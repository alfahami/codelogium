import java.util.HashMap;
import java.util.List;

public class Main {
    private static ContactBook contactBook = new ContactBook();
    public static void main(String[] args) {


        Contact c1 = new Contact("Tupac", "0627528394", "tupac.shakur@gmail.com", "Rapper");
        Contact c2 = new Contact("TuPac", "0627528394", "tupac.shakur@gmail.com", "Rapper");
        Contact c3 = new Contact("Biggie", "0606215094", "biggie.notorius@gmail.com", "Rapper");
        Contact c4 = new Contact("Nate Dogg", "0650215032", "nate.big@gmail.com", "Rapper");
        Contact c5 = new Contact("Brad Traversy", "0534213456", "brad.traversy@gmail.com", "Tech Guy");

        contactBook.addContact(c1);
        contactBook.addContact(c2);
        contactBook.addContact(c3);
        contactBook.addContact(c4);
        contactBook.addContact(c5);

        contactBook.listAllContacts();

        Contact retrievdContact = contactBook.searchByName("Biggie");

        System.out.println("Retrieve Contact from search by name: " + retrievdContact);

        contactBook.removeContact("biggie");

        contactBook.listAllContacts();
        contactBook.groupByContacts("Rapper");
        contactBook.listAllGroupedContacts();
    }
}
