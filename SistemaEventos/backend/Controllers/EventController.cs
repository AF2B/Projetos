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
    public class EventController : ControllerBase
    {
        
        private readonly DataContext context;

        public EventController(DataContext context)
        {
            this.context = context;

        }

        [HttpGet]
        public IEnumerable<Event> Get()
        {
            return context.Events;
        }

        [HttpGet("{id}")]
        public IEnumerable<Event> GetById(int id)
        {
            return context.Events.Where(_event => _event.EventId == id);
        }
    }
}
