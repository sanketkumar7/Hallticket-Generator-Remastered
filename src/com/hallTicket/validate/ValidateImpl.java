package com.hallTicket.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateImpl implements Validate {

	@Override
	public boolean validName(String name) {
		boolean validname=false;
		Pattern p=Pattern.compile("[a-zA-Z]{5,12}");
		Matcher m=p.matcher(name);
		if(m.find()&&m.group().equals(name))
			validname=true;
		return validname;
	}

	@Override
	public boolean validUsername(String uname) {
		boolean validusername=false;
		Pattern p=Pattern.compile("[a-z][a-zA-Z0-9]{2,7}");
		Matcher m=p.matcher(uname);
		if(m.find()&&m.group()==uname)
			validusername=true;
		return validusername;
	}

	@Override
	public boolean validPassword(String pass) {
		boolean validpass=false;
		Pattern p=Pattern.compile("[a-zA-Z0-9$ @]{8,12}");
		Matcher m= p.matcher(pass);
		if(m.find()&&m.group().equals(pass))
			validpass=true;
		return validpass;
	}

	@Override
	public boolean validMobileno(String mobile_no) {
		boolean validno=false;
		Pattern p=Pattern.compile("[0|91]?[0-9]{10}");
		Matcher m=p.matcher(mobile_no);
		if(m.find()&m.group().equals(mobile_no))
			validno=true;
		return validno;
	}

	@Override
	public boolean validEmail(String email) {
		boolean validemail=false;
		Pattern p=Pattern.compile("[a-z]([a-z0-9][.]*)*@[a-z][a-z0-9]*([.][a-z]+)+");
		Matcher m=p.matcher(email);
		if(m.find()&m.group().equals(email))
			validemail=true;
		return validemail;
	}

	@Override
	public boolean validMasterkey(String masterkey) {
		boolean validkey=false;
		 String masterkeys[]= {"abc","xyz"};
		 for(String s:masterkeys)
			 if(masterkey.equals(s))
				 validkey=true;
		return validkey;
	}

}
