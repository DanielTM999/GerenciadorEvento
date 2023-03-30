package controller;

import javax.swing.JOptionPane;

public class Controller extends Crud implements Funct {

    @Override
    public boolean VerifySenha(String pass1, String pass2) {
        try {
            if ((pass1.isEmpty() || pass1.isBlank()) || (pass2.isEmpty() || pass2.isBlank())) {
                return false;
            } else {
                if (pass1.equals(pass2)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
