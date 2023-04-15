import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame implements ActionListener {

    //Declare and initialize buttons for each module
    private final JButton userButton = new JButton("User Module");
    private final JButton energyButton = new JButton("Energy Consumption Module");
    private final JButton renewableButton = new JButton("Renewable Energy Generation Module");
    private final JButton transactionButton = new JButton("Transaction Module");
    private final JButton adminButton = new JButton("Admin Module");
    private JButton adminModuleButton;
    private JPanel panel1;
    private JButton userModuleButton;
    private JButton transactionModuleButton;
    private JButton renewableEnergyGenerationModuleButton;
    private JButton energyConsumptionModuleButton;

    public MainPage() {
        //Create a new JFrame for the main page
        JFrame mainPage = new JFrame("Main Page");

        //Create a new JPanel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));

        //Add the buttons to the panel
        buttonPanel.add(userButton);
        buttonPanel.add(energyButton);
        buttonPanel.add(renewableButton);
        buttonPanel.add(transactionButton);
        buttonPanel.add(adminButton);

        //Add an action listener to each button
        userButton.addActionListener(this);
        energyButton.addActionListener(this);
        renewableButton.addActionListener(this);
        transactionButton.addActionListener(this);
        adminButton.addActionListener(this);

        //Add the panel to the main page frame
        mainPage.add(buttonPanel);

        //Set the size of the frame and make it visible
        mainPage.setSize(400, 400);
        mainPage.setVisible(true);
    }

    //Implement actionPerformed method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userButton) {
            //Code to display the user module
        } else if (e.getSource() == energyButton) {
            //Code to display the energy consumption module
        } else if (e.getSource() == renewableButton) {
            //Code to display the renewable energy generation module
        } else if (e.getSource() == transactionButton) {
            //Code to display the transaction module
        } else if (e.getSource() == adminButton) {
            //Code to display the admin module
        }
    }

    //Main method to create an instance of the MainPage class
    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
    }
}