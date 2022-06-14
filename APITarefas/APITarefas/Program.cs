using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddDbContext<APITarefasContext>(options => options.UseInMemoryDatabase("TarefasDB"));

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.MapGet("/", () => "Teste");
app.MapGet("frases", async () => await new HttpClient().GetStringAsync("https://ron-swanson-quotes.herokuapp.com/v2/quotes"));

app.MapGet("/tarefas", async (APITarefasContext db) =>
{
    return await db.Tarefas.ToListAsync();
});

app.MapGet("/tarefas/{id}", async (int id, APITarefasContext db) =>
{
    return await db.Tarefas.FindAsync(id) is Tarefa tarefa ? Results.Ok(tarefa) : Results.NotFound();
});

app.MapGet("/tarefas/concluidas", async (APITarefasContext db) =>
{
    return await db.Tarefas.Where(t => t.isConcluida == true).ToListAsync();
});

app.MapPost("/tarefas", async (Tarefa tarefa, APITarefasContext db) =>
{
    db.Tarefas.Add(tarefa);
    await db.SaveChangesAsync();
    return Results.Created($"/tarefas/{tarefa.Id}", tarefa);
});

app.Run();

class Tarefa
{
    public int Id { get; set; }
    public string? Nome { get; set; }
    public bool isConcluida { get; set; }
}

class APITarefasContext : DbContext
{
    public APITarefasContext(DbContextOptions<APITarefasContext> options) : base(options)
    {}

    public DbSet<Tarefa> Tarefas => Set<Tarefa>();
}