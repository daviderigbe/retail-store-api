package com.example.retailstoreredo.user_bill.repo;

import com.example.retailstoreredo.user_bill.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo
     extends JpaRepository<User, Long>{
    }

