package org.codeoshare.jsf.controller.beanvalidators;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({METHOD , FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=org.codeoshare.jsf.controller.beanvalidators.CPFBeanValidator.class)
public @interface CPF {
	String message() default "O número de CPF não é válido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
