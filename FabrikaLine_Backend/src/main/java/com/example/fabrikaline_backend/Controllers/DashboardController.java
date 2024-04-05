package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.DTO.AccountDTO;
import com.example.fabrikaline_backend.DTO.CreditEntityDTO;
import com.example.fabrikaline_backend.DTO.RepaymentEntityDTO;
import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.Spending;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AccountServiceImp;
import com.example.fabrikaline_backend.Services.DashboardServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import com.example.fabrikaline_backend.DTO.LabelValueObject;
@RequestMapping("/Dashboard")
@RestController
@CrossOrigin("*")
public class DashboardController{

    @Autowired
    DashboardServiceImp dashboardServiceImp;

    @GetMapping(value = "/GetSpendingsByPurpose", produces = "application/json")
    @Operation(operationId = "getSpendingsByPurpose")
    public ResponseEntity<List<LabelValueObject>> GetSpendingsByPurpose() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getSpendingsByPurpose();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

    @GetMapping(value = "/GetDepositeByAccount", produces = "application/json")
    @Operation(operationId = "getDepositeByAccount")
    public ResponseEntity<List<LabelValueObject>> GetDepositeByAccount() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getDepositeByAccount();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

    @GetMapping(value = "/GetSpendingsByAccount", produces = "application/json")
    @Operation(operationId = "getSpendingsByAccount")
    public ResponseEntity<List<LabelValueObject>> GetSpendingsByAccount() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getSpendingsByAccount();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

    @GetMapping(value = "/GetRestAmountByAccount", produces = "application/json")
    @Operation(operationId = "getRestAmountByAccount")
    public ResponseEntity<List<LabelValueObject>> GetRestAmountByAccount() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getRestAmountByAccount();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

}
