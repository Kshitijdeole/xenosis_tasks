package Part2;


class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a node
    void insert(int key) {
        root = insertRec(root, key);
    }

    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Delete a node
    void delete(int key) {
        root = deleteRec(root, key);
    }

    TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val)
            root.left = deleteRec(root.left, key);
        else if (key > root.val)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }

    int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    // Search for a node
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(TreeNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;
        return key < root.val ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // In-order traversal
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal
    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal
    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.val + " ");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create the following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inorder();

        System.out.println("Pre-order traversal:");
        tree.preorder();

        System.out.println("Post-order traversal:");
        tree.postorder();

        System.out.println("Search for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));

        System.out.println("Delete 20");
        tree.delete(20);
        System.out.println("In-order traversal:");
        tree.inorder();

        System.out.println("Delete 30");
        tree.delete(30);
        System.out.println("In-order traversal:");
        tree.inorder();

        System.out.println("Delete 50");
        tree.delete(50);
        System.out.println("In-order traversal:");
        tree.inorder();
    }
}
