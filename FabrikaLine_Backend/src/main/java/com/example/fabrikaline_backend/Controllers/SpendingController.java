package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Spending;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.SpendingServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Spending")
@RestController
@CrossOrigin("*")
public class SpendingController implements IAbstractController<Spending> {

    @Autowired
    SpendingServiceImp spendingService;

    @PostMapping("/Save/{purposeId}/{statusId}/{accountId}")
    @Operation(operationId = "saveSpending")
    public ResponseEntity<Spending> save(@RequestBody Spending spending,  @PathVariable Long purposeId,  @PathVariable Long statusId,  @PathVariable Long accountId) throws Exception {
        Spending newSpending = spendingService.save(spending,purposeId,statusId,accountId) ;
        return new ResponseEntity<>(newSpending, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Spending> save(Spending entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Spending>> saveAll(List<Spending> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    @Operation(operationId = "loadSpending")
    public ResponseEntity<Spending> load(@PathVariable Long id) {
        Spending spending = spendingService.getById(id);
        return new ResponseEntity<>(spending,HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    @Operation(operationId = "getAllSpendings")
    public ResponseEntity<List<Spending>> getAll() throws Exception {
        List<Spending> spendings = spendingService.getAll();
        return new ResponseEntity<>(spendings,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Spending>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    @Operation(operationId = "deleteSpending")
    public void delete(@PathVariable Long id) { spendingService.delete(id);}

    @Override
    public ResponseEntity<List<Spending>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @GetMapping(value = "/GetSpendingsByAccount/{accountId}", produces = "application/json")
    @Operation(operationId = "getSpendingsByAccount")
    public ResponseEntity<List<Spending>> getSpendingsByAccount(@PathVariable Long accountId) throws Exception {
        List<Spending> spendingsByAccountId = spendingService.getSpendingsByAccount(accountId);
        return new ResponseEntity<>(spendingsByAccountId,HttpStatus.OK);
    }
}
