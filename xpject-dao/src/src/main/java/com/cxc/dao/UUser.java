package com.cxc.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UUser implements Serializable {
    private Integer id;

    /**
     * 用户名称或者昵称
     */
    private String name;

    /**
     * 性别(0：男，1:女)
     */
    private Integer sex;

    /**
     * 省
     */
    private String province;

    /**
     * 县
     */
    private String county;

    /**
     * 市
     */
    private String city;

    /**
     * 是否在夏令时时间，1：是，2不是
     */
    private Integer saving;

    /**
     * 出生时间（阳历）(输入时间)
     */
    private Date datetime;

    /**
     * 手机号
     */
    private String phone;

    /**
     * QQ授权
     */
    private String qqauth;

    /**
     * 微信授权
     */
    private String wxauth;

    /**
     * 微信公众号唯一标示
     */
    private String openid;

    /**
     * 微博授权
     */
    private String wbauth;

    private String password;

    /**
     * 注册时间
     */
    private Date register;

    /**
     * 头像
     */
    private String header;

    /**
     * 1.启用状态，2.禁用状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSaving() {
        return saving;
    }

    public void setSaving(Integer saving) {
        this.saving = saving;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqauth() {
        return qqauth;
    }

    public void setQqauth(String qqauth) {
        this.qqauth = qqauth;
    }

    public String getWxauth() {
        return wxauth;
    }

    public void setWxauth(String wxauth) {
        this.wxauth = wxauth;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWbauth() {
        return wbauth;
    }

    public void setWbauth(String wbauth) {
        this.wbauth = wbauth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UUser other = (UUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getSaving() == null ? other.getSaving() == null : this.getSaving().equals(other.getSaving()))
            && (this.getDatetime() == null ? other.getDatetime() == null : this.getDatetime().equals(other.getDatetime()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getQqauth() == null ? other.getQqauth() == null : this.getQqauth().equals(other.getQqauth()))
            && (this.getWxauth() == null ? other.getWxauth() == null : this.getWxauth().equals(other.getWxauth()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getWbauth() == null ? other.getWbauth() == null : this.getWbauth().equals(other.getWbauth()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRegister() == null ? other.getRegister() == null : this.getRegister().equals(other.getRegister()))
            && (this.getHeader() == null ? other.getHeader() == null : this.getHeader().equals(other.getHeader()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getSaving() == null) ? 0 : getSaving().hashCode());
        result = prime * result + ((getDatetime() == null) ? 0 : getDatetime().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getQqauth() == null) ? 0 : getQqauth().hashCode());
        result = prime * result + ((getWxauth() == null) ? 0 : getWxauth().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getWbauth() == null) ? 0 : getWbauth().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRegister() == null) ? 0 : getRegister().hashCode());
        result = prime * result + ((getHeader() == null) ? 0 : getHeader().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", province=").append(province);
        sb.append(", county=").append(county);
        sb.append(", city=").append(city);
        sb.append(", saving=").append(saving);
        sb.append(", datetime=").append(datetime);
        sb.append(", phone=").append(phone);
        sb.append(", qqauth=").append(qqauth);
        sb.append(", wxauth=").append(wxauth);
        sb.append(", openid=").append(openid);
        sb.append(", wbauth=").append(wbauth);
        sb.append(", password=").append(password);
        sb.append(", register=").append(register);
        sb.append(", header=").append(header);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}