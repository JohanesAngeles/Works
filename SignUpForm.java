import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.MatteBorder;

public class SignUpForm extends JFrame implements ActionListener {
    private JTextField usernameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signupButton;
    
    public SignUpForm() {
        setTitle("Sign up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(798, 862);
        getContentPane().setLayout(null);
        
        // Create text fields for each input
        usernameField = new JTextField();
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        usernameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        usernameField.setBounds(278, 431, 407, 40);
        getContentPane().add(usernameField);
        emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        emailField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        emailField.setBounds(278, 508, 407, 40);
        getContentPane().add(emailField);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        passwordField.setBounds(278, 590, 407, 40);
        getContentPane().add(passwordField);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        confirmPasswordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        confirmPasswordField.setBounds(278, 671, 407, 40);
        getContentPane().add(confirmPasswordField);
        
        // Create labels for each field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        usernameLabel.setBounds(147, 428, 106, 40);
        getContentPane().add(usernameLabel);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        emailLabel.setBounds(147, 508, 106, 40);
        getContentPane().add(emailLabel);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passwordLabel.setBounds(147, 587, 107, 40);
        getContentPane().add(passwordLabel);
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        confirmPasswordLabel.setBounds(147, 671, 131, 40);
        getContentPane().add(confirmPasswordLabel);
        
        // Create a sign up button
        signupButton = new JButton("Sign up");
        signupButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        signupButton.setBounds(278, 740, 407, 40);
        getContentPane().add(signupButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SignUpForm.class.getResource("/image/signupbg.png")));
        lblNewLabel.setBounds(0, 0, 788, 823);
        getContentPane().add(lblNewLabel);
        signupButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
                return;
            }
            
            // Perform sign up logic here
            
            JOptionPane.showMessageDialog(this, "Sign up successful.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignUpForm signupForm = new SignUpForm();
            signupForm.setVisible(true);
        });
    }
}
