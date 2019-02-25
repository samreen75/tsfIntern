package com.StudentRecord.Controller;

import java.util.List;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.StudentRecord.Model.StudentModel;
import com.StudentRecord.Repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")

public class StudentController {
	
StudentModel studMod;
	
	@Autowired	
	StudentRepository studRepo;
	
	@GetMapping("studentrecord")
	private List<StudentModel> getAll()
	{
		return studRepo.findAll();
	}

	@PostMapping("addstudent")
	private StudentModel createStud(@Valid @RequestBody StudentModel studModel)
	{
		return studRepo.save(studModel);
	}

	@DeleteMapping("/deletestudent")
	private void deleteStudent(@Valid @RequestBody StudentModel studModel)
	{
		studRepo.delete(studModel);
	}

	 @PutMapping("/updateStud/{id}")
	public StudentModel updateStud(@PathVariable(value="id")long id,@RequestBody StudentModel sModel) {
	StudentModel studMod = new StudentModel();
	studMod = studRepo.findById(id).orElse(new StudentModel());
	studMod.setName(sModel.getName());
	studMod.setAddress(sModel.getAddress());
	
		  return studRepo.save(studMod);
	  }
// @PutMapping("/updateStudent/{id}")
// public ResponseEntity<Object> studentrecord(@Valid  @RequestBody StudentModel studModel ,@PathVariable long id){
//studRepo.findById(id);
//	if(!studModel.isPresent())
//		return ResponseEntity.notFound().build();
//	studModel.setId(id);
//	studRepo.save(studModel);
//	
//	return ResponseEntity.noContent().build();
// }

}
