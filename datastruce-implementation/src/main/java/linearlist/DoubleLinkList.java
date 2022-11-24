package linearlist;

public class DoubleLinkList {
    public static class ListNode {
        int data;
        ListNode pre;
        ListNode next;

        private ListNode (int data) {
            this.data = data;
        }

        public static ListNode of (int data) {
            return new ListNode(data);
        }
    }

    public ListNode initEmptyList() {
        ListNode head = ListNode.of(0);
        head.pre = head;
        head.next = head;
        return head;
    }

    public void headInsert(ListNode head, int data) {
        ListNode node = ListNode.of(data);
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        head.data++;
    }

    public void tailInsert(ListNode head, int data) {
        ListNode node = ListNode.of(data);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        head.data++;
    }

    public void delete(ListNode head, int data) {
        ListNode node = head.next;
        while (node != head) {
            if (node.data == data) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                head.data--;
                return;
            }
            node = node.next;
        }
    }

    public void printList(ListNode head) {
        ListNode node = head.next;
        while (node != head) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print("\b\b\n");
    }

    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        ListNode head = doubleLinkList.initEmptyList();
        doubleLinkList.headInsert(head, 1);
        doubleLinkList.headInsert(head, 2);
        doubleLinkList.headInsert(head, 3);
        doubleLinkList.headInsert(head, 4);
        doubleLinkList.headInsert(head, 5);
        doubleLinkList.tailInsert(head, 6);
        doubleLinkList.tailInsert(head, 7);
        doubleLinkList.tailInsert(head, 8);
        doubleLinkList.tailInsert(head, 9);
        doubleLinkList.tailInsert(head, 10);
        doubleLinkList.printList(head);
        doubleLinkList.delete(head, 10);
        doubleLinkList.delete(head, 5);
        doubleLinkList.printList(head);
    }
}
