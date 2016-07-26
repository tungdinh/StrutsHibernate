package controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.MappingDispatchAction;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Department;
import entities.Member;
import form.MemberForm;
import model.MemberModel;
import util.HibernateUtil;


public class MemberAction extends MappingDispatchAction{
	//外部キーデフォルト
	public BigDecimal departmentId = new BigDecimal(1);

	public ActionForward MemberList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		departmentId = new BigDecimal(1);
		MemberModel member = new MemberModel();
		ArrayList<Member> list = member.getMembers(departmentId);
		ArrayList<Department> listDep = member.getDepartments();
    	request.setAttribute("choices", listDep);
		request.setAttribute("member.info", list.toArray());

		return mapping.findForward("success");
	}
	public ActionForward MemberListbyDepartment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//パラメータdepartment_id(部門id)を取得
		String dpt_id = request.getParameter("dpt_id");
		//キーワードに入力値を取得
		String key = request.getParameter("key");
		if (dpt_id != "" && dpt_id != null) {
			departmentId = new BigDecimal(dpt_id);
		}
		MemberModel member = new MemberModel();
		ArrayList<Member> list;

		if(key == null || "".equals(key)){
			list = member.getMembers(departmentId);
		} else {
			list = member.getMembers(departmentId, key);
		}
		request.setAttribute("member.info", list.toArray());

		return mapping.findForward("success");
	}

	//メンバー追加
	public ActionForward AddMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		MemberForm memberform = (MemberForm)form;
		//memberform.reset(mapping, request);
		return mapping.findForward("add");

	}
	public ActionForward MemberSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		//session取得
		Session session = HibernateUtil.getSession();

		MemberForm memberform = (MemberForm)form;
		Member member = new Member();

		//部門テーブルに部門idをセット
		Department dp = new Department();
		dp.setId(memberform.getDepartment_id());
		member.setDepartment(dp);

		//フォームをモデルにコピーする
		BeanUtils.copyProperties(member, memberform);

		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();

		//追加機能の画面を初期化
		memberform.reset(mapping, request);

		return mapping.findForward("save");

	}
	//メンバー削除
	public ActionForward MemberDelete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		//session取得
		Session session = HibernateUtil.getSession();
		//削除したいパラメータidを取得
		String idx = request.getParameter("id");
		Integer id = new Integer(idx);

		//削除したいメンバー情報を取得
		Member mb = (Member) session.load(Member.class, id);
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(mb);
		} catch (ObjectNotFoundException ex) {
			System.out.println(ex);
		} finally {
			transaction.commit();
		}
		return mapping.findForward("delete");

	}
	//メンバー情報表示(編集可能)
	public ActionForward MemberEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//パラメータidを取得
		String idx = request.getParameter("id");
		Integer id = new Integer(idx);

		//session取得
		Session session = HibernateUtil.getSession();
		Member mm = (Member) session.load(Member.class, id);

		ArrayList list = new ArrayList();
		list.add(mm);

		request.setAttribute("dptId", mm.getDepartment().getId());
        request.setAttribute("listEdit", list);

        return mapping.findForward("edit");

	}
	//メンバー情報更新
	public ActionForward MemberUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//session取得
		Session session = HibernateUtil.getSession();

		MemberForm memberform = (MemberForm)form;

		Member member = new Member();

		//部門テーブルに部門idをセット
		Department dp = new Department();
		dp.setId(memberform.getDepartment_id());
		member.setDepartment(dp);

		//メンバーフォームをモデルにコピーするl
		BeanUtils.copyProperties(member, memberform);

		session.beginTransaction();
		session.update(member);
		session.getTransaction().commit();

		//追加機能の画面を初期化
		memberform.reset(mapping, request);

        return mapping.findForward("update");

	}

}
