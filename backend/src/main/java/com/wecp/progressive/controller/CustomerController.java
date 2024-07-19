package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
   
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() throws SQLException {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{customerID}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerID) throws SQLException {
        return ResponseEntity.ok(customerService.getCustomerById(customerID));
    }
    @PostMapping
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) throws SQLException {
        return ResponseEntity.ok(customerService.addCustomer(customers));
    }
    @PutMapping("/{customerID}")
    public ResponseEntity<Void> updateCustomer(@RequestBody Customers customers) throws SQLException {
        customerService.updateCustomer(customers);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/{customerID}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerID) throws SQLException {
        customerService.deleteCustomer(customerID);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
    //     return null;
    // }
}
