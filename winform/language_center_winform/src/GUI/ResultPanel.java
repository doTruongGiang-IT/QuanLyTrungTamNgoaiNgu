package GUI;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.Candidate_RoomBUS;
import BUS.ExaminationBUS;
import BUS.RoomBUS;
import DTO.Candidate_RoomDTO;
import DTO.ExaminationDTO;
import DTO.RoomDTO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class ResultPanel extends JPanel {

    private JTable tableResult;
    private JTextField textId;
    private JTextField textField_1;
    private JTextField textSpeaking;
    private JTextField textListening;
    private JTextField textReading;
    private JTextField textWriting;
    private JTextField textCandidateId;
    private JTextField textCandidateno;
    private JTextField textRoomId;
    public JComboBox<String> comboBoxRoom;
    public JComboBox<String> comboBoxExam;
    private JButton btnApply;
    public Candidate_RoomBUS crBus;
    public List<Candidate_RoomDTO> crList;
    private int GlobalId;
    private Vector<String> rStringList;
    private Vector<String> eStringList;
    private int room_search = 0;
    private int exam_search = 0;
    private List<Integer> room_ids = new ArrayList<>();

    /**
     * Create the panel.
     */
    public ResultPanel() {
        onLoad();
        setMaximumSize(new Dimension(1039, 763));
        setLayout(new CardLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, "name_456402896127900");
        panel.setLayout(new GridLayout(2, 0, 0, 0));

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new GridLayout(2, 0, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "Xem chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.add(panel_3);
        GridBagLayout gbl_panel_3 = new GridBagLayout();
        gbl_panel_3.columnWidths = new int[]{80, 0, 130, 0};
        gbl_panel_3.rowHeights = new int[]{40, 40, 40, 40};
        gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        panel_3.setLayout(gbl_panel_3);

        JLabel lblSupervisorName = new JLabel("Mã kết quả thi");
        lblSupervisorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSupervisorName = new GridBagConstraints();
        gbc_lblSupervisorName.weightx = 0.3;
        gbc_lblSupervisorName.anchor = GridBagConstraints.WEST;
        gbc_lblSupervisorName.insets = new Insets(0, 0, 5, 5);
        gbc_lblSupervisorName.gridx = 0;
        gbc_lblSupervisorName.gridy = 0;
        panel_3.add(lblSupervisorName, gbc_lblSupervisorName);

        textId = new JTextField();
        textId.setEditable(false);
        textId.setColumns(10);
        GridBagConstraints gbc_textId = new GridBagConstraints();
        gbc_textId.fill = GridBagConstraints.HORIZONTAL;
        gbc_textId.insets = new Insets(0, 0, 5, 5);
        gbc_textId.gridx = 1;
        gbc_textId.gridy = 0;
        panel_3.add(textId, gbc_textId);

        JLabel lblSupervisorName_1 = new JLabel("Mã thí sinh");
        lblSupervisorName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSupervisorName_1 = new GridBagConstraints();
        gbc_lblSupervisorName_1.anchor = GridBagConstraints.WEST;
        gbc_lblSupervisorName_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblSupervisorName_1.gridx = 0;
        gbc_lblSupervisorName_1.gridy = 1;
        panel_3.add(lblSupervisorName_1, gbc_lblSupervisorName_1);

        textCandidateId = new JTextField();
        textCandidateId.setEditable(false);
        textCandidateId.setColumns(10);
        GridBagConstraints gbc_textCandidateId = new GridBagConstraints();
        gbc_textCandidateId.insets = new Insets(0, 0, 5, 5);
        gbc_textCandidateId.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCandidateId.gridx = 1;
        gbc_textCandidateId.gridy = 1;
        panel_3.add(textCandidateId, gbc_textCandidateId);

        JLabel lblSupervisorName_2 = new JLabel("Số báo danh");
        lblSupervisorName_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSupervisorName_2 = new GridBagConstraints();
        gbc_lblSupervisorName_2.anchor = GridBagConstraints.WEST;
        gbc_lblSupervisorName_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblSupervisorName_2.gridx = 0;
        gbc_lblSupervisorName_2.gridy = 2;
        panel_3.add(lblSupervisorName_2, gbc_lblSupervisorName_2);

        textCandidateno = new JTextField();
        textCandidateno.setEditable(false);
        textCandidateno.setColumns(10);
        GridBagConstraints gbc_textCandidateno = new GridBagConstraints();
        gbc_textCandidateno.insets = new Insets(0, 0, 5, 5);
        gbc_textCandidateno.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCandidateno.gridx = 1;
        gbc_textCandidateno.gridy = 2;
        panel_3.add(textCandidateno, gbc_textCandidateno);

        JLabel lblSupervisorName_3 = new JLabel("Phòng thi");
        lblSupervisorName_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSupervisorName_3 = new GridBagConstraints();
        gbc_lblSupervisorName_3.anchor = GridBagConstraints.WEST;
        gbc_lblSupervisorName_3.insets = new Insets(0, 0, 0, 5);
        gbc_lblSupervisorName_3.gridx = 0;
        gbc_lblSupervisorName_3.gridy = 3;
        panel_3.add(lblSupervisorName_3, gbc_lblSupervisorName_3);

        textRoomId = new JTextField();
        textRoomId.setEditable(false);
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
        gbl_panel_6.columnWidths = new int[]{60, 60, 60, 60};
        gbl_panel_6.rowHeights = new int[]{30, 5, 30};
        gbl_panel_6.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
        gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0};
        panel_6.setLayout(gbl_panel_6);

        JLabel lblNewLabel = new JLabel("Điểm Speaking");
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

        JLabel lblNewLabel_2 = new JLabel("Điểm Reading");
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

        JLabel lblNewLabel_1 = new JLabel("Điểm Listening");
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

        JLabel lblNewLabel_3 = new JLabel("Điểm Writing");
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

        btnApply = new JButton("Apply");
        btnApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeResult();
                loadData();
            }
        });
        btnApply.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_8.add(btnApply);

        JPanel panel_7 = new JPanel();
        panel_5.add(panel_7);
        panel_7.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_6_1 = new JPanel();
        panel_7.add(panel_6_1);
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

        JButton btnLoad = new JButton("Load dữ liệu");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//				int examinationIndex = comboBoxExamination.getSelectedIndex();
