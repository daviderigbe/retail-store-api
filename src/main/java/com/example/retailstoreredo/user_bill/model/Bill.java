package com.example.retailstoreredo.user_bill.model;

import com.example.retailstoreredo.user_bill.enums.BillType;
import jakarta.persistence.*;
@Table
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double amount;
    private Double netAmount;
    private Boolean containsGroceries;

    @Enumerated(value = EnumType.STRING)
    private BillType billType;
//    private User user;

    public Bill() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Boolean getContainsGroceries() {
        return containsGroceries;
    }

    public void setContainsGroceries(Boolean containsGroceries) {
        this.containsGroceries = containsGroceries;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", netAmount=" + netAmount +
                ", containsGroceries=" + containsGroceries +
                ", billType=" + billType +
                '}';
    }


}
