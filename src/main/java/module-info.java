/**
 * 
 */
/**
 * 
 */
module ProjJPA_Mod33 {
	requires java.desktop;
	requires java.xml;
	requires jdk.compiler;
	requires jdk.javadoc;
	requires junit;
	requires java.persistence;
	exports br.com.borges.domain;
	opens br.com.borges.domain to org.hibernate.orm.core;
}