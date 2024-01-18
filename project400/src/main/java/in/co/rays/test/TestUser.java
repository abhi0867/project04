package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {
		// testadd();
		// testupdate();
		// testdelete();
//		testSearch();
		testauthenticate();

	}

	private static void testadd() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(6);
		bean.setFirstNmae("ankush");
		bean.setLastNamt("maiviya");
		bean.setLoginId("ankush@gmail.com");
		bean.setPassword("178");
		bean.setAddress("indore");
		UserModel model = new UserModel();
		model.add(bean);

	}

	private static void testupdate() throws Exception {
		UserBean bean = new UserBean();
		bean.setFirstNmae("abhi");
		bean.setId(1);

		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testdelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(4);

	}

	private static void testauthenticate() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean.setLoginId("abhi@gmail.com");
		bean.setPassword("1235");
		UserBean bean1 = model.authenticate(bean.getLoginId(), bean.getPassword());
		if (bean1 != null) {

			System.out.println("   logoin");

		} else {
			System.out.println("user is invalid");
		}

	}

	private static void testSearch() throws Exception {
		UserBean bean = new UserBean();
		bean.setFirstNmae("");

		UserModel model = new UserModel();

		List list = model.Search(bean);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstNmae());
			System.out.print("\t" + bean.getLastNamt());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getAddress());
		}

	}

}
