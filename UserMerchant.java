package com.sample;


public class UserMerchant {

  private long userId;
  private String name;
  private long gender;
  private java.sql.Timestamp lastLoginTime;
  private String avatar;
  private String deleted;
  private String disabled;
  private long merchantId;
  private long departmentId;
  private long accountType;
  private java.sql.Timestamp createTime;
  private long role;
  private String securityStamp;
  private String comment;
  private String account;
  private String passwordHash;
  private String phoneNumber;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public java.sql.Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(java.sql.Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public String getDeleted() {
    return deleted;
  }

  public void setDeleted(String deleted) {
    this.deleted = deleted;
  }


  public String getDisabled() {
    return disabled;
  }

  public void setDisabled(String disabled) {
    this.disabled = disabled;
  }


  public long getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(long merchantId) {
    this.merchantId = merchantId;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public long getAccountType() {
    return accountType;
  }

  public void setAccountType(long accountType) {
    this.accountType = accountType;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }


  public String getSecurityStamp() {
    return securityStamp;
  }

  public void setSecurityStamp(String securityStamp) {
    this.securityStamp = securityStamp;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}
