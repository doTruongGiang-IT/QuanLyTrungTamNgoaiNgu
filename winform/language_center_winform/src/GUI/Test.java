package GUI;

import java.util.List;

import BUS.ExaminationBUS;
import DAO.ExaminationDAO;
import DTO.ExaminationDTO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExaminationBUS bus = new ExaminationBUS();
		ExaminationDTO examinationDTO= bus.getExamination(1);
//		for (ExaminationDTO examinationDTO : dtolist) {
			System.out.println(examinationDTO.getId());
			System.out.println(examinationDTO.getName());
			System.out.println(examinationDTO.getDate());
//		}
//		ExaminationDAO dao = new ExaminationDAO();
//		ExaminationDTO dto = new ExaminationDTO();
//		dto.setDate("1/1/2022");
//		dto.setName("Test Exam");
//		dao.insert(dto);
	}

}
