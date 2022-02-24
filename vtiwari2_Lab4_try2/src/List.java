/** List interface which is implemented in LList*/
public interface List {
    
    public int size(LList.Link[] arr, int index);
    public void append(char it);
    public char removeFront();
    public void addFront(char it);
    public void addLast(char it);
    
}
