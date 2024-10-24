import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    
    Random random = new Random(); // creates an instance of the random class
    JFrame frame = new JFrame(); // creates a new frame in which the game will run
    JPanel titlePanel = new JPanel(); // creates a panel to hold the title
    JPanel buttonPanel = new JPanel(); // creates a panel to hold the buttons
    JLabel textField = new JLabel(); // creates a label to serve as a text field
    JButton[] buttons = new JButton[9]; // creates an array of nine buttons
    boolean playerOneTurn; // true if it's player one's turn, false if it's player two's turn

    TicTacToe(){ // constructor for the TicTacToe class
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // will close the program upon closal of the frame
        frame.setSize(800, 800); // sets the default size of the frame
        frame.getContentPane().setBackground(new Color(0x93a4cf)); // sets the background color of the frame
        frame.setLayout(new BorderLayout()); // sets the layout of the frame
        frame.setVisible(true); // makes the frame visible

        textField.setBackground(new Color(0x93a4cf)); // sets label background color
        textField.setForeground(new Color(0x2f406b)); // sets text color
        textField.setFont(new Font("Helvetica Neue", Font.BOLD, 70)); // sets the font type, style, and size
        textField.setHorizontalAlignment(JLabel.CENTER); // centers the text box
        textField.setText("tic tac toe."); // sets the title
        textField.setOpaque(true); // sets the opacity

        titlePanel.setLayout(new BorderLayout()); // sets the layout of the title panel
        titlePanel.setBounds(0, 0, 800, 100); // sets the size of the title panel

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(0xbba7c9));
        buttonPanel.setForeground(new Color(0xbba7c9));

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Helvetica Neue", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(0x93a4cf)); // Background color for the buttons
            buttons[i].setOpaque(true); // Ensures the background is painted
            // Keep the borders to create a hashed look
            buttons[i].setBorder(BorderFactory.createLineBorder(new Color(0x2f406b), 5)); // Create a clearly colored border
        }

        titlePanel.add(textField); // adds the text field to the title panel
        frame.add(titlePanel, BorderLayout.NORTH); // adds the title panel to the frame
        frame.add(buttonPanel); // adds the button panel to the frame

        firstTurn();

    }
    
    // a method to randomly decide which player moves first
    public void firstTurn(){
        
        try {
        Thread.sleep(2500); // makes it so that tic tac toe shows at first before assigning a turn, adds a 2.5 second delay
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // simple conditional decision to randomly assign which player moves first
        if (random.nextInt(2) == 0){
            playerOneTurn = true;
            textField.setText("x turn");
        } else {
            playerOneTurn = false;
            textField.setText("o turn");
        }
    }

    public void isWinner(){
        // check x win conditions
        if ((buttons[0].getText()=="x") && (buttons[1].getText()=="x") && (buttons[2].getText()=="x")){
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText()=="x") && (buttons[4].getText()=="x") && (buttons[5].getText()=="x")){
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText()=="x") && (buttons[7].getText()=="x") && (buttons[8].getText()=="x")){
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText()=="x") && (buttons[3].getText()=="x") && (buttons[6].getText()=="x")){
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText()=="x") && (buttons[4].getText()=="x") && (buttons[7].getText()=="x")){
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText()=="x") && (buttons[5].getText()=="x") && (buttons[8].getText()=="x")){
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText()=="x") && (buttons[4].getText()=="x") && (buttons[8].getText()=="x")){
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText()=="x") && (buttons[4].getText()=="x") && (buttons[6].getText()=="x")){
            xWins(2, 4, 6);
        }

        // check o condition wins
        if ((buttons[0].getText()=="o") && (buttons[1].getText()=="o") && (buttons[2].getText()=="o")){
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText()=="o") && (buttons[4].getText()=="o") && (buttons[5].getText()=="o")){
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText()=="o") && (buttons[7].getText()=="o") && (buttons[8].getText()=="o")){
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText()=="o") && (buttons[3].getText()=="o") && (buttons[6].getText()=="o")){
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText()=="o") && (buttons[4].getText()=="o") && (buttons[7].getText()=="o")){
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText()=="o") && (buttons[5].getText()=="o") && (buttons[8].getText()=="o")){
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText()=="o") && (buttons[4].getText()=="o") && (buttons[8].getText()=="o")){
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText()=="o") && (buttons[4].getText()=="o") && (buttons[6].getText()=="o")){
            oWins(2, 4, 6);
        }

        // Check for draw (no winner and all buttons filled)
        boolean isDraw = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                isDraw = false; // If any button is still empty, it's not a draw
                break;
            }
        }
    
        if (isDraw) {
            draw(0, 1, 2, 3, 4, 5, 6, 7, 8);
        }
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(new Color(0x3e4261));
        buttons[b].setBackground(new Color(0x3e4261));
        buttons[c].setBackground(new Color(0x3e4261));
        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false); // so people can't touch buttons
        }
        textField.setText("x wins!!");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(new Color(0x3e4261));
        buttons[b].setBackground(new Color(0x3e4261));
        buttons[c].setBackground(new Color(0x3e4261));
        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false); // so people can't touch buttons
        }
        textField.setText("o wins!!");
    }

    public void draw(int a, int b, int c, int d, int e, int f, int g, int h, int i){
        buttons[a].setBackground(new Color(0x3e4261));
        buttons[b].setBackground(new Color(0x3e4261));
        buttons[c].setBackground(new Color(0x3e4261));
        buttons[d].setBackground(new Color(0x3e4261));
        buttons[e].setBackground(new Color(0x3e4261));
        buttons[f].setBackground(new Color(0x3e4261));
        buttons[g].setBackground(new Color(0x3e4261));
        buttons[h].setBackground(new Color(0x3e4261));
        buttons[i].setBackground(new Color(0x3e4261));
        for (int j = 0; j < 9; j++){
            buttons[i].setEnabled(false); // so people can't touch buttons
        }
        textField.setText("draw... try again");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // checks each button
        for (int i = 0; i < 9; i++){
            if (e.getSource() == buttons[i]){
                if (playerOneTurn){
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0xF6C1CE)); // color for x
                        buttons[i].setText("x");
                        playerOneTurn = false;
                        textField.setText("o turn");
                        isWinner(); // checks to see if adding an x here results in a win for x
                    }
                } else {
                        buttons[i].setForeground(new Color(0xE16482)); // color for o
                        buttons[i].setText("o");
                        playerOneTurn = true;
                        textField.setText("x turn");
                        isWinner(); // checks to see if adding an o here results in a win for o
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}