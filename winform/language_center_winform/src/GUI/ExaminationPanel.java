package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class ExaminationPanel extends JPanel {
	private JTextField textExaminationName;
	private JTextField textExaminationDate;
	private JTable tableExamination;
	private JTextField textField;

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
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0};
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
		gbc_textExaminationName.insets = new Insets(0, 0, 5, 0);
		gbc_textExaminationName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textExaminationName.gridx = 1;
		gbc_textExaminationName.gridy = 0;
		panel_3.add(textExaminationName, gbc_textExaminationName);
		textExaminationName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Examination Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textExaminationDate = new JTextField();
		GridBagConstraints gbc_textExaminationDate = new GridBagConstraints();
		gbc_textExaminationDate.insets = new Insets(0, 0, 5, 0);
		gbc_textExaminationDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textExaminationDate.gridx = 1;
		gbc_textExaminationDate.gridy = 1;
		panel_3.add(textExaminationDate, gbc_textExaminationDate);
		textExaminationDate.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 10, 0, 0));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnAdd);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnChange);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnDelete);
		
		JButton btnViewRoom = new JButton("View Room");
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
		tableExamination.setEnabled(false);
		tableExamination.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(tableExamination);
		
	}
}
