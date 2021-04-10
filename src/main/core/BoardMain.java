package main.core;

import main.ui.BoardPanel;
import main.ui.MainFrame;

public class BoardMain {
    public static BoardPanel boardPanel;
    public static MainFrame mainFrame;
    public static GomokuBoardListener gomokuBoardListener=new GomokuBoardListener();
    public static void main(String[] args) {
        boardPanel=new BoardPanel(gomokuBoardListener);
        boardPanel.setSize(456,456);

        mainFrame=new MainFrame(boardPanel);
    }
}
