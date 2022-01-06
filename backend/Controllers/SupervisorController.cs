using backend.Models;
using backend.Models.DTOs;
using backend.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class SupervisorController : ControllerBase
    {
        private readonly ILogger<SupervisorController> _logger;
        private readonly ISupervisorRepository repository;

        public SupervisorController(ILogger<SupervisorController> logger, ISupervisorRepository repository)
        {
            this._logger = logger;
            this.repository = repository;
        }

        [HttpGet]
        public IActionResult GetAll()
        {
            Dictionary<string, SupervisorDTO[]> dictionary = new Dictionary<string, SupervisorDTO[]>();
            SupervisorDTO[] supervisorDTOs = this.repository.GetAll().Cast<SupervisorDTO>().ToArray();
            dictionary.Add("data", supervisorDTOs);
            return Ok(dictionary);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]SupervisorDTO supervisorDTO)
        {
            try
            {
                SupervisorDTO checkSup = this.repository.Create(supervisorDTO);
                return Ok(checkSup);
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
        public IActionResult Update([FromBody]SupervisorDTO supervisorDTO)
        {
            try
            {
                this.repository.Update(supervisorDTO);
                return Ok(supervisorDTO);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}