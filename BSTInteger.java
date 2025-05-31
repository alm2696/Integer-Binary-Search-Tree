package mod07_02;

import java.util.ArrayDeque;

/**
 * The BSTInteger class represents a Binary Search Tree that stores integers.
 * It provides methods for adding nodes, displaying the tree in different
 * ways, and creating example trees for demonstration purposes.
 * 
 * @author angel
 */
public class BSTInteger {
    
    /**
     * The Node class represents a node in the binary search tree. Each node 
     * stores an integer value and references to its left and right children.
     */
    public class Node {
        
        private int value;  // The integer value stored in the node
        private Node left;  // Reference to the left child node
        private Node right; // Reference to the right child node
        
        /**
         * Constructor to create a new Node.
         * 
         * @param value The integer value for the node.
         * @param left  Reference to the left child node.
         * @param right Reference to the right child node.
         */
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
    }
    
    private Node root = null; // The root node of the binary search tree

    /**
     * Creates an example binary search tree with predefined values.
     * This method manually builds a tree for demonstration.
     */
    public void createExample() {
        
        // Manually create nodes for the example tree
        Node node25 = new Node(25, null, null);
        Node node35 = new Node(35, null, null);
        Node node45 = new Node(45, null, null);
        Node node60 = new Node(60, null, null);
        
        // Build the subtrees
        Node node30 = new Node(30, node25, node35);
        Node node50 = new Node(50, node45, node60);
        
        // Set the root of the tree
        this.root = new Node(40, node30, node50);
        
    }

    /**
     * Displays the values of the nodes in the tree in in-order 
     * traversal. This method starts the traversal from the root.
     */
    public void display() {
        this.display(this.root);
        System.out.println(); // Print a new line after traversal
    }

    /**
     * Recursively displays the values of the nodes in in-order traversal.
     * 
     * @param node The current node in the traversal.
     */
    public void display(Node node) {
        // Recursively display left subtree
        if (node.left != null) {
            display(node.left);
        }
        
        // Display current node's value
        System.out.print(node.value + " ");
        
        // Recursively display right subtree
        if (node.right != null) {
            display(node.right);
        }
    }

    /**
     * Displays the tree using an iterative in-order traversal.
     * This method uses a stack to traverse the tree without recursion.
     */
    public void display2() {
        
        ArrayDeque<Node> stack = new ArrayDeque<>(); // Stack for iterative traversal
        Node currNode = this.root; // Start traversal from the root
        
        while (true) {
            // Traverse to the leftmost node
            while (currNode != null) {
                stack.addLast(currNode); // Push current node onto the stack
                currNode = currNode.left;
            }
            
            // If the stack is empty, break the loop
            if (stack.isEmpty()) {
                break;
            }
            
            // Pop the last node from the stack and process it
            currNode = stack.pollLast();
            System.out.print(currNode.value + " ");
            
            // Move to the right subtree
            currNode = currNode.right;
        }
        
        System.out.println(); // Print a new line after traversal
    }

    /**
     * Adds a new integer value to the binary search tree.
     * 
     * @param value             The integer value to be added to the tree.
     * @throws RuntimeException If the value is a duplicate.
     */
    public void add(int value) {
        
        Node newNode = new Node(value, null, null); // Create a new node with the given value
        
        // If the tree is empty, set the new node as the root
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        
        // Recursively add the new node to the tree
        add(newNode, this.root);
    }

    /**
     * Recursively adds a new node to the binary search tree.
     * 
     * @param newNode           The new node to be added.
     * @param startNode         The current node in the tree where we are trying to add the new node.
     * @throws RuntimeException If the value of the new node is a duplicate of an existing node.
     */
    private void add(Node newNode, Node startNode) {
        
        // If the new node's value is less than the current node's value, go left
        if (newNode.value < startNode.value) {
            if (startNode.left != null) {
                add(newNode, startNode.left); // Recursively add to the left subtree
            } else {
                startNode.left = newNode; // Place the new node as the left child
            }
            return;
        }
        
        // If the new node's value is greater than the current node's value, go right
        if (newNode.value > startNode.value) {
            if (startNode.right != null) {
                add(newNode, startNode.right); // Recursively add to the right subtree
            } else {
                startNode.right = newNode; // Place the new node as the right child
            }
            return;
        }
        
        // If the value is equal, throw an exception
        throw new RuntimeException("The value is a duplicate");
    }

}
