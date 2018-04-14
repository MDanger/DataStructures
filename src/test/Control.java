package test;

import list.ArrayList;
import list.LinkedList;
import list.OandULinkedList;
import list.OrderedArrayList;
import queue.CircularArrayQueue;
import queue.LinkedQueue;
import stack.ArrayStack;
import stack.LinkedStack;

import java.util.Iterator;

public class Control {
    public static void main(String[] args) {
//        ArrayStack intAStack = new ArrayStack();
//        System.out.println("isEmpty: " + intAStack.isEmpty());
//        System.out.println("size: " + intAStack.size());
//        for(int i = 20; i > 0; i--){
//            intAStack.push(i);
//        }
//        System.out.println("iAS peek : " +intAStack.peek());
//        System.out.println("toString: " +intAStack.toString());
//        System.out.println("iAS pop: " +intAStack.pop());
//        System.out.println("iAS peek : " +intAStack.peek());
//        System.out.println("isEmpty: " + intAStack.isEmpty());
//        System.out.println("size: " + intAStack.size());
//        System.out.println("toString: " +intAStack.toString());
//        System.out.println("iAS pop: " +intAStack.pop());
//        System.out.println("iAS pop: " +intAStack.pop());
//        System.out.println("toString: " +intAStack.toString());

//        LinkedStack intLStack = new LinkedStack();
//        System.out.println("LStack isEmpty: " + intLStack.isEmpty());
//        System.out.println("LStack size: " + intLStack.size());
//        for (int i = 1; i <= 20; i++ ){
//            intLStack.push(i);
//        }
//        System.out.println("LStack isEmpty: " + intLStack.isEmpty());
//        System.out.println("LStack size: " + intLStack.size());
//        System.out.println("LStack peek : " +intLStack.peek());
//        System.out.println("toString: " +intLStack.toString());
//        System.out.println("LStack peek : " +intLStack.peek());
//        System.out.println("LStack pop: " +intLStack.pop());
//        System.out.println("iAS peek : " +intLStack.peek());
//        System.out.println("isEmpty: " + intLStack.isEmpty());
//        System.out.println("size: " + intLStack.size());
//        System.out.println("toString: " +intLStack.toString());
//        System.out.println("iAS pop: " +intLStack.pop());
//        System.out.println("iAS pop: " +intLStack.pop());
//        System.out.println("toString: " +intLStack.toString());

//        LinkedQueue intLQ = new LinkedQueue();
//        System.out.println("intLQ isEmpty: " + intLQ.isEmpty());
//        System.out.println("intLQ size: " +intLQ.size());
//        for (int i = 1; i <=20; i++){
//            intLQ.enqueue(i);
//        }
//        System.out.println("intLQ isEmpty: " + intLQ.isEmpty());
//        System.out.println("intLQ size: " +intLQ.size());
//        System.out.println("intLQ toString: " +intLQ.toString());
//        System.out.println("intLQ dequeue: " +intLQ.dequeue());
//        System.out.println("intLQ size: " +intLQ.size());
//        System.out.println("intLQ toString: " +intLQ.toString());
//        System.out.println("intLQ peek: " +intLQ.peek());

//        CircularArrayQueue intCAQ = new CircularArrayQueue();
//        System.out.println("intCAQ isEmpty: " + intCAQ.isEmpty());
//        System.out.println("intCAQ size: " +intCAQ.size());
//        for (int i = 1; i <=201; i++){
//            intCAQ.enqueue(i);
//        }
//        System.out.println("intCAQ isEmpty: " + intCAQ.isEmpty());
//        System.out.println("intCAQ size: " +intCAQ.size());
//        System.out.println("intCAQ peek: " +intCAQ.peek());
//        System.out.println("intCAQ toString: " +intCAQ.toString());
//        System.out.println("intCAQ dequeue: " +intCAQ.dequeue());
//        System.out.println("intCAQ peek: " +intCAQ.peek());
//        System.out.println("intCAQ size: " +intCAQ.size());
//        System.out.println("intCAQ toString: " +intCAQ.toString());
//        System.out.println("intCAQ isEmpty: " + intCAQ.isEmpty());

//        OrderedArrayList intOAL = new OrderedArrayList();
//        System.out.println("intOAL isEmpty: " + intOAL.isEmpty());
//        System.out.println("intOAL size: " +intOAL.size());
//        for (int i = 1; i <=20; i++){
//            intOAL.add(i);
//        }
//        System.out.println("intOAL isEmpty: " + intOAL.isEmpty());
//        System.out.println("intOAL size: " +intOAL.size());
//        System.out.println("intOAL first: " +intOAL.first());
//        System.out.println("intOAL last: " +intOAL.last());
//        System.out.println("intOAL removeFirst: " +intOAL.removeFirst());
//        System.out.println("intOAL size: " +intOAL.size());
//        System.out.println("intOAL first: " +intOAL.first());
//        System.out.println("intOAL last: " +intOAL.last());
//        intOAL.remove(20);
//        System.out.println("intOAL remove(20): " );
//        System.out.println("intOAL last: " +intOAL.last());
//        System.out.println("intOAL size: " +intOAL.size());
//        System.out.println("intOAL toString: " +intOAL.toString());
//        System.out.println("intOAL removeLast: " +intOAL.removeLast());
//        System.out.println("intOAL toString: " +intOAL.toString());
//        System.out.println("intOAL contains(11): " +intOAL.contains(11));
//        System.out.println("intOAL contains(30): " +intOAL.contains(30));
//        System.out.println("intOAL addToFront(20): " );
//        intOAL.addToFront(20);
//        System.out.println("intOAL toString: " +intOAL.toString());
//        System.out.println("intOAL addToTail(44): " );
//        intOAL.addToTail(44);
//        System.out.println("intOAL toString: " +intOAL.toString());
//        System.out.println("intOAL addAfter(55,10): " );
//        intOAL.addAfter(55, 10);
//        System.out.println("intOAL toString: " +intOAL.toString());
//        Iterator itr = intOAL.Iterator();
//        while (itr.hasNext()){
//            System.out.print(itr.next());
//        }
        OandULinkedList OLL = new OandULinkedList();
        System.out.println("OLL isEmpty: " + OLL.isEmpty());
        System.out.println("OLL size: " +OLL.size());
        for (int i = 1; i <=20; i++){
            OLL.add(i);
        }
        Iterator itr = OLL.Iterator();
        while (itr.hasNext()){
            System.out.print(itr.next());
        }
//        System.out.println("OLL toString: " +OLL.toString());
//        System.out.println("OLL isEmpty: " + OLL.isEmpty());
//        System.out.println("OLL size: " +OLL.size());
//        System.out.println("OLL first: " +OLL.first());
//        System.out.println("OLL last: " +OLL.last());
//        System.out.println("OLL toString: " +OLL.toString());
//        System.out.println("OLL addToFront(22)");
//        OLL.addToFront(22);
//        System.out.println("OLL toString: " +OLL.toString());
//        System.out.println("OLL addToTail(33)");
//        OLL.addToTail(33);
//        System.out.println("OLL toString: " +OLL.toString());
//        System.out.println("OLL addAfter(55,10)");
//        OLL.addAfter(55,10);
//        System.out.println("OLL toString: " +OLL.toString());
//        System.out.println("OLL remove(10)"  );
//        OLL.remove(10);
//        System.out.println("OLL toString: " +OLL.toString());
//        System.out.println("OLL removeFirst" + OLL.removeFirst());
//        System.out.println("OLL toString: " +OLL.toString());
//        System.out.println("OLL removeLast: " + OLL.removeLast());
//        System.out.println("OLL toString: " +OLL.toString());
    }
}
