package com.sample;


public class MerchantMessage {

  private long id;
  private String adcode;
  private String title;
  private String content;
  private java.sql.Date startTime;
  private java.sql.Date endTime;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private java.sql.Timestamp onlineTime;
  private long state;
  private long channelId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAdcode() {
    return adcode;
  }

  public void setAdcode(String adcode) {
    this.adcode = adcode;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Date getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Date startTime) {
    this.startTime = startTime;
  }


  public java.sql.Date getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Date endTime) {
    this.endTime = endTime;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public java.sql.Timestamp getOnlineTime() {
    return onlineTime;
  }

  public void setOnlineTime(java.sql.Timestamp onlineTime) {
    this.onlineTime = onlineTime;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public long getChannelId() {
    return channelId;
  }

  public void setChannelId(long channelId) {
    this.channelId = channelId;
  }

}
