package DBProj;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Product_Manage extends JFrame implements ActionListener {
	
	JPanel p;
	JTextField tfProduct_ID, tfProduct_Name, tfPrice;
	JButton btnInsert, btnCancel, btnUpdate, btnDelete;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Franchising_List fList;
	
	public Product_Manage() {
		createUI();
		btnUpdate.setEnabled(false);
	    btnUpdate.setVisible(false);
	    btnDelete.setEnabled(false);
	    btnDelete.setVisible(false);
	}

	public Product_Manage(String id, Franchising_List fList) {
		createUI();
		btnInsert.setEnabled(false);
        btnInsert.setVisible(false);
        this.fList = fList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
        btnInsert = new JButton("µî·Ï");
        btnUpdate = new JButton("¼öÁ¤"); 
        btnDelete = new JButton("Å»Åð");
        btnCancel = new JButton("Ãë¼Ò");     
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
