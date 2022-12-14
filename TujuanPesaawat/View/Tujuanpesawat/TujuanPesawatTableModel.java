package TujuanPesaawat.View.Tujuanpesawat;

import java.util.List;

import TujuanPesaawat.Model.Tujuanpesawat;

public class TujuanPesawatTableModel {
  private String[] columnNames = {"Nama"};
  private List<Tujuanpesawat> data;

  public void JenisMemberTableModel(List<Tujuanpesawat> data)
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
    Tujuanpesawat rowItem = data.get(row);
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

public void add(Tujuanpesawat value)
{
    data.add(value);
    fireTableRowsInserted(data.size() -1, data.size() -1);
}

private void fireTableRowsInserted(int i, int j) {
}
}
