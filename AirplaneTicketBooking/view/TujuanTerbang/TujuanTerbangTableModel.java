package view.TujuanTerbang;

import javax.swing.table.*;
import java.util.*;
import model.TujuanTerbang;

class TujuanTerbangTableModel extends AbstractTableModel {
    private String[] columnNames = {"Tujuan Terbang"};
    private List<TujuanTerbang> data;

    public TujuanTerbangTableModel(List<TujuanTerbang> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        TujuanTerbang rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getTujuan();
                break;
        }
        return value;
    }   

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(TujuanTerbang value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}