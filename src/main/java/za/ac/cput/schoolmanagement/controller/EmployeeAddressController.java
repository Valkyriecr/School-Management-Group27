package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.service.EmployeeAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("SchoolManagementGroup27/employee-address/")
@Slf4j
public class EmployeeAddressController {

private final EmployeeAddressService employeeAddressService;
    @Autowired
    public EmployeeAddressController(EmployeeAddressService employeeAddressService) {
        this.employeeAddressService = employeeAddressService;
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress employeeAddress) {

        EmployeeAddress save = this.employeeAddressService.save(employeeAddress);
        return ResponseEntity.ok(save);
    }


   @GetMapping("read/{employeeAddressId}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable EmployeeAddress.EmployeeAddressId employeeAddressId){
        log.info("Read Request:{}",employeeAddressId);
        EmployeeAddress employeeAddress=this.employeeAddressService.read(employeeAddressId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);

    }
    @DeleteMapping("delete/{employeeAddressId}")
    public ResponseEntity<Void> delete(@PathVariable EmployeeAddress employeeAddressId)
    {
        log.info("Read Request:{}",employeeAddressId);
        this.employeeAddressService.delete(employeeAddressId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>> findAll(){
        List<EmployeeAddress> employeeAddressList=this.employeeAddressService.findAll();
        return ResponseEntity.ok(employeeAddressList);
    }


}
