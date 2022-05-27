using System;
using System.Collections.Generic;
using System.Linq;
using backend.Models;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class EventController : ControllerBase
    {
        public IEnumerable<Event> _event = new Event[] {
            new Event() {
                EventId = 1,
                Theme = "Angular é show!" ,
                Local = "Pernambuco",
                Lote = "Primeiro",
                LengthMax = 250,
                EventDate = DateTime.Now.AddDays(2).ToString("dd/MM/yyyy"),
                ImageURL = "Photo.png"
            },
            new Event() {
                EventId = 2,
                Theme = "React também!" ,
                Local = "Pernambuco",
                Lote = "Segundo",
                LengthMax = 550,
                EventDate = DateTime.Now.AddDays(2).ToString("dd/MM/yyyy"),
                ImageURL = "Photo2.png"
            }
        };

        public EventController()
        {

        }

        [HttpGet]
        public IEnumerable<Event> Get()
        {
            return _event;
        }

        [HttpGet("{id}")]
        public IEnumerable<Event> GetById(int id)
        {
            return _event.Where(_event => _event.EventId == id);
        }
    }
}
