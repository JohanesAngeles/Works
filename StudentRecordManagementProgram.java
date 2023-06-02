import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.MatteBorder;

public class StudentRecordManagementProgram extends JFrame implements ActionListener {
    // GUI components
    private JTextField studentNoTextField, degreeTextField, yearLevelTextField, firstNameTextField,
            middleNameTextField, lastNameTextField, genderTextField, prelimGradeTextField, midtermGradeTextField,
            finalGradeTextField;
    private JButton saveButton, quitButton, continueButton;

    // Student record data
    private String studentNo, degree, yearLevel, firstName, middleName, lastName, gender;
    private double prelimGrade, midtermGrade, finalGrade, finalTermGrade;

    // File handling
    private File currentFile;
    private FileWriter fileWriter;
    private BufferedReader fileReader;
    private JLabel lblNewLabel;

    public StudentRecordManagementProgram() {
    	setResizable(false);
        // Set up the GUI
        setTitle("Student Record Management Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1024);
        getContentPane().setLayout(null);

        // Add labels and text fields for each data field
        JLabel label = new JLabel("Student No:");
        label.setFont(new Font("Monospaced", Font.BOLD, 15));
        label.setBounds(817, 219, 179, 41);
        getContentPane().add(label);
        studentNoTextField = new JTextField();
        studentNoTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        studentNoTextField.setBounds(1028, 219, 350, 41);
        getContentPane().add(studentNoTextField);

        JLabel label_1 = new JLabel("Degree:");
        label_1.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_1.setBounds(817, 271, 179, 41);
        getContentPane().add(label_1);
        degreeTextField = new JTextField();
        degreeTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        degreeTextField.setBounds(1028, 271, 350, 41);
        getContentPane().add(degreeTextField);

        JLabel label_2 = new JLabel("Year Level:");
        label_2.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_2.setBounds(817, 330, 179, 41);
        getContentPane().add(label_2);
        yearLevelTextField = new JTextField();
        yearLevelTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        yearLevelTextField.setBounds(1028, 330, 350, 41);
        getContentPane().add(yearLevelTextField);

        JLabel label_3 = new JLabel("First Name:");
        label_3.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_3.setBounds(91, 219, 159, 41);
        getContentPane().add(label_3);
        firstNameTextField = new JTextField();
        firstNameTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        firstNameTextField.setBounds(319, 219, 350, 41);
        getContentPane().add(firstNameTextField);

        JLabel label_4 = new JLabel("Middle Name:");
        label_4.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_4.setBounds(91, 271, 151, 41);
        getContentPane().add(label_4);
        middleNameTextField = new JTextField();
        middleNameTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        middleNameTextField.setBounds(319, 271, 350, 41);
        getContentPane().add(middleNameTextField);

        JLabel label_5 = new JLabel("Last Name:");
        label_5.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_5.setBounds(91, 330, 159, 41);
        getContentPane().add(label_5);
        lastNameTextField = new JTextField();
        lastNameTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        lastNameTextField.setBounds(319, 325, 350, 41);
        getContentPane().add(lastNameTextField);

        JLabel label_6 = new JLabel("Gender:");
        label_6.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_6.setBounds(91, 377, 179, 41);
        getContentPane().add(label_6);
        genderTextField = new JTextField();
        genderTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        genderTextField.setBounds(319, 377, 350, 41);
        getContentPane().add(genderTextField);

        JLabel label_7 = new JLabel("Prelim Grade:");
        label_7.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_7.setBounds(460, 656, 159, 41);
        getContentPane().add(label_7);
        prelimGradeTextField = new JTextField();
        prelimGradeTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        prelimGradeTextField.setBounds(635, 656, 350, 41);
        getContentPane().add(prelimGradeTextField);

        JLabel label_8 = new JLabel("Midterm Grade:");
        label_8.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_8.setBounds(460, 708, 159, 41);
        getContentPane().add(label_8);
        midtermGradeTextField = new JTextField();
        midtermGradeTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        midtermGradeTextField.setBounds(635, 718, 350, 41);
        getContentPane().add(midtermGradeTextField);

        JLabel label_9 = new JLabel("Final Grade:");
        label_9.setFont(new Font("Monospaced", Font.BOLD, 15));
        label_9.setBounds(460, 770, 159, 41);
        getContentPane().add(label_9);
        finalGradeTextField = new JTextField();
        finalGradeTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        finalGradeTextField.setBounds(635, 770, 350, 41);
        getContentPane().add(finalGradeTextField);

        // Add buttons for saving, quitting, and continuing
        saveButton = new JButton("Save");
        saveButton.setBounds(1124, 690, 350, 41);
        saveButton.addActionListener(this);
        getContentPane().add(saveButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(1124, 794, 350, 41);
        quitButton.addActionListener(this);
        getContentPane().add(quitButton);

        continueButton = new JButton("Continue");
        continueButton.setBounds(1124, 742, 350, 41);
        continueButton.addActionListener(this);
        getContentPane().add(continueButton);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(StudentRecordManagementProgram.class.getResource("/image/StudentRecord.png")));
        lblNewLabel.setBounds(0, 2, 1484, 983);
        getContentPane().add(lblNewLabel);

        // Initialize the file handling variables
        currentFile = null;
        fileWriter = null;
        fileReader = null;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == saveButton) {
            saveRecord();
        } else if (source == quitButton) {
            quitProgram();
        } else if (source == continueButton) {
            continueInput();
        }
    }

