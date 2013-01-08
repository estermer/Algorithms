import java.util.Scanner;

public class Stack
{
  int top;
  int capacity;
  int[] array;
  static int min = 0;
  static int[] minArr;
  static int count = 0;
  
  Stack()
  {
    capacity = 10;
    array = new int[capacity];
    top = -1;
    minArr = new int[capacity];
  }

  public boolean isEmpty()
  {
    return (this.top == -1);
  }

  public boolean isFull()
  {
    return (this.top == (this.capacity -1));
  }

  public int push(int data)
  {
    if (this.isFull())
    {
      return -1;
    }
    if (min == 0)
      min = data;
    else if (data < min)
    {
      min = data;
    }
    this.array[++top] = data;
    minArr[count++] = min;
    return data;
  }
  
  public int pop()
  {
    if(this.isEmpty())
    {
      return -1;
    }
    minArr[count] = 0;
    --count;
    if (count != 0)
      min = minArr[count];
    else
      min = 0;
    return this.array[top--];
  }

  public void delete()
  {
    this.top = -1;
  }

  public void print(Stack s)
  {
    for (int i = 0 ; i <= s.top; i++)
    {
      System.out.println(s.array[i]);
    }
  }

  public void reverseStack(Stack s)
  {
    if (s.isEmpty())
      return;
    int data = s.pop();
    reverseStack(s);

    pushToBottom(s, data);
  }

  public void pushToBottom(Stack s, int data)
  {
    if (s.isEmpty())
    {
      s.push(data);
      return;
    }
    int temp = s.pop();
    pushToBottom(s, data);
    s.push(temp);
  }
  public static void main(String[] args)
  {
    Stack s = new Stack();
    Scanner input = new Scanner(System.in);
    int choice = 0;

    while(true)
    {
      System.out.println("1.Push 2.Pop 3.IsEmpty 4.IsFull 5.Delete 6.Print 7.Reverse 8.Min 9.Exit");
      choice = input.nextInt();
      switch(choice)
      {
        case 1:
          int value = input.nextInt();
          System.out.println("Pushed: "+s.push(value));
          break;
        case 2:
          System.out.println("Popped : "+s.pop()+"\n");
          break;
        case 3:
          if (s.isEmpty())
            System.out.println("Stack empty\n");
          else
            System.out.println("Not empty\n");
          break;
        case 4:
          if (s.isFull())
            System.out.println("Stack full\n");
          else
            System.out.println("Not full\n");
          break;
        case 5:
          s.delete();
          System.out.println("Stack deleted\n");
          break;
        case 6:
          s.print(s);
          break;
        case 7:
          s.reverseStack(s);
          s.print(s);
          break;
        case 8:
          System.out.println("Min: \n"+min);
          for (int i = 0 ; i < count ; i++)
            System.out.println("\n"+minArr[i]);
          break;
        default:
          System.exit(0);
      }
    }
  }
}
