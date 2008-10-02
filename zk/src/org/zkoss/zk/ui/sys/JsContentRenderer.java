/* JsContentRenderer.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct  1 19:08:57     2008, Created by tomyeh
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zk.ui.sys;

/**
 * An implementation of {@link ContentRenderer} that renders
 * the content as a JavaScript property (i.e., name: 'value').
 * @author tomyeh
 * @since 5.0.0
 */
public class JsContentRenderer implements ContentRenderer {
	private final StringBuffer _buf = new StringBuffer(128);

	public JsContentRenderer() {
	}

	/** Returns the content being rendered.
	 */
	public StringBuffer getBuffer() {
		return _buf;
	}
	/** Renders a property.
	 * @param name the property name. Note: it must be a legal JavaScript
	 * variable name.
	 */
	public void render(String name, String value) {
		if (_buf.length() > 0) _buf.append(',');
		_buf.append(name).append(':');
		if (value == null) _buf.append((String)null);
		else {
			_buf.append('\'');
			for (int j = 0, len = value.length(); j < len; ++j) {
				char cc = value.charAt(j);
				switch (cc) {
				case '\'':
				case '\\': _buf.append('\\'); break;
				case '\n': _buf.append('\\'); cc = 'n'; break;
				case '\t': _buf.append('\\'); cc = 't'; break;
				case '\r': _buf.append('\\'); cc = 'r'; break;
				case '\f': _buf.append('\\'); cc = 'f'; break;
				}
				_buf.append(cc);
			}
			_buf.append('\'');
		}
	}
}
