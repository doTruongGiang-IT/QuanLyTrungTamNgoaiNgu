package BUS;

import DTO.SupervisorDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import DAO.SupervisorDAO;

public class SupervisorBUS {

    public static List<SupervisorDTO> supervisors = new ArrayList<SupervisorDTO>();
    private SupervisorDAO supervisorDAO = new SupervisorDAO();

    public List<SupervisorDTO> getSupervisors() {
        if (supervisors == null) {
            supervisors = new ArrayList<>();
        };

        try {
            supervisors = supervisorDAO.getSupervisors();
            return supervisors;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public SupervisorDTO getExamination(int id) {
        SupervisorDTO supervisor = new SupervisorDTO();
        try {
            supervisor = supervisorDAO.getSupervisor(id);
            return supervisor;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean insert(SupervisorDTO supervisor) {
        try {
            SupervisorDTO result = supervisorDAO.insert(supervisor);

            if (result != null) {
                supervisors.add(supervisor);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Insert supervisor error");
            return false;
        }
    }

    public boolean update(SupervisorDTO supervisor) {
        int index = -1;
        boolean result = false;
        for (int i = 0; i < supervisors.size(); i++) {
            if ((supervisors.get(i)).getId() == supervisor.getId()) {
                index = i;
            };
        };

        if (index != -1) {
            try {
                boolean res = supervisorDAO.update(supervisor);
                if (res) {
                    supervisors.set(index, supervisor);
                    result = true;
                }
            } catch (Exception e) {
                System.out.println("Update supervisor error");
            };
        };
        return result;
    }

    public boolean delete(int id) {
        int index = -1;
        boolean result = false;
        for (int i = 0; i < supervisors.size(); i++) {
            if ((supervisors.get(i)).getId() == id) {
                index = i;
            };
        };
        if (index != -1) {
            try {
                boolean res = supervisorDAO.delete(id);
                if (res) {
                    supervisors.remove(index);
                    result = true;
                }
            } catch (Exception e) {
                System.out.println("Delete supervisor error");
            };
        };
        return result;
    }

    public List<SupervisorDTO> search(String name) {
        List<SupervisorDTO> supervisorsSearch = new ArrayList<SupervisorDTO>();
        try {
            supervisors = supervisorDAO.getSupervisors();
        } catch (Exception e) {
            System.out.println(e);
        };

        for (SupervisorDTO supervisor : supervisors) {
            if (supervisor.getName().toLowerCase().equals(name.toLowerCase())) {
                supervisorsSearch.add(supervisor);
            };
        };

        return supervisorsSearch;
    }

}
