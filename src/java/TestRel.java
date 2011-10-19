
import br.com.hibernate.entities.LabDetalheRequisicao;
import br.com.hibernate.entities.LabRequisicao;
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;
import java.util.List;

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
//        LabUsuario user = OracleHelper.getLabUsuario("EROS", "DAFTPUNK");
        LabRequisicao lr = (LabRequisicao)OracleHelper.getObject(LabRequisicao.class, new Long(1139365702));
//        List list = OracleHelper.getListOfObjectByKeyEq(LabDetalheRequisicao.class, "reqStCodigo", "1139365702", "reqStCodigo", true);
        
//        System.out.println(user.getUsuStNome());
    }
    
}
