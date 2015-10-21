package br.ufpa.easw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * AllTests.java 
 * 
 * <p>Run all tests with Mockito</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@RunWith(Suite.class)
@SuiteClasses({ ContaTest1.class, ContaTest2.class, ContaTest3.class, ContaTest4.class, ContaTest5.class })
public class AllTests {

}
