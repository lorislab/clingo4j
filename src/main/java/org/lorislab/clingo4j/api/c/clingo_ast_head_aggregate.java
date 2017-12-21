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
@Name("clingo_ast_head_aggregate") 
@Library("clingo") 
public class clingo_ast_head_aggregate extends StructObject {
	/** C type : clingo_ast_aggregate_function_t */
	@Field(0) 
	public int function() {
		return this.io.getIntField(this, 0);
	}
	/** C type : clingo_ast_aggregate_function_t */
	@Field(0) 
	public clingo_ast_head_aggregate function(int function) {
		this.io.setIntField(this, 0, function);
		return this;
	}
	/** C type : const clingo_ast_head_aggregate_element_t* */
	@Field(1) 
	public Pointer<clingo_ast_head_aggregate_element > elements() {
		return this.io.getPointerField(this, 1);
	}
	/** C type : const clingo_ast_head_aggregate_element_t* */
	@Field(1) 
	public clingo_ast_head_aggregate elements(Pointer<clingo_ast_head_aggregate_element > elements) {
		this.io.setPointerField(this, 1, elements);
		return this;
	}
	@Ptr 
	@Field(2) 
	public long size() {
		return this.io.getSizeTField(this, 2);
	}
	@Ptr 
	@Field(2) 
	public clingo_ast_head_aggregate size(long size) {
		this.io.setSizeTField(this, 2, size);
		return this;
	}
	/** C type : const clingo_ast_aggregate_guard_t* */
	@Field(3) 
	public Pointer<clingo_ast_aggregate_guard > left_guard() {
		return this.io.getPointerField(this, 3);
	}
	/** C type : const clingo_ast_aggregate_guard_t* */
	@Field(3) 
	public clingo_ast_head_aggregate left_guard(Pointer<clingo_ast_aggregate_guard > left_guard) {
		this.io.setPointerField(this, 3, left_guard);
		return this;
	}
	/** C type : const clingo_ast_aggregate_guard_t* */
	@Field(4) 
	public Pointer<clingo_ast_aggregate_guard > right_guard() {
		return this.io.getPointerField(this, 4);
	}
	/** C type : const clingo_ast_aggregate_guard_t* */
	@Field(4) 
	public clingo_ast_head_aggregate right_guard(Pointer<clingo_ast_aggregate_guard > right_guard) {
		this.io.setPointerField(this, 4, right_guard);
		return this;
	}
	public clingo_ast_head_aggregate() {
		super();
	}
	public clingo_ast_head_aggregate(Pointer pointer) {
		super(pointer);
	}
}