package main.core;

import main.ui.BoardPanel;

public class GomokuBoardListener implements BoardPanel.IPanelClickListener {
    @Override
    public void clicked(int x, int y) {
//        System.out.println(x+","+y);
        BoardMain.boardPanel.setChess(x,y,0);
        BoardMain.boardPanel.repaint();
    }
}
