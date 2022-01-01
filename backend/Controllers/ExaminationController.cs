using backend.Models;
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
        public IActionResult Create([FromBody]Examination examination)
        {
            return Ok(this.repository.Create(examination));
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
        public IActionResult Update([FromBody]Examination examination)
        {
            try
            {
                this.repository.Update(examination);
                return Ok(examination);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}