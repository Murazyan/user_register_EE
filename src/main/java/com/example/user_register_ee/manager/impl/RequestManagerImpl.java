//package com.example.user_register_ee.manager.impl;
//
//import com.example.user_register_ee.manager.RequestManager;
//import com.example.user_register_ee.models.Request;
//import com.example.user_register_ee.models.User;
//import com.example.user_register_ee.models.enums.RequestStatus;
//import com.example.user_register_ee.util.HibernateUtil;
//import lombok.SneakyThrows;
//import org.hibernate.Session;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class RequestManagerImpl implements RequestManager {
//
//    @Override
//    @SneakyThrows
//    public List<Request> dailyRequestsPerDoctor(User doctor) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Request> cq = cb.createQuery(Request.class);
//        Root<Request> root = cq.from(Request.class);
//        cq.select(root).where(
//                cb.and(cb.equal(root.get("doctor"), doctor),
//                        cb.greaterThanOrEqualTo(root.get("startDate"), LocalDateTime.now().withHour(0).withMinute(0)),
//                        cb.lessThanOrEqualTo(root.get("endDate"), LocalDateTime.now().withHour(23).withMinute(59))
//                        )
//        );
//        return session.createQuery(cq).getResultList();
//    }
//    @Override
//    @SneakyThrows
//    public List<Request> dailyRequestsPerDoctorByStatus(User doctor,
//                                                        RequestStatus status) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Request> cq = cb.createQuery(Request.class);
//        Root<Request> root = cq.from(Request.class);
//        cq.select(root).where(
//                cb.and(
//                        cb.equal(root.get("doctor"), doctor),
//                        cb.equal(root.get("status"), status),
//                        cb.greaterThanOrEqualTo(root.get("startDate"), LocalDateTime.now().withHour(0).withMinute(0)),
//                        cb.lessThanOrEqualTo(root.get("endDate"), LocalDateTime.now().withHour(23).withMinute(59))
//                        )
//        );
//        return session.createQuery(cq).getResultList();
//    }
//
//    @Override
//    public List<Request> requestsPerPatient(User user) {
//        return null;
//    }
//}
