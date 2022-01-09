using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class RoomRepository : IRoomRepository
    {
        private QLTTNNContext context;
        private ICandidateRepository candidateRepository;
        public RoomRepository(QLTTNNContext context, ICandidateRepository candidateRepository)
        {
            this.context = context;
            this.candidateRepository = candidateRepository;
        }

        public IEnumerable<RoomDTO> GetAll()
        {
            return this.context.rooms.ToList().ConvertToRoomDTO();
        }
        public RoomDTO Get(int id)
        {
            return this.context.rooms.Find(id).ConvertToRoomDTO();
        }
        public RoomDTO Create(RoomDTO roomDTO)
        {
            Room room = roomDTO.ConvertToRoom();
            var result = this.context.rooms.Add(room);
            this.context.SaveChanges();
            RoomDTO roomDTOResult = result.Entity.ConvertToRoomDTO();
            return roomDTOResult;
        }
        public void Update(RoomDTO roomDTO)
        {
            Room room = roomDTO.ConvertToRoom();
            this.context.rooms.Update(room);
            this.context.SaveChanges();
        }
        public void Delete(int id)
        {
            var room = this.context.rooms.Find(id);
            this.context.rooms.Remove(room);
            this.context.SaveChanges();
        }
        public IEnumerable<RoomDTO> GetByExam(int exmination_id){
            return this.context.rooms.Where(r => r.examination_id==exmination_id).ToList().ConvertToRoomDTO();
        }

        public StatisticDTO ConvertRoomToStatisticDTO(Room room)
        {
            IEnumerable<CandidateDTO> candidates = this.candidateRepository.GetByRoom(room.id);
            return new StatisticDTO()
            {
                name = room.name,
                count = candidates.Count()
            };
        }
        public IEnumerable<StatisticDTO> GetByExamLevel(int exmination_id, string level){
            IEnumerable<Room> rooms =  this.context.rooms.Where(r => r.examination_id==exmination_id && r.level==level).ToList();
            List<StatisticDTO> statisticDTOs = new List<StatisticDTO>();
            foreach(Room room in rooms)
            {
                statisticDTOs.Add(this.ConvertRoomToStatisticDTO(room));
            }
            return statisticDTOs;
        }
    }
}