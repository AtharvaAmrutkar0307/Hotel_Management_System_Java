package hotel.management;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BookFood extends javax.swing.JFrame {
    public BookFood() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        back_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        room = new javax.swing.JTextField();
        item = new javax.swing.JTextField();
        book_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        back_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-go-back-32.png"))); // NOI18N
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Room Number");

        jLabel2.setText("Item Name");

        book_button.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); 
        book_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-tableware-64.png"))); 
        book_button.setText("Book Food");
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back_button))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(room, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(item)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(book_button)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back_button)
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)))
                .addGap(74, 74, 74)
                .addComponent(book_button)
                .addContainerGap(105, Short.MAX_VALUE))
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

    private void book_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_buttonActionPerformed
        // TODO add your handling code here:
        String qroom,qitem;
        qroom=room.getText();
        qitem = item.getText();
        if(qroom.equals("")||qitem.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the details");
            return;
        }
        
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root",Credentials.sqlPassword);
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("USE hotel_management");
            
            ResultSet rs = stmt.executeQuery("select * from room;");
            int f=0,f2=0;
            while(rs.next()){
                String id = rs.getString("id");
                String occupied = rs.getString("occupied");
                if(qroom.equals(id)){
                    f=1;f2=1;
                    if(occupied.equals("0")){
                    JOptionPane.showMessageDialog(null, "Room is Vacant");
                    f=0;
                    }
                    break;
                }
            }
            if(f2==0) 
                    JOptionPane.showMessageDialog(null, "Room no. not available");
            rs.close();
            
            ResultSet rse = stmt.executeQuery("select * from restitem;");
            int f3=0;
            while(rse.next()){
                String temp_name = rse.getString("item_name");
                if(qitem.equals(temp_name)){
                    f3=1;
                    break;
                }
            }
            if(f3==0) 
                    JOptionPane.showMessageDialog(null, "Food Item not available");
            
            if(f==1&&f3==1){
                stmt.executeUpdate("insert into bookfood values("+qroom+",'"+qitem+"');");
                ResultSet rs2 = stmt.executeQuery("select * from restitem where item_name='"+qitem+"';");
                rs2.next();
                String price = rs2.getString("item_price");
                int pr = Integer.parseInt(price);
         
                rs2 = stmt.executeQuery("select * from bookings where room="+qroom+" and checkout is null;");
                System.out.println("fck");
                rs2.next();
                int prices = Integer.parseInt(rs2.getString("amount"));
                String id = rs2.getString("id");
                prices+=pr;
                System.out.println("fck");
                stmt.executeUpdate("update bookings set amount="+prices+" where id="+id+";");
                
                JOptionPane.showMessageDialog(null, "Food Booked");
                new RestMenu().setVisible(true);
                this.setVisible(false);
            }
            else{
                room.setText("");
                item.setText("");
            }
            
            
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            System.out.println("Esception: "+e);
        }
    }

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new RestMenu().setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookFood().setVisible(true);
            }
        });
    }

    private javax.swing.JButton back_button;
    private javax.swing.JButton book_button;
    private javax.swing.JTextField item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField room;
}