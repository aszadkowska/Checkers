import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.net.URISyntaxException;

/**
 * Created by ada on 28.03.17.
 */

public class Gui
{
    public static String type_BLANK = "BLANK";
    public static String type_WHITE = "WHITE";
    public static String type_BLACK = "BLACK";

    public static int width = 70;
    public static int height = 70;

    Client client;
    public static class Board
    {
        private JFrame frame = new JFrame();
        private JPanel backBoard = new JPanel();


        Board()
        {
            int numRows = 8;
            int numCols = 8;
            frame.setSize(605,605);
            backBoard.setSize(500,600);
            frame.setTitle("Checkers");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            backBoard.setVisible(true);
            String str;
            str =   "1,0,1,0,1,0,1,0," +
                    "0,1,0,1,0,1,0,1," +
                    "1,0,0,0,1,0,1,0," +
                    "0,0,0,1,0,0,0,0," +
                    "0,0,0,0,2,0,0,0," +
                    "0,2,0,2,0,0,0,2," +
                    "2,0,2,0,2,0,2,0," +
                    "0,2,0,2,0,2,0,2," ;
            String[] splited = str.split(",");

            String type;

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
            frame.add(backBoard);
            repaint(numRows, numCols, splited);

            String content = "Ada ada adaa\n";
            backBoard.add(new JTextArea(content));


        }

        public void repaint(int numRows, int numCols, String[] splited) {
            String type;
            int[][] tab = new int[8][8];
            int i = 0;
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
            *//*frame.add(backBoard);*//*
            frame.repaint();

*/
            SwingUtilities.updateComponentTreeUI(frame);
        }

        private class BoardSquare extends JComponent
        {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            private int x; //x position of the rectangle measured from top left corner
            private int y; //y position of the rectangle measured from top left corner

            private boolean isBlack = false;
            private boolean isRed = false;

            public BoardSquare(int p, int q, String type)
            {
                //this.setBorder(new LineBorder(Color.CYAN, 2));
                this.setPreferredSize(new Dimension(width, height));

                x = p;
                y = q;

                if (type.equals(type_BLACK))
                {
                    isBlack = true;
                    isRed = false;
                }
                else if (type.equals(type_WHITE))
                {
                    isRed = true;
                    isBlack = false;
                }
                else if (type.equals(type_BLANK))
                {
                    isBlack = false;
                    isRed = false;

                }


            }
            public void paintComponent(Graphics g)
            {
                String ada;
                int numRows = 8;
                int numCols = 8;
                Graphics2D g2 = (Graphics2D) g;
                Graphics2D g3 = (Graphics2D) g;
                Rectangle box = new Rectangle(x,y,width,height);
                g2.draw(box);

                g2.setPaint(Color.LIGHT_GRAY);

                g2.fill(box);
                g3.draw(box);
                g3.fill(box);

                int ovalWidth = width - 25;
                int ovalHeight = height- 25;


                if(isBlack)
                {
                    g2.setColor(Color.black);
                    g2.fillOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight);
                    g2.drawOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight) ;

                    g3.setColor(Color.darkGray);
                    g3.fillOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight);
                    g3.drawOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight) ;
                }

                else if(isRed)
                {
                    g3.setColor(Color.darkGray);
                    g3.fillOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight);
                    g3.drawOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight) ;
                    g2.setColor(Color.white);
                    g2.fillOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight);
                    g2.drawOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight);

                }


            }
        }


    }

    /*public static void main(String[] args) throws URISyntaxException
    {
        Board game = new Board();
    }*/
}