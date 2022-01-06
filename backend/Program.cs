using backend.Models.Data;
using backend.Models.Repositories;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<QLTTNNContext>(options => options.UseNpgsql(connectionString));
builder.Services.AddControllers();
builder.Services.AddScoped<ICandidateRepository, CandidateRepository>();
builder.Services.AddScoped<ISupervisorRepository, SupervisorRepository>();
builder.Services.AddScoped<IRoomRepository, RoomRepository>();
builder.Services.AddScoped<IExaminationRepository, ExaminationRepository>();
builder.Services.AddScoped<ICandidateRoomRepository, CandidateRoomRepository>();
builder.Services.AddScoped<ISupervisorRoomRepository, SupervisorRoomRepository>();
builder.Services.AddScoped<IRegistrationFormRepository, RegistrationFormRepository>();
builder.Services.AddCors(options =>
            {
                options.AddPolicy("CorsPolicy", policy =>
                {
                    policy.AllowAnyHeader().AllowAnyMethod().WithOrigins("http://localhost:3000");
                });
            });
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// var serviceScope = app.ApplicationServices.GetService<IServiceScopeFactory>().CreateScope();
// var context = serviceScope.ServiceProvider.GetRequiredService<QLTTNNContext>();
// context.Database.Migrate();

using (var scope = app.Services.CreateScope())
{
    var db = scope.ServiceProvider.GetRequiredService<QLTTNNContext>();
    db.Database.EnsureCreated();
}

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.UseCors("CorsPolicy");

app.MapControllers();

app.Run();
