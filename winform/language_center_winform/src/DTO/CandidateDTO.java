package DTO;

import org.json.JSONException;
import org.json.JSONObject;

public class CandidateDTO {

    private int id;
    private String identification;
    private String issue_date;
    private String issue_place;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String day_of_birth;
    private String place_of_birth;
    private String phone;

    public CandidateDTO() {
    }

    public CandidateDTO(CandidateDTO dto) {
        this.id = dto.getId();
        this.identification = dto.getIdentification();
        this.issue_date = dto.getIssue_date();
        this.issue_place = dto.getIssue_place();
        this.first_name = dto.getFirst_name();
        this.last_name = dto.getLast_name();
        this.email = dto.getEmail();
        this.gender = dto.getGender();
        this.day_of_birth = dto.getDay_of_birth();
        this.place_of_birth = dto.getPlace_of_birth();
        this.phone = dto.getPhone();
    }

    public CandidateDTO(JSONObject data) {
        try {
            this.id = data.getInt("id");
            this.identification = data.getString("identification");
            this.first_name = data.getString("first_name");
            this.last_name = data.getString("last_name");
            this.email = data.getString("email");
            this.gender = data.getString("gender");
            this.day_of_birth = data.getString("date_of_birth");
            this.place_of_birth = data.getString("place_of_birth");
            this.issue_date = data.getString("issue_date");
            this.issue_place = data.getString("issue_place");
            this.phone = data.getString("phone");
        } catch (JSONException e) {
            System.out.println("Candidate error convert json -> dto");
        }
    }

    public CandidateDTO(int id, String identification, String issue_date, String issue_place, String first_name,
            String last_name, String email, String gender, String day_of_birth, String place_of_birth, String phone) {
        super();
        this.id = id;
        this.identification = identification;
        this.issue_date = issue_date;
        this.issue_place = issue_place;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.day_of_birth = day_of_birth;
        this.place_of_birth = place_of_birth;
        this.phone = phone;
    }

    public CandidateDTO(String identification, String issue_date, String issue_place, String first_name,
            String last_name, String email, String gender, String day_of_birth, String place_of_birth, String phone) {
        super();
        this.identification = identification;
        this.issue_date = issue_date;
        this.issue_place = issue_place;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.day_of_birth = day_of_birth;
        this.place_of_birth = place_of_birth;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getIssue_place() {
        return issue_place;
    }

    public void setIssue_place(String issue_place) {
        this.issue_place = issue_place;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public String getName(){
        return this.last_name + " " + this.last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDay_of_birth() {
        return day_of_birth;
    }

    public void setDay_of_birth(String day_of_birth) {
        this.day_of_birth = day_of_birth;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", this.id);
            obj.put("identification", this.identification);
            obj.put("issue_date", this.issue_date);
            obj.put("issue_place", this.issue_place);
            obj.put("first_name", this.first_name);
            obj.put("last_name", this.last_name);
            obj.put("email", this.email);
            obj.put("gender", this.gender);
            obj.put("date_of_birth", this.day_of_birth);
            obj.put("place_of_birth", this.place_of_birth);
            obj.put("phone", this.phone);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
//			e.printStackTrace();
            System.out.println("Convert to JSON error" + e);
        }
        return obj;
    }

}
