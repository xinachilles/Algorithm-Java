import java.util.HashMap;

/**
 * Created by xhu on 4/29/17.
 */
public class Singleton
{
    private static Singleton instance;
    HashMap<Integer,String> user;
    private Singleton()
    {
        user = new HashMap<>();
    }

    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }


}
