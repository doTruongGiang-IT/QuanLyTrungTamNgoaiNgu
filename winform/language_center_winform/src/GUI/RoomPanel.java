package GUI;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.components.JSpinField;

import BUS.RoomBUS;
import DTO.RoomDTO;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RoomPanel extends JPanel {
	private JTable tableRoom;
	private JTextField textRoomName;
	private JTextField textExaminationId;
	private JTextField textRoomLevel;
	private JTextField textField_3;
	private JTextField textRoomId;
	private JComboBox comboBoxRoomTime;
	private JButton btnChange;

	/**
	 * Create the panel.
	 */
	public RoomPanel() {
		setMaximumSize(new Dimension(1039, 763));
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_455268586571900");
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{80, 0, 130, 0};
		gbl_panel_3.rowHeights = new int[] {35, 35, 35, 35, 30};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblCandidateIdentification_1_1 = new JLabel("Room Id");
		lblCandidateIdentification_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCandidateIdentification_1_1 = new GridBagConstraints();
		gbc_lblCandidateIdentification_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblCandidateIdentification_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCandidateIdentification_1_1.gridx = 0;
		gbc_lblCandidateIdentification_1_1.gridy = 0;
		panel_3.add(lblCandidateIdentification_1_1, gbc_lblCandidateIdentification_1_1);
		
		textRoomId = new JTextField();
		textRoomId.setEditable(false);
		textRoomId.setColumns(10);
		GridBagConstraints gbc_textRoomId = new GridBagConstraints();
		gbc_textRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_textRoomId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRoomId.gridx = 1;
		gbc_textRoomId.gridy = 0;
		panel_3.add(textRoomId, gbc_textRoomId);
		
		JLabel lblSupervisorName = new JLabel("Room Name");
		lblSupervisorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSupervisorName = new GridBagConstraints();
		gbc_lblSupervisorName.weightx = 0.3;
		gbc_lblSupervisorName.anchor = GridBagConstraints.WEST;
		gbc_lblSupervisorName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupervisorName.gridx = 0;
		gbc_lblSupervisorName.gridy = 1;
		panel_3.add(lblSupervisorName, gbc_lblSupervisorName);
		
		textRoomName = new JTextField();
		textRoomName.setEditable(false);
		textRoomName.setColumns(10);
		GridBagConstraints gbc_textRoomName = new GridBagConstraints();
		gbc_textRoomName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRoomName.insets = new Insets(0, 0, 5, 5);
		gbc_textRoomName.gridx = 1;
		gbc_textRoomName.gridy = 1;
		panel_3.add(textRoomName, gbc_textRoomName);
		
		JLabel lblCandidateName = new JLabel("Examination Id");
		lblCandidateName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCandidateName = new GridBagConstraints();
		gbc_lblCandidateName.anchor = GridBagConstraints.WEST;
		gbc_lblCandidateName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCandidateName.gridx = 0;
		gbc_lblCandidateName.gridy = 2;
		panel_3.add(lblCandidateName, gbc_lblCandidateName);
		
		textExaminationId = new JTextField();
		textExaminationId.setEditable(false);
		textExaminationId.setColumns(10);
		GridBagConstraints gbc_textExaminationId = new GridBagConstraints();
		gbc_textExaminationId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textExaminationId.insets = new Insets(0, 0, 5, 5);
		gbc_textExaminationId.gridx = 1;
		gbc_textExaminationId.gridy = 2;
		panel_3.add(textExaminationId, gbc_textExaminationId);
		
		JLabel lblCandidateIdentification = new JLabel("Room Level");
		lblCandidateIdentification.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCandidateIdentification = new GridBagConstraints();
		gbc_lblCandidateIdentification.anchor = GridBagConstraints.WEST;
		gbc_lblCandidateIdentification.insets = new Insets(0, 0, 5, 5);
		gbc_lblCandidateIdentification.gridx = 0;
		gbc_lblCandidateIdentification.gridy = 3;
		panel_3.add(lblCandidateIdentification, gbc_lblCandidateIdentification);
		
		textRoomLevel = new JTextField();
		textRoomLevel.setEditable(false);
		textRoomLevel.setColumns(10);
		GridBagConstraints gbc_textRoomLevel = new GridBagConstraints();
		gbc_textRoomLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRoomLevel.insets = new Insets(0, 0, 5, 5);
		gbc_textRoomLevel.gridx = 1;
		gbc_textRoomLevel.gridy = 3;
		panel_3.add(textRoomLevel, gbc_textRoomLevel);
		
		JLabel lblRoomTime = new JLabel("Room Time");
		lblRoomTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRoomTime = new GridBagConstraints();
		gbc_lblRoomTime.anchor = GridBagConstraints.WEST;
		gbc_lblRoomTime.insets = new Insets(0, 0, 0, 5);
		gbc_lblRoomTime.gridx = 0;
		gbc_lblRoomTime.gridy = 4;
		panel_3.add(lblRoomTime, gbc_lblRoomTime);
		
		comboBoxRoomTime = new JComboBox();
		comboBoxRoomTime.setModel(new DefaultComboBoxModel(new String[] {"Morning", "Noon"}));
		GridBagConstraints gbc_comboBoxRoomTime = new GridBagConstraints();
		gbc_comboBoxRoomTime.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxRoomTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRoomTime.gridx = 1;
		gbc_comboBoxRoomTime.gridy = 4;
		panel_3.add(comboBoxRoomTime, gbc_comboBoxRoomTime);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] {50, 50, 0};
		gbl_panel_5.rowHeights = new int[] {50};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0};
		panel_5.setLayout(gbl_panel_5);
		
		btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomDTO rDto = new RoomDTO();
				rDto.setExamination_id(Integer.parseInt(textExaminationId.getText()));
				rDto.setId(Integer.parseInt(textRoomId.getText()));
				rDto.setLevel(textRoomLevel.getText());
				rDto.setName(textRoomName.getText());
				boolean time = false;
				int index = comboBoxRoomTime.getSelectedIndex();
				if (comboBoxRoomTime.getItemAt(index).equals("morning")) {
					time = true;
				}
				rDto.setTime(time);
				changeRoom(rDto);
			}
		});
		
		JButton btnAddSupervisor = new JButton("Add Supervisor");
		btnAddSupervisor.setVisible(false);
		btnAddSupervisor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAddSupervisor = new GridBagConstraints();
		gbc_btnAddSupervisor.fill = GridBagConstraints.BOTH;
		gbc_btnAddSupervisor.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddSupervisor.gridx = 0;
		gbc_btnAddSupervisor.gridy = 0;
		panel_5.add(btnAddSupervisor, gbc_btnAddSupervisor);
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnChange = new GridBagConstraints();
		gbc_btnChange.fill = GridBagConstraints.BOTH;
		gbc_btnChange.gridx = 1;
		gbc_btnChange.gridy = 0;
		panel_5.add(btnChange, gbc_btnChange);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6_1 = new JPanel();
		panel_6.add(panel_6_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_6_1 = new GridBagLayout();
		gbl_panel_6_1.columnWidths = new int[]{256, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6_1.rowHeights = new int[]{21, 0};
		gbl_panel_6_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6_1.setLayout(gbl_panel_6_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 0;
		panel_6_1.add(textField_3, gbc_textField_3);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.anchor = GridBagConstraints.WEST;
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 0;
		panel_6_1.add(btnSearch, gbc_btnSearch);
		
		JButton btnLoad = new JButton("Load data");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.anchor = GridBagConstraints.EAST;
		gbc_btnLoad.gridx = 14;
		gbc_btnLoad.gridy = 0;
		panel_6_1.add(btnLoad, gbc_btnLoad);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] {100, 200};
		gbl_panel_7.rowHeights = new int[] {30};
		gbl_panel_7.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_7.rowWeights = new double[]{0.0};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblNewLabel = new JLabel("Examination");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_7.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBoxExamination = new JComboBox();
		GridBagConstraints gbc_comboBoxExamination = new GridBagConstraints();
		gbc_comboBoxExamination.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxExamination.gridx = 1;
		gbc_comboBoxExamination.gridy = 0;
		panel_7.add(comboBoxExamination, gbc_comboBoxExamination);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		tableRoom = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
                return false;               
			};
		};
		tableRoom.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(tableRoom);

	}
	
	public void changeRoom(RoomDTO dto) {
		RoomBUS rBus = new RoomBUS();
		rBus.update(dto);
	}
	
	public void onLoad() {
		if (textRoomId.getText().equals("")) {
			btn
		}
	}

}
