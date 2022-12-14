package Penumpang.view;

import javax.swing.table.*;
import java.util.List;
import Penumpang.model.JenisPenumpang;

// Input Dari Frame JenisPenumpangFrame belom keluar di JTable, masih bingung cara ngambilnya

class JenisPenumpangTableModel extends AbstractTableModel{
    private String[] columnNames = {"Tiket Dewasa", "Tiket Anak"};
    private List<JenisPenumpang> data;

    public JenisPenumpangTableModel(List<JenisPenumpang> data) {
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
        JenisPenumpang rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getTiketDewasa();
                break;
            case 1:
                value = rowItem.getTiketAnak();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(JenisPenumpang value) {
        data.add(value);
        fireTableRowsInserted(data.size() -1, data.size() -1);
    }
}