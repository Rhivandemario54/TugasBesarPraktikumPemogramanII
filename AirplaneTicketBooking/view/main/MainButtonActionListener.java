package view.main;

import java.awt.event.*;

public class MainButtonActionListener implements ActionListener {
    private MainFrame mainFrame;

    public MainButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainFrame.getButtonAsalTerbang()) 
        {
            mainFrame.showAsalTerbangFrame();
        } 
        else if (e.getSource() == mainFrame.getButtonTujuanTerbang()) 
        {
            mainFrame.showTujuanTerbangFrame();
        } 
        else if (e.getSource() == mainFrame.getButtonPenumpang()) 
        {
            mainFrame.showPenumpangFrame();
        }
    }
}