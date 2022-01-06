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

        public RegistrationFormController(ILogger<RegistrationFormController> logger, IRegistrationFormRepository repository)
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
        public IActionResult Create([FromBody]RegistrationFormDTO registrationFormDTO)
        {
            try
            {
                RegistrationFormDTO checkRegFr = this.repository.Create(registrationFormDTO);
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
    }
}