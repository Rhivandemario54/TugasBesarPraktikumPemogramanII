package view.classpenerbangan;

import java.awt.event.*;
import model.ClassPenerbangan;

    public class ClassPenerbanganButtonSimpanActionListener implements ActionListener{
    private ClassPenerbanganFrame classPenerbanganFrame;

    public ClassPenerbanganButtonSimpanActionListener(ClassPenerbanganFrame classPenerbanganFrame)
    {
        this.classPenerbanganFrame = classPenerbanganFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.classPenerbanganFrame.getNama();
        ClassPenerbangan classPenerbangan = new ClassPenerbangan();
        classPenerbangan.setNama(nama);

        this.classPenerbanganFrame.addClassPenerbangan(classPenerbangan);
      }
    }

