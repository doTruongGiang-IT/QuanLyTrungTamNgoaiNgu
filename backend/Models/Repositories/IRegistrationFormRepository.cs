using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface IRegistrationFormRepository
    {
         IEnumerable<RegistrationFormDTO> GetAll();
         RegistrationFormDTO Get(int id);
         RegistrationFormDTO Create(RegistrationFormDTO registrationFormDTO);
         void Update(RegistrationFormDTO registrationFormDTO);
         void Delete(int id);
    }
}