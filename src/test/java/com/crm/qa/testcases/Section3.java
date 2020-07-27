package com.crm.qa.testcases;

import org.testng.annotations.Test;



/**
 * @author Lav Gupta
 * @date 27-Jul-2020
 * @description If we list all the natural numbers below 10 that are multiples of 3 or 5,
 *	we get 3, 5, 6 and 9. The sum of these multiples is 23. 
 *	Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Section3 {

	@Test
	public void main()
	{
		multiples(1000);

	}

	public void multiples(int endcount){
		int sum = 0;
		for (int i = 1; i < endcount; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				sum += i;
			}
		}
		System.out.println("Final Sum value of below 1000 is : "+sum);
	}
}
