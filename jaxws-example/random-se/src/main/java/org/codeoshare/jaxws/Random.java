package org.codeoshare.jaxws;

import javax.jws.WebService;

@WebService
public class Random {

	public double next(double max) {
		return Math.random() * max;
	}
}
