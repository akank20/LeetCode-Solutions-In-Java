class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> arrList;
    
    public MedianFinder() {
        arrList = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        arrList.add(num);
    }
    
    public double findMedian() {
        Collections.sort(arrList);
        int n = arrList.size();
        return (n % 2 == 0) ?
            ((arrList.get(n/2 -1) + arrList.get(n/2)) /2.0) :
            arrList.get(n/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
