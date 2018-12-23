package DBProj;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Franchising_List extends JFrame implements MouseListener, ActionListener{
	Vector f;  
    Vector cols;
    DefaultTableModel model;
    JTable jTable;
    JScrollPane pane;
    JPanel pbtn;
    JButton btnInsert, btnProduct;
    
    public Franchising_List() {
    	super("Franchising Manage System");
    	FranchisingDB FDB = new FranchisingDB();
    	f = FDB.getFranchisingList();
    	cols = getColumn();
    	
    	model =  new DefaultTableModel(f, cols);
    	
    	jTable = new JTable(model);
        pane = new JScrollPane(jTable);
        add(pane);
         
        pbtn = new JPanel();
        btnInsert = new JButton("가맹점 등록");
        pbtn.add(btnInsert);
        add(pbtn, BorderLayout.NORTH);
        
        pbtn = new JPanel();
        btnProduct = new JButton("물품관리");
        pbtn.add(btnProduct);
        add(pbtn, BorderLayout.WEST);
         
        jTable.addMouseListener(this);
        btnInsert.addActionListener(this);
        btnProduct.addActionListener(this);
          
        setSize(1000,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Vector getColumn() {
    	Vector col = new Vector();
    	col.add("Franchising_ID");
    	col.add("Franchising_Name");
    	col.add("Franchising_Location");
    	col.add("Franchising_Office_Hours");
    	col.add("Franchising_Number");
    	col.add("Franchising_Performance");
    	
    	return col;
    }
    
    public void jTableRefresh() {
    	FranchisingDB FDB = new FranchisingDB();
    	DefaultTableModel model = new  DefaultTableModel(FDB.getFranchisingList(), getColumn());
    	jTable.setModel(model);
    }
    
    public static void main(String[] args) {
        new Franchising_List();
    }
     
	@Override
	public void mouseClicked(MouseEvent e) {
		int r = jTable.getSelectedRow();
		String id = (String) jTable.getValueAt(r, 0);
		System.out.println("id = " + id);
		ManageSystem franchising = new ManageSystem(id, this);
			
	} 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInsert) {
			new ManageSystem(this);
		}
		else if(e.getSource() == btnProduct) {
			new Product_List();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
