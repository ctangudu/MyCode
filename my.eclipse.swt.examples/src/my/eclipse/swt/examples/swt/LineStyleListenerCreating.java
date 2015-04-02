package my.eclipse.swt.examples.swt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class LineStyleListenerCreating {
  public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);

    final StyledText styledText = new StyledText(shell, SWT.V_SCROLL | SWT.BORDER);

    styledText.addLineStyleListener(new LineStyleListener() {

      public void lineGetStyle(LineStyleEvent event) {
        java.util.List styles = new java.util.ArrayList();

        for (int i = 0, n = event.lineText.length(); i < n; i++) {
          if (event.lineText.charAt(i) == 'e') {
            int start = i;
            while (i < n && event.lineText.charAt(i) == 'e'){
              i++;
            }
            styles.add(new StyleRange(event.lineOffset + start, i - start, display
                .getSystemColor(SWT.COLOR_BLUE), null));
          }
        }
        event.styles = (StyleRange[]) styles.toArray(new StyleRange[0]);

      }
    });

    styledText.setBounds(10, 10, 500, 100);
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}