/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.oracleconnector;


import br.com.facesbeans.*;
import br.com.hibernate.entities.*;



//import br.com.tmlab.facesbeans.shared.GeraAmostra;
//import br.com.tmlab.facesbeans.shared.useraccess.AccessDetails;
import br.com.hibernate.utils.OracleHelper;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mchange.v2.c3p0.*;
import com.mchange.v2.c3p0.DataSources;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;//ComboPooledDataSource.
//import org.apache.log4j.Logger;


/**
 *
 * @author eros
 */
public class OracleConnector {



    

    public static java.sql.Connection conn = null;
    public static DataSource ds_unpooled = null;
    static protected Logger log = Logger.getLogger("logs4.tmdonor");
    static ComboPooledDataSource cpds ;


    public static Connection connectOrDie(){

            //java.sql.Connection conn = null;
         try{
             
              Class.forName("oracle.jdbc.driver.OracleDriver");
              
              String url = "jdbc:oracle:thin:@//10.200.200.11:1521/clabdb";
              if(conn != null){
                        if(conn.isClosed()){
                                conn = DriverManager.getConnection(url,"cielab","lab");
                        }else{

                        }
              }else{
                conn = DriverManager.getConnection(url,"cielab","lab");
              }
              
              
            }
            catch (ClassNotFoundException e)
            {
              e.printStackTrace();

              
            }
            catch (SQLException e)
            {
              e.printStackTrace();
              
            }
            return conn;

    }

     public static ComboPooledDataSource getComboPooledDataSource(){
            //java.sql.Connection conn = null;
        try{

            if(cpds == null){
                        try{
                                    cpds = new ComboPooledDataSource();
                                    cpds.setDriverClass( "oracle.jdbc.driver.OracleDriver" );
                                    //loads the jdbc driver
                                    cpds.setJdbcUrl( "jdbc:oracle:thin:@//10.200.200.11:1521/clabdb" );
                                    cpds.setUser("EROS");
                                    cpds.setPassword("EROS"); // the settings below are optional -- c3p0 can work with defaults
                                    cpds.setMinPoolSize(5);
                                    cpds.setAcquireIncrement(3);
                                    cpds.setMaxPoolSize(30);
                                    cpds.setMaxIdleTime(0);
                                    cpds.setNumHelperThreads(100);

                                    //System.out.println("cpds = new ComboPooledDataSource();");

                                    return cpds;
                        }catch(PropertyVetoException xcp){
                            System.out.println(xcp);
                        }


            }else{
                    return cpds;
            }

        }catch (Exception e){
              e.printStackTrace();

        }

        return null;
    }

    public static DataSource getDataSourceFromC3p0(){

        try{

            if(ds_unpooled != null){
                ds_unpooled.getConnection();
            }else{
                    ds_unpooled = DataSources.unpooledDataSource("jdbc:oracle:thin:@//10.200.200.11:1521/clabdb", "cielab", "lab");
                    ds_unpooled.getConnection();
            }


            if(ds_unpooled != null){
                return ds_unpooled;
            }

        }catch (SQLException e){
              e.printStackTrace();

            }

        return null;
    }
     
      public static Connection connectByC3p0(){
            //java.sql.Connection conn = null;
        try{
                
                
            if(conn != null){
                if(conn.isClosed()){
                    return conn =    getComboPooledDataSource().getConnection();//getDataSourceFromC3p0().getConnection();
                }else{
                    return conn;
                }
                
            }else{
                    return conn = getComboPooledDataSource().getConnection();//getDataSourceFromC3p0().getConnection();
            }

        }catch (SQLException e){
              e.printStackTrace();

        }

        return null;
    }


      

      public static void openC3p0Connection(){
            try{

            if(conn != null){
                if(conn.isClosed()){
                  conn = getDataSourceFromC3p0().getConnection();
                }

            }else{
                    conn = getDataSourceFromC3p0().getConnection();
            }

        }catch (SQLException e){
              e.printStackTrace();

        }
      }

       public static void closeC3p0Connection(){
            try{

            if(conn != null){
                if(!conn.isClosed()){
                    conn.close();
                }

            }

        }catch (SQLException e){
              e.printStackTrace();

        }
      }


