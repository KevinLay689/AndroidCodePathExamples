package com.example.kevinlay.androidfundamentalspractice.rxjava;

import rx.subjects.PublishSubject;

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
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);
        subject.subscribe();
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);
    }
}
