
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;

class Node implements Comparable<Node>{
    char ch;
    Integer freq;
    Node left = null;
    Node right = null;

    Node(char ch, Integer freq){ //Constructor
        this.ch = ch;
        this.freq = freq;
    }

    Node(Integer freq, Node left, Node right){ //Constructor
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public int compareTo(Node n){ //Compare frequencies to organize priority queue from lowest to highest
        if(this.freq < n.freq){ //If frequency of node is higher, we consider this node "less" in comparison
            return -1;
        } else if (this.freq > n.freq){ //If frequency of node is lower, we consider this node "greater" in comparison
            return 1;
        } else
            return 0;
    }

    public boolean isLeaf() {
        if ((this.left == null) && (this.right == null)) {
            return true;
        } else {
            return false;
        }
    }
}


public class HuffmanSubmit implements Huffman {
    HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>(); //Creates Hashmap of frequencies
    HashMap<Character, String> huffmanCodesEnc = new HashMap<Character, String>(); //Creates Hashmap of Huffman Codes;
    HashMap<String, Character> huffmanCodesDec = new HashMap<String, Character>(); //Creates Hashmap of Huffman Codes;
    PriorityQueue<Node> huffmanTreePQ = new PriorityQueue<>();
    Node huffmanTree;

    public void resetFreq(){
        frequencies.clear();
    }

    public void resetHuffmanCodes(){
        huffmanCodesEnc.clear();
        huffmanCodesDec.clear();
    }

    public void setHuffmanTree(){
        huffmanTree = huffmanTreePQ.poll();
    }

    public void createFreqFile(String inputFile, String freqFile) throws FileNotFoundException { //Create frequency file
        BinaryIn in  = new BinaryIn(inputFile);

        while (!in.isEmpty()){
            Character c = in.readChar();
            if (frequencies.containsKey(c) == true){
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }

        try {
            FileWriter myWriter = new FileWriter(freqFile);
            for (Character i : frequencies.keySet()){
                Integer val = Integer.valueOf(i);
                String cBin = Integer.toBinaryString(val);
                while (cBin.length() < 8){
                    cBin = "0" + cBin;
                }
                myWriter.write(cBin);
                myWriter.write(":");
                myWriter.write(String.valueOf(frequencies.get(i)));
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            //
        }

    }

    public void createHuffmanTree(){
        Node node1 = huffmanTreePQ.poll();
        Node node2 = huffmanTreePQ.poll();

        Node combinedNode = new Node(node1.freq + node2.freq, node1, node2);
        huffmanTreePQ.add(combinedNode);
    }

    public HashMap<Character, String> putCodesInHashEnc(Node node, String huffmanCode){
        if (node == null){
            return huffmanCodesEnc;
        }

        //Potential bug
        if (node.isLeaf()){
            huffmanCodesEnc.put(node.ch, huffmanCode);
            //System.out.println("Huffman Code for " + node.binString + " is " + huffmanCode);
        } else {
            putCodesInHashEnc(node.left, huffmanCode.concat("0"));
            putCodesInHashEnc(node.right, huffmanCode.concat("1"));
        }

        return huffmanCodesEnc;
    }

    public HashMap<String, Character> putCodesInHashDec(Node node, String huffmanCode){
        if (node == null){
            return huffmanCodesDec;
        }

        //Potential bug
        if (node.isLeaf()){
            huffmanCodesDec.put(huffmanCode, node.ch);
            //System.out.println("Huffman Code for " + node.binString + " is " + huffmanCode);
        } else {
            putCodesInHashDec(node.left, huffmanCode.concat("0"));
            putCodesInHashDec(node.right, huffmanCode.concat("1"));
        }

        return huffmanCodesDec;
    }

    public void buildFreq(String freqFile) throws FileNotFoundException{
        File myFreqFile = new File(freqFile);
        Scanner scnr = new Scanner(myFreqFile);

        while (scnr.hasNextLine()){
            String scnrLine = scnr.nextLine();
            int indOfColon = scnrLine.indexOf(":");
            String myChar = scnrLine.substring(0, indOfColon);
            String myFreqStr = scnrLine.substring(indOfColon + 1, scnrLine.length());
            Integer myFreq = Integer.valueOf(myFreqStr);

            int parseInt = Integer.parseInt(myChar, 2);
            char c = (char)parseInt;
            frequencies.put(c, myFreq);
        }
    }

    public void createHuffmanEnc(){
        for (Character i : frequencies.keySet()){
            Node charFreq = new Node(i, frequencies.get(i));
            huffmanTreePQ.add(charFreq);
        }

        while (huffmanTreePQ.size() > 1){
            createHuffmanTree();
        }
        setHuffmanTree();
        putCodesInHashEnc(huffmanTree, "");
    }

    public void createHuffmanDec(){
        for (Character i : frequencies.keySet()){
            Node charFreq = new Node(i, frequencies.get(i));
            huffmanTreePQ.add(charFreq);
        }

        while (huffmanTreePQ.size() > 1){
            createHuffmanTree();
        }
        setHuffmanTree();
        putCodesInHashDec(huffmanTree, "");
    }

    public void createOutputEnc(String inputFile, String outputFile) throws FileNotFoundException{
        BinaryIn in = new BinaryIn(inputFile);

        BinaryOut out = new BinaryOut(outputFile);
        while (!in.isEmpty()){
            char c = in.readChar();
            String myHuffmanCode = huffmanCodesEnc.get(c);
            for (int i = 0; i < myHuffmanCode.length(); i++){
                if (myHuffmanCode.charAt(i) == '0'){
                    out.write(false);
                } else {
                    out.write(true);
                }
            }
        }
        out.flush();
    }

    public char traverseTree(BinaryIn in, Node node){
        if ((node.isLeaf()) || (in.isEmpty())){
            char c = node.ch;
            return c;
        }

        if (in.readBoolean() == false){
            return traverseTree(in, node.left);
        } else {
            return traverseTree(in, node.right);
        }
    }

    public void createOutputDec(String inputFile, String outputFile) throws IOException{
        BinaryIn in = new BinaryIn(inputFile);
        BinaryOut out = new BinaryOut(outputFile);
        while (!in.isEmpty()){
            out.write(traverseTree(in, huffmanTree));
        }
        out.flush();
    }

    public void encode(String inputFile, String outputFile, String freqFile){
        try {
            createFreqFile(inputFile, freqFile);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }

        createHuffmanEnc();

        try {
            createOutputEnc(inputFile, outputFile);
        } catch (FileNotFoundException e) {
            //
        }

        resetFreq();
        resetHuffmanCodes();

    }


    public void decode(String inputFile, String outputFile, String freqFile){
        try {
            buildFreq(freqFile);
        } catch (FileNotFoundException e) {
            //
        }

        createHuffmanDec();

        try {
            createOutputDec(inputFile, outputFile);
        } catch (IOException e) {
            //
        }
    }





    public static void main(String[] args) {
        Huffman  huffman = new HuffmanSubmit();
        huffman.encode("ur.jpg", "ur.enc", "freq.txt");
        huffman.decode("ur.enc", "ur_dec.jpg", "freq.txt");
        // After decoding, both ur.jpg and ur_dec.jpg should be the same.
        // On linux and mac, you can use `diff' command to check if they are the same.
        //System.out.println("hi");
    }

}
