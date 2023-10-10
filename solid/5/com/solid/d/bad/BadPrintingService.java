package com.solid.d.bad;

import com.solid.i.Invoice;
import com.solid.i.good.GoodInvoicePrinter;

public class BadPrintingService {

	private GoodInvoicePrinter invoicePrinter; // notice the lack of an interface!

	public BadPrintingService() {
		this.invoicePrinter = new GoodInvoicePrinter();
	}

	public void print(Invoice invoice) {
		invoicePrinter.print(invoice);
	}

}
