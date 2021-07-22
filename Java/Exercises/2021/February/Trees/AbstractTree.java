package ir.blog.mahdidavoodi;

public abstract class AbstractTree<T> implements Tree<T> {
    @Override
    public boolean isExternal(Position<T> position) throws IllegalArgumentException {
        return numberOfChildren(position) == 0;
    }

    @Override
    public boolean isInternal(Position<T> position) throws IllegalArgumentException {
        return numberOfChildren(position) > 0;
    }

    @Override
    public boolean isRoot(Position<T> position) throws IllegalArgumentException {
        return position == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<T> position) {
        if (isRoot(position)) return 0;
        else return 1 + depth(parent(position));
    }

    public int height(Position<T> position) {
        int height = 0;
        for (Position<T> p :
                children(position)) {
            height = Math.max(height, height(p));
        }
        return height;
    }
}
