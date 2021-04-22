package hotel.management;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        connectSQL();
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        login_button = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        login_button.setFont(new java.awt.Font("Stencil", 1, 18)); 
        login_button.setText("login");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Kristen ITC", 1, 18)); 
        jLabel1.setText("Username: ");

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 18)); 
        jLabel2.setText("password:");

        jLabel3.setFont(new java.awt.Font("Vivaldi", 3, 48)); 
        jLabel3.setText("      TTF Hotel.");
        jLabel3.setIconTextGap(5);

        jLabel4.setFont(new java.awt.Font("Museo Sans For Dell", 1, 24)); 
        jLabel4.setText("Employee login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(login_button)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(password))))
                .addGap(348, 348, 348))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addComponent(login_button)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    private JFrame frame;
    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String user,pass;
        user = username.getText();
        pass = new String(password.getPassword());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/hotel_management","root","Msd??007");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("USE hotel_management");
            ResultSet rs = stmt.executeQuery("select * from staff;");
            int f=0;
            while(rs.next()){
                String usr = rs.getString("username");
                String pwd = rs.getString("password");
                if(user.equals(usr) && pass.equals(pwd)){
                    f=1;
                    break;
                }
            }
            rs.close();
            if(f==1){
                new MainScreen().setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(frame, "Invalid user id or Password");
                username.setText("");
                password.setText("");
            }
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            System.out.println("Esception: "+e);
        }
        
    }

    
    private void connectSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "Msd??007");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS hotelsystem;");
            stmt.executeUpdate("USE hotel_management");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS staff (id int NOT NULL PRIMARY KEY auto_increment, name varchar(20) NOT NULL, contact varchar(20) NOT NULL, aadhar  varchar(20) NOT NULL, username  varchar(20) NOT NULL UNIQUE, password  varchar(20) NOT NULL, work  varchar(20) NOT NULL);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS customer (aadhar  varchar(20) PRIMARY KEY, name varchar(20) NOT NULL, contact varchar(20) NOT NULL,address varchar(30),nation varchar(30) );");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS bookings (id int primary key auto_increment, aadhar  varchar(20) not null, number_of_persons int NOT NULL, room int NOT NULL,checkin varchar(30) not null,checkout varchar(30),amount int default 0 );");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS room (id int NOT NULL PRIMARY KEY, beds int NOT NULL, capacity int NOT NULL, price int NOT NULL, occupied int NOT NULL );");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS restitem (item_name varchar(20) NOT NULL, item_price varchar(20) NOT NULL);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS bookfood (room_id int NOT NULL,item_name varchar(20) NOT NULL);");
            ResultSet rs = stmt.executeQuery("select COUNT(*) from staff;");
            rs.next();
            String count = rs.getString("COUNT(*)");	
            if(count.equals("0")){
                stmt.executeUpdate("INSERT into staff(name,contact,aadhar,username,password,work) values('admin','0','0','admin','1234','admin');");
            }
            rs = stmt.executeQuery("select COUNT(*) from room;");
            rs.next();
            count = rs.getString("COUNT(*)");
            if(count.equals("0")){
                stmt.executeUpdate("INSERT into room values(101,1,1,500,0);");
                stmt.executeUpdate("INSERT into room values(102,2,2,900,0);");
                stmt.executeUpdate("INSERT into room values(103,1,2,800,0);");
                stmt.executeUpdate("INSERT into room values(104,2,4,1600,0);");
                stmt.executeUpdate("INSERT into room values(201,1,1,800,0);");
                stmt.executeUpdate("INSERT into room values(202,1,2,1500,0);");
                stmt.executeUpdate("INSERT into room values(203,3,6,2500,0);");
                stmt.executeUpdate("INSERT into room values(204,4,4,3500,0);");
                stmt.executeUpdate("INSERT into room values(301,2,3,1600,0);");
                stmt.executeUpdate("INSERT into room values(302,2,2,2000,0);");
                stmt.executeUpdate("INSERT into room values(303,5,6,4000,0);");
                stmt.executeUpdate("INSERT into room values(304,4,6,4800,0);");
            }
            
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Exception" + e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_button;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
}