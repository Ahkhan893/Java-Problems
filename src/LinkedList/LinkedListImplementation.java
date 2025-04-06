package LinkedList;

public class LinkedListImplementation {

    Node head;
    Node tail;
    int length;

    /**
     * A node class
     */
    class Node {

        int data;
        Node next;



        /**
         * Constructor
         *
         * @param_value - value for a node
         */
        public Node(int data) {
            this.data = data;
        }
    }
    /**
     * Constructor to build a new linked list instance
     *
     * @param_value - the first value to be inserted into the linked list
     */

    public LinkedListImplementation(Node head, Node tail, int length) {
        this.head = head;
        this.tail = tail;
        this.length = 1;
    }

    /**
     * Prints the node values within a linked list
     */
    public void printList(){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.data);
            temp = head.next;
        }
    }

    /**
     * Utility method to return the head value for a linked list
     */

    public void getHead(){
        System.out.println("Head " + head.data);
    }

    /**
     * Utility method to return the tail value for a linked list
     */

    public void getTail(){
        System.out.println("Tail " + tail.data);
    }

    /**
     * Utility method to return the length of a linked list
     */

    public void getLength(){
        System.out.println("Length " + length);
    }

    /**
     * Add a node to the end of the LinkedList
     * This operation is O(1) which is constant in nature
     *
     * @param_value - the value to be added
     */

    public void append(int data){

        Node newNode = new Node(data);

        if(head==null){
            head = newNode;
        }else {
            tail.next = newNode; //// 30.next = 40
        }          /// tail.next = newNode; physically links the new node to the end of the list.
        tail = newNode; ///This updates the tail pointer to point to the new last node (which is newNode).
        length++;
    }
    /**
     * Add a node to the start of the LinkedList
     * This operation is O(1) which is constant in nature
     *
     * @param_value - the value to be added
     */
    public void prepend(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
            head.next =newNode;
        }
        head = newNode;
        length++;
    }

    public Node removeLastNode(){

        if(head==null){
            return null;
        }
        Node currentNode = head;  /// Current: will travel to the last node.
        Node prevNode = head;     /// prev: will stay one step behind current.
        while (currentNode.next !=null){
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        tail = prevNode;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }
        return tail;
    }


    public Node removeFirstNode(){

        if(length == 0){
            return null;
        }
        //    head → [10] → [20] → [30] → null
//            ↑
//            current
        Node current = head;
        head.next = head;
        current.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return current;
    }
    /**
     * Returns a node at the specified index within the LinkedList
     * This operation is O(n) since we need to iterate
     * through 'n' number the items within the linked list
     *
     * @param index - the index to get the value from
     * @return Node
     */
    public Node get(int index){

        if(index < 0 || index >= length){
            return null;
        }
        Node current = head;
        for(int i = 0 ; i < index; i ++){
            current = current.next;
        }
        return current;

    }
    /**
     * Replaces the value at a specified index within the LinkedList
     * This operation is O(n) since we need to iterate
     * through 'n' number the items within the linked list to change its value
     *
     * @param index - the index to change
     * @param value - the new value to be added at that index
     * @return Node
     */

    public boolean set(int index , int value){
        Node current = get(index);
        if(current != null){
            current.data = value;
            return true;
        }
        return false;
    }
    /**
     * Inserts a node at a specified index within the LinkedList
     * This operation is O(n).
     *
     * @param index - the index to insert at
     * @param value - the new value to be inserted at that index
     * @return boolean
     */

    public boolean insert(int index ,  int value){

        if(index < 0 || index > length){
            return false;
        }
        if(index == 0){
            prepend(value);
        }
        if(index == length){
            append(value);
        }else {
            Node newNode = new Node(value);
            Node prevNode = get(index - 1); // prev = [20]
//            You need the node before the position where the new node should go.
//            So, if you’re inserting at index 2, you get node at index 1 (prev).
            newNode.next = prevNode.next; /// prev.next = [30]
            prevNode.next = newNode; // [20].next = [25]
            /// [10] → [20] → [25] → [30] → [40]
            length  ++;
        }
        return true;
    }
    /**
     * Removes a node at a specified index within the LinkedList
     *
     * @param index - the index at which the value needs to be removed
     * @return Node
     */

    public Node remove(int index){

        if(index < 0 || index > length){
            return null;
        }
        if(index == 0 ){
            removeFirstNode();
        }
        if(index == length-1){
            removeLastNode();
        }
//        [10] → [20] → [30] → [40] → [50]
//        0     1     2      3    4

        Node prevNode = get(index - 1); // [20]
        Node current = prevNode.next; // [30]
        prevNode.next = current.next;  // [20].next = [40] --> 30 == 40
        current.next = null;  // Break the reference from [30] to [40], to completely detach it..
        return current;

    }



}

