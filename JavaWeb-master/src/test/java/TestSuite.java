/*
 * @(#) TestSuite.java - 07/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.softtek.java.academy.web.lesson2.CreditCardValidationTest;
import com.softtek.java.academy.web.lesson2.HelloWorldServletTest;
import com.softtek.java.academy.web.lesson3.ProductListTest;
import com.softtek.java.academy.web.lesson3.ShowXMLTest;

/**
 * <code>TestSuite</code> to run all Test Cases.
 * <br><br>
 * You <b>have to run</b> the WebApplication before to execute Unit Testing:
 * <ul>
 *   <li>com.softtek.java.academy.web.lesson2.CreditCardValidationTest</li>
 *   <li>com.softtek.java.academy.web.lesson3.ProductListTest</li>
 *   <li>com.softtek.java.academy.web.lesson3.ShowXMLTest</li>
 * </ul>
 * 
 * <p>
 * Currently Test Cases are configured to run over Tomcat Maven Plugin and are using a URL such as: 
 * <br>
 * <a href="http://localhost:9090/JavaWeb/CreditCardValidation.html">
 *          http://localhost:9090/JavaWeb/CreditCardValidation.html</a>
 * <p>
 *
 * @author luisf.robles
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CreditCardValidationTest.class, HelloWorldServletTest.class,
					 ProductListTest.class, ShowXMLTest.class})
public class TestSuite {

}
