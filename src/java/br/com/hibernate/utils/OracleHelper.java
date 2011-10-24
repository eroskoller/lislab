/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.utils;



import br.com.facesbeans.ExameBean;
import br.com.facesbeans.LabPacienteBean;
import br.com.facesbeans.MaterialBean;
import br.com.hibernate.entities.*;
import br.com.oracleconnector.OracleConnector;
import br.com.utils.tipstricks.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
/**
 *
 * @author eros
 */
public class OracleHelper{
    

    static protected Logger log = Logger.getLogger("logs4.tmlab");
//  static public    List<MaterialBean>  listMaterialBeans = new ArrayList<MaterialBean>();
    static Session session = null;
    static  Transaction tx = null;




       /**
        *
        *
        * @return a new Session if session is null or a session if session is not null
        */


    

    public static Session getSessionDude(){

   
         if(session == null  || !session.isOpen()){
            return session = HibernateUtilFaces.getCurrentSession4Faces();
        }else{
            return session;
        }
    }


    /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
     public static Object getObject(Class clazz,long id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }



      /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
     public static Object getObject(Class clazz,String id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }


     /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
     public static Object getObject(Class clazz,Object idPk){

         session = getSessionDude();//sessionFactory.getCurrentSession();
         tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz,(Serializable) idPk);
        tx.commit();
        return obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }


      /**
     *
     * @param clazz
     * @param id
     * @return List<Object>
     */
     public static List  getListObject(Class clazz){

         session = getSessionDude();
         tx = session.beginTransaction();
        List result ;

       
        try{
        Criteria criteria = session.createCriteria(clazz);
         result = criteria.list();
        tx.commit();
        return result;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }




      /**
 *
 * @param classBean
 * @param strKey
 * @param value
 * @return a first Object from a List of obejcts
 */
 static  public Object getObjectByKey( Class classBean, String strKey, Object value){

       
        List result = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(classBean);

            if(strKey != null){
                criteria.add(Restrictions.like(strKey, value));
            }
            result = criteria.list();
            tx.commit();


            if(result != null && result.size()>0){
                return result.get(0);
            }



        }finally{
            if(session != null){
                session.close();
            }
        }


            return null;
  }




      /**
 *
 * @param classBean
 * @param strKey
 * @param value
 * @return a List of obejcts
 */
 static  public java.util.List getListOfObjectByKey( Class classBean, String strKey, Object value){

       
        List result = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(classBean);
            
            if(strKey != null){
                criteria.add(Restrictions.like(strKey, value));
            }
            result = criteria.list();

            tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }


            return result;
  }


  static  public java.util.List getListOfObjectByKeyEq( Class classBean, String strKey, Object value,String orderByField,boolean orderBy){

        
        
        try{

            if(strKey != null){
                session = getSessionDude();//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                Criteria criteria = session.createCriteria(classBean);

                criteria.add(Restrictions.eq(strKey, value));
//                criteria.add(Restrictions.isNotNull(strKey));
                    if(orderBy){
                     criteria.addOrder( Order.asc(orderByField) );
                    }else{
                        criteria.addOrder( Order.desc(orderByField) );
                    }
                tx.commit();
                
                return criteria.list();
            }
            

            
        }finally{
            if(session != null){
                session.close();
            }
        }
        return null;

  }





    /**
     *
     * @param obj save a obj
     *
     */
     public static void saveObject(Object obj){
        
        try{
        session = getSessionDude();
        
        tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }


    }
    /**
     *
     * @param save a list of objects
     */
     public static void saveObjectList(List list){

        
         try{
             session = getSessionDude();
             tx = session.beginTransaction();

             for(Object obj: list){
                 session.save(obj);
             }
             tx.commit();
         }finally{
             if(session != null){
                 session.close();
             }
         }

    }

     /**
     *
     * @param obj save or update a obj
     *
     */
     public static void saveOrUpdateObject(Object obj){
        
        try{
        session = getSessionDude();
        //session = getSessionDude();
        tx = session.beginTransaction();
        session.saveOrUpdate(obj);
        tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }


    }
     /**
     *
     * @param save or update a list of objects
     */
     public static void saveOrUpdateObjectList(List list){

          
         try{
             session = getSessionDude();
             tx = session.beginTransaction();

             for(Object obj: list){
                 session.saveOrUpdate(obj);
             }
             tx.commit();
         }finally{
             if(session != null){
                 session.close();
             }
         }

    }

     /**
     *
     * @param update a obj 
     *
     */
     public static void updateObject(Object obj){
         
        try{
        session = getSessionDude();
        //session = getSessionDude();
        tx = session.beginTransaction();
        session.update(obj);
        tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }


    }

        /**
     *
     * @param update a obj and return the same
     *
     */
     public static Object  updateObjectReturnObject(Object obj){
         
        try{
        session = getSessionDude();
        //session = getSessionDude();
        tx = session.beginTransaction();

        session.update(obj);
        tx.commit();
        return obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }

     /**
     *
     * @param save a list of objects
     */
     public static void updateObjectList(List list){

          
         try{
             session = getSessionDude();
             tx = session.beginTransaction();

             for(Object obj: list){
                 session.update(obj);
             }
             tx.commit();
         }finally{
             if(session != null){
                 session.close();
             }
         }

    }

     /**
     *
     * @param update a list of LabDetalheRequisicao using hql
     */
      public static void updateListLabDetalheRequisicao(List<LabDetalheRequisicao> list){

         
         try{
             if(list != null && list.size()>0){
                  session = getSessionDude();
                tx = session.beginTransaction();
                 String hql = "update"
                +" LabDetalheRequisicao "
                +" set "
                +"legStCodigo = :legStCodigo ,"
                +"legStCodigoFat = :legStCodigoFat"
                +" where "
                +"derInCodigo=:derInCodigo";

               for(LabDetalheRequisicao ldr : list){
                    Query query = session.createQuery(hql);
                    query.setString("legStCodigo",ldr.getLegStCodigo());
                    query.setString("legStCodigoFat",ldr.getLegStCodigoFat());
                    query.setLong("derInCodigo", ldr.getDerInCodigo());
                    query.executeUpdate();
               }
               tx.commit();
             }

         }finally{
             if(session != null){
                 session.close();
             }
         }

    }




     /**
      *
      * @param obj delete object
      */
     public static void deleteObject(Object obj){
        
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }


    }


     /**
     *
     * @param delete a list of objects
     */
     public static void deleteObjectList(List list){

         
         try{
             session = getSessionDude();
             tx = session.beginTransaction();

             for(Object obj: list){
                 session.delete(obj);
             }
             tx.commit();
         }finally{
             if(session != null){
                 session.close();
             }
         }

    }






     //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< tmlab specific >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



