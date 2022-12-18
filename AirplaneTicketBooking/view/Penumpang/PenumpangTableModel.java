package view.Penumpang; 

import javax.swing.table.*;
import java.util.List;
import model.Penumpang;

class PenumpangTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "No Telp", "Umur",  "Asal Terbang", "Tujuan Terbang"};

    private List<Penumpang> data;

    public PenumpangTableModel(List<Penumpang> data) {
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
        Penumpang rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getNoTelpon();
                break;
            case 2:
                value = rowItem.getUmur();
                break;
            case 3:
                value = rowItem.getAsalTerbang().getAsal();
                break;
            case 4:
                value = rowItem.getTujuanTerbang().getTujuan();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add (Penumpang value) {
        data.add(value);
        fireTableRowsInserted(data.size() -1, data.size() -1);
    }


}
