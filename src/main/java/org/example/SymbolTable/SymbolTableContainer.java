package org.example.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class SymbolTableContainer {
    private List<Node> allNodesUnsorted;

    public SymbolTableContainer() {
        allNodesUnsorted = new ArrayList<>();
    }

    public SymbolTableContainer(List<Node> nodes) {
        allNodesUnsorted = new ArrayList<>(nodes);
    }

    public List<Node> getAllNodesUnsorted() {
        return allNodesUnsorted;
    }

    public void setAllNodesUnsorted(List<Node> allNodesUnsorted) {
        this.allNodesUnsorted = allNodesUnsorted;
    }

    public Node insert(Node root, SymbolTableElement element) {
        if (root == null)
            return new Node(element);

        if (element.getId().compareTo(root.element.getId()) < 0)
            root.left = insert(root.left, element);
        else if (element.getId().compareTo(root.element.getId()) > 0)
            root.right = insert(root.right, element);

        return root;
    }

    public void add(String parsedString)
    {
        SymbolTableElement element = SymbolTableElement.parseSymbol(parsedString);
        if (allNodesUnsorted.isEmpty()) {
            Node root = insert(null, element);
            allNodesUnsorted.add(root);
        } else {
            Node node = insert(allNodesUnsorted.getFirst(), element);
            if (node != null) allNodesUnsorted.add(node);
        }
    }

    public static void inorder(Node root) {
        if (root != null)
        {
            inorder(root.left);
            System.out.println(root.element);
            inorder(root.right);
        }
    }

    public static Node search(Node root, String id) {
        if (root == null || root.element.getId().equals(id))
            return root;

        if (root.element.getId().compareTo(id) < 0)
            return search(root.right, id);

        return search(root.left, id);
    }
}
