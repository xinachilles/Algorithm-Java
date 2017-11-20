import org.omg.PortableInterceptor.INACTIVE;

public class LCA2 {

        class ResultType {
        public int distance_a = Integer.MAX_VALUE;
        public int distance_b = Integer.MAX_VALUE;


        public ResultType(int distance_a, int distance_b) {
            this.distance_a = distance_a;
            this.distance_b = distance_b;

        }
    }

        public int lowestCommonAncestor3(TreeNode root, TreeNode a, TreeNode b) {
            ResultType res = helper(root, a, b);
            if (res.distance_a == Integer.MAX_VALUE || res.distance_b == Integer.MAX_VALUE ) {//return node only when two nodes found
                return Integer.MAX_VALUE;
            }
            return res.distance_b+res.distance_a-1;
        }

        private ResultType helper(TreeNode root, TreeNode a, TreeNode b) {
            if (root == null) {
                return new ResultType(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }

            ResultType left = helper(root.left, a, b);
            ResultType right = helper(root.right, a, b);
            int  distance_a = left.distance_a == Integer.MAX_VALUE? right.distance_a: left.distance_a;
            int  distance_b = left.distance_b == Integer.MAX_VALUE? right.distance_b : right.distance_b;

            if(root == a){
                return  new ResultType(0,distance_b==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_b+1);
            }

            if(root == b){
                return  new ResultType(distance_a==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_a+1,0);
            }else {
                return  new ResultType(distance_a==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_a+1,distance_b==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_b+1);
            }




        }
    }

