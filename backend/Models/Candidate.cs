using System.ComponentModel.DataAnnotations;

namespace backend.Models
{

    public class Candidate
    {
        [Key]
        public int Id { get; set; }

        [StringLength(50)]
        [Required]
        public string Name { get; set; }
    }
}