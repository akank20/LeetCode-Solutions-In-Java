Given total of numCourses courses you have to take.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


**Example 1:**
```
Input: numCourses = 5, prerequisites = [[1,0],[0,2],[2,1],[4,0],[3,4]]  
Output: false
```

**Example 2:**
```
Input: numCourses = 5, prerequisites =[[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]
Output: true
```

**Constraints:**
```
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
```
