package ir.blog.mahdidavoodi;

/*
 * You can find MyLinkedListStack class in:
 * Address: https://github.com/MahdiDavoodi/Java/blob/master/Exercises/2021/January/Data%20Structure/Stack/MyLinkedListStack.java
 * */
public class QueueWoksWithStack<T> implements MyQueue<T> {
    private MyLinkedListStack<T> myLinkedListStack;
    private T reply = null;

    public QueueWoksWithStack() {
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
            dequeueHelp();
        }
        return reply;
    }

    @Override
    public void enqueue(T element) {
        myLinkedListStack.push(element);
    }

    private void dequeueHelp() {
        if (myLinkedListStack.size() == 1) {
            reply = myLinkedListStack.pop();
            return;
        }

        T temp = myLinkedListStack.pop();
        dequeueHelp();
        myLinkedListStack.push(temp);
    }
}
