package com.beehive.randang.utils;

import com.beehive.randang.invoice.Invoice;
import com.beehive.randang.invoice.InvoiceServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class InvoiceIdGenerator implements IdentifierGenerator {
    private static InvoiceServiceImpl invoiceService;

    public InvoiceIdGenerator() {
    }

    @Autowired
    public InvoiceIdGenerator(InvoiceServiceImpl invoiceService) {
        this();
        InvoiceIdGenerator.invoiceService = invoiceService;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "INV-";
        LocalDate now = LocalDate.now();
        int i;
        Invoice invoice = invoiceService.findLastInvoice();

        if(invoice == null){
            i = 1;
        }else{
            String lastId = invoice.getId();
            i = Integer.parseInt(lastId.substring(10).replaceFirst("^0+(?!$)", "")) + 1;
        }
        return this.finishing(i, prefix, now);
    }

    private Serializable finishing(int i, String prefix, LocalDate now) {
        return prefix + now.getYear() + String.format("%02d", now.getMonthValue()) + String.format("%08d", i);
    }
}
