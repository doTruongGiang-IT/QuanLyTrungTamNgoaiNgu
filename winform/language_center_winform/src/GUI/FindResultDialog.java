package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.Candidate_RoomBUS;
import BUS.RoomBUS;
import DTO.CandidateDTO;
import DTO.Candidate_RoomDTO;
import DTO.RoomDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class FindResultDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textPhone;
	private JTextField textCandidateNumber;
	private JTextField textRoom;
	private JTextField textSpeaking;
	private JTextField textReading;
	private JTextField textWriting;
	private JTextField textListening;
	public CandidateDTO finderDto;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FindResultDialog dialog = new FindResultDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FindResultDialog(CandidateDTO inputDto) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Tên thí sinh");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textFirstName = new JTextField();
			textFirstName.setEditable(false);
			GridBagConstraints gbc_textFirstName = new GridBagConstraints();
			gbc_textFirstName.insets = new Insets(0, 0, 5, 0);
			gbc_textFirstName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFirstName.gridx = 1;
			gbc_textFirstName.gridy = 0;
			contentPanel.add(textFirstName, gbc_textFirstName);
			textFirstName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Họ thí sinh");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textLastName = new JTextField();
			textLastName.setEditable(false);
			GridBagConstraints gbc_textLastName = new GridBagConstraints();
			gbc_textLastName.insets = new Insets(0, 0, 5, 0);
			gbc_textLastName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textLastName.gridx = 1;
			gbc_textLastName.gridy = 1;
			contentPanel.add(textLastName, gbc_textLastName);
			textLastName.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Số điện thoại");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			textPhone = new JTextField();
			textPhone.setEditable(false);
			GridBagConstraints gbc_textPhone = new GridBagConstraints();
			gbc_textPhone.insets = new Insets(0, 0, 5, 0);
			gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
			gbc_textPhone.gridx = 1;
			gbc_textPhone.gridy = 2;
			contentPanel.add(textPhone, gbc_textPhone);
			textPhone.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Số báo danh");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			textCandidateNumber = new JTextField();
			textCandidateNumber.setEditable(false);
			GridBagConstraints gbc_textCandidateNumber = new GridBagConstraints();
			gbc_textCandidateNumber.insets = new Insets(0, 0, 5, 0);
			gbc_textCandidateNumber.fill = GridBagConstraints.HORIZONTAL;
			gbc_textCandidateNumber.gridx = 1;
			gbc_textCandidateNumber.gridy = 3;
			contentPanel.add(textCandidateNumber, gbc_textCandidateNumber);
			textCandidateNumber.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Phòng thi");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			textRoom = new JTextField();
			textRoom.setEditable(false);
			GridBagConstraints gbc_textRoom = new GridBagConstraints();
			gbc_textRoom.insets = new Insets(0, 0, 5, 0);
			gbc_textRoom.fill = GridBagConstraints.HORIZONTAL;
			gbc_textRoom.gridx = 1;
			gbc_textRoom.gridy = 4;
			contentPanel.add(textRoom, gbc_textRoom);
			textRoom.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Điểm Speaking");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 5;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			textSpeaking = new JTextField();
			textSpeaking.setEditable(false);
			GridBagConstraints gbc_textSpeaking = new GridBagConstraints();
			gbc_textSpeaking.insets = new Insets(0, 0, 5, 0);
			gbc_textSpeaking.fill = GridBagConstraints.HORIZONTAL;
			gbc_textSpeaking.gridx = 1;
			gbc_textSpeaking.gridy = 5;
			contentPanel.add(textSpeaking, gbc_textSpeaking);
			textSpeaking.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Điểm Reading");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 6;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			textReading = new JTextField();
			textReading.setEditable(false);
			GridBagConstraints gbc_textReading = new GridBagConstraints();
			gbc_textReading.insets = new Insets(0, 0, 5, 0);
			gbc_textReading.fill = GridBagConstraints.HORIZONTAL;
			gbc_textReading.gridx = 1;
			gbc_textReading.gridy = 6;
			contentPanel.add(textReading, gbc_textReading);
			textReading.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Điểm Writing");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 0;
			gbc_lblNewLabel_7.gridy = 7;
			contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			textWriting = new JTextField();
			textWriting.setEditable(false);
			GridBagConstraints gbc_textWriting = new GridBagConstraints();
			gbc_textWriting.insets = new Insets(0, 0, 5, 0);
			gbc_textWriting.fill = GridBagConstraints.HORIZONTAL;
			gbc_textWriting.gridx = 1;
			gbc_textWriting.gridy = 7;
			contentPanel.add(textWriting, gbc_textWriting);
			textWriting.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Điểm Listening");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_8.gridx = 0;
			gbc_lblNewLabel_8.gridy = 8;
			contentPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			textListening = new JTextField();
			textListening.setEditable(false);
			GridBagConstraints gbc_textListening = new GridBagConstraints();
			gbc_textListening.fill = GridBagConstraints.HORIZONTAL;
			gbc_textListening.gridx = 1;
			gbc_textListening.gridy = 8;
			contentPanel.add(textListening, gbc_textListening);
			textListening.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialog();
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
			this.onCreate(inputDto);
		}
	}
	
	
	public void closeDialog() {
		this.dispose();
	}
	
	public void onCreate(CandidateDTO dto) {
		finderDto = new CandidateDTO(dto);
		this.textFirstName.setText(finderDto.getFirst_name());
		this.textLastName.setText(finderDto.getLast_name());;
		this.textPhone.setText(finderDto.getPhone());
		Candidate_RoomBUS crBus = new Candidate_RoomBUS();
		List<Candidate_RoomDTO> crDtoList = crBus.getCandidate_Rooms();
		Candidate_RoomDTO crDto = new Candidate_RoomDTO();
		RoomDTO rDto = new RoomDTO();
		for (Candidate_RoomDTO candidate_RoomDTO : crDtoList) {
			if (finderDto.getId() == candidate_RoomDTO.getCandidate_id()) {
				crDto = candidate_RoomDTO;
				break;
			}
		}
		if (crDto.getCandidate_no() != null) {
			
			RoomBUS rBus = new RoomBUS();
			rDto = rBus.getRoom(crDto.getRoom_id());
			if (rDto.getName() != null) {
				this.textRoom.setText(rDto.getName());
				this.textCandidateNumber.setText(crDto.getCandidate_no());
				this.textListening.setText(Float.toString(crDto.getScore_listening()));
				this.textSpeaking.setText(Float.toString(crDto.getScore_speaking()));
				this.textWriting.setText(Float.toString(crDto.getScore_writing()));
				this.textReading.setText(Float.toString(crDto.getScore_reading()));
			}
			
		}
		else {
			JOptionPane.showMessageDialog(getParent(), "This candidate have no result");
		}
		
	}

}
