package interfaceSegregation.bad;

import interfaceSegregation.ComplexInvoice;
import interfaceSegregation.Invoice;

public class BadInvoicePrinter implements BadInvoicePrinter_I{
    @Override
    public void print(Invoice invoice) {
        System.out.println("Printing invoice " + invoice);
    }

    @Override
    public void printComplexInvoice(ComplexInvoice complexInvoice) {
        System.out.println("Printing complex invoice " + complexInvoice);
    }

    @Override
    public void someOtherPrintMethod(Invoice invoice) {
        //don't need this here, leaving unimplemented
    }
}
