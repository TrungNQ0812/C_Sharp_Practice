using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Core.Domain.Entities
{
    public class SalesOrderDetails
    {
        public int SalesOrderDetailsId { get; set; }
        public int SalesOrderId { get; set; } 
        public int ProductId { get; set; }
        public decimal TotalPrice { get; set; }

        public SalesOrder Order { get; set; } = null!;
    }
}
