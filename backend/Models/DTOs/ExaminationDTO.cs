namespace backend.Models.DTOs
{
    public class ExaminationDTO
    {
        public int id { get; set; }
        public string name { get; set; }
        public string date { get; set; }
        public bool registration_status { get; set; }
    }
}