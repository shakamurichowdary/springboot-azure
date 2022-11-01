package com.grpf.lipc.dao;

import java.util.List;

import com.grpf.lipc.entities.Beneficiary;
import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;

public interface BeneficiaryDAO {
		
		public void addBeneficiary(Beneficiary beneficiary);
		public void deleteBeneficiary(Beneficiary beneficiary);
		public void updateBeneficiary(Beneficiary beneficiary);
		public int findUserIdByEmail(String email);
		public Beneficiary findBeneficiaryById(int beneficiaryId);
		public Beneficiary findBeneficiaryByUserId(int userId);
		public List<Beneficiary> findAllBeneficiary();
		void deleteBeneficiaryByUserId(int userId);
		public Submission findSubmissionByEmail(String email);

	}


