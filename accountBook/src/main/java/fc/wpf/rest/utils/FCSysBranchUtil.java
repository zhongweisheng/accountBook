package fc.wpf.rest.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FCSysBranchUtil {		
	private String id;
    private String text;
    private String parentId;
    private Integer level;  
    private List<FCSysBranchUtil> children=new ArrayList<FCSysBranchUtil>();	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public List<FCSysBranchUtil> getChildren() {
		return children;
	}
	public void setChildren(List<FCSysBranchUtil> children) {
		this.children = children;
	}

}
