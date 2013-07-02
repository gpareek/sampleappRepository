package net.gp.sample.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import javax.xml.validation.Validator;


import net.gp.sample.beans.User;
import net.gp.sample.services.profile.ProfileService;
import net.gp.sample.validation.constraints.Extended;
import net.gp.sample.validation.constraints.PasswordReTypePasswordMatchConstraint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes("user1")
public class RegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	private ProfileService profileService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {		
		logger.debug("Inside registration GET");
		model.addAttribute("User", new User());
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("User") User user, BindingResult result, Model model) {		
		logger.debug("Inside registration POST");
	
		logger.debug("firstName: " + user.getFirstName());
		logger.debug("lastName: " + user.getLastName());
		logger.debug("email: " + user.getEmail());
		logger.debug("dateOfBirth: " + user.getDateOfBirth());
		logger.debug("password: " + user.getPassword());
		logger.debug("salutation: " + user.getSalutation());
		
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user, Default.class);
		
		if(!constraintViolations.isEmpty()) {
			return null;
		}
		
		constraintViolations = validator.validate(user, Extended.class);
		
		if(!constraintViolations.isEmpty()) {
			for(ConstraintViolation cv : constraintViolations) {
				
				logger.debug("********************************");
				logger.debug("oe.getLeafBean() :" + cv.getLeafBean());
				logger.debug("oe.getPropertyPath() :" + cv.getPropertyPath());
				logger.debug("oe.getConstraintDescriptor().getAnnotation() :" + cv.getConstraintDescriptor().getAnnotation().getClass());
				logger.debug("oe.getMessage() :" + cv.getMessage());
				
				if(cv.getConstraintDescriptor().getAnnotation().getClass().equals(PasswordReTypePasswordMatchConstraint.class)) {
					model.addAttribute("PasswordReTypePasswordMatchConstraint", cv.getMessage());
				}
			}
			return null;
		}*/
		
		if(!result.hasErrors()) {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			javax.validation.Validator validator = factory.getValidator();
			
			Set<ConstraintViolation<User>> constraintViolations = validator.validate(user, Extended.class);
			
			if(!constraintViolations.isEmpty()) {
				for(ConstraintViolation<User> cv : constraintViolations) {
					 
					logger.debug("********************************");
					logger.debug("oe.getLeafBean() :" + cv.getLeafBean());
					logger.debug("oe.getPropertyPath() :" + cv.getPropertyPath());
					logger.debug("oe.getConstraintDescriptor().getAnnotation() :" + cv.getConstraintDescriptor().getAnnotation().getClass());
					logger.debug("oe.getMessage() :" + cv.getMessage());
					
					
					//if(cv.getConstraintDescriptor().getAnnotation().getClass().equals(PasswordReTypePasswordMatchConstraint.class)) {
						model.addAttribute("PasswordReTypePasswordMatchConstraint", cv.getMessage());
						//return null;
					//}
				}
			} else {
				profileService.register(userDTO(user));
				model.addAttribute("user1", user);
				return "redirect:thankyou";
			} 
		} else {
			return null;
		}
		return null;		
	}
	
	@RequestMapping(value = "/thankyou", method = RequestMethod.GET)
	public ModelAndView thankyou(@ModelAttribute("user1") User user) {		
		ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("thankyou");  
           
        modelAndView.addObject("user1", user);  
         
          
        return modelAndView;  
	}
	
	private net.gp.sample.user.dto.User userDTO(User userBean) {
		
		net.gp.sample.user.dto.User userDTO = new net.gp.sample.user.dto.User();
		userDTO.setFirstName(userBean.getFirstName());
		userDTO.setLastName(userBean.getLastName());
		userDTO.setEmail(userBean.getEmail());
		userDTO.setDateOfBirth(userBean.getDateOfBirth());
		userDTO.setPassword(userBean.getPassword());
		userDTO.setReceiveMarketingEmail(userBean.isReceiveMarketingEmail());
		userDTO.setSalutation(userBean.getSalutation());
		return userDTO;
		
	}

	public ProfileService getProfileService() {
		return profileService;
	}
	@Autowired
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
}
