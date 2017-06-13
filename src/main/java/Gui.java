

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by ada on 28.03.17.
 */

public class Gui
{
    public static String type_BLANK = "BLANK";
    public static String type_WHITE = "WHITE";
    public static String type_BLACK = "BLACK";
    public static JFrame frame = new JFrame();
    public static JPanel backBoard = new JPanel();
    public static JLabel lbl = new JLabel();
    public static JButton btn = new JButton("History of moves");
    public static JList history = new JList();


    public static class Board
    {
        public static ArrayList<String> list = new ArrayList<String>();
        public String a;
        Board()
        {
            int numRows = 8;
            int numCols = 8;
            frame.setSize(605,805);
            backBoard.setBorder(new EmptyBorder(10,30,20,30));
/*
            backBoard.setSize(500,600);
*/
            frame.setTitle("Checkers");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //frame.setVisible(true);

            backBoard.setVisible(true);
            String str;
            //to copy: str=2,2,1,1,1,1,1,2,2,1,2,1,2,1,2,1,1,2,2,2,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,2,0,0,0,0,2,0,2,0,0,0,2,2,0,2,0,2,0,2,0,0,2,0,2,0,2,1,1
            str =   "1,0,1,0,1,0,1,0," +
                    "0,1,0,1,0,1,0,1," +
                    "1,0,0,0,1,0,1,0," +
                    "0,0,0,1,0,0,0,0," +
                    "0,0,0,0,2,0,0,0," +
                    "0,2,0,2,0,0,0,2," +
                    "2,0,2,0,2,0,2,0," +
                    "0,2,0,2,0,2,0,2," ;
            String[] splited = str.split(",");
            list.add(str);

//            for(int r=0; r<numRows; r++) {
//                for (int c = 0; c < numCols; c++) {
//                    //
//
//                    type = type_BLANK;
//                    if (c % 2 == 0) {
//                        if (r == 0 || r == 2) {
//                            type = type_WHITE;
//                        } else if (r == 6) {
//                            type = type_BLACK;
//                        }
//                    } else {
//                        if (r == 1) {
//                            type = type_WHITE;
//                        } else if (r == 5 || r == 7) {
//                            type = type_BLACK;
//                        }
//                    }
//                    backBoard.add(new BoardSquare(r, c, type));
//
//                }
//            }
            //frame.add(backBoard);
            repaint(numRows, numCols, splited);
            moves();
            setVisible(false);

        }
        public void repaint(int numRows, int numCols, String[] splited) {
            String type;
            int[][] tab = new int[8][8];
            int i = 0;
            backBoard.removeAll();
            for(int r=0; r<numRows; r++){
                for(int c=0; c<numCols; c++){
                    type = type_BLANK;
                    tab[r][c] = Integer.parseInt(splited[i]);

                    if (splited[i].equals("1")){
                        type = type_WHITE;
                    }
                    if(splited[i].equals("2")){
                        type = type_BLACK;
                    }
                    i++;
                    backBoard.add(new BoardSquare(r,c,type));
                }
            }

           /* backBoard.repaint();
            frame.add(backBoard);
            frame.repaint();*/
            SwingUtilities.updateComponentTreeUI(frame);
            frame.invalidate();
            frame.validate();
            frame.repaint();
            frame.add(backBoard);
        }

        public void moves(){
            int count=0;

            final JComboBox c = new JComboBox();
            for (int i = 0; i < list.size(); i++)
                c.addItem("move: " + String.valueOf(count++));

            c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    String newSelection = (String)c.getSelectedItem();
                    newSelection.repaint(8,8,splited);
                }
            });

            backBoard.add(c);
            SwingUtilities.updateComponentTreeUI(frame);
            frame.invalidate();
            frame.validate();
            frame.repaint();
            frame.add(backBoard);
        }

        public void add(String move){
            list.add(move);
        }

        public void setVisible(boolean visable){
            frame.setVisible(visable);
        }

    }

    /*public static void main(String[] args) throws URISyntaxException
    {
        Board game = new Board();
    }*/
}