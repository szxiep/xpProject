package com.business.astrology.algorithmic.impl;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

import com.business.astrology.algorithmic.api.IAstrologCalculator;
import com.business.astrology.algorithmic.api.INatal;
import com.business.astrology.algorithmic.bean.CP;
import com.business.astrology.algorithmic.bean.Natal;

public class AstrologTestCaseProvider implements IAstrologCalculator {

	@Override
	public INatal calc() {
		Scanner scanner = null;
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("com/gnet/lib/astrolog/testcase/natal1.txt");
			scanner = new Scanner(new BufferedInputStream(is));
			CP cp = new CP();
			int objSize = scanner.nextInt();
			for (int i = 0; i < objSize; ++i) {
				cp.obj[i] = scanner.nextDouble();
			}
			int altSize = scanner.nextInt();
			for (int i = 0; i < altSize; ++i) {
				cp.alt[i] = scanner.nextDouble();
			}
			int dirSize = scanner.nextInt();
			for (int i = 0; i < dirSize; ++i) {
				cp.dir[i] = scanner.nextDouble();
			}
			int cuspSize = scanner.nextInt();
			for (int i = 0; i < cuspSize; ++i) {
				cp.cusp[i] = scanner.nextDouble();
			}
			int houseSize = scanner.nextInt();
			for (int i = 0; i < houseSize; ++i) {
				cp.house[i] = scanner.nextInt();
			}
			// 示例数据以出生数据 2017年7月9日16时北京为例，演示宫制和坐标系统切换
			return new Natal(cp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != scanner) {
				scanner.close();
			}
		}

		return null;
	}
}
