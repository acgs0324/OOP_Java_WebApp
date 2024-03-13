package uk.ac.ucl.model;

import java.util.ArrayList;

public class DataFrame {
    private ArrayList<Column> columns;

    public DataFrame() {
        this.columns = new ArrayList<Column>();
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public ArrayList<String> getColumnNames() { // Return a list of names in the same order as they are stored in the frame
        ArrayList<String> columnNames = new ArrayList<>();
        for (Column column : this.columns) {
            columnNames.add(column.getName());
        }
        return columnNames;
    }

    public int getRowCount() { // Return the number of rows in a column, all columns should have the same number of rows when the frame is fully loaded with data
        return this.columns.getFirst().getSize();
    }

    public String getValue(String columnName, int row) {
        for (Column column : this.columns) {
            if (column.getName().equals(columnName)) {
                return column.getRowValue(row);
            }
        }
        return null;
    }

    public void putValue(String columnName, int row, String value) {
        for (Column column : this.columns) {
            if (column.getName().equals(columnName)) {
                column.setRowValue(row, value);
            }
        }
    }

    public void addValue(String columnName, String value) {
        for (Column column : this.columns) {
            if (column.getName().equals(columnName)) {
                column.addRowValue(value);
            }
        }
    }
}
