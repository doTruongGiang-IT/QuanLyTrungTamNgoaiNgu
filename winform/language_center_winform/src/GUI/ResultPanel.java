package GUI;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class ResultPanel extends JPanel {
	private JTable table;
	private JTextField textId;
	private JTextField textField_1;
	private JTextField textSpeaking;
	private JTextField textListening;
	private JTextField textReading;
	private JTextField textWriting;
	private JTextField textCandidateId;
	private JTextField textCandidateno;
	private JTextField textRoomId;

	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setMaximumSize(new Dimension(1039, 763));
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_456402896127900");
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{80, 0, 130, 0};
		gbl_panel_3.rowHeights = new int[] {40, 40, 40, 40};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblSupervisorName = new JLabel("Result Id");
		lblSupervisorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSupervisorName = new GridBagConstraints();
		gbc_lblSupervisorName.weightx = 0.3;
		gbc_lblSupervisorName.anchor = GridBagConstraints.WEST;
		gbc_lblSupervisorName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupervisorName.gridx = 0;
		gbc_lblSupervisorName.gridy = 0;
		panel_3.add(lblSupervisorName, gbc_lblSupervisorName);
		
		textId = new JTextField();
		textId.setColumns(10);
		GridBagConstraints gbc_textId = new GridBagConstraints();
		gbc_textId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textId.insets = new Insets(0, 0, 5, 5);
		gbc_textId.gridx = 1;
		gbc_textId.gridy = 0;
		panel_3.add(textId, gbc_textId);
		
		JLabel lblSupervisorName_1 = new JLabel("Candidate Id");
		lblSupervisorName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSupervisorName_1 = new GridBagConstraints();
		gbc_lblSupervisorName_1.anchor = GridBagConstraints.WEST;
		gbc_lblSupervisorName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupervisorName_1.gridx = 0;
		gbc_lblSupervisorName_1.gridy = 1;
		panel_3.add(lblSupervisorName_1, gbc_lblSupervisorName_1);
		
		textCandidateId = new JTextField();
		textCandidateId.setColumns(10);
		GridBagConstraints gbc_textCandidateId = new GridBagConstraints();
		gbc_textCandidateId.insets = new Insets(0, 0, 5, 5);
		gbc_textCandidateId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCandidateId.gridx = 1;
		gbc_textCandidateId.gridy = 1;
		panel_3.add(textCandidateId, gbc_textCandidateId);
		
		JLabel lblSupervisorName_2 = new JLabel("Candidate Code");
		lblSupervisorName_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSupervisorName_2 = new GridBagConstraints();
		gbc_lblSupervisorName_2.anchor = GridBagConstraints.WEST;
		gbc_lblSupervisorName_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupervisorName_2.gridx = 0;
		gbc_lblSupervisorName_2.gridy = 2;
		panel_3.add(lblSupervisorName_2, gbc_lblSupervisorName_2);
		
		textCandidateno = new JTextField();
		textCandidateno.setColumns(10);
		GridBagConstraints gbc_textCandidateno = new GridBagConstraints();
		gbc_textCandidateno.insets = new Insets(0, 0, 5, 5);
		gbc_textCandidateno.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCandidateno.gridx = 1;
		gbc_textCandidateno.gridy = 2;
		panel_3.add(textCandidateno, gbc_textCandidateno);
		
		JLabel lblSupervisorName_3 = new JLabel("Room Id");
		lblSupervisorName_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSupervisorName_3 = new GridBagConstraints();
		gbc_lblSupervisorName_3.anchor = GridBagConstraints.WEST;
		gbc_lblSupervisorName_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblSupervisorName_3.gridx = 0;
		gbc_lblSupervisorName_3.gridy = 3;
		panel_3.add(lblSupervisorName_3, gbc_lblSupervisorName_3);
		
		textRoomId = new JTextField();
		textRoomId.setColumns(10);
		GridBagConstraints gbc_textRoomId = new GridBagConstraints();
		gbc_textRoomId.insets = new Insets(0, 0, 0, 5);
		gbc_textRoomId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRoomId.gridx = 1;
		gbc_textRoomId.gridy = 3;
		panel_3.add(textRoomId, gbc_textRoomId);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] {60, 60, 60, 60};
		gbl_panel_6.rowHeights = new int[] {30, 5, 30};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel = new JLabel("Speaking");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_6.add(lblNewLabel, gbc_lblNewLabel);
		
		textSpeaking = new JTextField();
		GridBagConstraints gbc_textSpeaking = new GridBagConstraints();
		gbc_textSpeaking.insets = new Insets(0, 0, 5, 5);
		gbc_textSpeaking.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSpeaking.gridx = 1;
		gbc_textSpeaking.gridy = 0;
		panel_6.add(textSpeaking, gbc_textSpeaking);
		textSpeaking.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Reading");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel_6.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textReading = new JTextField();
		textReading.setColumns(10);
		GridBagConstraints gbc_textReading = new GridBagConstraints();
		gbc_textReading.insets = new Insets(0, 0, 5, 5);
		gbc_textReading.fill = GridBagConstraints.HORIZONTAL;
		gbc_textReading.gridx = 3;
		gbc_textReading.gridy = 0;
		panel_6.add(textReading, gbc_textReading);
		
		JLabel lblNewLabel_1 = new JLabel("Listening");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_6.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textListening = new JTextField();
		textListening.setColumns(10);
		GridBagConstraints gbc_textListening = new GridBagConstraints();
		gbc_textListening.insets = new Insets(0, 0, 0, 5);
		gbc_textListening.fill = GridBagConstraints.HORIZONTAL;
		gbc_textListening.gridx = 1;
		gbc_textListening.gridy = 2;
		panel_6.add(textListening, gbc_textListening);
		
		JLabel lblNewLabel_3 = new JLabel("Writing");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 2;
		panel_6.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textWriting = new JTextField();
		textWriting.setColumns(10);
		GridBagConstraints gbc_textWriting = new GridBagConstraints();
		gbc_textWriting.insets = new Insets(0, 0, 0, 5);
		gbc_textWriting.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWriting.gridx = 3;
		gbc_textWriting.gridy = 2;
		panel_6.add(textWriting, gbc_textWriting);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 10, 0, 0));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(btnAdd);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(btnChange);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(btnDelete);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6_1 = new JPanel();
		panel_7.add(panel_6_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_6_1 = new GridBagLayout();
		gbl_panel_6_1.columnWidths = new int[]{256, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6_1.rowHeights = new int[]{21, 0};
		gbl_panel_6_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6_1.setLayout(gbl_panel_6_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		panel_6_1.add(textField_1, gbc_textField_1);
		
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
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.anchor = GridBagConstraints.EAST;
		gbc_btnLoad.gridx = 14;
		gbc_btnLoad.gridy = 0;
		panel_6_1.add(btnLoad, gbc_btnLoad);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

}
