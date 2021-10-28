class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //Use min heap to store the end times of meeting
        PriorityQueue<Integer> rooms = new PriorityQueue<Integer>();
        //Sort the intevals array by their start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        //Add the endTime for first interval to the heap
        rooms.add(intervals[0][1]);
        //Compare next startTime with the earliest ending meeting, if room is empty
        for(int i = 1; i < intervals.length; i++){
            int currEnd = rooms.peek();
            int start = intervals[i][0];
            if(start >= currEnd){
                rooms.poll();
            }
            rooms.add(intervals[i][1]);
        }
        return rooms.size();
    }
}
