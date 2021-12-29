using backend.Models;
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
            return Ok(this.repository.GetAll());
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]SupervisorRoom supervisorRoom)
        {
            return Ok(this.repository.Create(supervisorRoom));
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
        public IActionResult Update([FromBody]SupervisorRoom supervisorRoom)
        {
            try
            {
                this.repository.Update(supervisorRoom);
                return Ok(supervisorRoom);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}