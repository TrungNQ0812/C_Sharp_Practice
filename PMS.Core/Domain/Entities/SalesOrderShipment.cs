using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Core.Domain.Entities
{
    public class SalesOrderShipment
    {
        public int OrderShipmentId { get; set; }
        public int SaleOrderId { get; set; }
        public DateTime CreateAt { get; set; } = DateTime.Now;
        public bool IsPayment { get; set; }
        public decimal? PaymentAmount { get; set; }

        public SalesOrder SaleOrder { get; set; } = null!;
        public GoodsIssueNote? GoodsIssueNote { get; set; } 
    }
}
