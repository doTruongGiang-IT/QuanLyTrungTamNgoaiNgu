using backend.Models;
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
            return Ok(this.repository.GetAll());
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]Supervisor supervisor)
        {
            return Ok(this.repository.Create(supervisor));
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
        public IActionResult Update([FromBody]Supervisor supervisor)
        {
            try
            {
                this.repository.Update(supervisor);
                return Ok(supervisor);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}