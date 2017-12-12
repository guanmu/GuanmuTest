package org.guanmu.log;



import ch.qos.logback.core.PropertyDefinerBase;

/**
 * 日志路径自定义类
 * @author wangquan
 *
 */
public class LogPathDefiner extends PropertyDefinerBase {

	@Override
	public String getPropertyValue() {
			
		return "C:/guanmu/GuanmuTest";
	}

}
