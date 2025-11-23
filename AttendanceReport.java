package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class AttendanceReport extends JFrame implements ActionListener {
    JTable table;
    JButton back, refresh;
    DefaultTableModel model;

    AttendanceReport() {
        JLabel heading = new JLabel("Attendance Report");
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setBounds(350, 20, 400, 40);
        add(heading);

        model = new DefaultTableModel();
        model.addColumn("Emp ID");
        model.addColumn("Date");
        model.addColumn("Status");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 100, 700, 400);
        add(scrollPane);

        refresh = new JButton("Refresh");
        refresh.setBounds(250, 550, 150, 40);
        refresh.setBackground(Color.BLACK);
        refresh.setForeground(Color.WHITE);
        refresh.addActionListener(this);
        add(refresh);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        loadData();

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    void loadData() {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM attendance");
            model.setRowCount(0); // clear table
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("empId"),
                        rs.getString("date"),
                        rs.getString("status")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refresh) {
            loadData();
        } else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AttendanceReport();
    }
}

