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
            Dictionary<string, ExaminationDTO[]> dictionary = new Dictionary<string, ExaminationDTO[]>();
            ExaminationDTO[] examinationDTOs = this.repository.GetAll().Cast<ExaminationDTO>().ToArray();
            dictionary.Add("data", examinationDTOs);
            return Ok(dictionary);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {   

            return Ok(this.repository.Get(id));
        }   

        [HttpPost]
        public IActionResult Create([FromBody]ExaminationDTO examinationDTO)
        {
            try{
                var checkExam = this.repository.Create(examinationDTO);
                if(checkExam == null)
                {
                    return BadRequest();
                }
                return Ok(checkExam);
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
        public IActionResult Update([FromBody]ExaminationDTO examinationDTO)
        {
            try
            {
                var checkExam = this.repository.Update(examinationDTO);
                if(checkExam == null)
                {
                    return BadRequest();
                }
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
            try{
                var examination =  this.repository.GetCurrent();
                return Ok(examination);
            }catch(Exception ex)
            {
                return StatusCode(500);
            }
                
        }
    }
}