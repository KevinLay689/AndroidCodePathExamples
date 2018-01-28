package com.example.kevinlay.androidfundamentalspractice.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevinlay.androidfundamentalspractice.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        createObservable().subscribe(createObserver());
    }
    // This observable event emits the data "a", "b", "c" and then completes.
    private Observable<String> createObservable() {
        // Observables emit any number of items to be processed
        // The type of the item to be processed needs to be specified as a "generic type"
        // In this case, the item type is `String`
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        // "Emit" any data to the subscriber
                        sub.onNext("a");
                        sub.onNext("b");
                        sub.onNext("c");
                        // Trigger the completion of the event
                        sub.onCompleted();
                    }
                }
        );
        return myObservable;
    }

    private Observer<String> createObserver() {
        Observer<String> mySubscriber = new Observer<String>() {
            // Triggered for each emitted value
            @Override
            public void onNext(String s) { System.out.println("onNext: " + s); }

            // Triggered once the observable is complete
            @Override
            public void onCompleted() { System.out.println("done!"); }

            // Triggered if there is any errors during the event
            @Override
            public void onError(Throwable e) { }
        };
        return mySubscriber;
    }

    //This example above would simply print each argument ("a", "b", "c") and then exit since each
    // item is invoked with a call to onNext. Once all items have been invoked, the onCompleted method is called.
    private void createObservable2() {
        Observable.just("a", "b", "c").subscribe(new Observer<String>() {
            // Triggered for each emitted value
            // Invoked with "a", then "b", then "c"
            @Override
            public void onNext(String s) { System.out.println("onNext: " + s); }

            // Triggered once the observable is complete
            @Override
            public void onCompleted() { System.out.println("done!"); }

            // Triggered if there is any errors during the event
            @Override
            public void onError(Throwable e) { }
        });
    }
}
