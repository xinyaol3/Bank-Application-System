package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CheckingPage extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckingPage frame = new CheckingPage();
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
	public CheckingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 774);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AccountNumber");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setBounds(340, 52, 197, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(282, 113, 316, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Balance    $");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(100, 206, 136, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(262, 204, 336, 33);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Deposite");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnNewButton.setBounds(65, 352, 171, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Withdraw");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnNewButton_1.setBounds(282, 350, 171, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Transfer");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnNewButton_2.setBounds(508, 350, 171, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Check History");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_3.setBounds(282, 460, 197, 41);
		contentPane.add(btnNewButton_3);
	}
}
