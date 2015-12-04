package org.codeoshare.jaxws;

public class Consumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// service
		RandomService randomService = new RandomService();
		
		//proxy
		Random proxy = randomService.getRandomPort();
		
		//operation
		double next = proxy.next(50);
		System.out.println(next);

	}

}
