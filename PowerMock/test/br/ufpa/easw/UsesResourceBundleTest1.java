package br.ufpa.easw;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufpa.easw.UsesResourceBundle;

/**
 * 
 * UsesResourceBundleTest1.java 
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
@RunWith(MockitoJUnitRunner.class)
public class UsesResourceBundleTest1 {

	@Mock
	private ResourceBundle bundle;
	
	
	@Test
	public final void testGetResourceString() {

		String codigo = "3_2993_1";
		String mensagem = "Campo Obrigat�rio n�o Informado";
		
		Mockito.when(ResourceBundle.getBundle("SomeBundleName", Locale.ENGLISH)).thenReturn(bundle);
		Mockito.when(bundle.getString(codigo)).thenReturn(mensagem);

		UsesResourceBundle instance = new UsesResourceBundle();
		
		assertEquals(mensagem, instance.getResourceString(codigo));
	}

}
