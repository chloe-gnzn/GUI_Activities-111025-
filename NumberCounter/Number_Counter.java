package NumberCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Number_Counter extends JFrame implements ActionListener {
    private JButton decreaseButton;
    private JButton increaseButton;
    private JLabel countLabel;
    private JPanel contentPane; //name of my Number_Counter.form
    private static int ctr;

    public Number_Counter() {
        setContentPane(contentPane); // connecting it to the GUI form
        setTitle("Number Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        ctr = 0;
        countLabel.setText(String.valueOf(ctr));

        decreaseButton.addActionListener(this);     //addActionListener calls the actionPerformed method
        increaseButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == decreaseButton) {
            ctr--;
        } else if (e.getSource() == increaseButton) {
            ctr++;
        }
        countLabel.setText(String.valueOf(ctr));
    }

    public static void main(String[] args) {
        new Number_Counter();
    }
}
