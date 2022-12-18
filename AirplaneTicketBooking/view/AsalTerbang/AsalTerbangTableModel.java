package view.AsalTerbang;

import javax.swing.table.*;
import java.util.List;
import model.AsalTerbang;

class AsalTerbangTableModel extends AbstractTableModel {
    private String[] columnNames = {"Asal Terbang"};
    private List<AsalTerbang> data;

    public AsalTerbangTableModel(List<AsalTerbang> data) {
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
        AsalTerbang rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getAsal();
                break;
        }
        return value;
    }   

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(AsalTerbang value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
