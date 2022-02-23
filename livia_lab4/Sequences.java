package dp;

public class Sequences {
	protected LList<Character> sequence = new LList<>();
	
	enum Type{
	      DNA,
	      RNA,
	}
	
	//  enumeration if the list is filled
	enum Filled{
		Empty,
		Filled,
	}
	
	Filled filled;
	Type type;
	
	public Sequences(String sequence, String type, String filled) {
		for (int i = 0; i < sequence.length(); i++) {
			(this.sequence).append(sequence.charAt(i));
		}
		
		if (type.equals("DNA")) {
			this.type = Type.DNA;
		} else if (type.equals("RNA")) {
			this.type = Type.RNA;
		}
		
		this.filled = Filled.Filled;
	}
	
	public Sequences(String filled) {
		if (filled.equals("Empty")) {
			this.filled = Filled.Empty;
		}
	}
	
	public Type getType() {
		return type;
	}
	
	public Filled getFill() {
		return filled;
	}
	
	public boolean checkIfDNA() {
		for (int i = 0; i < sequence.length(); i++) {
			if ((sequence.getValue() != 'A') && (sequence.getValue() != 'T') && (sequence.getValue() != 'G') && (sequence.getValue() != 'C')) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkIfRNA() {
		for (int i = 0; i < sequence.length(); i++) {
			if ((sequence.getValue() != 'A') && (sequence.getValue() != 'U') && (sequence.getValue() != 'G') && (sequence.getValue() != 'C')) {
				return false;
			}
		}
		return true;
	}
	
	public void printSeq() {
		sequence.printList();
	}
	
}