//				String examinationString =  comboBoxExamination.getItemAt(examinationIndex);
                int roomIndex = comboBoxRoom.getSelectedIndex();
                String roomString = comboBoxRoom.getItemAt(roomIndex);

                int examIndex = comboBoxExam.getSelectedIndex();
                String examString = comboBoxExam.getItemAt(examIndex);

                if (roomString.equals("Tất cả phòng thi")) {
                    room_search = 0;
                } else {
                    room_search = Integer.parseInt(roomString.split(" | ")[0]);
                }

                if (examString.equals("Tất cả kì thi")) {
                    exam_search = 0;
                } else {
                    exam_search = Integer.parseInt(examString.split(" | ")[0]);
                }

//				if( examinationStrgetItemAting == null || examinationString.equals("")) {
//					JOptionPane.showMessageDialog(getParent(),"Must select examination" );
//				}
//				if(roomString == null || roomString.equals("")) {
//					JOptionPane.showMessageDialog(getParent(),"Must select room" );
//				}
//				else 
                loadData();
            }
        });
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_btnLoad = new GridBagConstraints();
        gbc_btnLoad.anchor = GridBagConstraints.EAST;
        gbc_btnLoad.gridx = 14;
        gbc_btnLoad.gridy = 0;
        panel_6_1.add(btnLoad, gbc_btnLoad);

        JPanel panel_9 = new JPanel();
        panel_7.add(panel_9);
        panel_9.setLayout(new GridLayout(0, 2, 0, 0));

        comboBoxExam = new JComboBox<String>(eStringList);
        panel_9.add(comboBoxExam);

        comboBoxRoom = new JComboBox<String>(rStringList);
        panel_9.add(comboBoxRoom);

        comboBoxExam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RoomBUS rBus = new RoomBUS();
                List<RoomDTO> rList = rBus.getRooms();
                rStringList = new Vector<String>();
                rStringList.add("Tất cả phòng thi");

                boolean is_selection = false;

                int examIndex = comboBoxExam.getSelectedIndex();
                String examString = comboBoxExam.getItemAt(examIndex);
                int exam_id = 0;
                if (examString.equals("Tất cả kì thi")) {
                    is_selection = true;
                } else {
                    exam_id = Integer.parseInt(examString.split(" | ")[0]);
                }

                System.out.println(exam_id);
                room_ids.clear();
                if (rList != null) {
                    for (RoomDTO roomDTO : rList) {
                        if (is_selection || roomDTO.getExamination_id() == exam_id) {
                            rStringList.add(Integer.toString(roomDTO.getId()) + " | " + roomDTO.getName());
                            System.out.println(Integer.toString(roomDTO.getId()) + " | " + roomDTO.getName());
                            room_ids.add(roomDTO.getId());
                        }
                    }
                }
                comboBoxRoom.removeAllItems();

                for (String selection : rStringList) {
                    comboBoxRoom.addItem(selection);
                }
            }
        });

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane);

        tableResult = new JTable() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        ;
        };
		tableResult.setAutoCreateRowSorter(true);
        tableResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int rowIndex = tableResult.getSelectedRow();
                if (rowIndex > -1) {
                    textId.setText(tableResult.getValueAt(rowIndex, 0).toString());
                    textCandidateId.setText(tableResult.getValueAt(rowIndex, 1).toString());
                    textRoomId.setText(tableResult.getValueAt(rowIndex, 2).toString());
                    textCandidateno.setText(tableResult.getValueAt(rowIndex, 3).toString());
                    textListening.setText(tableResult.getValueAt(rowIndex, 4).toString());
                    textWriting.setText(tableResult.getValueAt(rowIndex, 5).toString());
                    textSpeaking.setText(tableResult.getValueAt(rowIndex, 6).toString());
                    textReading.setText(tableResult.getValueAt(rowIndex, 7).toString());

                }
            }
        });
        scrollPane.setViewportView(tableResult);

    }

    public void loadData() {
        Vector<String> vctHeader = new Vector<String>();
        vctHeader.add("Id");
        vctHeader.add("Mã thí sinh");
        vctHeader.add("Phòng thi");
        vctHeader.add("Số báo danh");
        vctHeader.add("Điểm Listening");
        vctHeader.add("Điểm Writing");
        vctHeader.add("Điểm Speaking");
        vctHeader.add("Điểm Reading");
        Vector vctData = new Vector<>();
        crBus = new Candidate_RoomBUS();
        crList = crBus.getCandidate_Rooms();

        List<Candidate_RoomDTO> crListSearch = new ArrayList<>();
        boolean invalid = false;
        if (exam_search == 0 && room_search != 0) {
            invalid = true;
        } else if (exam_search != 0 && room_search != 0) {
            for (Candidate_RoomDTO candidate_room : crList) {
                if (candidate_room.getRoom_id() == room_search) {
                    crListSearch.add(candidate_room);
                }
            }
            crList = crListSearch;
        } else if (exam_search != 0 && room_search == 0) {
            for (Candidate_RoomDTO candidate_room : crList) {
                if (room_ids.contains(candidate_room.getRoom_id())) {
                    crListSearch.add(candidate_room);
                }
            }
            crList = crListSearch;
        }

        if (invalid || crList == null) {
            JOptionPane.showMessageDialog(getParent(), "Error Load data: Null data");
        } else {
            for (Candidate_RoomDTO candidate_roomDTO : crList) {
                Vector<String> row = new Vector<String>();
                row.add(Integer.toString(candidate_roomDTO.getId()));
                row.add(candidate_roomDTO.getCandidate());
                row.add(candidate_roomDTO.getRoom());
                row.add(candidate_roomDTO.getCandidate_no());
                row.add(Double.toString(candidate_roomDTO.getScore_listening()));
                row.add(Double.toString(candidate_roomDTO.getScore_writing()));
                row.add(Double.toString(candidate_roomDTO.getScore_speaking()));
                row.add(Double.toString(candidate_roomDTO.getScore_reading()));
                vctData.add(row);
            }
        }
        tableResult.setModel(new DefaultTableModel(vctData, vctHeader));
    }

    public void onLoad() {
        RoomBUS rBus = new RoomBUS();
        ExaminationBUS eBus = new ExaminationBUS();
        List<RoomDTO> rList = rBus.getRooms();
        List<ExaminationDTO> eList = eBus.getExaminations();

        eStringList = new Vector<String>();
        eStringList.add("Tất cả kì thi");
        if (eList != null) {
            for (ExaminationDTO examDTO : eList) {
                eStringList.add(Integer.toString(examDTO.getId()) + " | " + examDTO.getName());
            }
        }

        comboBoxExam.removeAllItems();

        for (String selection : eStringList) {
            comboBoxExam.addItem(selection);
        }

        rStringList = new Vector<String>();
        rStringList.add("Tất cả phòng thi");
    }

    public void disableButton() {
        if (textCandidateId.getText() == null || textCandidateId.getText().equals("")) {
            btnApply.setEnabled(false);
        }
    }

    public void enableButton() {
        btnApply.setEnabled(true);
    }

    public void changeResult() {
        crBus = new Candidate_RoomBUS();
        Candidate_RoomDTO dto = new Candidate_RoomDTO();

        String candidate = textCandidateId.getText();
        if (candidate.split(" | ").length > 0) {
            candidate = candidate.split(" | ")[0];
        }

        String room = textRoomId.getText();
        if (room.split(" | ").length > 0) {
            room = room.split(" | ")[0];
        }

        dto.setId(Integer.parseInt(textId.getText()));
        dto.setCandidate_id(Integer.parseInt(candidate));
        dto.setCandidate_no(textCandidateno.getText());
        dto.setRoom_id(Integer.parseInt(room));
        dto.setScore_listening(Float.parseFloat(textListening.getText()));
        dto.setScore_writing(Float.parseFloat(textWriting.getText()));
        dto.setScore_reading(Float.parseFloat(textReading.getText()));
        dto.setScore_speaking(Float.parseFloat(textSpeaking.getText()));
        System.out.println(dto.toJSONObject().toString());
        boolean result = crBus.update(dto);
        if (!result) {
            JOptionPane.showMessageDialog(getParent(), "Update Result Error");
        } else {
            JOptionPane.showMessageDialog(getParent(), "Update Result Successful");
        }
    }

}
