package dependencyInversion.good;

import interfaceSegregation.ComplexInvoice;
import interfaceSegregation.Invoice;
import interfaceSegregation.good.GoodInvoicePrinter;
import interfaceSegregation.good.GoodInvoicePrinter_I;

public class HtmlInvoicePrinter implements GoodInvoicePrinter_I {
    @Override
    public void print(Invoice invoice) {
        System.out.println("This is a HTML printer " + invoice);
    }

    @Override
    public void printComplexInvoice(ComplexInvoice complexInvoice) {
        System.out.println("This is a complex HTML printer " + complexInvoice);
    }
}
