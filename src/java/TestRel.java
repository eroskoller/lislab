
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros
 */
public class TestRel {
    
    public static void main(String... agrs){
        LabUsuario user = OracleHelper.getLabUsuario("EROS", "DAFTPUNK");
        System.out.println(user.getUsuStNome());
    }
    
}
