class MinStack {
    private Stack<Integer> mainStack ; 
    private Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if(minStack.peek() >= val) {
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        if(!mainStack.isEmpty()) {
            int popElem = mainStack.pop();
            if(!minStack.isEmpty() && minStack.peek() == popElem) {
                minStack.pop();
            }
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
