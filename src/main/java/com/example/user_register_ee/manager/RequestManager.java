//package com.example.user_register_ee.manager;
//
//import com.example.user_register_ee.models.Request;
//import com.example.user_register_ee.models.User;
//import com.example.user_register_ee.models.enums.RequestStatus;
//import lombok.SneakyThrows;
//
//import java.util.List;
//
//public interface RequestManager {
//
//     List<Request> dailyRequestsPerDoctor(User doctor);
//
//     @SneakyThrows
//     List<Request> dailyRequestsPerDoctorByStatus(User doctor,
//                                                  RequestStatus status);
//
//     List<Request> requestsPerPatient(User user);
//}
