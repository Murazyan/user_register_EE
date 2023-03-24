//package com.example.user_register_ee.manager.impl;
//
//import com.example.user_register_ee.manager.IntervalManager;
//import com.example.user_register_ee.models.Interval;
//import com.example.user_register_ee.util.HibernateUtil;
//import org.hibernate.Session;
//
//public class IntervalManagerImpl implements IntervalManager {
//    @Override
//    public Interval save(Interval interval) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        if(interval.getId()==0){
//            session.beginTransaction();
//            Integer id = (Integer) session.save(interval);
//            session.getTransaction().commit();
//            interval.setId(id);
//            session.close();
//        }else {
//            session.beginTransaction();
//            session.saveOrUpdate(interval);
//            session.getTransaction().commit();
//        }
//        return interval;
//    }
//}
