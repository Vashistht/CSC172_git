import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public char getChar(){
		return this.ch;
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


public class HuffmanGraphics extends JComponent implements Huffman {
	HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>(); //Creates Hashmap of frequencies
	HashMap<Character, String> huffmanCodesEnc = new HashMap<Character, String>(); //Creates Hashmap of Huffman Codes; 
	HashMap<String, Character> huffmanCodesDec = new HashMap<String, Character>(); //Creates Hashmap of Huffman Codes; 
	PriorityQueue<Node> huffmanTreePQ = new PriorityQueue<>();
	Node huffmanTree;
    boolean painted = false;

    @Override
	public void paintComponent(Graphics g) {
        paintHuffmanTree(g, huffmanTree, 600, 20, 600);
    }

	public void paintHuffmanTree(Graphics g, Node node, int x, int y, int width){
		Graphics2D g2D = (Graphics2D) g;

		if (node.isLeaf()){
			g2D.setColor(Color.GRAY);
			Rectangle rect = new Rectangle(x, y, 50, 20);
			g2D.fill(rect);
			g2D.setColor(Color.BLACK);
			g2D.drawRect(x, y, 50, 20);
			String nodeText = node.ch + ": " + node.freq;
			//System.out.println(nodeText + " is leaf with x = " + x + ", y = " + y);
			g2D.drawString(nodeText, x, y + 10);
		} else {
			g2D.setColor(Color.GRAY);
			Rectangle rect = new Rectangle(x, y, 50, 20);
			g2D.fill(rect);
			g2D.setColor(Color.BLACK);
			g2D.drawRect(x, y, 50, 20);
			String nodeText = Integer.toString(node.freq);
			//System.out.println(nodeText + " is internal with x = " + x + ", y = " + y);
			//System.out.println("Line starts at x = " + (x-25) + "y = " + (y-20));

			if ((node.left).isLeaf()){
				g2D.drawString(nodeText, x, y+10);
				g2D.drawLine(x+25, y + 20, x, y + 30);
				g2D.drawString("0", x +5, y+25);
				paintHuffmanTree(g, node.left, x - 20, y + 30, width/2);
			} else {
				g2D.drawString(nodeText, x, y+10);
				g2D.drawLine(x+25, y + 20, x - (width/2) + 20, y + 30);
				g2D.drawString("0", x + (25 - (width)/2 + 20)/2, y+25);
				paintHuffmanTree(g, node.left, x - width/2, y + 30, width/2);
			}

			if ((node.right).isLeaf()){
				g2D.drawLine(x+25, y+20, x + 40, y + 55);
				g2D.drawString("1", x + 40, y+50);
				paintHuffmanTree(g, node.right, x + 20, y + 55, width/2);
			} else{
				g2D.drawLine(x+25, y+20, x + (width/2) + 20, y + 55);
				g2D.drawString("1", x + (55 + (width)/2)/2, y+50);
				paintHuffmanTree(g, node.right, x + width/2, y + 55, width/2);
			}
		}
	}

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

		resetFreq();
		resetHuffmanCodes();
   }

   /*
   protected Timer timer;
	
	public HuffmanGraphics() {
		super();
		setFocusable(true);
		timer = new Timer(10, new TimerCallback());
		timer.start();
	}
	
	protected class TimerCallback implements ActionListener {
			
		public void actionPerformed(ActionEvent e) {
            painted = true;
			repaint();		
		}
	}
	*/





   public static void main(String[] args) {
    HuffmanGraphics  huffman = new HuffmanGraphics();
	huffman.encode("alice30.txt", "ur.enc", "freq.txt");
	JFrame frame = new JFrame("Huffman Tree");
	frame.add(huffman);
	frame.setSize(1500,650);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	//huffman.decode("ur.enc", "myText.txt", "freq.txt");
	// After decoding, both ur.jpg and ur_dec.jpg should be the same. 
	// On linux and mac, you can use `diff' command to check if they are the same. 
   }

}
