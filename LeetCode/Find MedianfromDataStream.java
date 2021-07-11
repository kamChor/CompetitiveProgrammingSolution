class MedianFinder {
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxQ=new PriorityQueue<>((a,b) -> b-a);
        minQ=new PriorityQueue<>();  
    }
    public void addNum(int num) {
        maxQ.offer(num);
        minQ.offer(maxQ.poll());
        if(maxQ.size()<minQ.size()) maxQ.offer(minQ.poll()); 
    }
    public double findMedian() {
        if(maxQ.size()==0) return 0;
        return maxQ.size()>minQ.size()?maxQ.peek():(double)(maxQ.peek()+minQ.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
