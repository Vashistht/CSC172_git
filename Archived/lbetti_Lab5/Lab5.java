import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) throws Exception {
		Trie1 trie = new Trie1();
		File commands = new File(args[0]);
		try (Scanner strings = new Scanner(commands)) {
			while (strings.hasNextLine()) {
				String commandSingle = strings.nextLine();
				/** split when one or many white spaces and add them as elements of the list
				// first element decides the action,
				// second (if present) where that action would take place 
				*/
				String[] commandsSeparated = commandSingle.trim().split("\\s+"); 

				if (commandsSeparated[0].equals("insert")){
					trie.insert(trie, commandsSeparated[1]);
				}
			   		   
				else if (commandsSeparated[0].equals("search")){
					System.out.println(trie.search(trie, commandsSeparated[1]));
				}
			   
				else if (commandsSeparated[0].equals("height")){
					System.out.println(trie.height(trie)); 
				}

			   
				else if (commandsSeparated[0].equals("size")){
					System.out.println(trie.size(trie));
				}
			   
				else if (commandsSeparated[0].equals("largest")){
					System.out.println(trie.largest(trie)); 
				}
				else if (commandsSeparated[0].equals("smallest")){
					System.out.println(trie.smallest(trie)); 
				}
				else if (commandsSeparated[0].equals("print")){
					trie.print(trie.trieToList(trie));
				}
			   
			}
		}
		catch (FileNotFoundException e) {
            System.out.printf("Sorry, your file was not found", e);  
        }
	}
}
