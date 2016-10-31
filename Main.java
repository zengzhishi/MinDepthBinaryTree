import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Integer[] as = {12,3,4};
        List<Integer> a = Arrays.asList(as);
        a = a.subList(1, a.size());
        System.out.println(a);
    }
}



//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int run(TreeNode root) {

        if (root == null) return 0;
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        TreeNode presentNode = root;
        root.val = 1;
        treeNodes.add(root);
        while (presentNode.left != null || presentNode.right != null){
            if (presentNode.left != null){
                presentNode.left.val = presentNode.val + 1;
                treeNodes.add(presentNode.left);
            }
            if (presentNode.right != null){
                presentNode.right.val = presentNode.val + 1;
                treeNodes.add(presentNode.right);
            }
            treeNodes = treeNodes.subList(1, treeNodes.size());
            presentNode = treeNodes.get(0);
        }

        return presentNode.val;
    }
}
