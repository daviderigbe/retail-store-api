package com.example.retailstoreredo.user_bill.service.impl;

import com.example.retailstoreredo.user_bill.request.UpdateBillRequest;
import com.example.retailstoreredo.user_bill.response.BillResponse;

public interface BillService {
    BillResponse calculateNetAmount(UpdateBillRequest request);
}
