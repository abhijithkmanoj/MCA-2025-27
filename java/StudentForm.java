import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentForm extends JFrame {

    JTextField nameField, classField, rollField, addressField, phoneField;
    JTextArea outputArea;

    Connection conn;

    public StudentForm() {

        setTitle("Student Database");
        setSize(700, 500);
        setLayout(new BorderLayout(10,10));

        // ===== FORM PANEL =====
        JPanel formPanel = new JPanel(new GridLayout(5,2,10,10));

        nameField = new JTextField();
        classField = new JTextField();
        rollField = new JTextField();
        addressField = new JTextField();
        phoneField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Class:"));
        formPanel.add(classField);

        formPanel.add(new JLabel("Roll No:"));
        formPanel.add(rollField);

        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);

        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel();

        JButton insertBtn = new JButton("Insert");
        JButton deleteBtn = new JButton("Delete");
        JButton displayBtn = new JButton("Display All");

        buttonPanel.add(insertBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(displayBtn);

        // ===== OUTPUT AREA =====
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(650, 200));

        // ===== ADD TO FRAME =====
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // DB connection
        connectDB();

        // Button actions
        insertBtn.addActionListener(e -> insertRecord());
        deleteBtn.addActionListener(e -> deleteRecord());
        displayBtn.addActionListener(e -> displayRecords());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void connectDB() {
        conn = OracleConnect.getConnection();
    
        if (conn != null) {
            outputArea.setText("Connected to Database\n");
        } else {
            outputArea.setText("Connection Failed\n");
        }
    }

    void insertRecord() {
        try {
            String sql = "INSERT INTO student1 VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nameField.getText());
            ps.setString(2, classField.getText());
            ps.setInt(3, Integer.parseInt(rollField.getText()));
            ps.setString(4, addressField.getText());
            ps.setString(5, phoneField.getText());

            ps.executeUpdate();

            outputArea.setText("✔ Record Inserted\n");

        } catch (Exception e) {
            outputArea.setText("❌ Insert Error\n");
            e.printStackTrace();
        }
    }

    void deleteRecord() {
        try {
            String sql = "DELETE FROM student1 WHERE rollno=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(rollField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0)
                outputArea.setText("✔ Record Deleted\n");
            else
                outputArea.setText("❌ Record Not Found\n");

        } catch (Exception e) {
            outputArea.setText("❌ Delete Error\n");
            e.printStackTrace();
        }
    }

    void displayRecords() {
        try {
            String sql = "SELECT * FROM student1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            outputArea.setText("");

            outputArea.append("NAME\t\tCLASS\tROLL\tADDRESS\t\tPHONE\n");
            outputArea.append("------------------------------------------------------------\n");

            while (rs.next()) {
                outputArea.append(
                    rs.getString("name") + "\t" +
                    rs.getString("class") + "\t" +
                    rs.getInt("rollno") + "\t" +
                    rs.getString("address") + "\t" +
                    rs.getString("phone") + "\n"
                );
            }

        } catch (Exception e) {
            outputArea.setText("❌ Display Error\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}