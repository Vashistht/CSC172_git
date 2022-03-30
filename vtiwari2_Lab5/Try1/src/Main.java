// imoports
import java.io.FileNotFoundException;
import java.io.File;
import java.lang.Comparable;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) { //throws FileNotFoundException 
        Trie nodes = new Trie ();
        File commands= new File(args[0]);

        try (Scanner strings = new Scanner(commands)) {
            while(strings.hasNextLine()){
                String commandSingle = strings.nextLine();
                /** split when one or many white spaces and add them as elements of the list
                // first element decides the action,
                // second (if present) where that action would take place 
                */
                String[] commandsSeparated = commandSingle.trim().split("\\s+"); 

                if(commandsSeparated[0].toLowerCase().equals("insert")){
                    nodes.insert(commandsSeparated[1]);
                } else if(commandsSeparated[0].toLowerCase().equals("search")){

                } else if(commandsSeparated[0].toLowerCase().equals("height")){

                } else if(commandsSeparated[0].toLowerCase().equals("size")){

                } else if(commandsSeparated[0].toLowerCase().equals("print")){
                    // nodes.trieToList(Trie.node); trietoList needs more work

                } else if(commandsSeparated[0].toLowerCase().equals("smallest")){

                } else if(commandsSeparated[0].toLowerCase().equals("largest")){

                }
            }
        }
        catch (Exception e) {
            System.out.println(e);  
        }
    }




}
