using System.ComponentModel.DataAnnotations;

namespace backend.Models
{
    public class Examination
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public DateTime date { get; set; }
        public bool registration_status { get; set; }

        public ICollection<RegistrationForm> registrationForms { get; set; }

        public ICollection<Room> rooms { get; set; }
    }
}