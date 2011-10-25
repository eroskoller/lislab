
import org.junit.Test;
import org.junit.Assert;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros
 */
public class TestJunit {

    private static class Cpf {

        private int cpf;
        
        public Cpf(String cpf) {
            this.cpf = new Integer(cpf);
        }
        
        public boolean isValid() {
            return false;
        }
    }

    @Test
    public void cpfDeveSerInvalidoComMenosDeOnzeDigitos() {
        Cpf cpf = new Cpf("123");
        Assert.assertFalse(cpf.isValid());
    }
    
}
