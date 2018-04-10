package com.business.astrology.algorithmic.bean;

import java.io.File;

public class IS {


	public IS(Flag fHaveInfo, Flag fDst, Flag fProgress, Flag fReturn, Flag fMult, Flag fSeconds, Flag fSzPersist,
			Flag fSzInteract, Flag fNoEphFile, String szProgName, String szFileScreen, String szFileOut, int cszComment,
			int cchCol, int cchRow, double rSid, double jD, double jDp, File s, double t, double mC, double asc,
			double rA, double oB) {
		super();
		this.fHaveInfo = fHaveInfo;
		this.fDst = fDst;
		this.fProgress = fProgress;
		this.fReturn = fReturn;
		this.fMult = fMult;
		this.fSeconds = fSeconds;
		this.fSzPersist = fSzPersist;
		this.fSzInteract = fSzInteract;
		this.fNoEphFile = fNoEphFile;
		this.szProgName = szProgName;
		this.szFileScreen = szFileScreen;
		this.szFileOut = szFileOut;
		this.cszComment = cszComment;
		this.cchCol = cchCol;
		this.cchRow = cchRow;
		this.rSid = rSid;
		this.JD = jD;
		this.JDp = jDp;
		this.S = s;
		this.T = t;
		this.MC = mC;
		this.Asc = asc;
		this.RA = rA;
		this.OB = oB;
	}
	public Flag fHaveInfo; /* Do we need to prompt user for chart info? */
	public Flag fDst; /* Has Daylight Saving Time been autodetected? */
	public Flag fProgress; /* Are we doing a chart involving progression? */
	public Flag fReturn; /* Are we doing a transit chart for returns? */
	public Flag fMult; /* Have we already printed at least one text chart? */
	public Flag fSeconds; /* Do we print locations to nearest second? */
	public Flag fSzPersist; /* Are parameter strings persistent when processing? */
	public Flag fSzInteract; /* Are we in middle of chart so some setting fixed? */
	public Flag fNoEphFile; /* Have we already had a ephem file not found error? */
	public String szProgName; /* The name and path of the executable running. */
	public String szFileScreen; /* The file to send text output to as passed to -os. */
	public String szFileOut; /* The output chart filename string as passed to -o. */
	//public char **rgszComment; /* Points to any comment strings after -o filename. */
	public int cszComment; /* The number of strings after -o that are comments. */
	public int cchCol; /* The current column text charts are printing at. */
	public int cchRow; /* The current row text charts have scrolled to. */
	public double rSid; /* Sidedouble offset degrees to be added to locations. */
	public double JD; /* Fractional Julian day for current chart. */
	public double JDp; /* Julian day that a progressed chart indicates. */
	public File S; /* File to write text to. */
	public double T; /* Julian time for chart. */
	public double MC; /* Midheaven at chart time. */
	public double Asc; /* Ascendant at chart time. */
	public double RA; /* Right ascension at time. */
	public double OB; /* Obliquity of ecliptic. */
}
