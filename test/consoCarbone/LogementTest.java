package consoCarbone;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


public class LogementTest {
	private Logement logementTest;
	
	@BeforeEach
	public void initLogement() {
		logementTest = new Logement();
	}
	
	@AfterEach
	public void undefLogement() {
		this.logementTest = null;
	}
	
	@Test
	@DisplayName ("should create Logement instance")
	public void shouldCreateLogement() {
		this.logementTest.setCe(CE.F);
		this.logementTest.setSuperficie(20);
		Assertions.assertTrue(this.logementTest.getCe().equals(CE.F));
		Assertions.assertTrue(this.logementTest.getSuperficie() == 20);
		Assertions.assertTrue(this.logementTest.getImpact() == (new Logement(20, CE.F).getImpact()));
	}
	
	@DisplayName("setSuperficie method should update the impact")
	@ParameterizedTest
	@ValueSource (ints = {20, 75})
	public void  setSuperficieUpdateImpact(int superficie) {

		this.logementTest.setSuperficie(superficie);
		this.logementTest.setCe(CE.A);
		Assertions.assertEquals(this.logementTest.getImpact(), (new Logement(superficie, CE.A)).getImpact());
	} 
	
	@DisplayName("setCe method should update the impact")
	@ParameterizedTest
	@MethodSource ("CeList")
	public void  setCEUpdateImpact(CE ce) {

		this.logementTest.setSuperficie(20);
		this.logementTest.setCe(ce);
		Assertions.assertEquals(this.logementTest.getImpact(), (new Logement(20, ce)).getImpact());
	} 
	
	private static List<CE> CeList (){
		return Arrays.asList(CE.A,CE.B, CE.E);
	}
	
	@DisplayName("should throw exception if superficie est negative")
	@ParameterizedTest
	@ValueSource (ints = {-1, -2})
	public void  shouldThrowIllegalArgumentExceptionWhensuperficieIsUnvalid(int arg) {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			this.logementTest.setSuperficie(arg);
		});
		
	}


}