    private void saveRecord() {
        // Get the data from the text fields
        studentNo = studentNoTextField.getText();
        degree = degreeTextField.getText();
        yearLevel = yearLevelTextField.getText();
        firstName = firstNameTextField.getText();
        middleName = middleNameTextField.getText();
        lastName = lastNameTextField.getText();
        gender = genderTextField.getText();
        prelimGrade = Double.parseDouble(prelimGradeTextField.getText());
        midtermGrade = Double.parseDouble(midtermGradeTextField.getText());
        finalGrade = Double.parseDouble(finalGradeTextField.getText());
        finalTermGrade = (prelimGrade + midtermGrade + finalGrade) / 3;

        // Create a new file if one has not been selected yet
        if (currentFile == null) {
            // Ask the user for a file name and create the file
            String fileName = JOptionPane.showInputDialog("Enter a file name:");
            currentFile = new File(fileName);

            try {
                // Open the file for writing
                fileWriter = new FileWriter(currentFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening file for writing.");
                currentFile = null;
                return;
            }
        }

        try {
            // Write the record to the file
            fileWriter.write(studentNo + "," + degree + "," + yearLevel + "," + firstName + "," + middleName + ","
                    + lastName + "," + gender + "," + prelimGrade + "," + midtermGrade + "," + finalGrade + ","
                    + finalTermGrade + "\n");
            fileWriter.flush();
            JOptionPane.showMessageDialog(this, "Record saved to file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing record to file.");
        }
    }

    private void quitProgram() {
        // Close the file if it is open
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error closing file.");
            }
        }

        System.exit(0);
    }

    private void continueInput() {
        // Clear the text fields for a new record
        studentNoTextField.setText("");
        degreeTextField.setText("");
        yearLevelTextField.setText("");
        firstNameTextField.setText("");
        middleNameTextField.setText("");
        lastNameTextField.setText("");
        genderTextField.setText("");
        prelimGradeTextField.setText("");
        midtermGradeTextField.setText("");
        finalGradeTextField.setText("");

        // Ask the user if they want to continue inputting records or quit
        String input = JOptionPane.showInputDialog("Press 'C' to continue inputting records or 'Q' to quit.");
        if (input != null && input.toUpperCase().equals("Q")) {
            quitProgram();
        }
    }

    public static void main(String[] args) {
        // Create and show the GUI
        StudentRecordManagementProgram program = new StudentRecordManagementProgram();
        program.setVisible(true);
    }
}
