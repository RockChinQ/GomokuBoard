package main.ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(BoardPanel boardPanel){
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GomokuBoard");
        this.setBounds(200,200,boardPanel.getWidth()+20,boardPanel.getHeight()+40);
        boardPanel.setLocation(0,0);
        this.add(boardPanel);
        this.setVisible(true);
    }
}
