package my.eclipse.swt.examples.swt;

/*
 * GC example snippet: draw a thick line
 *
 * For a list of all SWT example snippets see
 * http://dev.eclipse.org/viewcvs/index.cgi/%7Echeckout%7E/platform-swt-home/dev.html#snippets
 */
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Snippet13 {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();
		GridLayoutFactory.fillDefaults().applyTo(shell);
		Composite testComposite = new Composite(shell, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(testComposite);
		final Text testTxt = new Text(testComposite, SWT.BORDER);
		testTxt.setText("Testing txt");
		final GC gc = new GC(shell);
		gc.setLineWidth(4);
		shell.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				gc.drawRectangle(testTxt.getBounds());
				// TODO Auto-generated method stub
				
			}
		});
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}