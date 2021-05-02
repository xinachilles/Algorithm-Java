package MOA;

public class MaxNetworkRank {
    public int maxNetworkRank(int[] A, int[] B, int N) {
        int[] edgeCount = new int[N];
        int M = A.length;

        for (int i = 0; i < M; i++) {
            edgeCount[A[i] - 1]++;
            edgeCount[B[i] - 1]++;
        }

        int maxRank = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            int rank = edgeCount[A[i] - 1] + edgeCount[B[i] - 1] - 1;
            if (rank > maxRank)
                maxRank = rank;
        }

        return maxRank;
    }
}
