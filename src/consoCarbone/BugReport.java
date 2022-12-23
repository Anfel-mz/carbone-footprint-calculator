package consoCarbone;
/**
 * a class for the anotation BugRepport
 * we use BugReport to report errors 
 * @author manfe
 *
 */
public @interface BugReport {
	/**
	 * 
	 * @return the name of the person reporting the error
	 */
	String [] reportedBy() default {"anonyme"};
	/**
	 * 
	 * @return a description telling what's not working in the code
	 */
	String description() default "ça ne marche pas";
	
}
