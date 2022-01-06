package GUI;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CandidatePanel extends JPanel {
	private JTable tableCandidate;
	private JTextField textField_1;
	private JTextField textCandidateName;
	private JTextField textCandidateIdent;
	private JTextField textCandidateId;
	private JButton btnViewDetail;
	private JButton btnDelete;
	private JButton btnCreateRegistration;

	/**
	 * Create the panel.
	 */
	public CandidatePanel() {
		setMaximumSize(new Dimension(1039, 763));
		setLayout(new CardLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		add(panelContent, "name_454536971900500");
		panelContent.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelContent.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.rowHeights = new int[] {30, 40, 40, 30};
		gbl_panel_3.columnWidths = new int[]{80, 0, 130, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Candidate Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		textCandidateId = new JTextField();
		textCandidateId.setEditable(false);
		GridBagConstraints gbc_textCandidateId = new GridBagConstraints();
		gbc_textCandidateId.insets = new Insets(0, 0, 5, 5);
		gbc_textCandidateId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCandidateId.gridx = 1;
		gbc_textCandidateId.gridy = 0;
		panel_3.add(textCandidateId, gbc_textCandidateId);
		textCandidateId.setColumns(10);
		
		JLabel lblCandidateName = new JLabel("Candidate Name");
		lblCandidateName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCandidateName = new GridBagConstraints();
		gbc_lblCandidateName.anchor = GridBagConstraints.WEST;
		gbc_lblCandidateName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCandidateName.gridx = 0;
		gbc_lblCandidateName.gridy = 1;
		panel_3.add(lblCandidateName, gbc_lblCandidateName);
		
		textCandidateName = new JTextField();
		textCandidateName.setEditable(false);
		textCandidateName.setColumns(10);
		GridBagConstraints gbc_textCandidateName = new GridBagConstraints();
		gbc_textCandidateName.insets = new Insets(0, 0, 5, 5);
		gbc_textCandidateName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCandidateName.gridx = 1;
		gbc_textCandidateName.gridy = 1;
		panel_3.add(textCandidateName, gbc_textCandidateName);
		
		JLabel lblCandidateIdentification = new JLabel("Candidate Identification");
		lblCandidateIdentification.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCandidateIdentification = new GridBagConstraints();
		gbc_lblCandidateIdentification.anchor = GridBagConstraints.WEST;
		gbc_lblCandidateIdentification.insets = new Insets(0, 0, 5, 5);
		gbc_lblCandidateIdentification.gridx = 0;
		gbc_lblCandidateIdentification.gridy = 2;
		panel_3.add(lblCandidateIdentification, gbc_lblCandidateIdentification);
		
		textCandidateIdent = new JTextField();
		textCandidateIdent.setEditable(false);
		textCandidateIdent.setColumns(10);
		GridBagConstraints gbc_textCandidateIdent = new GridBagConstraints();
		gbc_textCandidateIdent.insets = new Insets(0, 0, 5, 5);
		gbc_textCandidateIdent.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCandidateIdent.gridx = 1;
		gbc_textCandidateIdent.gridy = 2;
		panel_3.add(textCandidateIdent, gbc_textCandidateIdent);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 8, 0, 0));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCandidate();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnDelete);
		
		btnCreateRegistration = new JButton("Registration");
		btnCreateRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openRegistrationDialog();
			}
		});
		btnCreateRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnCreateRegistration);
		
		JButton btnViewResult = new JButton("View Result");
		btnViewResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCandidate();
			}
		});
		btnViewResult.setVisible(false);
		
		btnViewDetail = new JButton("Detail");
		btnViewDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDetailCandidateDialog();
			}
		});
		btnViewDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnViewDetail);
		btnViewResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnViewResult);
		
		JButton btnFindCandidate = new JButton("Find Candidate");
		btnFindCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFindCandidateDialog();
			}
		});
		btnFindCandidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnFindCandidate);
		
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
		panel_6.add(textField_1, gbc_textField_1);
		
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
		
		JPanel panel_1 = new JPanel();
		panelContent.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		tableCandidate = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
                return false;               
			};
		};
		scrollPane.setViewportView(tableCandidate);
		
		onLoad();
	}
	
	public void openRegistrationDialog() {
		JDialog registrationDialog = new RegisterFormDialog();
		registrationDialog.setVisible(true);;
	}
	
	public void openDetailCandidateDialog() {
		JDialog registrationDialog = new DetailCandidate();
		registrationDialog.setVisible(true);;
	}
	
	public void openFindCandidateDialog() {
		JDialog findcandidateDialog = new FindCandidateDialog();
		findcandidateDialog.setVisible(true);
	}
	
	public void onLoad() {
		if (textCandidateId.getText().equals("") || textCandidateId.getText() == null) {
			this.btnCreateRegistration.setEnabled(false);
			this.btnDelete.setEnabled(false);
			this.btnViewDetail.setEnabled(false);
		}
	}
	
	public void addCandidate() {
		CandidateCreateDialog dialog = new CandidateCreateDialog();
		dialog.setVisible(true);
	}

}
