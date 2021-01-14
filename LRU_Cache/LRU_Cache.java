import java.util.*;
class Solution {
  static class LRUCache {
    int maxSize;
		int currSize;
		Map<String, DoubleListNode> cache=new HashMap<String, DoubleListNode>();
		DoubleList recentNode=new DoubleList();

    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    public void insertKeyValuePair(String key, int value) {
      // key not in cache- need to insert new
			if(!cache.containsKey(key)){
				//cache full
				if(currSize==maxSize){
					//remove tail node
					evictLeastRecent();
				}
				//not full
				else
					currSize++;
				cache.put(key, new DoubleListNode(key, value));
			}
			//cache contains key --replace value
			else
				replaceKeyValue(key, value);
			updateMostRecent(cache.get(key));
    }

    public LRUResult getValueFromKey(String key) {
      // if cache does not contains key
			if(!cache.containsKey(key))
				return new LRUResult(false,-1);
			updateMostRecent(cache.get(key));
			return new LRUResult(true,cache.get(key).value);
    }

    public String getMostRecentKey() {
      // check in Doubly linked list head for recent node
      if(recentNode==null)
				return "";
			return recentNode.head.key;
    }
		
		public void evictLeastRecent(){
			String key=recentNode.tail.key;
			recentNode.removeTail();
			cache.remove(key);
		}
		
		public void updateMostRecent(DoubleListNode node){
			recentNode.setHeadTo(node);
		}
		
		public void replaceKeyValue(String key, int value){
			if(!this.cache.containsKey(key))
				return;
			cache.get(key).value=value;
		}
  }

	static class DoubleList{
		
		DoubleListNode head=null;
		DoubleListNode tail=null;
		
		public void setHeadTo(DoubleListNode node){
			//head already pointing to curr node
			if(head==node)
				return;
			//No node
			if(head==null){
				head=node; 
				tail=node;
			}
			//one node
			else if(head==tail){
				node.next=head;
				head.prev=node;
				head=node;
			}
			else {
				//node already in list as tail
				if(tail==node){
					removeTail();
				}
				node.removeNodeConnections();
				head.prev=node;
				node.next=head;
				head=node;
			}
		}
		
		public void removeTail(){
			//no node
			if(tail==null)
				return;
			//one node
			if(head==tail){
				head=null;
				tail=null;
				return;
			}
			//otherwise
			tail=tail.prev;
			tail.next=null;
		}
	}

	static class DoubleListNode{
		String key;
		int value;
		DoubleListNode next;
		DoubleListNode prev;
		
		DoubleListNode(String key, int value){
			this.key=key;
			this.value=value;
		}
		
		public void removeNodeConnections(){
			if(prev!=null)
				prev.next=next;
			if(next!=null)
				next.prev=prev;
			next=null;
			prev=null;
		}
		
	}

  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }
}
