public class MergeSort {
  
  private int[] num;
  private int[] aux;

  public void sort(int[] num) {
    this.num = num;
    int n = num.length;
    this.aux = new int[n];
    mergeSort(0, n-1);
  }

  public void mergeSort(int low, int high) {
    if (low < high) {
      int middle = low + (high - low) / 2;
      mergeSort(low, middle);
      mergeSort(middle + 1, high);
      merge(low, middle, high);
    }
  }
  
  public void merge(int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      aux[i] = num[i];
    }    

    int i = low;
    int j = middle + 1;
    int k = low;
    while (i <= middle && j <= high) {
      if (aux[i] <= aux[j]) {
        num[k] = aux[i];
        i++;
      }
      else {
        num[k] = aux[j];
        j++;
      }
      k++;
    }

    while (i <= middle) {
      num[k] = aux[i];
      k++;
      i++;
    }
  }

  public static void main(String[] args) {
    MergeSort m = new MergeSort();
    int[] numbers = new int[] {5, 4, 1, 3, 2};
    m.sort(numbers);

    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}
