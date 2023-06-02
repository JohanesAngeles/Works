import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VotingSystem extends JFrame {
    private JLabel titleLabel;
    private JLabel candidateLabel;
    private JRadioButton candidate1RadioButton;
    private JRadioButton candidate2RadioButton;
    private JButton submitButton;
    private int candidate1Votes;
    private int candidate2Votes;

    public VotingSystem() {
    	getContentPane().setBackground(Color.PINK);
        // Set up the window
        setTitle("Voting System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(690, 404);
        getContentPane().setLayout(null);

        // Set up the title label
        titleLabel = new JLabel("Please vote for your preferred candidate:");
        titleLabel.setBounds(16, 0, 636, 41);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        getContentPane().add(titleLabel);
        ButtonGroup candidateButtonGroup = new ButtonGroup();
        candidate1RadioButton = new JRadioButton("Candidate 1");
        candidate1RadioButton.setBounds(10, 106, 642, 36);
        getContentPane().add(candidate1RadioButton);
        candidate1RadioButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
        candidateButtonGroup.add(candidate1RadioButton);
        candidate2RadioButton = new JRadioButton("Candidate 2");
        candidate2RadioButton.setBounds(10, 162, 642, 36);
        getContentPane().add(candidate2RadioButton);
        candidate2RadioButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
        candidateButtonGroup.add(candidate2RadioButton);
        
                // Set up the candidate label and radio buttons
                candidateLabel = new JLabel("Candidates:");
                candidateLabel.setBounds(16, 52, 193, 19);
                getContentPane().add(candidateLabel);
                candidateLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
                
                        // Set up the submit button
                        submitButton = new JButton("Submit");
                        submitButton.setBounds(273, 288, 140, 33);
                        getContentPane().add(submitButton);
                        submitButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
                        submitButton.addActionListener(new SubmitButtonListener());

        // Set up the initial vote counts
        candidate1Votes = 0;
        candidate2Votes = 0;
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get the selected candidate
            String selectedCandidate;
            if (candidate1RadioButton.isSelected()) {
                selectedCandidate = "Candidate 1";
                candidate1Votes++;
            } else if (candidate2RadioButton.isSelected()) {
                selectedCandidate = "Candidate 2";
                candidate2Votes++;
            } else {
                JOptionPane.showMessageDialog(VotingSystem.this, "Please select a candidate.");
                return;
            }

            // Display the selected candidate and the current vote counts
            JOptionPane.showMessageDialog(VotingSystem.this, "You voted for " + selectedCandidate + ".\n\nCurrent Vote Counts:\nCandidate 1: " + candidate1Votes + "\nCandidate 2: " + candidate2Votes);
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.setVisible(true);
    }
}

