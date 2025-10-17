using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Core.Domain.Entities
{
    public class CustomerDept
    {
        public int CustomerDeptId { get; set; }
        public int OrderId { get; set; }
        public decimal DeptAmount { get; set; }

        public SalesOrder Order { get; set; } = null!;
    }
}
