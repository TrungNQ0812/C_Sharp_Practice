using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Core.Domain.Entities
{
    public class GoodsIssueNote
    {
        public int GoodsIssueNoteId { get; set; }
        public int OrderShipmentId { get; set; }
        public DateTime CreateAt { get; set; } = DateTime.UtcNow;

        public SalesOrderShipment OrderShipment { get; set; } = null!;
        public Invoice? Invoice { get; set; }
    }
}
