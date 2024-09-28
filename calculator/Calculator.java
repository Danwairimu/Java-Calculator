import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Calculator extends JFrame implements ActionListener{
    //calculator components
    private JTextField display;//to display input and result
    private JButton[]numberButtons;//array of number buttons
    private JButton[]functionButtons;//Array of function buttons
    private JButton addButton,subButton,divButton,mulButton,decButton,equButton,delButton,clrButton;
    private JPanel panel;//panel to hold buttons

    //variables to perform calculations
    private double num1 = 0,num2 = 0,result = 0;
    private char operator;//to store selected operator

    //constructor to set up our calculator
    public Calculator(){
        //frame
        setTitle("Calculator");
        setSize(500,300);
        setDefaultCloseOperation(3);
        setLayout(null);//null layout enables us to have absolute positioning

        //display field
        display = new JTextField();
        display.setBounds(50,25,300,50);//position and size of the display
        display.setFont(new Font("Arial",Font.PLAIN,25));//display font
        display.setEditable(false);//disabling editing the display area
        add(display);//adding display to frame

        //creating number buttons
        numberButtons = new JButton[10];
        for(int i = 0;i < 10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));//Button text is the number itself
            numberButtons[i].addActionListener(this);//adding action listener to each button

        }

        //creating function buttons
        functionButtons = new JButton[8];
        addButton = new JButton("+");
        addButton.setFocusable(false);
        subButton = new JButton("-");
        subButton.setFocusable(false);
        mulButton = new JButton("*");
        mulButton.setFocusable(false);
        divButton = new JButton("/");
        divButton.setFocusable(false);
        decButton = new JButton(".");
        decButton.setFocusable(false);
        equButton = new JButton("=");
        equButton.setFocusable(false);
        delButton = new JButton("Del");
        delButton.setFocusable(false);
        clrButton = new JButton("Clr");
        clrButton.setFocusable(false);

        //add function buttons to the array
        functionButtons[0] = addButton;
        addButton.setFocusable(false);
        functionButtons[1] = subButton;
        subButton.setFocusable(false);
        functionButtons[2] = mulButton;
        mulButton.setFocusable(false);
        functionButtons[3] = divButton;
        divButton.setFocusable(false);
        functionButtons[4] = decButton;
        decButton.setFocusable(false);
        functionButtons[5] = equButton;
        equButton.setFocusable(false);
        functionButtons[6] = delButton;
        delButton.setFocusable(false);
        functionButtons[7] = clrButton;
        clrButton.setFocusable(false);

        //add action listeners to function buttons
        for(JButton button : functionButtons){
            button.addActionListener(this);
             
        }

        //panel for buttons
        panel = new JPanel();
        panel.setBounds(50,100,300,300);//position and size of panel
        panel.setLayout(new GridLayout(4,4,10,10));//4*4 grid with 10px gaps

        //setting button focus to false
        numberButtons[1].setFocusable(false);
        numberButtons[2].setFocusable(false);
        numberButtons[3].setFocusable(false);
        numberButtons[4].setFocusable(false);
        numberButtons[5].setFocusable(false);
        numberButtons[6].setFocusable(false);
        numberButtons[7].setFocusable(false);
        numberButtons[8].setFocusable(false);
        numberButtons[9].setFocusable(false);
        numberButtons[0].setFocusable(false);

        //add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(equButton);

        add(panel);//adding it to frame

        //positioning and adding delete and clear buttons
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        add(delButton);
        add(clrButton);

        //adding hover events by using mouse events
        for(JButton button : numberButtons){
            button.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent e){
                    button.setBackground(Color.cyan);
                }
                public void mouseExited(MouseEvent e){
                    button.setBackground(UIManager.getColor("Button.background"));//reset color
                }
            });
        }
        for (JButton button : functionButtons){
             button.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent e){
                    button.setBackground(Color.cyan);
                }
                public void mouseExited(MouseEvent e){
                    button.setBackground(UIManager.getColor("Button.background"));//reset color
                }
            });
        }
        //make our frame visible
        setVisible(true);
    }
    //method to handle button click events
    public void actionPerformed(ActionEvent e){
        for(int i = 0;i < 10;i++){
            if(e.getSource() == numberButtons[i]){
                display.setText(display.getText().concat(String.valueOf(i)));//append number to the display
            }
        }
        if(e.getSource() == decButton){
            display.setText(display.getText().concat("."));//append decimal point to display
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(display.getText());//store the first number
            operator = '+';//set operator to addition
            display.setText("");//clear display
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(display.getText());//store the first number
            operator = '-';//set operator to substraction
            display.setText("");//clear display
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(display.getText());//store the first number
            operator = '*';//set operator t0 multiplication
            display.setText("");//clear display
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(display.getText());//store the first number
            operator = '/';//set operator to division
            display.setText("");//clear display
            
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(display.getText());//store second number
            switch(operator){
                case '+':
                    result = num1 + num2;//perform addition
                    break;
                case '-':
                    result = num1 - num2;//perform substraction
                    break;
                case '*':
                    result = num1 * num2;//perform multiplication
                    break;
                case '/':
                    result = num1 / num2;//perform division
                    break;
            }
            display.setText(String.valueOf(result));//display the result
            num1 = result;//store result for further calculations
        }
        if(e.getSource() == clrButton){
            display.setText("");//clear display
        }
        if(e.getSource() == delButton){
            String string = display.getText();
            display.setText("");
            for(int i = 0; i < string.length()-1; i++){
                display.setText(display.getText() + string.charAt(i));//remove last character from display
            }
        }
    }
    //main method
    public static void main(String[]args){
        new Calculator();//instance of this class
    }
}