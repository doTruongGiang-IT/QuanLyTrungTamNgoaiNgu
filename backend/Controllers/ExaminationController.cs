using backend.Models;
using backend.Models.DTOs;
using backend.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ExaminationController : ControllerBase
    {
        private readonly ILogger<ExaminationController> _logger;
        private readonly IExaminationRepository repository;

        public ExaminationController(ILogger<ExaminationController> logger, IExaminationRepository repository)
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
        public IActionResult Create([FromBody]ExaminationDTO examinationDTO)
        {
            return Ok(this.repository.Create(examinationDTO));
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
        public IActionResult Update([FromBody]ExaminationDTO examinationDTO)
        {
            try
            {
                this.repository.Update(examinationDTO);
                return Ok(examinationDTO);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }

        [HttpGet("current")]
        public IActionResult GetCurrent()
        {
            return Ok(this.repository.GetCurrent());    
        }
    }
}