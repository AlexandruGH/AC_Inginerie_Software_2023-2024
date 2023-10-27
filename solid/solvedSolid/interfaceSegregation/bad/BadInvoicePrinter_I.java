package interfaceSegregation.bad;

import interfaceSegregation.ComplexInvoice;
import interfaceSegregation.Invoice;

public interface BadInvoicePrinter_I {
    public void print(Invoice invoice);

    public void printComplexInvoice(ComplexInvoice complexInvoice);

    public void someOtherPrintMethod(Invoice invoice);
}
