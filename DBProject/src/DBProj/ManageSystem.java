package DBProj;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class ManageSystem extends JFrame implements ActionListener {
	
	JPanel p;
	JTextField tfFranchising_ID, tfFranchising_Name, tfFranchsing_Location, tfFranchsing_Office_Hours, tfPerformance;
	JTextField tfFranchsing_Number1, tfFranchsing_Number2, tfFranchsing_Number3; 
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; //가입, 취소, 수정 , 탈퇴 버튼
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Franchising_List fList;
	
	public ManageSystem() {
		createUI();
	    btnUpdate.setEnabled(false);
	    btnUpdate.setVisible(false);
	    btnDelete.setEnabled(false);
	    btnDelete.setVisible(false);
	}
	
	public ManageSystem(Franchising_List fList) {
		createUI();
		btnUpdate.setEnabled(false);
	    btnUpdate.setVisible(false);
	    btnDelete.setEnabled(false);
	    btnDelete.setVisible(false);
	    this.fList = fList;
	}
	
	public ManageSystem(String id, Franchising_List fList) {
		createUI();
		btnInsert.setEnabled(false);
        btnInsert.setVisible(false);
        this.fList = fList;
        
        FranchisingDB FDB = new FranchisingDB();
	    FranchisingDBdata modifyFranchising = FDB.getFranchisingDBdata(id);
	    viewData(modifyFranchising);
	}
	
	private void viewData(FranchisingDBdata modifyFranchising) {
		String fID = modifyFranchising.getfID();
		String fName = modifyFranchising.getfName();
		String fLocation = modifyFranchising.getfLocation();
		String fOffice_Hours = modifyFranchising.getfOffice_Hours();
		String fNumber = modifyFranchising.getfNumber();
		String fPerformance = modifyFranchising.getfPerformance();
		
		tfFranchising_ID.setText(fID);
		tfFranchising_ID.setEditable(false);
		tfFranchising_Name.setText(fName);
		String[] tels = fNumber.split("-");
		tfFranchsing_Number1.setText(tels[0]);
		tfFranchsing_Number2.setText(tels[1]);
		tfFranchsing_Number3.setText(tels[2]);
		tfFranchsing_Location.setText(fLocation); 
		tfFranchsing_Office_Hours.setText(fOffice_Hours);
		tfPerformance.setText(fPerformance);
	}
	
	private void createUI() {
		this.setTitle("Franchising Information");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        JLabel bID = new JLabel("Franchising ID: ");
        tfFranchising_ID = new JTextField(20);
        gbAdd(bID, 0, 0, 1, 1);
        gbAdd(tfFranchising_ID, 1, 0, 3, 1);
        
        JLabel bName = new JLabel("Franchising Name: ");
        tfFranchising_Name = new JTextField(20);
        gbAdd(bName, 0, 1, 1, 1);
        gbAdd(tfFranchising_Name, 1, 1, 3, 1);
        
        JLabel bLocation = new JLabel("Franchising Location: ");
        tfFranchsing_Location = new JTextField(20);
        gbAdd(bLocation, 0, 2, 1, 1);
        gbAdd(tfFranchsing_Location, 1, 2, 3, 1);
        
        JLabel bOffice_Hours = new JLabel("Franchising Office Hours: ");
        tfFranchsing_Office_Hours = new JTextField(20);
        gbAdd(bOffice_Hours, 0, 3, 1, 1);
        gbAdd(tfFranchsing_Office_Hours, 1, 3, 3, 1);
        
        JLabel bNumber = new JLabel("Franchising number: ");
        JPanel pNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tfFranchsing_Number1 = new JTextField(6);    
        tfFranchsing_Number2 = new JTextField(6);    
        tfFranchsing_Number3 = new JTextField(6);
        pNumber.add(tfFranchsing_Number1);
        pNumber.add(new JLabel(" - "));
        pNumber.add(tfFranchsing_Number2);
        pNumber.add(new JLabel(" - "));
        pNumber.add(tfFranchsing_Number3);
        gbAdd(bNumber, 0, 4, 1, 1);
        gbAdd(pNumber, 1, 4, 3, 1);
        
        JLabel bPerformance = new JLabel("Franchising Performance: ");
        tfPerformance = new JTextField(20);
        gbAdd(bPerformance, 0, 5, 1, 1);
        gbAdd(tfPerformance, 1, 5, 3, 1);
        
        JPanel pButton = new JPanel();
        btnInsert = new JButton("등록");
        btnUpdate = new JButton("수정"); 
        btnDelete = new JButton("탈퇴");
        btnCancel = new JButton("취소");     
        pButton.add(btnInsert);
        pButton.add(btnUpdate);
        pButton.add(btnDelete);
        pButton.add(btnCancel); 
        gbAdd(pButton, 0, 6, 4, 1);

        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);
        btnDelete.addActionListener(this);
       
        setSize(600,400);
        setVisible(true);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
    private void gbAdd(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gb.setConstraints(c, gbc);
        gbc.insets = new Insets(2, 2, 2, 2);
        add(c, gbc);
    }

	
	public static void main(String[] args) {
		new ManageSystem();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnInsert){
            insertFranchising();
        }
		else if(ae.getSource() == btnCancel){
            this.dispose();          
        }
		else if(ae.getSource() == btnUpdate){
            UpdateFranchising();            
        }
		else if(ae.getSource() == btnDelete){
            int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
           
            if (x == JOptionPane.OK_OPTION){
                deleteFranchising();
            }else{
                JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
            }
        }
		
		fList.jTableRefresh();
	}
	
	private void deleteFranchising() {
		String ID = tfFranchising_ID.getText();
		
		FranchisingDB FDB = new FranchisingDB();
		boolean OK = FDB.deleteFranchising(ID);
		
		if(OK) {
			JOptionPane.showMessageDialog(this, "삭제완료");
            dispose();
		}
		else{
			JOptionPane.showMessageDialog(this, "삭제실패");
		}
	}
	
	private void UpdateFranchising() {
		FranchisingDBdata FDBd = getViewData();
		FranchisingDB FDB = new FranchisingDB();
		boolean OK = FDB.UpdateFranchising(FDBd);
		
		if(OK){ 
            JOptionPane.showMessageDialog(this, "수정되었습니다");
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요\"");
        }
	}
	
	private void insertFranchising() {
		FranchisingDBdata FDBd = getViewData();
		FranchisingDB FDB = new FranchisingDB();
		boolean OK = FDB.insertFranchising(FDBd);
		
		if(OK){
            JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
            dispose();
           
        }else{
            JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
        }
	}
	
	public FranchisingDBdata getViewData() {
		FranchisingDBdata FDBd = new FranchisingDBdata();
		String ID = tfFranchising_ID.getText();
		String Name = tfFranchising_Name.getText();
		String tel1 = tfFranchsing_Number1.getText();
		String tel2 = tfFranchsing_Number2.getText();
		String tel3 = tfFranchsing_Number3.getText();
		String tel = tel1+"-"+tel2+"-"+tel3;
		String Location = tfFranchsing_Location.getText();
		String Office_Hours = tfFranchsing_Office_Hours.getText();
		String Performance = tfPerformance.getText();
		
		FDBd.setfID(ID);
		FDBd.setfName(Name);
		FDBd.setfNumber(tel);
		FDBd.setfLocation(Location);
		FDBd.setfOffice_Hours(Office_Hours);
		FDBd.setfPerformance(Performance);
		
		return FDBd;
	}

}
