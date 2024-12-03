package driver;

//Q1: What are truly these values?
//A1: integer array

//Q2: Why do we use it?
//A2: easy to read and hard to make errors

//Q3: Any other benefits?
//A3: faster when being compiled

//Q4: Why do we use enum?
//A4: when we need some constants in the code

public enum ItemFlag {
	empty_since_start,
	empty_after_removal,
	common_item
}
