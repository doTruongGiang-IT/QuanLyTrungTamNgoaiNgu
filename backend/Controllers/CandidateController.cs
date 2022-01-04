using backend.Models;
using backend.Models.DTOs;
using backend.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CandidateController : ControllerBase
    {
        private readonly ILogger<CandidateController> _logger;
        private readonly ICandidateRepository repository;

        public CandidateController(ILogger<CandidateController> logger, ICandidateRepository repository)
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
        public IActionResult Create([FromBody]CandidateDTO candidateDTO)
        {
            return Ok(this.repository.Create(candidateDTO));
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
        public IActionResult Update([FromBody]CandidateDTO candidateDTO)
        {
            try
            {
                this.repository.Update(candidateDTO);
                return Ok(candidateDTO);
            }
            catch(Exception ex)
            {
                return NotFound();
            }
        }
    }
}