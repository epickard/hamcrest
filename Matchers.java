package hamcrest_study;

import java.math.BigDecimal;

import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.closeTo;


public class Matchers {
	
	@Test
	//Will always evaluate to true
	public void testMatcherAnything() {
		String a = "hello";
		assertThat(a, is(anything()));
	}
	
	@Test
	//For custom descriptions. Useful when expecting not null, tells you what was supposed to be not null :)
	public void testDescribedAs() {
		String a = null;
		assertThat(a, describedAs("greeting", is(nullValue())));	
	}
	
	
	@Test
	public void testMatcherAllOf() {
		String a = "hello";
		assertThat(a, allOf(startsWith("h"), containsString("ell")));
	}
	
	@Test
	//Up to six matchers
	public void testMatcherAnyOf() {
		String a = "hello";
		assertThat(a, anyOf(startsWith("H"), containsString("ell")));
	}
	
	@Test
	public void testMatcherNot() {
		String a = "hello";
		String b = "Hello";
		assertThat(a, is(not(b)));
	}
		
	@Test
	//Logical equality (versus reference equality)
	public void testMatcherEqualTo() {
		String a = "hello";
		String b = "hello";
		assertThat(a, is(equalTo(b)));
	}
	
	@Test
	//Assertion requires Object to be tested and the expected contents of the toString() method. Expected contents 
	//must exactly match results returned from the toString() 
	public void testHasToString() {
		Foo myFoo = new Foo();
		assertThat(myFoo, hasToString("hello"));
	}
	
	@Test
	public void testInstanceOf() {
		assertThat(new Foo(), is(instanceOf(Object.class)));
	}
	
	@Test
	public void testNotNullValue() {
		Foo myFoo = new Foo();
		assertThat(myFoo, is(notNullValue()));
	}
	
	@Test
	public void testNullValue() {
		String myFoo = null;
		assertThat(myFoo, is(nullValue()));
	}
	
	@Test
	//Failure message shows "differed by" difference outside the range, not total difference
	public void testCloseToWithDouble() {
		Double d1 = 6.00; //For easy demo of error condition change to 7.00
		Double d2 = 4.00;
		Double d3 = 2.00;
		assertThat(d1, is(closeTo(d2, d3)));
	}
	
	@Test
	//Failure message shows "differed by" difference outside the range, not total difference
	public void testCloseToWithBigDecimal() {
		BigDecimal bd1 = new BigDecimal(6.00); //For easy demo of error condition change to 7.00
		BigDecimal bd2 = new BigDecimal(4.00);
		BigDecimal bd3 = new BigDecimal(2.00);
		assertThat(bd1, is(closeTo(bd2, bd3)));
	}
	
	@Test
	public void testGreaterThan() {
		
	}
}
