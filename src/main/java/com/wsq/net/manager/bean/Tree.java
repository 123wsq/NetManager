package com.wsq.net.manager.bean;

import java.util.ArrayList;
import java.util.List;

public class Tree
{
  private String id;
  private String text;
  private String name; //适配菜单树中得选中
  private String type;
  private boolean checked;
  private String menuParId;
  private String url;
  private Attributes attributes;
  public List<Tree> children = new ArrayList();

  public String toString()
  {
    return "Tree [id=" + this.id + ", text=" + this.text + ", checked=" + this.checked + 
      ", menuParId=" + this.menuParId + ", url=" + this.url + ", attributes=" + 
      this.attributes + ", children=" + this.children + "]";
  }

  public Attributes getAttributes()
  {
    return this.attributes;
  }

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean getChecked() {
    return this.checked;
  }
  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public String getText()
  {
    return this.text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public List<Tree> getChildren() {
    return this.children;
  }
  public void setChildren(List<Tree> children) {
    this.children = children;
  }
  public String getMenuParId() {
    return this.menuParId;
  }
  public void setMenuParId(String menuParId) {
    this.menuParId = menuParId;
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

  
  
  
}