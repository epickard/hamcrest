package hamcrest;

import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
		assertThat(a, describedAs("greeting", is(not(nullValue()))));	
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
}
