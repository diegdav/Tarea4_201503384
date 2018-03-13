/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea4_201503384;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author diego
 */
public class Panel extends JPanel implements ActionListener {

    private JTextField txt_primer_numero;
    private JTextField txt_segundo_numero;
    private JTextField txt_resultado;
    private JTextField txt_signo;
    private JTextField txt_igual;
    private JPanel panel_encabezado;
    private JButton btn_suma;
    private JButton btn_resta;
    private JButton btn_multiplicacion;
    private JButton btn_division;
    private JButton btn_igual;
    private JButton btn_limpiar;
    
    public Panel() {
        setLayout(null);

        panel_encabezado = new JPanel();
        panel_encabezado.setBounds(70, 50, 300, 50);
        panel_encabezado.setLayout(new GridLayout(1, 5));

        add(panel_encabezado);

        txt_primer_numero = new JTextField();
        txt_primer_numero.setHorizontalAlignment(JTextField.CENTER);

        txt_signo = new JTextField();
        txt_signo.setEditable(false);
        txt_signo.setHorizontalAlignment(JTextField.CENTER);

        txt_igual = new JTextField("=");
        txt_igual.setHorizontalAlignment(JTextField.CENTER);
        txt_igual.setEditable(false);

        txt_segundo_numero = new JTextField();
        txt_segundo_numero.setHorizontalAlignment(JTextField.CENTER);

        txt_resultado = new JTextField();
        txt_resultado.setEditable(false);
        txt_resultado.setHorizontalAlignment(JTextField.CENTER);

        panel_encabezado.add(txt_primer_numero);
        panel_encabezado.add(txt_signo);
        panel_encabezado.add(txt_segundo_numero);
        panel_encabezado.add(txt_igual);
        panel_encabezado.add(txt_resultado);

        btn_suma = new JButton("+");
        btn_suma.setBounds(80, 150, 60, 60);
        btn_suma.setFont(new Font("Dialog", Font.BOLD, 30));
        add(btn_suma);
        btn_suma.addActionListener(this);

        btn_resta = new JButton("-");
        btn_resta.setBounds(180, 150, 60, 60);
        btn_resta.setFont(new Font("Dialog", Font.BOLD, 30));
        btn_resta.addActionListener(this);
        add(btn_resta);
        
        btn_limpiar = new JButton("C");
        btn_limpiar.setBounds(280, 150, 60, 60);
        btn_limpiar.setFont(new Font("Dialog", Font.BOLD, 30));
        btn_limpiar.addActionListener(this);
        add(btn_limpiar);

        btn_multiplicacion = new JButton("*");
        btn_multiplicacion.setBounds(80, 300, 60, 60);
        btn_multiplicacion.setFont(new Font("Dialog", Font.BOLD, 30));
        btn_multiplicacion.addActionListener(this);
        add(btn_multiplicacion);

        btn_division = new JButton("/");
        btn_division.setBounds(180, 300, 60, 60);
        btn_division.setFont(new Font("Dialog", Font.BOLD, 30));
        btn_division.addActionListener(this);
        add(btn_division);

        btn_igual = new JButton("=");
        btn_igual.setBounds(280, 300, 60, 60);
        btn_igual.setFont(new Font("Dialog", Font.BOLD, 30));
        btn_igual.addActionListener(this);
        add(btn_igual);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn_suma) {
            txt_signo.setText("+");
        } else if (e.getSource() == this.btn_resta) {
            txt_signo.setText("-");
        } else if (e.getSource() == this.btn_multiplicacion) {
            txt_signo.setText("*");
        } else if (e.getSource() == this.btn_division) {
            txt_signo.setText("/");
        } else if (e.getSource() == this.btn_igual) {
            if (txt_signo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe de seleccionar una operacion", "Error", 0);
                txt_primer_numero.requestFocus();
            }
            calcular();
        } else if (e.getSource() == this.btn_limpiar) {
            txt_primer_numero.setText("");
            txt_segundo_numero.setText("");
            txt_signo.setText("");
            txt_resultado.setText("");
            txt_primer_numero.requestFocus();
        }
    }

    public void calcular() {
        double resultado;
        try {
            if (txt_signo.getText().equals("+")) {
                resultado = Double.parseDouble(txt_primer_numero.getText()) + Integer.parseInt(txt_segundo_numero.getText());
                txt_resultado.setText("" + resultado);
            } else if (txt_signo.getText().equals("-")) {
                resultado = Double.parseDouble(txt_primer_numero.getText()) - Integer.parseInt(txt_segundo_numero.getText());
                txt_resultado.setText("" + resultado);
            } else if (txt_signo.getText().equals("*")) {
                resultado = Double.parseDouble(txt_primer_numero.getText()) * Integer.parseInt(txt_segundo_numero.getText());
                txt_resultado.setText("" + resultado);
            } else if (txt_signo.getText().equals("/")) {
                try {
                    DecimalFormat formato = new DecimalFormat("0.00");
                    resultado = Double.parseDouble(txt_primer_numero.getText()) / Integer.parseInt(txt_segundo_numero.getText());
                    txt_resultado.setText(formato.format(resultado));
                    //txt_resultado.setText("%.2f" + resultado);
                } catch (ArithmeticException ae) {
                    JOptionPane.showMessageDialog(null, "La division entre cero no esta definida", "Error", 0);
                    txt_segundo_numero.setText("");
                    txt_segundo_numero.requestFocus();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar unicamente numeros", "Error", 0);
            txt_primer_numero.setText("");
            txt_signo.setText("");
            txt_segundo_numero.setText("");
            txt_primer_numero.requestFocus();
        }
    }
}
