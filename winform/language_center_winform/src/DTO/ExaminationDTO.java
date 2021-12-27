package DTO;

public class ExaminationDTO {
	private int id;
	private String name;
	private String examDate;
	
	public ExaminationDTO(){};
	
	public ExaminationDTO(int id, String name, String examDate) {
		this.id = id;
		this.name = name;
		this.examDate = examDate;
	};
	
	public int getId() {
		return id;
	};
	
	public void setId(int id) {
		this.id = id;
	};
	
	public String getName() {
		return name;
	};
	
	public void setName(String name) {
		this.name = name;
	};
	
	public String getExamDate() {
		return examDate;
	};
	
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	};
}
