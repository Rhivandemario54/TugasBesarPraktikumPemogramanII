package view.pendaftaran;

import javax.swing.table.*;
import java.util.List;
import model.Pendaftaran;

public class PendaftaranTableModel extends AbstractTableModel {
    private String[] columnNames = { "NamaUser", "TGL_Penerbangan", "Kelas Penerbangan", "Tujuan", "Jumlah Penumpang" };
    private List<Pendaftaran> data;

    public PendaftaranTableModel(List<Pendaftaran> data) {
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
        Pendaftaran rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNamauser();
                break;
            case 1:
                value = rowItem.getTgl_penerbangan();
                break;
            case 2:
                value = rowItem.getKelaspen();
                break;
            case 3:
                value = rowItem.getJumlah().getJumlahpen();
                break;
            case 4:
                value = rowItem.getTujuan().getTujuanpen();
                break;
            case 5:
                value = rowItem.getId();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Pendaftaran value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void remove(int value) {
        data.remove(value);
        fireTableRowsDeleted(data.size() - 1, data.size() - 1);
    }
}
