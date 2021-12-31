using backend.Models.Data;

namespace backend.Models.Repositories
{
    public class RegistrationFormRepository : IRegistrationFormRepository
    {
        private QLTTNNContext context;
        public RegistrationFormRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<RegistrationForm> GetAll()
        {
            return this.context.registration_forms.ToList();
        }
        public RegistrationForm Get(int id)
        {
            return this.context.registration_forms.Find(id);
        }
        public RegistrationForm Create(RegistrationForm registrationForm)
        {
            this.context.registration_forms.Add(registrationForm);
            this.context.SaveChanges();
            return registrationForm;
        }
        public void Update(RegistrationForm registrationForm)
        {
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