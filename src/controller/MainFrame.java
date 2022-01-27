/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.MainView;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame{
    
    private MainView imageDisplay;

    public MainFrame() {
        this.imageDisplay = new MainView();
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(this.imageDisplay);
        this.setVisible(true);
    }
}
