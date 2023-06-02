import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class BookCancellationForm extends JFrame implements ActionListener {
    private JLabel nameLabel, emailLabel, dateLabel, roomNumberLabel, contactNumberLabel;
    private JTextField nameField, emailField, dateField, roomNumberField, contactNumberField;
    private JButton cancelButton;
    private JLabel cancelbg;

    public BookCancellationForm() {
        setTitle("Book Cancellation Form");
        setSize(401, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        nameLabel.setBounds(56, 204, 100, 23);
        nameField = new JTextField(20);
        nameField.setBorder(new LineBorder(new Color(171, 173, 179)));
        nameField.setBounds(166, 204, 173, 23);
        getContentPane().setLayout(null);
        getContentPane().add(nameLabel);
        getContentPane().add(nameField);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        emailLabel.setBounds(56, 249, 100, 23);
        emailField = new JTextField(20);
        emailField.setBorder(new LineBorder(new Color(171, 173, 179)));
        emailField.setBounds(166, 250, 173, 23);
        getContentPane().add(emailLabel);
        getContentPane().add(emailField);

        dateLabel = new JLabel("Date Reserve:");
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        dateLabel.setBounds(56, 290, 100, 23);
        dateField = new JTextField(20);
        dateField.setBorder(new LineBorder(new Color(171, 173, 179)));
        dateField.setBounds(166, 291, 173, 23);
        getContentPane().add(dateLabel);
        getContentPane().add(dateField);

        roomNumberLabel = new JLabel("Room Number:");
        roomNumberLabel.setForeground(Color.WHITE);
        roomNumberLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        roomNumberLabel.setBounds(56, 337, 100, 23);
        roomNumberField = new JTextField(20);
        roomNumberField.setBorder(new LineBorder(new Color(171, 173, 179)));
        roomNumberField.setBounds(166, 338, 173, 23);
        getContentPane().add(roomNumberLabel);
        getContentPane().add(roomNumberField);

        contactNumberLabel = new JLabel("Contact #:");
        contactNumberLabel.setForeground(Color.WHITE);
        contactNumberLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        contactNumberLabel.setBounds(56, 383, 99, 23);
        contactNumberField = new JTextField(20);
        contactNumberField.setBorder(new LineBorder(new Color(171, 173, 179)));
        contactNumberField.setBounds(166, 384, 173, 23);
        getContentPane().add(contactNumberLabel);
        getContentPane().add(contactNumberField);

        cancelButton = new JButton("");
        cancelButton.setIcon(new ImageIcon(BookCancellationForm.class.getResource("/image/cancelbutton.png")));
        cancelButton.setBounds(71, 447, 248, 23);
        getContentPane().add(cancelButton);
        
        cancelbg = new JLabel("");
        cancelbg.setIcon(new ImageIcon(BookCancellationForm.class.getResource("/image/Cancelbg.png")));
        cancelbg.setBounds(0, 0, 384, 561);
        getContentPane().add(cancelbg);
        cancelButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel your booking?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Perform cancel booking logic here
                JOptionPane.showMessageDialog(this, "Your booking has been cancelled.", "Booking Cancelled", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        new BookCancellationForm();
    }
}
