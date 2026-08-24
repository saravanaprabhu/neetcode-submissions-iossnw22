class Solution {
    class Node {
        char ch;
        int freq, nextExecutionTime; 
        Node(char task, int freq, int nextExecutionTime) {
            this.ch = task;
            this.freq = freq;
            this.nextExecutionTime = nextExecutionTime;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int result = 0;
        int currentTime = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> {
            return o2.freq - o1.freq;
        });
        Queue<Node> waitingTasks = new LinkedList<>(); 
        for(char task: tasks) {
            count[task-'A']++;
        }
        for(int i=0;i<26;i++) {
            if(count[i] > 0) {
                pq.add(new Node((char)('A' + i) , count[i], 0));
            }
        }
        if(n == 0 ) return tasks.length;
        while(!pq.isEmpty() || !waitingTasks.isEmpty()) {
            currentTime++;    
            if(pq.size() > 0) {
                Node currTask = pq.poll(); 
                currTask.freq--;
                if(n > 0) {
                    if(currTask.freq > 0) {
                        waitingTasks.add(new Node(currTask.ch, currTask.freq, currentTime + n ));
                    }
                }
            }
            if( !waitingTasks.isEmpty() ) {
                Node currentFront = waitingTasks.peek();
                if( currentFront.nextExecutionTime == currentTime ) {
                    Node removeNode = waitingTasks.remove();
                    pq.add(new Node(removeNode.ch, removeNode.freq, removeNode.nextExecutionTime+1));
                }
            }
            
        }

        return currentTime;
    }
}
