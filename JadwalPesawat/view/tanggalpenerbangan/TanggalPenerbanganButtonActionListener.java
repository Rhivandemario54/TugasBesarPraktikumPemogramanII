package view.tanggalpenerbangan;

import java.awt.event.*;
import model.TanggalPenerbangan;

    public class TanggalPenerbanganButtonActionListener implements ActionListener{
    private TanggalPenerbanganFrame tanggalPenerbanganFrame;

	public TanggalPenerbanganButtonActionListener(TanggalPenerbanganFrame tanggalPenerbanganFrame)
	{
		this.tanggalPenerbanganFrame = tanggalPenerbanganFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String nama = this.tanggalPenerbanganFrame.getNama();
		TanggalPenerbangan tanggalPenerbangan = new TanggalPenerbangan();
		tanggalPenerbangan.setNama(nama);

		this.tanggalPenerbanganFrame.addTanggalPenerbangan
		(tanggalPenerbangan);
	}
	}