/**
 *
 * @return a List of only two itens [0,1], 0 position 0
   * being a LabRequisicao obj an position 1 being a LabPaciente
 * based on ra and sus number
 */
     static  public List getFirstMatchPacAndRequisicao(Long ra,Long sus) {

         List finalResult = null;
         LabRequisicao lr = null;
         LabPaciente lp = null;


         try{
             session = getSessionDude();
             tx = session.beginTransaction();

             lr = (LabRequisicao) HibernateHelperFaces.getObject(LabRequisicao.class, ra);

             if(ra != null){
                 Long susFromLR = lr.getPacInCodigo().getPacInCodSUS();
                 lp = lr.getPacInCodigo();
                // System.out.println(lp.getPacStNome()+" : "+lp.getPacStEstado());
                 if(susFromLR == sus){

                     //System.out.println("Everything matchs dude");
                    if(lp != null){
                        finalResult = new ArrayList();
                        finalResult.add(lr);
                        finalResult.add(lp);

                        return finalResult;
                    }else{
                        return null;
                    }


                 }

             }

         }finally{
             if(session != null){
                 session.close();
             }
         }




	    return null;
  }


  /**
 *
 * @return a List of only two itens [0,1], 0 position 0
   * being a LabRequisicao obj an position 1 being a LabPaciente
   * based on ra and pac number
 */
    static  public List getFirstMatchPac(Long ra,Long pac) {


         List finalResult = null;
         LabRequisicao lr = null;
         LabPaciente lp = null;


         try{
             session = getSessionDude();//sessionFactory.getCurrentSession();
             tx = session.beginTransaction();

             lr = (LabRequisicao) HibernateHelperFaces.getObject(LabRequisicao.class, ra);

             if(ra != null){
                 Long pacCodigoFromLR = lr.getPacInCodigo().getPacInCodigo();
                 //System.out.println(lr.getPacInCodigo().getPacInCodigo());
                 //System.out.println(pac);
                 if(pacCodigoFromLR.equals(pac)){
                    lp = lr.getPacInCodigo();
                    //System.out.println(lp.getPacStNome()+" : "+lp.getPacInCodigo());
                    // System.out.println("Everything matchs dude");
                    if(lp != null){
                        finalResult = new ArrayList();
                        finalResult.add(lr);
                        finalResult.add(lp);

                        return finalResult;
                    }else{
                        return null;
                    }


                 }

             }

         }finally{
             if(session != null){
                 session.close();
             }
         }




	    return null;
  }


/**
 *@return a LabAgenda based on Object class and LabAgendaPK object.
 */
public static LabAgenda getLabAgendaByLabAgendaPK(Class clazz,LabAgendaPK id){

      session = getSessionDude();//sessionFactory.getCurrentSession();
      tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabAgenda)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }

/**
 *@return a LabAgendaPaceinte based on Object class and LabAgendaPacientePK object.
 */
  public static LabAgendaPacienteExame getLabAgendaPacienteExameByLabAgendaPacienteExamePK(Class clazz,LabAgendaPacienteExamePK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabAgendaPacienteExame)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }


/**
 *@return a LabColetor based on Object class and LabColetorPK object.
 */
public static LabColetor getLabColetorByLabColetorPK(Class clazz,LabColetorPK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabColetor)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }

/**
 *@return a LabLocal based on Object class and LabLocalPK object.
 */
public static LabLocal getLabLocalByLabLocalPK(LabLocalPK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(LabLocal.class, id);
        tx.commit();
        return (LabLocal)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }

/**
 *@return a LabOrigem based on Object class and LabOrigemPK object.
 */
public static LabOrigem getLabOrigemByLabOrigemPK(Class clazz,LabOrigemPK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabOrigem)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }




/**
 *@return a LabRegras based on Object class and LabRegrasPK object.
 */
public static LabRegras getLabRegrasByLabRegrasPK(Class clazz,LabRegrasPK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabRegras)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }
/**
 *@return a LabRequisicao based pacInCodigo
 */
public static LabRequisicao getLastLabRequisicao(String pacInCodigo){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();
        Long l = null;
        Object obj = null;
        if(pacInCodigo.replaceAll("\\D", "").length()>4){
            l = new Long(pacInCodigo.replaceAll("\\D", ""));
            try{
              session = getSessionDude();//sessionFactory.getCurrentSession();
                         tx = session.beginTransaction();

                         org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.pacInCodigo = :pacInCodigo");
                         q.setLong("pacInCodigo", l);
                         tx.commit();
                         if(q.list().size()>0){
                             return (LabRequisicao) q.list().get(0);
                         }else{
                             return null;
                         }
                         
            }finally{
                if(session != null){
                    session.close();
                }
            }
        }
        
        return null;

  }




/**
 *@return a LabResultados based derInCodigo
 */
public static List<LabResultados> getListLabResultados(Long derInCodigo){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();
       
            try{
              session = getSessionDude();//sessionFactory.getCurrentSession();
                         tx = session.beginTransaction();

                         org.hibernate.Query q = session.createQuery("from LabResultados l where l.derInCodigo = :derInCodigo and res_st_ingresso is not NULL  order by derInValidadeRes asc ");
                         q.setLong("derInCodigo", derInCodigo);
                         //q.setMaxResults(1);
                         tx.commit();
                         if(q.list().size()>0){
                             return (List<LabResultados>) q.list();
                         }else{
                             return null;
                         }

            }finally{
                if(session != null){
                    session.close();
                }
            }


  }

public static List<LabResultados> getListLabResultadosCriteria(Long derInCodigo){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

            try{
              session = getSessionDude();//sessionFactory.getCurrentSession();
                         tx = session.beginTransaction();
                         Criteria criteria = session.createCriteria(LabResultados.class);
                         criteria.add(Restrictions.eq("derInCodigo", derInCodigo));


                         org.hibernate.Query q = session.createQuery("from LabResultados l where l.derInCodigo = :derInCodigo ");
                         q.setLong("derInCodigo", derInCodigo);
                         tx.commit();
                         if(q.list().size()>0){
                             return (List<LabResultados>) q.list();
                         }else{
                             return null;
                         }

            }finally{
                if(session != null){
                    session.close();
                }
            }


  }





/**
 *@return a LabSistema based on Object class and LabSistemaPK object.
 */
public static LabSistema getLabSistemaByLabSistemaPK(Class clazz,LabSistemaPK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabSistema)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }

/**
 *@return a LabAgendaLocal based on Object class and LabAgendaLocalPK object.
 */
public static LabAgendaLocal getLabAgendaLocalByLabAgendaLocalPK(Class clazz,LabAgendaLocalPK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabAgendaLocal)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }

/**
 *@return a LabSolicitante based on Object class and LabSolicitantePK object.
 */
