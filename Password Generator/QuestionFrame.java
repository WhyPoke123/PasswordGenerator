import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.util.Random;

public class QuestionFrame extends JFrame implements FocusListener{
    private JTextField AktivitaetField = new JTextField();
    private JButton generate = new JButton();
    public String randomString = "";
    public QuestionFrame(){
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 500;
        int frameHeight = 250;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("");
        setResizable(false);
        Container cp = getContentPane();
        AktivitaetField.addFocusListener(this);
        
        cp.setLayout(null);

        generate.setBounds(280, 150, 75, 25);
        generate.setText("Neues Passwort");
        generate.setMargin(new Insets(2, 2, 2, 2));
        generate.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                generate_ActionPerformed(evt);
            }
        });
        cp.add(generate);

        AktivitaetField.setBounds(30, 50, 100, 100);
        AktivitaetField.setText("Name der Anwendung");
        AktivitaetField.setOpaque(true);
        cp.add(AktivitaetField);

        setVisible(true);
    }
    public static void main(String [] args){
        new QuestionFrame();
        
        
    }
    public void generate_ActionPerformed(ActionEvent evt) {
        
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

    
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int length = 10;

        for(int i = 0; i < length; i++) {

            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }

       randomString = sb.toString();
       if(!randomString.isEmpty()){
        dispose();
       }
       else{ // Hier weiter machen

       }
       
	}

    
    public void focusGained(FocusEvent foc) {
		AktivitaetField.selectAll();
        
    }
	public void focusLost(FocusEvent foc) {
	}
}
