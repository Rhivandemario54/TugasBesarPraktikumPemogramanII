package view.jenispesawat;

import javax.swing.table.*;
import java.util.List;
import model.JenisPesawat;

    class JenisPesawatTableModel extends AbstractTableModel{
      private String[] columnNames = {"Nama"};
      private List<JenisPesawat> data;

      public JenisPesawatTableModel(List<JenisPesawat> data)
      {
        this.data = data;
      }

      public int getColumnCount(){
        return columnNames.length; 
       }

       public int getRowCount(){
          return data.size();
       }

       public String getColumnName(int col){
          return columnNames[col];
       }

       public Object getValueAt(int row, int col){
        JenisPesawat rowItem = data.get(row);
        String value = "";
        switch (col)
        {
            case 0:
            value = rowItem.getNama();
            break;
        }
        return value;
       }
    
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    public void add(JenisPesawat value)
    {
        data.add(value);
        fireTableRowsInserted(data.size() -1, data.size() -1);
    }
}