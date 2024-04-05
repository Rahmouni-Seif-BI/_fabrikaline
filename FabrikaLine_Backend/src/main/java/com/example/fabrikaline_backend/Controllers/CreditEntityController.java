package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.DTO.CreditEntityDTO;
import com.example.fabrikaline_backend.Entities.CreditEntity;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.CreditEntityServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/CreditEntity")
@RestController
@CrossOrigin("*")
public class CreditEntityController implements IAbstractController<CreditEntity> {

    @Autowired
    CreditEntityServiceImp creditEntityService;


    @Operation(operationId = "SaveCreditEntity")
    @PostMapping("/Save/{creditorAccountId}/{debitorAccountId}")
    public ResponseEntity<CreditEntity> save(@RequestBody CreditEntity creditEntity,@PathVariable Long creditorAccountId,@PathVariable Long debitorAccountId) throws Exception {
        CreditEntity newCreditEntity = creditEntityService.save(creditEntity, creditorAccountId, debitorAccountId) ;
        return new ResponseEntity<>(newCreditEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CreditEntity> save(CreditEntity entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<CreditEntity>> saveAll(List<CreditEntity> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "loadCreditEntity")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<CreditEntity> load(@PathVariable Long id) {
        CreditEntity creditEntity = creditEntityService.getById(id);
        return new ResponseEntity<>(creditEntity,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CreditEntity>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "getAllCreditEntities")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<CreditEntity>> getAll() throws Exception {
        List<CreditEntity> creditEntities = creditEntityService.getAll();
        return new ResponseEntity<>(creditEntities,HttpStatus.OK);
    }

    @Operation(operationId = "getAllCreditEntitiesDTO")
    @GetMapping(value = "/GetAllDTO", produces = "application/json")
    public ResponseEntity<List<CreditEntityDTO>> getCreditEntities() throws Exception {
        List<CreditEntityDTO> creditEntities = creditEntityService.getCreditEntities();
        return new ResponseEntity<>(creditEntities,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "deleteCreditEntity")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        creditEntityService.delete(id);
    }

    @Override
    public ResponseEntity<List<CreditEntity>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

}
