using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CandidateController : ControllerBase
    {
        private readonly ILogger<CandidateController> _logger;

        public CandidateController(ILogger<CandidateController> logger)
        {
            _logger = logger;
        }

        [HttpGet]
        public String Get()
        {
            return "Hello world!";
        }
    }
}