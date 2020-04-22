## Given n Servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network such as connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network. A critical connection is a connection that, if removed, will make some server unable to reach some other server. Return all critical connections in the network in any order.

 
````public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)````


### Example:

    Input: n = 7, connections =[[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
    Output: [[5,6],[2,5],[3,4]]
    
