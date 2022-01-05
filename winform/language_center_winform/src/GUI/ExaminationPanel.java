package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import BUS.ExaminationBUS;
import DTO.ExaminationDTO;

public class ExaminationPanel extends JPanel {
	private JTextField textExaminationName;
	private JTable tableExamination;
	private JTextField textField;
	public List<ExaminationDTO> examList;

	/**
	 * Create the panel.
	 */
	public ExaminationPanel() {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//		setPreferredSize(new Dimension(1039, 763));
		setMaximumSize(new Dimension(1039, 763));
		setLayout(new CardLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		panelContent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(panelContent, "name_437768996016200");
		panelContent.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContent.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {80, 0, 130};
		gbl_panel_3.rowHeights = new int[] {50, 50};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Examination Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.weightx = 0.3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		textExaminationName = new JTextField();
		GridBagConstraints gbc_textExaminationName = new GridBagConstraints();
		gbc_textExaminationName.insets = new Insets(0, 0, 5, 5);
		gbc_textExaminationName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textExaminationName.gridx = 1;
		gbc_textExaminationName.gridy = 0;
		panel_3.add(textExaminationName, gbc_textExaminationName);
		textExaminationName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Examination Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		LocalDate minDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		Date minSelectableDate = Date.from(minDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dateChooser.setMinSelectableDate(minSelectableDate);
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 1;
		panel_3.add(dateChooser, gbc_dateChooser);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{101, 101, 101, 101, 0};
		gbl_panel_4.rowHeights = new int[]{80, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textExaminationName.getText();
				Date dateUnformat = dateChooser.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateUnformat);
//				System.out.print(date);
//				if(name == null || name.equals("")) {
//					JOptionPane.showMessageDialog(getParent(), "Name must not be null")
//				}
//				else if() {
//					
//				}
//				else {
//					
//				}
				addExamination(name, date);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		panel_4.add(btnAdd, gbc_btnAdd);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnChange = new GridBagConstraints();
		gbc_btnChange.fill = GridBagConstraints.BOTH;
		gbc_btnChange.insets = new Insets(0, 0, 0, 5);
		gbc_btnChange.gridx = 1;
		gbc_btnChange.gridy = 0;
		panel_4.add(btnChange, gbc_btnChange);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 0;
		panel_4.add(btnDelete, gbc_btnDelete);
		
		JButton btnGenerateRoom = new JButton("Generate Room for Examination");
		btnGenerateRoom.setToolTipText("Create Room for this Examination");
		btnGenerateRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnGenerateRoom = new GridBagConstraints();
		gbc_btnGenerateRoom.fill = GridBagConstraints.BOTH;
		gbc_btnGenerateRoom.gridx = 3;
		gbc_btnGenerateRoom.gridy = 0;
		panel_4.add(btnGenerateRoom, gbc_btnGenerateRoom);
		
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
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_6.add(textField, gbc_textField);
		
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
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContent.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tableExamination = new JTable();
//		tableExamination.setEnabled(false);
//		tableExamination.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//			}
//		));
		scrollPane.setViewportView(tableExamination);
		
	}
	
	public void loadData() {
		Vector<String> vctHeader = new Vector<String>();
		vctHeader.add("Name");
		vctHeader.add("Date");
		Vector vctData = new Vector<>();
		ExaminationBUS examBus = new ExaminationBUS();
		examList = examBus.getExaminations();
		for (ExaminationDTO examinationDTO : examList) {
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(examinationDTO.getId()));
			row.add(examinationDTO.getName());
			row.add(examinationDTO.getDate());
			vctData.add(row);
		}
		tableExamination.setModel(new DefaultTableModel(vctData, vctHeader));
	}
	
	public void addExamination(String name,String date) {
		ExaminationBUS bus = new ExaminationBUS();
		ExaminationDTO dto = new ExaminationDTO();
		dto.setId(0);
		dto.setDate(date);
		dto.setName(name);
		System.out.println(date);
		System.out.println(name);
		bus.insert(dto);
	}
}
