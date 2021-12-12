class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> arrList;
    
    public MedianFinder() {
        arrList = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        if(arrList.size() == 0){
            arrList.add(num);
            return;
        }
        arrList.add(num);
        int j = arrList.size() - 2;
        while( j >= 0 && arrList.get(j) > num){
            arrList.set(j+1, arrList.get(j));
            j--;
        }
        arrList.set(j+1, num);
    }
    
    public double findMedian() {
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
