import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @org.junit.jupiter.api.Test
    void add() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(4);
        assertEquals("4 ", dll.toString());
        dll.add(6);
        assertEquals("4 6 ", dll.toString());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(0, 4);
        assertEquals("4 ", dll.toString());
        dll.add(1, 6);
        assertEquals("4 6 ", dll.toString());
        dll.add(2, 7);
        dll.add(2, 6);
        assertEquals("4 6 6 7 ", dll.toString());
        dll.add(0, 5);
        assertEquals("5 4 6 6 7 ", dll.toString());
        dll.remove();
        dll.add(0, 6);
        assertEquals("6 ", dll.toString());
        boolean thrown = false;
        try {
            dll.add(9, 5);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(4);
        dll.add(5);
        dll.add(4);
        dll.remove();
        assertEquals("", dll.toString());
        dll.remove();
        assertEquals("", dll.toString());
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(5);
        dll.add(4);
        dll.add(2);
        dll.remove(1);
        assertEquals("5 2 ", dll.toString());
        dll.remove(0);
        assertEquals("2 ", dll.toString());
        dll.remove(0);
        assertEquals("", dll.toString());
        dll.add(6);
        dll.add(2);
        dll.remove(1);
        assertEquals("6 ", dll.toString());
        dll.add(7);
        dll.add(8);
        dll.add(2);
        dll.remove(2);
        assertEquals("6 7 2 ", dll.toString());
        boolean thrown = false;
        try {
            dll.remove(9);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @org.junit.jupiter.api.Test
    void get() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(6);
        dll.add(7);
        dll.add(21);
        String str = dll.get(0).getObject() + "";
        assertEquals(str, "6");
        str = dll.get(1).getObject() + "";
        assertEquals(str, "7");
        str = dll.get(2).getObject() + "";
        assertEquals(str, "21");
        boolean thrown = false;
        try {
            dll.get(9);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @org.junit.jupiter.api.Test
    void set() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(6);
        dll.add(7);
        dll.add(21);
        dll.set(0, 1);
        assertEquals("1 7 21 ", dll.toString());
        dll.set(1, 2);
        assertEquals("1 2 21 ", dll.toString());
        dll.set(2, 3);
        assertEquals("1 2 3 ", dll.toString());
        boolean thrown = false;
        try {
            dll.set(9, 30);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @org.junit.jupiter.api.Test
    void size() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(6);
        dll.add(7);
        dll.add(21);
        assertEquals(3, dll.size());
        dll.remove(0);
        assertEquals(2, dll.size());
        dll.remove(0);
        assertEquals(1, dll.size());
        dll.remove();
        assertEquals(0, dll.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(6);
        dll.add(7);
        dll.add(21);
        assertFalse(dll.isEmpty());
        dll.remove();
        assertTrue(dll.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(6);
        dll.add(7);
        dll.add(21);
        assertEquals("6 7 21 ", dll.toString());
        dll.remove(0);
        assertEquals("7 21 ", dll.toString());
        dll.remove(1);
        assertEquals("7 ", dll.toString());
        dll.remove();
        assertEquals("", dll.toString());
    }
}