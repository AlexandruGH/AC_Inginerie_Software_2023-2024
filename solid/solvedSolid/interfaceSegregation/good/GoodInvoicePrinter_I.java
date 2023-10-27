package interfaceSegregation.good;

import interfaceSegregation.ComplexInvoice;
import interfaceSegregation.Invoice;

public interface GoodInvoicePrinter_I {
    public void print(Invoice invoice);

    public void printComplexInvoice(ComplexInvoice complexInvoice);
}
