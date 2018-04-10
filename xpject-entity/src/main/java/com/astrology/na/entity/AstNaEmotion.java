package com.astrology.na.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class AstNaEmotion implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 魅力
     */
    private String cy1;

    /**
     * 爱情分析
     */
    private String cy2;

    /**
     * 恋爱态度
     */
    private String cy3;

    /**
     * 恋爱风格
     */
    private String cy4;

    /**
     * 魅力展现
     */
    private String cy5;

    /**
     * 吸引你的人
     */
    private String cy6;

    /**
     * 适合你的人
     */
    private String cy7;

    /**
     * 太阳星座优秀
     */
    private String cy8;

    /**
     * 月亮星座优秀
     */
    private String cy9;

    /**
     * 适合恋爱的年份
     */
    private String cy10;

    /**
     * 适合结婚的年份
     */
    private String cy11;

    /**
     * 恋爱时机
     */
    private String cy12;

    /**
     * 桃花
     */
    private String cy13;

    /**
     * 愉悦
     */
    private String cy14;

    /**
     * 稳定
     */
    private String cy15;

    /**
     * 欲望
     */
    private String cy16;

    /**
     * 旺夫
     */
    private String cy17;

    /**
     * 宠妻
     */
    private String cy18;

    /**
     * 太阳星座良好
     */
    private String cy19;

    /**
     * 月亮星座良好
     */
    private String cy20;

    /**
     * 太阳星座尚可
     */
    private String cy21;

    /**
     * 月亮星座尚可
     */
    private String cy22;

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

    public String getCy14() {
        return cy14;
    }

    public void setCy14(String cy14) {
        this.cy14 = cy14;
    }

    public String getCy15() {
        return cy15;
    }

    public void setCy15(String cy15) {
        this.cy15 = cy15;
    }

    public String getCy16() {
        return cy16;
    }

    public void setCy16(String cy16) {
        this.cy16 = cy16;
    }

    public String getCy17() {
        return cy17;
    }

    public void setCy17(String cy17) {
        this.cy17 = cy17;
    }

    public String getCy18() {
        return cy18;
    }

    public void setCy18(String cy18) {
        this.cy18 = cy18;
    }

    public String getCy19() {
        return cy19;
    }

    public void setCy19(String cy19) {
        this.cy19 = cy19;
    }

    public String getCy20() {
        return cy20;
    }

    public void setCy20(String cy20) {
        this.cy20 = cy20;
    }

    public String getCy21() {
        return cy21;
    }

    public void setCy21(String cy21) {
        this.cy21 = cy21;
    }

    public String getCy22() {
        return cy22;
    }

    public void setCy22(String cy22) {
        this.cy22 = cy22;
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
        AstNaEmotion other = (AstNaEmotion) that;
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
            && (this.getCy14() == null ? other.getCy14() == null : this.getCy14().equals(other.getCy14()))
            && (this.getCy15() == null ? other.getCy15() == null : this.getCy15().equals(other.getCy15()))
            && (this.getCy16() == null ? other.getCy16() == null : this.getCy16().equals(other.getCy16()))
            && (this.getCy17() == null ? other.getCy17() == null : this.getCy17().equals(other.getCy17()))
            && (this.getCy18() == null ? other.getCy18() == null : this.getCy18().equals(other.getCy18()))
            && (this.getCy19() == null ? other.getCy19() == null : this.getCy19().equals(other.getCy19()))
            && (this.getCy20() == null ? other.getCy20() == null : this.getCy20().equals(other.getCy20()))
            && (this.getCy21() == null ? other.getCy21() == null : this.getCy21().equals(other.getCy21()))
            && (this.getCy22() == null ? other.getCy22() == null : this.getCy22().equals(other.getCy22()));
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
        result = prime * result + ((getCy14() == null) ? 0 : getCy14().hashCode());
        result = prime * result + ((getCy15() == null) ? 0 : getCy15().hashCode());
        result = prime * result + ((getCy16() == null) ? 0 : getCy16().hashCode());
        result = prime * result + ((getCy17() == null) ? 0 : getCy17().hashCode());
        result = prime * result + ((getCy18() == null) ? 0 : getCy18().hashCode());
        result = prime * result + ((getCy19() == null) ? 0 : getCy19().hashCode());
        result = prime * result + ((getCy20() == null) ? 0 : getCy20().hashCode());
        result = prime * result + ((getCy21() == null) ? 0 : getCy21().hashCode());
        result = prime * result + ((getCy22() == null) ? 0 : getCy22().hashCode());
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
        sb.append(", cy14=").append(cy14);
        sb.append(", cy15=").append(cy15);
        sb.append(", cy16=").append(cy16);
        sb.append(", cy17=").append(cy17);
        sb.append(", cy18=").append(cy18);
        sb.append(", cy19=").append(cy19);
        sb.append(", cy20=").append(cy20);
        sb.append(", cy21=").append(cy21);
        sb.append(", cy22=").append(cy22);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}