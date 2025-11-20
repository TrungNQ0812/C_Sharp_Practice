using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Application.DTOs.PO
{
    public class PODetailViewDTO
    {  
        public int PODID { get; set; }

        public int ProductID { get; set; }
        public string ProductName { get; set; }
        public string DVT { get; set; }
        public int Quantity { get; set; }
        public decimal UnitPrice { get; set; }
        public decimal UnitPriceTotal { get; set; }
        public string Description { get; set; }
        public int POID { get; set; }
        public int RemainingQty { get; set; }
        public DateTime ExpiredDate { get; set; }

    }
}
