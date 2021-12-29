using System.ComponentModel.DataAnnotations;
// using System.Data.Entity.Core;

namespace backend.Models
{
    public class Supervisor
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
    }
}