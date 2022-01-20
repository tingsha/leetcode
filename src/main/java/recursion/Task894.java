package recursion;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task894 {
    public static void main(String[] args) {
        System.out.println(new Task894().allPossibleFBT(7));
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0)
            return new ArrayList<>();
        return null;
        //return makeNodes(new TreeNode(), n-1, new ArrayList<>());
    }

    public TreeNode makeNodes(TreeNode root, int n, List<TreeNode> res){
        root.left = new TreeNode();
        root.right = new TreeNode();
        return null;
    }

    public TreeNode getClone(TreeNode root){
        if (root == null)
            return null;
        return new TreeNode(root.val,
                getClone(root.left),
                getClone(root.right));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        static List<Integer> numbers = new ArrayList<>();

        TreeNode() {
            int number = -1;
            while (numbers.contains(number = new Random().nextInt(100))){
                number = new Random().nextInt(100);
            }
            numbers.add(number);
            val = number;
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private StringBuilder builder = new StringBuilder();

        @Override
        public String toString() {
            builder = new StringBuilder();
            allNodesToString(this);
            return builder.toString();
        }

        private void allNodesToString(TreeNode root){
            if (root == null)
                return;
            if (root.left != null && root.right != null)
                builder.append(String.format("{root=%d} {l=%d} {r=%d}\n", root.val, root.left.val, root.right.val));

            allNodesToString(root.left);
            allNodesToString(root.right);
        }
    }

}
