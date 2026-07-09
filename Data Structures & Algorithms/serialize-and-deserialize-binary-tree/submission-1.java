public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("N,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < tokens.length) {
            TreeNode parent = queue.poll();
            if (!tokens[i].equals("N")) {
                parent.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(parent.left);
            }
            i++;
            if (i < tokens.length && !tokens[i].equals("N")) {
                parent.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }
}