package SurveyProgressIndicator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Survey_Progress_Indicator extends JFrame implements ActionListener {
    private JProgressBar progressBar;
    private JTextField nameField;
    private JTextField birthField;
    private JTextField genderField;
    private JTextField numberField;
    private JTextField emailField;
    private JButton submitButton;
    private JLabel messageLabel;
    private JPanel contentPane;

    Survey_Progress_Indicator() {
        setContentPane(contentPane);
        setTitle("Survey Progress Indicator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        DocumentListener updateProgress = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updateProgressBar(); }
            @Override
            public void removeUpdate(DocumentEvent e) { updateProgressBar(); }
            @Override
            public void changedUpdate(DocumentEvent e) { updateProgressBar(); }
        };


        nameField.getDocument().addDocumentListener(updateProgress);
        birthField.getDocument().addDocumentListener(updateProgress);
        genderField.getDocument().addDocumentListener(updateProgress);
        numberField.getDocument().addDocumentListener(updateProgress);
        emailField.getDocument().addDocumentListener(updateProgress);


        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            handleSubmit();
        }
    }


    private void updateProgressBar() {
        int filled = 0;
        JTextField[] fields = { nameField, birthField, genderField, numberField, emailField };

        for (JTextField field : fields) {
            if (!field.getText().trim().isEmpty()) {
                filled++;
            }
        }

        int progress = (int) ((filled / 5.0) * 100);
        progressBar.setValue(progress);
    }


    private void handleSubmit() {
        JTextField[] fields = { nameField, birthField, genderField, numberField, emailField };
        boolean allFilled = true;

        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                allFilled = false;
                break;
            }
        }

        if (allFilled) {
            messageLabel.setText("Thank you for answering");
        } else {
            messageLabel.setText("All fields are required");
        }
    }


    public static void main(String[] args) {
        new Survey_Progress_Indicator();
    }
}
