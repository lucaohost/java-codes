/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeejbstateless;

import br.ifrs.ejb.IConta;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Neiva
 */
public class TesteEJBStateless {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialHost", "localhost");
            props.put("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(java.lang.System.getProperties());
            IConta ejb = (IConta) ctx.lookup("br.ifrs.ejb.IConta");
            ejb.depositar(865.00f);
            float total = ejb.debitar(65.00f);
            System.out.println("Total após transações: " + total);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
