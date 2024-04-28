import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop {
    private ArrayList<Gadget> gadgets;
    private JFrame frame;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField,
            phoneNumberField, durationField, downloadSizeField, displayNumberField;

    public GadgetShop() {
        gadgets = new ArrayList<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));

        addLabelAndTextField(panel, "Model:", modelField = new JTextField());
        addLabelAndTextField(panel, "Price (£):", priceField = new JTextField());
        addLabelAndTextField(panel, "Weight (grams):", weightField = new JTextField());
        addLabelAndTextField(panel, "Size:", sizeField = new JTextField());
        addLabelAndTextField(panel, "Initial Credit (Mobile):", creditField = new JTextField());
        addLabelAndTextField(panel, "Initial Memory (MP3):", memoryField = new JTextField());
        addLabelAndTextField(panel, "Phone Number:", phoneNumberField = new JTextField());
        addLabelAndTextField(panel, "Duration (minutes):", durationField = new JTextField());
        addLabelAndTextField(panel, "Download Size (MB):", downloadSizeField = new JTextField());
        addLabelAndTextField(panel, "Display Number:", displayNumberField = new JTextField());

        addButton(panel, "Add Mobile", e -> addMobile());
        addButton(panel, "Add MP3", e -> addMP3());
        addButton(panel, "Clear", e -> clearTextFields());
        addButton(panel, "Display All", e -> displayAll());
        addButton(panel, "Make a Call", e -> makeCall());
        addButton(panel, "Download Music", e -> downloadMusic());

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void addLabelAndTextField(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(textField);
    }

    private void addButton(JPanel panel, String buttonText, ActionListener actionListener) {
        JButton button = new JButton(buttonText);
        button.addActionListener(actionListener);
        panel.add(button);
    }

    private void addMobile() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(creditField.getText());
            gadgets.add(new Mobile(model, price, weight, size, credit));
            clearTextFields();
            JOptionPane.showMessageDialog(frame, "Mobile added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numeric values.");
        }
    }

    private void addMP3() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int memory = Integer.parseInt(memoryField.getText());
            gadgets.add(new MP3(model, price, weight, size, memory));
            clearTextFields();
            JOptionPane.showMessageDialog(frame, "MP3 player added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numeric values.");
        }
    }

    private void clearTextFields() {
        Component[] components = frame.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
    }

    private void displayAll() {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < gadgets.size(); i++) {
            display.append("Display Number: ").append(i).append("\n");
            display.append(gadgets.get(i).toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(frame, display.toString());
    }

    private void makeCall() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                Mobile mobile = (Mobile) gadgets.get(displayNumber);
                String phoneNumber = phoneNumberField.getText();
                int duration = Integer.parseInt(durationField.getText());
                mobile.makeCall(phoneNumber, duration);
                JOptionPane.showMessageDialog(frame, "calling number.");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter a valid index.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numeric values.");
        }
    }

    private void downloadMusic() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                MP3 mp3 = (MP3) gadgets.get(displayNumber);
                int downloadSize = Integer.parseInt(downloadSizeField.getText());
                mp3.downloadMusic(downloadSize);
                JOptionPane.showMessageDialog(frame, "downloading music.");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numeric values.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "exception");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GadgetShop();
            }
        });
    }
}
