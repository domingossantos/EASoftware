package br.ufpa.easw;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by domingossantos on 28/09/15.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Categories.ExcludeCategory(FastTests.class)
@Suite.SuiteClasses({ ContaTest2.class, ContaTest3.class,ContaTest.class })
public class AllSlowTests {
}
