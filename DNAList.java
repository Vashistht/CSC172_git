package dp;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

import dp.Sequences.Filled;
import dp.Sequences.Type;

import java.io.File;

public class DNAList {
	
	public static void print(Sequences[] seqArray) {
		for (int i = 0; i < seqArray.length; i++) {
			if (seqArray[i] != null) {
				if (seqArray[i].getFill() != Filled.Empty) {
					System.out.print(i + "\t");
					System.out.print(seqArray[i].getType() + "\t");
					seqArray[i].printSeq();
					System.out.println();
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	  int sizeOfArray = 20;
	  Sequences[] seqArray = new Sequences[sizeOfArray];
	  
	  File commands = new File("C:\\Users\\livia\\eclipse-workspace\\Lab04 CSC 172\\src\\dp\\LabInput.txt");
	  Scanner scnr = new Scanner(commands);
	  
	  while (scnr.hasNextLine()) {
		  Scanner scLine = new Scanner(scnr.nextLine());
		  
		  String command = scLine.next();
		  if (command.equals("insert")) {
			  boolean replace;
			  int pos = Integer.parseInt(scLine.next());
			  String typeStr = scLine.next();
			  String sequence = scLine.next();
			  
			  Sequences seq = new Sequences(sequence, typeStr, "Filled"); //Make new sequence
			  
			  if (seq.getType() == Type.DNA) { //Checks if seq matches type (DNA)
				  if (seq.checkIfDNA() == true) {
					  replace = true;
				  } else {
					  System.out.println("Error while inserting");
					  replace = false;
				  }
			  } else if (seq.getType() == Type.RNA) { //Checks if seq matches type (RNA)
				  if (seq.checkIfRNA() == true) {
					  replace = true;
				  } else {
					  System.out.println("Error while inserting");
					  replace = false;
				  }
			  } else {
				  replace = false;
			  }
			  
			  if ((pos < sizeOfArray) && (replace = true)) {
				  seqArray[pos] = seq;
			  }
			  
		  } else if (command.equals("remove")) {
			  int pos = Integer.parseInt(scLine.next());
			  if (seqArray[pos] == null) {
				  System.out.println("No sequence to remove at specified position");
			  } else if (seqArray[pos].getFill() == Filled.Empty) {
				  System.out.println("No sequence to remove at specified position");
			  } else if (pos < sizeOfArray) {
				  seqArray[pos] = new Sequences("Empty");
			  }
		  } else if (command.equals("print")) {
			  if (scLine.hasNext()) {
				  int pos = Integer.parseInt(scLine.next());
				  seqArray[pos].printSeq();
			  } else {
				  print(seqArray); 
			  }
		  }
	  }
  }
}

