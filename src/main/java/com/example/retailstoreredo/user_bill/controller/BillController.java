package com.example.retailstoreredo.user_bill.controller;

import com.example.retailstoreredo.user_bill.request.UpdateBillRequest;
import com.example.retailstoreredo.user_bill.response.BillResponse;
import com.example.retailstoreredo.user_bill.service.impl.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"api/v1"})
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(path = "/discount")
    public ResponseEntity<BillResponse> getNetAmount(@RequestBody UpdateBillRequest request) {
        return ResponseEntity.ok(billService.calculateNetAmount(request));
    }
}
