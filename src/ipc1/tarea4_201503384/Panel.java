/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea4_201503384;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author diego
 */
public final class Panel extends JPanel {

    private JTextField primer_numero;
    private JTextField segundo_numero;
    private JTextField resultado;
    private JTextField signo;
    private final JTextField igual;
    private JPanel panel_encabezado;
    private JPanel panel_signos;
    private JButton operacion;

    public Panel() {
        setLayout(new BorderLayout());

        panel_encabezado = new JPanel();
        panel_encabezado.setLayout(new GridLayout(1, 5));

        panel_signos = new JPanel();
        panel_signos.setLayout(new GridLayout(2, 3));

        primer_numero = new JTextField();

        signo = new JTextField();
        signo.setEditable(false);
        signo.setHorizontalAlignment(JTextField.CENTER);

        igual = new JTextField("=");
        igual.setHorizontalAlignment(JTextField.CENTER);
        igual.setEditable(false);

        segundo_numero = new JTextField();

        resultado = new JTextField();
        resultado.setEditable(false);

        add(panel_encabezado, BorderLayout.NORTH);
        add(panel_signos, BorderLayout.CENTER);

        panel_encabezado.add(primer_numero);
        panel_encabezado.add(signo);
        panel_encabezado.add(segundo_numero);
        panel_encabezado.add(igual);
        panel_encabezado.add(resultado);

        ActionListener insertar = new InsertarSigno();
        ActionListener operar = new Operar();

        crearBoton("+", insertar);
        crearBoton("-", insertar);
        crearBoton("*", insertar);
        crearBoton("/", insertar);

        operacion = new JButton("=");
        operacion.addActionListener(operar);
        panel_signos.add(operacion);
    }

    public void crearBoton(String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        boton.setSize(50, 50);
        boton.addActionListener(oyente);
        panel_signos.add(boton);
    }

    private class InsertarSigno implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String entrada = e.getActionCommand();
            signo.setText(entrada);
        }
    }

    private class Operar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calcular(Integer.parseInt(primer_numero.getText()), Integer.parseInt(segundo_numero.getText()));
        }
    }

    public void calcular(int numero1, int numero2) {

        switch (signo.getText()) {
            case "+":
                resultado.setText("" + (numero1 + numero2));
                break;
            case "-":
                resultado.setText("" + (numero1 - numero2));
                break;
            case "*":
                resultado.setText("" + (numero1 - numero2));
                break;
            case "/":
                resultado.setText("" + (numero1 - numero2));
                break;
        }
    }
}
