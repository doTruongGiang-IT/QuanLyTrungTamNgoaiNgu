package DTO;

import org.json.JSONException;
import org.json.JSONObject;

public class ExaminationDTO {

    private int id;
    private String name;
    private String date;
    private boolean registration_status;

    public ExaminationDTO() {
    }

    public ExaminationDTO(JSONObject data) {
        try {
            this.id = data.getInt("id");
            this.name = data.getString("name");
            this.date = data.getString("date");
            this.registration_status = data.getBoolean("registration_status");
        } catch (JSONException e) {
            System.out.println("Examination error convert json -> dto");
        }
    }

    public ExaminationDTO(int id, String name, String date, boolean registration_status) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.registration_status = registration_status;
    }

    public ExaminationDTO(String name, String date, boolean registration_status) {
        super();
        this.name = name;
        this.date = date;
        this.registration_status = registration_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRegistration_status() {
        return registration_status;
    }

    public void setRegistration_status(boolean registration_status) {
        this.registration_status = registration_status;
    }
    
    public String getCompleteName(){
        return this.id + " | " + this.name;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", this.id);
            obj.put("name", this.name);
            obj.put("date", this.date);
            obj.put("registration_status", this.registration_status);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
//			e.printStackTrace();
            System.out.println("Convert to JSON error" + e);
        }
        return obj;
    }
}
