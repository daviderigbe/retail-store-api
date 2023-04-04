package com.example.retailstoreredo.user_bill.service;

import com.example.retailstoreredo.user_bill.enums.UserType;
import com.example.retailstoreredo.user_bill.model.Bill;
import com.example.retailstoreredo.user_bill.repo.BillRepo;
import com.example.retailstoreredo.user_bill.request.UpdateBillRequest;
import com.example.retailstoreredo.user_bill.response.BillResponse;
import com.example.retailstoreredo.user_bill.service.impl.BillService;
import com.example.retailstoreredo.user_bill.service.impl.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private final UserService userService;
    private final BillRepo billRepo;

    public BillServiceImpl(UserService userService, BillRepo billRepo) {
        this.userService = userService;
        this.billRepo = billRepo;
    }

    public BillResponse calculateNetAmount(UpdateBillRequest request) {
        BillResponse response = new BillResponse();
        Bill bill = new Bill();

        Double netAmount;

        int percentage = getUserDiscountPercentage(request.getUserId());
        Double amount = calculateItemTotal(request.getItems());

        if (percentage == 0) {
            netAmount = amount;
            response.setAmount(amount);
        }
        else {

            Double discount = ((amount * percentage) / 100);
            netAmount = amount - discount;
            response.setAmount(netAmount);
        }

        bill.setAmount(amount);
        bill.setNetAmount(netAmount);

        return response;
    }

    private int getUserDiscountPercentage(Long userId) {
        UserType userType = userService.getUserType(userId);
        int percentage = 0;
        switch (userType) {
            case EMPLOYEE:
                percentage = 30;
                break;
            case AFFILIATE:
                percentage =  10;
                break;
            case LOYAL:
                if (userService.isCustomerValidForDiscount(userId)) {
                    percentage =  5;
                }
                break;
        }

        return percentage;
    }

    private Double calculateItemTotal(List<UpdateBillRequest.Item> items) {
        Double total = 0.0;
        for (UpdateBillRequest.Item item: items) {
            total += item.getPrice();
        }

        return addItemDiscount(total);
    }

    private Double addItemDiscount(double total) {
        int x = (int) total / 100;
        int y = x * 5;

        return total - y;
    }

}
