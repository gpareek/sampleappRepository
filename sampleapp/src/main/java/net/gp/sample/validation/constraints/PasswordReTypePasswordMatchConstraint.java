package net.gp.sample.validation.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordReTypePasswordValidator.class)
@Documented
public @interface PasswordReTypePasswordMatchConstraint {

    String message() default "pwd no match";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
