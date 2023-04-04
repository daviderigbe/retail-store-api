package com.example.retailstoreredo.user_bill.request;

import com.example.retailstoreredo.user_bill.enums.BillType;

import java.util.List;

public class UpdateBillRequest {
    private Long userId;
    public Double amount;
    private Boolean containsGroceries;
    private String billType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getContainsGroceries() {
        return containsGroceries;
    }

    public void setContainsGroceries(Boolean containsGroceries) {
        this.containsGroceries = containsGroceries;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        private Double price;
        private BillType type;

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public BillType getType() {
            return type;
        }

        public void setType(BillType type) {
            this.type = type;
        }
    }
}
