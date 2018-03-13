/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea4_201503384;

import javax.swing.*;

/**
 *
 * @author diego
 */
public class Calculadora extends JFrame {

    public Calculadora() {
        setTitle("Calculadora");
        setSize(450, 450);
        setLocationRelativeTo(null);
        
        Panel panel = new Panel();
        panel.setVisible(true);
        add(panel);
    }
}