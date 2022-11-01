package com.grpf.lipc.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeneficiaryValidate {

	public boolean validatePhno(long phno)
	{
		String phone =String.valueOf(phno);
		String regex = "^(0/91)?[6-9][0-9]{9}$";
		Pattern p = Pattern.compile(regex);
		if(phone == null || phone.length()!=10)
		{
			return false;
		}
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	public boolean validateTaxId(String taxId)
	{
		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		Pattern p = Pattern.compile(regex);
		if(taxId == null || taxId.length()!=10)
		{
			return false;
		}
		Matcher m = p.matcher(taxId);
		return m.matches();
	}

}
