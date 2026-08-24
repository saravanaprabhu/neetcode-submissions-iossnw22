class Solution {
    public int[][] kClosest(int[][] points, int k) {
        class Node {
            private record Pair(int x, int y) {};
            private int distance;
            private Pair pair;
            Node(Pair pair, int distance) {
                this.pair = pair;
                this.distance = distance;
            }
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((o1, o2) -> {
            return o1.distance - o2.distance;
        });
        for(int i=0;i< points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            minHeap.add(new Node(new Node.Pair(points[i][0], points[i][1]), dist));
        }
        int[][] result = new int[k][2];
        for(int i=0;i<k;i++) {
            Node node = minHeap.poll();
            result[i][0] = node.pair.x;
            result[i][1] = node.pair.y;
        }   
        return result;
    }
}
