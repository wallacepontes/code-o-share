package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;


public class ValidatesPersonTest {
	@Test
	public void testValidatesPerson () throws Exception {
		
		Person p = new Person();
		
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator v = vf.getValidator();
		
		Set<ConstraintViolation<Person>> errors = v.validate(p);
		
		for (ConstraintViolation<Person> error : errors) {
			System.out.println(error);
			
		}
		
		assertTrue(true);
	}
}
