
import br.com.hibernate.entities.LabOrigem;
import br.com.hibernate.entities.LabSetor;
import br.com.hibernate.utils.OracleHelper;
import java.io.File;
import java.util.ArrayList;
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
//        LabRequisicao lr = (LabRequisicao)OracleHelper.getObject(LabRequisicao.class, new Long(1139365702));
//        List list = OracleHelper.getListOfObjectByKeyEq(LabDetalheRequisicao.class, "reqStCodigo", "1139365702", "reqStCodigo", true);
//        List list = OracleHelper.getListOfObjectByKeyEq(LabRequisicao.class, "reqStCodigo", "1139365702", "reqStCodigo", true);
        
        
//        System.out.println(new Double(25).intValue());
//        System.out.println("AMI(EA), BIL(EA), CRE(EA), GLI(EA), HEM(EA), LIP(EA), MB(EA), MIOG(CO), POT(EA), PTF(EA), SOD(EA), TGO(EA), TGP(EA), TP(EA), TRO(EA), TTPA(EA), URE(EA), URI(EA)".length());
//        System.out.println(user.getUsuStNome());
        
//        float f = 1.2f;
//        System.out.println(Math.ceil(f));
        
//                LabSetor obj = (LabSetor) OracleHelper.getObjectByKey(LabSetor.class, "setStCodigo", "test");
        
//        File file = new File("some file that dind't exists");
        
//        String s = "some file that dind't exists";
//        System.out.println(s.split("\\D"));
        
        LabOrigem lo = OracleHelper.getLabOrigemByUniStCodigo("SPS", "000174");
        System.out.println(lo.getOriStDescricao());
        
//        System.out.println(file.exists());
        
        
    }
    
}
