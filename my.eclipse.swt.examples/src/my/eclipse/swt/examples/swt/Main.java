package my.eclipse.swt.examples.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Main {
	protected Shell shell;
	protected Shell tooltip;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setLayout(new GridLayout(1, false));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		{
			final Button btnShowTheFake = new Button(shell, SWT.TOGGLE);
			btnShowTheFake.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					if (btnShowTheFake.getSelection()) {
						Rectangle bounds = btnShowTheFake.getBounds();
						Point pos = shell.toDisplay(bounds.x + 5, bounds.y + bounds.height);
						tooltip = showTooltip(shell, pos.x, pos.y);
						btnShowTheFake.setText("Hide it");
					} else {
						if (tooltip != null && !tooltip.isDisposed())
							tooltip.dispose();
						btnShowTheFake.setText("Show The Fake Tooltip");
					}
				}
			});
			btnShowTheFake.setText("Show The Fake Tooltip");
		}
	}

	/**
	 * Show the fake tooltip. Don't forget to hide it by yourself.
	 * 
	 * @param parent
	 * @param x
	 * @param y
	 * @return
	 */
	public Shell showTooltip(Shell parent, int x, int y) {
		Shell tooltip = new Shell(parent, SWT.TOOL | SWT.ON_TOP);
		tooltip.setLayout(new GridLayout());

		tooltip.setBackground(tooltip.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		tooltip.setBackgroundMode(SWT.INHERIT_FORCE);

		Label lbContent = new Label(tooltip, SWT.NONE);
		lbContent.setText("Hello world! I'm a fake tooltip");

		Point lbContentSize = lbContent.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		int width = lbContentSize.x + 10;
		int height = lbContentSize.y + 10;

		tooltip.setBounds(x, y, width, height);
		tooltip.setVisible(true);
		return tooltip;
	}
}