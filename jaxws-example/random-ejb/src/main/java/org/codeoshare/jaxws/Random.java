package org.codeoshare.jaxws;

import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService
@Stateless
public class Random {

	public double next(double max) {
		return Math.random() * max;
	}
}
