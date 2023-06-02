import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMFrame extends JFrame implements ActionListener {

    private JButton btnWithdraw;
    private JButton btnDeposit;
    private JButton btnCheckBalance;
    private JButton btnPayBills;

    private double balance = 1000.0;
    private JLabel atm2bg;

    public ATMFrame() {
        // Set window properties
        setTitle("ATM Machine");
        setSize(600, 519);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create UI components
        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(112, 194, 139, 54);
        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(112, 287, 139, 54);
        btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.setBounds(357, 194, 139, 54);
        btnPayBills = new JButton("Pay Bills");
        btnPayBills.setBounds(357, 287, 139, 54);

        // Add components to content pane
        Container contentPane = getContentPane();
        getContentPane().setLayout(null);
        contentPane.add(btnWithdraw);
        contentPane.add(btnDeposit);
        contentPane.add(btnCheckBalance);
        contentPane.add(btnPayBills);
        
        atm2bg = new JLabel("");
        atm2bg.setIcon(new ImageIcon(ATMFrame.class.getResource("/image/atm2bg.png")));
        atm2bg.setBounds(0, 0, 584, 480);
        getContentPane().add(atm2bg);

        // Register event listeners for buttons
        btnWithdraw.addActionListener(this);
        btnDeposit.addActionListener(this);
        btnCheckBalance.addActionListener(this);
        btnPayBills.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked and perform corresponding action
        if (e.getSource() == btnWithdraw) {
            String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                if (amount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this, "Withdrawal successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (e.getSource() == btnDeposit) {
            String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                balance += amount;
                JOptionPane.showMessageDialog(this, "Deposit successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == btnCheckBalance) {
            JOptionPane.showMessageDialog(this, "Your balance is $" + balance, "Balance", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnPayBills) {
            JOptionPane.showMessageDialog(this, "Pay Bills feature not implemented yet.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create and display the ATM Machine Frame
        ATMFrame frame = new ATMFrame();
        frame.setVisible(true);
    }
}
