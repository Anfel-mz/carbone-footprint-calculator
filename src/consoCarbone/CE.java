package consoCarbone;

//les différentes classes énergétiques d'un logement
public enum CE {
A(0.005),B(0.01),C(0.02),D(0.035),E(0.055),F(0.08),G(0.1);

	private final double co;
	private CE(double d) {
		this.co = d;
	}
	public double getCo() {
		return this.co;
	}
}
