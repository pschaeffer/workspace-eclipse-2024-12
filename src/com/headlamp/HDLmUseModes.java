package com.headlamp;
import java.util.ArrayList;
import java.util.List;
/**
 * HDLmUseModes short summary.
 *
 * HDLmUseModes description.
 *
 * @version 1.0
 * @author Peter
 */
/* The enum below defines the values of use mode supported by this
   code. Many values of use mode are supported. Many of the values
   are synonyms for each other. For example, on, all, and always are
   synonyms. The same is true for prod and production. Off,
   none, and never are also synonyms. The notset value is used when
   the caller does not specify a use mode. The value "none" is 
   used as a synonym for "off" and "never". */  
public enum HDLmUseModes {
	NOTSET(0), 
	ON(1),  
	ALL(2), 
	ALWAYS(3),
	PROD(4), 
	PRODUCTION(5), 
	TEST(6),
	OFF(7), 
	NONE(8), 
  NEVER(9);
	private static final ArrayList<String>  useModeValues = new ArrayList<String>(
		List.of("NOTSET",
				    "ON", "ALL", "ALWAYS", 
				    "PROD", "PRODUCTION",
				    "TEST",
				    "OFF", "NONE", "NEVER"));	 
	/* Add a field to each enum */
	private final int enumValue;
	/* Provide a constructor for the enum */
	private HDLmUseModes(final int intValue) {
		this.enumValue = intValue;
	}
	/* Return the integer value of the enum to the caller */
	protected int getValue() {
    return enumValue;
  }
  /* We provide a non-standard routine for converting integers to 
     enum values. Note that if a matching enum is not found (for
     the integer passed by the caller), a null value is returned
     by this routine. */
	protected static HDLmUseModes  valueOfInteger(final int newValue) {
    /* Scan all of the enum values looking for a match */
    for (var enumValue : values()) {
      if (enumValue.getValue() == newValue) 
        return enumValue;      
    }
    return null;
  }
  /* We provide a non-standard routine for converting strings to 
     enum values. This routine converts the input string value
     to uppercase and checks the value first. The string passed
     by the caller must not be null. */
  protected static HDLmUseModes valueOfString(String newValue) {
		if (newValue == null) {
		  String  errorText = "String passed to use mode value conversion is null";
		  throw new NullPointerException(errorText);
		}
	  newValue = newValue.toUpperCase();
	  if (useModeValues.contains(newValue)) 
	  	return HDLmUseModes.valueOf(newValue);
	  return HDLmUseModes.NOTSET;
  }
}