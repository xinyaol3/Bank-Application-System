package GUI;

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

import javax.swing.JTextField;
import javax.swing.JButton;
import server.*;
public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private String email;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create new Account");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(292, 55, 260, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(67, 139, 115, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Middle Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(67, 201, 115, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(67, 262, 115, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(67, 311, 115, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(67, 359, 115, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(67, 406, 115, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Salary");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(67, 456, 115, 33);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Emaill");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(67, 503, 115, 33);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Phone");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(67, 550, 115, 33);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField(); //First Name
		textField.setBounds(204, 145, 236, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(); //Middle Name
		textField_1.setBounds(204, 207, 236, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();//Last Name
		textField_2.setBounds(204, 268, 236, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(); //ID
		textField_3.setBounds(204, 315, 236, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();// Gender
		textField_4.setBounds(204, 359, 236, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(); //Age
		textField_5.setBounds(204, 406, 236, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField(); // Salary
		textField_6.setBounds(204, 462, 236, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("/month"); 
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(457, 456, 115, 33);
		contentPane.add(lblNewLabel_10);
		
		textField_7 = new JTextField(); //email
		textField_7.setBounds(204, 509, 236, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();//phone
		textField_8.setBounds(204, 550, 236, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerDataBase db = new CustomerDataBase();
				PersonalInfo pi = new PersonalInfo();
				Registration rg = new Registration();
				email = textField_7.getText();
			    if(rg.emailExist(email)) {
			    	JOptionPane.showMessageDialog(btnNewButton,"This email already exist");
			    }
			    else {
			    	pi.setFirstName(textField.getText());
			    	pi.setMiddleName(textField_1.getText());
			    	pi.setLastName(textField_2.getText());
			    	pi.setIdentity(textField_3.getText());
			    	pi.setGender(textField_4.getText().charAt(0));
			    	pi.setAge(Integer.parseInt(textField_5.getText()));
			    	pi.setSalary(Integer.parseInt(textField_6.getText()));
			    	pi.setEmail(email);
			    	pi.setPhone(textField_8.getText());
			    	db.setInfo(pi);
			    	CreateAccount1 ca1 = new CreateAccount1();
			    	ca1.setVisible(true);
			    	dispose();
			    }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnNewButton.setBounds(618, 593, 171, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("Male(M)/Female(F)");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(466, 355, 161, 33);
		contentPane.add(lblNewLabel_11);
	}
	public String getEmail() {
		return email;
	}
}
