public class SimilarStringGroups {
    class Union{
        int[] parents;
        public Union(int n){
            parents = new int[n];
            for(int i = 0; i<n;i++){
                parents[i] = i;
            }
        }
        public int parent(int id){
            while(id != parents[id]){
                id = parents[id];
            }

            return id;
        }

        public void union(int id1, int id2){
            int p1 = parent(id1);
            int p2 = parent(id2);

            parents[p1] = p2;
        }


    }
    public int numSimilarGroups(String[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        Union un = new Union(n);
        int result = n;
        for(int i  = 0; i<A.length;i++){
            for(int j  = i+1; j<A.length;j++){
                if(similar(A[i],A[j]) && un.parent(i) != un.parent(j)){
                    un.union(i,j);
                    result--;
                }
            }
        }

        return result;
    }

    private boolean similar(String a,String b){
        //
        int different =0;
        for(int i = 0; i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                different++;
            }
        }
        return different == 2;

    }
}
