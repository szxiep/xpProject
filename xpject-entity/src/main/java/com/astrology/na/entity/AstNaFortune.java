package com.astrology.na.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class AstNaFortune implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 财务风险
     */
    private String cy1;

    /**
     * 财运解析
     */
    private String cy2;

    /**
     * 爆发机会
     */
    private String cy3;

    /**
     * 合作收益
     */
    private String cy4;

    /**
     * 博彩收益
     */
    private String cy5;

    /**
     * 房产投资
     */
    private String cy6;

    /**
     * 证券投资
     */
    private String cy7;

    /**
     * 风险投资
     */
    private String cy8;

    /**
     * 收藏投资
     */
    private String cy9;

    /**
     * 遗产赠予
     */
    private String cy10;

    /**
     * 储蓄保险
     */
    private String cy11;

    /**
     * 经营收益
     */
    private String cy12;

    /**
     * 薪金收益
     */
    private String cy13;

    private Integer status;

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

    public String getCy11() {
        return cy11;
    }

    public void setCy11(String cy11) {
        this.cy11 = cy11;
    }

    public String getCy12() {
        return cy12;
    }

    public void setCy12(String cy12) {
        this.cy12 = cy12;
    }

    public String getCy13() {
        return cy13;
    }

    public void setCy13(String cy13) {
        this.cy13 = cy13;
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
        AstNaFortune other = (AstNaFortune) that;
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
            && (this.getCy10() == null ? other.getCy10() == null : this.getCy10().equals(other.getCy10()))
            && (this.getCy11() == null ? other.getCy11() == null : this.getCy11().equals(other.getCy11()))
            && (this.getCy12() == null ? other.getCy12() == null : this.getCy12().equals(other.getCy12()))
            && (this.getCy13() == null ? other.getCy13() == null : this.getCy13().equals(other.getCy13()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
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
        result = prime * result + ((getCy11() == null) ? 0 : getCy11().hashCode());
        result = prime * result + ((getCy12() == null) ? 0 : getCy12().hashCode());
        result = prime * result + ((getCy13() == null) ? 0 : getCy13().hashCode());
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
        sb.append(", cy11=").append(cy11);
        sb.append(", cy12=").append(cy12);
        sb.append(", cy13=").append(cy13);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}