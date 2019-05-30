/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeejbstateful;

import br.ifrs.ejb.ICarrinhodeCompras;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Neiva
 */
public class TesteEJBStateful {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialHost", "localhost");
            props.put("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(java.lang.System.getProperties());
            ICarrinhodeCompras ejb = (ICarrinhodeCompras) ctx.lookup("br.ifrs.ejb.ICarrinhodeCompras");
            ejb.adicionarItem("Mouse Optico");
            System.out.println("Itens no carrinho: " + ejb.getItens());
            ejb.removerItem("Mouse Optico");
            System.out.println("Itens no carrinho: "  + ejb.getItens());
            ejb.adicionarItem("Mouse Optico");
            ejb.remover();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
