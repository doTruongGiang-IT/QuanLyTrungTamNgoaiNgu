namespace backend.Models.Repositories
{
    public interface IRegistrationFormRepository
    {
         IEnumerable<RegistrationForm> GetAll();
         RegistrationForm Get(int id);
         RegistrationForm Create(RegistrationForm registrationForm);
         void Update(RegistrationForm registrationForm);
         void Delete(int id);
    }
}