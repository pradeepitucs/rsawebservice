/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class RoleModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "role_t")
@NamedQuery(name = "RoleModel.findAll", query = "SELECT r FROM RoleModel r")
public class RoleModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;

	/** The role name. */
	@Column(name = "role_name")
	private String roleName;

	/** The user models. */
	//bi-directional many-to-one association to UserModel
	@OneToMany(mappedBy = "roleModel", fetch = FetchType.EAGER)
	private List<UserModel> userModels;

	/**
	 * Instantiates a new role model.
	 */
	public RoleModel()
	{
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public int getRoleId()
	{
		return this.roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId
	 *           the new role id
	 */
	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName()
	{
		return this.roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName
	 *           the new role name
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	/**
	 * Gets the user models.
	 *
	 * @return the user models
	 */
	public List<UserModel> getUserModels()
	{
		return this.userModels;
	}

	/**
	 * Sets the user models.
	 *
	 * @param userModels
	 *           the new user models
	 */
	public void setUserModels(List<UserModel> userModels)
	{
		this.userModels = userModels;
	}

	/**
	 * Adds the user model.
	 *
	 * @param userModel
	 *           the user model
	 * @return the user model
	 */
	public UserModel addUserModel(UserModel userModel)
	{
		getUserModels().add(userModel);
		userModel.setRoleModel(this);

		return userModel;
	}

	/**
	 * Removes the user model.
	 *
	 * @param userModel
	 *           the user model
	 * @return the user model
	 */
	public UserModel removeUserModel(UserModel userModel)
	{
		getUserModels().remove(userModel);
		userModel.setRoleModel(null);

		return userModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RoleModel [roleId=" + roleId + ", roleName=" + roleName + ", userModels=" + userModels + "]";
	}


}
