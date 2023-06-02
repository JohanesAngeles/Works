import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoffeeShopOrderSystem extends JFrame implements ActionListener {
    private JLabel coffeeLabel;
    private JComboBox coffeeComboBox;
    private JLabel sizeLabel;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JLabel pastriesLabel;
    private JComboBox pastriesComboBox;
    private JButton orderButton;
    private JTextArea receiptTextArea;

    private String[] coffeeMenu = {"Cappuccino", "Latte", "Americano", "Espresso"};
    private double[] coffeePrices = {150, 150, 130, 130};
    private String[] pastriesMenu = {"Croissant", "Danish", "Muffin", "Donut"};
    private double[] pastriesPrices = {150, 150, 120, 80};
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    public CoffeeShopOrderSystem() {
    	getContentPane().setBackground(Color.WHITE);
        // Set up the window
        setTitle("Coffee Shop Order System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        coffeeLabel = new JLabel("Coffee:");
        coffeeLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        coffeeLabel.setBounds(821, 147, 76, 50);
        coffeeComboBox = new JComboBox(coffeeMenu);
        coffeeComboBox.setBounds(972, 160, 360, 23);
        sizeLabel = new JLabel("Size:");
        sizeLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        sizeLabel.setBounds(855, 194, 76, 23);
        smallRadioButton = new JRadioButton("Small");
        smallRadioButton.setBackground(Color.WHITE);
        smallRadioButton.setBounds(972, 198, 61, 27);
        mediumRadioButton = new JRadioButton("Medium");
        mediumRadioButton.setBackground(Color.WHITE);
        mediumRadioButton.setBounds(1127, 196, 76, 27);
        largeRadioButton = new JRadioButton("Large");
        largeRadioButton.setBackground(Color.WHITE);
        largeRadioButton.setBounds(1271, 193, 61, 32);
        ButtonGroup sizeButtonGroup = new ButtonGroup();
        sizeButtonGroup.add(smallRadioButton);
        sizeButtonGroup.add(mediumRadioButton);
        sizeButtonGroup.add(largeRadioButton);
        pastriesLabel = new JLabel("Pastries:");
        pastriesLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pastriesLabel.setBounds(821, 274, 76, 27);
        pastriesComboBox = new JComboBox(pastriesMenu);
        pastriesComboBox.setBounds(972, 282, 360, 20);
        orderButton = new JButton("");
        orderButton.setIcon(new ImageIcon(CoffeeShopOrderSystem.class.getResource("/image/orderbutton.png")));
        orderButton.setBounds(834, 375, 498, 44);
        orderButton.addActionListener(this);
        receiptTextArea = new JTextArea(10, 30);
        receiptTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        receiptTextArea.setBounds(821, 599, 511, 262);
        getContentPane().setLayout(null);
        getContentPane().add(coffeeLabel);
        getContentPane().add(coffeeComboBox);
        getContentPane().add(sizeLabel);
        getContentPane().add(smallRadioButton);
        getContentPane().add(mediumRadioButton);
        getContentPane().add(largeRadioButton);
        getContentPane().add(pastriesLabel);
        getContentPane().add(pastriesComboBox);
        getContentPane().add(orderButton);
        getContentPane().add(receiptTextArea);
        
        JLabel Header = new JLabel("New label");
        Header.setIcon(new ImageIcon(CoffeeShopOrderSystem.class.getResource("/image/HeaderCoffee.png")));
        Header.setBounds(-1, 0, 1425, 111);
        getContentPane().add(Header);
        
        JLabel Menu = new JLabel("");
        Menu.setIcon(new ImageIcon(CoffeeShopOrderSystem.class.getResource("/image/Menu.png")));
        Menu.setBounds(16, 133, 759, 841);
        getContentPane().add(Menu);
        
        JLabel orderbg = new JLabel("");
        orderbg.setIcon(new ImageIcon(CoffeeShopOrderSystem.class.getResource("/image/orderbg.png")));
        orderbg.setBounds(793, 133, 574, 339);
        getContentPane().add(orderbg);
        
        lblNewLabel = new JLabel("Receipt");
        lblNewLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        lblNewLabel.setBounds(821, 557, 110, 31);
        getContentPane().add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(CoffeeShopOrderSystem.class.getResource("/image/orderbg.png")));
        lblNewLabel_1.setBounds(793, 544, 574, 339);
        getContentPane().add(lblNewLabel_1);

        // Set the window size and show it
        setSize(1440, 1024);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            // Get the selected coffee and pastry items
            String selectedCoffee = (String) coffeeComboBox.getSelectedItem();
            String selectedPastry = (String) pastriesComboBox.getSelectedItem();

            // Get the selected coffee size and price
            double coffeePrice = 0.0;
            if (smallRadioButton.isSelected()) {
                coffeePrice = coffeePrices[coffeeComboBox.getSelectedIndex()] * 0.8;
            } else if (mediumRadioButton.isSelected()) {
                coffeePrice = coffeePrices[coffeeComboBox.getSelectedIndex()] * 1.0;
            } else if (largeRadioButton.isSelected()) {
                coffeePrice = coffeePrices[coffeeComboBox.getSelectedIndex()] * 1.2;
            }

            // Get the selected pastry price
            double pastryPrice = pastriesPrices[pastriesComboBox.getSelectedIndex()];

            // Calculate the total price
            double totalPrice = coffeePrice + pastryPrice;

            // Generate the receipt
            String receipt = "Coffee Shop Order System\n";
            receipt += "==========================\n";
            receipt += "Coffee: " + selectedCoffee + " (" + getSelectedSize() + ")\n";
            receipt += "Pastry: " + selectedPastry + "\n";
            receipt += "Total price: ₱" + String.format("%.2f", totalPrice) + "\n";
            
            // Display the receipt in the text area
            receiptTextArea.setText(receipt);
        }
    }

    private String getSelectedSize() {
        if (smallRadioButton.isSelected()) {
            return "Small";
        } else if (mediumRadioButton.isSelected()) {
            return "Medium";
        } else if (largeRadioButton.isSelected()) {
            return "Large";
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        new CoffeeShopOrderSystem();
    }
}

