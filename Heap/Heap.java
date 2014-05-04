public class Heap {

  int[] heap;
  
  Heap(int size) {
    heap = new int[size + 1];
  }

  int getParent(int i) {
    return (int)i/2;
  }

  int getLeft(int i) {
    return 2*i;
  }

  int getRight(int i) {
    return 2*i+1;
  }

  void heapify(int i) {
    int l = getLeft(i);
    int r = getRight(i);
    int largest;
    
    if(l < heap.length && heap[l] > heap[i])
      largest = l;
    else 
      largest = i;

    if(r < heap.length && heap[r] > heap[largest])
      largest = r;
      
    if(largest != i) {
      int temp = heap[i];
      heap[i] = heap[largest];
      heap[largest] = temp;

      heapify(largest);
    }
  }

  void buildHeap() {
    int l = heap.length - 1;

    for(int i = l/2; i >= 1; i--)
      heapify(i);
  }

  public static void main(String[] args) {
    Heap h = new Heap(8);

    int[] x = {0, 8, 15, 4, 3, 16, 11, 12};
    h.heap = x;

    h.buildHeap(); 

    for(int i = 1; i < h.heap.length; i++) {
      System.out.println(h.heap[i]);
    }
  }
}