        public static String getReqStCodigo(){

                conn = connectOrDie();//connectByC3p0();//
                List<String> list = new ArrayList<String>();

                try
                {
                  Statement st = conn.createStatement();
                  ResultSet rs = st.executeQuery("select SEQ_REQ_ST_CODIGO.nextval from dual ");




                  while ( rs.next()){
                        list.add(rs.getString("NEXTVAL"));

                  }
                  rs.close();
                  st.close();
                  if(list != null && list.size()>0){

                     return list.get(0);

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());

                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                   return null;
                }finally{
                    if(conn != null){
                            try {
                               // System.out.println("Closing Oracle Connection.");
                                conn.close();
                            } catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);

                            }
                  }
                }




    }


         public static Long getDerInCodigo(){

                conn = connectOrDie();//connectByC3p0();//
                List<String> list = new ArrayList<String>();

                try
                {
                  Statement st = conn.createStatement();
                  ResultSet rs = st.executeQuery("select SEQ_DER_IN_CODIGO.nextval from dual ");




                  while ( rs.next()){
                        list.add(rs.getString("NEXTVAL"));

                  }
                  rs.close();
                  st.close();
                  if(list != null && list.size()>0){

                      Long id = new Long(list.get(0));

                     return id;

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());

                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                   return null;
                }finally{
                    if(conn != null){
                            try {
                                //System.out.println("Closing Oracle Connection.");
                                conn.close();
                            } catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);

                            }
                  }
                }




    }


    public static Date getSysDateFromDual(){
               conn = connectOrDie();// connectByC3p0();
                List<Date> list = new ArrayList<Date>();

                try
                {
                  Statement st = conn.createStatement();
                  ResultSet rs = st.executeQuery("select SYSDATE FROM DUAL");

                  while ( rs.next()){
                        list.add(rs.getDate("SYSDATE"));

                  }
                  rs.close();
                  st.close();
                  if(list != null && list.size()>0){

                     return list.get(0);

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());

                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                   return null;
                }finally{
                    if(conn != null){
                            try {
                               // System.out.println("Closing Oracle Connection.");
                                conn.close();
                            } catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);

                            }
                  }
                }


    }


        public static List<ExameFormatado>  getListExameFormatado(String uniStCodigo, String  conStCodigo, String regStCodigo, String oriStCodigo, String exaStCodigo,Date reqDtCadastro ){

                conn = connectByC3p0();//connectOrDie();
                List<ExameFormatado> list = new ArrayList<ExameFormatado>();
                String DATE_FORMAT = "yyyy/MM/dd";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                


                String query =
                        "SELECT "+
  "0        AS TAB_FL_QTDECH, "+
  "0             AS RTP_FL_VALORCH, "+
  "0             AS RTP_FL_VALORCHEXTERNO, "+
  "0             AS RTP_FL_DESCONTO, "+
  "0             AS RTP_FL_DESCONTOEXTERNO, "+
  "0             AS RTP_FL_ACRESCIMO, "+
  "EXD_ST_TABELA AS TAP_ST_CODIGO, "+
  "REG.REG_CH_OBRIGATORIONUMGUIA, "+

  "EXD_ST_CODIGO           AS TAB_ST_CODIGO, "+
  "''                      AS TAP_ST_DESCRICAO, "+
  "EDI.EDI_FL_VALOR        AS ETP_FL_VALORDIFENCIADO, "+
  "EDI.EDI_FL_VALOREXTERNO AS ETP_FL_VALORDIFENCIADOEXTERNO, "+
  "EDI.EDI_FL_DESCONTO, "+
  "EDI.EDI_FL_DESCONTOEXTERNO, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
    "END "+
  "FROM LAB_EXAMESCOMAUTORIZACAO "+
  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
 " ) AS ETP_ch_comautorizacao, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
    "END "+
  "FROM LAB_EXAMENAOAUTORIZADOS "+
  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
"  ) AS ETP_ch_naoautorizado, "+
  "MAT.MAT_ST_CODIGO, "+
  "MAT.MAT_ST_DESCRICAO, "+
  "EXA.EXA_CH_OBRIGATORIOPESO, "+
  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
  "EXA.EXA_CH_OBRIGAGESTANTE, "+
  "EXA.EXA_CH_SEXO, "+
  "EXU.MPA_ST_CODIGO, "+
  "EXA.EXA_ST_DESCRICAO, "+
  "EXA.EXA_CH_GRUPO, "+
  "EXU.MET_ST_CODIGO, "+
  "MET.MET_ST_DESCRICAO, "+
  "EXM.EXM_DT_VALIDADE, "+
  "EXU.EXU_CH_STATUS, "+
  "EXU.EXU_CH_FATURA, "+
  "EXA.EXA_CH_INATIVO, "+
  "EXU.EXU_CH_INATIVO, "+
  "EXU.EXU_CH_PREPARO, "+
  "EXU.EXU_CH_OBRIGAMATERIAL, "+
  "EXU.PRA_ST_CODIGO, "+
  "PRA.PRA_IN_DIAS, "+
  "PRA.PRA_CH_DOMINGO, "+
  "PRA.PRA_CH_SEGUNDA, "+
  "PRA.PRA_CH_TERCA, "+
  "PRA.PRA_CH_QUARTA, "+
  "PRA.PRA_CH_QUINTA, "+
  "PRA.PRA_CH_SEXTA, "+
 " PRA.PRA_CH_SABADO, "+
  "PRA.PRA_HR_FINAL, "+
  "PRA.PRA_IN_HORAS    AS pra_in_horas, "+
  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
  "EXU.EXU_ST_PRAZOURGENTE, "+
  "EXU.EXU_CH_NAONECESSARIO, "+
  "ORI.ORI_ST_CODIGO, "+
  "ORI.ORI_CH_URGENCIA, "+
  "ORI.LEG_ST_CODIGOINICIAL, "+
  "ORI.ORI_CH_CONFEREAUTOMATICO, "+
  "ORI.ORI_CH_CONFEREAUTOMATICOFAT, "+
  "EXU.SET_ST_CODIGO, "+
  "EXU.EXU_ST_UNIDADEEX, "+
  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
  "(SELECT MAX(EXA_ST_CODIGO) "+
  "FROM LAB_EXAMEDEPENDENTE "+
  "WHERE UNI_ST_CODIGO ='"+uniStCodigo+"' "+
  "AND EXA_ST_CODIGO   ='"+exaStCodigo+"' "+
"  ) AS DEP_ST_CODIGO "+
"FROM LAB_EXAMESDIFERENCIADOS EDI, "+
 " LAB_REGRAS REG, "+
  "LAB_EXAMEUNIDADE EXU, "+
  "LAB_ORIGEM ORI, "+
  "LAB_PRAZO PRA1, "+
  "LAB_PRAZO PRA, "+
  "LAB_EXAME EXA, "+
  "LAB_EXAMEMETODO EXM, "+
  "LAB_METODO MET, "+
  "LAB_MATERIAL MAT "+
"WHERE EDI.UNI_ST_CODIGO     = REG.UNI_ST_CODIGO "+
"AND EDI.CON_ST_CODIGO       = REG.CON_ST_CODIGO "+
"AND EDI.REG_ST_CODIGO       = REG.REG_ST_CODIGO "+
"AND EDI.UNI_ST_CODIGO       = EXU.UNI_ST_CODIGO "+
"AND EDI.EXA_ST_CODIGO       = EXU.EXA_ST_CODIGO "+
"AND EDI.UNI_ST_CODIGO       = ORI.UNI_ST_CODIGO "+
"AND EXU.EXA_ST_CODIGO       = EXA.EXA_ST_CODIGO "+
"AND EXU.EXU_ST_PRAZOURGENTE = PRA1.PRA_ST_CODIGO(+) "+
"AND EXU.PRA_ST_CODIGO       = PRA.PRA_ST_CODIGO(+) "+
"AND EXU.EXA_ST_CODIGO       = EXM.EXA_ST_CODIGO(+) "+
"AND EXU.MET_ST_CODIGO       = EXM.MET_ST_CODIGO(+) "+
"AND EXU.MET_ST_CODIGO       = MET.MET_ST_CODIGO(+) "+
"AND EXA.MAT_ST_COLETA       = MAT.MAT_ST_CODIGO(+) "+
"AND EDI.UNI_ST_CODIGO       ='"+uniStCodigo+"' "+
"AND ORI.ORI_ST_CODIGO       ='"+oriStCodigo+"' "+
"AND EDI.CON_ST_CODIGO       ='"+conStCodigo+"' "+
"AND EDI.REG_ST_CODIGO       ='"+regStCodigo+"' "+
"AND EDI.EXA_ST_CODIGO       ='"+exaStCodigo+"' "+
"AND EDI_DT_INICIOVALIDADE   = "+
 " (SELECT MAX(EDI_DT_INICIOVALIDADE) "+
  "FROM LAB_EXAMESDIFERENCIADOS "+
  "WHERE UNI_ST_CODIGO        ='"+uniStCodigo+"' "+
  "AND CON_ST_CODIGO          ='"+conStCodigo+"' "+
  "AND REG_ST_CODIGO          ='"+regStCodigo+"' "+
  "AND EXA_ST_CODIGO          ='"+exaStCodigo+"' "+
  "AND EDI_DT_INICIOVALIDADE <= TO_DATE('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+
"  ) "+

"UNION ALL "+

"SELECT TAB1.TAB_FL_QTDECH, "+
 " RTP1.rtp_fl_valorch, "+
  "RTP1.RTP_FL_VALORCHEXTERNO, "+
  "RTP1.rtp_fl_desconto, "+
  "RTP1.rtp_fl_descontoEXTERNO, "+
  "RTP1.rtp_fl_acrescimo, "+
  "RTP1.TAP_ST_CODIGO, "+
  "REG1.REG_CH_OBRIGATORIONUMGUIA, "+
  "TAB1.TAB_ST_CODIGO, "+
  "TAP1.tap_st_descricao, "+
  "0 AS ETP_fl_valordifenciado, "+
  "0 AS ETP_fl_valordifenciadoExterno, "+
  "0 AS EDI_FL_DESCONTO, "+
  "0 AS EDI_FL_DESCONTOEXTERNO, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
    "END "+
  "FROM LAB_EXAMESCOMAUTORIZACAO "+
  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
 " ) AS ETP_ch_comautorizacao, "+
  "(SELECT "+
   " CASE "+
     " WHEN COUNT(*) > 0 "+
      "THEN 'S' "+
      "ELSE 'N' "+
    "END "+
 " FROM LAB_EXAMENAOAUTORIZADOS "+
  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
"  ) AS ETP_ch_naoautorizado, "+
  "MAT.MAT_ST_CODIGO, "+
  "MAT.MAT_ST_DESCRICAO, "+
  "EXA.EXA_CH_OBRIGATORIOPESO, "+
  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
  "EXA.EXA_CH_OBRIGAGESTANTE, "+
  "EXA.EXA_CH_SEXO, "+
  "EXU.MPA_ST_CODIGO, "+
  "EXA.EXA_ST_DESCRICAO, "+
  "EXA.EXA_CH_GRUPO, "+
  "EXU.MET_ST_CODIGO, "+
  "MET.MET_ST_DESCRICAO, "+
  "EXM.EXM_DT_VALIDADE, "+
  "EXU.EXU_CH_STATUS, "+
  "EXU.EXU_CH_FATURA, "+
  "EXA.EXA_CH_INATIVO, "+
  "EXU.EXU_CH_INATIVO, "+
  "EXU.EXU_CH_PREPARO, "+
  "EXU.EXU_CH_obrigamaterial, "+
  "EXU.PRA_ST_CODIGO, "+
  "PRA.PRA_IN_DIAS, "+
  "PRA.PRA_CH_DOMINGO, "+
  "PRA.PRA_CH_SEGUNDA, "+
  "PRA.PRA_CH_TERCA, "+
  "PRA.PRA_CH_QUARTA, "+
  "PRA.PRA_CH_QUINTA, "+
  "PRA.PRA_CH_SEXTA, "+
  "PRA.PRA_CH_SABADO, "+
  "PRA.PRA_HR_FINAL, "+
  "PRA.PRA_IN_HORAS    AS pra_in_horas, "+
  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
  "EXU.EXU_ST_PRAZOURGENTE, "+
  "EXU.EXU_CH_NAONECESSARIO, "+
  "ORI.ORI_ST_CODIGO, "+
  "ORI.ORI_CH_URGENCIA, "+
  "ORI.LEG_ST_CODIGOINICIAL, "+
  "ORI_CH_CONFEREAUTOMATICO, "+
  "ORI_CH_CONFEREAUTOMATICOFAT, "+
  "EXU.SET_ST_CODIGO, "+
  "EXU.EXU_ST_UNIDADEEX, "+
  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
  "(SELECT MAX(EXA_ST_CODIGO) "+
  "FROM LAB_EXAMEDEPENDENTE "+
  "WHERE UNI_ST_CODIGO ='"+uniStCodigo+"' "+
  "AND EXA_ST_CODIGO   ='"+exaStCodigo+"' "+
"  ) AS DEP_ST_CODIGO "+
"FROM LAB_EXAME EXA, "+
 " LAB_EXAMEUNIDADE EXU, "+
  "LAB_METODO MET, "+
  "LAB_MATERIAL MAT, "+
  "LAB_EXAMEMETODO EXM, "+
  "LAB_PRAZO PRA, "+
  "LAB_PRAZO PRA1, "+
  "LAB_ORIGEM ORI, "+
  "LAB_EXAMETABELAPRECO ETP1, "+
  "LAB_TABELA TAB1, "+
  "LAB_REGRATABELAPRECO RTP1, "+
  "LAB_REGRAS REG1, "+
  "LAB_TABELAPRECO TAP1 "+
"WHERE EXU.EXA_ST_CODIGO        = EXA.EXA_ST_CODIGO "+
"AND ORI.UNI_ST_CODIGO          = EXU.UNI_ST_CODIGO "+
"AND EXU.EXU_ST_PRAZOURGENTE    = PRA1.PRA_ST_CODIGO(+) "+
"AND EXU.MET_ST_CODIGO          = MET.MET_ST_CODIGO(+) "+
"AND EXA.MAT_ST_COLETA          = MAT.MAT_ST_CODIGO(+) "+
"AND EXU.PRA_ST_CODIGO          = PRA.PRA_ST_CODIGO(+) "+
"AND EXU.EXA_ST_CODIGO          = EXM.EXA_ST_CODIGO(+) "+
"AND EXU.MET_ST_CODIGO          = EXM.MET_ST_CODIGO(+) "+
"AND REG1.uni_st_codigo         = RTP1.uni_st_codigo "+
"AND REG1.con_st_codigo         = RTP1.con_st_codigo "+
"AND REG1.reg_st_codigo         = RTP1.reg_st_codigo "+
"AND ETP1.tap_st_codigo         = TAB1.tap_st_codigo "+
"AND ETP1.tab_st_codigo         = TAB1.tab_st_codigo "+
"AND TAB1.TAB_CH_TIPO           = '1' "+
"AND TAB1.TAB_DT_INICIOVALIDADE = "+
 " (SELECT MAX(TAB_DT_INICIOVALIDADE) "+
  "FROM LAB_TABELA "+
  "WHERE tap_st_codigo        = TAB1.tap_st_codigo "+
  "AND tab_st_codigo          = TAB1.tab_st_codigo "+
  "AND TAB_CH_TIPO            = '1' "+
  "AND TAB_DT_INICIOVALIDADE <= TO_DATE('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+
 "  ) "+
"AND ETP1.tap_st_codigo         = RTP1.tap_st_codigo "+
"AND TAB1.tap_st_codigo         = TAP1.tap_st_codigo "+
"AND RTP1.uni_st_codigo         = EXU.UNI_ST_CODIGO "+
"AND ETP1.exa_st_codigo         = EXA.EXA_ST_CODIGO "+
"AND RTP1.RTP_DT_INICIOVALIDADE = "+
 " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
  "FROM LAB_REGRATABELAPRECO "+
  "WHERE uni_st_codigo        = RTP1.uni_st_codigo "+
  "AND con_st_codigo          = RTP1.con_st_codigo "+
  "AND reg_st_codigo          = RTP1.reg_st_codigo "+
  "AND RTP_DT_INICIOVALIDADE <= SYSDATE "+
  "AND RTP1.RTP_IN_SEQUENCIA  = "+
   " (SELECT MIN(RTP2.RTP_IN_SEQUENCIA) "+
    "FROM LAB_EXAMETABELAPRECO ETP2, "+
     " LAB_TABELA TAB2, "+
      "LAB_REGRATABELAPRECO RTP2, "+
      "LAB_TABELAPRECO TAP2 "+
    "WHERE ETP2.tap_st_codigo       = TAB2.tap_st_codigo "+
    "AND ETP2.tab_st_codigo         = TAB2.tab_st_codigo "+
    "AND TAB2.TAB_CH_TIPO           = '1' "+
    "AND RTP2.uni_st_codigo         = RTP2.uni_st_codigo "+
    "AND RTP2.con_st_codigo         = RTP2.con_st_codigo "+
    "AND RTP2.reg_st_codigo         = RTP2.reg_st_codigo "+
    "AND ETP2.tap_st_codigo         = RTP2.tap_st_codigo "+
    "AND TAB2.tap_st_codigo         = TAP2.tap_st_codigo "+
    "AND RTP2.uni_st_codigo         = RTP1.UNI_ST_CODIGO "+
    "AND RTP2.con_st_codigo         = RTP1.CON_ST_CODIGO "+
    "AND RTP2.reg_st_codigo         = RTP1.REG_ST_CODIGO "+
    "AND ETP2.TAP_ST_CODIGO         = ETP2.TAP_ST_CODIGO "+
    "AND ETP2.exa_st_codigo         = ETP1.EXA_ST_CODIGO "+
    "AND RTP2.RTP_DT_INICIOVALIDADE = "+
     " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
     " FROM LAB_REGRATABELAPRECO "+
      "WHERE uni_st_codigo       = RTP1.uni_st_codigo "+
      "AND con_st_codigo         = RTP1.con_st_codigo "+
      "AND reg_st_codigo         = RTP1.reg_st_codigo "+
      "AND tap_st_codigo         = ETP1.tap_st_codigo "+
      "AND RTP_DT_INICIOVALIDADE = RTP1.Rtp_Dt_Iniciovalidade "+
   "   ) "+
  "  ) "+
"  ) "+
"AND EXU.UNI_ST_CODIGO  ='"+uniStCodigo+"' "+
"AND RTP1.CON_ST_CODIGO ='"+conStCodigo+"' "+
"AND RTP1.REG_ST_CODIGO ='"+regStCodigo+"' "+
"AND ORI.ORI_ST_CODIGO  ='"+oriStCodigo+"' "+
"AND EXA.EXA_ST_CODIGO  ='"+exaStCodigo+"'";



              

                try{
                  
               //   PreparedStatement preparedStatement = conn.prepareStatement(StaticQuerys.QUERY4EXAMEFORMATADO);
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);

//                  preparedStatement.setString(1, uniStCodigo);
//                  preparedStatement.setString(2, exaStCodigo);
//                  preparedStatement.setString(3, uniStCodigo);
//                  preparedStatement.setString(4, oriStCodigo);
//                  preparedStatement.setString(5, conStCodigo);
//                  preparedStatement.setString(6, regStCodigo);
//                  preparedStatement.setString(7, exaStCodigo);
//                  preparedStatement.setString(8, uniStCodigo);
//                  preparedStatement.setString(9, conStCodigo);
//                  preparedStatement.setString(10, regStCodigo);
//                  preparedStatement.setString(11, exaStCodigo);
//                  preparedStatement.setString(12, sdf.format(reqDtCadastro));
//                  preparedStatement.setString(13, uniStCodigo);
//                  preparedStatement.setString(14, exaStCodigo);
//                  preparedStatement.setString(15, sdf.format(reqDtCadastro));
//                  preparedStatement.setString(16, uniStCodigo);
//                  preparedStatement.setString(17, conStCodigo);
//                  preparedStatement.setString(18, regStCodigo);
//                  preparedStatement.setString(19, oriStCodigo);
//                  preparedStatement.setString(20, exaStCodigo);


               

                //  ResultSet rs = preparedStatement.executeQuery();





                  while ( rs.next()){
                      ExameFormatado ef1= new ExameFormatado(
                              rs.getFloat("TAB_FL_QTDECH") ,
                              rs.getFloat("RTP_FL_VALORCH"),
                              rs.getFloat("RTP_FL_VALORCHEXTERNO"),
                              rs.getFloat("RTP_FL_DESCONTO"),
                              rs.getFloat("RTP_FL_DESCONTOEXTERNO"),
                              rs.getFloat("RTP_FL_ACRESCIMO"),
                              rs.getString("TAP_ST_CODIGO"),
                              rs.getString("REG_CH_OBRIGATORIONUMGUIA").charAt(0),
                              rs.getString("TAB_ST_CODIGO") ,
                              rs.getString("TAP_ST_DESCRICAO") ,
                              rs.getFloat("ETP_FL_VALORDIFENCIADO"),
                              rs.getFloat("ETP_FL_VALORDIFENCIADOEXTERNO"),
                              rs.getFloat("EDI_FL_DESCONTO"),
                              rs.getFloat("EDI_FL_DESCONTOEXTERNO"),
                              rs.getString("ETP_CH_COMAUTORIZACAO").charAt(0) ,
                              rs.getString("ETP_CH_NAOAUTORIZADO").charAt(0) ,
                              rs.getString("MAT_ST_CODIGO"),
                              rs.getString("MAT_ST_DESCRICAO"),
                              rs.getString("EXA_CH_OBRIGATORIOPESO").charAt(0),
                              rs.getString("EXA_CH_OBRIGATORIOALTURA").charAt(0),
                              rs.getString("EXA_CH_OBRIGAGESTANTE").charAt(0),
                              rs.getString("EXA_CH_SEXO").charAt(0),
                              rs.getString("MPA_ST_CODIGO"),
                              rs.getString("EXA_ST_DESCRICAO"),
                              rs.getString("EXA_CH_GRUPO"),
                              rs.getString("MET_ST_CODIGO"),
                              rs.getString("MET_ST_DESCRICAO"),
                              rs.getTimestamp("EXM_DT_VALIDADE"),
                              rs.getString("EXU_CH_STATUS").charAt(0),
                              rs.getString("EXU_CH_FATURA").charAt(0),
                              rs.getString("EXA_CH_INATIVO").charAt(0) ,
                              rs.getString("EXU_CH_INATIVO").charAt(0) ,
                              rs.getString("EXU_CH_PREPARO").charAt(0),
                              rs.getString("EXU_CH_OBRIGAMATERIAL").charAt(0),
                              rs.getString("PRA_ST_CODIGO"),
                              rs.getInt("PRA_IN_DIAS"),
                              rs.getString("PRA_CH_DOMINGO").charAt(0),
                              rs.getString("PRA_CH_SEGUNDA").charAt(0),
                              rs.getString("PRA_CH_TERCA").charAt(0),
                              rs.getString("PRA_CH_QUARTA").charAt(0),
                              rs.getString("PRA_CH_QUINTA").charAt(0),
                              rs.getString("PRA_CH_SEXTA").charAt(0),
                              rs.getString("PRA_CH_SABADO").charAt(0),
                              rs.getDate("PRA_HR_FINAL"),
                              rs.getInt("PRA_IN_HORAS"),
                              rs.getInt("PRA_IN_HORASU"),
                              rs.getInt("PRA_IN_DIASU"),
                              rs.getString("PRA_CH_SEGUNDAU").charAt(0),
                              rs.getString("PRA_CH_TERCAU").charAt(0),
                              rs.getString("PRA_CH_QUARTAU").charAt(0),
                              rs.getString("PRA_CH_QUINTAU").charAt(0),
                              rs.getString("PRA_CH_SEXTAU").charAt(0),
                              rs.getString("PRA_CH_SABADOU").charAt(0),
                              rs.getString("PRA_CH_DOMINGOU").charAt(0),
                              rs.getDate("PRA_HR_FINALU"),
                              rs.getString("EXU_ST_PRAZOURGENTE"),
                              rs.getString("EXU_CH_NAONECESSARIO").charAt(0),
                              rs.getString("ORI_ST_CODIGO"),
                              rs.getString("ORI_CH_URGENCIA").charAt(0),
                              rs.getString("LEG_ST_CODIGOINICIAL"),
                              rs.getString("ORI_CH_CONFEREAUTOMATICO").charAt(0),
                              rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0),
                              rs.getString("SET_ST_CODIGO"),
                              rs.getString("EXU_ST_UNIDADEEX"),
                              rs.getString("EXU_ST_UNIDADEEXURGENTE"),
                              rs.getString("EXU_CH_CONFEREAUTOMATICOFAT").charAt(0),
                              rs.getString("DEP_ST_CODIGO"));
//                              ef1.setExuStUnidadeEx(rs.getString("EXU_ST_UNIDADEEX"));
//                              ef1.setExuStUnidadeExUrgente(rs.getString("EXU_ST_UNIDADEEXURGENTE"));
//

                              list.add(ef1);


                  }
                  rs.close();
                  //st.close();
                  st.close();
                  if(list.size()>0){

                     return list;

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());

                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                   return null;
                }finally{
                    if(conn != null){
                            try {
                                //System.out.println("Closing Oracle Connection. for getListExameFomatado");
                                conn.close();
                            }catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);

                            }
                  }
                }




    }


         public static List<ExameFormatado>  getListExameFormatadoGrupo(String uniStCodigo, String  conStCodigo, String regStCodigo, String oriStCodigo, String exaStCodigo,Date reqDtCadastro ){

                conn = connectByC3p0();//connectOrDie();
                List<ExameFormatado> list = new ArrayList<ExameFormatado>();

                try{

                String DATE_FORMAT = "yyyy/MM/dd";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

//                String query =
//                          "SELECT "+
// "0        AS TAB_FL_QTDECH, "+
//  "0             AS RTP_FL_VALORCH, "+
//  "0             AS RTP_FL_VALORCHEXTERNO, "+
//  "0             AS RTP_FL_DESCONTO, "+
//  "0             AS RTP_FL_DESCONTOEXTERNO, "+
//  "0             AS RTP_FL_ACRESCIMO, "+
//  "EXD_ST_TABELA AS TAP_ST_CODIGO, "+
//  "REG.REG_CH_OBRIGATORIONUMGUIA, "+
//  "EXD_ST_CODIGO           AS TAB_ST_CODIGO, "+
//  "''                      AS TAP_ST_DESCRICAO, "+
//  "EDI.EDI_FL_VALOR        AS ETP_FL_VALORDIFENCIADO, "+
//  "EDI.EDI_FL_VALOREXTERNO AS ETP_FL_VALORDIFENCIADOEXTERNO, "+
//  "EDI.EDI_FL_DESCONTO, "+
//  "EDI.EDI_FL_DESCONTOEXTERNO, "+
//  "(SELECT "+
//   " CASE "+
//    "  WHEN COUNT(*) > 0 "+
//     " THEN 'S' "+
//      "ELSE 'N' "+
//    "END "+
//  "FROM LAB_EXAMESCOMAUTORIZACAO "+
//  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
//  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
//  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
// " ) AS ETP_ch_comautorizacao, "+
//  "(SELECT "+
//   " CASE "+
//    "  WHEN COUNT(*) > 0 "+
//     " THEN 'S' "+
//      "ELSE 'N' "+
//    "END "+
// " FROM LAB_EXAMENAOAUTORIZADOS "+
//  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
//  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
//  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
//  ") AS ETP_ch_naoautorizado, "+
//  "(SELECT EXA_CH_OBRIGAGESTANTE FROM LAB_EXAME WHERE EXA_ST_CODIGO= '"+exaStCodigo+"'  "+ //'"+sdf.format(reqDtCadastro)+"'
//  ") AS EXA_CH_OBRIGAGESTANTE, "+
//  "(SELECT EXA_CH_SEXO FROM LAB_EXAME WHERE EXA_ST_CODIGO= '"+exaStCodigo+"' "+
//  ") AS EXA_CH_SEXO, "+
//  "MAT.MAT_ST_CODIGO, "+
//  "MAT.MAT_ST_DESCRICAO, "+
//  "EXG.EXA_ST_CODIGO, "+
//  "EXA.EXA_CH_OBRIGATORIOPESO, "+
//  "EXA.EXA_ST_DESCRICAO, "+
//  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
//  "EXA.EXA_CH_OBRIGAGESTANTE, "+
//  "EXA.EXA_CH_SEXO, "+
//  "EXA.EXA_CH_GRUPO, "+
//  "EXA.EXA_CH_INATIVO, "+
//  "EXU.EXU_CH_PREPARO, "+
//  "EXU.MPA_ST_CODIGO, "+
//  "EXU.MET_ST_CODIGO, "+
//  "EXU.EXU_CH_obrigamaterial, "+
//  "EXU.PRA_ST_CODIGO, "+
//  "EXU.EXU_ST_PRAZOURGENTE, "+
//  "EXU.EXU_ST_UNIDADEEX, "+
//  "EXU.SET_ST_CODIGO, "+
//  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
//  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
//  "PRA.PRA_IN_DIAS, "+
//  "PRA.PRA_IN_HORAS AS pra_in_horas, "+
//  "PRA.PRA_CH_DOMINGO, "+
//  "PRA.PRA_CH_SEGUNDA, "+
//  "PRA.PRA_CH_TERCA, "+
//  "PRA.PRA_CH_QUARTA, "+
//  "PRA.PRA_CH_QUINTA, "+
//  "PRA.PRA_CH_SEXTA, "+
//  "PRA.PRA_CH_SABADO, "+
//  "PRA.PRA_HR_FINAL, "+
//  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
//  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
//  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
//  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
//  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
//  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
//  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
//  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
//  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
//  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
//  "MET.MET_ST_DESCRICAO, "+
//  "ORI.ORI_ST_CODIGO, "+
//  "ORI.ORI_CH_URGENCIA, "+
//  "ORI.LEG_ST_CODIGOINICIAL, "+
//  "ORI.ORI_CH_CONFEREAUTOMATICO, "+
//  "ORI.ORI_CH_CONFEREAUTOMATICOFAT, "+
//  "EXM.EXM_DT_VALIDADE, "+
//  "CASE "+
//   " WHEN (EXU.EXU_CH_NAONECESSARIO = 'S' "+
//    "OR EXG.EXG_CH_OMITE            = 'S') "+
//    "THEN 'S' "+
//    "ELSE 'N' "+
//  "END AS EXU_CH_NAONECESSARIO, "+
//  "(SELECT "+
//   " CASE "+
//    "  WHEN COUNT(*) > 0 "+
//     " THEN 'S' "+
//      "ELSE 'N' "+
//    "END "+
//  "FROM LAB_EXAMENAOAUTORIZADOS "+
//  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
//  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
//  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
//  ") AS ETP_ch_naoautorizadoG, "+
//  "EXU.EXU_CH_SOFATURAMENTO, "+
//  "EXU.EXU_CH_FATURA, "+
//  "EXG.SEQ_ST_CODIGO, "+
//  "EXG.EXG_CH_FATURA, "+
//  "SEQ.SEQ_ST_DESCRICAO, "+
//  "(SELECT EXMG.EXM_DT_VALIDADE "+
//  "FROM LAB_EXAMEMETODO EXMG "+
//  "WHERE EXMG.EXA_ST_CODIGO ='"+exaStCodigo+"' "+
//  "AND EXMG.MET_ST_CODIGO   = "+
//   " (SELECT MET_ST_CODIGO "+
//    "FROM LAB_EXAMEUNIDADE "+
//    "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//    "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//   " ) "+
// " ) AS EXM_DT_VALIDADEGRUPO, "+
//  "(SELECT EXUG.EXU_CH_FATURAGRUPO "+
//  "FROM LAB_EXAMEUNIDADE EXUG "+
//  "WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
// " ) AS EXU_CH_FATURAGRUPO, "+
//  "(SELECT EXAG1.EXA_ST_DESCRICAO "+
//  "FROM LAB_EXAME EXAG1 "+
//  "WHERE EXAG1.EXA_ST_CODIGO = EXG.EXA_ST_CODIGO "+
//  ") AS EXA_ST_DESCRICAOGRUPO, "+
//  "(SELECT EXUG.EXU_CH_INATIVO "+
//  "FROM LAB_EXAMEUNIDADE EXUG "+
//  "WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//" ) AS EXU_CH_INATIVOG, "+
//  "(SELECT MET_ST_CODIGO "+
//  "FROM LAB_EXAMEUNIDADE "+
//  "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//" )        AS MET_ST_CODIGOGRP, "+
// " '      ' AS UNIDADEEX "+
//"FROM LAB_EXAMESDIFERENCIADOS EDI, "+
// " LAB_REGRAS REG, "+
//  "LAB_EXAMEUNIDADE EXU, "+
//  "LAB_ORIGEM ORI, "+
//  "LAB_PRAZO PRA1, "+
//  "LAB_PRAZO PRA, "+
//  "LAB_EXAME EXA, "+
//  "LAB_EXAMEMETODO EXM, "+
//  "LAB_METODO MET, "+
//  "LAB_SEQUENCIAAMOSTRA SEQ, "+
//  "LAB_MATERIAL MAT, "+
//  "LAB_EXAMEGRUPO EXG "+
//"WHERE EDI.UNI_ST_CODIGO     = REG.UNI_ST_CODIGO "+
//"AND EDI.CON_ST_CODIGO       = REG.CON_ST_CODIGO "+
//"AND EDI.REG_ST_CODIGO       = REG.REG_ST_CODIGO "+
//"AND EDI.UNI_ST_CODIGO       = EXU.UNI_ST_CODIGO "+
//"AND EDI.EXA_ST_CODIGO       = EXU.EXA_ST_CODIGO "+
//"AND EDI.UNI_ST_CODIGO       = ORI.UNI_ST_CODIGO "+
//"AND EXU.EXA_ST_CODIGO       = EXA.EXA_ST_CODIGO "+
//"AND EXU.EXU_ST_PRAZOURGENTE = PRA1.PRA_ST_CODIGO(+) "+
//"AND EXU.PRA_ST_CODIGO       = PRA.PRA_ST_CODIGO(+) "+
//"AND EXU.EXA_ST_CODIGO       = EXM.EXA_ST_CODIGO(+) "+
//"AND EXU.MET_ST_CODIGO       = EXM.MET_ST_CODIGO(+) "+
//"AND EXU.MET_ST_CODIGO       = MET.MET_ST_CODIGO(+) "+
//"AND EXA.MAT_ST_COLETA       = MAT.MAT_ST_CODIGO(+) "+
//"AND EXG.SEQ_ST_CODIGO       = SEQ.SEQ_ST_CODIGO (+) "+
//"AND EXG.UNI_ST_CODIGO       = EDI.UNI_ST_CODIGO (+) "+
//"AND EXG.EXA_ST_CODIGO       = EDI.EXA_ST_CODIGO (+) "+
//"AND EXG.UNI_ST_CODIGO       ='"+uniStCodigo+"' "+
//"AND EXG.GRP_ST_CODIGO       ='"+exaStCodigo+"' "+
//"AND ORI.ORI_ST_CODIGO       ='"+oriStCodigo+"' "+
//"AND EDI.CON_ST_CODIGO       ='"+conStCodigo+"' "+
//"AND EDI.REG_ST_CODIGO       ='"+regStCodigo+"' "+
//"AND EDI_DT_INICIOVALIDADE   = "+
// " (SELECT MAX(EDI_DT_INICIOVALIDADE) "+
//  "FROM LAB_EXAMESDIFERENCIADOS "+
//  "WHERE UNI_ST_CODIGO        = EDI.UNI_ST_CODIGO "+
//  "AND CON_ST_CODIGO          = EDI.CON_ST_CODIGO "+
//  "AND REG_ST_CODIGO          = EDI.REG_ST_CODIGO "+
//  "AND EXA_ST_CODIGO          = EDI.EXA_ST_CODIGO "+
//  "AND EDI_DT_INICIOVALIDADE <= TO_DATE ('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+  /*  ('+#39 + cData_InicioValidade + #39+','+Quotedstr(YYYY-MM-DD) */
//"  ) "+
// "+ "+
//"UNION ALL "+
//
//"SELECT TAB1.TAB_FL_QTDECH, "+
//  "RTP1.rtp_fl_valorch, "+
//  "RTP1.RTP_FL_VALORCHEXTERNO, "+
//  "RTP1.rtp_fl_desconto, "+
//  "RTP1.rtp_fl_descontoEXTERNO, "+
//  "RTP1.rtp_fl_acrescimo, "+
//  "RTP1.TAP_ST_CODIGO, "+
//  "REG1.REG_CH_OBRIGATORIONUMGUIA, "+
//  "TAB1.TAB_ST_CODIGO, "+
//  "TAP1.tap_st_descricao, "+
//  "0 AS ETP_fl_valordifenciado, "+
//  "0 AS ETP_fl_valordifenciadoExterno, "+
//  "0 AS EDI_FL_DESCONTO, "+
//  "0 AS EDI_FL_DESCONTOEXTERNO, "+
//  "(SELECT "+
//   " CASE "+
//    "  WHEN COUNT(*) > 0 "+
//     " THEN 'S' "+
//      "ELSE 'N' "+
//   " END "+
//  "FROM LAB_EXAMESCOMAUTORIZACAO "+
//  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
//  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
//  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
//"  ) AS ETP_ch_comautorizacao, "+
//  "(SELECT "+
//   " CASE "+
//     " WHEN COUNT(*) > 0 "+
//      "THEN 'S' "+
//      "ELSE 'N' "+
//    "END "+
//  "FROM LAB_EXAMENAOAUTORIZADOS "+
//  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
//  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
//  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
// " ) AS ETP_ch_naoautorizado, "+
// " (SELECT EXA_CH_OBRIGAGESTANTE FROM LAB_EXAME WHERE EXA_ST_CODIGO='"+exaStCodigo+"' "+
//"  ) AS EXA_CH_OBRIGAGESTANTE, "+
// " (SELECT EXA_CH_SEXO FROM LAB_EXAME WHERE EXA_ST_CODIGO='"+exaStCodigo+"' "+
//"  ) AS EXA_CH_SEXO, "+
//  "MAT.MAT_ST_CODIGO, "+
//  "MAT.MAT_ST_DESCRICAO, "+
//  "EXA.EXA_ST_CODIGO, "+
//  "EXA.EXA_CH_OBRIGATORIOPESO, "+
//  "EXA.EXA_ST_DESCRICAO, "+
//  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
//  "EXA.EXA_CH_OBRIGAGESTANTE, "+
//  "EXA.EXA_CH_SEXO, "+
//  "EXA.EXA_CH_GRUPO, "+
//  "EXA.EXA_CH_INATIVO, "+
//  "EXU.EXU_CH_PREPARO, "+
//  "EXU.MPA_ST_CODIGO, "+
//  "EXU.MET_ST_CODIGO, "+
//  "EXU.EXU_CH_obrigamaterial, "+
//  "EXU.PRA_ST_CODIGO, "+
//  "EXU.EXU_ST_PRAZOURGENTE, "+
//  "EXU.EXU_ST_UNIDADEEX, "+
//  "EXU.SET_ST_CODIGO, "+
//  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
//  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
//  "PRA.PRA_IN_DIAS, "+
//  "PRA.PRA_IN_HORAS AS pra_in_horas, "+
//  "PRA.PRA_CH_DOMINGO, "+
//  "PRA.PRA_CH_SEGUNDA, "+
//  "PRA.PRA_CH_TERCA, "+
//  "PRA.PRA_CH_QUARTA, "+
//  "PRA.PRA_CH_QUINTA, "+
//  "PRA.PRA_CH_SEXTA, "+
//  "PRA.PRA_CH_SABADO, "+
//  "PRA.PRA_HR_FINAL, "+
//  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
//  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
//  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
//  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
//  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
//  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
//  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
//  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
//  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
//  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
//  "MET.MET_ST_DESCRICAO, "+
//  "ORI.ORI_ST_CODIGO, "+
//  "ORI.ORI_CH_URGENCIA, "+
//  "ORI.LEG_ST_CODIGOINICIAL, "+
//  "ORI_CH_CONFEREAUTOMATICO, "+
//  "ORI_CH_CONFEREAUTOMATICOFAT, "+
//  "EXM.EXM_DT_VALIDADE, "+
//  "CASE "+
//   " WHEN (EXU.EXU_CH_NAONECESSARIO = 'S' "+
//    "OR EXG.EXG_CH_OMITE            = 'S') "+
//    "THEN 'S' "+
//    "ELSE 'N' "+
//  "END AS EXU_CH_NAONECESSARIO, "+
//  "(SELECT "+
//   " CASE "+
//    "  WHEN COUNT(*) > 0 "+
//     " THEN 'S' "+
//      "ELSE 'N' "+
//   " END "+
//  "FROM LAB_EXAMENAOAUTORIZADOS "+
//  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
//  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
//  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//"  ) AS ETP_ch_naoautorizadoG, "+
//  "EXU.EXU_CH_SOFATURAMENTO, "+
//  "EXU.EXU_CH_FATURA, "+
//  "EXG.SEQ_ST_CODIGO, "+
//  "EXG.EXG_CH_FATURA, "+
//  "SEQ.SEQ_ST_DESCRICAO, "+
//"  (SELECT EXMG.EXM_DT_VALIDADE "+
//  "FROM LAB_EXAMEMETODO EXMG "+
//  "WHERE EXMG.EXA_ST_CODIGO ='"+exaStCodigo+"' "+
//  "AND EXMG.MET_ST_CODIGO   = "+
//   " (SELECT MET_ST_CODIGO "+
//    "FROM LAB_EXAMEUNIDADE "+
//    "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//    "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//  "  ) "+
//"  ) AS EXM_DT_VALIDADEGRUPO, "+
//  "(SELECT EXUG.EXU_CH_FATURAGRUPO "+
//  "FROM LAB_EXAMEUNIDADE EXUG "+
//  "WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//" ) AS EXU_CH_FATURAGRUPO, "+
// " (SELECT EXAG1.EXA_ST_DESCRICAO "+
// " FROM LAB_EXAME EXAG1 "+
//  "WHERE EXAG1.EXA_ST_CODIGO = EXG.GRP_ST_CODIGO "+
//" ) AS EXA_ST_DESCRICAOGRUPO, "+
// " (SELECT EXUG.EXU_CH_INATIVO "+
// " FROM LAB_EXAMEUNIDADE EXUG "+
// " WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//"  ) AS EXU_CH_INATIVOG, "+
//  "(SELECT MET_ST_CODIGO "+
//  "FROM LAB_EXAMEUNIDADE "+
//  "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
//  "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
//" )        AS MET_ST_CODIGOGRP, "+
// " '      ' AS UNIDADEEX "+
//"FROM LAB_EXAMEGRUPO EXG, "+
// " LAB_EXAME EXA, "+
//  "LAB_EXAMEUNIDADE EXU, "+
//  "LAB_METODO MET, "+
//  "LAB_MATERIAL MAT, "+
//  "LAB_EXAMEMETODO EXM, "+
//  "LAB_SEQUENCIAAMOSTRA SEQ, "+
//  "LAB_PRAZO PRA, "+
//  "LAB_PRAZO PRA1, "+
//  "LAB_ORIGEM ORI, "+
//  "LAB_EXAMETABELAPRECO ETP1, "+
//  "LAB_TABELA TAB1, "+
//  "LAB_REGRATABELAPRECO RTP1, "+
//  "LAB_TABELAPRECO TAP1, "+
//  "LAB_REGRAS REG1 "+
//"WHERE EXG.EXA_ST_CODIGO        = EXA.EXA_ST_CODIGO "+
//"AND EXU.MET_ST_CODIGO          = MET.MET_ST_CODIGO "+
//"AND EXU.EXA_ST_CODIGO          = EXM.EXA_ST_CODIGO "+
//"AND EXU.MET_ST_CODIGO          = EXM.MET_ST_CODIGO "+
//"AND EXA.MAT_ST_COLETA          = MAT.MAT_ST_CODIGO "+
//"AND EXU.EXA_ST_CODIGO          = EXA.EXA_ST_CODIGO "+
//"AND EXU.PRA_ST_CODIGO          = PRA.PRA_ST_CODIGO(+) "+
//"AND EXU.EXU_ST_PRAZOURGENTE    = PRA1.PRA_ST_CODIGO(+) "+
//"AND EXG.SEQ_ST_CODIGO          = SEQ.SEQ_ST_CODIGO "+
//"AND ORI.UNI_ST_CODIGO          = EXU.UNI_ST_CODIGO "+
//"AND ETP1.tap_st_codigo         = TAB1.tap_st_codigo "+
//"AND ETP1.tab_st_codigo         = TAB1.tab_st_codigo "+
//"AND TAB1.TAB_CH_TIPO           = '1' "+
//"AND TAB1.TAB_DT_INICIOVALIDADE = "+
//  "(SELECT MAX(TAB_DT_INICIOVALIDADE) "+
//  "FROM LAB_TABELA "+
//  "WHERE tap_st_codigo        = TAB1.tap_st_codigo "+
//  "AND tab_st_codigo          = TAB1.tab_st_codigo "+
//  "AND TAB_CH_TIPO            = '1' "+
//  "AND TAB_DT_INICIOVALIDADE <= TO_DATE ('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+ /**/
//  ") "+
//"AND REG1.uni_st_codigo         = RTP1.uni_st_codigo "+
//"AND REG1.con_st_codigo         = RTP1.con_st_codigo "+
//"AND REG1.reg_st_codigo         = RTP1.reg_st_codigo "+
//"AND ETP1.tap_st_codigo         = RTP1.tap_st_codigo "+
//"AND TAB1.tap_st_codigo         = TAP1.tap_st_codigo "+
//"AND RTP1.uni_st_codigo         = EXU.UNI_ST_CODIGO "+
//"AND ETP1.exa_st_codigo         = EXA.EXA_ST_CODIGO "+
//"AND RTP1.RTP_DT_INICIOVALIDADE = "+
// " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
//  "FROM LAB_REGRATABELAPRECO "+
//  "WHERE uni_st_codigo        = RTP1.uni_st_codigo "+
//  "AND con_st_codigo          = RTP1.con_st_codigo "+
//  "AND reg_st_codigo          = RTP1.reg_st_codigo "+
//  "AND RTP_DT_INICIOVALIDADE <= SYSDATE "+
//  "AND RTP1.RTP_IN_SEQUENCIA  = "+
//   " (SELECT MIN(RTP2.RTP_IN_SEQUENCIA) "+
//    "FROM LAB_EXAMETABELAPRECO ETP2, "+
//     " LAB_TABELA TAB2, "+
//      "LAB_REGRATABELAPRECO RTP2, "+
//      "LAB_TABELAPRECO TAP2 "+
//    "WHERE ETP2.tap_st_codigo       = TAB2.tap_st_codigo "+
//    "AND ETP2.tab_st_codigo         = TAB2.tab_st_codigo "+
//    "AND TAB2.TAB_CH_TIPO           = '1' "+
//    "AND RTP2.uni_st_codigo         = RTP2.uni_st_codigo "+
//    "AND RTP2.con_st_codigo         = RTP2.con_st_codigo "+
//    "AND RTP2.reg_st_codigo         = RTP2.reg_st_codigo "+
//    "AND ETP2.tap_st_codigo         = RTP2.tap_st_codigo "+
//    "AND TAB2.tap_st_codigo         = TAP2.tap_st_codigo "+
//    "AND RTP2.uni_st_codigo         = RTP1.UNI_ST_CODIGO "+
//    "AND RTP2.con_st_codigo         = RTP1.CON_ST_CODIGO "+
//    "AND RTP2.reg_st_codigo         = RTP1.REG_ST_CODIGO "+
//    "AND ETP2.TAP_ST_CODIGO         = ETP2.TAP_ST_CODIGO "+
//    "AND ETP2.exa_st_codigo         = ETP1.EXA_ST_CODIGO "+
//    "AND RTP2.RTP_DT_INICIOVALIDADE = "+
//     " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
//      "FROM LAB_REGRATABELAPRECO "+
//      "WHERE uni_st_codigo       = RTP1.uni_st_codigo "+
//      "AND con_st_codigo         = RTP1.con_st_codigo "+
//      "AND reg_st_codigo         = RTP1.reg_st_codigo "+
//      "AND tap_st_codigo         = ETP1.tap_st_codigo "+
//      "AND RTP_DT_INICIOVALIDADE = RTP1.Rtp_Dt_Iniciovalidade "+
//      ") "+
//    ") "+
//  ") "+
//"AND EXU.UNI_ST_CODIGO ='"+exaStCodigo+"' "+
//"AND EXG.UNI_ST_CODIGO ='"+uniStCodigo+"' "+
//"AND RTP1.CON_ST_CODIGO='"+conStCodigo+"' "+
//"AND RTP1.REG_ST_CODIGO='"+regStCodigo+"' "+
//"AND ORI.ORI_ST_CODIGO ='"+oriStCodigo+"' "+
//"AND EXG.GRP_ST_CODIGO ='"+exaStCodigo+"' ";




                  PreparedStatement preparedStatement = conn.prepareStatement(StaticQuerys.QUERY4EXAMEFORMATADOGRUPO);
                  preparedStatement.setString(1, exaStCodigo);
                  preparedStatement.setString(2, exaStCodigo);
                  preparedStatement.setString(3, exaStCodigo);
                  preparedStatement.setString(4, uniStCodigo);
                  preparedStatement.setString(5, exaStCodigo);
                  preparedStatement.setString(6, oriStCodigo);
                  preparedStatement.setString(7, conStCodigo);
                  preparedStatement.setString(8, regStCodigo);
                  preparedStatement.setString(9, sdf.format(reqDtCadastro));
                  preparedStatement.setString(10,exaStCodigo);
                  preparedStatement.setString(11, exaStCodigo);
                  preparedStatement.setString(12, exaStCodigo);
                  preparedStatement.setString(13, sdf.format(reqDtCadastro));
                  preparedStatement.setString(14, uniStCodigo);
                  preparedStatement.setString(15, uniStCodigo);
                  preparedStatement.setString(16, conStCodigo);
                  preparedStatement.setString(17, regStCodigo);
                  preparedStatement.setString(18, oriStCodigo);
                  preparedStatement.setString(19, exaStCodigo);

                    //conn.prepareStatement(StaticQuerys.QUERY4EXAMEFORMATADOGRUPO);
                   //Statement st = conn.createStatement();
                  //ResultSet rs = st.executeQuery(query);
                  ResultSet rs = preparedStatement.executeQuery();



                  while ( rs.next()){

                  ExameFormatado ef2 = new ExameFormatado();
                    ef2.setDepStCodigo("NI");//(rs.getString("DEP_ST_CODIGO"));
                    ef2.setEdiFlDesconto(rs.getFloat("EDI_FL_DESCONTO"));
                    ef2.setEdiFlDescontoExterno(rs.getFloat("EDI_FL_DESCONTOEXTERNO"));
                    ef2.setEtpChComAutorizacao(rs.getString("ETP_CH_COMAUTORIZACAO").charAt(0));
                    ef2.setEtpChNaoAutorizado(rs.getString("ETP_CH_NAOAUTORIZADO").charAt(0));
                    ef2.setEtpFlValorDifenciado(rs.getFloat("ETP_FL_VALORDIFENCIADO"));
                    ef2.setEtpFlValorDifenciadoExterno(rs.getFloat("ETP_FL_VALORDIFENCIADOEXTERNO"));
                    ef2.setExaChInativo(rs.getString("EXA_CH_INATIVO").charAt(0));
                    ef2.setExaChObrigaGestante(rs.getString("EXA_CH_OBRIGAGESTANTE").charAt(0));
                    ef2.setExaChObrigatorioAltura(rs.getString("EXA_CH_OBRIGATORIOALTURA").charAt(0));
                    ef2.setExaChObrigatorioPeso(rs.getString("EXA_CH_OBRIGATORIOPESO").charAt(0));
                    ef2.setExaChSexo(rs.getString("EXA_CH_SEXO").charAt(0));
                    ef2.setExaStCodigo((LabExame)OracleHelper.getObject(LabExame.class, rs.getString("EXA_ST_CODIGO")) );
                    ef2.setExaStDescricao(rs.getString("EXA_ST_DESCRICAO"));
                    ef2.setExaStGrupo(rs.getString("EXA_CH_GRUPO"));
                    ef2.setExmDtValidade(rs.getTimestamp("EXM_DT_VALIDADE"));
                    ef2.setExuChConfereAutomaticoFat(rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0));
                    ef2.setExuChFatura(rs.getString("EXU_CH_FATURA").charAt(0));
                    ef2.setExuChInativo('N');//(rs.getString("EXU_CH_INATIVO").charAt(0));
                    ef2.setExuChNaoNecessario(rs.getString("EXU_CH_NAONECESSARIO").charAt(0));
                    ef2.setExuChObrigaMaterial(rs.getString("EXU_CH_OBRIGAMATERIAL").charAt(0));
                    ef2.setExuChPreparo(rs.getString("EXU_CH_PREPARO").charAt(0));
                    ef2.setExuChStatus('N');//rs.getString("EXU_CH_STATUS").charAt(0));//('N');
                    ef2.setExuStPrazoUrgente(rs.getString("EXU_ST_PRAZOURGENTE"));
                    ef2.setExuStUnidadeEx(rs.getString("EXU_ST_UNIDADEEX"));
                    ef2.setExuStUnidadeExUrgente(rs.getString("EXU_ST_UNIDADEEXURGENTE"));
                    ef2.setLegStCogioInicial(rs.getString("LEG_ST_CODIGOINICIAL"));
                    ef2.setMatStCodigo(rs.getString("MAT_ST_CODIGO"));
                    ef2.setMatStDescricao(rs.getString("MAT_ST_DESCRICAO"));
                    ef2.setMetStCodigo(rs.getString("MET_ST_CODIGO"));
                    ef2.setMetStDescricao(rs.getString("MET_ST_DESCRICAO"));
                    ef2.setMpaStCodigo(rs.getString("MPA_ST_CODIGO"));
                    ef2.setOriChConfereAutomatico(rs.getString("ORI_CH_CONFEREAUTOMATICO").charAt(0));
                    ef2.setOriChConfereAutomaticoFat(rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0));
                    ef2.setOriChUrgencia(rs.getString("ORI_CH_URGENCIA").charAt(0));
                    ef2.setOriStCodigo(rs.getString("ORI_ST_CODIGO"));
                    ef2.setPraChDomingo(rs.getString("PRA_CH_DOMINGO").charAt(0));
                    ef2.setPraChDomingoU(rs.getString("PRA_CH_DOMINGOU").charAt(0));
                    ef2.setPraChQuarta(rs.getString("PRA_CH_QUARTA").charAt(0));
                    ef2.setPraChQuartaU(rs.getString("PRA_CH_QUARTAU").charAt(0));
                    ef2.setPraChQuinta(rs.getString("PRA_CH_QUINTA").charAt(0));
                    ef2.setPraChQuintaU(rs.getString("PRA_CH_QUINTAU").charAt(0));
                    ef2.setPraChSabado(rs.getString("PRA_CH_SABADO").charAt(0));
                    ef2.setPraChSabadoU(rs.getString("PRA_CH_SABADOU").charAt(0));
                    ef2.setPraChSegunda(rs.getString("PRA_CH_SEGUNDA").charAt(0));
                    ef2.setPraChSegundaU(rs.getString("PRA_CH_SEGUNDAU").charAt(0));
                    ef2.setPraChSexta(rs.getString("PRA_CH_SEXTA").charAt(0));
                    ef2.setPraChSextaU(rs.getString("PRA_CH_SEXTAU").charAt(0));
                    ef2.setPraChTerca(rs.getString("PRA_CH_TERCA").charAt(0));
                    ef2.setPraChTercaU(rs.getString("PRA_CH_TERCAU").charAt(0));
                    ef2.setPraHrFinal(rs.getDate("PRA_HR_FINAL"));
                    ef2.setPraHrFinalU(rs.getDate("PRA_HR_FINALU"));
                    ef2.setPraInDias(rs.getInt("PRA_IN_DIAS"));
                    ef2.setPraInDiasU(rs.getInt("PRA_IN_DIASU"));
                    ef2.setPraInHoras(rs.getInt("PRA_IN_HORAS"));
                    ef2.setPraInHorasU(rs.getInt("PRA_IN_HORASU"));
                    ef2.setPraStCodigo(rs.getString("PRA_ST_CODIGO"));
                    ef2.setRegChObrigatorioNumGuia(rs.getString("REG_CH_OBRIGATORIONUMGUIA").charAt(0));
                    ef2.setRtpFlAcrescimo(rs.getFloat("RTP_FL_ACRESCIMO"));
                    ef2.setRtpFlDesconto(rs.getFloat("RTP_FL_DESCONTO"));
                    ef2.setRtpFlDescontoExterno(rs.getFloat("RTP_FL_DESCONTOEXTERNO"));
                    ef2.setRtpFlValorCh(rs.getFloat("RTP_FL_VALORCH"));
                    ef2.setRtpFlValorChExterno(rs.getFloat("RTP_FL_VALORCHEXTERNO"));
                    ef2.setSetStCodigo(rs.getString("SET_ST_CODIGO"));
                    ef2.setTabFlQtDeCh(rs.getFloat("TAB_FL_QTDECH"));
                    ef2.setTabStCodigo(rs.getString("TAB_ST_CODIGO"));
                    /*ef.setTabStDescricao(rs.getString("TAB_ST_DESCRICAO")); */
                    ef2.setTapStCodigo(rs.getString("TAP_ST_CODIGO"));
                    ef2.setTapStDescricao(rs.getString("TAP_ST_DESCRICAO"));
                    ef2.setExuChConfereAutomaticoFat(rs.getString("EXU_CH_CONFEREAUTOMATICOFAT").charAt(0)) ;
                    ef2.setMetStCodigoGrp(rs.getString("MET_ST_CODIGOGRP"));


                              list.add(ef2);


                  }
                  rs.close();
                  preparedStatement.close();
 
                  if(list != null && list.size()>0){

                      List<ExameFormatado> myList = new ArrayList<ExameFormatado>();
                    
                      for(ExameFormatado e : list){
                          if(!e.getEtpChNaoAutorizado().toString().equalsIgnoreCase("S") ){ //e.getEtpFlValorDifenciado()>0 &&
                                myList.add(e);
                             
                          }
                      }


                     return myList;

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());
                   se.printStackTrace();
                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                    System.out.println(xcp);
                   return null;
                }finally{
                    if(conn != null){
                            try {
                                //System.out.println("Closing Oracle Connection. for getListExameFomatadoGrupo");
                                conn.close();
                            }catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println(ex);
                                System.err.println(ex);

                            }
                  }
                }




    }


         public static List<ExameFormatado>  getListExameFormatadoDependente
               (String uniStCodigo, String  conStCodigo, String regStCodigo, String oriStCodigo, String reqStCodigo,Date reqDtCadastro ){

                conn = connectByC3p0();//connectOrDie();
                List<ExameFormatado> list = new ArrayList<ExameFormatado>();
                List<ExameFormatado> listResult = new ArrayList<ExameFormatado>();

                try{

                        String DATE_FORMAT = "yyyy/MM/dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                        Statement st = conn.createStatement();


    String query =                    " SELECT "+
                         "0 AS TAB_FL_QTDECH, "+
                         "0 AS RTP_FL_VALORCH, "+
                         "0 AS RTP_FL_VALORCHEXTERNO, "+
                         "0 AS RTP_FL_DESCONTO, "+
                         "0 AS RTP_FL_DESCONTOEXTERNO, "+
                         "0 AS RTP_FL_ACRESCIMO, "+
                         "EXD_ST_TABELA AS TAP_ST_CODIGO, "+
                         "REG.REG_CH_OBRIGATORIONUMGUIA, "+
                         "EXD_ST_CODIGO AS TAB_ST_CODIGO, "+
                         "'' AS TAP_ST_DESCRICAO, "+
                         "EDI.EDI_FL_VALOR AS ETP_FL_VALORDIFENCIADO, "+
                         "EDI.EDI_FL_VALOREXTERNO AS ETP_FL_VALORDIFENCIADOEXTERNO, "+
                         "EDI.EDI_FL_DESCONTO, "+
                         "EDI.EDI_FL_DESCONTOEXTERNO, "+
                         "'N' AS ETP_CH_COMAUTORIZACAO, "+
                         "'N' AS ETP_CH_NAOAUTORIZADO, "+
                         "der.exa_st_codigo, "+
                         "dep.dep_st_codigo, "+
                         "DEP.DEP_CH_OMITE, "+
                         "dep.dep_ch_fatura, "+
                         "MAT.MAT_ST_CODIGO, "+
                         "MAT.MAT_ST_DESCRICAO, "+
                         "EXA.EXA_CH_OBRIGATORIOPESO, "+
                         "EXA.EXA_CH_OBRIGATORIOALTURA, "+
                         "EXA.EXA_CH_OBRIGAGESTANTE, "+
                         "EXA.EXA_CH_SEXO, "+
                         "EXU.MPA_ST_CODIGO, "+
                         "EXA.EXA_ST_DESCRICAO, "+
                         "EXU.EXU_CH_obrigamaterial, "+
                         "EXU.MET_ST_CODIGO, "+
                         "MET.MET_ST_DESCRICAO, "+
                         "EXM.EXM_DT_VALIDADE, "+
                         "EXU.EXU_CH_STATUS, "+
                         "EXU.EXU_CH_FATURA, "+
                         "EXA.EXA_CH_INATIVO, "+
                         "EXU.EXU_CH_PREPARO, "+
                         "EXA.EXA_CH_GRUPO, "+
                         "EXU.EXU_CH_INATIVO, "+
                         "EXU.PRA_ST_CODIGO, "+
                         "EXU.EXU_ST_UNIDADEEX, "+
                         "EXU.EXU_ST_UNIDADEEXURGENTE, "+
                         "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
                         "PRA.PRA_IN_DIAS, "+
                         "PRA.PRA_CH_DOMINGO, "+
                         "PRA.PRA_CH_SEGUNDA, "+
                         "PRA.PRA_CH_TERCA, "+
                         "PRA.PRA_CH_QUARTA, "+
                         "PRA.PRA_CH_QUINTA, "+
                         "PRA.PRA_CH_SEXTA, "+
                         "PRA.PRA_CH_SABADO, "+
                         "PRA.PRA_HR_FINAL, "+
                        "EXU.EXU_ST_PRAZOURGENTE, "+
                         "PRA.PRA_IN_HORAS as pra_in_horas, "+
                         "PRA1.PRA_IN_HORAS as pra_in_horasU, "+
                         "EXU.APO_ST_CODIGO, "+
                         "PRA1.PRA_IN_DIAS as pra_in_diasU, "+
                         "PRA1.PRA_CH_SEGUNDA as pra_ch_segundaU, "+
                         "PRA1.PRA_CH_TERCA as pra_ch_tercaU, "+
                         "PRA1.PRA_CH_QUARTA as pra_ch_quartaU, "+
                         "PRA1.PRA_CH_QUINTA as pra_ch_quintaU, "+
                         "PRA1.PRA_CH_SEXTA as pra_ch_sextaU, "+
                         "PRA1.PRA_CH_SABADO as pra_ch_sabadoU, "+
                         "PRA1.PRA_CH_DOMINGO as pra_ch_domingoU, "+
                         "PRA1.PRA_HR_FINAL AS PRA_HR_FINALU, "+
                         "ORI.ORI_ST_CODIGO, "+
                         "ORI.ORI_CH_URGENCIA, "+
                         "ORI.LEG_ST_CODIGOINICIAL, "+
                         "ORI.ORI_CH_CONFEREAUTOMATICO, "+
                         "ORI.ORI_CH_CONFEREAUTOMATICOFAT, "+
                         "EXU.SET_ST_CODIGO, "+
                         "'      ' as UNIDADEEX "+
                  "FROM LAB_EXAMESDIFERENCIADOS EDI, LAB_REGRAS REG, LAB_EXAMEUNIDADE EXU, LAB_ORIGEM ORI,LAB_PRAZO PRA1,LAB_EXAMEDEPENDENTE DEP, "+
                    "   LAB_PRAZO PRA,LAB_EXAME EXA, LAB_EXAMEMETODO EXM,LAB_METODO MET,LAB_MATERIAL MAT,lab_detalherequisicao der "+
                   "WHERE EDI.UNI_ST_CODIGO = REG.UNI_ST_CODIGO "+
                     "AND EDI.CON_ST_CODIGO = REG.CON_ST_CODIGO "+
                     "AND EDI.REG_ST_CODIGO = REG.REG_ST_CODIGO "+
                     "AND EDI.UNI_ST_CODIGO = EXU.UNI_ST_CODIGO "+
                     "AND EDI.EXA_ST_CODIGO = EXU.EXA_ST_CODIGO "+
                     "AND DER.EXA_ST_CODIGO = DEP.EXA_ST_CODIGO "+
                     "AND DER.UNI_ST_CODIGO = DEP.UNI_ST_CODIGO "+
                     "AND EXA.EXA_ST_CODIGO = DEP.DEP_ST_CODIGO "+
                     "AND EDI.UNI_ST_CODIGO = ORI.UNI_ST_CODIGO "+
                     "AND EXU.EXA_ST_CODIGO = EXA.EXA_ST_CODIGO "+
                     "AND EXU.EXU_ST_PRAZOURGENTE = PRA1.PRA_ST_CODIGO(+) "+
                     "AND EXU.PRA_ST_CODIGO = PRA.PRA_ST_CODIGO(+) "+
                     "AND EXU.EXA_ST_CODIGO = EXM.EXA_ST_CODIGO(+) "+
                     "AND EXU.MET_ST_CODIGO = EXM.MET_ST_CODIGO(+) "+
                     "AND EXU.MET_ST_CODIGO = MET.MET_ST_CODIGO(+) "+
                     "AND EXA.MAT_ST_COLETA = MAT.MAT_ST_CODIGO(+) "+
                     "AND EDI.UNI_ST_CODIGO ='"+uniStCodigo+"' "+
                     "AND ORI.ORI_ST_CODIGO ='"+oriStCodigo+"' "+
                     "AND EDI.CON_ST_CODIGO ='"+conStCodigo+"' "+
                     "AND EDI.REG_ST_CODIGO ='"+regStCodigo+"' "+
                     "and DER.REQ_ST_CODIGO ='"+reqStCodigo+"' "+
                     "AND EDI_DT_INICIOVALIDADE = "+
                       "  (SELECT MAX(EDI_DT_INICIOVALIDADE) FROM LAB_EXAMESDIFERENCIADOS "+
                         "  WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
                           "  AND CON_ST_CODIGO = EDI.CON_ST_CODIGO "+
                             "AND REG_ST_CODIGO = EDI.REG_ST_CODIGO "+
                             "AND EXA_ST_CODIGO = EDI.EXA_ST_CODIGO "+
                             "AND EDI_DT_INICIOVALIDADE <= TO_DATE('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD')) "+ // todo porrrrraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                  "UNION ALL "+
                  "select TAB1.TAB_FL_QTDECH, "+
                    "     RTP1.rtp_fl_valorch, "+
                      "   RTP1.rtp_fl_valorchEXTERNO, "+
                        " RTP1.rtp_fl_desconto, "+
                         "RTP1.rtp_fl_descontoEXTERNO, "+
                         "RTP1.rtp_fl_acrescimo, "+
                         "RTP1.TAP_ST_CODIGO, "+
                         "REG1.REG_CH_OBRIGATORIONUMGUIA, "+
                         "TAB1.TAB_ST_CODIGO, "+
                         "TAP1.tap_st_descricao, "+
                         "0 AS ETP_fl_valordifenciado, "+
                         "0 AS ETP_fl_valordifenciadoExterno, "+
                         "0 EDI_FL_DESCONTO, "+
                         "0 EDI_FL_DESCONTOEXTERNO, "+
                         "(SELECT CASE WHEN COUNT(*) > 0 THEN  'S'  ELSE  'N'  END "+
                           " FROM LAB_EXAMESCOMAUTORIZACAO "+
                           "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
                             "AND CON_ST_CODIGO = RTP1.CON_ST_CODIGO "+
                             "AND REG_ST_CODIGO = RTP1.REG_ST_CODIGO "+
                             "AND EXA_ST_CODIGO = ETP1.EXA_ST_CODIGO) AS ETP_ch_comautorizacao, "+
                         "(SELECT CASE WHEN COUNT(*) > 0 THEN 'S' ELSE 'N' END FROM LAB_EXAMENAOAUTORIZADOS "+
                           "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
                             "AND CON_ST_CODIGO = RTP1.CON_ST_CODIGO "+
                             "AND REG_ST_CODIGO = RTP1.REG_ST_CODIGO "+
                             "AND EXA_ST_CODIGO = ETP1.EXA_ST_CODIGO) AS ETP_ch_naoautorizado, "+
                         "der.exa_st_codigo, "+
                         "dep.dep_st_codigo, "+
                         "DEP.DEP_CH_OMITE, "+
                         "dep.dep_ch_fatura, "+
                         "MAT.MAT_ST_CODIGO, "+
                         "MAT.MAT_ST_DESCRICAO, "+
                         "EXA.EXA_CH_OBRIGATORIOPESO, "+
                         "EXA.EXA_CH_OBRIGATORIOALTURA, "+
                         "EXA.EXA_CH_OBRIGAGESTANTE, "+
                         "EXA.EXA_CH_SEXO, "+
                         "EXU.MPA_ST_CODIGO, "+
                         "EXA.EXA_ST_DESCRICAO, "+
                         "EXU.EXU_CH_obrigamaterial, "+
                         "EXU.MET_ST_CODIGO, "+
                         "MET.MET_ST_DESCRICAO, "+
                         "EXM.EXM_DT_VALIDADE, "+
                         "EXU.EXU_CH_STATUS, "+
                         "EXU.EXU_CH_FATURA, "+
                         "EXA.EXA_CH_INATIVO, "+
                         "EXU.EXU_CH_PREPARO, "+
                         "EXA.EXA_CH_GRUPO, "+
                         "EXU.EXU_CH_INATIVO, "+
                         "EXU.PRA_ST_CODIGO, "+
                         "EXU.EXU_ST_UNIDADEEX, "+
                         "EXU.EXU_ST_UNIDADEEXURGENTE, "+
                         "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
                         "PRA.PRA_IN_DIAS, "+
                         "PRA.PRA_CH_DOMINGO, "+
                         "PRA.PRA_CH_SEGUNDA, "+
                         "PRA.PRA_CH_TERCA, "+
                         "PRA.PRA_CH_QUARTA, "+
                         "PRA.PRA_CH_QUINTA, "+
                         "PRA.PRA_CH_SEXTA, "+
                         "PRA.PRA_CH_SABADO, "+
                         "PRA.PRA_HR_FINAL, "+
                         "EXU.EXU_ST_PRAZOURGENTE, "+
                         "PRA.PRA_IN_HORAS as pra_in_horas, "+
                         "PRA1.PRA_IN_HORAS as pra_in_horasU, "+
                         "EXU.APO_ST_CODIGO, "+
                         "PRA1.PRA_IN_DIAS as pra_in_diasU, "+
                         "PRA1.PRA_CH_SEGUNDA as pra_ch_segundaU, "+
                         "PRA1.PRA_CH_TERCA as pra_ch_tercaU, "+
                         "PRA1.PRA_CH_QUARTA as pra_ch_quartaU, "+
                         "PRA1.PRA_CH_QUINTA as pra_ch_quintaU, "+
                         "PRA1.PRA_CH_SEXTA as pra_ch_sextaU, "+
                         "PRA1.PRA_CH_SABADO as pra_ch_sabadoU, "+
                         "PRA1.PRA_CH_DOMINGO as pra_ch_domingoU, "+
                         "PRA1.PRA_HR_FINAL AS PRA_HR_FINALU, "+
                         "ORI.ORI_ST_CODIGO, "+
                         "ORI.ORI_CH_URGENCIA, "+
                         "ORI.LEG_ST_CODIGOINICIAL, "+
                         "ori.ORI_CH_CONFEREAUTOMATICO, "+
                         "ori.ORI_CH_CONFEREAUTOMATICOFAT, "+
                         "EXU.SET_ST_CODIGO, "+
                         "'      ' as UNIDADEEX "+
                    "FROM lab_detalherequisicao der, "+
                      "   lab_examedependente   dep, "+
                        " LAB_EXAME             EXA, "+
                         "LAB_EXAMEUNIDADE      EXU, "+
                         "LAB_METODO            MET, "+
                         "LAB_MATERIAL          MAT, "+
                         "LAB_EXAMEMETODO       EXM, "+
                         "LAB_PRAZO             PRA, "+
                         "LAB_PRAZO             PRA1, "+
                         "LAB_ORIGEM            ORI, "+
                         "LAB_EXAMETABELAPRECO  ETP1, "+
                         "LAB_TABELA            TAB1, "+
                         "LAB_REGRATABELAPRECO  RTP1, "+
                         "LAB_REGRAS            REG1, "+
                         "LAB_TABELAPRECO       TAP1 "+
                   "WHERE der.exa_st_codigo = dep.exa_st_codigo "+
                     "AND der.uni_st_codigo = dep.uni_st_codigo "+
                     "AND EXU.MET_ST_CODIGO = MET.MET_ST_CODIGO "+
                     "AND EXA.MAT_ST_COLETA = MAT.MAT_ST_CODIGO "+
                     "AND EXU.PRA_ST_CODIGO = PRA.PRA_ST_CODIGO(+) "+
                     "AND EXU.EXU_ST_PRAZOURGENTE = PRA1.PRA_ST_CODIGO(+) "+
                     "AND EXU.EXA_ST_CODIGO = EXM.EXA_ST_CODIGO "+
                     "AND EXU.MET_ST_CODIGO = EXM.MET_ST_CODIGO "+
                     "AND EXU.EXA_ST_CODIGO = EXA.EXA_ST_CODIGO "+
                     "AND EXA.EXA_ST_CODIGO = dep.dep_st_codigo "+
                     "AND ORI.UNI_ST_CODIGO = EXU.UNI_ST_CODIGO "+
                     "AND REG1.uni_st_codigo = RTP1.uni_st_codigo "+
                     "AND REG1.con_st_codigo = RTP1.con_st_codigo "+
                     "AND REG1.reg_st_codigo = RTP1.reg_st_codigo "+
                     "AND ETP1.tap_st_codigo = TAB1.tap_st_codigo "+
                     "AND ETP1.tab_st_codigo = TAB1.tab_st_codigo "+
                     "AND TAB1.TAB_CH_TIPO = '1' "+
                     "AND TAB1.TAB_DT_INICIOVALIDADE = "+
                       "  (SELECT MAX(TAB_DT_INICIOVALIDADE) FROM LAB_TABELA "+
"                           WHERE tap_st_codigo = TAB1.tap_st_codigo "+
  "                               AND tab_st_codigo = TAB1.tab_st_codigo "+
    "                             AND TAB_CH_TIPO = '1' "+
      "                           AND TAB_DT_INICIOVALIDADE <= TO_DATE('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') ) "+
        "             AND TAB1.tap_st_codigo = TAP1.tap_st_codigo "+
          "           AND RTP1.uni_st_codigo = EXU.UNI_ST_CODIGO "+
            "         AND ETP1.exa_st_codigo = EXA.EXA_ST_CODIGO "+
              "       AND RTP1.RTP_DT_INICIOVALIDADE = "+
                "         (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
                  "          FROM LAB_REGRATABELAPRECO "+
                    "       WHERE uni_st_codigo = RTP1.uni_st_codigo "+
                      "       AND con_st_codigo = RTP1.con_st_codigo "+
                        "     AND reg_st_codigo = RTP1.reg_st_codigo "+
                          "   AND RTP_DT_INICIOVALIDADE <= SYSDATE) "+
                     "AND RTP1.RTP_IN_SEQUENCIA = "+
                       "  (SELECT MIN(RTP2.RTP_IN_SEQUENCIA) "+
                         "   FROM LAB_EXAMETABELAPRECO ETP2, "+
                           "      LAB_TABELA           TAB2, "+
                             "    LAB_REGRATABELAPRECO RTP2, "+
                               "  LAB_TABELAPRECO      TAP2 "+
                           "WHERE ETP2.tap_st_codigo = TAB2.tap_st_codigo "+
                             "AND ETP2.tab_st_codigo = TAB2.tab_st_codigo "+
                             "AND TAB2.TAB_CH_TIPO = '1' "+
                             "AND RTP2.uni_st_codigo = RTP2.uni_st_codigo "+
                             "AND RTP2.con_st_codigo = RTP2.con_st_codigo "+
                             "AND RTP2.reg_st_codigo = RTP2.reg_st_codigo "+
                             "AND ETP2.tap_st_codigo = RTP2.tap_st_codigo "+
                             "AND TAB2.tap_st_codigo = TAP2.tap_st_codigo "+
                             "AND RTP2.uni_st_codigo = RTP1.UNI_ST_CODIGO "+
                             "AND RTP2.con_st_codigo = RTP1.CON_ST_CODIGO "+
                             "AND RTP2.reg_st_codigo = RTP1.REG_ST_CODIGO "+
                             "AND ETP2.TAP_ST_CODIGO = ETP2.TAP_ST_CODIGO "+
                             "AND ETP2.exa_st_codigo = ETP1.EXA_ST_CODIGO "+
                             "AND RTP2.RTP_DT_INICIOVALIDADE = "+
                               "  (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
                                 "   FROM LAB_REGRATABELAPRECO "+
                                   "WHERE uni_st_codigo = RTP1.uni_st_codigo "+
                                     "AND con_st_codigo = RTP1.con_st_codigo "+
                                     "AND reg_st_codigo = RTP1.reg_st_codigo "+
                                     "AND tap_st_codigo = ETP1.tap_st_codigo "+
                                     "AND RTP_DT_INICIOVALIDADE = RTP1.Rtp_Dt_Iniciovalidade)) "+
                     "AND EXU.UNI_ST_CODIGO ='"+uniStCodigo+"' "+
//                 '    AND REG1.UNI_ST_CODIGO ='TTT'1' +
                     "AND RTP1.CON_ST_CODIGO ='"+conStCodigo+"' "+
                     "AND RTP1.REG_ST_CODIGO ='"+regStCodigo+"' "+
                     "AND ORI.ORI_ST_CODIGO ='"+oriStCodigo+"' "+
                   "and DER.REQ_ST_CODIGO = '"+reqStCodigo+"'"  ;         //11 '"+reqStCodigo+"'







                  //PreparedStatement preparedStatement = conn.prepareStatement(StaticQuerys.QUERY4EXAMEFORMATADODEPENDENTE);
//                  preparedStatement.setString(1, uniStCodigo);
//                  preparedStatement.setString(2, oriStCodigo);
//                  preparedStatement.setString(3, conStCodigo);
//                  preparedStatement.setString(4, regStCodigo);
//                  preparedStatement.setString(5, reqStCodigo);
//                  preparedStatement.setString(6, sdf.format(reqDtCadastro));
//                  preparedStatement.setString(7, sdf.format(reqDtCadastro));
//                  preparedStatement.setString(8, conStCodigo);
//                  preparedStatement.setString(9, regStCodigo);
//                  preparedStatement.setString(10,oriStCodigo);
//                  preparedStatement.setString(11,reqStCodigo);



                 // ResultSet rs = preparedStatement.executeQuery();
                 ResultSet rs = st.executeQuery(query);

                  while ( rs.next()){

                      //System.out.println("dependente");

                      ExameFormatado ef3 = new ExameFormatado();

                    ef3.setExaStCodigo((LabExame)OracleHelper.getObject(LabExame.class, rs.getString("EXA_ST_CODIGO")) );
                    ef3.setDepStCodigo(rs.getString("DEP_ST_CODIGO"));
                    ef3.setEdiFlDesconto(rs.getFloat("EDI_FL_DESCONTO"));
                    ef3.setEdiFlDescontoExterno(rs.getFloat("EDI_FL_DESCONTOEXTERNO"));
                    ef3.setEtpChComAutorizacao(rs.getString("ETP_CH_COMAUTORIZACAO").charAt(0));
                    ef3.setEtpChNaoAutorizado(rs.getString("ETP_CH_NAOAUTORIZADO").charAt(0));
                    ef3.setEtpFlValorDifenciado(rs.getFloat("ETP_FL_VALORDIFENCIADO"));
                    ef3.setEtpFlValorDifenciadoExterno(rs.getFloat("ETP_FL_VALORDIFENCIADOEXTERNO"));
                    ef3.setExaChInativo(rs.getString("EXA_CH_INATIVO").charAt(0));
                    ef3.setExaChObrigaGestante(rs.getString("EXA_CH_OBRIGAGESTANTE").charAt(0));
                    ef3.setExaChObrigatorioAltura(rs.getString("EXA_CH_OBRIGATORIOALTURA").charAt(0));
                    ef3.setExaChObrigatorioPeso(rs.getString("EXA_CH_OBRIGATORIOPESO").charAt(0));
                    ef3.setExaChSexo(rs.getString("EXA_CH_SEXO").charAt(0));
                    ef3.setExaStDescricao(rs.getString("EXA_ST_DESCRICAO"));
                    ef3.setExaStGrupo(rs.getString("EXA_CH_GRUPO"));
                    ef3.setExmDtValidade(rs.getTimestamp("EXM_DT_VALIDADE"));
                    ef3.setExuChConfereAutomaticoFat(rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0));
                    ef3.setExuChFatura(rs.getString("EXU_CH_FATURA").charAt(0));
                    ef3.setExuChInativo(rs.getString("EXA_CH_INATIVO").charAt(0));//(rs.getString("EXU_CH_INATIVO").charAt(0));
                    ef3.setExuChObrigaMaterial(rs.getString("EXU_CH_OBRIGAMATERIAL").charAt(0));
                    ef3.setExuChPreparo(rs.getString("EXU_CH_PREPARO").charAt(0));
                    //ef.setExuChStatus(rs.getString("EXA_CH_STATUS").charAt(0));//rs.getString("EXU_CH_STATUS").charAt(0));//('N');
                    ef3.setExuStPrazoUrgente(rs.getString("EXU_ST_PRAZOURGENTE"));
                    ef3.setExuStUnidadeEx(rs.getString("EXU_ST_UNIDADEEX"));
                    ef3.setExuStUnidadeExUrgente(rs.getString("EXU_ST_UNIDADEEXURGENTE"));
                    ef3.setLegStCogioInicial(rs.getString("LEG_ST_CODIGOINICIAL"));
                    ef3.setMatStCodigo(rs.getString("MAT_ST_CODIGO"));
                    ef3.setMatStDescricao(rs.getString("MAT_ST_DESCRICAO"));
                    ef3.setMetStCodigo(rs.getString("MET_ST_CODIGO"));
                    ef3.setMetStDescricao(rs.getString("MET_ST_DESCRICAO"));
                    ef3.setMpaStCodigo(rs.getString("MPA_ST_CODIGO"));
                    ef3.setOriChConfereAutomatico(rs.getString("ORI_CH_CONFEREAUTOMATICO").charAt(0));
                    ef3.setOriChConfereAutomaticoFat(rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0));
                    ef3.setOriChUrgencia(rs.getString("ORI_CH_URGENCIA").charAt(0));
                    ef3.setOriStCodigo(rs.getString("ORI_ST_CODIGO"));
                    ef3.setPraChDomingo(rs.getString("PRA_CH_DOMINGO").charAt(0));
                    ef3.setPraChDomingoU(rs.getString("PRA_CH_DOMINGOU").charAt(0));
                    ef3.setPraChQuarta(rs.getString("PRA_CH_QUARTA").charAt(0));
                    ef3.setPraChQuartaU(rs.getString("PRA_CH_QUARTAU").charAt(0));
                    ef3.setPraChQuinta(rs.getString("PRA_CH_QUINTA").charAt(0));
                    ef3.setPraChQuintaU(rs.getString("PRA_CH_QUINTAU").charAt(0));
                    ef3.setPraChSabado(rs.getString("PRA_CH_SABADO").charAt(0));
                    ef3.setPraChSabadoU(rs.getString("PRA_CH_SABADOU").charAt(0));
                    ef3.setPraChSegunda(rs.getString("PRA_CH_SEGUNDA").charAt(0));
                    ef3.setPraChSegundaU(rs.getString("PRA_CH_SEGUNDAU").charAt(0));
                    ef3.setPraChSexta(rs.getString("PRA_CH_SEXTA").charAt(0));
                    ef3.setPraChSextaU(rs.getString("PRA_CH_SEXTAU").charAt(0));
                    ef3.setPraChTerca(rs.getString("PRA_CH_TERCA").charAt(0));
                    ef3.setPraChTercaU(rs.getString("PRA_CH_TERCAU").charAt(0));
                    ef3.setPraHrFinal(rs.getDate("PRA_HR_FINAL"));
                    ef3.setPraHrFinalU(rs.getDate("PRA_HR_FINALU"));
                    ef3.setPraInDias(rs.getInt("PRA_IN_DIAS"));
                    ef3.setPraInDiasU(rs.getInt("PRA_IN_DIASU"));
                    ef3.setPraInHoras(rs.getInt("PRA_IN_HORAS"));
                    ef3.setPraInHorasU(rs.getInt("PRA_IN_HORASU"));
                    ef3.setPraStCodigo(rs.getString("PRA_ST_CODIGO"));
                    ef3.setRegChObrigatorioNumGuia(rs.getString("REG_CH_OBRIGATORIONUMGUIA").charAt(0));
                    ef3.setRtpFlAcrescimo(rs.getFloat("RTP_FL_ACRESCIMO"));
                    ef3.setRtpFlDesconto(rs.getFloat("RTP_FL_DESCONTO"));
                    ef3.setRtpFlDescontoExterno(rs.getFloat("RTP_FL_DESCONTOEXTERNO"));
                    ef3.setRtpFlValorCh(rs.getFloat("RTP_FL_VALORCH"));
                    ef3.setRtpFlValorChExterno(rs.getFloat("RTP_FL_VALORCHEXTERNO"));
                    ef3.setSetStCodigo(rs.getString("SET_ST_CODIGO"));
                    ef3.setTabFlQtDeCh(rs.getFloat("TAB_FL_QTDECH"));
                    ef3.setTabStCodigo(rs.getString("TAB_ST_CODIGO"));
                    /*ef.setTabStDescricao(rs.getString("TAB_ST_DESCRICAO")); */
                    ef3.setTapStCodigo(rs.getString("TAP_ST_CODIGO"));
                    ef3.setTapStDescricao(rs.getString("TAP_ST_DESCRICAO"));
                    ef3.setExuChConfereAutomaticoFat(rs.getString("EXU_CH_CONFEREAUTOMATICOFAT").charAt(0)) ;
                   
                    
                  
                              list.add(ef3);


                  }
                  rs.close();
                  st.close();

                  
 
                  if(list != null && list.size()>0){

                      Map<String,ExameFormatado> map = new HashMap<String, ExameFormatado>();

                       //if(map.size()==0){map.put(list.get(0).getDepStCodigo(),list.get(0));}
                        for(ExameFormatado ef : list){
                            map.put(ef.getDepStCodigo(),ef);
                        }
                        if(map.size()>0){
                            Collection c = map.values();
                            Iterator iter =  c.iterator();
                            while(iter.hasNext()){
                                    listResult.add((ExameFormatado)iter.next());
                            }
                        }

                     return listResult;

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());
                   se.printStackTrace();
                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                    System.out.println(xcp);
                   return null;
                }finally{
                    if(conn != null){
                            try {
                                //System.out.println("Closing Oracle Connection. for getListExameFomatadoDependente");
                                conn.close();
                            }catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println(ex);
                                System.err.println(ex);

                            }
                  }
                }




    }



       public static List<ExameFormatado>  getListExameFormatadoGrupo2Steps(String uniStCodigo, String  conStCodigo, String regStCodigo, String oriStCodigo, String exaStCodigo,Date reqDtCadastro,int qd ){

                conn = connectByC3p0();//connectOrDie();
                List<ExameFormatado> list = new ArrayList<ExameFormatado>();

                try{

                String DATE_FORMAT = "yyyy/MM/dd";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

                String query =
                          "SELECT "+
 "0        AS TAB_FL_QTDECH, "+
  "0             AS RTP_FL_VALORCH, "+
  "0             AS RTP_FL_VALORCHEXTERNO, "+
  "0             AS RTP_FL_DESCONTO, "+
  "0             AS RTP_FL_DESCONTOEXTERNO, "+
  "0             AS RTP_FL_ACRESCIMO, "+
  "EXD_ST_TABELA AS TAP_ST_CODIGO, "+
  "REG.REG_CH_OBRIGATORIONUMGUIA, "+
  "EXD_ST_CODIGO           AS TAB_ST_CODIGO, "+
  "''                      AS TAP_ST_DESCRICAO, "+
  "EDI.EDI_FL_VALOR        AS ETP_FL_VALORDIFENCIADO, "+
  "EDI.EDI_FL_VALOREXTERNO AS ETP_FL_VALORDIFENCIADOEXTERNO, "+
  "EDI.EDI_FL_DESCONTO, "+
  "EDI.EDI_FL_DESCONTOEXTERNO, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
    "END "+
  "FROM LAB_EXAMESCOMAUTORIZACAO "+
  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
 " ) AS ETP_ch_comautorizacao, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
    "END "+
 " FROM LAB_EXAMENAOAUTORIZADOS "+
  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
  ") AS ETP_ch_naoautorizado, "+
  "(SELECT EXA_CH_OBRIGAGESTANTE FROM LAB_EXAME WHERE EXA_ST_CODIGO= '"+exaStCodigo+"'  "+ //'"+sdf.format(reqDtCadastro)+"'
  ") AS EXA_CH_OBRIGAGESTANTE, "+
  "(SELECT EXA_CH_SEXO FROM LAB_EXAME WHERE EXA_ST_CODIGO= '"+exaStCodigo+"' "+
  ") AS EXA_CH_SEXO, "+
  "MAT.MAT_ST_CODIGO, "+
  "MAT.MAT_ST_DESCRICAO, "+
  "EXG.EXA_ST_CODIGO, "+
  "EXA.EXA_CH_OBRIGATORIOPESO, "+
  "EXA.EXA_ST_DESCRICAO, "+
  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
  "EXA.EXA_CH_OBRIGAGESTANTE, "+
  "EXA.EXA_CH_SEXO, "+
  "EXA.EXA_CH_GRUPO, "+
  "EXA.EXA_CH_INATIVO, "+
  "EXU.EXU_CH_PREPARO, "+
  "EXU.MPA_ST_CODIGO, "+
  "EXU.MET_ST_CODIGO, "+
  "EXU.EXU_CH_obrigamaterial, "+
  "EXU.PRA_ST_CODIGO, "+
  "EXU.EXU_ST_PRAZOURGENTE, "+
  "EXU.EXU_ST_UNIDADEEX, "+
  "EXU.SET_ST_CODIGO, "+
  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
  "PRA.PRA_IN_DIAS, "+
  "PRA.PRA_IN_HORAS AS pra_in_horas, "+
  "PRA.PRA_CH_DOMINGO, "+
  "PRA.PRA_CH_SEGUNDA, "+
  "PRA.PRA_CH_TERCA, "+
  "PRA.PRA_CH_QUARTA, "+
  "PRA.PRA_CH_QUINTA, "+
  "PRA.PRA_CH_SEXTA, "+
  "PRA.PRA_CH_SABADO, "+
  "PRA.PRA_HR_FINAL, "+
  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
  "MET.MET_ST_DESCRICAO, "+
  "ORI.ORI_ST_CODIGO, "+
  "ORI.ORI_CH_URGENCIA, "+
  "ORI.LEG_ST_CODIGOINICIAL, "+
  "ORI.ORI_CH_CONFEREAUTOMATICO, "+
  "ORI.ORI_CH_CONFEREAUTOMATICOFAT, "+
  "EXM.EXM_DT_VALIDADE, "+
  "CASE "+
   " WHEN (EXU.EXU_CH_NAONECESSARIO = 'S' "+
    "OR EXG.EXG_CH_OMITE            = 'S') "+
    "THEN 'S' "+
    "ELSE 'N' "+
  "END AS EXU_CH_NAONECESSARIO, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
    "END "+
  "FROM LAB_EXAMENAOAUTORIZADOS "+
  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
  ") AS ETP_ch_naoautorizadoG, "+
  "EXU.EXU_CH_SOFATURAMENTO, "+
  "EXU.EXU_CH_FATURA, "+
  "EXG.SEQ_ST_CODIGO, "+
  "EXG.EXG_CH_FATURA, "+
  "SEQ.SEQ_ST_DESCRICAO, "+
  "(SELECT EXMG.EXM_DT_VALIDADE "+
  "FROM LAB_EXAMEMETODO EXMG "+
  "WHERE EXMG.EXA_ST_CODIGO ='"+exaStCodigo+"' "+
  "AND EXMG.MET_ST_CODIGO   = "+
   " (SELECT MET_ST_CODIGO "+
    "FROM LAB_EXAMEUNIDADE "+
    "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
    "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
   " ) "+
 " ) AS EXM_DT_VALIDADEGRUPO, "+
  "(SELECT EXUG.EXU_CH_FATURAGRUPO "+
  "FROM LAB_EXAMEUNIDADE EXUG "+
  "WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
 " ) AS EXU_CH_FATURAGRUPO, "+
  "(SELECT EXAG1.EXA_ST_DESCRICAO "+
  "FROM LAB_EXAME EXAG1 "+
  "WHERE EXAG1.EXA_ST_CODIGO = EXG.EXA_ST_CODIGO "+
  ") AS EXA_ST_DESCRICAOGRUPO, "+
  "(SELECT EXUG.EXU_CH_INATIVO "+
  "FROM LAB_EXAMEUNIDADE EXUG "+
  "WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
" ) AS EXU_CH_INATIVOG, "+
  "(SELECT MET_ST_CODIGO "+
  "FROM LAB_EXAMEUNIDADE "+
  "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
" )        AS MET_ST_CODIGOGRP, "+
 " '      ' AS UNIDADEEX "+
"FROM LAB_EXAMESDIFERENCIADOS EDI, "+
 " LAB_REGRAS REG, "+
  "LAB_EXAMEUNIDADE EXU, "+
  "LAB_ORIGEM ORI, "+
  "LAB_PRAZO PRA1, "+
  "LAB_PRAZO PRA, "+
  "LAB_EXAME EXA, "+
  "LAB_EXAMEMETODO EXM, "+
  "LAB_METODO MET, "+
  "LAB_SEQUENCIAAMOSTRA SEQ, "+
  "LAB_MATERIAL MAT, "+
  "LAB_EXAMEGRUPO EXG "+
"WHERE EDI.UNI_ST_CODIGO     = REG.UNI_ST_CODIGO "+
"AND EDI.CON_ST_CODIGO       = REG.CON_ST_CODIGO "+
"AND EDI.REG_ST_CODIGO       = REG.REG_ST_CODIGO "+
"AND EDI.UNI_ST_CODIGO       = EXU.UNI_ST_CODIGO "+
"AND EDI.EXA_ST_CODIGO       = EXU.EXA_ST_CODIGO "+
"AND EDI.UNI_ST_CODIGO       = ORI.UNI_ST_CODIGO "+
"AND EXU.EXA_ST_CODIGO       = EXA.EXA_ST_CODIGO "+
"AND EXU.EXU_ST_PRAZOURGENTE = PRA1.PRA_ST_CODIGO(+) "+
"AND EXU.PRA_ST_CODIGO       = PRA.PRA_ST_CODIGO(+) "+
"AND EXU.EXA_ST_CODIGO       = EXM.EXA_ST_CODIGO(+) "+
"AND EXU.MET_ST_CODIGO       = EXM.MET_ST_CODIGO(+) "+
"AND EXU.MET_ST_CODIGO       = MET.MET_ST_CODIGO(+) "+
"AND EXA.MAT_ST_COLETA       = MAT.MAT_ST_CODIGO(+) "+
"AND EXG.SEQ_ST_CODIGO       = SEQ.SEQ_ST_CODIGO (+) "+
"AND EXG.UNI_ST_CODIGO       = EDI.UNI_ST_CODIGO (+) "+
"AND EXG.EXA_ST_CODIGO       = EDI.EXA_ST_CODIGO (+) "+
"AND EXG.UNI_ST_CODIGO       ='"+uniStCodigo+"' "+
"AND EXG.GRP_ST_CODIGO       ='"+exaStCodigo+"' "+
"AND ORI.ORI_ST_CODIGO       ='"+oriStCodigo+"' "+
"AND EDI.CON_ST_CODIGO       ='"+conStCodigo+"' "+
"AND EDI.REG_ST_CODIGO       ='"+regStCodigo+"' "+
"AND EDI_DT_INICIOVALIDADE   = "+
 " (SELECT MAX(EDI_DT_INICIOVALIDADE) "+
  "FROM LAB_EXAMESDIFERENCIADOS "+
  "WHERE UNI_ST_CODIGO        = EDI.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO          = EDI.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO          = EDI.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO          = EDI.EXA_ST_CODIGO "+
  "AND EDI_DT_INICIOVALIDADE <= TO_DATE ('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+  /*  ('+#39 + cData_InicioValidade + #39+','+Quotedstr(YYYY-MM-DD) */
"  ) ";
                

String query2 =
"UNION ALL "+

"SELECT TAB1.TAB_FL_QTDECH, "+
  "RTP1.rtp_fl_valorch, "+
  "RTP1.RTP_FL_VALORCHEXTERNO, "+
  "RTP1.rtp_fl_desconto, "+
  "RTP1.rtp_fl_descontoEXTERNO, "+
  "RTP1.rtp_fl_acrescimo, "+
  "RTP1.TAP_ST_CODIGO, "+
  "REG1.REG_CH_OBRIGATORIONUMGUIA, "+
  "TAB1.TAB_ST_CODIGO, "+
  "TAP1.tap_st_descricao, "+
  "0 AS ETP_fl_valordifenciado, "+
  "0 AS ETP_fl_valordifenciadoExterno, "+
  "0 AS EDI_FL_DESCONTO, "+
  "0 AS EDI_FL_DESCONTOEXTERNO, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
   " END "+
  "FROM LAB_EXAMESCOMAUTORIZACAO "+
  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
"  ) AS ETP_ch_comautorizacao, "+
  "(SELECT "+
   " CASE "+
     " WHEN COUNT(*) > 0 "+
      "THEN 'S' "+
      "ELSE 'N' "+
    "END "+
  "FROM LAB_EXAMENAOAUTORIZADOS "+
  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
 " ) AS ETP_ch_naoautorizado, "+
 " (SELECT EXA_CH_OBRIGAGESTANTE FROM LAB_EXAME WHERE EXA_ST_CODIGO='"+exaStCodigo+"' "+
"  ) AS EXA_CH_OBRIGAGESTANTE, "+
 " (SELECT EXA_CH_SEXO FROM LAB_EXAME WHERE EXA_ST_CODIGO='"+exaStCodigo+"' "+
"  ) AS EXA_CH_SEXO, "+
  "MAT.MAT_ST_CODIGO, "+
  "MAT.MAT_ST_DESCRICAO, "+
  "EXA.EXA_ST_CODIGO, "+
  "EXA.EXA_CH_OBRIGATORIOPESO, "+
  "EXA.EXA_ST_DESCRICAO, "+
  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
  "EXA.EXA_CH_OBRIGAGESTANTE, "+
  "EXA.EXA_CH_SEXO, "+
  "EXA.EXA_CH_GRUPO, "+
  "EXA.EXA_CH_INATIVO, "+
  "EXU.EXU_CH_PREPARO, "+
  "EXU.MPA_ST_CODIGO, "+
  "EXU.MET_ST_CODIGO, "+
  "EXU.EXU_CH_obrigamaterial, "+
  "EXU.PRA_ST_CODIGO, "+
  "EXU.EXU_ST_PRAZOURGENTE, "+
  "EXU.EXU_ST_UNIDADEEX, "+
  "EXU.SET_ST_CODIGO, "+
  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
  "PRA.PRA_IN_DIAS, "+
  "PRA.PRA_IN_HORAS AS pra_in_horas, "+
  "PRA.PRA_CH_DOMINGO, "+
  "PRA.PRA_CH_SEGUNDA, "+
  "PRA.PRA_CH_TERCA, "+
  "PRA.PRA_CH_QUARTA, "+
  "PRA.PRA_CH_QUINTA, "+
  "PRA.PRA_CH_SEXTA, "+
  "PRA.PRA_CH_SABADO, "+
  "PRA.PRA_HR_FINAL, "+
  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
  "MET.MET_ST_DESCRICAO, "+
  "ORI.ORI_ST_CODIGO, "+
  "ORI.ORI_CH_URGENCIA, "+
  "ORI.LEG_ST_CODIGOINICIAL, "+
  "ORI_CH_CONFEREAUTOMATICO, "+
  "ORI_CH_CONFEREAUTOMATICOFAT, "+
  "EXM.EXM_DT_VALIDADE, "+
  "CASE "+
   " WHEN (EXU.EXU_CH_NAONECESSARIO = 'S' "+
    "OR EXG.EXG_CH_OMITE            = 'S') "+
    "THEN 'S' "+
    "ELSE 'N' "+
  "END AS EXU_CH_NAONECESSARIO, "+
  "(SELECT "+
   " CASE "+
    "  WHEN COUNT(*) > 0 "+
     " THEN 'S' "+
      "ELSE 'N' "+
   " END "+
  "FROM LAB_EXAMENAOAUTORIZADOS "+
  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
"  ) AS ETP_ch_naoautorizadoG, "+
  "EXU.EXU_CH_SOFATURAMENTO, "+
  "EXU.EXU_CH_FATURA, "+
  "EXG.SEQ_ST_CODIGO, "+
  "EXG.EXG_CH_FATURA, "+
  "SEQ.SEQ_ST_DESCRICAO, "+
"  (SELECT EXMG.EXM_DT_VALIDADE "+
  "FROM LAB_EXAMEMETODO EXMG "+
  "WHERE EXMG.EXA_ST_CODIGO ='"+exaStCodigo+"' "+
  "AND EXMG.MET_ST_CODIGO   = "+
   " (SELECT MET_ST_CODIGO "+
    "FROM LAB_EXAMEUNIDADE "+
    "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
    "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
  "  ) "+
"  ) AS EXM_DT_VALIDADEGRUPO, "+
  "(SELECT EXUG.EXU_CH_FATURAGRUPO "+
  "FROM LAB_EXAMEUNIDADE EXUG "+
  "WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
" ) AS EXU_CH_FATURAGRUPO, "+
 " (SELECT EXAG1.EXA_ST_DESCRICAO "+
 " FROM LAB_EXAME EXAG1 "+
  "WHERE EXAG1.EXA_ST_CODIGO = EXG.GRP_ST_CODIGO "+
" ) AS EXA_ST_DESCRICAOGRUPO, "+
 " (SELECT EXUG.EXU_CH_INATIVO "+
 " FROM LAB_EXAMEUNIDADE EXUG "+
 " WHERE EXUG.UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
  "AND EXUG.EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
"  ) AS EXU_CH_INATIVOG, "+
  "(SELECT MET_ST_CODIGO "+
  "FROM LAB_EXAMEUNIDADE "+
  "WHERE UNI_ST_CODIGO = EXG.UNI_ST_CODIGO "+
  "AND EXA_ST_CODIGO   = EXG.GRP_ST_CODIGO "+
" )        AS MET_ST_CODIGOGRP, "+
 " '      ' AS UNIDADEEX "+
"FROM LAB_EXAMEGRUPO EXG, "+
 " LAB_EXAME EXA, "+
  "LAB_EXAMEUNIDADE EXU, "+
  "LAB_METODO MET, "+
  "LAB_MATERIAL MAT, "+
  "LAB_EXAMEMETODO EXM, "+
  "LAB_SEQUENCIAAMOSTRA SEQ, "+
  "LAB_PRAZO PRA, "+
  "LAB_PRAZO PRA1, "+
  "LAB_ORIGEM ORI, "+
  "LAB_EXAMETABELAPRECO ETP1, "+
  "LAB_TABELA TAB1, "+
  "LAB_REGRATABELAPRECO RTP1, "+
  "LAB_TABELAPRECO TAP1, "+
  "LAB_REGRAS REG1 "+
"WHERE EXG.EXA_ST_CODIGO        = EXA.EXA_ST_CODIGO "+
"AND EXU.MET_ST_CODIGO          = MET.MET_ST_CODIGO "+
"AND EXU.EXA_ST_CODIGO          = EXM.EXA_ST_CODIGO "+
"AND EXU.MET_ST_CODIGO          = EXM.MET_ST_CODIGO "+
"AND EXA.MAT_ST_COLETA          = MAT.MAT_ST_CODIGO "+
"AND EXU.EXA_ST_CODIGO          = EXA.EXA_ST_CODIGO "+
"AND EXU.PRA_ST_CODIGO          = PRA.PRA_ST_CODIGO(+) "+
"AND EXU.EXU_ST_PRAZOURGENTE    = PRA1.PRA_ST_CODIGO(+) "+
"AND EXG.SEQ_ST_CODIGO          = SEQ.SEQ_ST_CODIGO "+
"AND ORI.UNI_ST_CODIGO          = EXU.UNI_ST_CODIGO "+
"AND ETP1.tap_st_codigo         = TAB1.tap_st_codigo "+
"AND ETP1.tab_st_codigo         = TAB1.tab_st_codigo "+
"AND TAB1.TAB_CH_TIPO           = '1' "+
"AND TAB1.TAB_DT_INICIOVALIDADE = "+
  "(SELECT MAX(TAB_DT_INICIOVALIDADE) "+
  "FROM LAB_TABELA "+
  "WHERE tap_st_codigo        = TAB1.tap_st_codigo "+
  "AND tab_st_codigo          = TAB1.tab_st_codigo "+
  "AND TAB_CH_TIPO            = '1' "+
  "AND TAB_DT_INICIOVALIDADE <= TO_DATE ('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+ /**/
  ") "+
"AND REG1.uni_st_codigo         = RTP1.uni_st_codigo "+
"AND REG1.con_st_codigo         = RTP1.con_st_codigo "+
"AND REG1.reg_st_codigo         = RTP1.reg_st_codigo "+
"AND ETP1.tap_st_codigo         = RTP1.tap_st_codigo "+
"AND TAB1.tap_st_codigo         = TAP1.tap_st_codigo "+
"AND RTP1.uni_st_codigo         = EXU.UNI_ST_CODIGO "+
"AND ETP1.exa_st_codigo         = EXA.EXA_ST_CODIGO "+
"AND RTP1.RTP_DT_INICIOVALIDADE = "+
 " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
  "FROM LAB_REGRATABELAPRECO "+
  "WHERE uni_st_codigo        = RTP1.uni_st_codigo "+
  "AND con_st_codigo          = RTP1.con_st_codigo "+
  "AND reg_st_codigo          = RTP1.reg_st_codigo "+
  "AND RTP_DT_INICIOVALIDADE <= SYSDATE "+
  "AND RTP1.RTP_IN_SEQUENCIA  = "+
   " (SELECT MIN(RTP2.RTP_IN_SEQUENCIA) "+
    "FROM LAB_EXAMETABELAPRECO ETP2, "+
     " LAB_TABELA TAB2, "+
      "LAB_REGRATABELAPRECO RTP2, "+
      "LAB_TABELAPRECO TAP2 "+
    "WHERE ETP2.tap_st_codigo       = TAB2.tap_st_codigo "+
    "AND ETP2.tab_st_codigo         = TAB2.tab_st_codigo "+
    "AND TAB2.TAB_CH_TIPO           = '1' "+
    "AND RTP2.uni_st_codigo         = RTP2.uni_st_codigo "+
    "AND RTP2.con_st_codigo         = RTP2.con_st_codigo "+
    "AND RTP2.reg_st_codigo         = RTP2.reg_st_codigo "+
    "AND ETP2.tap_st_codigo         = RTP2.tap_st_codigo "+
    "AND TAB2.tap_st_codigo         = TAP2.tap_st_codigo "+
    "AND RTP2.uni_st_codigo         = RTP1.UNI_ST_CODIGO "+
    "AND RTP2.con_st_codigo         = RTP1.CON_ST_CODIGO "+
    "AND RTP2.reg_st_codigo         = RTP1.REG_ST_CODIGO "+
    "AND ETP2.TAP_ST_CODIGO         = ETP2.TAP_ST_CODIGO "+
    "AND ETP2.exa_st_codigo         = ETP1.EXA_ST_CODIGO "+
    "AND RTP2.RTP_DT_INICIOVALIDADE = "+
     " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
      "FROM LAB_REGRATABELAPRECO "+
      "WHERE uni_st_codigo       = RTP1.uni_st_codigo "+
      "AND con_st_codigo         = RTP1.con_st_codigo "+
      "AND reg_st_codigo         = RTP1.reg_st_codigo "+
      "AND tap_st_codigo         = ETP1.tap_st_codigo "+
      "AND RTP_DT_INICIOVALIDADE = RTP1.Rtp_Dt_Iniciovalidade "+
      ") "+
    ") "+
  ") "+
"AND EXU.UNI_ST_CODIGO ='"+exaStCodigo+"' "+
"AND EXG.UNI_ST_CODIGO ='"+uniStCodigo+"' "+
"AND RTP1.CON_ST_CODIGO='"+conStCodigo+"' "+
"AND RTP1.REG_ST_CODIGO='"+regStCodigo+"' "+
"AND ORI.ORI_ST_CODIGO ='"+oriStCodigo+"' "+
"AND EXG.GRP_ST_CODIGO ='"+exaStCodigo+"' ";




                  PreparedStatement preparedStatement = conn.prepareStatement(StaticQuerys.QUERY4EXAMEFORMATADOGRUPO);
                  preparedStatement.setString(1, exaStCodigo);
                  preparedStatement.setString(2, exaStCodigo);
                  preparedStatement.setString(3, exaStCodigo);
                  preparedStatement.setString(4, uniStCodigo);
                  preparedStatement.setString(5, exaStCodigo);
                  preparedStatement.setString(6, oriStCodigo);
                  preparedStatement.setString(7, conStCodigo);
                  preparedStatement.setString(8, regStCodigo);
                  preparedStatement.setString(9, sdf.format(reqDtCadastro));
                  preparedStatement.setString(10,exaStCodigo);
                  preparedStatement.setString(11, exaStCodigo);
                  preparedStatement.setString(12, exaStCodigo);
                  preparedStatement.setString(13, sdf.format(reqDtCadastro));
                  preparedStatement.setString(14, uniStCodigo);
                  preparedStatement.setString(15, uniStCodigo);
                  preparedStatement.setString(16, conStCodigo);
                  preparedStatement.setString(17, regStCodigo);
                  preparedStatement.setString(18, oriStCodigo);
                  preparedStatement.setString(19, exaStCodigo);

                    //conn.prepareStatement(StaticQuerys.QUERY4EXAMEFORMATADOGRUPO);
                   //Statement st = conn.createStatement();
                  //ResultSet rs = st.executeQuery(query);
                  ResultSet rs = preparedStatement.executeQuery();



                  while ( rs.next()){

                  ExameFormatado ef2 = new ExameFormatado();
                    ef2.setDepStCodigo("NI");//(rs.getString("DEP_ST_CODIGO"));
                    ef2.setEdiFlDesconto(rs.getFloat("EDI_FL_DESCONTO"));
                    ef2.setEdiFlDescontoExterno(rs.getFloat("EDI_FL_DESCONTOEXTERNO"));
                    ef2.setEtpChComAutorizacao(rs.getString("ETP_CH_COMAUTORIZACAO").charAt(0));
                    ef2.setEtpChNaoAutorizado(rs.getString("ETP_CH_NAOAUTORIZADO").charAt(0));
                    ef2.setEtpFlValorDifenciado(rs.getFloat("ETP_FL_VALORDIFENCIADO"));
                    ef2.setEtpFlValorDifenciadoExterno(rs.getFloat("ETP_FL_VALORDIFENCIADOEXTERNO"));
                    ef2.setExaChInativo(rs.getString("EXA_CH_INATIVO").charAt(0));
                    ef2.setExaChObrigaGestante(rs.getString("EXA_CH_OBRIGAGESTANTE").charAt(0));
                    ef2.setExaChObrigatorioAltura(rs.getString("EXA_CH_OBRIGATORIOALTURA").charAt(0));
                    ef2.setExaChObrigatorioPeso(rs.getString("EXA_CH_OBRIGATORIOPESO").charAt(0));
                    ef2.setExaChSexo(rs.getString("EXA_CH_SEXO").charAt(0));
                    ef2.setExaStCodigo((LabExame)OracleHelper.getObject(LabExame.class, rs.getString("EXA_ST_CODIGO")) );
                    ef2.setExaStDescricao(rs.getString("EXA_ST_DESCRICAO"));
                    ef2.setExaStGrupo(rs.getString("EXA_CH_GRUPO"));
                    ef2.setExmDtValidade(rs.getTimestamp("EXM_DT_VALIDADE"));
                    ef2.setExuChConfereAutomaticoFat(rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0));
                    ef2.setExuChFatura(rs.getString("EXU_CH_FATURA").charAt(0));
                    ef2.setExuChInativo('N');//(rs.getString("EXU_CH_INATIVO").charAt(0));
                    ef2.setExuChNaoNecessario(rs.getString("EXU_CH_NAONECESSARIO").charAt(0));
                    ef2.setExuChObrigaMaterial(rs.getString("EXU_CH_OBRIGAMATERIAL").charAt(0));
                    ef2.setExuChPreparo(rs.getString("EXU_CH_PREPARO").charAt(0));
                    ef2.setExuChStatus('N');//rs.getString("EXU_CH_STATUS").charAt(0));//('N');
                    ef2.setExuStPrazoUrgente(rs.getString("EXU_ST_PRAZOURGENTE"));
                    ef2.setExuStUnidadeEx(rs.getString("EXU_ST_UNIDADEEX"));
                    ef2.setExuStUnidadeExUrgente(rs.getString("EXU_ST_UNIDADEEXURGENTE"));
                    ef2.setLegStCogioInicial(rs.getString("LEG_ST_CODIGOINICIAL"));
                    ef2.setMatStCodigo(rs.getString("MAT_ST_CODIGO"));
                    ef2.setMatStDescricao(rs.getString("MAT_ST_DESCRICAO"));
                    ef2.setMetStCodigo(rs.getString("MET_ST_CODIGO"));
                    ef2.setMetStDescricao(rs.getString("MET_ST_DESCRICAO"));
                    ef2.setMpaStCodigo(rs.getString("MPA_ST_CODIGO"));
                    ef2.setOriChConfereAutomatico(rs.getString("ORI_CH_CONFEREAUTOMATICO").charAt(0));
                    ef2.setOriChConfereAutomaticoFat(rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0));
                    ef2.setOriChUrgencia(rs.getString("ORI_CH_URGENCIA").charAt(0));
                    ef2.setOriStCodigo(rs.getString("ORI_ST_CODIGO"));
                    ef2.setPraChDomingo(rs.getString("PRA_CH_DOMINGO").charAt(0));
                    ef2.setPraChDomingoU(rs.getString("PRA_CH_DOMINGOU").charAt(0));
                    ef2.setPraChQuarta(rs.getString("PRA_CH_QUARTA").charAt(0));
                    ef2.setPraChQuartaU(rs.getString("PRA_CH_QUARTAU").charAt(0));
                    ef2.setPraChQuinta(rs.getString("PRA_CH_QUINTA").charAt(0));
                    ef2.setPraChQuintaU(rs.getString("PRA_CH_QUINTAU").charAt(0));
                    ef2.setPraChSabado(rs.getString("PRA_CH_SABADO").charAt(0));
                    ef2.setPraChSabadoU(rs.getString("PRA_CH_SABADOU").charAt(0));
                    ef2.setPraChSegunda(rs.getString("PRA_CH_SEGUNDA").charAt(0));
                    ef2.setPraChSegundaU(rs.getString("PRA_CH_SEGUNDAU").charAt(0));
                    ef2.setPraChSexta(rs.getString("PRA_CH_SEXTA").charAt(0));
                    ef2.setPraChSextaU(rs.getString("PRA_CH_SEXTAU").charAt(0));
                    ef2.setPraChTerca(rs.getString("PRA_CH_TERCA").charAt(0));
                    ef2.setPraChTercaU(rs.getString("PRA_CH_TERCAU").charAt(0));
                    ef2.setPraHrFinal(rs.getDate("PRA_HR_FINAL"));
                    ef2.setPraHrFinalU(rs.getDate("PRA_HR_FINALU"));
                    ef2.setPraInDias(rs.getInt("PRA_IN_DIAS"));
                    ef2.setPraInDiasU(rs.getInt("PRA_IN_DIASU"));
                    ef2.setPraInHoras(rs.getInt("PRA_IN_HORAS"));
                    ef2.setPraInHorasU(rs.getInt("PRA_IN_HORASU"));
                    ef2.setPraStCodigo(rs.getString("PRA_ST_CODIGO"));
                    ef2.setRegChObrigatorioNumGuia(rs.getString("REG_CH_OBRIGATORIONUMGUIA").charAt(0));
                    ef2.setRtpFlAcrescimo(rs.getFloat("RTP_FL_ACRESCIMO"));
                    ef2.setRtpFlDesconto(rs.getFloat("RTP_FL_DESCONTO"));
                    ef2.setRtpFlDescontoExterno(rs.getFloat("RTP_FL_DESCONTOEXTERNO"));
                    ef2.setRtpFlValorCh(rs.getFloat("RTP_FL_VALORCH"));
                    ef2.setRtpFlValorChExterno(rs.getFloat("RTP_FL_VALORCHEXTERNO"));
                    ef2.setSetStCodigo(rs.getString("SET_ST_CODIGO"));
                    ef2.setTabFlQtDeCh(rs.getFloat("TAB_FL_QTDECH"));
                    ef2.setTabStCodigo(rs.getString("TAB_ST_CODIGO"));
                    /*ef.setTabStDescricao(rs.getString("TAB_ST_DESCRICAO")); */
                    ef2.setTapStCodigo(rs.getString("TAP_ST_CODIGO"));
                    ef2.setTapStDescricao(rs.getString("TAP_ST_DESCRICAO"));
                    ef2.setExuChConfereAutomaticoFat(rs.getString("EXU_CH_CONFEREAUTOMATICOFAT").charAt(0)) ;


                              list.add(ef2);


                  }
                  rs.close();
                  preparedStatement.close();

                  if(list != null && list.size()>0){

                      List<ExameFormatado> myList = new ArrayList<ExameFormatado>();

                      for(ExameFormatado e : list){
                          if(!e.getEtpChNaoAutorizado().toString().equalsIgnoreCase("S") ){ //e.getEtpFlValorDifenciado()>0 &&
                                myList.add(e);

                          }
                      }


                     return myList;

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());
                   se.printStackTrace();
                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                    System.out.println(xcp);
                   return null;
                }finally{
                    if(conn != null){
                            try {
                                //System.out.println("Closing Oracle Connection. for getListExameFomatadoGrupo");
                                conn.close();
                            }catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println(ex);
                                System.err.println(ex);

                            }
                  }
                }




    }






