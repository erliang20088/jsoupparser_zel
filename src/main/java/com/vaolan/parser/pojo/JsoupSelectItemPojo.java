package com.vaolan.parser.pojo;
/**
 * jsoup
 * @author zel
 *
 */
public class JsoupSelectItemPojo {
	private String selector;
	
	public JsoupSelectItemPojo(String selector, 
			boolean have_remove_sel) {
		this.selector = selector;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}
}
