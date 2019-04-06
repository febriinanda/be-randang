package com.beehive.randang.invoice;

import com.beehive.randang.utils.ControllerFactoryAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController extends ControllerFactoryAdapter<Invoice, String, InvoiceServiceImpl> {
    @Override
    @GetMapping
    public List<Invoice> index() {
        return this.service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Invoice findById(@PathVariable String id) {
        return this.service.findById(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody Invoice invoice) {
        this.service.save(invoice);
    }

    @Override
    @PostMapping("/bulk")
    public void save(@RequestBody List<Invoice> list) {
        this.service.save(list);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable String id,@RequestBody Invoice invoice) {
        this.service.update(id, invoice);
    }
}
