package org.example.SymbolTable;

// this can be a constant or a symbol
public class SymbolTableElement
{
    private String id;
    private Object value;
    private String type;

    public SymbolTableElement(String id, Object value, String type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public static SymbolTableElement parseSymbol(String line) {
        String[] parts = line.trim().split("\\s+", 2);
        String id = parts[0];
        String valueStr = parts[1];

        Object value;
        String type;

        if (valueStr.matches("^(-?\\d+$)") && !valueStr.contains(".")) {
            value = Integer.parseInt(valueStr);
            type = "Integer";
        }
        else if(valueStr.matches("^(-?\\d+\\.?\\d*|\\d+)$"))
        {
            value = Float.parseFloat(valueStr);
            type = "Float";
        }
        else if (valueStr.matches("^'[^']'$"))
        {
            value = valueStr.charAt(1);
            type = "Character";
        }
        else if (valueStr.matches("^'[^']+'$"))
        {
            value = valueStr.substring(1, valueStr.length() - 1);
            type = "String";
        }
        else
        {
            value = valueStr;
            type = "Identifier";
        }
        return new SymbolTableElement(id, value, type);
    }

    @Override
    public String toString() {
        return "SymbolTableElement{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
