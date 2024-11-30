package com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame{
	JTextField userIdField;
     JPasswordField passwordField;
     JButton loginButton;

    public LoginFrame() {
        setTitle("ATM Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome to ATM Machine!", SwingConstants.CENTER);

        userIdField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        userIdField.setPreferredSize(new Dimension(200, 25));
        passwordField.setPreferredSize(new Dimension(200, 25));
        loginButton.setPreferredSize(new Dimension(80, 30));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(welcomeLabel, c);

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("User ID:"), c);

        c.gridx = 1;
        panel.add(userIdField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Password:"), c);

        c.gridx = 1;
        panel.add(passwordField, c);

        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        panel.add(loginButton, c);

        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String password = new String(passwordField.getPassword());

                if (userId.equals("12345") && password.equals("123")) {
                    setVisible(false);
                    new ATMFrame("User");
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this,
                        "Wrong password or id, please try again!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
