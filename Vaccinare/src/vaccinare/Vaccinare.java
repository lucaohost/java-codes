/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare;

import vaccinare.view.JFrameLogin;
import vaccinare.view.JFrameMain;

/**
 *
 * @author lucas.270948
 */
public class Vaccinare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Verificar o Login antes
        JFrameLogin jFLogin = new JFrameLogin();
        jFLogin.setLocationRelativeTo(null);
        jFLogin.setVisible(true);
    }
    
}
