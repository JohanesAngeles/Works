import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class ATM extends JFrame implements ActionListener {
    
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    
    public ATM() {
        // Set window properties
        setTitle("ATM Login");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create UI components
        JPanel panel = new JPanel();
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblUsername.setBounds(168, 224, 140, 37);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblPassword.setBounds(168, 294, 140, 29);
        tfUsername = new JTextField();
        tfUsername.setBorder(new LineBorder(new Color(171, 173, 179)));
        tfUsername.setBounds(168, 261, 262, 37);
        pfPassword = new JPasswordField();
        pfPassword.setBorder(new LineBorder(new Color(171, 173, 179)));
        pfPassword.setBounds(168, 323, 262, 37);
        btnLogin = new JButton("Log in");
        btnLogin.setBounds(168, 371, 262, 37);
        panel.setLayout(null);
        
        // Add components to panel
        panel.add(lblUsername);
        panel.add(tfUsername);
        panel.add(lblPassword);
        panel.add(pfPassword);
        panel.add(btnLogin);
        
        // Add panel to frame
        getContentPane().add(panel, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("Login your bank account");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblNewLabel.setBounds(188, 178, 220, 28);
        panel.add(lblNewLabel);
        
        JLabel atmbg = new JLabel("");
        atmbg.setIcon(new ImageIcon(ATM.class.getResource("/image/atmbg.png")));
        atmbg.setBounds(0, 0, 584, 461);
        panel.add(atmbg);
        
        // Register event listener for login button
        btnLogin.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if login button was clicked
        if (e.getSource() == btnLogin) {
            String username = tfUsername.getText();
            char[] password = pfPassword.getPassword();
            
            // TODO: Implement authentication logic here
            boolean authenticated = true;
            
            if (authenticated) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Login failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args) {
        // Create and display the ATM Login Frame
        ATM frame = new ATM();
        frame.setVisible(true);
    }
}

