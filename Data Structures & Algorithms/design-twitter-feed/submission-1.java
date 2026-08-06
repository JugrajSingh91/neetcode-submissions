class Twitter {

    // For each user, we keep their tweets in a linkedList adding to the beginning of the list every new tweet
    // To store them we use a map of userId -> Tweet(head of the LinkedList)


    // We also maintain a map of user -> followees

    // Global timestamp
    private static int timestamp = 0;
    private static class Tweet {
        int tweetId;
        int timestamp;
        Tweet next;
        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    private Map<Integer, Set<Integer>> followerMap;
    private Map<Integer, Tweet> userTweetsMap;
    public Twitter() {
        followerMap = new HashMap<>();
        userTweetsMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Tweet latestTweet = new Tweet(tweetId, timestamp);
        latestTweet.next = userTweetsMap.get(userId);
        userTweetsMap.put(userId, latestTweet);
    }
    
    // we collect tweets from the folowees of user and use a heap sorted by timestamp to get the top ten
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> topTenTweets = new PriorityQueue<>((a,b) -> {return Integer.compare(b.timestamp, a.timestamp);});
        if (userTweetsMap.containsKey(userId)) {
            topTenTweets.offer(userTweetsMap.get(userId));
        }
        
        Set<Integer> followees = followerMap.getOrDefault(userId, new HashSet<>());
        for (int followee: followees) {
            if (userTweetsMap.containsKey(followee)) {
                topTenTweets.offer(userTweetsMap.get(followee));
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!topTenTweets.isEmpty()) {
                Tweet latest = topTenTweets.poll();
                result.add(latest.tweetId);

                if (latest.next != null) {
                    topTenTweets.offer(latest.next);
                }
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        // Prevent users from following themselves
        if (followerId == followeeId) return; 
        Set<Integer> followees = followerMap.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        followerMap.put(followerId, followees);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followerMap.getOrDefault(followerId, new HashSet<>());
        followees.remove(followeeId);
        followerMap.put(followerId, followees);
    }
}
