package my.eclipse.swt.examples.swt;

/*
 * ToolBar example snippet: create a tool bar (text)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet18 {

public static void main (String [] args) {
	Shell shell = new Shell ();
	ToolBar bar = new ToolBar (shell, SWT.BORDER);
	for (int i=0; i<2; i++) {
		ToolItem item = new ToolItem (bar, SWT.PUSH);
		item.setText ("Item " + i);
	}
	GridDataFactory.fillDefaults().hint(500, SWT.DEFAULT).applyTo(bar);
	Rectangle clientArea = shell.getClientArea ();
	bar.setLocation (clientArea.x, clientArea.y);
	bar.pack ();
	shell.open ();
	Display display = shell.getDisplay ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
} 
}
