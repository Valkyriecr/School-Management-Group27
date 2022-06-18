package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.schoolmanagement.api.EmployeeApi;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.service.service.EmployeeService;

import javax.validation.Valid;

@RestController
@RequestMapping("SchoolManagementGroup27/employee/")
@Slf4j
public class EmployeeController {

private final EmployeeApi employeeApi;

@Autowired public EmployeeController(EmployeeApi employeeApi){
    this.employeeApi=employeeApi;

}
@PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee) {

    Employee save = this.employeeApi.save(employee);
    return ResponseEntity.ok(save);
/*
}
@GetMapping("read/{employeeId}")
    public ResponseEntity<Employee> read(@PathVariable Employee.EmployeeId employeeId)
{
    log.info("Read Request:{}",employeeId);
    Employee employee=this.employeeService.read(employeeId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    return ResponseEntity.ok(employee);

}
@DeleteMapping("delete/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable Employee employee){
    log.info("Read Request:{}",employee);
    this.employeeService.delete(employee);
    return ResponseEntity.noContent().build();
}
@GetMapping("all")
    public ResponseEntity<List<Employee>> findAll(){
    List<Employee> employeeList= this.employeeService.findAll();
    return ResponseEntity.ok(employeeList);
}

*/
}
}
