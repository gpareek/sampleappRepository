package net.gp.sample.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.gp.sample.beans.User;


public class PasswordReTypePasswordValidator implements ConstraintValidator<PasswordReTypePasswordMatchConstraint, Object> {

	@Override
	public void initialize(PasswordReTypePasswordMatchConstraint arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		User user = (User)arg0;
		
		String password = user.getPassword();
		String reTypePassword = user.getReTypePassword();
		
		if(password.equals(reTypePassword)) {
			return true;
		}
		return false;
	}

}
