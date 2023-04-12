package realization;

public class PrintMulti implements Printable{

	@Override
	public void print() {
		System.out.println("[Printer] Printing document");
	}

	@Override
	public void scan() {
		System.out.println("[Scanner] Scanning document");
	}
}
