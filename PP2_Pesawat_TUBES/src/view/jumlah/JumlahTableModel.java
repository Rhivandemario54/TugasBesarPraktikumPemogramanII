package view.jumlah;

import javax.swing.table.*;
import java.util.List;
import model.Jumlah;

public class JumlahTableModel extends AbstractTableModel {
    private String[] columnNames = { "<< Jumlah Penumpang >>" };
    private List<Jumlah> data;

    public JumlahTableModel(List<Jumlah> data) {
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
        Jumlah rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getJumlahpen();
                break;
            case 1:
                value = rowItem.getId();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Jumlah value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void remove(int value) {
        data.remove(value);
        fireTableRowsDeleted(data.size() - 1, data.size() - 1);
    }
}
