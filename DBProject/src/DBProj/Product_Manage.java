package DBProj;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Product_Manage extends JFrame implements ActionListener {
	
	JPanel p;
	JTextField tfProduct_ID, tfProduct_Name, tfPrice;
	JButton btnInsert, btnCancel, btnUpdate, btnDelete;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Product_List pList;
	
	public Product_Manage() {
		createUI();
		btnUpdate.setEnabled(false);
	    btnUpdate.setVisible(false);
	    btnDelete.setEnabled(false);
	    btnDelete.setVisible(false);
	}
	
	public Product_Manage(Product_List pList) {
		createUI();
		btnUpdate.setEnabled(false);
	    btnUpdate.setVisible(false);
	    btnDelete.setEnabled(false);
	    btnDelete.setVisible(false);
	    this.pList = pList;
	}
	
	public Product_Manage(String id, Product_List pList) {
		createUI();
		btnInsert.setEnabled(false);
        btnInsert.setVisible(false);
        this.pList = pList;
        
        ProductDB PDB = new ProductDB();
        ProductDBdata modifyProduct = PDB.getProductDBdata(id);
        viewData(modifyProduct);
        
	}
	
	private void viewData(ProductDBdata modifyProduct) {
		String pID = modifyProduct.getpID();
		String pName = modifyProduct.getpName();
		String pLocation = modifyProduct.getpPrice();
		
		tfProduct_ID.setText(pID);
		tfProduct_ID.setEditable(false);
		tfProduct_Name.setText(pName);
		tfPrice.setText(pLocation); 
	}
	
	private void createUI() {
		this.setTitle("Product Information");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        JLabel bID = new JLabel("Product ID: ");
        tfProduct_ID = new JTextField(20);
        gbAdd(bID, 0, 0, 1, 1);
        gbAdd(tfProduct_ID, 1, 0, 3, 1);
        
        JLabel bName = new JLabel("Product Name: ");
        tfProduct_Name = new JTextField(20);
        gbAdd(bName, 0, 1, 1, 1);
        gbAdd(tfProduct_Name, 1, 1, 3, 1);
        
        JLabel bLocation = new JLabel("Product Price: ");
        tfPrice= new JTextField(20);
        gbAdd(bLocation, 0, 2, 1, 1);
        gbAdd(tfPrice, 1, 2, 3, 1);
        
        JPanel pButton = new JPanel();
        btnInsert = new JButton("등록");
        btnUpdate = new JButton("수정"); 
        btnDelete = new JButton("삭제");
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
		new Product_Manage();
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnInsert){
            insertProduct();
        }
		else if(ae.getSource() == btnCancel){
            this.dispose();          
        }
		else if(ae.getSource() == btnUpdate){
            UpdateProduct();            
        }
		else if(ae.getSource() == btnDelete){
            int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
           
            if (x == JOptionPane.OK_OPTION){
                deleteProduct();
            }else{
                JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
            }
        }
		
		pList.jTableRefresh();
		
	}
	
	private void deleteProduct() {
		String ID = tfProduct_ID.getText();
		ProductDB PDB = new ProductDB();
		boolean OK = PDB.deleteProduct(ID);
		
		if(OK) {
			JOptionPane.showMessageDialog(this, "삭제완료");
            dispose();
		}
		else{
			JOptionPane.showMessageDialog(this, "삭제실패");
		}
	}
	
	private void UpdateProduct() {
		ProductDBdata PDBd = getViewData();
		ProductDB PDB = new ProductDB();
		boolean OK = PDB.UpdateProduct(PDBd);
		
		if(OK){ 
            JOptionPane.showMessageDialog(this, "수정되었습니다");
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요\"");
        }
	}
	
	private void insertProduct() {
		ProductDBdata PDBd = getViewData();
		ProductDB PDB = new ProductDB();
		boolean OK = PDB.insertProduct(PDBd);
		
		if(OK){
            JOptionPane.showMessageDialog(this, "물품등록이 완료되었습니다.");
            dispose();
           
        }else{
            JOptionPane.showMessageDialog(this, "물품등록이 정상적으로 처리되지 않았습니다.");
        }
	}
	
	public ProductDBdata getViewData() {
		ProductDBdata PDBd = new ProductDBdata();
		String ID = tfProduct_ID.getText();
		String Name = tfProduct_Name.getText();
		String Price = tfPrice.getText();
		
		PDBd.setpID(ID);
		PDBd.setpName(Name);
		PDBd.setpPrice(Price);

		return PDBd;
	}
    

}
