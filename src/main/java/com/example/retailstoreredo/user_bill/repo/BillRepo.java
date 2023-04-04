package com.example.retailstoreredo.user_bill.repo;

import com.example.retailstoreredo.user_bill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo
        extends JpaRepository<Bill, Long> {
}
