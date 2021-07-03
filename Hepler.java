/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Thuy Linh
 */
public class Hepler {
    public static boolean checkRong(JTextField tf , String mss){
        if (tf.getText().equals("")){
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    
}
