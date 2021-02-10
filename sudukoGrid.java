import javax.swing.JPanel;
import java.util.Scanner;
import javax.swing.JTextField;
import java.awt.Container;
import javax.swing.JFrame;
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
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
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.time.Duration;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.File;

public class sudukoGrid extends JFrame
{
    private static final int newWIDTH = 450;
    private static final int newHEIGHT = 450;
    private long lastTickTime;
    public static long lastTickTime2;
    public static String whatTime;
    public static JLabel time;
    public static String time2 = "";
    
    public sudukoGrid()
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

        setSize(newWIDTH, newHEIGHT);
        JPanel newPanel = new JPanel();
        
        newPanel.setBackground(Color.BLACK);
        setContentPane(newPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);

        JTextField[][] fields = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                for (int k = 0; k < 9; k++)
                fields[i][j] = new JTextField(" ");
                setLayout(new GridLayout(10,7));
                
                add(fields[i][j]);
            }
           
        }
        JTextField[][] blank = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                for (int k = 0; k < 9; k++)
                blank[i][j] = new JTextField(" ");
                setLayout(new GridLayout(10,7));
                
                
            }
           
        }

        JLabel label2 = new JLabel();
        label2.setBounds(30, 140, 190, 25);
        add(label2);
        JLabel label3 = new JLabel();
        label3.setBounds(30, 140, 190, 25);
        add(label3);
        
int grids[][] = suduko.getGrid();

int grids2[][] = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
                   { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                   { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                   { 2, 6, 3, 4, 1, 5, 9, 8, 7 },
                   { 9, 7, 4, 8, 6, 3, 1, 2, 5 },
                   { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                   { 1, 3, 8, 9, 4, 7, 2, 5, 6 },
                   { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                   { 7, 4, 5, 2, 8, 6, 3, 1, 9 } };

for (int i = 0; i < 9; i++)
{
    for (int j = 0; j < 9; j++)
    blank[i][j].setText(Integer.toString(grids2[i][j])); 
}

for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            fields[i][j].setText(Integer.toString(grids[i][j]));                       
        }

for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            if (fields[i][j].getText().equals("0"))
            fields[i][j].setText("");
                
        }

for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            fields[i][j].setHorizontalAlignment(fields[i][j].CENTER);
                
        }
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
        JLabel time = new JLabel(String.format("%02d:%02d", 0, 0));
        time.setForeground(Color.white);
        time.setBounds(30, 140, 190, 25);
               
        Timer timer;

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long runningTime = System.currentTimeMillis() - lastTickTime;
                Duration duration = Duration.ofMillis(runningTime);
                long hours = duration.toHours();
                duration = duration.minusHours(hours);
                long minutes = duration.toMinutes();
                duration = duration.minusMinutes(minutes);
                long millis = duration.toMillis();
                long seconds = millis / 1000;
                millis -= (seconds * 1000);
                time.setText(String.format("%02d:%02d", minutes, seconds));
            }
        });
        
        JButton solve = new JButton("Finish");
        solve.setBounds(75, 330, 300, 25);
        solve.setForeground(Color.white);
        
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
        
        solve.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 9; i++)
                {
                    for (int j = 0; j < 9; j++)
                if (!fields[i][j].getText().equals(blank[i][j].getText()) && !fields[i][j].getText().equals(""))
                fields[i][j].setForeground(Color.red);
                else 
                fields[i][j].setForeground(Color.black); 
                }
                timer.stop();
            }
            
        });
    }
        JButton answer = new JButton("Show");
        answer.setBounds(75, 330, 300, 25);
        answer.setForeground(Color.white);
        answer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                suduko puzzle = new suduko();
                puzzle.setVisible(true);
                
            }
        });

        
        solve.setBackground(Color.WHITE);
        newPanel.add(solve);

        JLabel label4 = new JLabel();
        label4.setBounds(30, 140, 190, 25);
        add(label4);
        add(time);
        
        JLabel label5 = new JLabel();
        label5.setBounds(30, 140, 190, 25);
        add(label5);
        JButton check = new JButton("Check");
        check.setBounds(175, 330, 300, 25);
        check.setForeground(Color.white);

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
        
        check.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 9; i++)
                {
                    for (int j = 0; j < 9; j++)
                if (!fields[i][j].getText().equals(blank[i][j].getText()) && !fields[i][j].getText().equals(""))
                fields[i][j].setForeground(Color.red);
                else 
                fields[i][j].setForeground(Color.BLACK); 
                }
            }
            
        });   
        check.setBackground(Color.WHITE);
        newPanel.add(check);
        newPanel.add(answer);

        lastTickTime = System.currentTimeMillis();
                        timer.start();
        }
        }
        });
    }

    public static void main(String[] args)
    {   String newTime = "";
    Scanner scan = new Scanner(System.in);
    sudukoGrid runIt = new sudukoGrid();
    runIt.setVisible(true);
    }
}
