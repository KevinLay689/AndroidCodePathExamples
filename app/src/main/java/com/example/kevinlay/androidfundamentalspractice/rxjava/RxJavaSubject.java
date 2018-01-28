package com.example.kevinlay.androidfundamentalspractice.rxjava;

import android.util.Log;

import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * Subject
 * -Extension of the Observable that also implements the Observer interface.
 * -They can have events pushed to them (like observers), which they then push further to their own
 * subscribers (like observables).
 *
 */

public class RxJavaSubject {

    // PublishSubject
    // PublishSubject is the most straight-forward kind of subject. When a value is pushed into a PublishSubject,
    // the subject pushes it to every subscriber that is subscribed to it at that moment.
    public void createPublishSubject() {
        // As we can see in the example, 1 isn't printed because we weren't subscribed when it was pushed.
        // After we subscribed, we began receiving the values that were pushed to the subject.
        // This is the first time we see subscribe being used, so it is worth paying attention to how it was used.
        // In this case, we used the overload which expects one Function for the case of onNext. That function
        // takes an argument of type Integer and returns nothing. Functions without a return type are also
        // called actions. We can provide that function in different ways:
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);
        subject.subscribe(this::handleInt);
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);
    }

    void handleInt(int v) {
        Log.i("", "handleInt: "+ v);
    }

    // ReplaySubject
    // ReplaySubject has the special feature of caching all the values pushed to it. When a new subscription
    // is made, the event sequence is replayed from the start for the new subscriber. After catching up,
    // every subscriber receives new events as they come.
    public void createReplaySubject() {
        // All the values are received by the subscribers, even though one was late. Also notice that
        // the late subscriber had everything replayed to it before proceeding to the next value.
        ReplaySubject<Integer> s = ReplaySubject.create();
        s.subscribe(this::handleInt);
        s.onNext(0);
        s.onNext(1);
        s.subscribe(this::handleInt);
        s.onNext(2);
    }
}
