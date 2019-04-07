package com.beehive.randang.invoice;

import com.beehive.randang.exception.ResourceNotFound;
import com.beehive.randang.invoice.detail.InvoiceDetail;
import com.beehive.randang.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
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
    public Invoice findLastInvoiceThisMonth() {
        LocalDateTime lastDay = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        PageRequest pageRequest = PageRequest.of(0, 1);

        return this.findOne(invoiceRepository.findAll(
                Specification.where(InvoiceSpecification.fromLastEntry())
                        .and(InvoiceSpecification.before(DateUtils.toDate(lastDay))), pageRequest).getContent(), 0);
    }

    @Override
    public Invoice findOne(List<Invoice> invoices, int index) {
        if(invoices.size() < 1)
            return null;

        if(index < 0 || index > invoices.size() - 1)
            throw new ResourceNotFound();

        return invoices.get(index);
    }

    @Override
    public void submit(Invoice invoice) {
        for (InvoiceDetail detail : invoice.getDetails()) {
            detail.setInvoice(invoice);
        }

        this.save(invoice);
    }
}
