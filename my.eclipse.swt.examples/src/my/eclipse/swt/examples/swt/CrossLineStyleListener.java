package my.eclipse.swt.examples.swt;

/*
 Revised from The Definitive Guide to SWT and JFace
 by Robert Harris and Rob Warner 
 Apress 2004
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CrossLineStyleListener {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);

		final StyledText styledText = new StyledText(shell, SWT.V_SCROLL | SWT.BORDER);

		final MultiLineCommentListener lineStyleListener = new MultiLineCommentListener();
		styledText.addLineStyleListener(lineStyleListener);

		styledText.addExtendedModifyListener(new ExtendedModifyListener() {
			public void modifyText(ExtendedModifyEvent event) {
				// Recalculate the comments
				lineStyleListener.refreshMultilineComments(styledText.getText());
				// Redraw the text
				styledText.redraw();
			}
		});

		styledText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				try {
					int offset = styledText.getOffsetAtLocation(new Point(e.x, e.y));
					StyleRange style = styledText.getStyleRangeAtOffset(offset);
					if (style != null && style.underline && style.underlineStyle == SWT.UNDERLINE_LINK) {
						System.out.println("Click on a Link");
					}
				} catch (IllegalArgumentException ex) {
					// no character under event.x, event.y
				}

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

class MultiLineCommentListener implements LineStyleListener {
	// Markers for multiline comments
//	private static final String COMMENT_START = "/*";
	private static final String COMMENT_START = "/*";
	private static final String COMMENT_END = "*/";

	// Color for comments
	private static final Color COMMENT_COLOR = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);

	List<int[]> commentOffsets = new LinkedList<int[]>();

	public void refreshMultilineComments(String text) {
		// Clear any stored offsets
		commentOffsets.clear();

		// Go through all the instances of COMMENT_START
		for (int pos = text.indexOf(COMMENT_START); pos > -1; pos = text.indexOf(COMMENT_START, pos)) {
			// offsets[0] holds the COMMENT_START offset
			// and COMMENT_END holds the ending offset
			int[] offsets = new int[2];
			offsets[0] = pos;

			// Find the corresponding end comment.
			pos = text.indexOf(COMMENT_END, pos);

			// If no corresponding end comment, use the end of the text
			offsets[1] = pos == -1 ? text.length() - 1 : pos + COMMENT_END.length() - 1;
			pos = offsets[1];

			// Add the offsets to the collection
			commentOffsets.add(offsets);
		}
	}

	/**
	 * Called by StyledText to get the styles for a line
	 * 
	 * @param event
	 *            the event
	 */
	public void lineGetStyle(LineStyleEvent event) {
		// Create a collection to hold the StyleRanges
		List<StyleRange> styles = new ArrayList<StyleRange>();

		// Store the length for convenience
		int length = event.lineText.length();

		for (int i = 0, n = commentOffsets.size(); i < n; i++) {
			int[] offsets = commentOffsets.get(i);

			// If starting offset is past current line--quit
			if (offsets[0] > event.lineOffset + length)
				break;

			// Check if we're inside a multi-line comment
			if (offsets[0] <= event.lineOffset + length && offsets[1] >= event.lineOffset) {
				// Calculate starting offset for StyleRange
				int start = Math.max(offsets[0], event.lineOffset);

				// Calculate length for style range
				int len = Math.min(offsets[1], event.lineOffset + length) - start + 1;

				// Add the style range
				// styles.add(new StyleRange(start, len, COMMENT_COLOR, null));
				StyleRange style = new StyleRange();
				style.start = start;
				style.length = len;
				style.underline = true;
				style.foreground = COMMENT_COLOR;
				style.underlineStyle = SWT.UNDERLINE_LINK;
				styles.add(style);
			}
		}

		// Copy all the ranges into the event
		event.styles = styles.toArray(new StyleRange[0]);
	}
}