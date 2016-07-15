package com.ucs.rsa.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.CustomerDTO;
import com.ucs.rsa.common.dto.UserDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.Customer;
import com.ucs.rsa.domain.User;

@Component
public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	public UserDTO updateUser(int iUserId, String iUserFirstName,
			String iUserLastName, int iMobieNo, boolean isEnabled,
			boolean isCreate) {

		Session theSession = null;
		UserDTO userDTO = new UserDTO();

		try {

			theSession = currentSession();

			User user = null;

			if (isCreate) {
				user = (User) theSession.createCriteria(User.class, "user")
						.add(Restrictions.eq("mobileNo", iMobieNo))
						.uniqueResult();
				if (user != null) {
					RSAException rsaException = new RSAException();
					rsaException
							.setError(RSAErrorConstants.ErrorCode.USERNAME_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
				user = new User();
				user.setMobileNo(iMobieNo);
				user.setUserID(iUserId);
				user.setEnabled(isEnabled);
			} else {
				user = (User) theSession.createCriteria(User.class, "user")
						.add(Restrictions.ne("userId", iUserId))
						.add(Restrictions.eq("mobileNo", iMobieNo))
						.uniqueResult();
				if (user != null) {
					RSAException rsaException = new RSAException();
					rsaException
							.setError(RSAErrorConstants.ErrorCode.USERNAME_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
				user = new User();
				user.setMobileNo(iMobieNo);
				user.setUserID(iUserId);
				user.setEnabled(isEnabled);
			}

			// Need to check error on which case it will thow the error
			// theSession.saveOrUpdate(user);
			// org.hibernate.engine.jdbc.batch.internal.AbstractBatchImpl
			// release
			// INFO: HHH000010: On release of batch it still contained JDBC
			// statements

			theSession.save(user);

			user = (User) theSession.createCriteria(User.class, "user")
					.add(Restrictions.eq("mobileNo", iMobieNo)).uniqueResult();

			System.out.println(user);
			if (user != null) {
				userDTO.setUserId(user.getUserID());
				userDTO.setMobileNo(user.getMobileNo());
				userDTO.setEnabled(user.isEnabled());
			}

			System.out.println("userDTO " + userDTO);

		} catch (RSAException rsaException) {
			throw rsaException;
		} catch (RuntimeException runtimeException) {
			runtimeException.getStackTrace();
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}

		return userDTO;
	}

	@Override
	public UserDTO updateUser(UserDTO iUserDTO, boolean isCreate) {

		CustomerDTO customerDTO = (CustomerDTO) iUserDTO;
		Session theSession = null;

		System.out.println("Before Start" );
		try {

			theSession = currentSession();

			Customer customer = null;

			if (isCreate) {
				customer = (Customer) theSession
						.createCriteria(Customer.class, "customer")
						.add(Restrictions.eq("mobileNo",
								customerDTO.getMobileNo())).uniqueResult();
				if (customer != null) {
					RSAException rsaException = new RSAException();
					rsaException
							.setError(RSAErrorConstants.ErrorCode.USERNAME_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
				customer = new Customer();
				customer.setMobileNo(customerDTO.getMobileNo());
				customer.setUserID(customerDTO.getUserId());
				customer.setEnabled(customerDTO.isEnabled());
				customer.setUserFirstName(customerDTO.getUserFirstName());
				customer.setUserLastName(customerDTO.getUserLastName());
			} else {
				customer = (Customer) theSession
						.createCriteria(Customer.class, "customer")
						.add(Restrictions.ne("userId", customerDTO.getUserId()))
						.add(Restrictions.eq("mobileNo",
								customerDTO.getMobileNo())).uniqueResult();
				if (customer != null) {
					RSAException rsaException = new RSAException();
					rsaException
							.setError(RSAErrorConstants.ErrorCode.USERNAME_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
				customer = new Customer();
				customer.setMobileNo(customerDTO.getMobileNo());
				customer.setUserID(customerDTO.getUserId());
				customer.setEnabled(customerDTO.isEnabled());
				customer.setUserFirstName(customerDTO.getUserFirstName());
				customer.setUserLastName(customerDTO.getUserLastName());
			}

			// Need to check error on which case it will thow the error
			// theSession.saveOrUpdate(user);
			// org.hibernate.engine.jdbc.batch.internal.AbstractBatchImpl
			// release
			// INFO: HHH000010: On release of batch it still contained JDBC
			// statements

			System.out.println("Before Save" );
			theSession.save(customer);
			System.out.println("After Save" );
			
			customer = (Customer) theSession
					.createCriteria(Customer.class, "customer")
					.add(Restrictions.eq("mobileNo", customerDTO.getMobileNo()))
					.uniqueResult();

			System.out.println(customer);
			if (customer != null) {
				customerDTO.setUserId(customer.getUserID());
				customerDTO.setMobileNo(customer.getMobileNo());
				customerDTO.setEnabled(customer.isEnabled());
				customerDTO.setUserFirstName(customer.getUserFirstName());
				customerDTO.setUserLastName(customer.getUserLastName());
			}

			System.out.println("userDTO " + customerDTO);

		} catch (RSAException rsaException) {
			throw rsaException;
		} catch (RuntimeException runtimeException) {
			runtimeException.getStackTrace();
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return customerDTO;
	}

}