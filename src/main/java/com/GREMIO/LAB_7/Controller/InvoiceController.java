package com.GREMIO.LAB_7.Controller;

// FIX: Import InvoiceService and Invoice from the MAIN package
import com.GREMIO.LAB_7.Invoice;
import com.GREMIO.LAB_7.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @MutationMapping
    public Invoice createInvoice(@Argument Long customerId, @Argument List<Long> productIds) {
        return invoiceService.createInvoice(customerId, productIds);
    }
}