//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsuranceClaimApp {
    // Declare UI components
    private JFrame frame;
    private JTextField nameField, policyNumberField, claimAmountField;
    private JTextArea descriptionArea;
    private JTextArea resultArea;
    private JButton submitButton;

    public static void main(String[] args) {
        // Start the app
        SwingUtilities.invokeLater(() -> {
            new InsuranceClaimApp().createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        // Create frame
        frame = new JFrame("Insurance Claim Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create the form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2));

        // Add form fields
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Policy Number:"));
        policyNumberField = new JTextField();
        formPanel.add(policyNumberField);

        formPanel.add(new JLabel("Claim Amount:"));
        claimAmountField = new JTextField();
        formPanel.add(claimAmountField);

        formPanel.add(new JLabel("Description:"));
        descriptionArea = new JTextArea();
        formPanel.add(new JScrollPane(descriptionArea));

        // Add the submit button
        submitButton = new JButton("Submit Claim");
        formPanel.add(submitButton);

        // Add form panel to the frame
        frame.add(formPanel, BorderLayout.CENTER);

        // Add result area to display the submitted claim
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        frame.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        // Set up the submit button action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitClaim();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    public void submitClaim() {
        // Get input from fields
        String name = nameField.getText();
        String policyNumber = policyNumberField.getText();
        String claimAmount = claimAmountField.getText();
        String description = descriptionArea.getText();

        // Create the result string
        String result = "Claim Submitted:\n";
        result += "Name: " + name + "\n";
        result += "Policy Number: " + policyNumber + "\n";
        result += "Claim Amount: " + claimAmount + "\n";
        result += "Description: " + description;

        // Show the result in the result area
        resultArea.setText(result);
    }
}
