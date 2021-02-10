import javax.swing.JPanel;
import java.util.Scanner;
import javax.swing.JTextField;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.*;
import java.lang.Object;
import java.util.Arrays;
import java.lang.*;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Duration;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.File;

public class suduko extends JFrame{
    private static final int newWIDTH = 400;
    private static final int newHEIGHT = 350;
    private JTextField textField;
    static JTextField[][] fields = new JTextField[9][9];
    static int N = 9;
    private long lastTickTime;
    public suduko()
    {   
        NewInitial();
    }
    public void NewInitial()
    {
        Scanner scan = new Scanner(System.in);
        JPanel newPanel = new JPanel();
        JFrame newFrame = new JFrame();
        newPanel.setBackground(Color.BLACK);
        setSize(450, 450);
        setContentPane(newPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++)
            {
                for (int k = 0; k < 9; k++)
                fields[i][j] = new JTextField("0");
                
                add(fields[i][j]);
            }
            setLayout(new GridLayout(10,7));
           
        }

        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
            
          
        

            if (solveSuduko(grid, 0, 0))
            print2(grid);

    }
    

    static boolean solveSuduko(int grid[][], int row, int col)
    {
        if (row == N - 1 && col == N)
            return true;

        if (col == N)
        {
            row++;
            col = 0;
        }
    

        if (grid[row][col] != 0)
            return solveSuduko(grid, row, col + 1);

        for (int num = 1; num < 10; num++)
        {
            if ( isSafe(grid, row, col, num))
        {
            grid[row][col] = num;

            if (solveSuduko(grid, row, col + 1))
                return true;
        }

        grid[row][col] = 0;

        }
        return false;
    }
    
    static void print(int[][] grid)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(int[][] grid, int row, int col, int num)
    {
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;

        for (int x = 0; x <= 8; x++)
            if(grid[x][col] == num)
                return false;

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;
        
        return true;
    }
    
static void print2(int[][] grid)
{   
    
    
    for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
                fields[i][j].setText(Integer.toString(grid[i][j]));
                
        }

    for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            fields[i][j].setHorizontalAlignment(fields[i][j].CENTER);
                
        }
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            fields[i][j].setBorder(border2);
                
        }
        for (int i = 3; i < 6; i++)
        {
            for (int j = 3; j < 6; j++)
            fields[i][j].setBorder(border2);
                
        }
        for (int i = 6; i < 9; i++)
        {
            for (int j = 6; j < 9; j++)
            fields[i][j].setBorder(border2);
                
        }
        for (int i = 6; i < 9; i++)
        {
            for (int j = 0; j < 3; j++)
            fields[i][j].setBorder(border2);
                
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 6; j < 9; j++)
            fields[i][j].setBorder(border2);
                
        }
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 6; j++)
            fields[i][j].setBorder(border2);
                
        }
        for (int i = 3; i < 6; i++)
        {
            for (int j = 0; j < 3; j++)
            fields[i][j].setBorder(border2);
                
        }
        for (int i = 6; i < 9; i++)
        {
            for (int j = 3; j < 6; j++)
            fields[i][j].setBorder(border2);
                
        }

        for (int i = 3; i < 6; i++)
        {
            for (int j = 6; j < 9; j++)
            fields[i][j].setBorder(border2);
                
        }


        for (int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 6; j++)
            fields[i][j].setBackground(Color.lightGray);
                
        }
        for (int i = 3; i < 6; i++)
        {
            for (int j = 0; j < 3; j++)
            fields[i][j].setBackground(Color.lightGray);
                
        }
        for (int i = 6; i < 9; i++)
        {
            for (int j = 3; j < 6; j++)
            fields[i][j].setBackground(Color.lightGray);
                
        }

        for (int i = 3; i < 6; i++)
        {
            for (int j = 6; j < 9; j++)
            fields[i][j].setBackground(Color.lightGray);
                
        }
        
}


    public static int[][] getGrid()
    {
        int grid1[][] ={ { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        return grid1;
    }

    


    public static void main(String[] args)
    {       

        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
            
            suduko some = new suduko();
            some.setVisible(true);
        
            if (solveSuduko(grid, 0, 0))
            print2(grid);
            else
            System.out.println("No solution exists");

        
    }
}