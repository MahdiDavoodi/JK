package ir.blog.mahdidavoodi;


import java.util.Stack;

public class PersianStack<T> extends Stack<T> {
    public int hajm() {
        return super.size();
    }

    public boolean ayaKhalist() {
        return super.isEmpty();
    }


    public T darj(T element) {
        super.push(element);
        return element;
    }


    public T akharin() {
        return super.lastElement();
    }


    public T bardashtan() {
        return super.pop();
    }

    public T avvalin() {
        return super.firstElement();
    }
}

