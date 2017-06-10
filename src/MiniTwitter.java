import java.util.*;

/**
 * Created by xhu on 4/10/17.
 */

public class MiniTwitter {
    public class Node implements Comparable<Node>{
        int timeStamp;
        Tweet tweet;
        Node next;

        public Node(int timeStamp, Tweet tweet){
            this.timeStamp = timeStamp;
            this.tweet = tweet;
        }

        @Override
        public  int compareTo(Node a){
            return this.timeStamp - a.timeStamp;
        }
    }

    public class User{
        int id;
        Set<User> follower;
        Node head;

        public User(int id){
            this.id = id;
            follower = new HashSet<>();
        }

        public void postTweet(String tweet_text, int timeStamp){
            Tweet t = Tweet.create(this.id,tweet_text);
            Node n = new Node(timeStamp, t);

            n.next = head;
            head = n;
        }

        public void follow(User user){
            if(!follower.contains(user)){
                follower.add(user);
            }
        }

        public void unfollow(User user){
            if(follower.contains(user)){
                follower.remove(user);
            }
        }
    }



    Map<Integer,User> users;
    private int timeStamp;
    public MiniTwitter() {
        // initialize your data structure here.
        users = new HashMap<>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        if(!users.containsKey(user_id)){
            users.put(user_id, new User(user_id));
        }

        users.get(user_id).postTweet(tweet_text, timeStamp++);
        return users.get(user_id).head.tweet;

    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        if(!users.containsKey(user_id)){
            return null;
        }
        User u = users.get(user_id);
        PriorityQueue<Node> newsFeed = new PriorityQueue<>();

        newsFeed.offer(u.head);
        for(User f : u.follower){
            if(f.head != null){
                newsFeed.offer(f.head);
            }
        }

        List<Tweet> result = new ArrayList<Tweet>();

        while(result.size() <10 && !newsFeed.isEmpty()){
            Node current = newsFeed.poll();
            result.add(current.tweet);

            if(current.next != null){
                newsFeed.offer(current.next);
            }
        }

        return result;

    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here

        if(!users.containsKey(user_id)){
            return null;
        }
        User u = users.get(user_id);
        PriorityQueue<Node> timeLine = new PriorityQueue<>();


        for(User f : u.follower){
            if(f.head != null){
                timeLine.offer(f.head);
            }
        }

        List<Tweet> result = new ArrayList<Tweet>();

        while(result.size() <10 && !timeLine.isEmpty()){
            Node current = timeLine.poll();
            result.add(current.tweet);

            if(current.next != null){
                timeLine.offer(current.next);
            }
        }

        return result;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if(!users.containsKey(from_user_id)){
            users.put(from_user_id, new User(from_user_id));
        }

        if(!users.containsKey(to_user_id)){
            users.put(to_user_id, new User(to_user_id));
        }

        users.get(from_user_id).follow(users.get(to_user_id));



    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here

        if(!users.containsKey(from_user_id)){
            users.put(from_user_id, new User(from_user_id));
        }

        if(!users.containsKey(to_user_id)){
            users.put(to_user_id, new User(to_user_id));
        }

        users.get(from_user_id).unfollow(users.get(to_user_id));

    }
}
