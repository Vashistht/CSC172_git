import java.io.File;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.File;

public class DNAList {
//    static array of notes

    // enumeration RNA, DNA
    enum Type {
        DNA,
        RNA,
    }

    //    enumeration if the list is filled
    enum Occupancy {
        empty,
        filled,
    }

    LList linkedList = new LList();
    Array arr = new Array();

    File commands = new File(args[1]);
    Scanner s = new Scanner(commands);

    while(s.hasNextLine()){
        String command = s.nextLine();
        String[] commandParsed = command.trim().split("\\s+"); // parse by space

//        insert pos type sequence (Insert sequence to position pos in the sequence array
//         insert = commandParsed[0], pos=commandParsed[1], type = commandParsed[2], sequence = commandParsed[3]
        /*
         if (commandParsed[0].toLowerCase().equals("insert")){
            -
            if commandSeparated[2] == "DNA"{ // Type.valueof(commandSeparated[2]).equals(Type.DNA)) {
                nodelist = newlist (Integer.parseInt( commandParsed[1]) , commandParsed[3]) // first one is the location follwed by the sequence

                (1) if the checkDNA seuqnence is false: print ("Error Occured while inserting")
                (2) else (when checkDNA is true): at link (node) position pos add the sequence

            - else if (Type.valueof(commandSeparated[2]).equals(Type.RNA)){ // you will have to see what to do with the filled enum, I dont quite get it.
               nodelist = newlist (Integer.parseInt( commandParsed[1]) , commandParsed[3]) // first one is the location follwed by the sequence
                (1) if the checkRNA seuqnence is false: print ("Error Occured while inserting")
                (2)else (when checkRNA is true): at link (node) position pos add the sequence
           }

         */
    }
}

