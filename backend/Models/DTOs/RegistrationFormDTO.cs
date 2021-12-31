namespace backend.Models.DTOs
{
    public class RegistrationFormDTO
    {
        public int id { get; set; }
        public int candidate_id { get; set; }
        public int examination_id { get; set; }
        public string level { get; set; }
        public bool status { get; set; }
    }
}