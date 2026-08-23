class MedianFinder {
    private PriorityQueue<Integer> maxHeap , minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(); 
    }
    
    public void addNum(int num) {
        // Step 1: Push to maxHeap first, then route the largest element to minHeap
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        // Step 2: Maintain size property (maxHeap holds equal or 1 extra element)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
