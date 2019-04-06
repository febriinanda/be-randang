package com.beehive.randang.invoice;

import com.beehive.randang.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(String id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void save(List<Invoice> list) {
        invoiceRepository.saveAll(list);
    }

    @Override
    public void update(String id, Invoice invoice) {
        Invoice exist = this.shouldExist(id);

        invoice.setId(exist.getId());
        this.save(invoice);
    }

    @Override
    public Invoice shouldExist(String id) {
        Invoice invoice = this.findById(id);

        if(invoice == null)
            throw new ResourceNotFound("invoice");

        return invoice;
    }

    @Override
    public Invoice findLastInvoice() {
        return invoiceRepository.findOne(Specification.where(InvoiceSpecification.fromLastEntry())).orElse(null);
    }
}
