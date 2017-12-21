package org.lorislab.clingo4j.api.c;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Ptr;
/**
 * <i>native declaration : src/main/clingo/lib/c/clingo.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Name("clingo_part") 
@Library("clingo") 
public class clingo_part extends StructObject {
	/**
	 * !< name of the program part<br>
	 * C type : const char*
	 */
	@Field(0) 
	public Pointer<Byte > name() {
		return this.io.getPointerField(this, 0);
	}
	/**
	 * !< name of the program part<br>
	 * C type : const char*
	 */
	@Field(0) 
	public clingo_part name(Pointer<Byte > name) {
		this.io.setPointerField(this, 0, name);
		return this;
	}
	/**
	 * !< array of parameters<br>
	 * C type : const clingo_symbol_t*
	 */
	@Field(1) 
	public Pointer<Long > params() {
		return this.io.getPointerField(this, 1);
	}
	/**
	 * !< array of parameters<br>
	 * C type : const clingo_symbol_t*
	 */
	@Field(1) 
	public clingo_part params(Pointer<Long > params) {
		this.io.setPointerField(this, 1, params);
		return this;
	}
	/** !< number of parameters */
	@Ptr 
	@Field(2) 
	public long size() {
		return this.io.getSizeTField(this, 2);
	}
	/** !< number of parameters */
	@Ptr 
	@Field(2) 
	public clingo_part size(long size) {
		this.io.setSizeTField(this, 2, size);
		return this;
	}
	public clingo_part() {
		super();
	}
	public clingo_part(Pointer pointer) {
		super(pointer);
	}
}