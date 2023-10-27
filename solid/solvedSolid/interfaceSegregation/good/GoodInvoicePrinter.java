package interfaceSegregation.good;

import interfaceSegregation.ComplexInvoice;
import interfaceSegregation.Invoice;

public class GoodInvoicePrinter implements GoodInvoicePrinter_I {
    @Override
    public void print(Invoice invoice) {
        System.out.println("Printing Invoice " + invoice);
    }

    @Override
    public void printComplexInvoice(ComplexInvoice complexInvoice) {
        System.out.println("Printing Complex Invoice " + complexInvoice);
    }
}
