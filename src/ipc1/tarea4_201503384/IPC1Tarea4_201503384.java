/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea4_201503384;

import javax.swing.JFrame;

/**
 *
 * @author diego
 */
public class IPC1Tarea4_201503384 extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculadora verCalculadora = new Calculadora();
        verCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        verCalculadora.setVisible(true);
    }
    
}
