
package my.eclipse.swt.examples.swt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;

public class ComboDecoration {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));
        final ToolTip tip = new ToolTip(shell, SWT.BALLOON);
        tip.setMessage("Here is a message for the user. When the message is too long it wraps. I should say something cool but nothing comes to my mind.");

        Text tfTooltip = new Text(shell, SWT.BORDER);
        tfTooltip.setText("sample text field");
        tfTooltip.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                tip.setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                Text actionWidget = (Text) e.widget;
                Point loc = actionWidget.toDisplay(actionWidget.getLocation());
                tip.setLocation(loc.x + actionWidget.getSize().x - actionWidget.getBorderWidth(), loc.y);
                tip.setVisible(true);
            }
        });
        Button tfNext = new Button(shell, SWT.ARROW | SWT.DOWN);
        tfNext.setText("TF without tooltip");
        tfNext.setImage(Display.getDefault().getSystemImage(SWT.ARROW | SWT.DOWN));
        shell.setBounds(50, 50, 300, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}