package singlyLinkedList;

/**
 * Modified from Drozdek, Data Structures and Algorithms in Java
 */
/*
 * Name: Philip Cothery
 *  COSC 311 FA19 
 *  hw0912 
 *  URL: <your URL>
 */

public class SinglyLinkedList {

	public class Node {
		int data;
		Node next;

		public Node() {
			this(0, null);
		}

		public Node(int data) {
			this(data, null);
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head, tail;

	public SinglyLinkedList() {
		head = tail = null;
	}

	public void insert(int data) {
		if (head == null) {
			head = tail = new Node(data, head);
		} else {
			if (head.data > data) {
				head = new Node(data, head);
			} else {
				if (head.next == null) {
					tail = new Node(data, null);
					head.next = tail;
				} else {
					Node before = head;
					Node after = head.next;
					while (after != null) {
						if (data <= after.data) {
							before.next = new Node(data, after);
							break;
						}
						if (after.next == null) {
							after.next = new Node(data, null);
							break;
						} else {

							before = before.next;
							after = after.next;
						}
					}
				}
			}
		}

	}

	public void delete(int data) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.next.data == data) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		if (head.data == data) {
			head = head.next;
		}

	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		String s = "";
		if (head == null) {
			return "Empty String";
		}
		for (Node p = head; p != null; p = p.next)
			s += p.data + " ";
		return s;
	}

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();

		System.out.println("Execution begun");
		System.out.println("initial list: " + list);

		// testing
		list.insert(3);
		list.insert(5);
		System.out.println(list);

		list.insert(2);
		list.insert(2);
		list.insert(2);
		list.insert(7);
		list.insert(6);
		System.out.println("list after inserts: " + list);

		list.delete(2);
		list.delete(5);
		list.delete(7);
		System.out.println("list after deletes: " + list);

		System.out.println("Execution terminated");
	}
}
