package algo;

public class DLNode<E> {
    public DLNode<E> left;
    public DLNode<E> right;
    private final E value;

    DLNode(DLNode<E> left, DLNode<E> right, E value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    DLNode(E value){
        this(null,null, value);
    }

    public E getValue() {
        return value;
    }
}
