package com.example.kevinlay.androidfundamentalspractice.rxjava;

/**
 * Key Types
 *
 * -Best to not manually implement, instead use Rx build in classes
 *
 * Observable
 * -Must understand the Subscribe method.
 * -This is the method that you use to receive the values emitted by the observable. As the values come
 * to be pushed (through policies that we will discuss throughout this book), they are pushed to the
 * subscriber, which is then responsible for the behaviour intended by the consumer.
 * -Pushes 3 kinds of events: Values, Completion, Error
 *
 * Observer
 * -Interface that is composed of 3 methods onCompleted(), onError(), onNext()
 * -Those three methods are the behaviour that is executed every time the observable pushes a value.
 * The observer will have its onNext called zero or more times, optionally followed by an onCompleted or
 * an onError. No calls happen after a call to onError or onCompleted.
 *
 */

public class RxJavaKeyTypes {
}
