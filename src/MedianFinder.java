import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

  public static void main(String...strings) {
    MedianFinder sol = new MedianFinder();
    sol.addNum(5);
    sol.addNum(2);
    sol.addNum(4);
    sol.addNum(3);
    System.out.println("median: "+sol.findMedian());
  }

  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  /** initialize your data structure here. */
  public MedianFinder() {
    minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n)); //tracks nums right of mid element
    maxHeap = new PriorityQueue<>((n1,n2) -> n2-n1); //tracks nums left of mid element
  }

  public void addNum(int num) {
    //put the first num in maxHeap
    if(minHeap.isEmpty() && maxHeap.isEmpty()) {
      maxHeap.offer(num);
    }else if(maxHeap.isEmpty()) {
      if(num > minHeap.peek()) {
       minHeap.offer(num);
       maxHeap.offer(minHeap.poll());
      }else {
        maxHeap.offer(num);
      }
    }
    else if(minHeap.isEmpty()) {
      if(num < maxHeap.peek()) {
        maxHeap.offer(num);
        //rebalance
        minHeap.offer(maxHeap.poll());
      }else {
        minHeap.offer(num);
      }
    }
    else if(num <= maxHeap.peek()) {
      if(maxHeap.size() <= minHeap.size()) {
        maxHeap.offer(num);
      }else {
        maxHeap.offer(num);
        //rebalance
        minHeap.offer(maxHeap.poll());
      }
    }else if(num >= minHeap.peek()) {
      if(minHeap.size() <= maxHeap.size()) {
        minHeap.offer(num);
      }else {
        minHeap.offer(num);
        //rebalance
        maxHeap.offer(minHeap.poll());
      }
    }else {
      if(maxHeap.size() < minHeap.size()) {
        maxHeap.offer(num);
      }else if(minHeap.size() < maxHeap.size()) {
        minHeap.offer(num);
      }else {
        maxHeap.offer(num);
        //rebalance
        minHeap.offer(maxHeap.poll());
      }
    }
  }

  public double findMedian() {
    if((minHeap.size() + maxHeap.size())%2 == 0) {
      return (double) (minHeap.peek() + maxHeap.peek())/2;
    }else {
      if(maxHeap.size() > minHeap.size()) {
        return maxHeap.peek();
      }return minHeap.peek();
    }
  }
}
