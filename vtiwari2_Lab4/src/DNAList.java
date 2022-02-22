import java.io.File;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.File;

public class DNAList {
//    static array of notes

// enumeration RNA, DNA
    enum Type{
        DNA,
        RNA,
    }

//    enumeration if the list is filled
    enum Filled{
        Empty,
        Filled,
    }

    LList linkedList = new LList();
    Array arr = new Array();

    File commands = new File(args[1]);
    Scanner s = new Scanner(commands);

    while(s.hasNextLine())

    {
        String command = s.nextLine();
        String[] commandParsed= command.trim().split("\\s+");

//        insert pos type sequence (Insert sequence to position pos in the sequence array
//         insert = commandParsed[0], pos=commandParsed[1], type = commandParsed[2], sequence = commandParsed[3]
        /*
         if (commandParsed[0].toLowerCase().equals("insert")){
            if commandSeparated[2] == "DNA"{
                nodelist = newlist (Integer.parseInt( commandParsed[1]) , commandParsed[3])
                (1) i
         */
    
