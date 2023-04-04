package com.example.retailstoreredo.user_bill.service;

import com.example.retailstoreredo.user_bill.enums.UserType;
import com.example.retailstoreredo.user_bill.model.User;
import com.example.retailstoreredo.user_bill.repo.UserRepo;
import com.example.retailstoreredo.user_bill.request.UpdateUserRequest;
import com.example.retailstoreredo.user_bill.service.impl.UserService;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public UserType getUserType(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isEmpty())
            throw new IllegalStateException("User not found");

        return optionalUser.get().getUserType();
    }

    @Override
    public User getUsers(Long userId) {
        return null;
    }

    public User registerNewUser(User user) {
        User newUser = new User();
        return userRepo.save(new User());
    }

    public boolean isCustomerValidForDiscount(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isEmpty())
            throw new IllegalStateException("User not found");

        User user = optionalUser.get();

        if (!user.getUserType().equals(UserType.LOYAL))
            throw new IllegalStateException("User not a customer");

        if (getNumberOfYears(user.getCreatedDate()) >= 2)
            return true;

        return false;
    }

//    @Override
//    public User registerNewUser(UpdateUserRequest request) {
//        return null;
//    }

    @Transactional
    public User updateUser(Long userId,
                           UpdateUserRequest request) {
        User user = userRepo.findById(userId)
                .orElseThrow(() ->new IllegalStateException(
                        "user with id" + userId + "does not exists"
                ));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setUserType(UserType.valueOf(request.getUserType()));

        return userRepo.save(user);
    }

    private int getNumberOfYears(LocalDate date) {
        long age = LocalDate.from(date).until(LocalDate.now(), ChronoUnit.YEARS);
        return (int) age;
    }

    public void deleteUser(Long userId, UpdateUserRequest request) {
        boolean exists = userRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "user with id" + userId + " does not exist");
        }
        userRepo.deleteById(userId);
    }
}
