A 2D grid [m x n] initialized with these three possible values.
```
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. 
```
Using the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.

**Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.**

**Sample Grid:**
```
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
```

**Sample Output:**
```
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
```
