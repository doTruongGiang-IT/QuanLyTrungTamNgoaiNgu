using System.ComponentModel.DataAnnotations;

namespace backend.Models
{
    public class Room
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public int examination_id { get; set; }
        public string level { get; set; }
        public bool time { get; set; } 
    }
}