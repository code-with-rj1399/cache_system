package algo;

import exceptions.InvalidElementException;

import java.util.NoSuchElementException;

public class DLList<E> {
    DLNode<E> dummyHead;
    DLNode<E> dummyTail;
    public DLList(){
        dummyHead = new DLNode<>(null);
        dummyTail = new DLNode<>(null);
        dummyTail.left = dummyHead;
        dummyHead.right = dummyTail;
    }

    public void addNodeAtLast(DLNode<E> node){
        DLNode<E> leftNode = dummyTail.left;
        leftNode.right = node;
        node.left = leftNode;
        node.right = dummyTail;
        dummyTail.left = node;
    }

    public void detatchNode(DLNode<E> element) {
        if(element == null) return;
        DLNode<E> leftNode = element.left;
        DLNode<E> rightNode = element.right;
        leftNode.right = rightNode;
        rightNode.left = leftNode;
        element.left = null;
        element.right = null;
    }

    private boolean isEmpty(){
        return dummyHead==dummyTail;
    }

    public DLNode<E> addElementAtLast(E element) {
        if(element == null) throw new InvalidElementException("Element is invalid");
        DLNode<E> node = new DLNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public DLNode<E> getFirstNode() {
        if (isEmpty())  throw new NoSuchElementException("No element present. ");
        else return dummyHead.right;
    }
}
