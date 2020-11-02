package GUI;
import server.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bank of Aaron");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(276, 43, 192, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(90, 123, 115, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(90, 183, 115, 33);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(207, 130, 302, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 190, 302, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("login in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				String password = passwordField.getText();
				Registration rg = new Registration();
				if(rg.usernameExist(username)&&rg.passwordCorrectness(username, password)) {
					MainPage mp = new MainPage(username,0,0);
					mp.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton,"Invaild Username or Password");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(282, 287, 151, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New User?");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		        CreateAccount ca = new CreateAccount();
		        ca.setVisible(true);
		        dispose();
		      }
		    });
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(203, 233, 115, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Forget Password");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		        ResetPassword reset = new ResetPassword();
		        reset.setVisible(true);
		        dispose();
		      }
		    });
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(387, 233, 143, 33);
		contentPane.add(lblNewLabel_4);
	}
}
