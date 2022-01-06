namespace backend.Models.DTOs
{
    public class RoomDTO
    {
        public int id { get; set; }
        public string name { get; set; }
        public int examination_id { get; set; }
        public string level { get; set; }
        public bool time { get; set; }
    }
}