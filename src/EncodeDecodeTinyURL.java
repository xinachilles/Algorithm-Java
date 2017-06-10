import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 4/30/17.
 */
public class EncodeDecodeTinyURL {

    int id;
    Map<Integer,String> idToString = new HashMap<>();
    Map<String,Integer> stringToId = new HashMap<>();
    private final String URL  = "http://tinyurl.com/";



    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(stringToId.containsKey(longUrl)){
            return URL+ IdToShortKey(stringToId.get(longUrl));
        }

        id++;
        stringToId.put(longUrl,id);
        return "http://tinyurl.com/"+ IdToShortKey(stringToId.get(longUrl));
    }

    private String IdToShortKey(int id){
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String short_url = "";

        while(id >0){
            short_url = chars.charAt(id%62)+short_url;
            id = id/62;
        }

        while(short_url.length()<6){
            short_url = "0"+short_url;
        }

        return short_url;
    }

    private int toBase62(char c){
        if(c >='0' && c<='9'){
            return c-'0';
        }

        if(c>='a' && c<='z'){
            return 10+(c-'a');
        }

        if(c>='A' && c<='Z'){
            return 36+(c-'A');
        }

        return 0;
    }
    private int ShortKeyToId(String shortKey){
        int id = 0;
        for(int i = 0; i<shortKey.length();i++){
            id = id *62 + toBase62(shortKey.charAt(i));
        }

        return id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int id = ShortKeyToId( shortUrl.substring(URL.length()));

        if(idToString.containsKey(id)){
            return idToString.get(id);
        }

        return "";
    }

}
