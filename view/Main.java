package project.view;

import java.awt.*;
import javax.swing.*;

import java.sql.*;

import project.control.DatabaseConnection;
import project.model.Image;
import project.view.admin.*;
import project.view.giangvien.*;
import project.view.phongql.*;

public class Main {

	private JFrame frame;
	private DangNhapPanel dangNhapPanel;
	private TuyChonAdminPanel tuyChonAdminPanel;
	private TuyChonGVPanel tuyChonGVPanel;
	//private ThongTinCaNhanGVPanel thongTinCaNhanGVPanel;
	private TuyChonPhongQLPanel tuyChonPhongQLPanel;
	private ChinhSuaThongTinGVPanel chinhSuaThongTinGVPanel;
	private DatabaseConnection databaseConnection;
	private static Connection connection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame("Quản lý đề tài");
		frame.setSize(800, 500);
		frame.setIconImage(Image.ICON.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		databaseConnection = new DatabaseConnection();
		setConnection(databaseConnection.getConnection());
		
				
		dangNhapPanel =new DangNhapPanel();
		frame.getContentPane().add(dangNhapPanel);
		
		tuyChonAdminPanel =new TuyChonAdminPanel();
		tuyChonAdminPanel.show(false);
		frame.getContentPane().add(tuyChonAdminPanel);
		
		tuyChonGVPanel = new TuyChonGVPanel();
		tuyChonGVPanel.show(false);
		frame.getContentPane().add(tuyChonGVPanel);
		
//		thongTinCaNhanGVPanel =new ThongTinCaNhanGVPanel();
//		thongTinCaNhanGVPanel.show(false);
//		frame.getContentPane().add(thongTinCaNhanGVPanel);
		
		tuyChonPhongQLPanel = new TuyChonPhongQLPanel();
		tuyChonPhongQLPanel.show(false);
		frame.getContentPane().add(tuyChonPhongQLPanel);
		
		chinhSuaThongTinGVPanel = new ChinhSuaThongTinGVPanel();
		chinhSuaThongTinGVPanel.show(false);
		frame.getContentPane().add(chinhSuaThongTinGVPanel);
		
		
		dangNhapPanel.setTuyChonAdminPanel(this.tuyChonAdminPanel);
		dangNhapPanel.setTuyChonGVPanel(this.tuyChonGVPanel);
		dangNhapPanel.setTuyChonPhongQLPanel(this.tuyChonPhongQLPanel);
		tuyChonAdminPanel.setDangNhapPanel(this.dangNhapPanel);
		tuyChonGVPanel.setDangNhapPanel(this.dangNhapPanel);
		//tuyChonGVPanel.setThongTinCaNhanGVPanel(this.thongTinCaNhanGVPanel);
		tuyChonGVPanel.setChinhSuaThongTinGVPanel(this.chinhSuaThongTinGVPanel);
		//thongTinCaNhanGVPanel.setTuyChonGVPanel(this.tuyChonGVPanel);
		chinhSuaThongTinGVPanel.setTuyChonGVPanel(tuyChonGVPanel);
		tuyChonPhongQLPanel.setDangNhapPanel(this.dangNhapPanel);
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		Main.connection = connection;
	}
}
