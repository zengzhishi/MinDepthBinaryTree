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
//        TreeNode presentNode = root;
        root.val = 1;
        treeNodes.add(root);
        while (root.left != null || root.right != null){
            if (root.left != null){
                root.left.val = root.val + 1;
                treeNodes.add(root.left);
            }
            if (root.right != null){
                root.right.val = root.val + 1;
                treeNodes.add(root.right);
            }
            treeNodes = treeNodes.subList(1, treeNodes.size());
            root = treeNodes.get(0);
        }

        return root.val;
    }
}
