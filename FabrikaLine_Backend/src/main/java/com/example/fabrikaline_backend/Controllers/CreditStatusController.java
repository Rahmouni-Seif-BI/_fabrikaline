package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.CreditStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.CreditStatusServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/CreditStatus")
@RestController
@CrossOrigin("*")
public class CreditStatusController implements IAbstractController<CreditStatus> {

    @Autowired
    CreditStatusServiceImp creditStatusService;
    @Override
    @Operation(operationId = "saveCreditStatus")
    @PostMapping("/Save")
    public ResponseEntity<CreditStatus> save(@RequestBody CreditStatus creditStatus) throws Exception {
        CreditStatus newCreditStatus = creditStatusService.save(creditStatus) ;
        return new ResponseEntity<>(newCreditStatus, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CreditStatus>> saveAll(List<CreditStatus> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "loadCreditStatus")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<CreditStatus> load(@PathVariable Long id) {
        CreditStatus creditStatus = creditStatusService.getById(id);
        return new ResponseEntity<>(creditStatus,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "getAllCreditStatus")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<CreditStatus>> getAll() throws Exception {
        List<CreditStatus> creditStatuss = creditStatusService.getAll();
        return new ResponseEntity<>(creditStatuss,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CreditStatus>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "deleteCreditStatus")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        creditStatusService.delete(id);
    }

    @Override
    public ResponseEntity<List<CreditStatus>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

}
