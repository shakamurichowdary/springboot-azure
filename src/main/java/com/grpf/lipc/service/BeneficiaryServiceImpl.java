package com.grpf.lipc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grpf.lipc.dao.BeneficiaryDAO;
import com.grpf.lipc.dao.UserDAO;
import com.grpf.lipc.entities.Beneficiary;
import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;

@Service
@Transactional(readOnly=true)
public class BeneficiaryServiceImpl implements BeneficiaryService{

	@Autowired
	private BeneficiaryDAO dao;
	
	public BeneficiaryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public void addBeneficiary(Beneficiary beneficiary) {
		dao.addBeneficiary(beneficiary);
		
	}

	@Override
	@Transactional
	public void deleteBeneficiary(int BeneficiaryId) {
		Beneficiary u= findBeneficiaryById(BeneficiaryId);
		if(u==null) {
			throw new IllegalArgumentException("Id not found: "+BeneficiaryId);
		}
		dao.deleteBeneficiary(u);
		
	}
	
	@Override
	@Transactional
	public void deleteBeneficiaryByUserId(int userId) {
		Beneficiary u= findBeneficiaryByUserId(userId);
		if(u==null) {
			throw new IllegalArgumentException("Id not found: "+userId);
		}
		dao.deleteBeneficiary(u);
		
	}
	

	@Override
	@Transactional
	public void updateBeneficiary(Beneficiary beneficiary) {
		Beneficiary u=findBeneficiaryById(beneficiary.getBeneficiaryId());
		if(u==null) {
			throw new IllegalArgumentException("Id not found: "+beneficiary.getBeneficiaryId());
		}
		u.setPerson(beneficiary.getPerson());
		
	}

	@Override
	public int findUserIdByEmail(String email) {
		
		return dao.findUserIdByEmail(email);
	}

	@Override
	public Beneficiary findBeneficiaryById(int beneficiaryId) {
		
		return dao.findBeneficiaryById(beneficiaryId);
	}
	
	@Override
	public Beneficiary findBeneficiaryByUserId(int userId)
	{
		return dao.findBeneficiaryByUserId(userId);
	}

	@Override
	public List<Beneficiary> findAllBeneficiary() {
		
		return dao.findAllBeneficiary();
	}

	@Override
	public Submission findSubmissionByEmail(String email) {
		
		return dao.findSubmissionByEmail(email);
	}

//	@Override
//	public Beneficiary findBeneficiaryByUserMail(String email) {
//		
//		return dao.findBeneficiaryByUserMail(email);
//	}

//	@Override
//	public void deleteBeneficiaryByEmail(String email) {
//		Beneficiary u= findBeneficiaryByUserMail(email);
//		if(u==null) {
//			throw new IllegalArgumentException("Email not found: "+email);
//		}
//		dao.deleteBeneficiaryByUserMail(u);
//		
//	}

}
