package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.CandidateBUS;
import DTO.CandidateDTO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FindCandidateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFirstName;
	private JTextField textPhone;
	public List<CandidateDTO> candidateList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindCandidateDialog dialog = new FindCandidateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindCandidateDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("First Name");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textFirstName = new JTextField();
			GridBagConstraints gbc_textFirstName = new GridBagConstraints();
			gbc_textFirstName.insets = new Insets(0, 0, 5, 0);
			gbc_textFirstName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFirstName.gridx = 1;
			gbc_textFirstName.gridy = 1;
			contentPanel.add(textFirstName, gbc_textFirstName);
			textFirstName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Phone");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 3;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textPhone = new JTextField();
			GridBagConstraints gbc_textPhone = new GridBagConstraints();
			gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
			gbc_textPhone.gridx = 1;
			gbc_textPhone.gridy = 3;
			contentPanel.add(textPhone, gbc_textPhone);
			textPhone.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String firstName = textFirstName.getText();
						String phone = textPhone.getText();
						if(firstName == null || firstName.equals("") || phone == null || phone.equals("")) {
							JOptionPane.showMessageDialog(getParent(), "All field must be filled");
						}
						else {
							openFindResultDialog(firstName, phone);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialog();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void closeDialog() {
		this.dispose();
	}
	
	public void openFindResultDialog(String firstName, String phone) {
		CandidateBUS bus = new CandidateBUS();
		CandidateDTO result = new CandidateDTO();
		candidateList = new ArrayList<CandidateDTO>();
		candidateList = bus.search(firstName);
		if (candidateList.size() > 0) {
			for (CandidateDTO candidateDTO : candidateList) {
				if(candidateDTO.getPhone().equals(phone)) {
	            	result = candidateDTO;
	            	break;
	            };
			}
		}
		if (result.getIdentification() != null) {
			FindResultDialog findresultDialog = new FindResultDialog();
			findresultDialog.setFinderDto(result);
			findresultDialog.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(getParent(), "Cannot find candidate");
		}
		this.dispose();
	}

}
