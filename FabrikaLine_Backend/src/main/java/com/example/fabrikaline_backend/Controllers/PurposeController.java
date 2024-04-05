package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Purpose;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.PurposeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Purpose")
@RestController
@CrossOrigin("*")
public class PurposeController implements IAbstractController<Purpose> {

    @Autowired
    PurposeServiceImp purposeService;

    @Override
    @PostMapping("/Save")
    @Operation(operationId = "saveCreditEntity")
    public ResponseEntity<Purpose> save(@RequestBody Purpose purpose) throws Exception {
        Purpose newPurpose = purposeService.save(purpose) ;
        return new ResponseEntity<>(newPurpose, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Purpose>> saveAll(List<Purpose> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Purpose> load(@PathVariable Long id) {
        Purpose purpose = purposeService.getById(id);
        return new ResponseEntity<>(purpose,HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Purpose>> getAll() throws Exception {
        List<Purpose> purposes = purposeService.getAll();
        return new ResponseEntity<>(purposes,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Purpose>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { purposeService.delete(id);}

    @Override
    public ResponseEntity<List<Purpose>> search(SearchCriteria criteria) throws Exception {
        return null;
    }
}
