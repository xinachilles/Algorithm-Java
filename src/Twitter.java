import java.util.*;

/**
 * Created by xhu on 3/18/17.
 */
public class Twitter {
    private static int timeStamp = 0;


    public class User {
        private int id;
        private Tweet head;
        private Set<User> followList;

        public void postTweet(int id) {
            Tweet newTweet = new Tweet(Twitter.timeStamp++, id);
            newTweet.next = head;
            head = newTweet;

        }

        public User(int id) {
            this.id = id;
            followList = new HashSet<User>();
        }

        public void follow(User followee) {
            if (!followList.contains(followee)) {
                followList.add(followee);
            }
        }

        public void unFollow(User followee) {
            if (followList.contains(followee)) {
                followList.remove(followee);
            }
        }
    }


    public class Tweet implements Comparable<Tweet> {
        int timeStamp;
        int id;
        Tweet next;


        public Tweet(int timeStamp, int id) {
            this.timeStamp = timeStamp;
            this.id = id;

        }

        public int compareTo(Tweet a) {
            return a.timeStamp - this.timeStamp;
        }
    }


    Map<Integer, User> userList;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userList = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userList.containsKey(userId)) {
            userList.put(userId, new User(userId));
        }

        userList.get(userId).postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new LinkedList<>();
        if (!userList.containsKey(userId)) {
            return news;
        }

        User user = userList.get(userId);
        PriorityQueue<Tweet> newsQeue = new PriorityQueue<>();
        newsQeue.offer(user.head);

        for (User f : user.followList) {
            newsQeue.offer(f.head);
        }

        int index = 10;

        while (index > 0 || !newsQeue.isEmpty()) {
            Tweet current = newsQeue.poll();
            news.add(current.id);

            if (current.next != null) {
                newsQeue.offer(current.next);
            }

            index--;

        }

        return news;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (!userList.containsKey(followeeId) || !userList.containsKey(followerId)) {
            return;
        }

        userList.get(followerId).follow(userList.get(followeeId));
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (!userList.containsKey(followeeId) || !userList.containsKey(followerId)) {
            return;
        }

        userList.get(followerId).unFollow(userList.get(followeeId));

    }
}

