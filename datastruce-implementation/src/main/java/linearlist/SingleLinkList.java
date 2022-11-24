package linearlist;

public class SingleLinkList {
    public static class ListNode {
        int data;
        ListNode next;

        private ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public static ListNode of(int data) {
            return new ListNode(data);
        }
    }

    public ListNode initEmptyList() {
        return ListNode.of(0);
    }

    public void headInsert(ListNode head, int data) {
        ListNode node = ListNode.of(data);
        node.next = head.next;
        head.next = node;
        head.data++;
    }

    public void tailInsert(ListNode head, int data) {
        head.data++;
        ListNode node = ListNode.of(data);
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }

    public void delete(ListNode head, int data) {
        if (head.data == 0) {
            return;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.data == data) {
                // current是要删除的节点
                pre.next = current.next;
                head.data--;
                return;
            }
            pre = current;
            current = current.next;
        }
    }

    public void printList(ListNode head) {
        ListNode node = head.next;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print("\b\b\n");
    }

    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList();
        ListNode head = singleLinkList.initEmptyList();
        singleLinkList.headInsert(head, 1);
        singleLinkList.headInsert(head, 2);
        singleLinkList.headInsert(head, 3);
        singleLinkList.headInsert(head, 4);
        singleLinkList.headInsert(head, 5);
        singleLinkList.tailInsert(head, 6);
        singleLinkList.tailInsert(head, 7);
        singleLinkList.tailInsert(head, 8);
        singleLinkList.tailInsert(head, 9);
        singleLinkList.tailInsert(head, 10);
        singleLinkList.printList(head);
        singleLinkList.delete(head, 10);
        singleLinkList.delete(head, 5);
        singleLinkList.printList(head);
    }
}
