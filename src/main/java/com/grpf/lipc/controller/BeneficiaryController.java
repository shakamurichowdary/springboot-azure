package com.grpf.lipc.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grpf.lipc.entities.Beneficiary;
import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;
import com.grpf.lipc.exception.BeneficiaryValidate;
import com.grpf.lipc.exception.DataNotFoundException;
import com.grpf.lipc.exception.UserValidate;
import com.grpf.lipc.service.BeneficiaryService;
import com.grpf.lipc.service.MapValidationErrorService;
import com.grpf.lipc.service.UserService;
import com.grpf.lipc.dao.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/beneficiary")
public class BeneficiaryController
{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BeneficiaryService beneficiaryService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	
	@GetMapping("/{beneficiaryId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Beneficiary getBeneficiaryById(@PathVariable("beneficiaryId") int beneficiaryId) {
		return beneficiaryService.findBeneficiaryById(beneficiaryId);
	}
	
	@GetMapping("/user/{userId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Beneficiary getBeneficiaryByUserId(@PathVariable("userId") int userId)
	{
		return beneficiaryService.findBeneficiaryByUserId(userId);
	}
	
	@GetMapping("/getAllBeneficiary")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Beneficiary> getAllBeneficiary(){
		return beneficiaryService.findAllBeneficiary();
	}
	
	@GetMapping("/findBeneficiaryByUserMail/{email}")
	@Produces({MediaType.APPLICATION_JSON})
	public Beneficiary findBeneficiaryByUserMail(@PathVariable("email") String email)
	{
		User u=userService.findUserByEmail(email);
		int uId=u.getUserId();
		Beneficiary b=beneficiaryService.findBeneficiaryByUserId(uId);
		return b;
	}
	
	@PostMapping("/add/{email}")
	@Consumes({MediaType.APPLICATION_JSON})
	public ResponseEntity<Beneficiary> addBeneficiary(@PathVariable("email") String email, @Valid @RequestBody Beneficiary beneficiary, BindingResult result) {
	ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
	if(errorMap!=null) return (ResponseEntity<Beneficiary>) errorMap;
	BeneficiaryValidate validateBeneficiary = new BeneficiaryValidate();
	boolean phone = validateBeneficiary.validatePhno(beneficiary.getPerson().getPhoneNo());
	boolean taxId = true;
	Submission sub=beneficiaryService.findSubmissionByEmail(email);
	beneficiary.setSubmission(sub);
//	User u = userService.findUserByEmail(email);
//	beneficiary.setUser(u);
	
	
		
		try {
		
		if(phone) {
			if(taxId) {
				try {
				beneficiaryService.addBeneficiary(beneficiary); 
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				throw new DataNotFoundException("Enter Valid TAX ID");
			}
			
		}
		else {
			throw new DataNotFoundException("Enter valid Phone Number");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>(beneficiary, HttpStatus.CREATED);
				
	}
	
	
	@PutMapping("/updateBeneficiary")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseEntity<Beneficiary> updateBeneficiary(@Valid @RequestBody Beneficiary beneficiary, BindingResult result) {
		
		Beneficiary b= beneficiaryService.findBeneficiaryById((int)beneficiary.getBeneficiaryId());
		
		b.setBeneficiaryId(beneficiary.getBeneficiaryId());
//		b.setBeneficiaryName(beneficiary.getBeneficiaryName());
		b.setBeneficiaryGender(beneficiary.getBeneficiaryGender());
		b.setBeneficiaryAge(beneficiary.getBeneficiaryAge());
		b.setBeneficiaryRelation(beneficiary.getBeneficiaryRelation());
//		b.setPhNo(beneficiary.getPhNo());
		b.setBeneficiaryEmail(beneficiary.getBeneficiaryEmail());
		b.setTaxId(beneficiary.getTaxId());
		
		beneficiaryService.updateBeneficiary(b);
		
		return new ResponseEntity<>(b, HttpStatus.CREATED);
		
}
	
	@DeleteMapping("/delete/{userId}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteBeneficiary(@PathVariable("userId") int userId) {
		beneficiaryService.deleteBeneficiary(userId);
		return Response.status(Status.OK).entity("Successfully Deleted By user Id").build();
	}
	
	@DeleteMapping("/delete/userMail/{email}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteBeneficiaryByEmail(@PathVariable("email") String email) {
		System.out.println("In delete by user mail");
		
		User u=userService.findUserByEmail(email);
		int uId=u.getUserId();
		System.out.println("after finding the user id "+uId);
		beneficiaryService.deleteBeneficiaryByUserId(uId);
		System.out.println("after deleting");
		return Response.status(Status.OK).entity("Successfully Deleted By User email").build();
	
	}

	
}