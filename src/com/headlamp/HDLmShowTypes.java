package com.headlamp;
import java.util.ArrayList;
import java.util.List;
/**
 * HDLmShowTypes short summary.
 *
 * HDLmShowTypes description.
 *
 * @version 1.0
 * @author Peter
 */
/* The enum below shows how output should be handled. We can send 
   output to standard output and to the log. */
public enum HDLmShowTypes {
	NONE,	
	SHOWLOG,
	SHOWPRINT;
	private static final ArrayList<String>  typeValues = new ArrayList<String>(
		List.of("NONE", "SHOWLOG", "SHOWPRINT"));	
  /* We provide a non-standard routine for converting strings to 
     enum values. This routine converts the input string value
     to uppercase and checks the value first. The string passed
     by the caller must not be null.*/
	protected static HDLmShowTypes valueOfString(String newType) {
		if (newType == null) {
		  String  errorText = "String passed to show type conversion is null";
		  throw new NullPointerException(errorText);
		}
	  newType = newType.toUpperCase();
	  if (typeValues.contains(newType)) 
	    return HDLmShowTypes.valueOf(newType);
	  return HDLmShowTypes.NONE;
	}
}