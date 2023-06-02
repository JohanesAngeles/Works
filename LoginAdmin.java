import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class LoginAdmin {

	 JFrame frame3;
	 private final JLabel lblNewLabel = new JLabel("Username: ");
	 private JTextField textField;
	 private JPasswordField passwordField;
	 private JLabel lblNewLabel_2;
	 private JLabel lblNewLabel_3;
	 private JLabel LoginAdminbg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin window = new LoginAdmin();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginAdmin() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginAdmin.class.getResource("/image/adminloginbttn.png")));
		frame3.setTitle("Login for Admin");
		frame3.setBounds(100, 100, 450, 553);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(33, 223, 98, 31);
		frame3.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(33, 297, 98, 25);
		frame3.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		textField.setBounds(43, 259, 344, 27);
		frame3.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		passwordField.setBounds(43, 322, 344, 27);
		frame3.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(LoginAdmin.class.getResource("/image/loginbttn.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				String username = textField.getText();

				if(password.contains("AdminOne")&& username.contains("Admin_01") //This is the pattern or format in logins 
				   || password.contains("AdminTwo") && username.contains("Admin_02")
				   || password.contains("AdminThree") && username.contains("Admin_03")) {
					passwordField.setText(null);
					textField.setText(null);
					JOptionPane.showMessageDialog(null, "SUCCESSFULLY LOGIN.");
					
					WelcomePage welcomepage = new WelcomePage();
					WelcomePage.main(null);
				    frame3.dispose();
				}
				else {

					JOptionPane.showMessageDialog(null, "Incorrect Username or Password. "
							+ "\nPlease try again!");
					passwordField.setText(null);
					textField.setText(null);
				}
			}
			
	
		});
		btnNewButton.setBounds(43, 371, 344, 31);
		frame3.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Please Login your\r\n ");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(134, 95, 193, 37);
		frame3.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Admin Account");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_3.setBounds(144, 129, 164, 31);
		frame3.getContentPane().add(lblNewLabel_3);
		
		LoginAdminbg = new JLabel("");
		LoginAdminbg.setIcon(new ImageIcon(LoginAdmin.class.getResource("/image/LibrarySystemHPBackground.jpg")));
		LoginAdminbg.setBounds(0, 0, 434, 514);
		frame3.getContentPane().add(LoginAdminbg);
	}
}