public static LabSolicitante getLabSolicitanteByLabSolicitantePK(Class clazz,LabSolicitantePK id){

        session = getSessionDude();//sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        Object obj = null;
        try{
        obj  =   session.get(clazz, id);
        tx.commit();
        return (LabSolicitante)obj;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }


/**
 *@return a first position of list LabPaciente based on RG and CPF .
 * no index for CPF create don't use it.
 */
 public static LabPaciente getLabPacienteByCPF_RG(String cpf,String rg){
     
         List list = new ArrayList();
         List result = null;

         if(cpf.trim() != null && rg.trim() != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStRG = :rg and  l.pacStCPF = :cpf ");
                     q.setString("cpf", cpf.trim().replaceAll("\\D", ""));
                     q.setString("rg", rg.trim().toUpperCase());

                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return (LabPaciente) result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }


 public static LabUsuario getLabUsuario(String login,String senha){
             List list = new ArrayList();
             
             String l ;
             String s;

         List result = null;

         if(login.trim() != null && senha.trim() != null){

             l = login.trim().toUpperCase();
             s = senha.trim().toUpperCase();


                 try{
                     
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                      Criteria criteria = session.createCriteria(LabUsuario.class);
                      criteria.add(Restrictions.eq("usuStCodigo", login));
                      criteria.add(Restrictions.eq("usuStSenha", senha));
                      criteria.add(Restrictions.eq("usuChAtivo", "S"));
//                      criteria.add(Restrictions.isNotNull(strKey));
                      
                     tx = session.beginTransaction();
//                     org.hibernate.Query q = session.createQuery("from LabUsuario l where l.usuStCodigo = :login and  l.usuStSenha = :senha and l.usuChAtivo = 'S' ");
//                     q.setString("login", l);
//                     q.setString("senha", s);

                     result = criteria.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return (LabUsuario) result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }





 /**
 *@return a first position of list LabPaciente based on RG  .
 */
  public static LabPaciente getLabPacienteByRG(String rg){
      
         
         List result = null;

         if(rg.trim() != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStRG = :rg");
                     q.setString("rg", rg.trim().toUpperCase());

                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return (LabPaciente) result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }




 /**
 *@return a first position of list LabPaciente based on pacInCodSus .
 */
  public static LabPaciente getLabPacienteBySUS(String sus){

         List result = null;
            sus = sus.replaceAll("\\D", "").trim();




            if(sus != null && sus.length()>0){
                 Long codigoSus = new Long(sus);

                           if(codigoSus != null){
                                         try{
                                             session = getSessionDude();//sessionFactory.getCurrentSession();
                                             tx = session.beginTransaction();
                                             org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacInCodSUS = :sus");
                                           
                                             q.setLong("sus",codigoSus);

                                             result = q.list();
                                             tx.commit();

                                             if (result != null && result.size() > 0) {
                                                return (LabPaciente) result.get(0);
                                              }

                                         }finally{
                                             if(session != null){
                                                 session.close();
                                             }
                                         }
                         }

            }
        

	    return null;

 }











  

 /**
 *@return a first position of list LabPaciente based on CPF .
  * no index create don't use it.
 */
  public static LabPaciente getLabPacienteByCPF(String cpf){

         List result = null;

         if(cpf != null && cpf.trim() != null && cpf.replaceAll("\\D", "").length()>5){
             String cpf2 = cpf.replaceAll("\\D", "");
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStCPF = '"+cpf2+"' ");

                    // q.setString("cpf", cpf.trim());

                     result = q.list();
                     

                     if (result != null && result.size() > 0) {
                        return (LabPaciente) result.get(0);
                      }else{
                         org.hibernate.Query q2 = session.createQuery("from LabPaciente l where l.pacStCPF = '"+Cpf.formatingCpf(cpf2)+"' ");
                         List result2 = q2.list();
                         if( result2!= null && result2.size()>0){
                             return (LabPaciente) result2.get(0);
                         }
                      }

                     tx.commit();
                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a first position of list LabRequisicao based on req .
  * no index create don't use it.
 */
  public static LabRequisicao getLabRequisicaoByReq(String req){

         List result = null;

         if(req.trim() != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.reqStCodigo = '"+req.toUpperCase()+"' ");

                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return (LabRequisicao) result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a first position of list LabRequisicao based on req .
  * no index create don't use it.
 */
  public static LabRequisicao getLabRequisicaoByReq(String req,int minDate,LabUnidade lu){

         List result = null;


         if(req.trim() != null){
                 try{
                     Calendar cal1 = Calendar.getInstance();
                     Calendar cal2 = Calendar.getInstance();
                     cal1.add(Calendar.DAY_OF_YEAR, minDate);
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     Criteria criteria = session.createCriteria(LabRequisicao.class);
                     criteria.add(Restrictions.eq("reqStCodigo", req.toUpperCase()));
                     criteria.add(Restrictions.eq("uniStCodigo", lu));
                     criteria.add(Expression.between("reqDtCadastro", cal1.getTime(), cal2.getTime()));
                     System.out.println(cal1.getTime()+"       "+cal2.getTime());
                    result = criteria.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return (LabRequisicao) result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }







    /**
 *@return a first position of list LabRequisicao based on req .
  * no index create don't use it.
 */
  public static LabPaciente getLabPacienteByPront(String pront){

         List result = null;
         pront = pront.trim();

         if(pront != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStProntuario = '"+pront+"' ");

                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return (LabPaciente) result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }






   /**
 *@return a first position of list LabRequisicao based on req .
  * no index create don't use it.
 */
  public static LabRequisicao getLabRequisicaoByReq(String req,String ano){

         List result = null;


         if(req.length()==10){

         }else{
             if(req.length()==8){
                 req = ano.substring(2, 4)+req;
             }
         }

         if(req.trim() != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.reqStCodigo = '"+req.toUpperCase()+"' ");


                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return (LabRequisicao) result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }


    /**
 *@return a list of LabRequisicao based on pacInCodigo .
  * no index create don't use it.
 */
  public static List<LabRequisicao> getListLabRequisicaoByPacInCodigo(LabPaciente pacInCodigo){

         List<LabRequisicao> result = null;




         if(pacInCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.pacInCodigo = '"+pacInCodigo.getPacInCodigo()+"' order by reqDtCadastro ");


                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }








  /**
 *@return a list of LabRequisicao based on pacInCodigo .
  * no index create don't use it.
 */
  public static List<LabDetalheRequisicao> getListLabDetalheRequisicaoByReqStCodigo(String reqStCodigo){

         List<LabDetalheRequisicao> result = null;




         if(reqStCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabDetalheRequisicao l where l.reqStCodigo = '"+reqStCodigo.trim()+"' order by derInCodigo");

                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {

                         for(LabDetalheRequisicao ldr : result){
                             ldr.setSalvoNoDb(true);
                         }


                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



  /**
 *@return a list of LabRequisicao based on  uniStCodigo, oriStCodigo, locStCodigo between dates.
  * no index create don't use it.
 */
  public static List<LabRequisicao> getListLabRequisicaoByDinoQuery
          (LabUnidade uniStCodigo,LabOrigem oriStCodigo,String locStCodigo,Date dtInicio,Date dtFinal,LabPaciente pacInCodigo,String legStCodigo){

         List<LabRequisicao> result = null;

         if(uniStCodigo != null ){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();


                      Criteria criteria = session.createCriteria(LabRequisicao.class);


                        if(pacInCodigo != null){
                            criteria.add(Restrictions.eq("pacInCodigo", pacInCodigo));
                        }
                        if(uniStCodigo != null){
                            criteria.add(Restrictions.eq("uniStCodigo", uniStCodigo));
                        }
                        if(oriStCodigo != null){
                            criteria.add(Restrictions.eq("oriStCodigo", oriStCodigo));
                        }

                      if(legStCodigo != null){
                            if(legStCodigo.equalsIgnoreCase("A")){
                                 LabLegenda ll = new LabLegenda();
                                 ll.setLegStCodigo("L");
                                 LabLegenda ll2 = new LabLegenda();
                                 ll2.setLegStCodigo("011");
                                 criteria.add(Restrictions.or(Property.forName( "legStCodigo" ).eq(ll),Property.forName( "legStCodigo" ).eq(ll2)));
                              }else
                                  if(legStCodigo.equalsIgnoreCase("L")){
                                        LabLegenda ll = new LabLegenda();
                                         ll.setLegStCodigo("L");
                                         criteria.add(Restrictions.eq("legStCodigo", ll));
                              }else if(legStCodigo.equalsIgnoreCase("I")){
                                        LabLegenda ll = new LabLegenda();
                                         ll.setLegStCodigo("011");
                                         criteria.add(Restrictions.eq("legStCodigo", ll));
                              }

                      }

                      



                      if(dtInicio != null && dtFinal != null){

                          
                        //  Calendar cal2 = Calendar.getInstance();
                          //cal2.setTime(dtFinal);
                          
                          //cal2.add(Calendar.DAY_OF_YEAR, 1);
                          //System.out.println("dtInicio: "+dtInicio+"  cal2.getTime(): "+cal2.getTime());
                          criteria.add(Expression.between("reqDtCadastro", dtInicio, dtFinal));//cal2.getTime()));
                      }
                      if(locStCodigo != null){
                            criteria.add(Restrictions.like("locStCodigo", locStCodigo));
                      }
                     criteria.setMaxResults(100);
                     criteria.addOrder(Property.forName("reqDtCadastro").desc());
                     result = criteria.list();
                     tx.commit();

                     if(result == null){
                         return new ArrayList<LabRequisicao>(10);
                     }
                        return result;
                      

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a list of LabRequisicao based on  uniStCodigo, oriStCodigo, locStCodigo between dates.
  * no index create don't use it.
 */
  public static List<LabRequisicao> getListLabRequisicaoByDinoQuery
          (LabUnidade uniStCodigo,LabOrigem oriStCodigo,String locStCodigo,Date dtInicio,Date dtFinal,LabPaciente pacInCodigo,List<String> listLegStCodigo){

         List<LabRequisicao> result = null;

         if(uniStCodigo != null ){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();


                      Criteria criteria = session.createCriteria(LabRequisicao.class);


                        if(pacInCodigo != null){
                            criteria.add(Restrictions.eq("pacInCodigo", pacInCodigo));
                        }else{
                          criteria.add(Restrictions.isNotNull("pacInCodigo"));
                        }
                        if(uniStCodigo != null){
                            criteria.add(Restrictions.eq("uniStCodigo", uniStCodigo));
                        }
                        if(oriStCodigo != null){
                            criteria.add(Restrictions.eq("oriStCodigo", oriStCodigo));
                        }
                         

                      if(listLegStCodigo != null && listLegStCodigo.size()>0){
                          Disjunction dis =  Restrictions.disjunction();
                          for(String str : listLegStCodigo){
                                LabLegenda ll = new LabLegenda();
                                 ll.setLegStCodigo(str);
                                  dis.add(Restrictions.eq("legStCodigo", ll));
                          }
                          criteria.add(dis);
                      }
                      

                      if(dtInicio != null && dtFinal != null){


                    
                          criteria.add(Expression.between("reqDtCadastro", dtInicio, dtFinal));//cal2.getTime()));
                      }
                      if(locStCodigo != null){
                            criteria.add(Restrictions.like("locStCodigo", locStCodigo));
                      }
                     criteria.setMaxResults(1000);
                     criteria.addOrder(Property.forName("reqDtCadastro").desc());
                     result = criteria.list();
                     tx.commit();

                     if(result == null){
                         return new ArrayList<LabRequisicao>(10);
                     }
                        return result;


                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }




   



  public  static LabUnidadeMedida getLabUnidadeMedida(String exaStCodigo, String cinStCodigo, String metStCodigo){

         
         try{

             if(exaStCodigo != null &&cinStCodigo != null && metStCodigo != null ){

                 session = getSessionDude();
                 tx = session.beginTransaction();
                   Criteria criteria = session.createCriteria(LabConfigIngresso.class);
                   criteria.add(Restrictions.eq("exaStCodigo", exaStCodigo));
                   criteria.add(Restrictions.eq("cinStCodigo", cinStCodigo));
                   criteria.add(Restrictions.eq("metStCodigo", metStCodigo));
                   List<LabConfigIngresso> lLci = criteria.list();
                   if(lLci != null && lLci.size()>0){
                       LabConfigIngresso lci =lLci.get(0);
                       if(lci != null && lci.getUnmStCodigo() != null){
                            LabUnidadeMedida lum =( LabUnidadeMedida) session.get(LabUnidadeMedida.class, lci.getUnmStCodigo());//( LabUnidadeMedida) OracleHelper.getObject(LabUnidadeMedida.class, lci.getUnmStCodigo()); //
                               if(lum != null){
                                   return lum;
                           }
                       }
                       
                   }
                   tx.commit();

             }


         }finally{
                     if(session != null){
                         session.close();
                     }
         }

      return null;
  }



   /**
 *@return a list of LabRequisicao based on  uniStCodigo, oriStCodigo, locStCodigo between dates.
  * no index create don't use it.
 */
  public static List<LabRequisicao> getListLabRequisicaoByDinoQuerySQL(LabUnidade uniStCodigo,LabOrigem oriStCodigo,String locStCodigo,Date dtInicio,Date dtFinal,LabPaciente pacInCodigo){

         List<LabRequisicao> result = null;

         if(uniStCodigo != null ){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();
                     String query = " from LabRequisicao l where "; //l.uniStCodigo = 'ACL' and reqStCodigo = '0915151515' ";
                 
                      if(oriStCodigo != null){
                                    query = query+" l.oriStCodigo = '"+oriStCodigo.getOriStCodigo()+"'  ";
                        }

                        if(pacInCodigo != null){
                            query = query+" and l.pacInCodigo = '"+pacInCodigo.getPacInCodigo().toString()+"'";
                        }
                        if(uniStCodigo != null){
                            query = query+" and l.uniStCodigo = '"+uniStCodigo.getUniStCodigo()+"'";
                        }


                      if(locStCodigo != null){
                           query = query+" and l.locStCodigo = '"+locStCodigo+"'";
                        }
                      if(dtInicio != null && dtFinal != null){

                            String DATE_FORMAT = "dd-MMM-yy";
                            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                            
                            query = query+" and l.reqDtCadastro >= ('"+sdf.format(dtInicio)+"', 'dd-MMM-yy')" +
                            "  and  l.reqDtCadastro <=('"+sdf.format(dtFinal)+"', 'dd-MMM-yy')" ;
                      }

                     org.hibernate.Query q = session.createQuery(query );
                     q.setMaxResults(1000);
                     result = q.list();
                     tx.commit();

                        return result;


                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }





  


   /**
 *@return a Map<LabDetalheRequisicao,LabDetalheRequisicao> of LabRequisicao based on pacInCodigo .
  * no index create don't use it.
 */
  public static Map<LabDetalheRequisicao,LabDetalheRequisicao> getMapLabDetalheRequisicaoByReqStCodigo(String reqStCodigo){

         List<LabDetalheRequisicao> result = null;
         Map<LabDetalheRequisicao,LabDetalheRequisicao> map = new HashMap<LabDetalheRequisicao, LabDetalheRequisicao>();




         if(reqStCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabDetalheRequisicao l where l.reqStCodigo = '"+reqStCodigo+"' order by derInCodigo");

                    // q.setString("cpf", cpf.trim());

                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {

                         for(LabDetalheRequisicao ldr : result){
                             ldr.setSalvoNoDb(true);
                             map.put(ldr, ldr);
                         }


                        return map;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return map;

 }







   /**
 *@return a list of LabExame based on pacInCodigo .
  * no index create don't use it.
 */
  public static List<LabExame> getListLabExameByPacInCodigo(LabPaciente pacInCodigo){

         
         List<LabRequisicao>  listLabRequisicao = null;
         List<LabDetalheRequisicao> listLabDetalheRequisicao = null;
         List<LabExame> listLabExame = null;



         if(pacInCodigo != null){
                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = 
                             session.createQuery("from LabRequisicao l where l.pacInCodigo = '"+pacInCodigo.getPacInCodigo()+"' ");
                      listLabRequisicao = q.list();
                      

                      if(listLabRequisicao != null && listLabRequisicao.size()>0){
                          //System.out.println(listLabRequisicao.size());
                          for(LabRequisicao lr : listLabRequisicao){
                                listLabDetalheRequisicao = lr.getListLabDetalheRequisicao();
                               
                                //System.out.println(listLabDetalheRequisicao.size());
                                    if(listLabDetalheRequisicao != null && listLabDetalheRequisicao.size()>0){
                                        listLabExame = new ArrayList<LabExame>();
                                        for(LabDetalheRequisicao ldr : listLabDetalheRequisicao){
                                            listLabExame.add(new LabExame(ldr.getExaStCodigo()));
                                        }
                                    }
                          }
                      }
                      tx.commit();

                     return listLabExame;

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }





   /**
 *@return a list of ExameBean based on pacInCodigo .
  * no index create don't use it.
 */
  public static List<ExameBean> getListExameBeanByPacInCodigo(LabPaciente pacInCodigo){

         List<LabRequisicao>  listLabRequisicao = null;
         List<LabDetalheRequisicao> listLabDetalheRequisicao = new ArrayList<LabDetalheRequisicao>();
         List<ExameBean> listExameBean = new ArrayList<ExameBean>();
       



         if(pacInCodigo != null){
                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     LabPaciente lp = pacInCodigo;
                     

                     org.hibernate.Query q  = session.createQuery("from LabRequisicao l where l.pacInCodigo = :pacInCodigo ");
                     q.setLong("pacInCodigo", pacInCodigo.getPacInCodigo());

                     listLabRequisicao = q.list();
                     if(listLabRequisicao != null & listLabRequisicao.size()>0){
                        
                         for(LabRequisicao lr : listLabRequisicao){
                               String codigo = lr.getReqStCodigo();

                                                                  org.hibernate.Query q2 =  session.createQuery("from LabDetalheRequisicao l where l.reqStCodigo = :reqStCodigo ");
                                                                  q2.setString("reqStCodigo", codigo);
                                                                  List <LabDetalheRequisicao> listLdr = q2.list();
                                       if(listLdr != null && listLdr.size()>0){
                                           for(LabDetalheRequisicao l : listLdr){
                                                listLabDetalheRequisicao.add(l);
                                           }
                                       }
                         }
                     }


                     if(listLabDetalheRequisicao.size()>0){
                         for(LabDetalheRequisicao l : listLabDetalheRequisicao){
                             ExameBean ex = new ExameBean(); 
                             LabExame e = (LabExame) OracleHelper.getObject(LabExame.class,l.getExaStCodigo());
                             ex.setStrExameDescricao(e.getExaStDescricao());
                             ex.setStrExameExame(l.getExaStCodigo());
                             ex.setStrExameStatus(l.getLegStCodigo());
                             listExameBean.add(ex);

                         }
                     }

                      tx.commit();
                     

                     return listExameBean;

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }





  /**
 *@return a list of ExameBean based on pacInCodigo .
  * no index create don't use it.
 */
  public static List<MaterialBean> getListMaterialBeanByReqStCodigo(List<LabDetalheRequisicao>  listLabDReq){

         
         if(listLabDReq != null  && listLabDReq.size()>0){
                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();//0914924   213004365875
                                                                                    //0914924
                     if(listLabDReq.size()>0){
                         for(LabDetalheRequisicao l : listLabDReq){
                             if(l.getMatStCodigo() != null){
                                 LabMaterial lm = (LabMaterial) getObject(LabMaterial.class, l.getMatStCodigo());
                                 MaterialBean mb = new MaterialBean(); mb.setStrMaterialCodigo(lm.getMatStCodigo()); mb.setStrMaterialDescricao(lm.getMatStDescricao());
                              //  listMaterialBeans.add(mb);
                             }



                         }
                     }


                      tx.commit();


                     return null;// listMaterialBeans;

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }

/**
 *
 * @param reqStCodigo
 * @return a List<List> index 0 = list of ExameBean index 1 = list of MaterialBean...
 */
public static List<ExameBean> getListExamePlustListMaterial(String reqStCodigo){
     
    reqStCodigo = reqStCodigo.trim();
    List<ExameBean> listExameBean;
    List<MaterialBean> listMaterialBean;
    List<LabDetalheRequisicao> listLabDetalheRequisicao = null;

    if(reqStCodigo !=  null){
        listExameBean = new ArrayList<ExameBean>();
        listMaterialBean = new ArrayList<MaterialBean>();


                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();



                      org.hibernate.Query q =  session.createQuery("from LabDetalheRequisicao l where l.reqStCodigo = :reqStCodigo order by derInCodigo ");
                      q.setString("reqStCodigo", reqStCodigo);
                      listLabDetalheRequisicao = q.list(); 



                                 if( listLabDetalheRequisicao != null && listLabDetalheRequisicao.size()>0){
                                     for(LabDetalheRequisicao l : listLabDetalheRequisicao){
                                         if(l.getMatStCodigo() != null){
                                                     ExameBean ex = new ExameBean();
                                                     
                                                     LabExame e = (LabExame) OracleHelper.getObject(LabExame.class,l.getExaStCodigo());
                                                     
                                                     ex.setStrExameDescricao(e.getExaStDescricao());
                                                     ex.setStrExameExame(e.getExaStCodigo());
                                                     ex.setStrExameStatus(l.getLegStCodigo());
                                                     ex.setStrLegStSigla(l.getLegStSigla());


                                                    if(l.getMatStCodigo() != null){
                                                        LabMaterial lm = (LabMaterial) getObject(LabMaterial.class, l.getMatStCodigo());
                                                        ex.setStrMatStCodigo(lm.getMatStCodigo());
                                                        ex.setStrMatStDescricao(lm.getMatStDescricao());
                                                        
                                                    }


                                                     listExameBean.add(ex);
                                         }




                                     }
                                 }



                     

                      tx.commit();

                      
                    

                     return listExameBean;

                 }finally{
                      if(session != null){
                         session.close();
                     }
                 }
        

    }

    return null;
}



public static LabUnidade getLabUnidadeByUniStCodigo(String uniStCodigo){
    uniStCodigo = uniStCodigo.toUpperCase().trim();
    
    if(uniStCodigo != null && uniStCodigo.length()>1){
        try{
                     session = getSessionDude();
                     tx = session.beginTransaction();
                     org.hibernate.Query q =  session.createQuery("from LabUnidade where uniStCodigo = :uniStCodigo ");
                     q.setString("uniStCodigo", uniStCodigo);
                     tx.commit();

                     List<LabUnidade> list = q.list();
                     if(list != null && list.size()>0){
                         return list.get(0);
                     }

        }finally{

                 if(session != null){
                        session.close();
                 }
        }



    }


    return null;
}




public static List<LabUnidade> getListLabUnidadeOrderByUniStCodigo(){
   
    
        try{
                     session = getSessionDude();
                     tx = session.beginTransaction();
                     org.hibernate.Query q =  session.createQuery("from LabUnidade where uniStCodigo != null order by uniStCodigo ");
                    
                     tx.commit();

                     List<LabUnidade> list = q.list();
                     if(list != null && list.size()>0){
                         return list;
                     }

        }finally{

                 if(session != null){
                        session.close();
                 }
        }



    


    return null;
}






 /**
 *@return a list of LabPaciente based on pacStProntuario .
  * 
 */
  public static List<LabPaciente> getListLabPacienteByProntuario(String prontuario){

         
         List<LabPaciente> result = null;
         prontuario = prontuario.trim();



         if(prontuario != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStProntuario like '"+prontuario+"' ");
                     q.setMaxResults(100);

                 
                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }

   /**
 *@return a list of LabPaciente based on pacStProntuario and uniStCodigo.
  *
 */
  public static List<LabPaciente> getListLabPacienteByProntuario_UniStCodigo(LabUnidade uniStCodigo,String prontuario){

         
         List<LabPaciente> result = null;
         prontuario = prontuario.trim();



         if(prontuario != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     if(uniStCodigo != null && prontuario != null){
                         Criteria criteria = session.createCriteria(LabPaciente.class);
                         if(prontuario != null){
                            criteria.add(Restrictions.like("pacStProntuario", prontuario));
                          }
                          if(uniStCodigo != null){
                            criteria.add(Restrictions.like("uniStCodigo", uniStCodigo));
                          }
                          
                          criteria.setMaxResults(100);
                          result = criteria.list();
                          tx.commit();
                     }



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }
	    return null;

 }



   /**
 *@return a list of LabPaciente based on pacStNome .
  *
 */
  public static List<LabPaciente> getListLabPacienteByPacStNome(String nome){

         
         List<LabPaciente> result = null;
         nome = nome.toUpperCase().trim().replaceAll("[^a-zA-Z&&[\\S]]", "");



         if(nome != null && nome.length()>8){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStNome like '"+nome+"%' ");
                     q.setMaxResults(100);


                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }

   /**
 *@return a list of LabPaciente based on pacStNome .
  *
 */
  public static List<LabPaciente> getListLabPacienteByPacStNomeUniStCodigo(String nome,String uniStCodigo){

         
         List<LabPaciente> result = null;
         nome = nome.toUpperCase().trim().replaceAll("[^a-zA-Z&&[\\S]]", "");



         if(nome != null && nome.length()>8){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStNome like '"+nome+"%'  and uniStCodigo = '"+uniStCodigo+"' ");
                     q.setMaxResults(50);


                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a list of LabPaciente based on pacStNome .
  *
 */
  public static List<LabPacienteBean> getListLabPacienteBeanByPacStNome(String nome){

         
         List<LabPaciente> result = null;
         List<LabPacienteBean> listPacBean = null;
         nome = nome.toUpperCase().trim().replaceAll("[^a-zA-Z&&[\\S]]", "");



         if(nome != null && nome.length()>8){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStNome like '"+nome+"%' ");
                     q.setMaxResults(50);
                     

                     result = q.list();
                     if(result.size()>0){
                         listPacBean = new ArrayList<LabPacienteBean>();
                         for(LabPaciente lp : result){
                             LabPacienteBean lpb = new LabPacienteBean();
                             lpb.setPacInCodigo(lp.getPacInCodigo());
                             lpb.setPacStNome(lp.getPacStNome());
                             lpb.setPacDtNascimento(lp.getPacDtNascimento());
                             lpb.setUniStCodigo(lp.getUniStCodigo());
                             listPacBean.add(lpb);
                         }
                     }



                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return listPacBean;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }






  /**
 *@return a list of LabPaciente based on pacStRG .
  *
 */
  public static List<LabPaciente> getListLabPacienteByPacStRG(String rg){

         
         List<LabPaciente> result = null;
         rg = rg.toUpperCase().trim();



         if(rg != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStRG like '"+rg+"' ");
                     q.setMaxResults(100);


                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }

   /**
 *@return a list of LabPaciente based on pacStRG and uniStCodigo.
  *
 */
  public static List<LabPaciente> getListLabPacienteByPacStRG_UniStCodigo(LabUnidade uniStCodigo,String pacStRG){

         
         List<LabPaciente> result = null;
         if(pacStRG != null && uniStCodigo  != null){
                 try{
                     pacStRG = pacStRG.trim();
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     if(uniStCodigo != null && pacStRG != null){
                         Criteria criteria = session.createCriteria(LabPaciente.class);
                         if(pacStRG != null){
                            criteria.add(Restrictions.like("pacStRG", pacStRG));
                          }
                          if(uniStCodigo != null){
                            criteria.add(Restrictions.like("uniStCodigo", uniStCodigo));
                          }
                         criteria.setMaxResults(100);
                          result = criteria.list();
                          tx.commit();
                     }

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }
	    return null;

 }







   /**
 *@return a list of LabPaciente based on pacStCPF .
  *
 */
  public static List<LabPaciente> getListLabPacienteByPacStCPF(String cpf){

         
         List<LabPaciente> result = null;
         cpf = cpf.toUpperCase().trim();



         if(cpf != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStCPF like '"+cpf+"%' ");
                     q.setMaxResults(100);


                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }


   /**
 *@return a list of LabPaciente based on pacStCPF and uniStCodigo.
  *
 */
  public static List<LabPaciente> getListLabPacienteByPacStCPF_UniStCodigo(LabUnidade uniStCodigo,String pacStCPF){

         
         List<LabPaciente> result = null;
         if(pacStCPF != null && uniStCodigo  != null){
                 try{
                     pacStCPF = pacStCPF.trim();
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     if(uniStCodigo != null && pacStCPF != null){
                         Criteria criteria = session.createCriteria(LabPaciente.class);
                         if(pacStCPF != null){
                            criteria.add(Restrictions.like("pacStCPF", pacStCPF));
                          }
                          if(uniStCodigo != null){
                            criteria.add(Restrictions.like("uniStCodigo", uniStCodigo));
                          }
                          result = criteria.list();
                          tx.commit();
                     }

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }
	    return null;

 }






   /**
 *@return a list of LabPaciente based on pacStCPF .
  *
 */
  public static LabLocal  getLabLocalBylocStCodigo_uniStCodigo(String locStCodigo,String uniStCodigo){

         
         List<LabLocal> result = null;
       


         if(locStCodigo != null  && uniStCodigo != null){

              locStCodigo = locStCodigo.trim().toUpperCase();
              uniStCodigo = uniStCodigo.trim().toUpperCase();

                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabLocal l where l.locStCodigo = :locStCodigo and l.uniStCodigo = :uniStCodigo ");
                     q.setString("uniStCodigo", uniStCodigo);
                      q.setString("locStCodigo", locStCodigo);
                      result = q.list();

                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a list of LabLocal based on uniStCodigo .
  *
 */
  public static List<LabLocal> getListLabLocalByUniStCodigo(String uniStCodigo){


         List<LabLocal> result = null;
         uniStCodigo = uniStCodigo.toUpperCase().trim();



         if(uniStCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabLocal l where l.uniStCodigo like '"+uniStCodigo+"' ");


                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a list of LabConvenio based on uniStCodigo .
  *
 */
  public static List<LabConvenio> getListLabConvenioByUniStCodigo(String uniStCodigo){

         
         List<LabConvenio> result = null;
         List<LabConvenioUnidade>  cumList;
         uniStCodigo = uniStCodigo.toUpperCase().trim();



         if(uniStCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabConvenioUnidade l where l.uniStCodigo = '"+uniStCodigo+"'and l.cunChAtivo = 'S'");


                     cumList = q.list();
                     tx.commit();

                     if(cumList != null && cumList.size()>0){
                         result = new ArrayList<LabConvenio>();
                         for(LabConvenioUnidade lcu : cumList){
                             LabConvenio l = lcu.getConStCodigo();
                             if( l.getConChAtivo() != null && l.getConChAtivo().toString().equalsIgnoreCase("S")){
                                result.add(l);
                             }

                         }

                     }

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a list of LabConvenio based on uniStCodigo .
  *
 */
  public static  LabConvenio  getLabConvenioByUniStCodigoAndConStCodigo(String uniStCodigo,String conStCodigo){

         
         List<LabConvenio> result = null;
         List<LabConvenioUnidade>  cumList;
         uniStCodigo = uniStCodigo.toUpperCase().trim();



         if(uniStCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabConvenioUnidade l where l.uniStCodigo = '"+uniStCodigo+"'and l.cunChAtivo = 'S'  and l.conStCodigo = '"+conStCodigo+"'");


                     cumList = q.list();
                     tx.commit();

                     if(cumList != null && cumList.size()>0){
                         result = new ArrayList<LabConvenio>();
                         for(LabConvenioUnidade lcu : cumList){
                             LabConvenio l = lcu.getConStCodigo();
                             if( l.getConChAtivo() != null && l.getConChAtivo().toString().equalsIgnoreCase("S")){
                                result.add(l);
                             }

                         }

                     }

                     if (result != null && result.size() > 0) {
                        return result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a list of LabRegras based on uniStCodigo and conStCodigo .
  *
 */
  public static List<LabRegras> getListLabRegrasByUniStCodigoAndConStCodigo(String uniStCodigo,String conStCodigo){

         
         List<LabRegras> result = null;




         if(uniStCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabRegras l where l.uniStCodigo = '"+uniStCodigo+"'and l.conStCodigo = '"+conStCodigo+"'");


                     result = q.list();
                     tx.commit();

                  

                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



   /**
 *@return a list of LabRegras based on uniStCodigo and conStCodigo .
  *
 */
  public static LabRegras getLabRegrasByUniStCodigoAndConStCodigoAndRegStCodigo(String uniStCodigo,String conStCodigo,String regStCodigo){

         
         List<LabRegras> result = null;

         if(uniStCodigo != null){
                 try{
                     session = getSessionDude();//sessionFactory.getCurrentSession();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabRegras l where l.uniStCodigo = '"+uniStCodigo+"'and l.conStCodigo = '"+conStCodigo+"' and l.regStCodigo = '"+regStCodigo+"' ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }




    /**
 *@return a list of LabOrigem based on uniStCodigo.
  *
 */
  public static List<LabOrigem> getListLabOrigemByUniStCodigo(String uniStCodigo){

         
         List<LabOrigem> result = null;




         if(uniStCodigo != null){
                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabOrigem l where l.uniStCodigo = '"+uniStCodigo+"'");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }



    /**
 *@return a  LabOrigem based on uniStCodigo and oriStCodigo.
  *
 */
  public static LabOrigem  getLabOrigemByUniStCodigo(String uniStCodigo,String oriStCodigo){

         
         List<LabOrigem> result = null;

         if(uniStCodigo != null){
                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabOrigem l where l.uniStCodigo = '"+uniStCodigo+"' and l.oriStCodigo = '"+oriStCodigo+"' ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
         }



	    return null;

 }


   /**
 *@return a  LabSolicitante based on solStEstado and proStCodigo and solStCodigo.
  *
 */
  public static LabSolicitante  getLabSolicitanteBySolStEstado_ProStCodigo_SolStCodigo(String solStEstado,String proStCodigo,String solStCodigo){

         
         List<LabSolicitante> result = null;


                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabSolicitante l where l.solStEstado = '"+solStEstado+"' and l.proStCodigo = '"+proStCodigo+"'  and l.solStCodigo = '"+solStCodigo+"' ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

 }


  



    /**
 *@return a  List LabSolicitante based on solStEstado and proStCodigo and solStCodigo.
  *
 */
  public static List<LabSolicitante>  getListLabSolicitanteBySolStEstado_ProStCodigo(String solStEstado, String proStCodigo){

         
         List<LabSolicitante> result = null;


                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabSolicitante l where l.solStEstado = '"+solStEstado+"'  and l.proStCodigo = '"+proStCodigo+"'  and l.solStCodigo <> '0' ");
                     q.setMaxResults(50);


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

 }


   /**
 *@return a  List LabSolicitante based on solStEstado.
  *
 */
  public static List<LabSolicitante>  getListLabSolicitanteBySolStEstado(String solStEstado){

         
         List<LabSolicitante> result = null;


                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabSolicitante l where l.solStEstado = '"+solStEstado+"'  ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

 }




 /**
 *@return a  LabColetor based on colStCodigo and uniStCodigo.
  *
 */
  public static LabColetor  getLabColetorByColStCodigo_UniStCodigo(String colStCodigo,String uniStCodigo){

         
         List<LabColetor> result = null;


                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabColetor l where l.colStCodigo = '"+colStCodigo+"' and l.uniStCodigo = '"+uniStCodigo+"'  ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result.get(0);
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

 }


  /**
 *@return a List LabColetor based on  uniStCodigo.
  *
 */
  public static List<LabColetor>  getListLabColetorByUniStCodigo(String uniStCodigo){

         
         List<LabColetor> result = null;

                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabColetor l where l.uniStCodigo = '"+uniStCodigo+"'  ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

 }



 /**
     *
     * @param LabReuisicao and save the obj given the propriete next id
     *
     */
     public static  LabRequisicao  saveLabRequisicao(LabRequisicao lr){
        
        Locale loc = new Locale("pt", "BR");
        DateFormat df  = DateFormat.getDateInstance(DateFormat.SHORT);
        String idFromOracle = OracleConnector.getReqStCodigo();
        int count = 0;
        while(idFromOracle== null && count<5){
            idFromOracle = OracleConnector.getReqStCodigo();
            count++;
            if(idFromOracle != null && idFromOracle.length()>5){
                break;
            }
        }

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        String strDate = df.format(today);
         int i = strDate.length();
        String year = strDate.substring(i-2, i);
        
        
        
        try{
            String id = year+idFromOracle;
            lr.setReqInCodigo(new Long(id));
            lr.setReqStCodigo(id);
            
        session = getSessionDude();
        tx = session.beginTransaction();
        session.save(lr);
        tx.commit();

        return lr;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }






     /**
 *@return a List LabExameGrupo based on  exaStCodigo grpStCodigo uniStCodigo.
  *
 */
  public static List<LabExameGrupo>  getListLabExameGrupoByExaStCodigo_GrpStCodigo_UniStCodigo
          (String exaStCodigo,String grpStCodigo,String uniStCodigo){

         
         List<LabExameGrupo> result = null;

                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabExameGrupo l where l.uniStCodigo = '"+uniStCodigo+"'" +
                             " and l.exaStCodigo = '"+exaStCodigo+"' " +
                             "   and l.grpStCodigo = '"+grpStCodigo+"' ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

 }



    /**
 *@return a List LabExameGrupo based on  exaStCodigo grpStCodigo uniStCodigo.
  *
 */
  public static List<LabExameGrupo>  getListLabExameGrupoByGrpStCodigo_UniStCodigo
          (String grpStCodigo,String uniStCodigo){

         
         List<LabExameGrupo> result = null;

                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabExameGrupo l where l.uniStCodigo = '"+uniStCodigo+"'" +
                             "   and l.grpStCodigo = '"+grpStCodigo+"' ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

 }



  public static List<LabExameDependente> getListLabExameDependente(String exaStCodigo, String uniStCodigo){
        
         List<LabExameDependente> result = null;

                 try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabExameDependente l where l.uniStCodigo = '"+uniStCodigo+"'" +
                             "   and l.exaStCodigo = '"+exaStCodigo+"' ");


                     result = q.list();
                     tx.commit();



                     if (result != null && result.size() > 0) {
                        return result;
                      }

                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }




	    return null;

  }


   /**
     *
     * @param save a list of LabDetalheRequisicao and set de derInCodigo at the same time
     */
     public static void saveListLabDetalherRequisicao(List<LabDetalheRequisicao> list){

         
         try{

             if(list != null && list.size()>00){
                              session = getSessionDude();
                              tx = session.beginTransaction();

                             for(LabDetalheRequisicao ldr : list){
                                 ldr.setDerInCodigo(OracleConnector.getDerInCodigo());
                                 if(ldr.getDerInCodigo() != null){
                                    session.save(ldr);
                                 }
                                 
                             }
                             tx.commit();
             }

           
         }finally{
             if(session != null){
                 session.close();
             }
         }

    }




     /**
     *
     * @param clazz
     * @param uf
     * @return LabEstado
     */
     public static LabEstado  getLabEstado(String uf){

        session = getSessionDude();
        tx = session.beginTransaction();
        
        List<LabEstado> result ;

        if(uf != null && uf.trim().length()>1){
             try{
                     session = getSessionDude();
                     tx = session.beginTransaction();

                     org.hibernate.Query q = session.createQuery("from LabEstado l where l.estStUF ='"+uf.toUpperCase()+"'" );

                     result = q.list();
                     tx.commit();

                     if (result != null && result.size() > 0) {
                        return result.get(0);
                      }
                      return null;
                 }finally{
                     if(session != null){
                         session.close();
                     }
                 }
        }
       

        return null;
    }


public static List<LabConfigIngresso> getListLabConfiruraConfigIngressos(String exaStCodigo,String metStCodigo,Date emvDtValidade){

     session = getSessionDude();
     tx = session.beginTransaction();
     
    try{

        Criteria criteria = session.createCriteria(LabConfigIngresso.class);
        criteria.add(Restrictions.eq("exaStCodigo", exaStCodigo));
        criteria.add(Restrictions.eq("metStCodigo", metStCodigo));
        criteria.add(Restrictions.eq("emvDtValidade", emvDtValidade));

        return criteria.list();

    }finally{
                   if(session != null){
                       session.close();
                   }
    }

 
}



  /**
     *
     * @param clazz
     * @param id
     * @return String
     */
     public static String  getPacienteNextValue(){


         session = getSessionDude();
         tx = session.beginTransaction();
        List result ;


        try{
       org.hibernate.Query query = session.createSQLQuery("SELECT NEXT VALUE FOR PPACIENTE FROM RDB$DATABASE");//createQuery("EXECUTE PROCEDURE STATUSAMOSTRAPERFIL_NEW 2010102748588602,001,null");
         result = query.list();
        tx.commit();
            if(result != null){
                 return  null;
            }

        return null;
        }finally{
            if(session != null){
                session.close();
            }
        }


    }



   static public  LabConfigIngresso getLabConfigIngresso(String cinStCodigo,Date emvDtValidade,String exaStCodigo,String metStCodigo){

        
        List<LabConfigIngresso> result = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();


            Criteria criteria = session.createCriteria(LabConfigIngresso.class);

            if(cinStCodigo != null){
                criteria.add(Restrictions.eq("cinStCodigo", cinStCodigo));
            }
            if(emvDtValidade != null){
                criteria.add(Restrictions.eq("emvDtValidade", emvDtValidade));
            }
            if(exaStCodigo != null){
                criteria.add(Restrictions.eq("exaStCodigo", exaStCodigo));
            }
            if(metStCodigo != null){
                criteria.add(Restrictions.eq("metStCodigo", metStCodigo));
            }
            tx.commit();

            result = criteria.list();
            if(result != null && !result.isEmpty()){
                return result.get(0);
            }else{
                return null;
            }

        }finally{
            if(session != null){
                session.close();
            }
        }


  }

   
   
   static public  List<Object> getListObjectsByOrs(Class myClass,String strFieldName,List listArgs){    

        
        if(listArgs != null && listArgs.size()>0){
            
            
            try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();


            Criteria criteria = session.createCriteria(myClass);

            Disjunction disj;
            Property property = Property.forName(strFieldName);

            
            if(listArgs != null && listArgs.size()>0){
                disj = Restrictions.disjunction();
                for(Object strArgs : listArgs){
                    disj.add(property.eq(strArgs));
                }
                tx.commit();
                return criteria.add(disj).list();
                
            }
            
                return  null;
            }finally{
                if(session != null){
                    session.close();
                }
            }

            
            
        }else{
            return null;
        }
        
  }
   
   
   static public  List getListObjectsByAnds(Class myClass,Map<String,Object> mapArgs){

       if(mapArgs != null && mapArgs.size()>0){
           
                   try{
                    session = getSessionDude();//sessionFactory.getCurrentSession();
                    tx = session.beginTransaction();


                    Criteria criteria = session.createCriteria(myClass);
                    Iterator iter = mapArgs.entrySet().iterator();

                    while(iter.hasNext()){
                        Map.Entry<String,Object> pair =  (Map.Entry<String,Object>) iter.next();
                        criteria.add(Restrictions.eq(pair.getKey(),pair.getValue()));
                    }

                        tx.commit();
                        return criteria.list();

                    }finally{
                        if(session != null){
                            session.close();
                        }
                    }
           
       }else{
           return null;
       }
        

  }
   
   
   static public  List getListObjectsByAnds_Ors(Class myClass,Map<String,Object> mapArgsAnds,String strFieldName,List listArgsOrs){

    
    
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);

            if(mapArgsAnds != null && mapArgsAnds.size()>0){
                
                Iterator iter = mapArgsAnds.entrySet().iterator();
                while(iter.hasNext()){
                    Map.Entry<String,Object> pair =  (Map.Entry<String,Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(),pair.getValue()));
                }
            }
            
            if(listArgsOrs != null && listArgsOrs.size()>0){
                Disjunction disj;
            Property property = Property.forName(strFieldName);

            
            if(listArgsOrs != null && listArgsOrs.size()>0){
                disj = Restrictions.disjunction();
                for(Object strArgs : listArgsOrs){
                    disj.add(property.eq(strArgs));
                }
                return criteria.add(disj).list();
            }
            tx.commit();
            return  criteria.list();
                
                
            }
            
            return  null;
        }finally{
            if(session != null){
                session.close();
            }
        }


  }
   
   
   
   
   
   static public  List getListObjectsByAnds_Ors_Dates
           
           (Class myClass,Map<String,Object> mapArgsAnds,String strFieldNameOrs,List listArgsOrs,String strDateFieldName,Date dtStart,Date dtEnd){

        
        List<LabConfigIngresso> result = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);
            
            
            if(dtStart != null &&dtEnd != null){
                
               if(strDateFieldName != null){
                    if(dtEnd.after(dtStart)){
//                         System.out.println("Restrictions.between");
                        criteria.add(Expression.between(strDateFieldName, dtStart, dtEnd));
                    }else if(dtEnd.equals(dtStart)){
                        criteria.add(Restrictions.eq(strDateFieldName, dtStart));
                    }else if(dtEnd.before(dtStart)){
                        criteria.add(Restrictions.eq(strDateFieldName, dtStart));
                    }
                     criteria.addOrder( Order.asc(strDateFieldName) );
                    
                }
                
            }

            if(mapArgsAnds != null && mapArgsAnds.size()>0){
                
                Iterator iter = mapArgsAnds.entrySet().iterator();
                while(iter.hasNext()){
                    Map.Entry<String,Object> pair =  (Map.Entry<String,Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(),pair.getValue()));
                }
            }
            
            
            
            if(listArgsOrs != null && listArgsOrs.size()>0  && strFieldNameOrs != null){
                Disjunction disj;
            Property property = Property.forName(strFieldNameOrs);
   
                    if(listArgsOrs != null && listArgsOrs.size()>0){
                        disj = Restrictions.disjunction();
                        for(Object strArgs : listArgsOrs){
                            disj.add(property.eq(strArgs));
                        }
                        criteria.setMaxResults(100000);
                        return criteria.add(disj).list();
                    }
           
            }
            
               criteria.setMaxResults(100000);
            
            tx.commit();
            return  criteria.list();
                
            
            
        }finally{
            if(session != null){
                session.close();
            }
        }


  }
   
   
   
   public static List<LabUnidade> getListLabUnidadeByLabUsuario(LabUsuario labUsuario){
       List<LabUnidade> listLabUnidades ;
       if(labUsuario != null){
           List<LabUsuarioUnidade> listLabUsuarioUnidades =(List<LabUsuarioUnidade>) 
                   OracleHelper.getListOfObjectByKeyEq(LabUsuarioUnidade.class,"usuStCodigo",labUsuario ,"uniStCodigo" ,true);
           if(listLabUsuarioUnidades != null && listLabUsuarioUnidades.size()>0){
               listLabUnidades = new ArrayList<LabUnidade>(listLabUsuarioUnidades.size());
               
               for(LabUsuarioUnidade luu : listLabUsuarioUnidades){
                    LabUnidade lu = (LabUnidade)OracleHelper.getObject(LabUnidade.class, luu.getUniStCodigo());
                    if(lu != null){
                        listLabUnidades.add(lu);
                    }
                }
               return listLabUnidades;
           }
       }
       return null;
   }
   
   
   
   

}//end of the class
