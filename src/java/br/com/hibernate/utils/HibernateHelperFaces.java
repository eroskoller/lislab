/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.utils;


import java.util.*;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.Logger;

/**
 *
 * @author eros
 */
public class HibernateHelperFaces {





 


static protected Logger log = Logger.getLogger("logs4.tmdonor");





    public static Session getSessionDude(){
      
        Session session = null;
        if(session == null){
        return session = HibernateUtilFaces.getCurrentSession4Faces();
        }else{
            return session;
        }
    }

    public static void openHiberSession(){
        Session session = getSessionDude();
        if(session == null){
            session = HibernateUtilFaces.getCurrentSession4Faces();
        }

    }






    public static void addObject(Object obj){
        Session session = null;
        Transaction tx = null;
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

    public static void addOrUpdateObject(Object obj){
        Session session = null;
        Transaction tx = null;
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


    public static void addObject4List(Object obj,Session s){
        Session session = s;

        session = getSessionDude();
        //session = getSessionDude();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(obj);
        tx.commit();
       session.close();


    }


    public static void addListObjects(List list){
        Session session = getSessionDude();//sessionFactory.getCurrentSession();
        Transaction tx = session.getTransaction();
        for(Object obj : list){

                addObject(obj);

        }
        tx.commit();
        session.close();
    }

    public static Object getObject(Class clazz,long id){
     
        Session session = getSessionDude();//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

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
     
//     public static ReceptorHiber getReceptorHiberByNomeRGCPF(String nome, String rg, String cpf){
//            Session session = null;
//            Transaction tx = null;
//             List list = new ArrayList();
//
//                try{
//                    session = getSessionDude();
//                     tx = session.beginTransaction();
//
//                 if(nome != null && rg != null && cpf != null){
//
//                        Query q = session.createQuery("from ReceptorHiber r where r.receptorNome = '"+nome+"'  and r.receptorRG = '"+rg+"' and r.receptorCPF = '"+cpf+"' ");
//                        list = q.list();
//                        Transaction t = session.beginTransaction();
//                        t.commit();
//
//                        if(list != null && list.size() > 0){
//                            return (ReceptorHiber) list.get(0);
//                        }else{
//                            return null;
//                        }
//
//
//                 }else if(nome != null && rg != null){
//                     Query q = session.createQuery("from ReceptorHiber r where r.receptorNome = '"+nome+"'  and r.receptorRG = '"+rg+"' " );
//                        list = q.list();
//                        Transaction t = session.beginTransaction();
//                        t.commit();
//
//                        if(list != null && list.size() > 0){
//                            return (ReceptorHiber) list.get(0);
//                        }else{
//                            return null;
//                        }
//
//                 }else if(nome != null && rg != null){
//                     Query q = session.createQuery("from ReceptorHiber r where r.receptorNome = '"+nome+"' " +
//                                " and r.receptorCPF = '"+cpf+"' ");
//                        list = q.list();
//                        Transaction t = session.beginTransaction();
//                        t.commit();
//
//                        if(list != null && list.size() > 0){
//                            return (ReceptorHiber) list.get(0);
//                        }else{
//                            return null;
//                        }
//                 }else{
//                        return null;
//                 }
//                }finally{
//                    if(session != null){
//                        session.close();
//                    }
//                }
//
//
//
//     }



//     public static ReceptorHiber getReceptorHiberCPF(String cpf){
//            Session session = null;
//            Transaction tx = null;
//             List list = new ArrayList();
//
//                try{
//                    session = getSessionDude();
//                    tx = session.beginTransaction();
//                      if(cpf != null){
//
//                            cpf = cpf.trim();
//
//                            Query q = session.createQuery("from ReceptorHiber r where r.receptorCPF = '"+cpf+"' ");
//                            list = q.list();
//                            Transaction t = session.beginTransaction();
//                            t.commit();
//
//                            if(list != null && list.size() > 0){
//                                return (ReceptorHiber) list.get(0);
//                            }else{
//                                return null;
//                            }
//
//
//                     }
//                }finally{
//                    if(session != null){
//                        session.close();
//                    }
//                }
//         return null;
//     }



//      public static DoadorHiber getDoadorHiberCPF(String cpf){
//             List list = new ArrayList();
//             Session session = null;
//             Transaction tx = null;
//
//                try{
//                     session = getSessionDude();//sessionFactory.getCurrentSession();
//                     tx = session.beginTransaction();
//                      if(cpf != null){
//
//                            cpf = cpf.trim();
//
//                            Query q = session.createQuery("from DoadorHiber d where d.doadorCPF = '"+cpf+"' ");
//                            list = q.list();
//
//                            tx.commit();
//
//                            if(list != null && list.size() > 0){
//                                return (DoadorHiber) list.get(0);
//                            }else{
//                                return null;
//                            }
//
//
//                     }
//                }finally{
//                    if(session != null){
//                        session.close();
//                    }
//                }
//         return null;
//     }






    public static List getReceptorHiberList(){

        Session session = getSessionDude();//sessionFactory.getCurrentSession();


                List list = new ArrayList();

                Query q = session.createQuery("from ReceptorHiber r where r.receptorId != null");
                list = q.list();
                Transaction t = session.beginTransaction();
                t.commit();
                session.close();

        return list;
    }


    public static List getDoadorHiberList(){
        List list;
        Session session = null;
        Transaction tx = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.getTransaction();
            list = new ArrayList();

            Query q = session.createQuery("from DoadorHiber r where r.doadorId != null");
            list = q.list();
            Transaction t = session.beginTransaction();
            t.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }

            return list;
    }


    public static void updateObject(Object obj){
        Session session = null;
        Transaction tx = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            session.update(obj);
            tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }

    }

    public static void updateObjectList(List list){
       Session session = null;
       Transaction tx = null;
       try{
           session = getSessionDude();//sessionFactory.getCurrentSession();
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

    public static void mergeObject(Object obj){

        Session session = null;
        Transaction tx = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            session.merge(obj);

            tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }



    }

    public static void mergeObjectList(List list){

        Session session = null;
        Transaction tx = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            for(Object obj: list){
                session.merge(obj);
            }
            tx.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }


    }


     public static void saveObject(Object obj){
         Session session = null;
         Transaction tx = null;
         try{
             session = getSessionDude();//sessionFactory.getCurrentSession();
             tx = session.beginTransaction();

             session.save(obj);
             tx.commit();
         }finally{
             if(session != null){
                 session.close();
             }
         }

    }


     public static void saveObjectList(List list){

         Session session = null;
         Transaction tx = null;
         try{
             session = getSessionDude();//sessionFactory.getCurrentSession();
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
 * @param stId
 * @return DoadorHiber
 */
//public static DoadorHiber getDoadorByIdSt(String stId){
//    stId = stId.trim();
//    DoadorHiber doador;
//    if(stId != null && !stId.equals("")){
//        doador = (DoadorHiber) HibernateHelperFaces
//                .getObjectDataByKey(DoadorHiber.class, "doadorIdSt", stId);
//        return doador;
//    }
//
//    return null;
//}

/**
 *
 * @param stId
 * @return ReceptorHiber
 */
//public static ReceptorHiber getReceptorByIdSt(String stId){
//    stId = stId.trim();
//    ReceptorHiber receptor;
//    if(stId != null && !stId.equals("")){
//        receptor = (ReceptorHiber) HibernateHelperFaces
//                .getObjectDataByKey(ReceptorHiber.class, "receptorIdSt", stId);
//        return receptor;
//    }
//
//    return null;
//}


/**
 *
 * @param rgct
 * @return ReceptorHiber
 */
//public static ReceptorHiber getReceptorByRGCT(String rgct){
//    rgct = rgct.trim();
//    ReceptorHiber receptor;
//    if(rgct != null && !rgct.equals("")){
//        receptor = (ReceptorHiber) HibernateHelperFaces
//                .getObjectDataByKey(ReceptorHiber.class, "receptorRGCT", rgct);
//        return receptor;
//    }
//
//    return null;
//}

/**
 *
 * @param rgct
 * @return DoadorHiber
 */
//public static DoadorHiber getDoadorByRGCT(String rgct){
//    rgct = rgct.trim();
//    DoadorHiber doador;
//    if(rgct != null && !rgct.equals("")){
//        doador = (DoadorHiber) HibernateHelperFaces
//                .getObjectDataByKey(DoadorHiber.class, "doadorRGCT", rgct);
//        return doador;
//    }
//
//    return null;
//}



/**
 *
 * @param stId
 * @return TipagemDoadorHLAHiber
 */
//public static TipagemDoadorHLAHiber getTipagemDoadorHLAHiberByIdSt(String stId){
//    stId = stId.trim();
//    TipagemDoadorHLAHiber tip;
//    if(stId != null && !stId.equals("")){
//        tip = (TipagemDoadorHLAHiber) HibernateHelperFaces
//                .getObjectDataByKey(TipagemDoadorHLAHiber.class, "tipagemIdSt", stId);
//        return tip;
//    }
//
//    return null;
//}

/**
 *
 * @param stId
 * @return TipagemReceptorHLAHiber
 */
//public static TipagemRecepHLAHiber getTipagemRecepHLAHiberByIdSt(String stId){
//    stId = stId.trim();
//    TipagemRecepHLAHiber tip;
//    if(stId != null && !stId.equals("")){
//        tip = (TipagemRecepHLAHiber) HibernateHelperFaces
//                .getObjectDataByKey(TipagemRecepHLAHiber.class, "tipagemIdSt", stId);
//        return tip;
//    }
//
//    return null;
//}


/**
 *
 * @param stId
 * @return PRADoador
 */
//public static PRADoador getPRADoadorByIdSt(String stId){
//    stId = stId.trim();
//    PRADoador pra;
//    if(stId != null && !stId.equals("")){
//        pra = (PRADoador) HibernateHelperFaces
//                .getObjectDataByKey(PRADoador.class, "praIdSt", stId);
//        return pra;
//    }
//
//    return null;
//}

/**
 *
 * @param stId
 * @return PRAReceptor
 */
//public static PRAReceptor getPRAReceptorByIdSt(String stId){
//    stId = stId.trim();
//    PRAReceptor pra;
//    if(stId != null && !stId.equals("")){
//        pra = (PRAReceptor) HibernateHelperFaces
//                .getObjectDataByKey(PRAReceptor.class, "praIdSt", stId);
//        return pra;
//    }
//
//    return null;
//}

/**
 *
 * @deprecated don't use it
 * @param receptorId
 * @return
 */
//    public static List populateListDoadorDrop(Long receptorId){
//        List<DoadorDrop> listDrop = null;
//
//
//        Session session = null;
//        Transaction tx = null;
//
//
//
//        if(receptorId != null){
//                try{
//                    session = getSessionDude();
//                    tx = session.beginTransaction();
//                    tx.commit();
//                    ReceptorHiber rec = (ReceptorHiber) session.get(ReceptorHiber.class, receptorId); //HibernateHelperFaces.getObject(ReceptorHiber.class, receptorId);  //getObjectOpenSession(ReceptorHiber.class, receptorId);
//                    List l =  rec.getDoadorList();
//                    listDrop = new ArrayList<DoadorDrop>();
//                  //  tx.commit();
//                    for(Object obj : l){
//
//                                DoadorDrop dDrop = new DoadorDrop((DoadorHiber)obj);
//                                listDrop.add(dDrop);
//
//                            //this.setListDoadorDrop(listDrop);
//                        }
//
//
//                    return listDrop;
//
//                }finally{
//                    if(session != null){
//                        session.close();
//                    }
//                }
//        }
//
//        return null;
//
//    }
    /**
     *
     * @deprecated don't use it
     * @param receptorId
     * @return
     */
//    public static Set<DoadorDrop> populateSetDoadorDrop(Long receptorId){
//
//        Session session = null;
//        Transaction tx = null;
//        List<DoadorDrop> listDrop = null;
//        Set<DoadorDrop> set = null;
//
//
//
//
//        if(receptorId != null){
//                try{
//
//                    session = getSessionDude();
//                    tx = session.beginTransaction();
//                    tx.commit();
//                    ReceptorHiber rec = (ReceptorHiber) session.get(ReceptorHiber.class, receptorId);  //HibernateHelperFaces.getObject(ReceptorHiber.class, receptorId);//getObjectOpenSession(ReceptorHiber.class, receptorId);
//                    List l =  HibernateHelperFaces
//                            .getListDataByKey(DoadorHiber.class, "receptorFK", rec); //rec.getDoadorList();
//                    set = new HashSet<DoadorDrop>();
//
//                    for(Object obj : l){
//
//                                DoadorDrop dDrop = new DoadorDrop((DoadorHiber)obj);
//
//                                 set.add(dDrop);
//
//                        }
//
//
//                    return set;
//
//                }finally{
//                    if(session != null){
//                        session.close();
//                    }
//                }
//        }
//
//        return null;
//
//    }

    /**
     *
     * @deprecated don't use it !!!!!!!!!!!!!!!!!!!!!
     * @param doadorId
     * @return nothing
     */
//    public static Set<ReceptorDrop> populateSetReceptorDrop(Long doadorId){
//
//        List<ReceptorDrop> listDrop = null;
//        Set<ReceptorDrop> set = null;
//        Session session = null;
//        Transaction tx = null;
//
//
//
//
//        if(doadorId != null){
//                try{
//
//                    session = getSessionDude();
//                    tx = session.beginTransaction();
//                    tx.commit();
//                    DoadorHiber dh = (DoadorHiber) session.get(DoadorHiber.class, doadorId);  //(DoadorHiber) HibernateHelperFaces.getObject(DoadorHiber.class, doadorId);//getObjectOpenSession(DoadorHiber.class, doadorId);
//                    List l =   HibernateHelperFaces.
//                                    getListDataByKey(ReceptorHiber.class, "doadorFK", dh); //dh.getReceptorList(); //dh.getListDoadorOwnerReceptor();//getListReceptorOwnerDoador();
//                    set = new HashSet<ReceptorDrop>();
//
//                    for(Object obj : l){
//
//                                ReceptorDrop rDrop = new ReceptorDrop((ReceptorHiber)obj);
//
//                                 set.add(rDrop);
//
//                        }
//
//
//                    return set;
//
//                }finally{
//
//                    if(session != null){
//                        session.close();
//                    }
//
//                }
//        }
//
//        return null;
//
//    }

/**
 *
 * @deprecated don't use it !!!!!!!!!!!!!!!!!!!
 * @param doadorId
 * @return nothing
 */
//    public static List populateListReceptorDrop(Long doadorId){
//        List<ReceptorDrop> listDrop = null;
//
//
//        Session session = null;
//        Transaction tx = null;
//
//
//        if(doadorId != null){
//                try{
//                    session = getSessionDude();
//                    tx = session.beginTransaction();
//                    tx.commit();
//                    DoadorHiber doa = (DoadorHiber) session.get(DoadorHiber.class, doadorId);//HibernateHelperFaces.getObject(DoadorHiber.class, doadorId);//getObjectOpenSession(DoadorHiber.class, doadorId);
//                    List l =  doa.getReceptorList(); //doa.getListDoadorOwnerReceptor();
//                    listDrop = new ArrayList<ReceptorDrop>();
//
//                    for(Object obj : l){
//
//                                ReceptorDrop rDrop = new ReceptorDrop((ReceptorHiber)obj);
//                                listDrop.add(rDrop);
//
//                            //this.setListDoadorDrop(listDrop);
//                        }
//
//
//                    return listDrop;
//
//                }finally{
//                    if(session != null){
//                        session.close();
//                    }
//                }
//        }
//
//        return null;
//
//    }






    public static void deleteObject(Object obj){
        Session session = null;
        Transaction tx = null;
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





    public static  void deleteObjectList(List list){
        Session session = null;
        Transaction tx = null;
        try{
            session = getSessionDude();//sessionFactory.getCurrentSession();
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








     static  public Object getFirstMatchUser(String login,String pass) {


         Session session = null;
         Transaction tx;
         List result = null;
         try{
             session = getSessionDude();//sessionFactory.getCurrentSession();
             tx = session.beginTransaction();
             org.hibernate.Query q = session.createQuery("from UserHiber u where u.userLogin = :name and u.userPass = :pass");
             q.setString("name", login);
             q.setString("pass", pass);

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
 *
 * @param classBean
 * @param strKey
 * @param value
 * @return a List of obejcts
 */
 static  public java.util.List getListDataByKey( Class classBean, String strKey, Object value){

        Session session = null;
        Transaction tx = null;
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
/**
 *
 * @param classBean
 * @param strKey
 * @param value
 * @return the first obejct of the list
 */
  static  public Object getObjectDataByKey( Class classBean, String strKey, Object value){

        Session session = null;
        Transaction tx = null;
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
            }else{
                return null;
            }
        }finally{
            if(session != null){
                session.close();
            }
        }



  }


 static  public java.util.List getListData(Class classBean){

     Session session = null;
     Transaction tx = null;
     List result = null;
     try{
         session = getSessionDude();//sessionFactory.getCurrentSession();
         tx = session.beginTransaction();

         Criteria criteria = session.createCriteria(classBean);
         result = criteria.list();

         tx.commit();
         return result;
     }finally{
        if(session != null){
            session.close();
        }
     }


 }

//  static  public java.util.List getListData(Class classBean){
//      List result = new ArrayList();
//      session = getSessionDude();
//      Transaction tx = session.beginTransaction();
//      Criteria criteria = session.createCriteria(classBean);
//      result = criteria.list();
//
//      return result;
//  }

 static  public Object getObjectDataRestrictions( Class classBean, String strKey, Object value){

     Session session = null;
     Transaction tx = null;
     List result = null;
     try{
         session = getSessionDude();//sessionFactory.getCurrentSession();
         tx = session.beginTransaction();
         Criteria criteria = session.createCriteria(classBean);
         result = criteria.list();
         if(result != null && result.size() > 0){
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

  static  public List getListDataRestrictions( Class classBean, String strKey, Object value){



        Session session = null;
        Transaction tx = null;
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


//  public static TipagemDoadorHLAHiber getLastTipDoador(DoadorHiber doador){
//
//      Session session = null;
//      Transaction tx = null;
//      List result = null;
//
//      if(doador.getDoadorId() != null){
//              try{
//                  session = getSessionDude();//sessionFactory.getCurrentSession();
//                  tx = session.beginTransaction();
//
//                      Criteria criteria = session.createCriteria(TipagemDoadorHLAHiber.class);
//                      criteria.add(Restrictions.like("doadorFK", doador));
//                      result = criteria.list();
//
//                  tx.commit();
//
//                  if(result != null&& result.size()>0){
//
//                          return (TipagemDoadorHLAHiber) result.get(result.size()-1);
//
//                  }
//
//              }finally{
//                  if(session != null){
//                      session.close();
//                  }
//              }
//
//      }
//      return null;
//  }


//  public static TipagemRecepHLAHiber getLastTipReceptor(ReceptorHiber receptor){
//
//
//
//       Session session = null;
//      Transaction tx = null;
//      List result = null;
//
//      if(receptor.getReceptorId() != null){
//          try{
//              session = getSessionDude();//sessionFactory.getCurrentSession();
//              tx = session.beginTransaction();
//              Criteria criteria = session.createCriteria(TipagemRecepHLAHiber.class);
//              criteria.add(Restrictions.like("receptorFK", receptor));
//              result = criteria.list();
//              tx.commit();
//              if(result != null&&result.size()>0){
//                  return (TipagemRecepHLAHiber) result.get(result.size()-1);
//              }
//          }finally{
//              if(session != null){
//                  session.close();
//              }
//          }
//      }else{
//          System.out.println("Receptor null id");
//      }
//
//
//
//      return null;
//
//
//
//
//  }


//  public static PRADoador getLastPRADoador(DoadorHiber doador){
//
//      Session session = null;
//      Transaction tx = null;
//      List result = null;
//      if(doador.getDoadorId() != null){
//          session = getSessionDude();//sessionFactory.getCurrentSession();
//          tx = session.beginTransaction();
//          Criteria criteria = session.createCriteria(PRADoador.class);
//          criteria.add(Restrictions.like("doadorFK", doador));
//          result = criteria.list();
//          tx.commit();
//          if(result != null && result.size()>0){
//              return (PRADoador) result.get(result.size()-1);
//          }
//      }
//
//
//      return null;
//
//
//  }
//    public static PRAReceptor getLastPRAReceptor(ReceptorHiber receptor){
//
//        Session session = null;
//        Transaction tx = null;
//        List result = null;
//        if(receptor.getReceptorId() != null){
//            session = getSessionDude();//sessionFactory.getCurrentSession();
//            tx = session.beginTransaction();
//            Criteria criteria = session.createCriteria(PRAReceptor.class);
//            criteria.add(Restrictions.le("receptorFK", receptor));
//            result = criteria.list();
//
//            tx.commit();
//
//            if(result != null&&result.size()>0){
//                return (PRAReceptor) result.get(result.size()-1);
//            }
//        }
//
//
//      return null;
//
//
//  }
//
//    public static List<TipagemDoadorHLAHiber> getListTipDoaByDate(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(TipagemDoadorHLAHiber.class);
//             criteria.add(Expression.between("tipagemDate", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//            // if (result != null && result.size() > 0) {
//	        return result;
//	      //}
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//	    //return null;
//    }
//
//    public static List<TipagemRecepHLAHiber> getListTipRecByDate(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(TipagemRecepHLAHiber.class);
//             criteria.add(Expression.between("tipagemDate", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//            // if (result != null && result.size() > 0) {
//	        return result;
//	      //}
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//	   // return null;
//    }
//
//
//    /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of TipDoador between Dates of coleta
//     */
//    public static List<TipagemDoadorHLAHiber> getListTipDoadorByDateColeta(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<TipagemDoadorHLAHiber> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(TipagemDoadorHLAHiber.class);
//             criteria.add(Expression.between("dataColeta", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//
//	        return result;
//
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//    }
//
//
//     /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of TipReceptor between Dates of coleta
//     */
//    public static List<TipagemRecepHLAHiber> getListTipReceptorByDateColeta(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<TipagemRecepHLAHiber> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(TipagemRecepHLAHiber.class);
//             criteria.add(Expression.between("dataColeta", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//
//	        return result;
//
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//
//    }
//
//
//    public static List<PRADoador> getListPRADoaByDate(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(PRADoador.class);
//             criteria.add(Expression.between("soro", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//            // if (result != null && result.size() > 0) {
//	        return result;
//	      //}
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//	   // return null;
//    }
//
//    public static List<PRAReceptor> getListPRARecByDate(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(PRAReceptor.class);
//             criteria.add(Expression.between("soro", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//
//	        return result;
//
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//
//    }
//
//
//
//
//     /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of PRAReceptor between Dates of coleta
//     */
//    public static List<PRAReceptor> getListPRARecByDateColeta(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<PRAReceptor> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(PRAReceptor.class);
//             criteria.add(Expression.between("dataColeta", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//
//	        return result;
//
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//
//    }
//
//
//    /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of PRADoador between Dates of coleta
//     */
//    public static List<PRADoador> getListPRADoadorByDateColeta(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<PRADoador> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(PRADoador.class);
//             criteria.add(Expression.between("dataColeta", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//
//	        return result;
//
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//
//    }
//
//    /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of Doador between Dates
//     */
//
//    public static List<DoadorHiber> getListDoadorByDateRegistro(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<DoadorHiber> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(DoadorHiber.class);
//             criteria.add(Expression.between("doadorDataRegistro", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//            // if (result != null && result.size() > 0) {
//	        return result;
//	      //}
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//    }
//
//
//
//    /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of AgendaPac between Dates retorno
//     */
//
//    public static List<AgendamentoPac> getListAgendaPacByDateRetorno(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<AgendamentoPac> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(AgendamentoPac.class);
//             criteria.add(Expression.between("agendamentoDataRetorno", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//
//	        return result;
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//    }
//
//
//     /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of Receptor between Dates
//     */
//
//    public static List<ReceptorHiber> getListReceptorByDateRegistro(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<ReceptorHiber> result = null;
//         try{
//             session = getSessionDude();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(ReceptorHiber.class);
//             criteria.add(Expression.between("receptorDataRegistro", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//	        return result;
//
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//    }
//
//
//     /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of Doador between Dates
//     */
//
//    public static List<DoadorHiber> getListDoadorByDateNasc(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<DoadorHiber> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(DoadorHiber.class);
//             criteria.add(Expression.between("doadorDataNasc", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//            // if (result != null && result.size() > 0) {
//	        return result;
//	      //}
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//	   // return null;
//    }
//
//
//     /**
//     *
//     * @param dStart
//     * @param dEnd
//     * @return List of Receptor between Dates
//     */
//
//    public static List<ReceptorHiber> getListReceptorByDateNasc(Date dStart,Date dEnd){
//        Session session = null;
//         Transaction tx;
//         List<ReceptorHiber> result = null;
//         try{
//             session = getSessionDude();//sessionFactory.getCurrentSession();
//             tx = session.beginTransaction();
//             Criteria criteria = session.createCriteria(ReceptorHiber.class);
//             criteria.add(Expression.between("receptorDataNasc", dStart, dEnd));
//             result = criteria.list();
//
//             tx.commit();
//
//            // if (result != null && result.size() > 0) {
//	        return result;
//	      //}
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//
//
//
//
//	   // return null;
//    }
///**
// *
// *
// * @param listaReceptores
// * @return list fo ReceptorHiber linked to ListaReceptor class
// */
//    public static List<ReceptorHiber> getListReceptoresPorDoador(ListaReceptores listaReceptores) {
//        Session session = null;
//         Transaction tx;
//
//         ListaReceptores lista = null;
//         List<ReceptorHiber> listRec = null;
//         List<ReceptorHiber> listRec2 = null;
//         try{
//             session = getSessionDude();
//             tx = session.beginTransaction();
//             tx.commit();
//
//             lista = (ListaReceptores) HibernateHelperFaces
//                     .getObject(ListaReceptores.class, listaReceptores.getListaId());
//              listRec = lista.getListaReceptores();
//
//             if(listRec != null){
//                 listRec2 = new ArrayList<ReceptorHiber>();
//                 for(ReceptorHiber rec : listRec){
//                     listRec2.add(rec);
//                 }
//             }
//
//
//             return listRec2;
//
//
//
//         }finally{
//             if(session != null){
//                 session.close();
//             }
//         }
//    }
//
//
//
//
//
//
//
//
//
}



