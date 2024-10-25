package org.example.SymbolTable;

public class Node
{
    SymbolTableElement element;
    Node left, right;

    public Node(SymbolTableElement element) {
        this.element = element;
        left = right = null;
    }
}