package com.ucs.rsa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role_t database table.
 * 
 */
@Entity
@Table(name="role_t")
@NamedQuery(name="RoleModel.findAll", query="SELECT r FROM RoleModel r")
public class RoleModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-one association to UserModel
	@OneToMany(mappedBy="roleModel", fetch=FetchType.EAGER)
	private List<UserModel> userModels;

	public RoleModel() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserModel> getUserModels() {
		return this.userModels;
	}

	public void setUserModels(List<UserModel> userModels) {
		this.userModels = userModels;
	}

	public UserModel addUserModel(UserModel userModel) {
		getUserModels().add(userModel);
		userModel.setRoleModel(this);

		return userModel;
	}

	public UserModel removeUserModel(UserModel userModel) {
		getUserModels().remove(userModel);
		userModel.setRoleModel(null);

		return userModel;
	}

	@Override
	public String toString() {
		return "RoleModel [roleId=" + roleId + ", roleName=" + roleName + ", userModels=" + userModels + "]";
	}

	
}