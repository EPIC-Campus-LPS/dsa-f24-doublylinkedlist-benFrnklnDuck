public class DoublyLinkedList<G> implements List {
    private int length;
    private Node<G> first;
    private Node<G> last;

    /**
     * Constructor, creates an empty linked list
     * sets the length to zero and head and tail to null
     */
    public DoublyLinkedList () {
        length = 0;
        first = null;
        last = null;
    }

    /**
     * Add an element to the end of the list
     * checks if the list is empty:
     * if true, make the first and last variables equal to the new node
     * if false, set the current last node's next value to the new node
     * change the current last variable to the new Node
     * add to the length variable
     * @param element element to add to the list
     */
    @Override
    public void add(Object element) {
        if (isEmpty()) {
            Node<G> newNode = (Node<G>) new Node<>(element);
            first = newNode;
            last = newNode;
        } else {
            Node<G> newNode = new Node<>((G) element, last);
            last.setNext(newNode);
            last = newNode;
        }
        length++;
    }

    /**
     * Add an element to the list at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * check if empty and indicated index is 0:
     * If true, set the first and last variables to the new node
     * if not, check if the indicated index is between the first and last nodes in the list
     * iterate through the list to find the indicated node
     * change the paths of the surrounding nodes to point to the new one
     * change the path of the new nodes to point to the surroundings
     * if not and the index is 0, set the first's previous to the new node
     * make the first into the new node and set its next to first
     * if the index is the last node, do the same thing as the first
     * using the last instead
     * if all of that is false, throw an exception
     * @param i       index of the element
     * @param element element to add to the list
     */
    @Override
    public void add(int i, Object element) throws IndexOutOfBoundsException {
        if (length == 0 && i == 0) {
            Node<G> tempNode = new Node<>((G) element);
            first = tempNode;
            last = tempNode;
        } else if (i > 0 && i < length) {
            Node<G> tempNode = first;
            for (int j = 1; j < i + 1; j++) {
                tempNode = tempNode.getNext();
            }
            Node<G> newNode = new Node<>((G) element, tempNode.getPrev());
            newNode.setNext(tempNode);
            tempNode.getPrev().setNext(newNode);
            tempNode.setPrev(newNode);
        } else if (i == 0) {
            Node<G> newNode = new Node<>((G) element);
            newNode.setNext(first);
            first = newNode;
        } else if (i == length) {
            Node<G> newNode = new Node<>((G) element, last);
            last.setNext(newNode);
            last = newNode;
        } else {
            throw new IndexOutOfBoundsException("Not a value in this list.");
        }
        length++;
    }

    /**
     * Removes all elements from the list
     * set the variables back to the original as set in the constructor
     */
    @Override
    public void remove() {
        length = 0;
        first = null;
        last = null;
    }

    /**
     * Remove element at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * if the list is only one long and the index is 0:
     * store the given node, reset the list and return the stored node
     * if it is the first or last node indicated:
     * save the first or last and change the variables to the next or previous in the list
     * decrement the length and return the stored node
     * if it is between the first and last:
     * iterate and save the node, connect the next and previous to each other
     * subtract from the length, return the saved node
     * if none of that, throw an exception
     * @param i index of the element to remove
     * @return the element that was removed
     */
    @Override
    public Node remove(int i) throws IndexOutOfBoundsException {
        if (length == 1 && i == 0) {
            Node<G> tempNode = first;
            first = null;
            last = null;
            length--;
            return tempNode;
        } else if (i == 0) {
            Node<G> tempNode = first;
            first = first.getNext();
            first.setPrev(null);
            length--;
            return tempNode;
        } else if (i == length - 1) {
            Node<G> tempNode = last;
            last = last.getPrev();
            last.setNext(null);
            length--;
            return tempNode;
        } else if (i > 0 && i < length - 1) {
            Node<G> tempNode = first;
            for (int j = 0; j < i; j++) {
                tempNode = tempNode.getNext();
            }
            tempNode.getPrev().setNext(tempNode.getNext());
            tempNode.getNext().setPrev(tempNode.getPrev());
            tempNode.getNext().setPrev(tempNode.getPrev());
            length--;
            return tempNode;
        } else {
            throw new IndexOutOfBoundsException("There is not a node at that index.");
        }
    }

    /**
     * Gets the element at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * create a new node and iterate through the list to find the node at the desired index
     * return that node
     * @param i index of the element
     * @return the element
     */
    @Override
    public Node get(int i) throws IndexOutOfBoundsException {
        if (i > -1 && i < length) {
            Node<G> tempNode = first;
            for (int j = 0; j < i; j++) {
                tempNode = tempNode.getNext();
            }
            return tempNode;
        } else {
            throw new IndexOutOfBoundsException("There is not a node at that index.");
        }
    }

    /**
     * Sets the element at i to a new value
     * If index is invalid, throws IndexOutOfBoundsException
     * Create a new node and iterate through the list to find the desired one
     * change its value
     * check for edge cases of the first or last node, no iteration required in those cases
     * if not an index in the list, throw exception
     * @param i       index of the element to set
     * @param element new value of the element
     */
    @Override
    public void set(int i, Object element) throws IndexOutOfBoundsException {
        if (i > 0 && i < length - 1) {
            Node<G> newNode = first;
            for (int j = 0; j < i; j++) {
                newNode = newNode.getNext();
            }
            newNode.setObject((G) element);
        } else if (i == 0) {
            first.setObject((G) element);
        } else if (i == length - 1) {
            last.setObject((G) element);
        } else {
            throw new IndexOutOfBoundsException("There isn't a node at that index.");
        }
    }

    /**
     * Returns the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Returns true if the list is empty and false if there are elements
     * Check length variable
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        }
        return false;
    }

    /**
     * Create a string that lists every node's value separated by a space
     * Use a temporary node and iteration to access each value
     * @return the string list of nodes
     */
    public String toString() {
        String out = "";
        Node<G> tempNode = first;
        for (int i = 0; i < length; i++) {
            out += tempNode + " ";
            tempNode = tempNode.getNext();
        }
        return out;
    }
}
