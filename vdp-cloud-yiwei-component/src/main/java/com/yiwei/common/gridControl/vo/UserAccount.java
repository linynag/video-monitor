package com.yiwei.common.gridControl.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 登录用户信息
 * @author: chenxin
 * @date: 2019/5/01 17:34
 */
public class UserAccount implements Serializable{

	private static final long serialVersionUID = 6063968049391620301L;
	private Long userId;
	private String account;
	private String username;
	private String password;
	private Long orgId;
	private String orgName;
	private String orgCode;
	private String orgPath;
	private String mobile;
	private String email;
	private String role;// 用户角色 1对1
	private Set<String> roles;// 用户角色 1对多
	private Set<String> function;// 功能
    private String orgLogo;// 系统显示的logo
    private String orgTitle;// 系统显示的命名
    private String recordInfo;// 系统备案信息如：X公网安备 42XXXXXXXXX号'
    private String recordNum;// 系统备案信息如：XICP备1XXXXXX号'


	//以下是扩展字段 TODO 没使用
	private int accountType;
	private int initPassStatus;
	private String userCode;
	private Date createdDate;
	private Date lastUpdatedDate;
	private String authcode;
	private String oldPassword;
	private String nickname;
	private String contactName;
	private String contactPhone;
	private Long refParkId;
	private String refParkCode;
	private String refParkName;


    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public String getOrgTitle() {
        return orgTitle;
    }

    public void setOrgTitle(String orgTitle) {
        this.orgTitle = orgTitle;
    }

    public String getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(String recordInfo) {
        this.recordInfo = recordInfo;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgPath() {
		return orgPath;
	}

	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public Set<String> getFunction() {
		return function;
	}

	public void setFunction(Set<String> function) {
		this.function = function;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getInitPassStatus() {
		return initPassStatus;
	}

	public void setInitPassStatus(int initPassStatus) {
		this.initPassStatus = initPassStatus;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Long getRefParkId() {
		return refParkId;
	}

	public void setRefParkId(Long refParkId) {
		this.refParkId = refParkId;
	}

	public String getRefParkCode() {
		return refParkCode;
	}

	public void setRefParkCode(String refParkCode) {
		this.refParkCode = refParkCode;
	}

	public String getRefParkName() {
		return refParkName;
	}

	public void setRefParkName(String refParkName) {
		this.refParkName = refParkName;
	}
}
