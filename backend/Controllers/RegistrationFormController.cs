using backend.Models;
using backend.Models.DTOs;
using backend.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class RegistrationFormController : ControllerBase
    {
        private readonly ILogger<RegistrationFormController> _logger;
        private readonly IRegistrationFormRepository repository;
        private readonly ICandidateRoomRepository candidateRoomRepository;
        private readonly IRoomRepository roomRepository;
        private readonly IExaminationRepository examinationRepository;
        public RegistrationFormController(ILogger<RegistrationFormController> logger, IRegistrationFormRepository repository, ICandidateRoomRepository candidateRoomRepository, IRoomRepository roomRepository, IExaminationRepository examinationRepository)
        {
            this._logger = logger;
            this.repository = repository;
            this.candidateRoomRepository = candidateRoomRepository;
            this.roomRepository = roomRepository;
            this.examinationRepository = examinationRepository;
        }

        [HttpGet]
        public IActionResult GetAll()
        {
            Dictionary<string, RegistrationFormDTO[]> dictionary = new Dictionary<string, RegistrationFormDTO[]>();
            RegistrationFormDTO[] registrationFormDTOs = this.repository.GetAll().Cast<RegistrationFormDTO>().ToArray();
            dictionary.Add("data", registrationFormDTOs);
            return Ok(dictionary);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]RegistrationFormDTO registrationFormDTO)
        {
            try
            {
                var checkRegFr = this.repository.Create(registrationFormDTO);
                if(checkRegFr == null)
                {
                    return BadRequest();
                }
                return Ok(checkRegFr);
            }
            catch(Exception ex)
            {
                return BadRequest();
            }
            
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            try
            {
                this.repository.Delete(id);
                return Ok(id);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }

        [HttpPut]
        public IActionResult Update([FromBody]RegistrationFormDTO registrationFormDTO)
        {
            try
            {
                this.repository.Update(registrationFormDTO);
                return Ok(registrationFormDTO);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
                
        [HttpGet("arrange")]
        public IActionResult Arange()
        {
            IEnumerable<RegistrationFormDTO> registrations = this.repository.GetAll();
            List <RegistrationFormDTO> registrationsCurrentExamsA2 = new List<RegistrationFormDTO>();
            List <RegistrationFormDTO> registrationsCurrentExamsB1 = new List<RegistrationFormDTO>();

            int currentExamID = examinationRepository.GetCurrent().id;

            foreach (RegistrationFormDTO registration in registrations) 
            {
                if (registration.examination_id == currentExamID){
                    if (registration.level == "A2"){
                        registrationsCurrentExamsA2.Add(registration);
                    }
                    else{
                        registrationsCurrentExamsB1.Add(registration);
                    }
                }
            }

            int minSize = 30;
            int maxSize = 35;
            int candidateSize; 

            string[] levels = {"A2", "B1"};

            foreach (string level in levels){                
                List <RegistrationFormDTO> registrationsCurrentExams;

                if (level == "A2"){
                    candidateSize = registrationsCurrentExamsA2.Count;
                    registrationsCurrentExams = registrationsCurrentExamsA2;
                }
                else {
                    candidateSize = registrationsCurrentExamsB1.Count;
                    registrationsCurrentExams = registrationsCurrentExamsB1;
                }
                

                int roomCount = candidateSize / minSize;
                int candidateLefts = candidateSize % minSize;
                bool canArange = false;

                if ((maxSize - minSize) * roomCount >= candidateLefts) {
                    canArange = true;
                }

                int roomMinValue;
                int roomMaxValue;
                int roomMaxCount;
                int roomMinCount;

                if (canArange) {
                    roomMinValue = candidateSize / roomCount;
                    roomMaxValue = roomMinValue + 1;
                    roomMaxCount = candidateSize % roomCount;
                    roomMinCount = roomCount - roomMaxCount;
                }
                else {
                    roomMinValue = candidateLefts;
                    roomMaxValue = minSize;
                    roomMaxCount = roomCount;
                    roomMinCount = 1;
                }

                Console.WriteLine(roomMinValue);
                Console.WriteLine(roomMaxValue);
                Console.WriteLine(roomMaxCount);
                Console.WriteLine(roomMinCount);

                int roomId=1;
                int candidateId = 1;
                var rand = new Random();

                for (int i=1; i<=roomMaxCount; i++){
                    RoomDTO room = new RoomDTO(){
                        id = 0,
                        name = level + "P" + roomId.ToString("D2"),
                        examination_id = currentExamID,
                        level = level,
                        time = rand.NextDouble() > 0.5
                    };
                    RoomDTO newRoom = roomRepository.Create(room);

                    for (int j=1; j<=roomMaxValue; j++){
                        CandidateRoomDTO candidateRoom = new CandidateRoomDTO(){
                            id = 0,
                            candidate_id = registrationsCurrentExams[candidateId-1].candidate_id,
                            candidate_no = level + candidateId.ToString("D3"),
                            room_id = newRoom.id,
                            score_listening = 0,
                            score_speaking = 0,
                            score_writing = 0,
                            score_reading = 0
                        };
                        candidateRoomRepository.Create(candidateRoom);
                        candidateId++;
                    }
                    roomId++;
                }

                for (int i=1; i<=roomMinCount; i++){
                    RoomDTO room = new RoomDTO(){
                        id = 0,
                        name = level + "P" + roomId.ToString("D2"),
                        examination_id = currentExamID,
                        level = level,
                        time = rand.NextDouble() > 0.5
                    };
                    RoomDTO newRoom = roomRepository.Create(room);

                    for (int j=1; j<=roomMinValue; j++){
                        CandidateRoomDTO candidateRoom = new CandidateRoomDTO(){
                            id = 0,
                            candidate_id = registrationsCurrentExams[candidateId-1].candidate_id,
                            candidate_no = level + candidateId.ToString("D3"),
                            room_id = newRoom.id,
                            score_listening = 0,
                            score_speaking = 0,
                            score_writing = 0,
                            score_reading = 0
                        };
                        candidateRoomRepository.Create(candidateRoom);
                        candidateId++;
                    }
                    roomId++;
                }
            }

            return StatusCode(200);   
        }
    }
}