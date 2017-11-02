package com.cqm;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * Created by qmcheng on 2017/10/27 0027.
 */
public class BST {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(10);
  }

  private static boolean isCompleteTree(TreeNode root) {
    if (root == null)
      return true;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    TreeNode node;
    boolean hasNoChild = false;
    while ((node = queue.poll()) != null) {
      if (hasNoChild && (node.left != null || node.right != null)) {
        return false;
      }
      if (node.left != null && node.right != null) {
        queue.add(node.left);
        queue.add(node.right);
      } else if (node.left != null) {
        queue.add(node.left);
        hasNoChild = true;
      } else if (node.right != null) {
        return false;
      } else {
        hasNoChild = true;
      }
    }
    return true;
  }

  private static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.push(root);
    TreeNode node = null;
    int lastDepth = 0;
    while ((node = queue.poll()) != null) {
      int depth = getDepth(node);
      if (depth != lastDepth) {
        lastDepth = depth;
        System.out.println();
      }
      System.out.print(node.value + " ");
      if (node.parent != null && node.parent.right == node)
        System.out.print(" ");
      if (node.left != null)
        queue.add(node.left);
      if (node.right != null)
        queue.add(node.right);
    }
    System.out.println();
    System.out.println();
  }

  private static TreeNode insert(TreeNode parent, TreeNode root, int value) {
    TreeNode node = new TreeNode();
    node.value = value;
    if (root == null) {
      return node;
    }
    if (root.value == value) {
      return root;
    }
    if (value < root.value) {
      root.left = insert(root, root.left, value);
      root.left.parent = root;
    } else {
      root.right = insert(root, root.right, value);
      root.right.parent = root;
    }
    return adjustTree(parent, root);
  }

  private static TreeNode adjustTree(TreeNode parent, TreeNode node) {
    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);
    if (leftHeight - rightHeight > 1) {
      TreeNode left = node.left;
      if (getHeight(left.left) >= getHeight(left.right)) {// LL
        node.left = left.right;
        left.right = node;
        node.parent = left;
        if (node.left != null)
          node.left.parent = node;
        return replaceNode(parent, node, left);
      } else {// LR
        TreeNode right = left.right;
        node.left = null;
        left.right = null;
        right.left = left;
        right.right = node;
        node.parent = right;
        left.parent = right;
        return replaceNode(parent, node, right);
      }
    } else if (rightHeight - leftHeight > 1) {
      TreeNode right = node.right;
      if (getHeight(right.left) <= getHeight(right.right)) {
        node.right = right.left;
        right.left = node;
        node.parent = right;
        if (node.right != null)
          node.right.parent = node;
        return replaceNode(parent, node, right);
      } else {
        TreeNode left = right.left;
        node.right = null;
        right.left = null;
        left.left = node;
        left.right = right;
        node.parent = left;
        right.parent = left;
        return replaceNode(parent, node, left);
      }
    }
    return node;
  }

  private static TreeNode replaceNode(TreeNode parent, TreeNode target, TreeNode node) {
    if (parent != null) {
      if (parent.left == target)
        parent.left = node;
      else if (parent.right == target)
        parent.right = node;
    }
    if (node != null)
      node.parent = parent;
    return node;
  }

  private static int getHeight(TreeNode root) {
    return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  private static int getDepth(TreeNode node) {
    int level = -1;
    while (node != null) {
      level++;
      node = node.parent;
    }
    return level;
  }

  private static class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }
}
