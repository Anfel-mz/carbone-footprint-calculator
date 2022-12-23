package consoCarbone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class AlimentationTest {
private Alimentation alimentationTest;

@BeforeEach
public void initAlimentation() {
	alimentationTest = new Alimentation();
}

@AfterEach
public void undefAlimentation() {
	this.alimentationTest = null;
}


@Test 
@DisplayName ("should create Alimentation instance ")
public void shouldCreateAlimentation() {
	this.alimentationTest.setTxBoeuf(0.6);
	this.alimentationTest.setTxVege(0.4);
	assertTrue(this.alimentationTest.getTxBoeuf() == 0.6);
	assertTrue(this.alimentationTest.getTxVege() == 0.4);
	assertTrue(this.alimentationTest.getImpact() == (new Alimentation(0.6, 0.4).getImpact()));
}


@DisplayName("should throw exception if the txBoeuf value is not between 0 and 1")
@ParameterizedTest
@ValueSource (doubles = {-1, 2})
public void  shouldThrowIllegalArgumentExceptionWhentxBoefIsUnvalid(double arg) {
	Assertions.assertThrows(IllegalArgumentException.class, () ->{
		alimentationTest.setTxBoeuf(arg);
	});
	
}


@DisplayName("should throw exception if the txVege value is not between 0 and 1")
@ParameterizedTest
@ValueSource (doubles = {-1, 2})
public void  shouldThrowIllegalArgumentExceptionWhentxVegeIsUnvalid(double arg) {
	Assertions.assertThrows(IllegalArgumentException.class, () ->{
		alimentationTest.setTxVege(arg);
	});
	
}

@DisplayName("update correctly the impact after the setter")
@ParameterizedTest
@ValueSource (doubles = {0.5, 0.7})
public void  setTxupdateImpact(double t) {

	this.alimentationTest.setTxBoeuf(t);
	this.alimentationTest.setTxVege(t+0.05);
	Assertions.assertEquals(this.alimentationTest.getImpact(), (new Alimentation (t,t+0.05)).getImpact());
}



}
