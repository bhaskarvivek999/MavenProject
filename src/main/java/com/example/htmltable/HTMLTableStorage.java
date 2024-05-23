package com.example.htmltable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTMLTableStorage {

    private String autoFill = "&nbsp;";
    private boolean autoGrow = true;
    private List<List<Map<String, Object>>> structure = new ArrayList<>();
    private int rows = 0;
    private int cols = 0;
    private int nestLevel = 0;
    private boolean useTGroups = false;

    public HTMLTableStorage(int tabOffset, boolean useTGroups) {
        // Constructor logic here
        this.useTGroups = useTGroups;
    }

    public void setUseTGroups(boolean useTGroups) {
        this.useTGroups = useTGroups;
    }

    public boolean getUseTGroups() {
        return this.useTGroups;
    }

    public void setAutoFill(String fill) {
        this.autoFill = fill;
    }

    public String getAutoFill() {
        return this.autoFill;
    }

    public void setAutoGrow(boolean grow) {
        this.autoGrow = grow;
    }

    public boolean getAutoGrow() {
        return this.autoGrow;
    }

    public void setRowCount(int rows) {
        this.rows = rows;
    }

    public void setColCount(int cols) {
        this.cols = cols;
    }

    public int getRowCount() {
        return this.rows;
    }

    public int getColCount(Integer row) {
        if (row != null) {
            int count = 0;
            for (Map<String, Object> cell : this.structure.get(row)) {
                if (cell instanceof Map) {
                    count++;
                }
            }
            return count;
        }
        return this.cols;
    }

}
