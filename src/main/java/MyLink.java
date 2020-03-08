/**
 * Created by wangshunxi on 2019/11/22.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class MyLink {
    //头节点
    Node head = null;

    class Node{
        Node next = null;
        int data; //节点内容
        public Node(int data){
            this.data = data;
        }
    }

    //insert
    public void addNode(int d){
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
            return;
        }
        Node tmp = newNode;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;


    }
}
