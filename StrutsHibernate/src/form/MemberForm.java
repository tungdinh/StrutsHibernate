package form;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class MemberForm extends ValidatorForm{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private BigDecimal department_id;
	private String deparment;
	private String name;
	private String nameYomikata="";
	private String email;
	private String telephone;
	private String address;
	private String button;


	public String getButton() {

		return this.button;
	}

	public void setButton(String button) {
		//System.out.println(button);
		this.button = button;
	}

	public Integer getId() {
		//System.out.println("id : " + id);
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getDepartment_id() {
		//System.out.println("department_id : " + department_id);
		return this.department_id;
	}

	public void setDepartment_id(BigDecimal department_id) {
		this.department_id = department_id;
	}
	public String getDeparment(){
		//System.out.println("department : " + deparment);
		return this.deparment;
	}
	public void setDeparment(String deparment){
		this.deparment = deparment;
	}
	public String getName() {
		//System.out.println("name : " + name);
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameYomikata() {
		return this.nameYomikata;
	}

	public void setNameYomikata(String nameYomikata) {
		this.nameYomikata = nameYomikata;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	/*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errs = super.validate(mapping, request);
		Integer idx = getId();
		if(idx != null){
		//	System.out.println(idx);
			Session session = HibernateUtil.getSession();
			Member mb = (Member) session.get(Member.class, idx);
			if(mb != null ){
				//System.out.println(mb.getId());
				//System.out.println(mb.getName());
				if(mb.getId() == idx && button.equals("作成")) {
					ActionMessage err = new ActionMessage("error.exist");
					errs.add("exist",err);
				}
			}
		}
		System.out.println("name : " + getName());
		System.out.println("id : " + getId());
		System.out.println("department_id : " + getDepartment_id());
		/*ActionErrors errs = new ActionErrors();
		if (getName() == null || "".equals(getName())) {
			ActionMessage err = new ActionMessage("errors.name1");
			errs.add("name", err);
		} else if (getName().length() > 20 ) {
			ActionMessage err = new ActionMessage("errors.name2");
			errs.add("name", err);
		}
		if (getNameYomikata() == null || "".equals(getNameYomikata())) {
			ActionMessage err = new ActionMessage("errors.yomi1");
			errs.add("name_yomikata", err);
		} else if (getNameYomikata().length() > 20 ) {
			ActionMessage err = new ActionMessage("errors.yomi2");
			errs.add("name_yomikata", err);
		}

		return errs;

	}*/
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.setId(null);
		this.setDepartment_id(null);
		this.setDeparment("");
		this.setName("");
		this.setNameYomikata("");
		this.setEmail("");
		this.setTelephone("");
		this.setAddress("");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
	}

}
