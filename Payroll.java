package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Payroll extends JFrame implements ActionListener {
    JTextField tfEmpID, tfBasic, tfHRA, tfDA, tfTax, tfMonth;
    JButton btnCalc, btnSave;
    JLabel lblNet;

    Payroll() {
        getContentPane().setBackground(new Color(200, 255, 200));
        setLayout(null);

        JLabel heading = new JLabel("Payroll Management");
        heading.setBounds(320, 30, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel lbl1 = new JLabel("Employee ID:");
        lbl1.setBounds(150, 100, 150, 30);
        add(lbl1);
        tfEmpID = new JTextField();
        tfEmpID.setBounds(300, 100, 150, 30);
        add(tfEmpID);

        JLabel lbl2 = new JLabel("Basic Salary:");
        lbl2.setBounds(150, 150, 150, 30);
        add(lbl2);
        tfBasic = new JTextField();
        tfBasic.setBounds(300, 150, 150, 30);
        add(tfBasic);

        JLabel lbl3 = new JLabel("HRA (%):");
        lbl3.setBounds(150, 200, 150, 30);
        add(lbl3);
        tfHRA = new JTextField("10");
        tfHRA.setBounds(300, 200, 150, 30);
        add(tfHRA);

        JLabel lbl4 = new JLabel("DA (%):");
        lbl4.setBounds(150, 250, 150, 30);
        add(lbl4);
        tfDA = new JTextField("8");
        tfDA.setBounds(300, 250, 150, 30);
        add(tfDA);

        JLabel lbl5 = new JLabel("Tax (%):");
        lbl5.setBounds(150, 300, 150, 30);
        add(lbl5);
        tfTax = new JTextField("5");
        tfTax.setBounds(300, 300, 150, 30);
        add(tfTax);

        JLabel lbl6 = new JLabel("Month:");
        lbl6.setBounds(150, 350, 150, 30);
        add(lbl6);
        tfMonth = new JTextField();
        tfMonth.setBounds(300, 350, 150, 30);
        add(tfMonth);

        JLabel lbl7 = new JLabel("Net Salary:");
        lbl7.setBounds(150, 400, 150, 30);
        add(lbl7);
        lblNet = new JLabel();
        lblNet.setBounds(300, 400, 150, 30);
        add(lblNet);

        btnCalc = new JButton("Calculate");
        btnCalc.setBounds(200, 470, 120, 40);
        btnCalc.addActionListener(this);
        add(btnCalc);

        btnSave = new JButton("Save");
        btnSave.setBounds(350, 470, 120, 40);
        btnSave.addActionListener(this);
        add(btnSave);

        setSize(700, 600);
        setLocation(400, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalc) {
            double basic = Double.parseDouble(tfBasic.getText());
            double hra = Double.parseDouble(tfHRA.getText());
            double da = Double.parseDouble(tfDA.getText());
            double tax = Double.parseDouble(tfTax.getText());

            double net = basic + (basic * hra / 100) + (basic * da / 100) - (basic * tax / 100);
            lblNet.setText(String.valueOf(net));
        }
        else if (e.getSource() == btnSave) {
            try {
                conn c = new conn();
                String query = "insert into payroll values('" + tfEmpID.getText() + "', '" + tfBasic.getText() + "', '" + tfHRA.getText() + "', '" + tfDA.getText() + "', '" + tfTax.getText() + "', '" + lblNet.getText() + "', '" + tfMonth.getText() + "')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Payroll data saved successfully!");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Payroll();
    }
}

