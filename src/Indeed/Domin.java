package Indeed;
import java.util.*;

public class Domin {
    /*
    * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level,
    * we have "leetcode.com", and at the lowest level, "discuss.leetcode.com".
    * When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.


    * */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(String cp: cpdomains){
            int count = Integer.valueOf(cp.split(" ")[0]);
            String domin = cp.split(" ")[1];

            for(int i = 0; i<domin.length();i++){
                if(domin.charAt(i) == '.'){
                    // get all subdomin and cal his count
                    // google.mail.com -> subdomin mail.com, com
                    String subDomin = domin.substring(i+1,domin.length());
                    map.put(subDomin,map.getOrDefault(subDomin,0)+count);
                }
            }

            map.put(domin,map.getOrDefault(domin,0)+count);
        }
        List<String> result= new ArrayList<>();
        for(String key:map.keySet()){
            result.add(String.valueOf(map.get(key))+" "+key);
        }
        return result;
    }



    // input
    //[
    //  ["3234.html", "xys.html", "7hsaa.html"], // user1
    //  ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2
    //]

    //输出两个user的最长连续且相同的访问记录。
    //["xys.html", "7hsaa.html"]
    private static List<String> longestCommonContinuous(String[]history1, String[] history2){
       // the longest continue common subarray end with hitory1[i-1], and hostory [j-1]
        int[][] longest = new int[history1.length+1][history2.length+1];
        int max = 0;
        int end = 0;

        for(int i = 0; i<history1.length;i++){
            for(int j =0; j<history2.length;j++){
                if(history1[i].equals(history2[j])){
                    longest[i+1][j+1] = longest[i][j] +1;
                }else{
                    longest[i+1][j+1] = 0;
                }
                if(max <longest[i+1][j+1]){
                    max = longest[i+1][j+1];
                    end = i;
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(int i =end; i>=end-max+1 && i>=0; i--){
            result.add(0,history1[i]);
        }
        return result;
    }

    /*
    * Pt.3 (Map)The people who buy ads on our network don't have enough data about how ads are working for their business.
    * They've asked us to find out which ads produce the most purchases on their website.
Our client provided us with a list of user IDs of customers who bought something on a landing page after clicking one of their ads:
    *
    * */

    /*
    *  Write a function to parse this data, determine how many times each ad was clicked,
then return the ad text, that ad's number of clicks, and how many of those ad clicks
were from users who made a purchase.
    *
    * */
   public static List<String> adsConversionRate(String[]completedPurchaseUserIds,String[]adClicks, String[]allUserIps) {
        // ad  and user id who clicked the ad
        Map<String, List<Long>> adToUserID = new HashMap<>();
        // user and ip address
        Map<String, Long> IPToUserid = new HashMap<>();
        Set<Long> completedPurchaseSet = new HashSet<>();

        Arrays.stream(completedPurchaseUserIds).forEach(a->{
            completedPurchaseSet.add(Long.valueOf(a));
        });

        Arrays.stream(allUserIps).forEach(a->{
            String[] info = a.split(",");
            IPToUserid.put(info[1],Long.valueOf(info[0]));

        } );

        Arrays.stream(adClicks).forEach(a->{
            String[] info = a.split(",");
            Long id = IPToUserid.get(info[0]);
            adToUserID.computeIfAbsent(info[2],b->new ArrayList<>()).add(id);
        });

        List<String> result = new ArrayList<>();

        for(String key: adToUserID.keySet() ){
            // how many user clicked this ad
            int total = adToUserID.get(key).size();
            // how many user acturaly bought something
            int purched = 0;
            for(Long id : adToUserID.get(key)){
                if(completedPurchaseSet.contains(id)){
                    purched++;
                }
            }
            result.add(String.valueOf(purched)+" "+"of"+" "+String.valueOf(total)+" "+key);
        }
        return result;
    }

    public static void main(String[] args){

     String[] history1 = new String[]{"3234.html", "xys.html", "7hsaa.html"};
     String[] histroy2 = new String[]{"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};

     List<String> result = longestCommonContinuous(history1, histroy2);
     result.stream().forEach( a-> System.out.println(a));

     String[] completed_purchase_user_ids = {"3123122444","234111110", "8321125440", "99911063"};
     String[]  ad_clicks = {
             "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
             "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
             "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
             "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
             "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
             "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens",
     };

     String[] all_user_ips = {

   "2339985511,122.121.0.155",
  "234111110,122.121.0.1",
  "3123122444,92.130.6.145",
  "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
  "8321125440,82.1.106.8",
  "99911063,92.130.6.144"};

     List<String> result2 = adsConversionRate(completed_purchase_user_ids,ad_clicks,all_user_ips);
     result2.stream().forEach( a-> System.out.println(a));



    }

}
