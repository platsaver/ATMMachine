package com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ATMFrame extends JFrame {
    private ATM atm;
    JLabel welcomeLabel;
    JButton viewBalanceButton, withdrawButton, depositButton, viewStatementButton, exitButton;

    public ATMFrame(String username) {
        atm = new ATM();

        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        welcomeLabel = new JLabel("Hello " + username + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        viewBalanceButton = new JButton("View Balance");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        viewStatementButton = new JButton("View Mini Statement");
        exitButton = new JButton("Exit");

        viewBalanceButton.setPreferredSize(new Dimension(100, 30));
        withdrawButton.setPreferredSize(new Dimension(100, 30));
        depositButton.setPreferredSize(new Dimension(100, 30));
        viewStatementButton.setPreferredSize(new Dimension(100, 30));
        exitButton.setPreferredSize(new Dimension(80, 30));

        setLayout(new BorderLayout(10, 10));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.add(viewBalanceButton);
        buttonPanel.add(viewStatementButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);

        add(buttonPanel, BorderLayout.CENTER);

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);

        viewBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ATMFrame.this,
                    "Your available balance: " + atm.getBalance(),
                    "View Balance",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean validAmount = false;
                while (!validAmount) {
                    String amountStr = JOptionPane.showInputDialog(ATMFrame.this, "Enter amount you want to withdraw:");
                    int amount = Integer.parseInt(amountStr);
                    if (amount < 0) {
                        JOptionPane.showMessageDialog(ATMFrame.this,
                            "Invalid amount of funds! Please enter a positive number.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    } else if (amount > atm.getBalance()) {
                        JOptionPane.showMessageDialog(ATMFrame.this,
                            "Insufficient amount of funds! Please try again.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        atm.setWithdraw(amount);
                        atm.setBalance(atm.getBalance() - amount);
                        JOptionPane.showMessageDialog(ATMFrame.this,
                            "Your updated balance: " + atm.getBalance(),
                            "Withdraw",
                            JOptionPane.INFORMATION_MESSAGE);
                        validAmount = true;
                    }
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean validAmount = false;
                while (!validAmount) {
                    String amountStr = JOptionPane.showInputDialog(ATMFrame.this, "Enter amount you want to deposit:");
                    int amount = Integer.parseInt(amountStr);
                    if (amount < 0) {
                        JOptionPane.showMessageDialog(ATMFrame.this,
                            "Invalid amount. Please enter a positive number.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        atm.setDeposit(amount);
                        atm.setBalance(atm.getBalance() + amount);
                        JOptionPane.showMessageDialog(ATMFrame.this,
                            "Your updated balance: " + atm.getBalance(),
                            "Deposit",
                            JOptionPane.INFORMATION_MESSAGE);
                        validAmount = true;
                    }
                }
            }
        });


        viewStatementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ATMFrame.this,
                    "Balance: " + atm.getBalance() +
                    "\nWithdraw Amount: " + atm.getWithdraw() +
                    "\nDeposit Amount: " + atm.getDeposit(),
                    "Mini Statement",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ATMFrame.this,
                    "Thanks for using our service!",
                    "Exit",
                    JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
