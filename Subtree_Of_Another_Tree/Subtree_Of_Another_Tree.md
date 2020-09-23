Given two Binary trees 'S' and 'T', we need to check whether tree 'T' has exactly the same structure and node values with a subtree of 'S'. 
A subtree of 'S' is a tree consists of a node in 'S' and all of this node's descendants. The tree 'S' could also be considered as a subtree of itself.

```
Example 1:

Tree 'S':          
     3                
    / \ 
   4   5
  / \
 1   2
 
 Tree 'T':
   4 
  / \
 1   2
 'T' is a subtree of 'S' : TRUE
 ```
 
 ```
 Example 2:
 
 Tree 'S':
     3
    / \
   4   5
  / \
 1   2
    /
   0
   
 Tree 'T':
   4
  / \
 1   2
 'T' is not a subtree of 'S' : FALSE
 ```
 
 ```
 Example 3:
 
 Tree 'S':
     1
    / 
   1
   
 Tree 'T':
   1
  
 'T' is a subtree of 'S' : TRUE
 ```
 
