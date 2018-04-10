package com.astrology.na.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class AstNaCause implements Serializable {
    private Integer id;

    private Integer userid;

    /**
     * 适宜从事行业
     */
    private String cy1;

    /**
     * 有利事业星座
     */
    private String cy2;

    /**
     * 有利团队星座
     */
    private String cy3;

    /**
     * 有利人脉星座
     */
    private String cy4;

    /**
     * 事业分析
     */
    private String cy5;

    /**
     * 责任感
     */
    private String cy6;

    /**
     * 执行力
     */
    private String cy7;

    /**
     * 沟通能力
     */
    private String cy8;

    /**
     * 应急能力
     */
    private String cy9;

    /**
     * 团队协作
     */
    private String cy10;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCy1() {
        return cy1;
    }

    public void setCy1(String cy1) {
        this.cy1 = cy1;
    }

    public String getCy2() {
        return cy2;
    }

    public void setCy2(String cy2) {
        this.cy2 = cy2;
    }

    public String getCy3() {
        return cy3;
    }

    public void setCy3(String cy3) {
        this.cy3 = cy3;
    }

    public String getCy4() {
        return cy4;
    }

    public void setCy4(String cy4) {
        this.cy4 = cy4;
    }

    public String getCy5() {
        return cy5;
    }

    public void setCy5(String cy5) {
        this.cy5 = cy5;
    }

    public String getCy6() {
        return cy6;
    }

    public void setCy6(String cy6) {
        this.cy6 = cy6;
    }

    public String getCy7() {
        return cy7;
    }

    public void setCy7(String cy7) {
        this.cy7 = cy7;
    }

    public String getCy8() {
        return cy8;
    }

    public void setCy8(String cy8) {
        this.cy8 = cy8;
    }

    public String getCy9() {
        return cy9;
    }

    public void setCy9(String cy9) {
        this.cy9 = cy9;
    }

    public String getCy10() {
        return cy10;
    }

    public void setCy10(String cy10) {
        this.cy10 = cy10;
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
        AstNaCause other = (AstNaCause) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCy1() == null ? other.getCy1() == null : this.getCy1().equals(other.getCy1()))
            && (this.getCy2() == null ? other.getCy2() == null : this.getCy2().equals(other.getCy2()))
            && (this.getCy3() == null ? other.getCy3() == null : this.getCy3().equals(other.getCy3()))
            && (this.getCy4() == null ? other.getCy4() == null : this.getCy4().equals(other.getCy4()))
            && (this.getCy5() == null ? other.getCy5() == null : this.getCy5().equals(other.getCy5()))
            && (this.getCy6() == null ? other.getCy6() == null : this.getCy6().equals(other.getCy6()))
            && (this.getCy7() == null ? other.getCy7() == null : this.getCy7().equals(other.getCy7()))
            && (this.getCy8() == null ? other.getCy8() == null : this.getCy8().equals(other.getCy8()))
            && (this.getCy9() == null ? other.getCy9() == null : this.getCy9().equals(other.getCy9()))
            && (this.getCy10() == null ? other.getCy10() == null : this.getCy10().equals(other.getCy10()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCy1() == null) ? 0 : getCy1().hashCode());
        result = prime * result + ((getCy2() == null) ? 0 : getCy2().hashCode());
        result = prime * result + ((getCy3() == null) ? 0 : getCy3().hashCode());
        result = prime * result + ((getCy4() == null) ? 0 : getCy4().hashCode());
        result = prime * result + ((getCy5() == null) ? 0 : getCy5().hashCode());
        result = prime * result + ((getCy6() == null) ? 0 : getCy6().hashCode());
        result = prime * result + ((getCy7() == null) ? 0 : getCy7().hashCode());
        result = prime * result + ((getCy8() == null) ? 0 : getCy8().hashCode());
        result = prime * result + ((getCy9() == null) ? 0 : getCy9().hashCode());
        result = prime * result + ((getCy10() == null) ? 0 : getCy10().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", cy1=").append(cy1);
        sb.append(", cy2=").append(cy2);
        sb.append(", cy3=").append(cy3);
        sb.append(", cy4=").append(cy4);
        sb.append(", cy5=").append(cy5);
        sb.append(", cy6=").append(cy6);
        sb.append(", cy7=").append(cy7);
        sb.append(", cy8=").append(cy8);
        sb.append(", cy9=").append(cy9);
        sb.append(", cy10=").append(cy10);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}