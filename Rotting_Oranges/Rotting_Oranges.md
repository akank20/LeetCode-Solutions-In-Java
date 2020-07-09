Given a grid, each cell can have one of three values:

Value 0 : empty cell;
Value 1 : fresh orange;
Value 2 : rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  

If it is impossible, return -1.

```
Sample 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

```
Sample 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
```

```
Sample 3:
Input: [[0,2]]
Output: 0
```
