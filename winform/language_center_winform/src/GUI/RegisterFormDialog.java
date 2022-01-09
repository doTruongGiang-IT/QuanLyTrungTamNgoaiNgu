package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.ExaminationBUS;
import BUS.Registration_FormsBUS;
import DTO.ExaminationDTO;
import DTO.Registration_FormsDTO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterFormDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textCandidateId;
    private JTextField textStatus;
    private Registration_FormsDTO newDto;
    private ExaminationDTO examDto;
    private JTextField textExaminationId;
    private JComboBox comboBoxLevel;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		try {
//			RegisterFormDialog dialog = new RegisterFormDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
    /**
     * Create the dialog.
     */
    public RegisterFormDialog(Registration_FormsDTO dto) {
        this.newDto = new Registration_FormsDTO(dto);
        System.out.println(newDto.toJSONObject().toString());
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{40, 40, 40, 40};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblNewLabel_1 = new JLabel("Mã thí sinh");
            GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
            gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_1.gridx = 0;
            gbc_lblNewLabel_1.gridy = 0;
            contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        }
        {
            textCandidateId = new JTextField();
            textCandidateId.setEditable(false);
            GridBagConstraints gbc_textCandidateId = new GridBagConstraints();
            gbc_textCandidateId.insets = new Insets(0, 0, 5, 0);
            gbc_textCandidateId.fill = GridBagConstraints.HORIZONTAL;
            gbc_textCandidateId.gridx = 1;
            gbc_textCandidateId.gridy = 0;
            contentPanel.add(textCandidateId, gbc_textCandidateId);
            textCandidateId.setColumns(10);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Kì thi");
            GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
            gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_2.gridx = 0;
            gbc_lblNewLabel_2.gridy = 1;
            contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        }
        {
            textExaminationId = new JTextField();
            textExaminationId.setEditable(false);
            GridBagConstraints gbc_textExaminationId = new GridBagConstraints();
            gbc_textExaminationId.insets = new Insets(0, 0, 5, 0);
            gbc_textExaminationId.fill = GridBagConstraints.HORIZONTAL;
            gbc_textExaminationId.gridx = 1;
            gbc_textExaminationId.gridy = 1;
            contentPanel.add(textExaminationId, gbc_textExaminationId);
            textExaminationId.setColumns(10);
        }
        {
            JLabel lblNewLabel_3 = new JLabel("Trình độ");
            GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
            gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_3.gridx = 0;
            gbc_lblNewLabel_3.gridy = 2;
            contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        }
        {
            comboBoxLevel = new JComboBox();
            comboBoxLevel.setModel(new DefaultComboBoxModel(new String[]{"A2", "B1"}));
            GridBagConstraints gbc_comboBoxLevel = new GridBagConstraints();
            gbc_comboBoxLevel.insets = new Insets(0, 0, 5, 0);
            gbc_comboBoxLevel.fill = GridBagConstraints.HORIZONTAL;
            gbc_comboBoxLevel.gridx = 1;
            gbc_comboBoxLevel.gridy = 2;
            contentPanel.add(comboBoxLevel, gbc_comboBoxLevel);
        }
        {
            JLabel lblNewLabel_4 = new JLabel("Trạng thái");
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
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        createRegistrationForm();
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
        onLoad();
    }

    public void closeDialog() {
        this.dispose();
    }

    public void createRegistration() {
        Registration_FormsBUS bus = new Registration_FormsBUS();
    }

    public void onLoad() {
        if (newDto.isStatus()) {
            textStatus.setText("True");
        } else {
            textStatus.setText("False");
        }
        textCandidateId.setText(Integer.toString(newDto.getCandidate_id()));
        ExaminationBUS examBus = new ExaminationBUS();
        this.examDto = examBus.getCurrentExamination();
        
        if (examDto != null){
            int id = examDto.getId();
            textExaminationId.setText(newDto.getExamination(id));
        }
    }

    public void createRegistrationForm() {
        Registration_FormsDTO rfDto = new Registration_FormsDTO();
        String raw_exam = textExaminationId.getText();
        
        if (raw_exam.split(" | ").length > 0){
            raw_exam = raw_exam.split(" | ")[0];
        }
        
        rfDto.setId(0);
        rfDto.setCandidate_id(Integer.parseInt(textCandidateId.getText()));
        rfDto.setExamination_id(Integer.parseInt(raw_exam));
        rfDto.setLevel(comboBoxLevel.getSelectedItem().toString());
        rfDto.setStatus(newDto.isStatus());
        Registration_FormsBUS bus = new Registration_FormsBUS();
        boolean result = bus.insert(rfDto);
        if (!result) {
            JOptionPane.showMessageDialog(getParent(), "Insert Registration Error");
        } else {
            JOptionPane.showMessageDialog(getParent(), "Insert Registration Successful");
        }
        this.dispose();
    }

}
