package project.view.giangvien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import project.control.ChiKhacControl;
import project.model.DeTai;

import java.awt.event.*;
import java.util.Vector;

public class DanhSachChiPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaDeTai;
	private JLabel lblMaDeTai;
	private JTable tbDanhSachChi;	
	private JButton btnTroVe;
	private DeTaiCaNhanPanel deTaiCaNhanPanel;
	@SuppressWarnings("unused")
	private DeTai deTai;

	/**
	 * Launch the application.
	 */

	public DanhSachChiPanel() {
		setBounds(70, 40, 300, 400);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		lblMaDeTai = new JLabel("M\u00E3 \u0111\u1EC1 t\u00E0i");
		lblMaDeTai.setBounds(10, 51, 75, 14);
		add(lblMaDeTai);

		txtMaDeTai = new JTextField();
		txtMaDeTai.setBounds(95, 48, 86, 20);
		txtMaDeTai.setEditable(false);
		add(txtMaDeTai);
		txtMaDeTai.setColumns(10);		
			
		tbDanhSachChi = new JTable();		
		tbDanhSachChi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			       int index=tbDanhSachChi.getSelectedRow(); 
			       System.out.println(tbDanhSachChi.getValueAt(index,1));   
			}
		});
		tbDanhSachChi.setBounds(10, 136, 280, 108);
		add(tbDanhSachChi);
		
		btnTroVe = new JButton("Trở về");
		btnTroVe.setBounds(108, 312, 89, 23);
		btnTroVe.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				deTaiCaNhanPanel.show();
				show(false);
			}
		});
		add(btnTroVe);
		
		JScrollPane scrollPane = new JScrollPane(tbDanhSachChi);
		scrollPane.setBounds(10, 104, 280, 184);
		tbDanhSachChi.setFillsViewportHeight(true);
		add(scrollPane);
	}

	public void setDeTaiCaNhanPanel(DeTaiCaNhanPanel deTaiCaNhanPanel) {
		this.deTaiCaNhanPanel = deTaiCaNhanPanel;
	}
	
	public void setDeTai(DeTai deTai) {
		this.deTai = deTai;
		Vector<Object> data = ChiKhacControl.loadDanhSachChi(deTai);
		Vector<String> columns = new Vector<String>();
		columns.addElement("Mã chi");
		columns.addElement("Lý do");
		columns.addElement("Số tiền");
		columns.addElement("Tình trạng");
		this.tbDanhSachChi.setModel(new DefaultTableModel(data, columns));
		this.txtMaDeTai.setText(deTai.getMaDeTai());
	}
}
