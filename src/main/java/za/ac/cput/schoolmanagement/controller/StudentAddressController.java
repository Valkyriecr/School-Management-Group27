package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.service.service.IStudentAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("SchoolManagementGroup27/student-address/")
@Slf4j
public class StudentAddressController {
    private IStudentAddressService studentAddressService;
    @Autowired
    public StudentAddressController(IStudentAddressService studentAddressService){
        this.studentAddressService=studentAddressService;
    }
    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress){
        StudentAddress save = this.studentAddressService.save(studentAddress);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{studentAddressId}")
        public ResponseEntity<StudentAddress> read(StudentAddress.StudentAddressId studentAddressId){
        log.info("Read Request:{}",studentAddressId);
        StudentAddress studentAddress=this.studentAddressService.read(studentAddressId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }

    @DeleteMapping("delete/{studentAddressId}")
    public ResponseEntity<Void>delete(@PathVariable StudentAddress studentAddressId){
        log.info("Delete Request:{}",studentAddressId);
        this.studentAddressService.delete(studentAddressId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>>findAll(){
        List<StudentAddress> studentAddressList=this.studentAddressService.findAll();
        return ResponseEntity.ok(studentAddressList);
    }
}
