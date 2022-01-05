package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RegisterFormDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textExaminationId;
	private JTextField textLevel;
	private JTextField textStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterFormDialog dialog = new RegisterFormDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterFormDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[] {40, 40, 40, 40};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel_1 = new JLabel("Candidate Id");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 0;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textExaminationId = new JTextField();
			textExaminationId.setEditable(false);
			GridBagConstraints gbc_textExaminationId = new GridBagConstraints();
			gbc_textExaminationId.insets = new Insets(0, 0, 5, 0);
			gbc_textExaminationId.fill = GridBagConstraints.HORIZONTAL;
			gbc_textExaminationId.gridx = 1;
			gbc_textExaminationId.gridy = 0;
			contentPanel.add(textExaminationId, gbc_textExaminationId);
			textExaminationId.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Examination");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 1;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JComboBox comboBoxExamination = new JComboBox();
			GridBagConstraints gbc_comboBoxExamination = new GridBagConstraints();
			gbc_comboBoxExamination.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxExamination.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxExamination.gridx = 1;
			gbc_comboBoxExamination.gridy = 1;
			contentPanel.add(comboBoxExamination, gbc_comboBoxExamination);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Level");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 2;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			textLevel = new JTextField();
			textLevel.setEditable(false);
			GridBagConstraints gbc_textLevel = new GridBagConstraints();
			gbc_textLevel.insets = new Insets(0, 0, 5, 0);
			gbc_textLevel.fill = GridBagConstraints.HORIZONTAL;
			gbc_textLevel.gridx = 1;
			gbc_textLevel.gridy = 2;
			contentPanel.add(textLevel, gbc_textLevel);
			textLevel.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Status");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 3;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			textStatus = new JTextField();
			textStatus.setEditable(false);
			GridBagConstraints gbc_textStatus = new GridBagConstraints();
			gbc_textStatus.fill = GridBagConstraints.HORIZONTAL;
			gbc_textStatus.gridx = 1;
			gbc_textStatus.gridy = 3;
			contentPanel.add(textStatus, gbc_textStatus);
			textStatus.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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

}
