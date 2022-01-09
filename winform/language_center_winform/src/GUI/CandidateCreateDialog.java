package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import BUS.CandidateBUS;
import DTO.CandidateDTO;

public class CandidateCreateDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textLastName;
    private JTextField textIdentification;
    private JTextField textIssuePlace;
    private JTextField textEmail;
    private JTextField textGender;
    private JTextField textFirstName;
    private JTextField textPlaceofbirth;
    private JTextField textPhone;
    private JDateChooser dateChooserDateofbirth;
    private JDateChooser dateChooserIssueDate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            CandidateCreateDialog dialog = new CandidateCreateDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public CandidateCreateDialog() {
        setBounds(100, 100, 703, 491);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.rowHeights = new int[]{30, 30, 30, 0, 30, 30, 30, 0, 30, 30};
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblNewLabel_6 = new JLabel("Tên");
            GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
            gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_6.gridx = 0;
            gbc_lblNewLabel_6.gridy = 0;
            contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
        }
        {
            textFirstName = new JTextField();
            GridBagConstraints gbc_textFirstName = new GridBagConstraints();
            gbc_textFirstName.insets = new Insets(0, 0, 5, 0);
            gbc_textFirstName.fill = GridBagConstraints.HORIZONTAL;
            gbc_textFirstName.gridx = 1;
            gbc_textFirstName.gridy = 0;
            contentPanel.add(textFirstName, gbc_textFirstName);
            textFirstName.setColumns(10);
        }
        {
            JLabel lblNewLabel = new JLabel("Họ");
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel.gridx = 0;
            gbc_lblNewLabel.gridy = 1;
            contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        }
        {
            textLastName = new JTextField();
            GridBagConstraints gbc_textLastName = new GridBagConstraints();
            gbc_textLastName.insets = new Insets(0, 0, 5, 0);
            gbc_textLastName.fill = GridBagConstraints.HORIZONTAL;
            gbc_textLastName.gridx = 1;
            gbc_textLastName.gridy = 1;
            contentPanel.add(textLastName, gbc_textLastName);
            textLastName.setColumns(10);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Số CMT");
            GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
            gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_1.gridx = 0;
            gbc_lblNewLabel_1.gridy = 2;
            contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        }
        {
            textIdentification = new JTextField();
            GridBagConstraints gbc_textIdentification = new GridBagConstraints();
            gbc_textIdentification.insets = new Insets(0, 0, 5, 0);
            gbc_textIdentification.fill = GridBagConstraints.HORIZONTAL;
            gbc_textIdentification.gridx = 1;
            gbc_textIdentification.gridy = 2;
            contentPanel.add(textIdentification, gbc_textIdentification);
            textIdentification.setColumns(10);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Ngày cung cấp CMT");
            GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
            gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_2.gridx = 0;
            gbc_lblNewLabel_2.gridy = 3;
            contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        }
        {
            dateChooserIssueDate = new JDateChooser();
            GridBagConstraints gbc_dateChooserIssueDate = new GridBagConstraints();
            gbc_dateChooserIssueDate.insets = new Insets(0, 0, 5, 0);
            gbc_dateChooserIssueDate.fill = GridBagConstraints.HORIZONTAL;
            gbc_dateChooserIssueDate.gridx = 1;
            gbc_dateChooserIssueDate.gridy = 3;
            contentPanel.add(dateChooserIssueDate, gbc_dateChooserIssueDate);
        }
        {
            JLabel lblNewLabel_3 = new JLabel("Nơi cấp CMT");
            GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
            gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_3.gridx = 0;
            gbc_lblNewLabel_3.gridy = 4;
            contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        }
        {
            textIssuePlace = new JTextField();
            GridBagConstraints gbc_textIssuePlace = new GridBagConstraints();
            gbc_textIssuePlace.insets = new Insets(0, 0, 5, 0);
            gbc_textIssuePlace.fill = GridBagConstraints.HORIZONTAL;
            gbc_textIssuePlace.gridx = 1;
            gbc_textIssuePlace.gridy = 4;
            contentPanel.add(textIssuePlace, gbc_textIssuePlace);
            textIssuePlace.setColumns(10);
        }
        {
            JLabel lblNewLabel_4 = new JLabel("Email");
            GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
            gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_4.gridx = 0;
            gbc_lblNewLabel_4.gridy = 5;
            contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
        }
        {
            textEmail = new JTextField();
            GridBagConstraints gbc_textEmail = new GridBagConstraints();
            gbc_textEmail.insets = new Insets(0, 0, 5, 0);
            gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
            gbc_textEmail.gridx = 1;
            gbc_textEmail.gridy = 5;
            contentPanel.add(textEmail, gbc_textEmail);
            textEmail.setColumns(10);
        }
        {
            JLabel lblNewLabel_5 = new JLabel("Giới tính");
            GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
            gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_5.gridx = 0;
            gbc_lblNewLabel_5.gridy = 6;
            contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
        }
        {
            textGender = new JTextField();
            GridBagConstraints gbc_textGender = new GridBagConstraints();
            gbc_textGender.insets = new Insets(0, 0, 5, 0);
            gbc_textGender.fill = GridBagConstraints.HORIZONTAL;
            gbc_textGender.gridx = 1;
            gbc_textGender.gridy = 6;
            contentPanel.add(textGender, gbc_textGender);
            textGender.setColumns(10);
        }
        {
            JLabel lblNewLabel_7 = new JLabel("Ngày sinh");
            GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
            gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_7.gridx = 0;
            gbc_lblNewLabel_7.gridy = 7;
            contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
        }
        {
            dateChooserDateofbirth = new JDateChooser();
            GridBagConstraints gbc_dateChooserDateofbirth = new GridBagConstraints();
            gbc_dateChooserDateofbirth.insets = new Insets(0, 0, 5, 0);
            gbc_dateChooserDateofbirth.fill = GridBagConstraints.HORIZONTAL;
            gbc_dateChooserDateofbirth.gridx = 1;
            gbc_dateChooserDateofbirth.gridy = 7;
            contentPanel.add(dateChooserDateofbirth, gbc_dateChooserDateofbirth);
        }
        {
            JLabel lblNewLabel_8 = new JLabel("Nơi sinh");
            GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
            gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_8.gridx = 0;
            gbc_lblNewLabel_8.gridy = 8;
            contentPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
        }
        {
            textPlaceofbirth = new JTextField();
            GridBagConstraints gbc_textPlaceofbirth = new GridBagConstraints();
            gbc_textPlaceofbirth.insets = new Insets(0, 0, 5, 0);
            gbc_textPlaceofbirth.fill = GridBagConstraints.HORIZONTAL;
            gbc_textPlaceofbirth.gridx = 1;
            gbc_textPlaceofbirth.gridy = 8;
            contentPanel.add(textPlaceofbirth, gbc_textPlaceofbirth);
            textPlaceofbirth.setColumns(10);
        }
        {
            JLabel lblNewLabel_9 = new JLabel("Số điện thoại");
            GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
            gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
            gbc_lblNewLabel_9.gridx = 0;
            gbc_lblNewLabel_9.gridy = 9;
            contentPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
        }
        {
            textPhone = new JTextField();
            GridBagConstraints gbc_textPhone = new GridBagConstraints();
            gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
            gbc_textPhone.gridx = 1;
            gbc_textPhone.gridy = 9;
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
                        CandidateDTO dto = new CandidateDTO();
                        dto.setId(0);
                        dto.setFirst_name(textFirstName.getText());
                        dto.setLast_name(textLastName.getText());
                        dto.setEmail(textEmail.getText());
                        dto.setGender(textGender.getText());
                        dto.setIdentification(textIdentification.getText());
                        dto.setIssue_place(textIssuePlace.getText());
                        dto.setPlace_of_birth(textPlaceofbirth.getText());
                        dto.setPhone(textPhone.getText());
                        Date issue_dateUnformat = dateChooserIssueDate.getDate();
                        Date dateofbirthUnformat = dateChooserDateofbirth.getDate();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String issue_date = sdf.format(issue_dateUnformat);
                        String dateofbirth = sdf.format(dateofbirthUnformat);
                        dto.setDay_of_birth(dateofbirth);
                        dto.setIssue_date(issue_date);
                        addCandidate(dto);
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

    public void addCandidate(CandidateDTO dto) {
        CandidateBUS bus = new CandidateBUS();
        boolean result = bus.insert(dto);
        if (!result) {
			JOptionPane.showMessageDialog(getParent(), "Thêm thí sinh thất bại");
		}
		else {
			JOptionPane.showMessageDialog(getParent(), "Thêm thí sinh thành công!!!");
		}
        this.dispose();
    }

}
