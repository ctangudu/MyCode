
package my.eclipse.swt.examples.swt;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TextFieldTooltip {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));
        
        Combo combo = new Combo(shell, SWT.NONE);
        
     // Create the decoration for the text UI component
        final ControlDecoration deco = 
         new ControlDecoration(combo, SWT.TOP | SWT.RIGHT);

        // Re-use an existing image
        Image image = FieldDecorationRegistry.
          getDefault().
          getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).
          getImage();
        // Set description and image
        deco.setDescriptionText("This is a tooltip text");
        deco.setImage(image);
        // Hide deco if not in focus
        deco.setShowOnlyOnFocus(true); 
        
        shell.setBounds(50, 50, 300, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}