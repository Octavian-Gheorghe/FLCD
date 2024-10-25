# Symbol Table with Binary Search Tree

This project implements a **Symbol Table** using a **Binary Search Tree (BST)** in Java. The symbol table is populated with elements read from an input file, `symbols.in`. Each element has an identifier (`id`), a `value`, and a `type`, determined based on specific parsing rules.

### `symbols.in` Format

Each line in `symbols.in` should contain an identifier followed by a value, separated by a space: (see 'symbols.in')

### 1. Symbol Type Identification

The `SymbolTableElement` class identifies the type of each symbol using regex patterns based on the value format. Here’s how types are assigned:

- **Integer**: If `valueStr` contains only digits, optionally prefixed with a negative sign (e.g., `-42` or `100`).
- **Float**: If `valueStr` represents a floating-point number, optionally prefixed with a negative sign (e.g., `3.14` or `-2.5`).
- **Character**: If `valueStr` is a single character enclosed in single quotes (e.g., `'a'`).
- **String**: If `valueStr` is a sequence of characters enclosed in single quotes (e.g., `'Hello'`).
- **Identifier**: If none of the above patterns match, the symbol is classified as an `Identifier`.

### 2. Data Structure

The symbol table elements are stored in a **Binary Search Tree (BST)**. Each element in the tree is a `Node` that contains:
- A `SymbolTableElement` object (holding the `id`, `value`, and `type`).
- Left and right child nodes, forming a hierarchical, sorted structure based on the `id`.

### 3. Adding an Element

The `SymbolTableContainer` class provides an `add` method that:
1. **Parses the Symbol**: Converts each line from `symbols.in` into a `SymbolTableElement` with `parseSymbol`.
2. **Checks for an Empty Tree**: If the tree is empty, the new element becomes the root.
3. **Inserts the Node**:
   - Compares the new element's `id` with the root node's `id`.
   - If the `id` is lexicographically smaller, it inserts into the left subtree; if larger, it inserts into the right subtree.
4. **Stores the Node**: Keeps track of nodes in `allNodesUnsorted`, with the first element as the root.

### 4. Searching for an Element

The `search` method in `SymbolTableContainer` finds an element by its `id`:
1. **Starting from the Root**: Calls `search` with the root node and the target `id`.
2. **Checking the Root**: Returns the node if `id` matches or `null` if the tree is empty.
3. **Traversing the Tree**:
   - Recursively searches the left subtree if the target `id` is smaller, or the right subtree if larger.
4. **Recursive Search**: Continues until finding the `id` or reaching a leaf node.

### Example of In-Order Traversal

The `inorder` method provides an in-order traversal of the BST (left-root-right), which prints all elements in lexicographical order by `id`.

## Running the Program

1. Place the `symbols.in` file in the `src` directory.
2. Run the `Main` class. This class will:
   - Read each line from `symbols.in`.
   - Parse and add each element to the binary search tree.
   - Display the elements in sorted order by performing an in-order traversal.

## Sample Output

Assuming `symbols.in` contains:
x 42
y 'c'
message 'Hello, World!'
count 100
flag 'Y'

The output after an in-order traversal will be:
Inorder traversal of symbol table:
SymbolTableElement{id='count', value=100, type='Integer'}
SymbolTableElement{id='flag', value=Y, type='Character'}
SymbolTableElement{id='message', value=Hello, World!, type='String'}
SymbolTableElement{id='x', value=42, type='Integer'}
SymbolTableElement{id='y', value=c, type='Character'}

## Notes

- **File Path**: The path for `symbols.in` is set as `"src/symbols.in"`.
- **Error Handling**: IOException is handled in the `main` method to catch issues with file access.
