package com.grpf.lipc.service;

import java.util.List;

import com.grpf.lipc.entities.Beneficiary;
import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;




public interface BeneficiaryService {
	
	public void addBeneficiary(Beneficiary beneficiary);
	public void deleteBeneficiary(int beneficiaryId);
	public void updateBeneficiary(Beneficiary beneficiary);
	public Beneficiary findBeneficiaryById(int beneficiaryId);
	public Beneficiary findBeneficiaryByUserId(int userId);
//	public Beneficiary findBeneficiaryByUserMail(String email); 
	public int findUserIdByEmail(String email);
	public List<Beneficiary> findAllBeneficiary();
//	public void deleteBeneficiaryByEmail(String email);
	void deleteBeneficiaryByUserId(int userId);
	public Submission findSubmissionByEmail(String email);


}
