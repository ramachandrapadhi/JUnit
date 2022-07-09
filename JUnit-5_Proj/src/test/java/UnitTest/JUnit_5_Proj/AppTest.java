package UnitTest.JUnit_5_Proj;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

//@TestMethodOrder(value = OrderAnnotation.class)
//@TestMethodOrder(value = MethodName.class)
//@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@DisplayName("Bank Lone Service Class ")
public class AppTest {
	/*
	 * @Test 	   use for method is available to test
	 * @DisplayName("Bank Lone Service Class ") use for change default name to user specific name
	 * @TestMethodOrder(value = OrderAnnotation.class) use for order the test method based on specified order
	 * @Order(1)   use for order the method when using OrderAnnotation.class in above annotation
	 * @BeforeEach use for the method executes before each test 
	 * @AfterEach  use for the method executes after each test 
	 * @BeforeAll  use for the method executes before all test methods only once and it will be a static method 
	 * @AfterAll   use for the method executes after all test methods only once and it will be a static method 
	 * @Tag 	   use for the profile environment DEV,TEST,UAT,PROD 
	 * 			  (rightClick Run As --> runConfiguration --> test tab --> configure --> include and exclude --> apply --run )
	 * 
	 * TestInfo(I) use for get class, parameter, displayName,methodName details if we pass the interface into method arguments
	 * 
	 * @RepeatedTest(value = 10, name = "Execution of {displayName} :- {currentRepetition}/{totalRepetitions}") use for repeated test like batch process
	 * Note : here @Test should not use because @RepeatedTest itSelf a @Test
	 * 
	 * @ParameterizedTest use for Parameterized method test, here also no need @Test annotation
	 * @ValueSource(strings = {"","d"," "}) for @ParameterizedTest pass value of array(strings, ints etc) 
	 * 
	 * @ValueSource(strings = {"",""," "}) instant of passing empty value use @EmptySource annotation for empty checking
	 * @NullSource use for @EmptySource annotation to checking null value
	 * @NullAndEmptySource use for checking null or empty parameter value
	 * 
	 * */
	
	
	

	
	
	private static BankLoanService service ;

	//	@BeforeEach
	//	public void doEachBefore() {
	//		System.out.println("AppTest.doEach()");
	//		service = new BankLoanService();
	//	}
	//	@AfterEach
	//	public void doEachAfter() {
	//		System.out.println("AppTest.doEachAfter()");
	//		service = null;
	//	}

	@BeforeAll
	public static void doBeforeAll() {
		System.out.println("AppTest.doBeforeAll()");
		service = new BankLoanService();
	}
	@AfterAll
	public static void doEachAfter() {
		System.out.println("AppTest.doEachAfter()");
		service = null;
	}


	@Test
//	@Order(1)
	@Tag("dev")
	@DisplayName("Test with Small number")
	public void testcalcSimpleInterestSmallNumber(TestInfo info) {
		
		System.out.println(info.getTags()+" "+info.getTestMethod().get().getName()+" "+ info.getDisplayName()+" " +info.getTestClass().get().getName());

		//		BankLoanService service = new BankLoanService();
		double actual = service.calcSimpleInterest(100000, 2, 12);
		double expected = 24000;
		assertEquals(actual, expected, "May be both result are not matched...!");
	}

	@Test
//	@Order(2)
//	@Tag("dev")
	@DisplayName("Test with Big number")
	public void testcalcSimpleInterestBigNumber() {
		//		BankLoanService service = new BankLoanService();

		double actual = service.calcSimpleInterest(10000000, 2, 12);
		double expected = 2400000;
		assertEquals(actual, expected,"May be both result are not matched...!");
	}
	@Test
//	@Order(3)
//	@Tag("uat")
	@DisplayName("Test with Invalid inputs")
	public void testcalcSimpleInterestInvalidInput() {
		//		BankLoanService service = new BankLoanService();

		assertThrows(IllegalArgumentException.class, ()->service.calcSimpleInterest(0, 0, 0));
		//		assertThrows(ArithmeticException.class, 
		//				()->service.calcSimpleInterest(0, 0, 0),
		//				"May be raised Exception not matched...!");
	}

	@Test
//	@Order(4)
	@Disabled
//	@Tag("uat")
	@DisplayName("Test with Method execution time")
	public void testcalcSimpleInterestLimitTime() {
		BankLoanService service = new BankLoanService();

		assertTimeout(Duration.ofMillis(10000), ()->service.calcSimpleInterest(10000, 2, 12),
				"Method execution time out..");
	}

	@Test
//	@Order(5)
//	@Tag("dev")
	@DisplayName("Test with No exception")
	public void testcalcSimpleInterestNoException() {
		//		BankLoanService service = new BankLoanService();

		assertDoesNotThrow(()->service.calcSimpleInterest(10000, 2, 12),
				"Method is throwing some exception fix the exception ");
	}
	
//	@Test  // no need here @Test annotation
	@RepeatedTest(value = 10, name = "Execution of {displayName} :- {currentRepetition}/{totalRepetitions}")
	@DisplayName("Test with repeat test")
	public void repeatTest() {
		System.out.println("AppTest.repeatTest()");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"","d"," "})
	public void testhelloString(String name) {
		assertEquals("hello "+name, service.helloString(name));
	}
	
	/*
	 * @ParameterizedTest 
	 * // @ValueSource(strings = {"",""," "}) instant of passing
	 * null value use @EmptySource annotation
	 * 
	 * @EmptySource public void testcheckEmpty(String name) {
	 * assertTrue(service.checkEmpty(name)); }
	 */
	
	
	/*
	 * @ParameterizedTest
	 * 
	 * @NullSource public void testcheckEmpty(String name) {
	 * assertTrue(service.checkEmpty(name)); }
	 */
	
	
	@ParameterizedTest
	@NullAndEmptySource
	public void testcheckEmpty(String name) {
		assertTrue(service.checkEmpty(name));
	}



















}
