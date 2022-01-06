package BUS;

import DTO.ExaminationDTO;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import DAO.ExaminationDAO;

public class ExaminationBUS {

    public static List<ExaminationDTO> examinations = new ArrayList<ExaminationDTO>();
    private ExaminationDAO examinationDAO = new ExaminationDAO();

    public List<ExaminationDTO> getExaminations() {
        if (examinations == null) {
            examinations = new ArrayList<>();
        };

        try {
            examinations = examinationDAO.getExaminations();
            return examinations;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ExaminationDTO getExamination(int id) {
        ExaminationDTO examination = new ExaminationDTO();
        try {
            examination = examinationDAO.getExamination(id);
            return examination;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean insert(ExaminationDTO examination) {
        try {
            ExaminationDTO result = examinationDAO.insert(examination);
            if (result != null){
                examinations.add(examination);
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Insert examination error");
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ExaminationDTO examination) {
        int index = -1;
        boolean result = false;
        for (int i = 0; i < examinations.size(); i++) {
            if ((examinations.get(i)).getId() == examination.getId()) {
                index = i;
            };
        };

        if (index != -1) {
            try {
                boolean res = examinationDAO.update(examination);
                if (res){
                    examinations.set(index, examination);
                    result = true;
                }
            } catch (Exception e) {
                System.out.println("Update examination error");
            }
        };
        return result;
    }

    public boolean delete(int id) {
        int index = -1;
        boolean result = false;
        for (int i = 0; i < examinations.size(); i++) {
            if ((examinations.get(i)).getId() == id) {
                index = i;
            };
        };
        if (index != -1) {
            try {
                boolean res = examinationDAO.delete(id);
                if (res){
                    examinations.remove(index);
                    result = true;
                }
            } catch (Exception e) {
                System.out.println("Delete examination error");
            }
        };
        return result;
    }

    public List<ExaminationDTO> search(String name) {
        List<ExaminationDTO> examinationsSearch = new ArrayList<ExaminationDTO>();
        try {
            examinations = examinationDAO.getExaminations();
        } catch (Exception e) {
            System.out.println(e);
        };

        for (ExaminationDTO examination : examinations) {
            if (examination.getName().toLowerCase().equals(name.toLowerCase())) {
                examinationsSearch.add(examination);
            };
        };

        return examinationsSearch;
    }

    public static void main(String args[]) {
        ExaminationBUS examBUS = new ExaminationBUS();
        List<ExaminationDTO> dtos = examBUS.getExaminations();
        if (dtos != null) {
            for (int i = 0; i < dtos.size(); i++) {
                System.out.println(dtos.get(i).getId());
                System.out.println(dtos.get(i).getName());
                System.out.println(dtos.get(i).getDate());
                System.out.println("=====================");
            };
        };
    }
}
