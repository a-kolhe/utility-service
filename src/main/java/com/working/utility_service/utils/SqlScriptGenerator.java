//package com.working.utility_service.utils;
//
//import java.io.File;
//import java.util.EnumSet;
//
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.tool.schema.SchemaExport;
//import org.hibernate.tool.schema.TargetType;
//
//public class SqlScriptGenerator {
//
//	public static void main(String[] args) {
//		// 🧹 Scan all compiled classes for record entities BEFORE bootstrapping
//		// Hibernate
//		scanAllRecordClasses(new File("target/classes"), "com.working.utility_service");
//
//		// ⚙️ Configure Hibernate registry with safe, minimal settings
//		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//				.applySetting("hibernate.dialect", "org.hibernate.dialect.MySQLDialect") // Hibernate 6 auto-detects,
//																							// but fine to keep
//				.applySetting("hibernate.boot.allow_jdbc_metadata_access", "false") // replaces deprecated
//																					// use_jdbc_metadata_defaults
//				.applySetting("hibernate.archive.autodetection", "none") // avoids scanning rogue classes
//				.build();
//
//		try {
//			// 📦 Explicitly register known-safe entity classes
//			Metadata metadata = new MetadataSources(registry)
//					.addAnnotatedClass(com.working.utility_service.entities.States.class)
//					.addAnnotatedClass(com.working.utility_service.entities.City.class).buildMetadata();
//
//			int entityCount = metadata.getEntityBindings().size();
//			System.out.println("📦 Entities registered: " + entityCount);
//			if (entityCount == 0) {
//				System.err.println("⚠️ No entities detected. Aborting export.");
//				return;
//			}
//
//			// 📜 Generate the SQL schema script
//			SchemaExport export = new SchemaExport();
//			export.setOutputFile("create.sql"); // will write to project root
//			export.setFormat(true);
//			export.setDelimiter(";");
//
//			export.create(EnumSet.of(TargetType.SCRIPT), metadata);
//
//			System.out.println("✅ create.sql generated successfully.");
//
//		} catch (Exception e) {
//			System.err.println("❌ Failed to generate create.sql");
//			e.printStackTrace();
//		} finally {
//			StandardServiceRegistryBuilder.destroy(registry);
//		}
//	}
//
//	public static void scanAllRecordClasses(File dir, String packagePrefix) {
//		if (!dir.exists() || !dir.isDirectory())
//			return;
//
//		File[] files = dir.listFiles();
//		if (files == null)
//			return;
//
//		for (File file : files) {
//			if (file.isDirectory()) {
//				scanAllRecordClasses(file, packagePrefix + "." + file.getName());
//			} else if (file.getName().endsWith(".class")) {
//				String className = packagePrefix + "." + file.getName().replace(".class", "");
//				try {
//					Class<?> clazz = Class.forName(className);
//					if (clazz.isRecord()) {
//						System.out.println("❌ Record detected: " + className);
//					}
//				} catch (Throwable t) {
//					// silently skip
//				}
//			}
//		}
//	}
//
//}
//
////
////cfg.addAnnotatedClass(com.working.utility_service.entities.City.class);
////cfg.addAnnotatedClass(com.working.utility_service.entities.States.class);