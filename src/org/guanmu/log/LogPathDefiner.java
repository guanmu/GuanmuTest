package org.guanmu.log;



import ch.qos.logback.core.PropertyDefinerBase;

/**
 * ��־·���Զ�����
 * @author wangquan
 *
 */
public class LogPathDefiner extends PropertyDefinerBase {

	@Override
	public String getPropertyValue() {
			
		return "C:/guanmu/GuanmuTest";
	}

}
