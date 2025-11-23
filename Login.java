package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login() {
        // Frame setup
        setTitle("Employee Management System - Login");
        setSize(800, 450);
        setLocationRelativeTo(null); // center
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for login form
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(new Color(255, 255, 255, 230));
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
        add(panel);

        // Username
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(20, 40, 80, 25);
        panel.add(userLabel);

        tusername = new JTextField();
        tusername.setBounds(110, 40, 160, 25);
        panel.add(tusername);

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(20, 90, 80, 25);
        panel.add(passLabel);

        tpassword = new JPasswordField();
        tpassword.setBounds(110, 90, 160, 25);
        panel.add(tpassword);

        // Login button
        login = new JButton("LOGIN");
        login.setBounds(50, 150, 200, 40);
        login.setBackground(new Color(0, 123, 255));
        login.setForeground(Color.white);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setFocusPainted(false);
        panel.add(login);
        login.addActionListener(this);

        // Hover effect
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setBackground(new Color(0, 90, 200));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setBackground(new Color(0, 123, 255));
            }
        });

        // Back button
        back = new JButton("BACK");
        back.setBounds(50, 210, 200, 40);
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setFocusPainted(false);
        panel.add(back);
        back.addActionListener(this);

        // Background image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/LoginB.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        JLabel bgLabel = new JLabel(new ImageIcon(bgImg));
        bgLabel.setBounds(400, 0, 500, 450);
        add(bgLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {

            try{
                String username=tusername.getText();
                String password=tpassword.getText();
                conn conn=new conn();
                String query="Select * from login where username='"+username+"' and password='"+password+"' ";
                ResultSet resultSet=conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }
                else{
                    JOptionPane.showMessageDialog( null, "Invalid username or password");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
            /*String user = tusername.getText().trim();
            String pass = new String(tpassword.getPassword()).trim();

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username and password");
                return;
            }

            try {
                // Load JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connect to database
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ems", "root", "Srishti@22");

                // Prepare query
                PreparedStatement pst = conn.prepareStatement(
                        "SELECT * FROM users WHERE username=? AND password=?");
                pst.setString(1, user);
                pst.setString(2, pass);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }

                rs.close();
                pst.close();
                conn.close();

            } catch (ClassNotFoundException cnf) {
                JOptionPane.showMessageDialog(this, "JDBC Driver not found: " + cnf.getMessage());
            } catch (SQLException sq) {
                JOptionPane.showMessageDialog(this, "Database Error: " + sq.getMessage());
                sq.printStackTrace();
            }*/

        } else if (e.getSource() == back) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
