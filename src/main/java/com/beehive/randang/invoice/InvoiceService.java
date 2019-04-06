package com.beehive.randang.invoice;

import com.beehive.randang.utils.ServiceFactory;

interface InvoiceService extends ServiceFactory<Invoice, String> {
    Invoice findLastInvoiceThisMonth();
}
