package hotel.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RoomBooking extends javax.swing.JFrame {
    public RoomBooking() {
        initComponents();
    }
    private JFrame frame;
    int f=0;
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logout_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        home_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        namef = new javax.swing.JTextField();
        adhaarf = new javax.swing.JTextField();
        contactf = new javax.swing.JTextField();
        addressf = new javax.swing.JTextField();
        nationf = new javax.swing.JTextField();
        roomf = new javax.swing.JTextField();
        inhabf = new javax.swing.JTextField();
        check_button = new javax.swing.JButton();
        book_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        logout_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); 
        logout_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-exit-32.png"))); 
        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        back_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); 
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-go-back-32.png"))); 
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        home_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); 
        home_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-home-page-32.png")));
        home_button.setText("Home");
        home_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer Name :");

        jLabel2.setText("Adhaar Number: ");

        jLabel3.setText("Contact Number:");

        jLabel4.setText("Contact Address :");

        jLabel5.setText("Nationality :");

        jLabel6.setText("Number of Inhabitants :");

        jLabel7.setText("Room Number :");

        check_button.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); 
        check_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-id-32.png"))); 
        check_button.setText("Check");
        check_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_buttonActionPerformed(evt);
            }
        });

        book_button.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); 
        book_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-bed-64.png"))); 
        book_button.setText("Book");
        book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(home_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back_button)
                .addGap(28, 28, 28)
                .addComponent(logout_button))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namef, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(adhaarf)
                    .addComponent(contactf)
                    .addComponent(addressf)
                    .addComponent(nationf)
                    .addComponent(roomf)
                    .addComponent(inhabf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(check_button)
                .addGap(98, 98, 98))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(book_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logout_button)
                        .addComponent(back_button))
                    .addComponent(home_button))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(namef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(adhaarf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_button))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(contactf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addressf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nationf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(inhabf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7))
                    .addComponent(roomf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(book_button)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
        new RoomList().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_back_buttonActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void home_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_buttonActionPerformed
        // TODO add your handling code here:
        new MainScreen().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_home_buttonActionPerformed
    
    private void book_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_buttonActionPerformed
        // TODO add your handling code here:
        if(f==0){
            JOptionPane.showMessageDialog(frame, "Please click the check button");
            return;
        }
        String name = namef.getText();
        String contact = contactf.getText();
        String address = addressf.getText();
        String nation = nationf.getText();
        String aadhar = adhaarf.getText();
        String inhab = inhabf.getText();
        String room = roomf.getText();
        if(name.equals("")||contact.equals("")||address.equals("")||nation.equals("")||aadhar.equals("")||inhab.equals("")||room.equals("")){
            JOptionPane.showMessageDialog(frame, "Please fill the details");
            return;
        }
        int l =contact.length();
        for(int i=0;i<l;i++){
            if(contact.charAt(i)>'9'||contact.charAt(i)<'0'||l!=10){
                JOptionPane.showMessageDialog(frame, "Invalid contact");
                return;
            }
        }
        Date date = new Date();
        long time = date.getTime();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root","Msd??007");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("use hotelsystem;");
            ResultSet rs = stmt.executeQuery("select * from room where id="+room+";");
            rs.next();
            int max = Integer.parseInt(rs.getString("capacity"));
            int occ = Integer.parseInt(rs.getString("occupied"));
            if(occ==1){
                JOptionPane.showMessageDialog(frame, "Room is already occupied");
                return;
            }
            int inhabs = Integer.parseInt(inhab);
            if(inhabs>max){
                JOptionPane.showMessageDialog(frame, "Person limit exceeding \nMax "+max);
                return;
            }
            if(f==1){
                stmt.executeUpdate("insert into customer values('"+aadhar+"','"+name+"','"+contact+"','"+address+"','"+nation+"');");
            }
            stmt.executeUpdate("insert into bookings(aadhar,number_of_persons,room,checkin) values('"+aadhar+"',"+inhab+","+room+",'"+time+"');");
            stmt.executeUpdate("update room set occupied=1 where id="+room+";");
            JOptionPane.showMessageDialog(frame, "Room Booked");
            new CustomerList().setVisible(true);
            this.setVisible(false);
            con.close();
            stmt.close();           
        }
        catch(Exception e)
        {
            System.out.println("Esception: "+e);
        }
        
    }//GEN-LAST:event_book_buttonActionPerformed

    private void check_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_buttonActionPerformed
        // TODO add your handling code here:
        String aadhar = adhaarf.getText();
        int l = aadhar.length();
        if(l!=12){
            JOptionPane.showMessageDialog(frame, "Aadhaar number incorrect");
            return;
        }
        for(int i=0;i<l;i++){
            if(aadhar.charAt(i)>'9'||aadhar.charAt(i)<'0'){
                JOptionPane.showMessageDialog(frame, "Invalid Aadhar");
                return;
            }
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root","Msd??007");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("use hotelsystem;");
            namef.setText("");
            JOptionPane.showMessageDialog(frame, "Aadhar number verified");
            ResultSet rs=stmt.executeQuery("select * from customer where aadhar ='"+aadhar+"';");
            rs.next();
            String name=rs.getString("name");
            String contact=rs.getString("contact");
            String address=rs.getString("address");
            String nation = rs.getString("nation");
            namef.setText(name);
            contactf.setText(contact);
            addressf.setText(address);
            nationf.setText(nation);
            rs.close();  
            con.close();
            stmt.close();           
        }
        catch(Exception e)
        {
            System.out.println("Esception: "+e);
        }
        if(namef.getText().equals(""))
            f=1;
        else
            f=2;
    }//GEN-LAST:event_check_buttonActionPerformed

    void setTextField(String room){
        roomf.setText(room);
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
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomBooking().setVisible(true);
            }
        });
    }
    
    private javax.swing.JTextField addressf;
    private javax.swing.JTextField adhaarf;
    private javax.swing.JButton back_button;
    private javax.swing.JButton book_button;
    private javax.swing.JButton check_button;
    private javax.swing.JTextField contactf;
    private javax.swing.JButton home_button;
    private javax.swing.JTextField inhabf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout_button;
    private javax.swing.JTextField namef;
    private javax.swing.JTextField nationf;
    private javax.swing.JTextField roomf;
    // End of variables declaration//GEN-END:variables
}