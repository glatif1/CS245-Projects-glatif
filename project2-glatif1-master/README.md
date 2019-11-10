## Description

In this project, I have coded my own insertion sort, quick sort, and bucket sort. I use these sorts to sort Amazon products based on reviews. The original data can be found [here](http://jmcauley.ucsd.edu/data/amazon/ "Amazon Review Data"). The original data is formatted with each line being a new review. For this project, I will be using a condensed version where each line is a different product. Comparable interface interface is implemented.

The consensed file is formatted as `<ASIN>,"[ratings]"` per line. In the file it will look something like this:

#### Array Based List
Created an array based list without importing ArrayList. The array based list extends `AbstractList` though. It has these method: get(index), size(), add(Object), add(index, Object), remove(index), and set(index, Object).

This array based list has a dynamic size change. The default size is 100. 


```
8805002917,"[1]"
9792372326,"[5, 5, 5, 4, 5, 5, 5, 5, 5, 5, 5, 4, 5, 4, 4, 5, 5, 5]"
9868238854,"[5, 5]"
B0000000P3,"[5, 5]"
B0000000PB,"[5]"
```
The first String up to the comma in each line is the `ASIN` or *Amazon Standard Identification Number*. If you would like to, you can go [here](http://www.amazon-asin.com/ "ASIN Lookup") to look up what item each ASIN correlates to. These ASINs may have been changed from when the data was recorded (May 1996 - July 2014). Next in the file is an array of integers in quotes. This array is the ratings. The file name will loook like `ratings_Musical_Instruments_short_condensed.csv`.

## Sorting

Sorting is based on average rating from highest to lowest.

## Input

Input will be given through the command line. This will be the condensed csv file. Such as:

```
> java Driver ratings_Musical_Instruments_short_condensed.csv
```

## Output

One sort method can be chosed to sort the condensed file. The other sorts need to be functional as well though. After you have sorted the file write to \<condensed file name>_sorted.csv. The written file for `ratings_Musical_Instruments_short_condensed.csv` will look like `ratings_Musical_Instruments_short_condensed_sorted.csv`.

A sorted list of ASIN separated by new lines is written to the file. For example:

```
9868238854
B0000000P3
B0000000PB
9792372326
8805002917
```

