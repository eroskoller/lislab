/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.utils.tipstricks;



//import br.com.tmlab.hibernatebeans.util.HibernateHelperFaces;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



/**
 *
 * @author eros
 */
public class Cpf  implements Validator {






    private String nome;
    private String cpf;
    private int dig1;
    private int dig2;

    public Cpf() {
    }





    public Cpf (String n, String c, int d1, int d2) {
        this.nome = n;
        this.cpf = c;
        this.dig1 = d1;
        this.dig2 = d2;

    }

    public Boolean calcDigVerificador () {

        if (this.cpfValido ()){
            if (this.calcDig1 () == this.dig1) {
                 System.out.println ("Dig1 OK!");
                if (this.calcDig2 () == this.dig2) {
                     System.out.println ("Dig2 OK!");
                    return true;
                } else {
                    System.out.println ("Dig2 Deu merda!");
                    return false;
                }
            } else {
                System.out.println ("Dig1 Deu merda!");
                return false;
            }//FIM SENAO
        } else {
            System.out.println ("CPF FORMATO INVALIDO!");
            return false;
        }//FIM SENAO
    }//FIM calcDigVerificador

    //Verifica a validade do cpf, indicando como inválido cpf's que possuem
    //todos os digitos repetidos. Ex.: 111.111.111-11 é inválido.
    public Boolean cpfValido () {
        int i;
        String digInicial = this.cpf.substring(0,1);
        Boolean valido = false;

        for (i = 1; i < 9; i++){
            if (!digInicial.equals(this.cpf.substring(i,i + 1))) {
                valido = true;
            }//FIM SE
        }//FIM PARA
        return valido;
    }//FIM cpfValido

    public int calcDig1 () {
        int i, resto, dig, soma = 0;

        for (i = 0; i < 9; i++) {
            soma += ((Integer.parseInt(this.cpf.substring(i,i + 1))) * (i + 1));
        }//FIM PARA

        resto = soma % 11;

        if (resto == 10) {
            dig = 0;
        } else {
            dig = resto;
        }//FIM SENAO

        return dig;

    }//FIM calcDig1

    public int calcDig2 () {
        int i, resto, dig, soma = 0;

        for (i = 0; i < 9; i++) {
            soma += ((Integer.parseInt(this.cpf.substring(i,i + 1))) * (12 - (i + 1)));
        }//FIM PARA

        soma += this.calcDig1 () * 2;
        soma *= 10;

        resto = soma % 11;

        if (resto == 10) {
            dig = 0;
        } else {
            dig = resto;
        }//FIM SENAO

        return dig;

    }// FIM calcDig2

    public String getCpf () {
        return cpf;
    }

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

    public int getDig1 () {
        return dig1;
    }

    public void setDig1 (int dig1) {
        this.dig1 = dig1;
    }

    public int getDig2 () {
        return dig2;
    }

    public void setDig2 (int dig2) {
        this.dig2 = dig2;
    }

     public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }


   

public static boolean cpfValidador(String s){
    boolean retorno = false;

    s = gettingDigits(s);

    if(s != null && s.length()>10){

            
            String strCpf = s.trim();
            String strCpf2;
            String cpfDig0;
            String cpfDig1;


            int control = strCpf.length() - 2;



            strCpf2 = strCpf.substring(0, control);
            cpfDig0 = strCpf.substring(control, control+1);
            cpfDig1 = strCpf.substring(control+1, control+2);

            Integer dig0 = new Integer(cpfDig0);
            Integer dig1 = new Integer(cpfDig1);

            if(dig0 != null && dig1 != null && strCpf2 != null){
                Cpf c = new Cpf("", strCpf2, dig0, dig1);

                retorno = (c.cpfValido() && c.calcDigVerificador());
            }


          //  System.out.println(strCpf2+"  ---  "+cpfDig0+"  ---   "+cpfDig1);
            
         return retorno;
    }else{
        return retorno;
    }


   
}


    public static String formatingCpf(String str){
        str = gettingDigits(str);
        String result= "";
        if(str != null && str.length() > 10){
            int control = str.length() - 2;
            String cpfPartial = str.substring(0,control);
            String strDig = str.substring(control, control+2);

            if(cpfPartial.length()== 9){

                String cpfFrist3 = cpfPartial.substring(0, 3);
                String cpfSecond3 = cpfPartial.substring(3, 6);
                String cpfThrid3 = cpfPartial.substring(6, 9);

                result = cpfFrist3+"."+cpfSecond3+"."+cpfThrid3+"-"+strDig;
            }



        }

        return result;
    }

    public static String gettingDigits(String str){
       return  str.replaceAll("\\D", "").trim();
    }


    

     public void validate(FacesContext context, UIComponent component, Object value){

         boolean isCpf = Cpf.cpfValidador((String) value);

         if(!isCpf){



            FacesMessage message = new FacesMessage();
            message.setDetail("Cpf não é valido");
            message.setSummary("Formato de cpf não é valido");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

     }

      public void validateDoador(FacesContext context, UIComponent component, Object value){

         boolean isCpf = Cpf.cpfValidador((String) value);
         String cpf = formatingCpf((String) value);


         if(!isCpf){
            FacesMessage message = new FacesMessage();
            message.setDetail("Cpf não é valido");
            message.setSummary("Formato de cpf não é valido");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }else{
           //  DoadorHiber dh = (DoadorHiber) HibernateHelperFaces.getListDataByKey(DoadorHiber.class, "doadorCPF", cpf);

//             if(dh.getDoadorId() != null){
//                 FacesMessage message = new FacesMessage();
//                message.setDetail("Cpf já existente no sistema.");
//                message.setSummary("Cpf já existente no sistema.");
//                message.setSeverity(FacesMessage.SEVERITY_ERROR);
//                throw new ValidatorException(message);
//
//             }
        }

     }


     public static void main(String... args){
         //System.out.println(Cpf.formatingCpf("213---043///65875"));
         System.out.println(Cpf.cpfValidador( Cpf.formatingCpf( "21304365875")));
     }



}
