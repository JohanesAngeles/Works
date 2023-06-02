import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ConferenceRoomReservation extends JFrame {
    
    private JLabel nameLabel, collegeLabel, studentNumberLabel, dateLabel,tableLabel, seatLabel;
    private JTextField nameField, collegeField, studentNumberField, dateField, tableField, seatField;
    private JButton reserveButton;
    
    public ConferenceRoomReservation() {
        setTitle("Library Conference Room Reservation");
        setSize(400, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        nameLabel.setBounds(61, 254, 114, 14);
        getContentPane().add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBorder(new LineBorder(new Color(171, 173, 179)));
        nameField.setBounds(185, 251, 145, 20);
        getContentPane().add(nameField);
        
        collegeLabel = new JLabel("College:");
        collegeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        collegeLabel.setBounds(61, 285, 114, 14);
        getContentPane().add(collegeLabel);
        collegeField = new JTextField(20);
        collegeField.setBorder(new LineBorder(new Color(171, 173, 179)));
        collegeField.setBounds(185, 282, 145, 20);
        getContentPane().add(collegeField);
        
        studentNumberLabel = new JLabel("Student Number:");
        studentNumberLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        studentNumberLabel.setBounds(61, 316, 114, 14);
        getContentPane().add(studentNumberLabel);
        studentNumberField = new JTextField(20);
        studentNumberField.setBorder(new LineBorder(new Color(171, 173, 179)));
        studentNumberField.setBounds(185, 313, 145, 20);
        getContentPane().add(studentNumberField);
        
        dateLabel = new JLabel("Reservation Date:");
        dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        dateLabel.setBounds(61, 344, 114, 14);
        getContentPane().add(dateLabel);
        dateField = new JTextField(20);
        dateField.setBorder(new LineBorder(new Color(171, 173, 179)));
        dateField.setBounds(185, 341, 145, 20);
        getContentPane().add(dateField);
        
        tableLabel = new JLabel("Table Number (1-4):");
        tableLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableLabel.setBounds(61, 375, 114, 14);
        getContentPane().add(tableLabel);
        tableField = new JTextField(20);
        tableField.setBorder(new LineBorder(new Color(171, 173, 179)));
        tableField.setBounds(185, 372, 145, 20);
        getContentPane().add(tableField);
        
        seatLabel = new JLabel("Seat Number (1-5):");
        seatLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        seatLabel.setBounds(61, 223, 114, 14);
        getContentPane().add(seatLabel);
        seatField = new JTextField(20);
        seatField.setBorder(new LineBorder(new Color(171, 173, 179)));
        seatField.setBounds(185, 220, 145, 20);
        getContentPane().add(seatField);
        
        reserveButton = new JButton("");
        reserveButton.setIcon(new ImageIcon(ConferenceRoomReservation.class.getResource("/image/reservebutton.png")));
        reserveButton.setBounds(86, 417, 231, 23);
        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String college = collegeField.getText();
                String studentNumber = studentNumberField.getText();
                String date = dateField.getText();
                String table = tableField.getText();
                String seat = seatField.getText();
                
                // Verify that the table and seat numbers are within the correct range
                int tableNumber = Integer.parseInt(table);
                if (tableNumber < 1 || tableNumber > 4) {
                    JOptionPane.showMessageDialog(null, "Invalid table number");
                    return;
                }
                int seatNumber = Integer.parseInt(seat);
                if (seatNumber < 1 || seatNumber > 5) {
                    JOptionPane.showMessageDialog(null, "Invalid seat number");
                    return;
                }
                
                // Save the reservation information to a text file
                try {
                    FileWriter writer = new FileWriter("reservations.txt", true);
                    writer.write(name + "," + college + "," + studentNumber + "," + date + "," + table + "," + seat + "\n");
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                JOptionPane.showMessageDialog(null, "Reservation saved");
            }
        });
        getContentPane().add(reserveButton);
        
        JLabel reservebg = new JLabel("");
        reservebg.setIcon(new ImageIcon(ConferenceRoomReservation.class.getResource("/image/reservebg.png")));
        reservebg.setBounds(0, 0, 384, 481);
        getContentPane().add(reservebg);
    }
    
    public static void main(String[] args) {
        ConferenceRoomReservation reservationForm = new ConferenceRoomReservation();
        reservationForm.setVisible(true);
    }
}

