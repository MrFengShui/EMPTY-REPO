package pers.luan.web.dao;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class AboutDAO {

	private final Properties properties;

	public AboutDAO(Properties properties) {
		this.properties = properties;
	}

	public Map<String, String> fetchServerBean() {
		Map<String, String> map = new TreeMap<>();
		map.put("Java Runtime Environment", String.format(Locale.getDefault(),
						"%s (%s)", properties.get("java.runtime.name"),
						properties.get("java.runtime.version")));
		map.put("Java Runtime Path", properties.getProperty("java.home"));
		map.put("Java Virtual Machine",
						String.format(Locale.getDefault(), "%s %s (%s_%s)",
										properties.get("java.vm.vendor"),
										properties.get("java.vm.name"),
										properties.get("java.vm.info"),
										properties.get("java.vm.version")));
		map.put("Java Specification", String.format(Locale.getDefault(),
						"%s %s (%s)",
						properties.get("java.vm.specification.vendor"),
						properties.get("java.vm.specification.name"),
						properties.get("java.vm.specification.version")));
		map.put("Server Environment", properties.getProperty("catalina.home"));

		StringBuilder builder = new StringBuilder();
		builder.append(properties
						.getProperty("tomcat.util.scan.StandardJarScanFilter.jarsToScan"))
						.append(",")
						.append(properties
										.get("tomcat.util.scan.StandardJarScanFilter.jarsToSkip"))
						.append(",").append(properties.get("java.class.path"))
						.append(",")
						.append(properties.get("sun.boot.class.path"));
		map.put("Dependent Library",
						builder.toString().replaceAll("[,:]+", " "));
		return map;
	}

	public Map<String, String> fetchSystemBean() {
		Map<String, String> map = new TreeMap<>();
		map.put("System Information",
						String.format(Locale.getDefault(), "%s_%s_%s",
										properties.get("os.name"),
										properties.get("os.version"),
										properties.get("os.arch")));
		map.put("User Name", properties.get("user.name").toString());
		map.put("User Home", properties.get("user.home").toString());
		map.put("User Directory", properties.get("user.dir").toString());
		map.put("User Environment", properties.getProperty("user.country") + "_"
						+ properties.getProperty("user.timezone") + "_"
						+ properties.getProperty("user.language"));
		return map;
	}

}
