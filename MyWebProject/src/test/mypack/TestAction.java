/**
 * 
 */
package test.mypack;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 929284
 * 
 */
public class TestAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4148032879424117216L;

	private String name;

	public String execute() throws Exception {
		if ("SECRET".equalsIgnoreCase(name)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
