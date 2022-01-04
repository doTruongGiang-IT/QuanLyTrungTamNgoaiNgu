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
            return Ok(this.repository.GetAll());
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]RoomDTO roomDTO)
        {
            return Ok(this.repository.Create(roomDTO));
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