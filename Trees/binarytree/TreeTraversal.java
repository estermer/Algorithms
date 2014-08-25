package binarytree;
import java.util.*;

public class TreeTraversal<T> {

  public void inOrder(BinaryTree<Integer> root) {
    if (root != null) {
      inOrder(root.left);
      System.out.println(root.value);
      inOrder(root.right);
    }
  }

  public void preOrder(BinaryTree<Integer> root) {
    if (root != null) {
      System.out.println(root.value);
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public void postOrder(BinaryTree<Integer> root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.println(root.value);
    }
  }

  public void levelOrder(BinaryTree<Integer> root) {
    Queue<BinaryTree> q = new LinkedList<BinaryTree>();   
    q.add(root);
    
    while(!q.isEmpty()) {
      BinaryTree<Integer> node = q.poll();
      System.out.println(node.value);
      if (node.left != null)
        q.add(node.left);
      if (node.right != null)
        q.add(node.right);
    }
    q = null;
  }

  public Integer findMax(BinaryTree<Integer> root) {
    Integer root_value = Integer.MIN_VALUE;
    Integer left, right, max = Integer.MIN_VALUE;

    if (root != null) {
      root_value = root.value;
      left = findMax(root.left);
      right = findMax(root.right);
      max = max(max(left, right), root_value);
    }
    return max;
  }
  
  private static Integer max(int x, int y) {
    return (x > y) ? x : y;
  }

  public boolean findNode(BinaryTree<Integer> root, Integer data) {
    boolean found = false;
    Integer root_value = Integer.valueOf(-1);
    boolean left, right = false;

    if (root != null) {
      root_value = root.value;
      left = findNode(root.left, data);
      right = findNode(root.right, data);
      found = (root_value == data || left || right);
    }
    return found;
  }

  public int treeSize(BinaryTree<Integer> root) {
    int count = 0;
    int left, right = 0;
    
    if (root != null) {
      left = treeSize(root.left);
      right = treeSize(root.right);
      count = left + right + 1;
    }
    return count;
  }

  public int treeHeight(BinaryTree<Integer> root) {
    int height = 0;
    int left, right = 0;

    if (root != null) {
      left = treeSize(root.left);
      right = treeSize(root.right);
      height = max(left, right) + 1;
    }
    return height;
  }

  public int fullNodes(BinaryTree<Integer> root) {
    int count = 0;
    int left = 0, right = 0;
    
    if (root != null) {
      /*
       *Alternative approach
       *if (root.left != null && root.right != null) {
       *  return 1 + fullNodes(root.left) + fullNodes(root.right);
       *}
       *return fullNodes(root.left) + fullNodes(root.right);
       */
      left = fullNodes(root.left);
      right = fullNodes(root.right);
      if (root.left != null && root.right != null)
        count = left + right + 1;
      else
        count = left + right;
    }
    return count;
  }

  public int halfNodes(BinaryTree<Integer> root) {
    int count = 0, left = 0, right = 0;

    if (root != null) {
      left = halfNodes(root.left);
      right = halfNodes(root.right);
      if ((root.left != null && root.right == null) || (root.left == null && root.right != null))
        count = left + right + 1;
      else
        count = left + right;
    }
    return count;
  }

  public int treeDiameter(BinaryTree<Integer> root) {
    int lHeight = 0, rHeight = 0;
    int lDiam = 0, rDiam = 0;
    int diameter = 0;

    if (root != null) {
      lHeight = treeHeight(root.left);
      rHeight = treeHeight(root.right);
      lDiam = treeDiameter(root.left);
      rDiam = treeDiameter(root.right);
      diameter = max(max(lDiam, rDiam), lHeight + rHeight + 1);
    }
    return diameter;
  }

  public boolean hasSum(BinaryTree<Integer> root, int sum) {
    int remaining = 0;
    boolean left = false, right = false;
    
    if (root != null) {
      if (sum != 0) {
        remaining = sum - root.value;
        left = hasSum(root.left, remaining);
        right = hasSum(root.right, remaining);
      }
    }
    return (sum == 0) || left || right;
  }

  public static void main(String[] args) {
    BinaryTree<Integer> root = new BinaryTree<Integer>();
    BinaryTree<Integer> n1 = new BinaryTree<Integer>();
    BinaryTree<Integer> n2 = new BinaryTree<Integer>();
    BinaryTree<Integer> n3 = new BinaryTree<Integer>();
    BinaryTree<Integer> n4 = new BinaryTree<Integer>();
    BinaryTree<Integer> n5 = new BinaryTree<Integer>();
    BinaryTree<Integer> n6 = new BinaryTree<Integer>();
    BinaryTree<Integer> n7 = new BinaryTree<Integer>();
    BinaryTree<Integer> n8 = new BinaryTree<Integer>();
    BinaryTree<Integer> n9 = new BinaryTree<Integer>();

    root.value = 1;
    n1.value = 2;
    n2.value = 3;
    n3.value = 4;
    n4.value = 5;
    n5.value = 6;
    n6.value = 7;
    n7.value = 13;
    n8.value = 11;
    n9.value = 10;
    
    root.left = n1;
    root.right = n2;
    n1.left = n3;
    n1.right = n4;
    n2.left = n5;
    n2.right = n6;
    n6.left = n7;
    n7.left = n8;
    n7.right = n9;

    TreeTraversal t = new TreeTraversal();
    System.out.println("Inorder");
    t.inOrder(root);
    System.out.println("Preorder");
    t.preOrder(root);
    System.out.println("Postorder");
    t.postOrder(root);
    System.out.println("LevelOrder");
    t.levelOrder(root);
    System.out.println("FindMax");
    System.out.println(t.findMax(root));
    System.out.println("Find Value");
    System.out.println(t.findNode(root, Integer.valueOf(3)));
    System.out.println("Size");
    System.out.println(t.treeSize(root));
    System.out.println("Height");
    System.out.println(t.treeHeight(root));
    System.out.println("Full Nodes");
    System.out.println(t.fullNodes(root));
    System.out.println("Half Nodes");
    System.out.println(t.halfNodes(root));
    System.out.println("Tree Diameter");
    System.out.println(t.treeDiameter(root));
    System.out.println("Has Sum");
    System.out.println(t.hasSum(root, 11));
  }
}
