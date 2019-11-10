# Project 3
### Who to Trust?

Always view the [most updated version](https://github.com/usfcs245/Project3 "Project 3") if possible.

Make sure to look the the [DEADLINES](#requirements-and-deadline)

## Description
Here is the [reputation rating data](../master/soc-sign-bitcoinotc_notime.csv "Bitcoin file") from Bitcoin OTC. Each line represents one user (source) giving another user (target) a rating at a given time. The rating can go from -10 (absolutely not trustworthy) to 10 (absolutely trustworthy). Bitcoin address is anonymous, so a user may not wish to make a transaction with another user with bad reputation. This software is going to help users find trustworthy users.

Preview of file:

```
6,2,4
6,5,2
1,15,1
4,3,7
13,16,8
13,10,8
7,5,1
2,21,5
```
> Note: In the first line; 6 is the source, 2 is the target, and 4 is the reputation.


**Input:** The csv will be given through the command line. The source id and target id will be user inputted|
**Output:** The target's average reputation printed to the terminal
**Algorithm:** <br><br> The longer path from source node to target node is, the less trust the source node puts on the ratings on the edges. Imagine your friend's friend's friend's friend's impression on a stranger. Surely it counts less than your friend's. The reputation of the target node is now computed as the sum of all the ratings on the path divided by the length of the path.<br><br> Your software will find all the paths from source node to target node, calculate the reputation of the target on each path, and return the average reputation.
