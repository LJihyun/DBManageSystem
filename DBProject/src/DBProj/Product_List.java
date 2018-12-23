package DBProj;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Product_List extends JFrame implements MouseListener, ActionListener{
	
	Vector p;  
    Vector cols;
    DefaultTableModel model;
    JTable jTable;
    JScrollPane pane;
    JPanel pbtn;
    JButton btnInsert, btnOrder;
    
    public Product_List() {
    	super("Product Manage");
    	ProductDB PDB = new ProductDB();
    	p = PDB.getProductList();
    	cols = getColumn();
    	
    	model =  new DefaultTableModel(p, cols);
    	
    	jTable = new JTable(model);
        pane = new JScrollPane(jTable);
        add(pane);
        
        pbtn = new JPanel();
        btnOrder = new JButton("물품등록");
        pbtn.add(btnOrder);
        add(pbtn, BorderLayout.NORTH);
         
        jTable.addMouseListener(this);
        btnOrder.addActionListener(this);
          
        setSize(1000,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Vector getColumn() {
    	Vector col = new Vector();
    	col.add("Product_ID");
    	col.add("Product_Name");
    	col.add("Product_Price");
    	
    	return col;
    }
    
    public void jTableRefresh() {
    	ProductDB PDB = new ProductDB();
    	DefaultTableModel model = new  DefaultTableModel(PDB.getProductList(), getColumn());
    	jTable.setModel(model);
    }

	public static void main(String[] args) {
		new Product_List();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnOrder) {
			new Product_Manage(this);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int r = jTable.getSelectedRow();
		String id = (String) jTable.getValueAt(r, 0);
		System.out.println("id = " + id);
		Product_Manage product = new Product_Manage(id, this);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