@Deprecated 
         public static List<ExameFormatado>  getListExameFormatadoGrupo(String uniStCodigo, String  conStCodigo, String regStCodigo, String oriStCodigo, String exaStCodigo,Date reqDtCadastro ,List<LabExameGrupo> listLabExameGrupo){

                conn = connectByC3p0();//connectOrDie();
                List<ExameFormatado> list = new ArrayList<ExameFormatado>();
                List<ExameFormatado> result = new ArrayList<ExameFormatado>();
                String DATE_FORMAT = "yyyy/MM/dd";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);



                for(LabExameGrupo leg : listLabExameGrupo){


                     String query2 =
                        "SELECT "+
                                  "0        AS TAB_FL_QTDECH, "+
                                  "0             AS RTP_FL_VALORCH, "+
                                  "0             AS RTP_FL_VALORCHEXTERNO, "+
                                  "0             AS RTP_FL_DESCONTO, "+
                                  "0             AS RTP_FL_DESCONTOEXTERNO, "+
                                  "0             AS RTP_FL_ACRESCIMO, "+
                                  "EXD_ST_TABELA AS TAP_ST_CODIGO, "+
                                  "REG.REG_CH_OBRIGATORIONUMGUIA, "+

                                  "EXD_ST_CODIGO           AS TAB_ST_CODIGO, "+
                                  "''                      AS TAP_ST_DESCRICAO, "+
                                  "EDI.EDI_FL_VALOR        AS ETP_FL_VALORDIFENCIADO, "+
                                  "EDI.EDI_FL_VALOREXTERNO AS ETP_FL_VALORDIFENCIADOEXTERNO, "+
                                  "EDI.EDI_FL_DESCONTO, "+
                                  "EDI.EDI_FL_DESCONTOEXTERNO, "+
                                  "(SELECT "+
                                   " CASE "+
                                    "  WHEN COUNT(*) > 0 "+
                                     " THEN 'S' "+
                                      "ELSE 'N' "+
                                    "END "+
                                  "FROM LAB_EXAMESCOMAUTORIZACAO "+
                                  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
                                  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
                                  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
                                  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
                                 " ) AS ETP_ch_comautorizacao, "+
                                  "(SELECT "+
                                   " CASE "+
                                    "  WHEN COUNT(*) > 0 "+
                                     " THEN 'S' "+
                                      "ELSE 'N' "+
                                    "END "+
                                  "FROM LAB_EXAMENAOAUTORIZADOS "+
                                  "WHERE UNI_ST_CODIGO = EDI.UNI_ST_CODIGO "+
                                  "AND CON_ST_CODIGO   = EDI.CON_ST_CODIGO "+
                                  "AND REG_ST_CODIGO   = EDI.REG_ST_CODIGO "+
                                  "AND EXA_ST_CODIGO   = EDI.EXA_ST_CODIGO "+
                                "  ) AS ETP_ch_naoautorizado, "+
                                  "MAT.MAT_ST_CODIGO, "+
                                  "MAT.MAT_ST_DESCRICAO, "+
                                  "EXA.EXA_CH_OBRIGATORIOPESO, "+
                                  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
                                  "EXA.EXA_CH_OBRIGAGESTANTE, "+
                                  "EXA.EXA_CH_SEXO, "+
                                  "EXU.MPA_ST_CODIGO, "+
                                  "EXA.EXA_ST_DESCRICAO, "+
                                  "EXA.EXA_CH_GRUPO, "+
                                  "EXU.MET_ST_CODIGO, "+
                                  "MET.MET_ST_DESCRICAO, "+
                                  "EXM.EXM_DT_VALIDADE, "+
                                  "EXU.EXU_CH_STATUS, "+
                                  "EXU.EXU_CH_FATURA, "+
                                  "EXA.EXA_CH_INATIVO, "+
                                  "EXU.EXU_CH_INATIVO, "+
                                  "EXU.EXU_CH_PREPARO, "+
                                  "EXU.EXU_CH_OBRIGAMATERIAL, "+
                                  "EXU.PRA_ST_CODIGO, "+
                                  "PRA.PRA_IN_DIAS, "+
                                  "PRA.PRA_CH_DOMINGO, "+
                                  "PRA.PRA_CH_SEGUNDA, "+
                                  "PRA.PRA_CH_TERCA, "+
                                  "PRA.PRA_CH_QUARTA, "+
                                  "PRA.PRA_CH_QUINTA, "+
                                  "PRA.PRA_CH_SEXTA, "+
                                 " PRA.PRA_CH_SABADO, "+
                                  "PRA.PRA_HR_FINAL, "+
                                  "PRA.PRA_IN_HORAS    AS pra_in_horas, "+
                                  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
                                  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
                                  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
                                  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
                                  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
                                  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
                                  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
                                  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
                                  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
                                  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
                                  "EXU.EXU_ST_PRAZOURGENTE, "+
                                  "EXU.EXU_CH_NAONECESSARIO, "+
                                  "ORI.ORI_ST_CODIGO, "+
                                  "ORI.ORI_CH_URGENCIA, "+
                                  "ORI.LEG_ST_CODIGOINICIAL, "+
                                  "ORI.ORI_CH_CONFEREAUTOMATICO, "+
                                  "ORI.ORI_CH_CONFEREAUTOMATICOFAT, "+
                                  "EXU.SET_ST_CODIGO, "+
                                  "EXU.EXU_ST_UNIDADEEX, "+
                                  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
                                  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
                                  "(SELECT MAX(EXA_ST_CODIGO) "+
                                  "FROM LAB_EXAMEDEPENDENTE "+
                                  "WHERE UNI_ST_CODIGO ='"+uniStCodigo+"' "+
                                  "AND EXA_ST_CODIGO   ='"+leg.getExaStCodigo().getExaStCodigo()+"' "+
                                "  ) AS DEP_ST_CODIGO "+
                                "FROM LAB_EXAMESDIFERENCIADOS EDI, "+
                                 " LAB_REGRAS REG, "+
                                  "LAB_EXAMEUNIDADE EXU, "+
                                  "LAB_ORIGEM ORI, "+
                                  "LAB_PRAZO PRA1, "+
                                  "LAB_PRAZO PRA, "+
                                  "LAB_EXAME EXA, "+
                                  "LAB_EXAMEMETODO EXM, "+
                                  "LAB_METODO MET, "+
                                  "LAB_MATERIAL MAT "+
                                "WHERE EDI.UNI_ST_CODIGO     = REG.UNI_ST_CODIGO "+
                                "AND EDI.CON_ST_CODIGO       = REG.CON_ST_CODIGO "+
                                "AND EDI.REG_ST_CODIGO       = REG.REG_ST_CODIGO "+
                                "AND EDI.UNI_ST_CODIGO       = EXU.UNI_ST_CODIGO "+
                                "AND EDI.EXA_ST_CODIGO       = EXU.EXA_ST_CODIGO "+
                                "AND EDI.UNI_ST_CODIGO       = ORI.UNI_ST_CODIGO "+
                                "AND EXU.EXA_ST_CODIGO       = EXA.EXA_ST_CODIGO "+
                                "AND EXU.EXU_ST_PRAZOURGENTE = PRA1.PRA_ST_CODIGO(+) "+
                                "AND EXU.PRA_ST_CODIGO       = PRA.PRA_ST_CODIGO(+) "+
                                "AND EXU.EXA_ST_CODIGO       = EXM.EXA_ST_CODIGO(+) "+
                                "AND EXU.MET_ST_CODIGO       = EXM.MET_ST_CODIGO(+) "+
                                "AND EXU.MET_ST_CODIGO       = MET.MET_ST_CODIGO(+) "+
                                "AND EXA.MAT_ST_COLETA       = MAT.MAT_ST_CODIGO(+) "+
                                "AND EDI.UNI_ST_CODIGO       ='"+uniStCodigo+"' "+
                                "AND ORI.ORI_ST_CODIGO       ='"+oriStCodigo+"' "+
                                "AND EDI.CON_ST_CODIGO       ='"+conStCodigo+"' "+
                                "AND EDI.REG_ST_CODIGO       ='"+regStCodigo+"' "+
                                "AND EDI.EXA_ST_CODIGO       ='"+leg.getExaStCodigo().getExaStCodigo()+"' "+
                                "AND EDI_DT_INICIOVALIDADE   = "+
                                 " (SELECT MAX(EDI_DT_INICIOVALIDADE) "+
                                  "FROM LAB_EXAMESDIFERENCIADOS "+
                                  "WHERE UNI_ST_CODIGO        ='"+uniStCodigo+"' "+
                                  "AND CON_ST_CODIGO          ='"+conStCodigo+"' "+
                                  "AND REG_ST_CODIGO          ='"+regStCodigo+"' "+
                                  "AND EXA_ST_CODIGO          ='"+leg.getExaStCodigo().getExaStCodigo()+"' "+
                                  "AND EDI_DT_INICIOVALIDADE <= TO_DATE('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+
                                "  ) "+

                                "UNION ALL "+

                                "SELECT TAB1.TAB_FL_QTDECH, "+
                                 " RTP1.rtp_fl_valorch, "+
                                  "RTP1.RTP_FL_VALORCHEXTERNO, "+
                                  "RTP1.rtp_fl_desconto, "+
                                  "RTP1.rtp_fl_descontoEXTERNO, "+
                                  "RTP1.rtp_fl_acrescimo, "+
                                  "RTP1.TAP_ST_CODIGO, "+
                                  "REG1.REG_CH_OBRIGATORIONUMGUIA, "+
                                  "TAB1.TAB_ST_CODIGO, "+
                                  "TAP1.tap_st_descricao, "+
                                  "0 AS ETP_fl_valordifenciado, "+
                                  "0 AS ETP_fl_valordifenciadoExterno, "+
                                  "0 AS EDI_FL_DESCONTO, "+
                                  "0 AS EDI_FL_DESCONTOEXTERNO, "+
                                  "(SELECT "+
                                   " CASE "+
                                    "  WHEN COUNT(*) > 0 "+
                                     " THEN 'S' "+
                                      "ELSE 'N' "+
                                    "END "+
                                  "FROM LAB_EXAMESCOMAUTORIZACAO "+
                                  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
                                  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
                                  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
                                  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
                                 " ) AS ETP_ch_comautorizacao, "+
                                  "(SELECT "+
                                   " CASE "+
                                     " WHEN COUNT(*) > 0 "+
                                      "THEN 'S' "+
                                      "ELSE 'N' "+
                                    "END "+
                                 " FROM LAB_EXAMENAOAUTORIZADOS "+
                                  "WHERE UNI_ST_CODIGO = RTP1.UNI_ST_CODIGO "+
                                  "AND CON_ST_CODIGO   = RTP1.CON_ST_CODIGO "+
                                  "AND REG_ST_CODIGO   = RTP1.REG_ST_CODIGO "+
                                  "AND EXA_ST_CODIGO   = ETP1.EXA_ST_CODIGO "+
                                "  ) AS ETP_ch_naoautorizado, "+
                                  "MAT.MAT_ST_CODIGO, "+
                                  "MAT.MAT_ST_DESCRICAO, "+
                                  "EXA.EXA_CH_OBRIGATORIOPESO, "+
                                  "EXA.EXA_CH_OBRIGATORIOALTURA, "+
                                  "EXA.EXA_CH_OBRIGAGESTANTE, "+
                                  "EXA.EXA_CH_SEXO, "+
                                  "EXU.MPA_ST_CODIGO, "+
                                  "EXA.EXA_ST_DESCRICAO, "+
                                  "EXA.EXA_CH_GRUPO, "+
                                  "EXU.MET_ST_CODIGO, "+
                                  "MET.MET_ST_DESCRICAO, "+
                                  "EXM.EXM_DT_VALIDADE, "+
                                  "EXU.EXU_CH_STATUS, "+
                                  "EXU.EXU_CH_FATURA, "+
                                  "EXA.EXA_CH_INATIVO, "+
                                  "EXU.EXU_CH_INATIVO, "+
                                  "EXU.EXU_CH_PREPARO, "+
                                  "EXU.EXU_CH_obrigamaterial, "+
                                  "EXU.PRA_ST_CODIGO, "+
                                  "PRA.PRA_IN_DIAS, "+
                                  "PRA.PRA_CH_DOMINGO, "+
                                  "PRA.PRA_CH_SEGUNDA, "+
                                  "PRA.PRA_CH_TERCA, "+
                                  "PRA.PRA_CH_QUARTA, "+
                                  "PRA.PRA_CH_QUINTA, "+
                                  "PRA.PRA_CH_SEXTA, "+
                                  "PRA.PRA_CH_SABADO, "+
                                  "PRA.PRA_HR_FINAL, "+
                                  "PRA.PRA_IN_HORAS    AS pra_in_horas, "+
                                  "PRA1.PRA_IN_HORAS   AS pra_in_horasU, "+
                                  "PRA1.PRA_IN_DIAS    AS pra_in_diasU, "+
                                  "PRA1.PRA_CH_SEGUNDA AS pra_ch_segundaU, "+
                                  "PRA1.PRA_CH_TERCA   AS pra_ch_tercaU, "+
                                  "PRA1.PRA_CH_QUARTA  AS pra_ch_quartaU, "+
                                  "PRA1.PRA_CH_QUINTA  AS pra_ch_quintaU, "+
                                  "PRA1.PRA_CH_SEXTA   AS pra_ch_sextaU, "+
                                  "PRA1.PRA_CH_SABADO  AS pra_ch_sabadoU, "+
                                  "PRA1.PRA_CH_DOMINGO AS pra_ch_domingoU, "+
                                  "PRA1.PRA_HR_FINAL   AS PRA_HR_FINALU, "+
                                  "EXU.EXU_ST_PRAZOURGENTE, "+
                                  "EXU.EXU_CH_NAONECESSARIO, "+
                                  "ORI.ORI_ST_CODIGO, "+
                                  "ORI.ORI_CH_URGENCIA, "+
                                  "ORI.LEG_ST_CODIGOINICIAL, "+
                                  "ORI_CH_CONFEREAUTOMATICO, "+
                                  "ORI_CH_CONFEREAUTOMATICOFAT, "+
                                  "EXU.SET_ST_CODIGO, "+
                                  "EXU.EXU_ST_UNIDADEEX, "+
                                  "EXU.EXU_ST_UNIDADEEXURGENTE, "+
                                  "EXU.EXU_CH_CONFEREAUTOMATICOFAT, "+
                                  "(SELECT MAX(EXA_ST_CODIGO) "+
                                  "FROM LAB_EXAMEDEPENDENTE "+
                                  "WHERE UNI_ST_CODIGO ='"+uniStCodigo+"' "+
                                  "AND EXA_ST_CODIGO   ='"+leg.getExaStCodigo().getExaStCodigo()+"' "+
                                "  ) AS DEP_ST_CODIGO "+
                                "FROM LAB_EXAME EXA, "+
                                 " LAB_EXAMEUNIDADE EXU, "+
                                  "LAB_METODO MET, "+
                                  "LAB_MATERIAL MAT, "+
                                  "LAB_EXAMEMETODO EXM, "+
                                  "LAB_PRAZO PRA, "+
                                  "LAB_PRAZO PRA1, "+
                                  "LAB_ORIGEM ORI, "+
                                  "LAB_EXAMETABELAPRECO ETP1, "+
                                  "LAB_TABELA TAB1, "+
                                  "LAB_REGRATABELAPRECO RTP1, "+
                                  "LAB_REGRAS REG1, "+
                                  "LAB_TABELAPRECO TAP1 "+
                                "WHERE EXU.EXA_ST_CODIGO        = EXA.EXA_ST_CODIGO "+
                                "AND ORI.UNI_ST_CODIGO          = EXU.UNI_ST_CODIGO "+
                                "AND EXU.EXU_ST_PRAZOURGENTE    = PRA1.PRA_ST_CODIGO(+) "+
                                "AND EXU.MET_ST_CODIGO          = MET.MET_ST_CODIGO(+) "+
                                "AND EXA.MAT_ST_COLETA          = MAT.MAT_ST_CODIGO(+) "+
                                "AND EXU.PRA_ST_CODIGO          = PRA.PRA_ST_CODIGO(+) "+
                                "AND EXU.EXA_ST_CODIGO          = EXM.EXA_ST_CODIGO(+) "+
                                "AND EXU.MET_ST_CODIGO          = EXM.MET_ST_CODIGO(+) "+
                                "AND REG1.uni_st_codigo         = RTP1.uni_st_codigo "+
                                "AND REG1.con_st_codigo         = RTP1.con_st_codigo "+
                                "AND REG1.reg_st_codigo         = RTP1.reg_st_codigo "+
                                "AND ETP1.tap_st_codigo         = TAB1.tap_st_codigo "+
                                "AND ETP1.tab_st_codigo         = TAB1.tab_st_codigo "+
                                "AND TAB1.TAB_CH_TIPO           = '1' "+
                                "AND TAB1.TAB_DT_INICIOVALIDADE = "+
                                 " (SELECT MAX(TAB_DT_INICIOVALIDADE) "+
                                  "FROM LAB_TABELA "+
                                  "WHERE tap_st_codigo        = TAB1.tap_st_codigo "+
                                  "AND tab_st_codigo          = TAB1.tab_st_codigo "+
                                  "AND TAB_CH_TIPO            = '1' "+
                                  "AND TAB_DT_INICIOVALIDADE <= TO_DATE('"+sdf.format(reqDtCadastro)+"','YYYY-MM-DD') "+
                                 "  ) "+
                                "AND ETP1.tap_st_codigo         = RTP1.tap_st_codigo "+
                                "AND TAB1.tap_st_codigo         = TAP1.tap_st_codigo "+
                                "AND RTP1.uni_st_codigo         = EXU.UNI_ST_CODIGO "+
                                "AND ETP1.exa_st_codigo         = EXA.EXA_ST_CODIGO "+
                                "AND RTP1.RTP_DT_INICIOVALIDADE = "+
                                 " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
                                  "FROM LAB_REGRATABELAPRECO "+
                                  "WHERE uni_st_codigo        = RTP1.uni_st_codigo "+
                                  "AND con_st_codigo          = RTP1.con_st_codigo "+
                                  "AND reg_st_codigo          = RTP1.reg_st_codigo "+
                                  "AND RTP_DT_INICIOVALIDADE <= SYSDATE "+
                                  "AND RTP1.RTP_IN_SEQUENCIA  = "+
                                   " (SELECT MIN(RTP2.RTP_IN_SEQUENCIA) "+
                                    "FROM LAB_EXAMETABELAPRECO ETP2, "+
                                     " LAB_TABELA TAB2, "+
                                      "LAB_REGRATABELAPRECO RTP2, "+
                                      "LAB_TABELAPRECO TAP2 "+
                                    "WHERE ETP2.tap_st_codigo       = TAB2.tap_st_codigo "+
                                    "AND ETP2.tab_st_codigo         = TAB2.tab_st_codigo "+
                                    "AND TAB2.TAB_CH_TIPO           = '1' "+
                                    "AND RTP2.uni_st_codigo         = RTP2.uni_st_codigo "+
                                    "AND RTP2.con_st_codigo         = RTP2.con_st_codigo "+
                                    "AND RTP2.reg_st_codigo         = RTP2.reg_st_codigo "+
                                    "AND ETP2.tap_st_codigo         = RTP2.tap_st_codigo "+
                                    "AND TAB2.tap_st_codigo         = TAP2.tap_st_codigo "+
                                    "AND RTP2.uni_st_codigo         = RTP1.UNI_ST_CODIGO "+
                                    "AND RTP2.con_st_codigo         = RTP1.CON_ST_CODIGO "+
                                    "AND RTP2.reg_st_codigo         = RTP1.REG_ST_CODIGO "+
                                    "AND ETP2.TAP_ST_CODIGO         = ETP2.TAP_ST_CODIGO "+
                                    "AND ETP2.exa_st_codigo         = ETP1.EXA_ST_CODIGO "+
                                    "AND RTP2.RTP_DT_INICIOVALIDADE = "+
                                     " (SELECT MAX(RTP_DT_INICIOVALIDADE) "+
                                     " FROM LAB_REGRATABELAPRECO "+
                                      "WHERE uni_st_codigo       = RTP1.uni_st_codigo "+
                                      "AND con_st_codigo         = RTP1.con_st_codigo "+
                                      "AND reg_st_codigo         = RTP1.reg_st_codigo "+
                                      "AND tap_st_codigo         = ETP1.tap_st_codigo "+
                                      "AND RTP_DT_INICIOVALIDADE = RTP1.Rtp_Dt_Iniciovalidade "+
                                   "   ) "+
                                  "  ) "+
                                "  ) "+
                                "AND EXU.UNI_ST_CODIGO  ='"+uniStCodigo+"' "+
                                "AND RTP1.CON_ST_CODIGO ='"+conStCodigo+"' "+
                                "AND RTP1.REG_ST_CODIGO ='"+regStCodigo+"' "+
                                "AND ORI.ORI_ST_CODIGO  ='"+oriStCodigo+"' "+
                                "AND EXA.EXA_ST_CODIGO  ='"+leg.getExaStCodigo().getExaStCodigo()+"'";


                                try{
                                    Statement st = conn.createStatement();
                                     ResultSet rs = st.executeQuery(query2);

                  while ( rs.next()){
                      ExameFormatado ef1= new ExameFormatado(
                              rs.getFloat("TAB_FL_QTDECH") ,
                              rs.getFloat("RTP_FL_VALORCH"),
                              rs.getFloat("RTP_FL_VALORCHEXTERNO"),
                              rs.getFloat("RTP_FL_DESCONTO"),
                              rs.getFloat("RTP_FL_DESCONTOEXTERNO"),
                              rs.getFloat("RTP_FL_ACRESCIMO"),
                              rs.getString("TAP_ST_CODIGO"),
                              rs.getString("REG_CH_OBRIGATORIONUMGUIA").charAt(0),
                              rs.getString("TAB_ST_CODIGO") ,
                              rs.getString("TAP_ST_DESCRICAO") ,
                              rs.getFloat("ETP_FL_VALORDIFENCIADO"),
                              rs.getFloat("ETP_FL_VALORDIFENCIADOEXTERNO"),
                              rs.getFloat("EDI_FL_DESCONTO"),
                              rs.getFloat("EDI_FL_DESCONTOEXTERNO"),
                              rs.getString("ETP_CH_COMAUTORIZACAO").charAt(0) ,
                              rs.getString("ETP_CH_NAOAUTORIZADO").charAt(0) ,
                              rs.getString("MAT_ST_CODIGO"),
                              rs.getString("MAT_ST_DESCRICAO"),
                              rs.getString("EXA_CH_OBRIGATORIOPESO").charAt(0),
                              rs.getString("EXA_CH_OBRIGATORIOALTURA").charAt(0),
                              rs.getString("EXA_CH_OBRIGAGESTANTE").charAt(0),
                              rs.getString("EXA_CH_SEXO").charAt(0),
                              rs.getString("MPA_ST_CODIGO"),
                              rs.getString("EXA_ST_DESCRICAO"),
                              rs.getString("EXA_CH_GRUPO"),
                              rs.getString("MET_ST_CODIGO"),
                              rs.getString("MET_ST_DESCRICAO"),
                              rs.getTimestamp("EXM_DT_VALIDADE"),
                              rs.getString("EXU_CH_STATUS").charAt(0),
                              rs.getString("EXU_CH_FATURA").charAt(0),
                              rs.getString("EXA_CH_INATIVO").charAt(0) ,
                              rs.getString("EXU_CH_INATIVO").charAt(0) ,
                              rs.getString("EXU_CH_PREPARO").charAt(0),
                              rs.getString("EXU_CH_OBRIGAMATERIAL").charAt(0),
                              rs.getString("PRA_ST_CODIGO"),
                              rs.getInt("PRA_IN_DIAS"),
                              rs.getString("PRA_CH_DOMINGO").charAt(0),
                              rs.getString("PRA_CH_SEGUNDA").charAt(0),
                              rs.getString("PRA_CH_TERCA").charAt(0),
                              rs.getString("PRA_CH_QUARTA").charAt(0),
                              rs.getString("PRA_CH_QUINTA").charAt(0),
                              rs.getString("PRA_CH_SEXTA").charAt(0),
                              rs.getString("PRA_CH_SABADO").charAt(0),
                              rs.getDate("PRA_HR_FINAL"),
                              rs.getInt("PRA_IN_HORAS"),
                              rs.getInt("PRA_IN_HORASU"),
                              rs.getInt("PRA_IN_DIASU"),
                              rs.getString("PRA_CH_SEGUNDAU").charAt(0),
                              rs.getString("PRA_CH_TERCAU").charAt(0),
                              rs.getString("PRA_CH_QUARTAU").charAt(0),
                              rs.getString("PRA_CH_QUINTAU").charAt(0),
                              rs.getString("PRA_CH_SEXTAU").charAt(0),
                              rs.getString("PRA_CH_SABADOU").charAt(0),
                              rs.getString("PRA_CH_DOMINGOU").charAt(0),
                              rs.getDate("PRA_HR_FINALU"),
                              rs.getString("EXU_ST_PRAZOURGENTE"),
                              rs.getString("EXU_CH_NAONECESSARIO").charAt(0),
                              rs.getString("ORI_ST_CODIGO"),
                              rs.getString("ORI_CH_URGENCIA").charAt(0),
                              rs.getString("LEG_ST_CODIGOINICIAL"),
                              rs.getString("ORI_CH_CONFEREAUTOMATICO").charAt(0),
                              rs.getString("ORI_CH_CONFEREAUTOMATICOFAT").charAt(0),
                              rs.getString("SET_ST_CODIGO"),
                              rs.getString("EXU_ST_UNIDADEEX"),
                              rs.getString("EXU_ST_UNIDADEEXURGENTE"),
                              rs.getString("EXU_CH_CONFEREAUTOMATICOFAT").charAt(0),
                              rs.getString("DEP_ST_CODIGO"));
                              //ef1.setMetStCodigoGrp(rs.getString("MET_ST_CODIGOGRP"));

                              list.add(ef1);

                                rs.close();
                                //st.close();
                                st.close();


                  }
                                }catch (SQLException se) {
                                          System.err.println("Threw a SQLException");
                                          System.err.println(se.getMessage());

                                          return null;
                                        }catch(Exception xcp){
                                           System.err.println(xcp.getMessage());
                                           return null;
                                        }

                                }

                try{


                    
                
                  if(list.size()>0){

                     return list;

                  }else{
                      return null;
                  }

                }finally{
                    if(conn != null){
                            try {
                                //System.out.println("Closing Oracle Connection. for getListExameFomatado");
                                conn.close();
                            }catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);

                            }
                  }
                }




    }







          public static  Map<String,AccessDetails>  getUserDetalhes(LabUsuario labUsuario){
          conn =  connectByC3p0();//connectOrDie();
          Map<String , AccessDetails>  map = new HashMap<String,AccessDetails>();

                if(labUsuario != null){

                                    try
                                    {
                                      PreparedStatement preparedStatement = conn.prepareStatement(StaticQuerys.QUERY4USUARIOACCESS);
                                      preparedStatement.setString(1, labUsuario.getPusStCodigo().getPusStCodigo());
                                      preparedStatement.setString(2, labUsuario.getUsuStCodigo());
                                      ResultSet rs = preparedStatement.executeQuery();

                                      while ( rs.next()){
                                         // System.out.println("working...");

                                          AccessDetails a = new AccessDetails();
                                          a.setUsuUmo(rs.getString("USUUMO"));
                                          a.setPusStCodigo(rs.getString("PUS_ST_CODIGO"));
                                          a.setPusInSequencia(rs.getInt("PUS_IN_SEQUENCIA"));
                                          a.setPusInSequenciaPai(rs.getInt("PUS_IN_SEQUENCIAPAI"));
                                          a.setModStCodigo(rs.getString("MOD_ST_CODIGO"));
                                          a.setPusChHabilitado(rs.getString("PUS_CH_HABILITADO").charAt(0));
                                          a.setModStDescricao(rs.getString("MOD_ST_DESCRICAO"));
                                          a.setModStFormulario(rs.getString("MOD_ST_FORMULARIO"));
                                          if(rs.getString("MOD_CH_STATUS") != null){
                                          a.setModChStatus(rs.getString("MOD_CH_STATUS").charAt(0));
                                          }
                                          
                                          a.setModStOpcao1(rs.getString("MOD_ST_OPCAO1"));
                                          a.setModStOpcao2(rs.getString("MOD_ST_OPCAO2"));
                                          a.setModStOpcao3(rs.getString("MOD_ST_OPCAO3"));
                                          a.setModStOpcao4(rs.getString("MOD_ST_OPCAO4"));
                                          a.setModStOpcao5(rs.getString("MOD_ST_OPCAO5"));
                                          a.setModStOpcao6(rs.getString("MOD_ST_OPCAO6"));
                                          a.setModStOpcao7(rs.getString("MOD_ST_OPCAO7"));
                                          a.setModStOpcao8(rs.getString("MOD_ST_OPCAO8"));
                                          a.setModStOpcao9(rs.getString("MOD_ST_OPCAO9"));
                                          a.setModStOpcao10(rs.getString("MOD_ST_OPCAO10"));
                                          if(rs.getString("UMO_CH_OPCAO1")!= null){a.setUmoChOpcao1(rs.getString("UMO_CH_OPCAO1").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO2") != null){a.setUmoChOpcao2(rs.getString("UMO_CH_OPCAO2").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO3") != null){a.setUmoChOpcao3(rs.getString("UMO_CH_OPCAO3").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO4") != null){a.setUmoChOpcao4(rs.getString("UMO_CH_OPCAO4").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO5") != null){a.setUmoChOpcao5(rs.getString("UMO_CH_OPCAO5").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO6") != null){a.setUmoChOpcao6(rs.getString("UMO_CH_OPCAO6").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO7") != null){a.setUmoChOpcao7(rs.getString("UMO_CH_OPCAO7").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO8") != null){a.setUmoChOpcao8(rs.getString("UMO_CH_OPCAO8").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO9") != null){a.setUmoChOpcao9(rs.getString("UMO_CH_OPCAO9").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO10") != null){a.setUmoChOpcao10(rs.getString("UMO_CH_OPCAO10").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO11") != null){a.setUmoChOpcao11(rs.getString("UMO_CH_OPCAO11").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO12") != null){a.setUmoChOpcao12(rs.getString("UMO_CH_OPCAO12").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO13") != null){a.setUmoChOpcao13(rs.getString("UMO_CH_OPCAO13").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO14") != null){a.setUmoChOpcao14(rs.getString("UMO_CH_OPCAO14").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO15") != null){a.setUmoChOpcao15(rs.getString("UMO_CH_OPCAO15").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO16") != null){a.setUmoChOpcao16(rs.getString("UMO_CH_OPCAO16").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO17") != null){a.setUmoChOpcao17(rs.getString("UMO_CH_OPCAO17").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO18") != null){a.setUmoChOpcao18(rs.getString("UMO_CH_OPCAO18").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO19") != null){a.setUmoChOpcao19(rs.getString("UMO_CH_OPCAO19").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO20") != null){a.setUmoChOpcao20(rs.getString("UMO_CH_OPCAO20").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO21") != null){a.setUmoChOpcao21(rs.getString("UMO_CH_OPCAO21").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO22") != null){a.setUmoChOpcao22(rs.getString("UMO_CH_OPCAO22").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO23") != null){a.setUmoChOpcao23(rs.getString("UMO_CH_OPCAO23").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO24") != null){a.setUmoChOpcao24(rs.getString("UMO_CH_OPCAO24").charAt(0));}
                                          if(rs.getString("UMO_CH_OPCAO25") != null){a.setUmoChOpcao25(rs.getString("UMO_CH_OPCAO25").charAt(0));}
                                          if(rs.getString("USU_CH_ATIVO") != null){a.setUsuChAtivo(rs.getString("USU_CH_ATIVO").charAt(0));}
                                          if(rs.getString("USU_CH_ANATOMIA") != null){a.setUsuChAnatomia(rs.getString("USU_CH_ANATOMIA").charAt(0));}
                                          if(rs.getInt("USU_IN_DIASRELATORIO") != -1){a.setUsuInDiasRelatorio(rs.getInt("USU_IN_DIASRELATORIO"));}
                                          if(rs.getString("USU_CH_VALOREXTERNO") != null){a.setUsuChValorExterno(rs.getString("USU_CH_VALOREXTERNO").charAt(0));}

                                          if(a != null){
                                              map.put(a.getModStDescricao(), a);
                                              
                                          }


                                      }
                                      rs.close();
                                      preparedStatement.close();
                                      if(map.size()>0){

                                         return map;

                                      }else{
                                          return null;
                                      }

                                    }catch (SQLException se) {
                                      System.err.println("Threw a SQLException");
                                      System.err.println(se.getMessage());

                                      return null;
                                    }catch(Exception xcp){
                                       System.err.println(xcp.getMessage());
                                       return null;
                                    }finally{
                                        if(conn != null){
                                                try {
                                                   // System.out.println("Closing Oracle Connection.");
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);

                                                }
                                      }
                                    }

                }


           return null;
    }




       public static List<GeraAmostra>  getListGeraAmostra( String reqStCodigo ){

                conn = connectByC3p0();
                List<GeraAmostra> list = new ArrayList<GeraAmostra>();
               
                try{

                        Statement st = conn.createStatement();


    String query =
                         " select gtr.gtr_ch_triagem, "+
                " t.rec_st_codigo, "+
                " t.gtr_st_codigo, "+
                " t.mtr_ch_etiqueta, "+
                " t.mtr_ch_triagem, "+
                " (select max(amo_st_codigo) from lab_detalherequisicao "+
                 "  where req_st_codigo = '"+reqStCodigo+"' ) as amostra,  "+
                 "rc.rec_st_descricao,d.* "+
                  "from lab_mapatriagem t,lab_grupoTriagem gtr, "+
                 "(SELECT case "+
                  "         when der.grp_st_codigo is null then "+
                   "         der.exa_st_codigo  "+
                    "       when der.seq_st_codigo = ('01') then  "+
                     "       der.exa_st_codigo  "+
                      "     else "+
                       "     der.grp_st_codigo "+
                        " end as grupo, "+
                         "DER.SEQ_ST_CODIGO, "+
                         "DER.REQ_ST_CODIGO, "+
                         "DER.EXA_ST_CODIGO, "+
                         "DER.AMO_ST_CODIGO, "+
                         "DER.AMO_ST_CODIGO as AMOSTRA1, "+
                         "DER.SET_ST_CODIGO, "+
                         "DER.DER_DT_ENTRADAMAT, "+
                         "DER.LEG_ST_CODIGO, "+
                         "DER.DER_CH_URGENTE, "+
                         "NVL(DER.DER_CH_ETIQUETA, ('N'))  AS DER_CH_ETIQUETA, "+
                         "DER.DER_DT_DATAPREVISTAENTREGA, "+
                         "DER.DER_ST_UNIDADEEX, "+
                         "DER.REC_ST_CODIGO, "+
                         "DER.GRP_ST_CODIGO, "+
                         "EXUEX.APO_ST_CODIGO, "+
                         "PAC.PAC_ST_NOME, "+
                         "PAC.PAC_IN_CODIGO, "+
                         "PAC.PAC_ST_SEXO, "+
                         "PAC.PAC_DT_NASCIMENTO, "+
                         "LEG.LEG_IN_FONTE, "+
                         "LEG.LEG_IN_COR, "+
                         "LEG.LEG_ST_SIGLA, "+
                         "EXA.EXA_ST_FANTASIA, "+
                         "REQ.REQ_ST_QUARTO, "+
                         "REQ.UNI_ST_CODIGO, "+
                         "REQ.ORI_ST_CODIGO, "+
                         "REQ.REQ_CH_NOVO, "+
                         "REQ.REQ_ST_CODIGOLIS, "+
                        "DER.REQ_ST_CODIGOLIS AS REQ_ST_CODIGOLISDER, "+
                        " UNI.UNI_ST_DESCRICAO, "+
                        " ORI_ST_MARCAETIQUETA, "+
                         "ORI.ORI_ST_DESCRICAO, "+
                        " MAT.MAT_ST_DESCRICAO, "+
                         "exu.rec_st_coleta, "+
                  "CASE DER.DER_CH_URGENTE || EXU.APO_ST_CODIGO "+
                      " WHEN 'S' THEN "+
                       "     EXU.EXU_ST_UNIDADEEXURGENTE "+
                       "WHEN 'N' THEN "+
                        "    EXU.EXU_ST_UNIDADEEX "+
                       "ELSE '+' || EXU.APO_ST_CODIGO "+
                       "END AS EXU_ST_UNIDADEEX, "+
                  "CASE DER.DER_CH_URGENTE "+
                    "   WHEN 'S' THEN "+
                     "       EXU.EXU_ST_UNIDADEEXURGENTE "+
                      " ELSE "+
                       "     EXU.EXU_ST_UNIDADEEX "+
                       "END AS EXU_ST_UNIDADEEX1 "+
                    "FROM LAB_DETALHEREQUISICAO DER,LAB_PACIENTE PAC,LAB_REQUISICAO REQ,LAB_LEGENDA LEG, "+
                     "   LAB_EXAME  EXA,LAB_UNIDADE UNI,LAB_ORIGEM ORI,LAB_MATERIAL MAT,LAB_EXAMEUNIDADE EXU,LAB_EXAMEUNIDADE EXUEX  "+
                   "WHERE DER.REQ_ST_CODIGO = REQ.REQ_ST_CODIGO  "+
                   "  AND REQ.PAC_IN_CODIGO = PAC.PAC_IN_CODIGO  "+
                    " AND DER.LEG_ST_CODIGO = LEG.LEG_ST_CODIGO  "+
                     "AND DER.DER_ST_UNIDADEEX = EXUEX.UNI_ST_CODIGO "+
                    " AND DER.EXA_ST_CODIGO = EXUEX.EXA_ST_CODIGO "+
                    " AND DER.UNI_ST_CODIGO = UNI.UNI_ST_CODIGO "+
                    " AND DER.EXA_ST_CODIGO = EXA.EXA_ST_CODIGO "+
                     "AND DER.UNI_ST_CODIGO = EXU.UNI_ST_CODIGO "+
                    "AND DER.EXA_ST_CODIGO = EXU.EXA_ST_CODIGO "+
                    " AND REQ.UNI_ST_CODIGO = ORI.UNI_ST_CODIGO "+
                    " AND REQ.ORI_ST_CODIGO = ORI.ORI_ST_CODIGO "+
                    " AND EXA.MAT_ST_TRIAGEM = MAT.MAT_ST_CODIGO(+) "+
                    " AND DER.DER_CH_TROUXEMAT = 'S'   "+
                    " AND DER.REQ_ST_CODIGO = '"+reqStCodigo+"' ) d,  "+
                 "LAB_RECIPIENTE RC  "+
             "where d.grupo = t.exa_st_codigo  "+
             "and t.gtr_st_codigo = gtr.gtr_st_codigo(+)  "+
             "and t.rec_st_codigo = rec_st_coleta  "+
             "and t.uni_st_codigo = d.uni_st_codigo  "+
             "and ((t.rec_st_codigo = d.REC_ST_CODIGO) or (d.REC_ST_CODIGO is null))  "+
             "and t.rec_st_codigo = rc.rec_st_codigo  "+
             "and (d.exa_st_codigo <> d.grp_st_codigo or d.grp_st_codigo is null) "+
             "and d.grp_st_codigo is null"  ;   

                 ResultSet rs = st.executeQuery(query);
                 GeraAmostra ga;
                  while ( rs.next()){
                    ga = new GeraAmostra();
                   if(rs.getString("GTR_CH_TRIAGEM") != null){ga.setGtrChTriagem(new Character(rs.getString("GTR_CH_TRIAGEM").charAt(0)));}
                    ga.setRecStCodigo(rs.getString("REC_ST_CODIGO"));
                    ga.setGtrStCodigo(rs.getString("GTR_ST_CODIGO"));
                    if(rs.getString("MTR_CH_ETIQUETA") != null)ga.setMtrChEriqueta(rs.getString("MTR_CH_ETIQUETA").charAt(0));
                    if(rs.getString("MTR_CH_TRIAGEM") != null)ga.setMtrChTriagem(rs.getString("MTR_CH_TRIAGEM").charAt(0));
                    ga.setAmostra(rs.getString("AMOSTRA"));
                    ga.setRecStDescricao(rs.getString("REC_ST_DESCRICAO"));
                    ga.setGrupo(rs.getString("GRUPO"));
                    ga.setSeqStCodigo(rs.getString("SEQ_ST_CODIGO"));
                    ga.setReqStCodigo(rs.getString("REQ_ST_CODIGO"));
                    ga.setExaStCodigo(rs.getString("EXA_ST_CODIGO"));
                    ga.setAmoStCodigo(rs.getString("AMO_ST_CODIGO"));
                    ga.setAmostra1(rs.getString("AMOSTRA1"));
                    ga.setSetStCodigo(rs.getString("SET_ST_CODIGO"));
                    ga.setDerDtEntradaMat(rs.getDate("DER_DT_ENTRADAMAT"));
                    ga.setLegStCodigo(rs.getString("LEG_ST_CODIGO"));
                    if(rs.getString("DER_CH_URGENTE") != null)ga.setDerChUrgente(rs.getString("DER_CH_URGENTE").charAt(0));
                    if(rs.getString("DER_CH_ETIQUETA") != null)ga.setDerChEtiqueta(rs.getString("DER_CH_ETIQUETA").charAt(0));
                    ga.setDerDtDataPrevistaEntrega(rs.getDate("DER_DT_DATAPREVISTAENTREGA"));
                    ga.setDerStUnidadeEx(rs.getString("DER_ST_UNIDADEEX"));
                    ga.setRecStCodigo(rs.getString("REC_ST_CODIGO"));
                    ga.setGrpStCodigo(rs.getString("GRP_ST_CODIGO"));
                    ga.setApoStCodigo(rs.getString("APO_ST_CODIGO"));
                    ga.setPacStNome(rs.getString("PAC_ST_NOME"));
                    ga.setPacInCodigo(rs.getLong("PAC_IN_CODIGO"));
                    ga.setPacStSexo(rs.getString("PAC_ST_SEXO"));
                    ga.setPacDtNascimento(rs.getDate("PAC_DT_NASCIMENTO"));
                    ga.setLegInFonte(rs.getLong("LEG_IN_FONTE"));
                    ga.setLegInCor(rs.getLong("LEG_IN_COR"));
                    ga.setLegStSigla(rs.getString("LEG_ST_SIGLA"));
                    ga.setExaStFantasia(rs.getString("EXA_ST_FANTASIA"));
                    ga.setReqStQuarto(rs.getString("REQ_ST_QUARTO"));
                    ga.setUniStCodigo(rs.getString("UNI_ST_CODIGO"));
                    ga.setOriStCodigo(rs.getString("ORI_ST_CODIGO"));
                    if(rs.getString("REQ_CH_NOVO") != null)ga.setReqChNovo(rs.getString("REQ_CH_NOVO").charAt(0));
                    ga.setReqStCodigoLis(rs.getString("REQ_ST_CODIGOLIS"));
                    ga.setReqStCodigoLisDer(rs.getString("REQ_ST_CODIGOLISDER"));
                    ga.setUniStDescricao(rs.getString("UNI_ST_DESCRICAO"));
                    ga.setOriStMarcaEtiqueta(rs.getString("ORI_ST_MARCAETIQUETA"));
                    ga.setOriStDescricao(rs.getString("ORI_ST_DESCRICAO"));
                    ga.setMatStDescricao(rs.getString("MAT_ST_DESCRICAO"));
                    ga.setRecStColeta(rs.getString("REC_ST_COLETA"));
                    ga.setExuStUnidadeEx(rs.getString("EXU_ST_UNIDADEEX"));
                    ga.setExuStUnidadeEx1(rs.getString("EXU_ST_UNIDADEEX1"));
                        list.add(ga);

                  }
                  rs.close();
                  st.close();



                  if(list != null && list.size()>0){
                    
                     return list;

                  }else{
                      return null;
                  }

                }catch (SQLException se) {
                  System.err.println("Threw a SQLException");
                  System.err.println(se.getMessage());
                   se.printStackTrace();
                  return null;
                }catch(Exception xcp){
                   System.err.println(xcp.getMessage());
                    System.out.println(xcp);
                   return null;
                }finally{
                    if(conn != null){
                            try {
                                //System.out.println("Closing Oracle Connection. for getListExameFomatadoDependente");
                                conn.close();
                            }catch (SQLException ex) {
                                Logger.getLogger(OracleConnector.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println(ex);
                                System.err.println(ex);

                            }
                  }
                }




    }






}
