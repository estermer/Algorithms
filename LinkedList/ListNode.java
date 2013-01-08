import java.util.Scanner;

public class ListNode
{
  int data;
  ListNode next;

  /*
   * Getters
   */

  public ListNode getNextNode()
  {
    return this.next;
  }

  public int getNextData()
  {
    return this.data;
  }

  /*
   * Setters
   */

  public void setNextNode(ListNode node)
  {
    this.next = node;
  }
  
  public void setData(int data)
  {
    this.data = data;
  }
  
  public static int listLength(ListNode head)
  {
    int length = 0;

    while (head != null)
    {
      length++;
      head = head.getNextNode();
    }
    return length;
  }

  public static ListNode addToList(ListNode head, ListNode node, int position)
  {
    int listLength = listLength(head);
    if (position < 0 || position > listLength)
    {
    	System.out.println("Incorrect position\n");
    	return head;
    }

    if (position == 0)
    {
      node.next = head;
      head = node;
      return head;
    }
    
    ListNode currNode = head;
    for (int i = 1 ; i < position; i++)
    {
      currNode = currNode.getNextNode();
    }

    node.next = currNode.getNextNode();
    currNode.next = node;
    return head;
  }


  public static ListNode deleteFromList(ListNode head, int position)
  {
    int listLength = listLength(head);
    if (position < 0 || position > (listLength - 1))
    {
      System.out.println("Incorrect position\n");
      return head;
    }

    if (position == 0)
    {
      head = head.next;
      return head;
    }

    ListNode currNode = head;
    for (int i = 0 ; i < position - 1 ; i++)
    {
      currNode = currNode.getNextNode();
    }
    
    currNode.next = (currNode.next).next;
    return head;
  }

  public static void printList(ListNode head)
  {
    int listLength = listLength(head);
    ListNode currNode = head;

    if (listLength == 0)
    {
      System.out.println("Empty\n");
      return;
    }
    for (int i = 0 ; i < listLength ; i++)
    {
      System.out.println("| "+ i +" || "+ currNode.getNextData() +" |");
      currNode = currNode.getNextNode();
    }
  }

  /*public static int findNNode(ListNode head, int position)
  {
    int listLength = listLength(head);
    position = listLength - position - 1;
    if (position < 0 || position > listLength)
    {
      System.out.println("Incorrect position\n");
      return 0;
    }
    
    ListNode currNode = head;
    for (int i = 0 ; i < position ; i++)
    {
      currNode = currNode.next;
    }

    return currNode.data;
  }*/

  public static int findNNode(ListNode head, int position)
  {
    ListNode fastNode = head;
    ListNode slowNode = head;
    int flength = 0;

    if (position < 0)
      return 0;

    while (fastNode != null)
    {
      fastNode = fastNode.next;
      if (flength > position)
      {
        slowNode = slowNode.next; 
      }
      flength++;
    }

    if (position >= flength)
      return 0;
    else 
      return slowNode.data;
  }

  public static int findLoop(ListNode head)
  {
    ListNode fastNode = head;
    ListNode slowNode = head;
    int flength = 0;
    int flag = 0;

    while ((fastNode != null) && (slowNode != null))
    {
      fastNode = fastNode.next;
      if (fastNode == slowNode)
      {
        flag = 1;
        break;
      }
      if (fastNode == null)
      {
        flag = 0;
        break;
      }
      fastNode = fastNode.next;
      if (fastNode == slowNode)
      {
        flag = 1;
        break;
      }
      slowNode = slowNode.next;
    }
    /* finds the start of the loop */
    if (flag == 1)
    {
      slowNode = head;
      while (slowNode != fastNode)
      {
        slowNode = slowNode.next;
        fastNode = fastNode.next;
      }
      return 1;
    }

    /* find the length of the loop */
    /*
    if (flag == 1)
    {
      int counter = 0;
      fastNode = fastNode.next;
      while (slowNode != fastNode)
      {
        counter++;
        fastNode = fastNode.next;
      }
    }*/
    
    return 0;
  }

  public static ListNode reverseList(ListNode head)
  {
    ListNode tempNode = null;
    ListNode nextNode = null;

    while (head != null)
    {
      nextNode = head.next;
      head.next = tempNode;
      tempNode = head;
      head = nextNode;
    }
    return tempNode;
  }

  public static int middleOfList(ListNode head)
  {
    ListNode slowNode = head;
    ListNode fastNode = head;

    while (fastNode != null && fastNode.next != null)
    {
      slowNode = slowNode.next;
      fastNode = (fastNode.next).next;
    }
    return slowNode.data;
  }

  public static void printReverse(ListNode head)
  {
    if (head == null)
      return;
    printReverse(head.next);
    System.out.println(head.data +" ");
  }

  public static void main(String[] args)
  { 
    int data = 0;
    int position = 0;

    System.out.println("Linked List\n");
    Scanner in = new Scanner(System.in);
    System.out.println("Enter data\n");
    data = in.nextInt();
    ListNode head = new ListNode();
    head.setData(data);
    
    /* Initialize list for testing */
    for (int i = 1 ; i < 8 ; i++)
    { 
      ListNode node = new ListNode();
      node.setData((10*i));
      head = addToList(head, node, i);
    }
    System.out.println("Initialized List\n");

    while (true)
    {
      data = 0;
      position = 0;
      System.out.println("Enter\n1. AddtoList\n2. PrintList\n3. DeleteNode\n4. FindFromNthNode\n5. ReverseList\n6. Middle\n7. ReversePrint\n9. DefaultExit\n");
    switch (in.nextInt())
    {
      case 1: 
      ListNode node = new ListNode();
      System.out.println("Enter data\n");
      data = in.nextInt();
      node.setData(data);
      System.out.println("Enter position\n");
      position = in.nextInt();
      head = addToList(head, node, position);
      break;
      case 2:
      System.out.println("List of Elements\n");
      printList(head);
      break;
      case 3:
      System.out.println("Enter position to delete\n");
      position = in.nextInt();
      head = deleteFromList(head, position);
      break;
      case 4:
      System.out.println("Enter position from Nth node to find\n");
      position = in.nextInt();
      int res = findNNode(head, position);
      System.out.println("Data at position : "+ position +" is "+ res +"\n");
      break;
      case 5:
      System.out.println("Reverse List\n");
      head = reverseList(head);
      break;
      case 6:
      int mid = middleOfList(head);
      System.out.println("Middle : "+ mid +"\n");
      break;
      case 7:
      printReverse(head);
      break;
      default:
      System.exit(0);
    }
    }
  }
}
