package org.codeoshare.jsf.controller.beanvalidators;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.codeoshare.jsf.controller.validators.ValidadorDePrimo;


@Target({METHOD , FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=ValidadorDePrimo.class)
public @interface Primo {
	String message() default "org.codeoshare.jsf.controller.beanvalidators.Primo.message";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
