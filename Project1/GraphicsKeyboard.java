import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;


public class GraphicsKeyboard extends JFrame implements KeyListener{
    private JPanel viewPanel = new JPanel();
    private JButton buttonArray[][] ;


    public GraphicsKeyboard(){
        // JFrame setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("2048");
        setPreferredSize( new Dimension(400, 400) );
        addKeyListener(this);
        // view Panel
//        viewPanel.setSize(400, 400);
        setLayout(new GridLayout(4,4) );

        Integer [][] array = {{0, 0, 0, 0},{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        buttonArray = new JButton[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton tempButton = new JButton( array[i][j].toString() );
                buttonArray[i][j] = tempButton;
                add(tempButton);
            }
        }

//        System.out.println("ff");
        setVisible(true);
        pack();
    }

    public void drawing2DArray(int[][] array){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.buttonArray[i][j].setText( Integer.toString( array[i][j]) );
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e){
        System.out.println("You typed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e){
        System.out.println("You released: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e){
        System.out.println("You pressed: " + e.getKeyChar());
    }

    public static void main (String[] args){
        GraphicsKeyboard gkeys = new GraphicsKeyboard();

        int[][] array = {{1, 1, 1, 1},{1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};

        gkeys.drawing2DArray(array);
    }

}