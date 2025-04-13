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
        prevNode.next = current.next;  // [20].next = [40] --> 20 --> 40
        current.next = null;  // Break the reference from [30] to [40], to completely detach it..
        return current;

    }

    public void reverse(){

        Node curr = head;
        Node prev = null;

        while (curr.next !=null){
             /// [1,2,3,4,5] == curr == head == 1 // next iteration // curr == 2 // 3
            Node temp = curr.next;
            // temp == [1].next == 1.[2] == 2 // Second Iteration // 2.[3] == 3 // third // 3.[4] == 4
            curr.next = prev;
            // curr.next == null // 1.next[2] now change to 1.next[null] // null<--1  2-->3-->4-->5
            // second iteration// // 2.next[3] // now change to 2.next[1]  1<--2 3 4 5
            // third iteration//  3 next[4] // now change to 3.next[2] 1<--2<--3 4 5
            prev = curr;   /// 1 == prev /// 2 == prev // 3 == prev
            curr = temp;    // curr == 2 // curr = 3 // curr 4

        }

    }

    public Node reverseRecursion(Node head){
        if(head == null || head.next == null){
            return head;
        }
        ///  1-->2-->3-->4
        Node newHead = reverseRecursion(head.next); //call happens until we reach end of Node//newHead = 4
        // this part will not execute yet ⬇️
        head.next.next = head;
        /****
         * First reverRecursion will keep calling unitl head.next = 3.next[4] is the last Node like 4
         * Second this line will excuete now head == 3 it's next is 4 and 4.next is null
         * Now we set 4.next to linked with 3 which is head in this line and reverse it.
         * 3.next[4].next[null] 4.next is null will linked with head = 3 // 3.4.next == 3
         * Before 3-->
         * After 3<--4
         */
        // 3.4.null = 3
        head.next = null; /// now just re-link the value 3.next which is 4 will be remove to null.
        return newHead;

    }

    public Boolean palindrome(Node head){

        if(head == null){
            return true;
        }
        ///  [1,2,3,2,1] Linked List
        Node mid = midOfLinkedList(head); /// middle will be 3.
        Node last = reverseRecursion(mid.next); /// 3.next[2] == 2
        /// this is reverse halfed reversed linkedlist 1--2--3--1-->2
        Node curr = head; /// 1
        while (last !=null){
            if(last.data !=curr.data){ /// last.data == 1 != curr.data == 1 // 1 == 1 // true
                return false;
            }
             last =last.next; // 1 .next == 2
             curr = curr.next; // 1.next == 2
        }
        return  true;
    }

    private Node midOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next !=null){

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}

