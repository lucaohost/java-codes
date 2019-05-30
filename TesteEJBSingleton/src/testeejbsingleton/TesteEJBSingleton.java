/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeejbsingleton;

import br.ifrs.ejb.IChat;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Neiva
 */
public class TesteEJBSingleton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialHost", "localhost");
            props.put("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(java.lang.System.getProperties());
            IChat ejb = (IChat) ctx.lookup("br.ifrs.ejb.IChat");
            ejb.criarSala("Bate papo UOL");
            ejb.criarSala("Conversa em grupo MSN");
            System.out.println(ejb.listaSalas());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
