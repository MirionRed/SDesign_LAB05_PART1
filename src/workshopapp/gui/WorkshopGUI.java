package workshopapp.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import workshopapp.domain.*;

public class WorkshopGUI extends JFrame implements ActionListener{
	WorkshopList workshopList;
	
	private JLabel lblWorkshopName;
	private JLabel lblWorkshopDate;
	private JLabel lblParticipantName;
	private JLabel lblParticipantIC;
	
	private JTextField tfdWorkshopName;
	private JTextField tfdWorkshopDate;
	private JTextField tfdParticipantName;
	private JTextField tfdParticipantIC;
	
	private JButton btnFindWorkshop;
	private JButton btnAddNewWorkshop;
	private JButton btnRegisterParticipant;
	
	protected WorkshopGUI(){
		workshopList = new WorkshopList();
		
		lblWorkshopName = new JLabel("Workshop Name: ");
		lblWorkshopDate = new JLabel("Workshop Date: ");
		lblParticipantName = new JLabel("Participant Name: ");
		lblParticipantIC = new JLabel("Participant IC No.: ");
		
		tfdWorkshopName = new JTextField(10);
		tfdWorkshopDate = new JTextField(10);
		tfdParticipantName = new JTextField(10);
		tfdParticipantIC = new JTextField(10);
		
		btnFindWorkshop = new JButton("Find Workshop");
		btnAddNewWorkshop = new JButton("Add New Workshop");
		btnRegisterParticipant = new JButton("Register Participant");
		
		JPanel content = new JPanel();
		GroupLayout layout = new GroupLayout(content);
		content.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.LEADING)
						.addComponent(lblWorkshopName)
						.addComponent(lblWorkshopDate)
						.addComponent(lblParticipantName)
						.addComponent(lblParticipantIC))
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.LEADING)
						.addComponent(tfdWorkshopName)
						.addComponent(tfdWorkshopDate)
						.addComponent(btnAddNewWorkshop)
						.addComponent(tfdParticipantName)
						.addComponent(tfdParticipantIC))
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.LEADING)
						.addComponent(btnFindWorkshop)
						.addComponent(btnRegisterParticipant))
				);
		layout.linkSize(SwingConstants.HORIZONTAL, btnFindWorkshop, btnAddNewWorkshop, btnRegisterParticipant);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.BASELINE)
						.addComponent(lblWorkshopName)
						.addComponent(tfdWorkshopName)
						.addComponent(btnFindWorkshop))
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.BASELINE)
						.addComponent(lblWorkshopDate)
						.addComponent(tfdWorkshopDate))
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.BASELINE)
						.addComponent(btnAddNewWorkshop))
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.BASELINE)
						.addComponent(lblParticipantName)
						.addComponent(tfdParticipantName)
						.addComponent(btnRegisterParticipant))
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.BASELINE)
						.addComponent(lblParticipantIC)
						.addComponent(tfdParticipantIC))
				);
		
		btnAddNewWorkshop.addActionListener(this);
		btnFindWorkshop.addActionListener(this);
		btnRegisterParticipant.addActionListener(this);
		
		this.setContentPane(content);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Workshop Application");
		this.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == btnAddNewWorkshop){
			String wName = tfdWorkshopName.getText();
			String wDate = tfdWorkshopDate.getText();
			workshopList.addWorkshop(wName, wDate);
			JOptionPane.showMessageDialog(this, "Workshop added");
		} else if (event.getSource() == btnFindWorkshop){
			String wName = tfdWorkshopName.getText();
			if(workshopList.isEmpty()){
				JOptionPane.showMessageDialog(this, "Workshop list is empty");
			} else {
				tfdWorkshopDate.setText(workshopList.findWorkshop(wName).getWDate());
				if(tfdWorkshopDate.getText() == ""){
					JOptionPane.showMessageDialog(this, "Workshop not found");
				}
			}
		} else if (event.getSource() == btnRegisterParticipant){
			String pName = tfdParticipantName.getText();
			String pIC = tfdParticipantIC.getText();
			String wName = tfdWorkshopName.getText();
			workshopList.registerParticipant(pName, pIC, wName);
			
			if (workshopList.findParticipant(wName, pName) == null){
				JOptionPane.showMessageDialog(this, "Participant not found");
			} else {
				JOptionPane.showMessageDialog(this,workshopList.findParticipant(wName, pName).getName() + " has been registered");
			}
		} else {
			
		}
	}
	
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					WorkshopGUI frame = new WorkshopGUI();
					frame.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
