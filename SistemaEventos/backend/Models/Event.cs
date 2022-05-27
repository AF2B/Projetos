namespace backend.Models
{
    public class Event
    {
        public int EventId { get; set; }

        public int LengthMax { get; set; }

        public string Local { get; set; }

        public string EventDate { get; set; }

        public string Theme { get; set; }

        public string Lote { get; set; }

        public string ImageURL { get; set; }
    }
}