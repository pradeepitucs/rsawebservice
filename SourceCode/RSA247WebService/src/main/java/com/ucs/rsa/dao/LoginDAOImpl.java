package com.ucs.rsa.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.Customer;

@Component
public class LoginDAOImpl extends BaseRepository implements ILoginDAO {

	@Override
	public String numberExist(long mobileNumber, String gcmId) {
		String result = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			Customer customer = null;
			customer = (Customer) theSession.createCriteria(Customer.class, "customer")
					.add(Restrictions.eq("mobileNo", mobileNumber)).uniqueResult();
			
			if(customer!= null) {			
				if (customer.getGcmId()==gcmId) {
					result = "no change";
				} else {
					//customer = new Customer();
					customer.setGcmId(gcmId);
					System.out.println("Before update");
					theSession.update(customer);
					System.out.println("After update");
					result = "updated";
				}
			} else {
				result = "not exist";
			}
		} catch (RuntimeException e) {
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return result;
	
	}

}
