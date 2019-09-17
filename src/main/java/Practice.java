import java.util.*;

public class Practice {
    public static void main(String[] args) {
        //some new text from server
           String first = new String("version");
          String second = new String(first);

        System.out.println(first == second);
        System.out.println(first.intern() == second.intern());
    }


    public Node createRoot() {
        Node root = new Node("root");

        Node first = new Node("first");
        Node childFirst1 = new Node("child");
        Node childFirst2 = new Node("child");


        Node second = new Node("second");
        Node secondFirst1 = new Node("child");
        Node secondFirstChild = new Node("LEAF");

        Node child = new Node("child");
        Node ch = new Node("child");
        Node secondFirst2 = new Node("child");


        Node third = new Node("third");

        root .addChild(first);
        first.addChild(childFirst1);
        first.addChild(childFirst2);

        root.addChild(second);
        second.addChild(secondFirst1);
        secondFirst1.addChild(secondFirstChild);
        secondFirst1.addChild(ch);
        secondFirst1.addChild(child);
        second.addChild(secondFirst2);

        root.addChild(third);
        return root;
    }



}

class Node {
    Node parent;
    ArrayList<Node> children = new ArrayList<>();
    String value;

    Node(String value) {
        this.value = value;
    }

    public void addChild(Node node) {
        node.parent = this;
        children.add(node);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
            "value=" + value +
            ", children=" + children +
            '}' + "\n";
    }
}
