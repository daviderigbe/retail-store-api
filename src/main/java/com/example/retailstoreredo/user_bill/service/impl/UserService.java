package com.example.retailstoreredo.user_bill.service.impl;

import com.example.retailstoreredo.user_bill.enums.UserType;
import com.example.retailstoreredo.user_bill.model.User;
import com.example.retailstoreredo.user_bill.request.UpdateUserRequest;

public interface UserService {
    UserType getUserType(Long userId);
    User getUsers(Long userId);
    boolean isCustomerValidForDiscount(Long userId);
    User registerNewUser(User user);
}
