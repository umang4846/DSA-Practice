package system_design.low_level_design.design_patterns.observer;

public class Main {
    public static void main(String[] args) {
        YoutubeChannel1 youtubeChannel1 = new YoutubeChannel1();
        YoutubeChannel2 youtubeChannel2 = new YoutubeChannel2();

        User1 user1 = new User1();
        User2 user2 = new User2();
        User3 user3 = new User3();

        youtubeChannel1.registerObserver(user1);
        youtubeChannel1.registerObserver(user2);

        youtubeChannel2.registerObserver(user1);
        youtubeChannel2.registerObserver(user2);
        youtubeChannel2.registerObserver(user3);

        youtubeChannel1.newVideoAdded("Video 1 is added in Channel 1");
        youtubeChannel2.newVideoAdded("Video 5 is added in Channel 2");
    }
}
