import java.util.Stack;

public class MinStack {
  /** initialize your data structure here. */
  Stack<Integer> stack;
  Stack<Integer> minStack;
  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    if(minStack.isEmpty() || x <= minStack.peek()) {
      minStack.push(x);
    }
  }

  public void pop() {
    int top = stack.peek();
    System.out.println("top: "+top);
    if(!minStack.isEmpty() && minStack.peek() == top) {
      minStack.pop();
    }
    stack.pop();
  }

  public int top() {
    return !stack.isEmpty() ? stack.peek() : -1;
  }

  public int getMin() {
    return minStack.isEmpty() ? -1 : minStack.peek();
  }
}
