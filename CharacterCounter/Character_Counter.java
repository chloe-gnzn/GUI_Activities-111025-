package CharacterCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Character_Counter extends JFrame implements ActionListener {
    private JButton countButton;
    private JTextField characterTextField;
    private JTextArea messageTextArea;
    private JPanel contentPane;
    private JLabel countLabel;


    Character_Counter(){
        setContentPane(contentPane);
        setTitle("Character Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        countButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == countButton){
            String text = characterTextField.getText();
            String messageText = messageTextArea.getText();

            char character = text.charAt(0);
            int ctr = 0;

            for(char c : messageText.toCharArray()){
                if(c == character){
                    ctr++;
                }
            }

            countLabel.setText("Count:     "+ctr);
        }
    }

    public static void main(String[] args) {
        new Character_Counter();
    }
}
