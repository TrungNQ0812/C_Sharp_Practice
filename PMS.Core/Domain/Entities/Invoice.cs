using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PMS.Core.Domain.Entities
{
    public class Invoice
    {
        public int InvoiceId { get; set; }
        public int GoodsIssueNoteId { get; set; }

        public string? TaxCode { get; set; }
        public string? Address { get; set; }
        public string? CustomerName { get; set; }
        public string? PaymentMethod { get; set; }
        public string? IdentityCard { get; set; }

        public GoodsIssueNote GoodsIssueNote { get; set; } = null!;

    }
}
