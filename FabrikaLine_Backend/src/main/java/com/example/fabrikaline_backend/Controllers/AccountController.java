package com.example.fabrikaline_backend.Controllers;
import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.DTO.CreditEntityDTO;
import com.example.fabrikaline_backend.DTO.RepaymentEntityDTO;
import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.CreditEntity;
import com.example.fabrikaline_backend.Entities.RepaymentEntity;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AccountServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.fabrikaline_backend.DTO.AccountDTO;

@RequestMapping("/Account")
@RestController
@CrossOrigin("*")
public class AccountController implements IAbstractController<Account> {

    @Autowired
    AccountServiceImp accountService;

    @Operation(operationId = "getCreditsGivenByAccountAccount")
    @GetMapping(value = "/{accountId}/creditsGiven", produces = "application/json")

    public ResponseEntity<List<CreditEntityDTO>> getCreditsGivenByAccount(@PathVariable Long accountId) {
        List<CreditEntityDTO> creditsGiven = accountService.getCreditsGivenByAccount(accountId);
        return ResponseEntity.ok(creditsGiven);
    }

    @Operation(operationId = "getCreditsReceivedByAccountAccount")
    @GetMapping(value = "/{accountId}/creditsReceived", produces = "application/json")

    public ResponseEntity<List<CreditEntityDTO>> getCreditsReceivedByAccount(@PathVariable Long accountId) {
        List<CreditEntityDTO> creditsReceived = accountService.getCreditsReceivedByAccount(accountId);
        return ResponseEntity.ok(creditsReceived);
    }

    @Operation(operationId = "getRepaymentsReceivedByAccountAccount")
    @GetMapping(value = "/{accountId}/repaymentsReceived", produces = "application/json")

    public ResponseEntity<List<RepaymentEntityDTO>> getRepaymentsReceivedByAccount(@PathVariable Long accountId) {
        List<RepaymentEntityDTO> repaymentsReceived = accountService.getRepaymentsReceivedByAccount(accountId);
        return ResponseEntity.ok(repaymentsReceived);
    }

    @Operation(operationId = "getRepaymentsMadeByAccountAccount")
    @GetMapping(value = "/{accountId}/repaymentsMade", produces = "application/json")

    public ResponseEntity<List<RepaymentEntityDTO>> getRepaymentsMadeByAccount(@PathVariable Long accountId) {
        List<RepaymentEntityDTO> repaymentsMade = accountService.getRepaymentsMadeByAccount(accountId);
        return ResponseEntity.ok(repaymentsMade);
    }

    @Operation(operationId = "depositAccountAccount")
    @PostMapping("/DepositAccount/{accountId}/{amountToDepose}")
    @GetMapping(value = "/{accountId}/creditsReceived", produces = "application/json")

    public ResponseEntity<Account> depositAccount(@PathVariable Long accountId,@PathVariable float amountToDepose) throws Exception {
        Account newAccount = accountService.depositAccount(accountId, amountToDepose) ;
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @Operation(operationId = "saveAccount")
    @PostMapping("/Save")
    public ResponseEntity<Account> save(@RequestBody Account account) throws Exception {
        Account newAccount = accountService.save(account) ;
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Account>> saveAll(List<Account> entities) throws Exception {
        return null;
    }

    @Operation(operationId = "loadAccount")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Account> load(@PathVariable Long id) {
        Account account = accountService.getById(id);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @Operation(operationId = "getAllAccount")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Account>> getAll() throws Exception {
        List<Account> accounts = accountService.getAll();
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Account>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Operation(operationId = "getAllAccounts")
    @GetMapping(value = "/getAllAccounts", produces = "application/json")
    public ResponseEntity<List<AccountDTO>> getAllAccounts()  throws Exception {
        List<AccountDTO> accountDTOs = accountService.getAllAccounts();
        return new  ResponseEntity<>(accountDTOs, HttpStatus.OK);
    }

    @Operation(operationId = "deleteAccount")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { accountService.delete(id);}

    @Operation(operationId = "searchAccount")
    @Override
    public ResponseEntity<List<Account>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

}
