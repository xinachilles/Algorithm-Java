/**
 * Created by xhu on 12/28/16.
 */
public class UnionFind
{
    int[] parents;

    public UnionFind(int n)
    {
        parents = new int[n];
        for (int i = 0; i < n; i++)
        {
            parents[i] = i;
        }
    }

    private int find(int id)
    {
        while (id != parents[id])
        {
            id = parents[id];
        }

        return id;
    }


    public int compress_find(int id)
    {
        int x = id;

        while (id != parents[id])
        {
            id = parents[id];
        }

        int temp;

        while (x != parents[x])
        {
            temp = parents[x];
            parents[x] = id;
            x = temp;

        }

        return id;
    }

    public void union(int id1, int id2)
    {
        int parents1 = find(id1);
        int parents2 = find(id2);

        if (parents1 != parents2)
        {
            parents[id2] = parents1;
        }
    }

    public int id(int x, int y, int col)
    {
        return x * col + y;
    }
}