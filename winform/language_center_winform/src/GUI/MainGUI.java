package GUI;

import BUS.CandidateBUS;
import BUS.Candidate_RoomBUS;
import BUS.ExaminationBUS;
import BUS.Registration_FormsBUS;
import BUS.RoomBUS;
import BUS.SupervisorBUS;
import BUS.Supervisor_RoomBUS;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class MainGUI {

    private JFrame mainFrame;
    public JPanel panelContent = new JPanel(new CardLayout(0, 0));

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI window = new MainGUI();
                    window.loadData();
                    window.mainFrame.setLocationRelativeTo(null);
                    window.mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainGUI() {
        initialize();
        mainFrame.getContentPane().add(panelContent, BorderLayout.CENTER);
        JPanel panelWelcome = new JPanel();
        JLabel wc = new JLabel("Welcom to English Examination Management");
        wc.setHorizontalAlignment(SwingConstants.CENTER);
        panelWelcome.setLayout(new BorderLayout());
        panelWelcome.add(wc, BorderLayout.CENTER);
        ExaminationPanel examCard = new ExaminationPanel();
        panelContent.add(panelWelcome, "welcomeCard");
        panelContent.add(examCard, "examCard");
        SupervisorPanel supervisorCard = new SupervisorPanel();
        panelContent.add(supervisorCard, "supervisorCard");
        CandidatePanel candidateCard = new CandidatePanel();
        panelContent.add(candidateCard, "candidateCard");
        ResultPanel resultCard = new ResultPanel();
        panelContent.add(resultCard, "resultCard");
        RoomPanel roomCard = new RoomPanel();
        panelContent.add(roomCard, "roomCard");
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        mainFrame = new JFrame();
        mainFrame.setLocationByPlatform(true);
        mainFrame.setLocation(new Point(0, 0));
        mainFrame.setTitle("English Examination Management");
        mainFrame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mainFrame.setBounds(100, 100, 1200, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelBtn = new JPanel();
        panelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        mainFrame.getContentPane().add(panelBtn, BorderLayout.WEST);
        panelBtn.setLayout(new GridLayout(0, 1, 0, 15));

        JButton btnExamination = new JButton("Kỳ thi");
        btnExamination.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadExamination();
            }
        });
        panelBtn.add(btnExamination);

        JButton btnRoom = new JButton("Phòng thi");
        btnRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadRoom();
            }
        });

        panelBtn.add(btnRoom);

        JButton btnSupervisor = new JButton("Giám thị");
        btnSupervisor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadSupervisor();
            }
        });

        JButton btnCandidate = new JButton("Thí sinh");
        btnCandidate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadCandidate();
            }
        });
        panelBtn.add(btnCandidate);
        panelBtn.add(btnSupervisor);

        JButton btnResult = new JButton("Kết quả thi");
        btnResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadResult();
            }
        });
        panelBtn.add(btnResult);

    }

    public void loadExamination() {
        String cardName = "examCard";
        ((CardLayout) panelContent.getLayout()).show(panelContent, cardName);;
    }

    public void loadSupervisor() {
        String cardName = "supervisorCard";
        ((CardLayout) panelContent.getLayout()).show(panelContent, cardName);;
    }

    public void loadCandidate() {
        String cardName = "candidateCard";
        ((CardLayout) panelContent.getLayout()).show(panelContent, cardName);;
    }

    public void loadResult() {
        String cardName = "resultCard";
        ((CardLayout) panelContent.getLayout()).show(panelContent, cardName);;
    }

    public void loadRoom() {
        String cardName = "roomCard";
        ((CardLayout) panelContent.getLayout()).show(panelContent, cardName);;
    }
    
    public void loadData() {
        new CandidateBUS().getCandidates();
        new Candidate_RoomBUS().getCandidate_Rooms();
        new ExaminationBUS().getExaminations();
        new Registration_FormsBUS().getRegistration_Forms();
        new RoomBUS().getRooms();
        new SupervisorBUS().getSupervisors();
        new Supervisor_RoomBUS().getSupervisor_Rooms();
    }
}
