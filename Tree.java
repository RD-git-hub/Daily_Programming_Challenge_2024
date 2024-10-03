class Day25TreeNode {
    int val;
    Day25TreeNode left, right;
    Day25TreeNode(int x) {
        val = x;
    }
}

public class Tree {
    public boolean isValidBST(Day25TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(Day25TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) return false;
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }

    public static void main(String[] args) {
        Day25TreeNode root = new Day25TreeNode(2);
        root.left = new Day25TreeNode(1);
        root.right = new Day25TreeNode(3);
        Tree tree = new Tree();
        System.out.println(tree.isValidBST(root));
    }
}
