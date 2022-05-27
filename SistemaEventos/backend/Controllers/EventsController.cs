using System;
using System.Collections.Generic;
using System.Linq;
using backend.Data;
using backend.Models;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class EventsController : ControllerBase
    {
        
        private readonly DataContext context;

        public EventsController(DataContext context)
        {
            this.context = context;
        }

        [HttpGet]
        public IEnumerable<Event> Get()
        {
            return context.Events;
        }

        [HttpGet("{id}")]
        public Event GetById(int id) => (Event)context.Events.Where(_event => _event.EventId == id);
    }
}
