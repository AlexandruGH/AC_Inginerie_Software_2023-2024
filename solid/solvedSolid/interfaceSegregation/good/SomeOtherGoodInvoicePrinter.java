package interfaceSegregation.good;

import interfaceSegregation.Invoice;

public class SomeOtherGoodInvoicePrinter implements SomeOtherGoodInvoicePrinter_I {
    @Override
    public void someOtherPrintMethod(Invoice invoice) {
        System.out.println("Printing the Invoice in a totally different way " + invoice);
    }
}
