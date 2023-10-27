package dependencyInversion.good;

import interfaceSegregation.Invoice;
import interfaceSegregation.good.GoodInvoicePrinter;
import interfaceSegregation.good.GoodInvoicePrinter_I;

public class GoodPrintingService {
    private GoodInvoicePrinter_I goodInvoicePrinter;

    public GoodPrintingService(GoodInvoicePrinter_I goodInvoicePrinter) {
        this.goodInvoicePrinter = goodInvoicePrinter;
    }

    public void print(Invoice invoice) {
        this.goodInvoicePrinter.print(invoice);
    }
}
