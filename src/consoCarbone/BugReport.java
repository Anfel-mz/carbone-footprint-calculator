package consoCarbone;
/**
 * a class for the anotation BugRepport
 * we use BugReport to report errors 
 * @author manfe
 *
 */
public @interface BugReport {
	String [] reportedBy() default {"anonyme"};
	String description() default "ça ne marche pas";
	
}
