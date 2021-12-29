using System.ComponentModel.DataAnnotations;

namespace backend.Models
{
    public class Examination
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public DateTime date { get; set; }
    }
}