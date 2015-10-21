/**
 * 
 */
package br.ufpa.easw;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.ufpa.easw.UsesResourceBundle;

/**
 * 
 * UsesResourceBundleTest2.java 
 * 
 * <p>A test of static methods</p>
 * 
 * Based on post of roger.hughes at
 * http://www.javacodegeeks.com/2011/11/mock-static-methods-with-powermock.html
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UsesResourceBundle.class)
public class UsesResourceBundleTest2 {

	@Mock
	private ResourceBundle bundle;
	
	
	@Test
	public final void testGetResourceString() {

		String codigo = "3_2993_1";
		String mensagem = "Campo Obrigatório não Informado";
		
		PowerMockito.mockStatic(ResourceBundle.class);
		
		PowerMockito.when(ResourceBundle.getBundle("SomeBundleName", Locale.ENGLISH)).thenReturn(bundle);
		PowerMockito.when(bundle.getString(codigo)).thenReturn(mensagem);

		UsesResourceBundle instance = new UsesResourceBundle();
		
		assertEquals(mensagem, instance.getResourceString(codigo));
	}

}

