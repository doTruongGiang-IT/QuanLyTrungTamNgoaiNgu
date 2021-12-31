using backend.Models;
using backend.Models.DTOs;
using backend.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CandidateRoomController : ControllerBase
    {
        private readonly ILogger<CandidateRoomController> _logger;
        private readonly ICandidateRoomRepository repository;

        public CandidateRoomController(ILogger<CandidateRoomController> logger, ICandidateRoomRepository repository)
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
        public IActionResult Create([FromBody]CandidateRoomDTO candidateRoomDTO)
        {
            return Ok(this.repository.Create(candidateRoomDTO));
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
        public IActionResult Update([FromBody]CandidateRoomDTO candidateRoomDTO)
        {
            try
            {
                this.repository.Update(candidateRoomDTO);
                return Ok(candidateRoomDTO);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}