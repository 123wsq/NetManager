package com.wsq.net.manager.bean;

public class Attributes
{
  String url;
  private String menuType;
  private String menuStatus;

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMenuType() {
    return this.menuType;
  }

  public void setMenuType(String menuType) {
    this.menuType = menuType;
  }

  public String getMenuStatus() {
    return this.menuStatus;
  }

  public void setMenuStatus(String menuStatus) {
    this.menuStatus = menuStatus;
  }
}