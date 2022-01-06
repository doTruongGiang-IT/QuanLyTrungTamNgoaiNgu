package GUI;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.ExaminationBUS;
import BUS.SupervisorBUS;
import DTO.ExaminationDTO;
import DTO.SupervisorDTO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class SupervisorPanel extends JPanel {
	private JTable tableSupervisor;
	private JTextField textSupervisorName;
	private JTextField textSearch;
	private JTextField textSupervisorId;
	private JButton btnChange;
	private JButton btnDelete;
	public SupervisorBUS supervisorBus;

	/**
	 * Create the panel.
	 */
	public SupervisorPanel() {
		setMaximumSize(new Dimension(1039, 763));
		setLayout(new CardLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		add(panelContent, "name_452838340029000");
		panelContent.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panelContent.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{80, 0, 130, 0};
		gbl_panel_3.rowHeights = new int[]{50, 50, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Supervisor Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		textSupervisorId = new JTextField();
		textSupervisorId.setEditable(false);
		GridBagConstraints gbc_textSupervisorId = new GridBagConstraints();
		gbc_textSupervisorId.insets = new Insets(0, 0, 5, 5);
		gbc_textSupervisorId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSupervisorId.gridx = 1;
		gbc_textSupervisorId.gridy = 0;
		panel_3.add(textSupervisorId, gbc_textSupervisorId);
		textSupervisorId.setColumns(10);
		
		JLabel lblSupervisorName = new JLabel("Supervisor Name");
		lblSupervisorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSupervisorName = new GridBagConstraints();
		gbc_lblSupervisorName.weightx = 0.3;
		gbc_lblSupervisorName.anchor = GridBagConstraints.WEST;
		gbc_lblSupervisorName.insets = new Insets(0, 0, 0, 5);
		gbc_lblSupervisorName.gridx = 0;
		gbc_lblSupervisorName.gridy = 1;
		panel_3.add(lblSupervisorName, gbc_lblSupervisorName);
		
		textSupervisorName = new JTextField();
		textSupervisorName.setColumns(10);
		GridBagConstraints gbc_textSupervisorName = new GridBagConstraints();
		gbc_textSupervisorName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSupervisorName.insets = new Insets(0, 0, 0, 5);
		gbc_textSupervisorName.gridx = 1;
		gbc_textSupervisorName.gridy = 1;
		panel_3.add(textSupervisorName, gbc_textSupervisorName);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 10, 0, 0));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textSupervisorName.getText();
				if ( name == null || name.equals("")) {
					JOptionPane.showMessageDialog(getParent(), "New Supervisor name must not be null");
				}
				else {
					addSupervisor(name);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnAdd);
		
		btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnChange);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnDelete);
		
		JButton btnViewRoom = new JButton("View Room");
		btnViewRoom.setVisible(false);
		btnViewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnViewRoom);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{256, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{21, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		textSearch = new JTextField();
		textSearch.setHorizontalAlignment(SwingConstants.LEFT);
		textSearch.setColumns(10);
		GridBagConstraints gbc_textSearch = new GridBagConstraints();
		gbc_textSearch.fill = GridBagConstraints.BOTH;
		gbc_textSearch.anchor = GridBagConstraints.WEST;
		gbc_textSearch.gridwidth = 2;
		gbc_textSearch.insets = new Insets(0, 0, 0, 5);
		gbc_textSearch.gridx = 0;
		gbc_textSearch.gridy = 0;
		panel_6.add(textSearch, gbc_textSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.anchor = GridBagConstraints.WEST;
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 0;
		panel_6.add(btnSearch, gbc_btnSearch);
		
		JButton btnLoad = new JButton("Load data");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.anchor = GridBagConstraints.EAST;
		gbc_btnLoad.gridx = 14;
		gbc_btnLoad.gridy = 0;
		panel_6.add(btnLoad, gbc_btnLoad);
		
		JPanel panel = new JPanel();
		panelContent.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tableSupervisor = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
                return false;               
			};
		};
		scrollPane.setViewportView(tableSupervisor);

		onLoad();
	}
	
	public void addSupervisor(String name) {
		supervisorBus = new SupervisorBUS();
		SupervisorDTO sDto = new SupervisorDTO();
		sDto.setName(name);
		sDto.setId(0);
		supervisorBus.insert(sDto);
	}
	
	public void loadData() {
		List<SupervisorDTO> supervisorList = new ArrayList<SupervisorDTO>();
		Vector<String> vctHeader = new Vector<String>();
		vctHeader.add("Id");
		vctHeader.add("Name");
		Vector vctData = new Vector<>();
		supervisorBus = new SupervisorBUS();
		supervisorList = supervisorBus.getSupervisors();
		for (SupervisorDTO supervisorDTO : supervisorList) {
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(supervisorDTO.getId()));
			row.add(supervisorDTO.getName());
			vctData.add(row);
			System.out.println(supervisorDTO.toJSONObject().toString());
		}
		tableSupervisor.setModel(new DefaultTableModel(vctData, vctHeader));
	}
	
	public void onLoad() {
		if (textSupervisorName.getText().equals("") || textSupervisorName.getText() == null) {
			this.btnChange.setEnabled(false);
			this.btnDelete.setEnabled(false);
		}
	}
}
