package mod07_02;

/**
 * The App class is the main entry point of the application.
 * It demonstrates the use of the BSTInteger class by creating
 * binary search trees, adding elements, and displaying the trees.
 * 
 * @author angel
 */
public class App {

    /**
     * The main method to run the application.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        
        // Create a binary search tree of integers
        BSTInteger tree = new BSTInteger();
        
        // Populate the tree with an example set of integers
        tree.createExample();
        
        // Display the tree in the console
        tree.display();
        
        // Alternative display method for the tree
        tree.display2();
        
        // Create a new binary search tree for adding custom values
        BSTInteger newTree = new BSTInteger();
        
        // Add integers to the tree
        newTree.add(0);    // Adding root
        newTree.add(100);  // Adding right child of root
        newTree.add(15);   // Adding left child of the root's right child
        newTree.add(30);   // Adding right child of 15
        
        // Display the new tree in the console
        newTree.display();
        
        // Attempt to add a duplicate value to the tree
        // Expecting an exception because BST does not allow duplicates
        try {
            newTree.add(100);
        } catch (Exception exception) {
            // Print error message to the console
            System.err.println(exception.getMessage());
        }
    }
}
