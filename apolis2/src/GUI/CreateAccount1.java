package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.AccRecord;
import server.AccountDataBase;
import server.Bank;
import server.CheckingAcc;
import server.CheckingAccountDataBase;
import server.CustomerDataBase;
import server.PersonalInfo;
import server.Registration;
import server.SavingAcc;
import server.SavingAccountDataBase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CreateAccount1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private String username;
    private String AccountNumber1;
    private String AccountNumber2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount1 frame = new CreateAccount1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateAccount1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create New Account 2");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(263, 28, 272, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter a username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(96, 117, 149, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(273, 122, 236, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Create Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(96, 194, 135, 33);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(283, 200, 226, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(96, 276, 149, 33);
		contentPane.add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(283, 280, 226, 27);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerDataBase db = new CustomerDataBase();
				Registration rg = new Registration();
				PersonalInfo pi = new PersonalInfo();
				username = textField.getText();
				String password = passwordField.getText();
				String password2 = passwordField_1.getText();
				if(password.equals(password2)) {
					rg.setInfo(db, textField.getText(),password);
					AccountDataBase cd = new CheckingAccountDataBase();
				    AccountDataBase sd = new SavingAccountDataBase();
				    AccountNumber1 = ""+(int)(Math.random()*(10000000-1000000)+1)+1000000;
				    while(!cd.containsAccountNumber(AccountNumber1)&&!sd.containsAccountNumber(AccountNumber1)) {
				    	AccountNumber1 = ""+(int)(Math.random()*(10000000-1000000)+1)+1000000;
				    }
				    AccountNumber2 = ""+(int)(Math.random()*(10000000-1000000)+1)+1000000;
				    while(!cd.containsAccountNumber(AccountNumber2)&&!sd.containsAccountNumber(AccountNumber2)) {
				    	AccountNumber2 = ""+(int)(Math.random()*(10000000-1000000)+1)+1000000;
				    }
					AccRecord ars = new AccRecord(AccountNumber1);
					AccRecord arc = new AccRecord(AccountNumber2);
					Bank sa = new SavingAcc(AccountNumber1,pi,sd,ars);
					Bank ch = new CheckingAcc(AccountNumber2,pi,cd,arc);
					JOptionPane.showMessageDialog(btnNewButton,"Your Account has been created");
					login lg = new login();
					lg.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton,"Confirm password is different with password");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnNewButton.setBounds(557, 462, 171, 41);
		contentPane.add(btnNewButton);
	}
	public String getUsername() {
		return username;
	}
	public String getCheckingAccountNum() {
		return AccountNumber1;
	}
	public String getSavingAccountNum() {
		return AccountNumber2;
	}
	
}
