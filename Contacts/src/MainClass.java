import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {

		Path contactsFilePath = Paths.get("C:\\Users\\Asus\\eclipse-workspace\\Contacts\\contacts.txt");
	    ArrayList<String> contactsList = new ArrayList<String>();
	    Scanner scanner = new Scanner(System.in);
	    int option = 0;
	    
	    
		if(Files.exists(contactsFilePath)) {
			System.out.println("Fajl postoji");
		
		}
		else {
			System.out.println("Fajl ne postoji");
			System.out.println("Fajl se kreira...");
		    Files.createFile(contactsFilePath);
		    System.out.println("Fajl je kreiran");
		}
		
		System.out.println("Fajl se ucitava...");
		
		BufferedReader bReader = new BufferedReader(new FileReader("contacts.txt"));
		
	    
	    String line;
		
		while((line = bReader.readLine()) != null) {
			contactsList.add(line);
		}
		System.out.println("Kontakti su ucitani, ima ih "+contactsList.size());
		
		
		do {
		System.out.println("Da li zelite unos (1) ili pretragu (2) kontakata");
		option = scanner.nextInt();
		
		if(option == 1) {
			
			System.out.println("Unesite ime: ");
			String name = scanner.next();
			System.out.println("Unesi prezime: ");
			String surname = scanner.next();
			System.out.println("Unesite broj telefona: ");
			String phoneNumber = scanner.next();
			
			contactsList.add(name+" "+surname+" "+phoneNumber);
			
			
		}
		else {
			System.out.println("Unesite termin za pretragu: ");
			String term = scanner.next();
			
			for(String contact: contactsList) {
				if(contact.toLowerCase().contains(term.toLowerCase())) {
					System.out.println(contact);
				}
			}
			
		}
		
		System.out.println("Da li zelite da izadjete iz programa (1) ili zelite da nastavite sa radom(2)");
	    option = scanner.nextInt();
		
		}while(option != 1);
	    
		
	    
	    
	    BufferedWriter bWriter = new BufferedWriter(new FileWriter("contacts.txt"));

		   for(String contact: contactsList) {
			   bWriter.write(contact);
			   bWriter.newLine();
		   }
		
		
			if(bReader != null) {
				bReader.close();
			}
			if(bWriter != null) {
				bWriter.close();
			}
			if(scanner != null) {
				scanner.close();
			}
		}
	}


