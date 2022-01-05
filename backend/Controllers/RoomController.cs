using backend.Models;
using backend.Models.DTOs;
using backend.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class RoomController : ControllerBase
    {
         private readonly ILogger<RoomController> _logger;
        private readonly IRoomRepository repository;

        public RoomController(ILogger<RoomController> logger, IRoomRepository repository)
        {
            this._logger = logger;
            this.repository = repository;
        }

        [HttpGet]
        public IActionResult GetAll()
        {
            Dictionary<string, RoomDTO[]> dictionary = new Dictionary<string, RoomDTO[]>();
            RoomDTO[] roomDTOs = this.repository.GetAll().Cast<RoomDTO>().ToArray();
            dictionary.Add("data", roomDTOs);
            return Ok(dictionary);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]RoomDTO roomDTO)
        {
            try
            {
                RoomDTO checkRoom = this.repository.Create(roomDTO);
                return Ok(checkRoom);
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
        public IActionResult Update([FromBody]RoomDTO roomDTO)
        {
            try
            {
                this.repository.Update(roomDTO);
                return Ok(roomDTO);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}