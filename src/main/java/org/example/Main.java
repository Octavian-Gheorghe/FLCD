package org.example;

import org.example.SymbolTable.SymbolTableContainer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SymbolTableContainer symbolTable = new SymbolTableContainer();

        try (BufferedReader br = new BufferedReader(new FileReader("src/symbols.in"))) {
            String line;
            while ((line = br.readLine()) != null) {
                symbolTable.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Inorder traversal of symbol table:");
        SymbolTableContainer.inorder(symbolTable.getAllNodesUnsorted().getFirst());
    }
}
