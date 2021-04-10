package main.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel extends JPanel {
    public static final int PANEL_SIZE=15;
    private int[][] panelData=new int[PANEL_SIZE][PANEL_SIZE];
    public static final BasicStroke PANEL_LINE=new BasicStroke(3);
    public interface IPanelClickListener{
        void clicked(int x,int y);
    }
    public IPanelClickListener panelClickListener;
    public BoardPanel(IPanelClickListener panelClickListener){
        //init panelData
        for(int i=0;i<PANEL_SIZE;i++){
            for(int j=0;j<PANEL_SIZE;j++){
                panelData[i][j]=-1;
            }
        }
//        panelData[1][2]=1;
//        panelData[2][1]=0;
        this.panelClickListener=panelClickListener;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getX()>getWidth()-3||e.getY()>getHeight()-3)
                    return;
//                panelClickListener.clicked(0,0);
                panelClickListener.clicked((e.getX()-3)/wStep,(e.getY()-3)/hStep);
            }
        });
    }
    public static final Font chessFont=new Font("",Font.BOLD,30);
    int wStep=0;
    int hStep=0;
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        wStep=(this.getWidth()-3)/PANEL_SIZE;
        hStep=(this.getHeight()-3)/PANEL_SIZE;
        ((Graphics2D)g).setStroke(PANEL_LINE);
        g.setColor(Color.black);
        for(int i=0;i<=PANEL_SIZE;i++){
            g.drawLine(i*wStep+3,3,i*wStep+3,this.getHeight()-3);
        }
        for (int i=0;i<=PANEL_SIZE;i++){
            g.drawLine(3,i*hStep+3,this.getWidth()-3,i*hStep+3);
        }
        //paint the chess
        g.setFont(chessFont);
        for (int i=0;i<PANEL_SIZE;i++){
            for (int j=0;j<PANEL_SIZE;j++){
                g.drawString(panelData[j][i]==-1?"":(panelData[j][i]==0?"O":"X"),j*wStep+7,i*hStep+30);
            }
        }
    }
    public void setChess(int x,int y,int chess){
        panelData[x][y]=chess;
    }
    public int checkWin(int x,int y){
        
    }

}
