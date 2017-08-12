package pers.luan.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import pers.luan.web.bean.AboutBean;

public class AboutDAO {

	private final Properties properties;

	public AboutDAO(Properties properties) {
		this.properties = properties;
	}
	
	public AboutBean fetchRTBean() {
		List<String> list = new ArrayList<>();
		list.add(String.format(Locale.getDefault(), "%s (%s)", properties.get("java.runtime.name"), properties.get("java.runtime.version")));
		list.add(properties.getProperty("java.home"));
		
		AboutBean rtBean = new AboutBean();
		rtBean.setKey("Java Runtime Environment");
		rtBean.setList(list);
		return rtBean;
	}
	
	public AboutBean[] fetchVMBean() {
		AboutBean vmBean = new AboutBean();
		vmBean.setKey("Java Virtual Machine");
		vmBean.setValue(String.format(Locale.getDefault(), "%s %s (%s_%s)", properties.get("java.vm.vendor"), properties.get("java.vm.name"), properties.get("java.vm.info"), properties.get("java.vm.version")));
		
		AboutBean specBean = new AboutBean();
		specBean.setKey(null);
		specBean.setValue(String.format(Locale.getDefault(), "%s %s (%s)", properties.get("java.vm.specification.vendor"), properties.get("java.vm.specification.name"), properties.get("java.vm.specification.version")));
		return new AboutBean[]{vmBean, specBean};
	}
	
	public AboutBean fetchServerBean() {
		AboutBean bean = new AboutBean();
		bean.setKey("Server Environment");
		bean.setValue(properties.getProperty("catalina.home"));
		return bean;
	}
	
	public AboutBean fetchOSBean() {
		AboutBean osBean = new AboutBean();
		osBean.setKey("OS Information");
		osBean.setValue(String.format(Locale.getDefault(), "%s_%s_%s", properties.get("os.name"), properties.get("os.version"), properties.get("os.arch")));
		return osBean;
	}
	
	public AboutBean fetchUserBean() {
		List<String> list = new ArrayList<>();
		list.add("User Name: " + properties.get("user.name"));
		list.add("User Home: " + properties.get("user.home"));
		list.add("User Directory: " + properties.get("user.dir"));
		list.add("User Environment: " + properties.getProperty("user.country") + "_" + properties.getProperty("user.timezone") + "_" + properties.getProperty("user.language"));
		
		AboutBean userBean = new AboutBean();
		userBean.setKey("User Information");
		userBean.setList(list);
		return userBean;
	}
	
	public AboutBean fetchJarBean() {
		StringBuilder builder = new StringBuilder();
		builder.append(properties.getProperty("tomcat.util.scan.StandardJarScanFilter.jarsToScan")).append(",").append(properties.get("tomcat.util.scan.StandardJarScanFilter.jarsToSkip")).append(",").append(properties.get("java.class.path"));
		List<String> list = new ArrayList<>();
		
		for (String item : builder.toString().split("[,:]+")) {
			list.add(item);
		}
		
		AboutBean jarBean = new AboutBean();
		jarBean.setKey("Dependent Library");
		jarBean.setList(list);
		return jarBean;
	}
	
}
