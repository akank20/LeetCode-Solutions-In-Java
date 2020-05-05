
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//Recursive solution by cloning the node and avoiding already visited nodes(cycles)

class Solution {
    
    HashMap<Node, Node> visitedList=new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        
        if(head==null)
            return null;
        
        if(this.visitedList.containsKey(head))
            return this.visitedList.get(head);
        
        Node cloned=new Node(head.val);
        this.visitedList.put(head, cloned);
        
        cloned.next=this.copyRandomList(head.next);
        cloned.random=this.copyRandomList(head.random);
        
        return cloned;
    }
}

//Leetcode Syntax
public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            
            ListNode ret = new Solution().copyRandomList(head);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}
