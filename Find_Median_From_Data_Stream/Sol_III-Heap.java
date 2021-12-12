class MedianFinder {

    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;
    
    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>(Collections.reverseOrder());
        
    }
    
    public void addNum(int num) {
        //no elem
        if(maxH.isEmpty() && minH.isEmpty()){
            maxH.add(num);
            return;
        }
        //even Length, adding curr elem will return odd length of stream
        if(maxH.size() == minH.size()){
            //top ele at minH is smaller than curr ele, then balance
            if(minH.peek() < num){
                maxH.add(minH.poll());
                minH.add(num);
            }
            else
                maxH.add(num);
        }//odd Length, adding curr elem will return even length of stream
        else{
            if(num < maxH.peek()){
                minH.add(maxH.poll());
                maxH.add(num);
            }
            else
                minH.add(num);
        }
    }
    
    public double findMedian() {
        //even length
        if(minH.size() == maxH.size())
            return (maxH.peek() + minH.peek())/2.0;
        else
            return maxH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
