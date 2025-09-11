package org.example.system.observer.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    public static void main(String[] args) {

        Chanel chanel = new Chanel("DSA");
        Subscriber s1 = new Subscriber(chanel, "s1");
        Subscriber s2 = new Subscriber(chanel, "s2");

        chanel.subscribe(s1);
        chanel.subscribe(s2);

        chanel.uploadVideo("chamcham");

        chanel.unSubscribe(s1);
        chanel.subscribe(s1);

        chanel.uploadVideo("hahaha");


    }
}

interface IChannel {
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscribers();
}

interface ISubscriber {
    void update();
}

class Subscriber implements ISubscriber {

    private final Chanel chanel;
    private final String name;
    public Subscriber(Chanel chanel, String name)  {
        this.chanel = chanel;
        this.name =name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update() {
        chanel.getVideo();
    }
}

class Chanel implements IChannel {

    private final List<Subscriber> subscribers = new ArrayList<>();
    private final String name;
    private String lastVideo;
    public Chanel(String name) {
        this.name = name;
    }
    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber: subscribers) {
            System.out.println("Notification sent from the channel: [" + name + "] to subscriber: [" + subscriber.getName() + "]");
            subscriber.update();
        }
    }

    public void uploadVideo(String video) {
        System.out.println("Channel: [" + name + "] uploaded new video: [" + video + "]");
        lastVideo = video;
        notifySubscribers();
    }

    public void getVideo(){
        System.out.println("Latest video from Channel: [" + name + "], video: [" + lastVideo + "]");
    }

}