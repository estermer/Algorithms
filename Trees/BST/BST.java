import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BST
{
  private Node root;

  private class Node
  {
    Node left;
    Node right;
    int value;
 
    Node()
    {}
 
    Node(int value)
    {
      this.value = value;
    }
 }


  /*
   * To insert value in a tree
   */
  void insert(Node node, int value)
  {
    if (value <= node.value)
    {
      if (node.left != null)
      {
        insert(node.left, value);
      }
      else
      {
       System.out.println("Inserted "+ value +" to the left of "+ node.value+"\n");
       node.left = new Node(value);
      }
    }
    else if (value > node.value)
    {
      if (node.right != null)
      {
        insert(node.right, value);
      }
      else
      {
        System.out.println("Inserted "+ value +" to the right of "+ node.value+"\n");
        node.right = new Node(value);
      }
    }
  }

  int maxLevel(Node node)
  {
    int maxLevel = 0, currLevel = 0;
    int currSum = 0, maxSum = 0;
    Node temp;

    Queue<Node> queue = new LinkedList<Node>();    
    if (node == null)
      return 0;
    
    queue.add(node);
    queue.add(null);

    while (!queue.isEmpty())
    {
      temp = queue.poll();
      
      if (temp == null)
      {
        if (currSum > maxSum)
        {
          maxSum = currSum;
          maxLevel = currLevel;
        }

        if (!queue.isEmpty())
          queue.add(null);
        currSum = 0;
        currLevel++;
      }
      else
      {
        currSum += temp.value;

        if (temp.left != null)
          queue.add(temp.left);

        if (temp.right != null)
          queue.add(temp.right);
      }
    }
    return maxLevel;
  }

  boolean hasPathSum(Node node, int sum)
  {
    if (node == null)
      return (sum == 0);
    else
    {
      int subSum = sum - node.value;
      return (hasPathSum(node.left, subSum)||hasPathSum(node.right, subSum));
    }
  }

  int sumOfAll(Node node)
  {
    if (node == null)
      return 0;
    else
    {
      return (node.value + sumOfAll(node.left) + sumOfAll(node.right));
    }
  }

  Node mirrorTree(Node node)
  {
    if (node == null)
      return;
    else
    {
      mirrorTree(node.left);
      mirrorTree(node.right);
      temp = node.left;
      node.left = node.right;
      node.right = temp;
    }
    return node;
  }

  boolean checkMirror(Node node1, Node node2)
  {
    if (node1 == null && node2 == null)
      return true;
    if (node1 == null || node2 == null)
      return false;
    if (node1.value != node2.value)
      return false;
    else
      return (checkMirror(node1.left, node2.right) && checkMirror(node1.right, node2.left));
  }

  void printAllPaths(Node node, int[] path, int len)
  {
    if (node == null)
      return;

    path[len] = node.value;
    len++;

    if (node.left == null && node.right == null)
      printArray(path, len);
    else
    {
      printAllPaths(node.left, path, len);
      printAllPaths(node.right, path, len);
    }
  }

  void printArray(int[] arr, int len)
  {
    for (int i = 0 ; i < len ; i++)
    {
      System.out.print(arr[i]);
    }
    System.out.println("\n");
  }
/*
 * Search the tree for a value
 */
  int findNode(Node node, int value)
  {
    if (node == null)
      return 0;
    else if (value < node.value)
      return findNode(node.left, value);
    else if (value > node.value)
      return findNode(node.right, value);
    else if(value == node.value)
      return 1;

    return 10;
  }

/*
 * Calculate the size of the tree
 */
  int size(Node node)
  {
    if (node == null)
      return 0;
    else
      return (size(node.left) + size(node.right) + 1);
  }


/*
 * Calculate the Max Depth of a tree
 */

  int maxDepth(Node node)
  {
    if (node == null)
      return 0;
    else
    {
      int lcount = maxDepth(node.left);
      int rcount = maxDepth(node.right);

      if (lcount > rcount)
        return (lcount + 1);
      else
        return (rcount + 1);
    }
  }

/*
 * Print the MinValue of tree
 */

  int minValue(Node node)
  {
    while(node.left != null)
    {
      node = node.left;
    }
    return node.value;
  }

/*
 * MaxValue in Tree
 */

  int maxValue(Node node)
  {
    while(node.right != null)
    {
      node = node.right;
    }
    return node.value;
  }

/*
 * Print Tree values
 */

  void printTree(Node node)
  {
    if (node == null)
      return; 
    else
    {
      printTree(node.left);
      System.out.println(node.value+" - ");
      printTree(node.right);
    }
  }

  int LCA(Node root, int p, int q)
  {
    if (root == null)
      return -1;
    
    if (Math.max(p, q) < root.value)
      return LCA(root.left, p, q);
    else if (Math.max(p, q) > root.value)
      return LCA(root.right, p, q);
    else
      return root.value;
  }

  void preOrder(Node node)
  {
    if (node == null)
      return;
    else
    {
      System.out.println(node.value);
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  void preOrderStack(Node node)
  {
    if (node == null)
      return;

    Stack<Node> stack = new Stack<Node>();
    while (true)
    {
      while (node != null)
      {
        System.out.println(node.value);
        stack.push(node);
        node = node.left;
      }

      if (stack.isEmpty())
        break;
      
      node = stack.pop();
      node = node.right;
    }
  }

  void inOrder(Node node)
  {
    if (node == null)
      return;
    else
    {
      inOrder(node.left);
      System.out.println(node.value);
      inOrder(node.right);
    }
  }

  void inOrderStack(Node node)
  {
    if (node == null)
      return;
    Stack<Node> stack = new Stack<Node>();
    while (true)
    {
      while (node != null)
      {
        stack.push(node);
        node = node.left;
      }

      if (stack.isEmpty())
        break;

      node = stack.pop();
      System.out.println(node.value);
      node = node.right;
    }
  }

  void postOrder(Node node)
  {
    if (node == null)
      return;
    else
    {
      postOrder(node.left);
      postOrder(node.right);
      System.out.println(node.value);
    }
  }

  /*void postOrder(Node node)
  {
    if (node == null)
      return;

    while (true)
    {
      while (node != null)
      {
        
      }
    }
  }*/
/*
 * This is for a binary tree and not BST
 */
  int largest(Node node)
  {
    int node_val;
    int left;
    int right;
    int max = 0;

    if (node == null)
      return 0;
    
    node_val = node.value;
    
    left = largest(node.left);
    right = largest(node.right);

    if (left > right)
      max = left;
    else
      max = right;

    if (max < node_val)
      max = node_val;

    return max;
  }

  boolean findElement(Node node, int data)
  {
    boolean ret;

    if (node == null)
    {
      return false;
    }
      else
      {
        
        if (node.value == data)
        {
          return true;
        }
        else
        {
          ret = findElement(node.left, data);

          if (ret != false)
            return ret;
          else
            return findElement(node.right, data);
        }
      }
  }

  int treeDiameter(Node node, int diameter)
  {
    if (node == null)
      return 0;

    int left = treeDiameter(node.left, diameter);
    int right = treeDiameter(node.right, diameter);

    if ((left + right) > diameter)
      diameter = left + right;

    return Math.max(left,right) + 1;
  }
/*
 * Main Function 
 */
  public static void main(String[] args)
  {
    System.out.println("Creating a Binary search tree \n");
    BST bst = new BST();
    Scanner scan = new Scanner(System.in);
    BST.Node node = bst.new Node(10);
    boolean flag = true;

    try 
    {
    while(flag)
    {
        System.out.println("\n1:Enter values\n2:Search\n3:Size\n4:MaxDepth\n5.MinValue\n6.MaxDepth\n7.PrintTree\n8.LCA\n9.Exit\n");
      
        switch(scan.nextInt())
        {
          case 1: System.out.println("How many values?");
                  int count = scan.nextInt();
                  for (int i = 0 ; i < count ; i++)
                    bst.insert(node, scan.nextInt());
                  break;
          case 2: int luck = bst.findNode(node, scan.nextInt());
                  if (luck == 0)
                    System.out.println("Not found!\n");
                  else if (luck == 1)
                    System.out.println("Found!");
                  break;
          case 3: System.out.println("Size of tree : "+ bst.size(node));
                  break;
          case 4: System.out.println("Max Depth : "+ bst.maxDepth(node));
                  break;
          case 5: System.out.println("Min Value : "+ bst.minValue(node));
                  break;
          case 6: System.out.println("Max Value : "+ bst.maxValue(node));
                  break;
          case 7: bst.printTree(node);
                  break;
          case 8: System.out.println("LCA" + bst.LCA(node, 2, 5));
                  break;
          case 9: System.out.println("Exit");
                  flag = false;
                  break;
          case 10: System.out.println("PreOrder");
                   bst.preOrder(node);
                   break;
          case 11: System.out.println("PreOrderStack");
                   bst.preOrderStack(node);
                   break;
          case 12: System.out.println("InOrder");
                   bst.inOrder(node);
                   break;
          case 13: System.out.println("InOrderStack");
                   bst.inOrderStack(node);
                   break;
          case 14: System.out.println("PostOrderStack");
                   bst.postOrder(node);
                   break;
          case 15: System.out.println("Largest");
                   System.out.println(bst.largest(node));
                   break;
          case 16: System.out.println("Find in BT");
                   System.out.println(bst.findElement(node, 15));
                   break;
          case 17: System.out.println("Max Diameter");
                   System.out.println(bst.treeDiameter(node, 0));
                   break;
          case 18: System.out.println("Max Level");
                   System.out.println(bst.maxLevel(node));
                   break;
          case 19: System.out.println("Root to leaf");
                   System.out.println(bst.maxLevel(node));
                   break;
          case 20: System.out.println("Print all paths");
                   int[] path = new int[256];
                   bst.printAllPaths(node, path, 0);
                   break;
         default: System.out.println("Incorrect value"); 
        }
      }
    }       
    catch (InputMismatchException ime)
    {
      System.out.println("Garbage value, try again!\n"); 
    }
  }
}
