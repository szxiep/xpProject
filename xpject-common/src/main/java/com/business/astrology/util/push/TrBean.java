package com.business.astrology.util.push;

import java.util.List;

//外盘星曜,本命星曜,多少度相位,第几宫 ,星座,守护星耀
public class TrBean {

	private Integer r1;		//TR星曜
	private Integer r2;		//本命星曜
	private String r3;		//发生相位
	private Integer r4;		//在第几宫(分)
	private Integer r4z;	//在第几宫(整)
	private Integer r5;		//所在星座
	private String r6;		//守护(宫)
	private String r7;		//分宫头相位(宫头_度数)
	private String r7z;		//整宫头相位(宫头_度数)
	private String r8;		//司掌宫位
	private Double r9;		//发生的容许度
	
	public Integer getR1() {
		return r1;
	}
	public void setR1(Integer r1) {
		this.r1 = r1;
	}
	public Integer getR2() {
		return r2;
	}
	public void setR2(Integer r2) {
		this.r2 = r2;
	}
	public String getR3() {
		return r3;
	}
	public void setR3(String r3) {
		this.r3 = r3;
	}
	public Integer getR4() {
		return r4;
	}
	public void setR4(Integer r4) {
		this.r4 = r4;
	}
	public Integer getR4z() {
		return r4z;
	}
	public void setR4z(Integer r4z) {
		this.r4z = r4z;
	}
	public Integer getR5() {
		return r5;
	}
	public void setR5(Integer r5) {
		this.r5 = r5;
	}
	public String getR6() {
		return r6;
	}
	public void setR6(String r6) {
		this.r6 = r6;
	}
	public String getR7() {
		return r7;
	}
	public void setR7(String r7) {
		this.r7 = r7;
	}
	public String getR7z() {
		return r7z;
	}
	public void setR7z(String r7z) {
		this.r7z = r7z;
	}
	public String getR8() {
		return r8;
	}
	public void setR8(String r8) {
		this.r8 = r8;
	}
	public Double getR9() {
		return r9;
	}
	public void setR9(Double r9) {
		this.r9 = r9;
	}
}
