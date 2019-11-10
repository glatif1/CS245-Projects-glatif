## Description

Implemented k-way merge sort for any `k>=2`, using *only* int arrays. This is basically a merge sort with a given (k) number of times to split the list . A customized arraylist class is used for this project. Built-in collections are not used. Arrays class is only used to print the content of the array.

## Input

The input is given as a text file and will contain:

- k (for k-way merge sort) 
- list of numbers separated by whitespace (space, tab, newline)

**Note:** The first number in the numbers file is your *k* or how many ways your merge sort will do.

**Note:** The text file will be provided as a command line argument. For example: `java project1 numbers`.


## Output

The output is also a file in the format of

- the numbers sorted in an ascending order

and the matching example output file for numbers is [numbers_sorted]
Note: that the name of the output file is *\<name of the input file>***_sorted**.

## Additional Notes and Requirements

For any input size that is *not* divisible by k, the list is split into (k-1) lists that contain (n/k) elements and 1 list for the rest of the elements. For example, if the input size is 11 and k is 5, then the list will be split into (2, 2, 2, 2, 3) elements. 

**Note:** If the input size is 14 and k is 5, then the list will be split into (2, 2, 2, 2, 6) elements.

This program prints the array at the end of every merge method call. In other words, if the input is [4, 2, 6, 1] for 2-way merge, then the program prints:

	[2, 4, 6, 1]

	[2, 4, 1, 6]
	
	[1, 2, 4, 6]
