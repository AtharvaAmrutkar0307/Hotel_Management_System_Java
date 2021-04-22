package hotel.management;

import javax.swing.*;

public class HotelManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }   
}
