package project.view.phongql;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TimKiemDeTaiPanel extends JPanel {

	/**
	 * 
	 */
	private JTextField txtTimKiem;

	public TimKiemDeTaiPanel() {
		setBounds(70, 40, 300, 400);
		setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(10, 11, 280, 25);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimKiem.setBounds(35, 155, 88, 23);
		add(btnTimKiem);
		
		JButton btnTroVe = new JButton("Tr\u1EDF v\u1EC1");
		btnTroVe.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				show(false);
			}
		});
		btnTroVe.setBounds(153, 155, 88, 23);
		add(btnTroVe);
		
		JLabel lblTimKiemTheo = new JLabel("T\u00ECm ki\u1EBFm theo");
		lblTimKiemTheo.setBounds(10, 74, 97, 14);
		add(lblTimKiemTheo);
		
		JComboBox<String> cbbTuyChonTimKiem = new JComboBox<String>();
		cbbTuyChonTimKiem.setBounds(117, 71, 107, 20);
		DefaultComboBoxModel<String> tuyChonTimKiem = new DefaultComboBoxModel<String>();
		tuyChonTimKiem.addElement("Đề tài");
		tuyChonTimKiem.addElement("Giảng viên");
		tuyChonTimKiem.addElement("Thời điểm phát hành");
		extracted(cbbTuyChonTimKiem, tuyChonTimKiem);
		add(cbbTuyChonTimKiem);
		

	}

	private void extracted(JComboBox<String> cbbTuyChonTimKiem, DefaultComboBoxModel<String> tuyChonTimKiem) {
		cbbTuyChonTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] {"Đề tài", "Giảng viên", "Thời điểm phát hành"}));
	}

	public void reset() {
		// TODO Auto-generated method stub
		txtTimKiem.setText("");
	}
}

