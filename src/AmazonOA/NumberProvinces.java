package AmazonOA;

public class NumberProvinces {
    class Union{

        int[] parent;
        public int numerOfParent;
        public  Union(int n){
            parent = new int[n];
            numerOfParent = n;
            for(int i = 0; i<parent.length;i++){
                parent[i] = i;
            }
        }
        private int find(int a){
            int temp = a;
            while(a!=parent[a]){
                a = parent[a];
            }

            while(a!=parent[temp]){
                int tempOfP = parent[temp];
                parent[temp] = a;
                temp = tempOfP;
            }
            return a;
        }
        public void union(int a, int b){
            int parentOfa = find(a);
            int parentOfb = find(b);
            if(parentOfa != parentOfb){
                parent[parentOfa] = parentOfb;
                numerOfParent--;
            }
        }

    }

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0){
            return  0;
        }

        Union un = new Union(M.length);
        for(int i = 0; i<M.length;i++){
            for(int j = 0; j<M[i].length;j++){
                if(M[i][j] == 1){
                   un.union(i,j);
                }
            }
        }

        return un.numerOfParent;
    }
}
