using backend.Models;
using backend.Models.DTOs;
using backend.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class SupervisorRoomController : ControllerBase
    {
        private readonly ILogger<SupervisorController> _logger;
        private readonly ISupervisorRoomRepository repository;

        public SupervisorRoomController(ILogger<SupervisorController> logger, ISupervisorRoomRepository repository)
        {
            this._logger = logger;
            this.repository = repository;
        }

        [HttpGet]
        public IActionResult GetAll()
        {
            Dictionary<string, SupervisorRoomDTO[]> dictionary = new Dictionary<string, SupervisorRoomDTO[]>();
            SupervisorRoomDTO[] supervisorRoomDTOs = this.repository.GetAll().Cast<SupervisorRoomDTO>().ToArray();
            dictionary.Add("data", supervisorRoomDTOs);
            return Ok(dictionary);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]SupervisorRoomDTO supervisorRoomDTO)
        {
             try
            {
                SupervisorRoomDTO checkSupRoo = this.repository.Create(supervisorRoomDTO);
                return Ok(checkSupRoo);
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
        public IActionResult Update([FromBody]SupervisorRoomDTO supervisorRoomDTO)
        {
            try
            {
                this.repository.Update(supervisorRoomDTO);
                return Ok(supervisorRoomDTO);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}