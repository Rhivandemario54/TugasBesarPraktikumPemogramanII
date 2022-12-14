package view.member;

import javax.swing.table.*;
import java.util.List;
import model.Pesawat;

    class MemberTableModel extends AbstractTableModel {
      private String[] columnNames = {"Nama", "Jenis Pesawat"};
      private List<Pesawat> data;

      public MemberTableModel(List<Pesawat> data)
      {
        this.data = data;
      }

      public int getColumnCount()
      {
        return columnNames.length;
      }

      public int getRowCount() 
      {
        return data.size();
      }

      public String getColumnName(int col)
      {
        return columnNames[col];
      }

      public Object getValueAt(int row, int col)
      {
        Pesawat rowItem = data.get(row);
        String value = "";
        switch (col)
        {
            case 0: 
                 value = rowItem.getNama();
                 break;
            case 1:
                 value = rowItem.getJenisPesawat().getNama();
                 break;
        }
        return value;
      }

      public boolean isCellEditable(int row, int col)
      {
        return false;
      }

      public void add(Pesawat value)
      {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() -1);
      }
    }
