package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class Attendance extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JComboBox<String> statusBox;
    JButton submit, back;

    Attendance() {
        JLabel heading = new JLabel("Mark Employee Attendance");
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setBounds(250, 30, 400, 40);
        add(heading);

        JLabel labelEmp = new JLabel("Select Employee ID:");
        labelEmp.setBounds(100, 120, 200, 30);
        labelEmp.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelEmp);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(300, 120, 150, 30);
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT empID FROM employee");
            while (rs.next()) {
                choiceEMPID.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelStatus = new JLabel("Status:");
        labelStatus.setBounds(100, 180, 200, 30);
        labelStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelStatus);

        String[] options = {"Present", "Absent"};
        statusBox = new JComboBox<>(options);
        statusBox.setBounds(300, 180, 150, 30);
        add(statusBox);

        submit = new JButton("Submit");
        submit.setBounds(200, 280, 100, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(350, 280, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(600, 400);
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String empId = choiceEMPID.getSelectedItem();
            String status = (String) statusBox.getSelectedItem();
            String date = LocalDate.now().toString(); // current date

            try {
                conn c = new conn();
                String query = "INSERT INTO attendance (empId, date, status) VALUES ('" + empId + "', '" + date + "', '" + status + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Attendance Marked Successfully");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Attendance();
    }
}

