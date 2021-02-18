package ir.blog.mahdidavoodi;

/*
 * You can find MyLinkedListStack class in:
 * Address: https://github.com/MahdiDavoodi/Java/blob/master/Exercises/2021/January/Data%20Structure/Stack/MyLinkedListStack.java
 * Another Version of Queue that works with stack in background.
 * */
public class QueueWorksWithStackV2<T> implements MyQueue<T> {
    private MyLinkedListStack<T> myLinkedListStack;

    public QueueWorksWithStackV2() {
        myLinkedListStack = new MyLinkedListStack<>();
    }


    @Override
    public int size() {
        return myLinkedListStack.size();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedListStack.isEmpty();
    }

    @Override
    public T first() {
        return myLinkedListStack.bottom();
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {

            if (myLinkedListStack.size() == 1) {
                return myLinkedListStack.pop();
            } else {
                T temp = myLinkedListStack.pop();
                T reply = dequeue();
                myLinkedListStack.push(temp);
                return reply;
            }

        } else return null;
    }

    @Override
    public void enqueue(T element) {
        myLinkedListStack.push(element);
    }

}
