using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class RegistrationFormRepository : IRegistrationFormRepository
    {
        private QLTTNNContext context;
        public RegistrationFormRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<RegistrationFormDTO> GetAll()
        {
            return this.context.registration_forms.ToList().ConvertToRegistrationFormDTO();
        }
        public RegistrationFormDTO Get(int id)
        {
            return this.context.registration_forms.Find(id).ConvertToRegistrationFormDTO();
        }
        public RegistrationFormDTO Create(RegistrationFormDTO registrationFormDTO)
        {
            RegistrationForm registrationForm = registrationFormDTO.ConvertToRegistrationForm();
            this.context.registration_forms.Add(registrationForm);
            this.context.SaveChanges();
            return registrationFormDTO;
        }
        public void Update(RegistrationFormDTO registrationFormDTO)
        {
            RegistrationForm registrationForm = registrationFormDTO.ConvertToRegistrationForm();
            this.context.registration_forms.Update(registrationForm);
            this.context.SaveChanges();
        }
        public void Delete(int id)
        {
            var registrationForm = this.context.registration_forms.Find(id);
            this.context.registration_forms.Remove(registrationForm);
            this.context.SaveChanges();
        }
    }
}