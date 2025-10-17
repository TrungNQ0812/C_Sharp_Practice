using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Core.Domain.Enums
{
    public enum SalesOrderStatus : byte
    {
        Draft = 0, 
        Send = 1,
        Confirmed = 2,
        Cancelled = 3
    }
}
