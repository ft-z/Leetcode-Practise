import java.util.*;

public class Main {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        String s="";

//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);

//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);

        ListNode l1=new ListNode(-10);
        ListNode head=l1;
        l1.next=new ListNode(-10);
        l1=l1.next;
        l1.next=new ListNode(-9);
        l1=l1.next;
        l1.next=new ListNode(-4);
        l1=l1.next;
        l1.next=new ListNode(1);
        l1=l1.next;
        l1.next=new ListNode(6);
        l1=l1.next;
        l1.next=new ListNode(6);

//        while (head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }

        ListNode l2=new ListNode(-7);

        //ListNode res = new ListNode(mergeTwoLists(l1, l2).val);
        ListNode res=mergeTwoLists(head,l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merge;
        ListNode head;
        //排除空
        if (l1 == null) {
            if (l2 != null) {
                return l2;
            }
            return null;
        }
        if (l2 == null) {
            return l1;
        }

        //获取
        if (l1.val <= l2.val) {
            merge = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            merge = new ListNode(l2.val);
            l2 = l2.next;
        }

        //存储头部
        head=merge;

        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                merge.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if (l2 == null && l1 != null) {
                merge.next = new ListNode(l1.val);
                l1=l1.next;
            }

            else if(l1==null&&l2==null){
                break;
            }

            else if (l1.val <= l2.val) {
                merge.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else if (l1.val > l2.val) {
                merge.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            //这里是每一种条件下都要判断，以防止在l1和l2挪动时，两者都已经到了尾部，merge再往下挪就有问题
            if (l1 != null || l2 != null) {
                merge = merge.next;
            }
        }
        return head;
    }

}
