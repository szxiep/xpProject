package com.xp.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SysBanner extends BaseEntity implements Serializable {
    private Integer id;

    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String depict;

    /**
     * 显示图片url
     */
    private String imgurl;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;
    /**
     * 单击跳转url
     */
    private String ckurl;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCkurl() {
        return ckurl;
    }

    public void setCkurl(String ckurl) {
        this.ckurl = ckurl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}