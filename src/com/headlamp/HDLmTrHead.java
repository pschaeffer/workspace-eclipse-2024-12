package com.headlamp;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * HDLmTrHead short summary.
 *
 * HDLmTrHead description.
 *
 * @version 1.0
 * @author Peter
 */
/* This class represents the header used for tracing and the routines
   used for tracing. The header is at the start of the memory-mapped
   data area. The header controls the tracing process. The header starts
   with a control block tag followed by a control block length. The 
   control block length is always 256 (256 bytes are not need so 
   padding used as need be. All of the fields in the header must 
   either be constant or offsets. The actual address may change each
   time the memory-mapped area is created. 
   
   The header is followed by the vector of offsets of each
   trace record.
   
   The actual data records follow the vector of offsets. */ 
/* This is not a purely static class and at least one instance of this class
   can definitely be created */
public class HDLmTrHead {	
	/* The next statement initializes logging to some degree. Note that
     having the slf4j jars and the log4j jars in the classpath also
     plays some role in logging initialization. */
  private static final Logger LOG = LoggerFactory.getLogger(HDLmTrHead.class);
	/* The next field contains the control block tag. This is set as part of
	   initialization and never changes. */ 
  byte[]      blockTag = {'T', 'R', 'A', 'C'};
	/* The next field contains the control block length. This is set as part of
     initialization and never changes. Note that this length include the 
     header block padding. */ 
  int         blockLen = 256;
  /* This field contains the entire length of the entire memory-mapped area.
     The entire length includes the header, the offsets vector, and data area
     after the offsets vector */
  long        entireSize = 0;
  /* This field has the offset of the start of the area used for the data
     records */
  long        dataStart = 0;
  /* This field has the offset of the next free byte. This value might much 
     greater than the size of the data area. This value allow the data area
     to wrap around as need be. */
  AtomicLong  nextFree = new AtomicLong(0);
  /* This field has the offset of the start of the area used for the vector
     of data offsets */ 
  long        vectorStart = 0;
  /* This field has the size of the offset vector in entries. The number of 
     entries may (or may not) fit into an integer. */
  long        vectorEntries = 0;
  /* This field has the first message number that is available */
  AtomicLong  firstMsg = new AtomicLong(0);
  /* This field has the last message number that is available */
  AtomicLong  lastMsg = new AtomicLong(0);
  /* The following field is used just for padding */ 
  long[]      padding = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
}