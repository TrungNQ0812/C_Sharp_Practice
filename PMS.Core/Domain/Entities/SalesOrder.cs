using PMS.Core.Domain.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Core.Domain.Entities
{
    public class SalesOrder
    {
        public int OrderId { get; set; }
        public int? SalesQuotationId { get; set; }
        public int? CustomerProfileId { get; set; }
        public string? CreateBy { get; set; }
        public DateTime CreateAt { get; set; } = DateTime.Now;
        public SalesOrderStatus Status { get; set; }    
        public bool IsDeposit { get; set; }
        public decimal? Deposit { get; set; }
        public decimal OrderTotalPrice { get; set; }
        public int? CustomerDeptId { get; set; }       

        // Navs
        public ICollection<SalesOrderDetails> OrderDetails { get; set; } = new List<SalesOrderDetails>();
        public ICollection<SalesOrderShipment> OrderShipments { get; set; } = new List<SalesOrderShipment>();
        public CustomerDept? CustomerDept { get; set; }
        public CustomerProfile? CustomerProfile { get; set; }
        public StaffProfile? StaffProfile { get; set; }
    }
}
