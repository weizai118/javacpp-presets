// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Base class for all data types
 * 
 *  Data types in this library are all *logical*. They can be expressed as
 *  either a primitive physical type (bytes or bits of some fixed size), a
 *  nested type consisting of other data types, or another data type (e.g. a
 *  timestamp encoded as an int64).
 * 
 *  Simple datatypes may be entirely described by their Type::type id, but
 *  complex datatypes are usually parametric. */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class DataType extends Fingerprintable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DataType(Pointer p) { super(p); }


  /** \brief Return whether the types are equal
   * 
   *  Types that are logically convertible from one to another (e.g. List<UInt8>
   *  and Binary) are NOT equal. */
  public native @Cast("bool") boolean Equals(@Const @ByRef DataType other, @Cast("bool") boolean check_metadata/*=true*/);
  public native @Cast("bool") boolean Equals(@Const @ByRef DataType other);

  /** \brief Return whether the types are equal */

  public native @SharedPtr @ByVal Field child(int i);

  public native @Const @ByRef FieldVector children();

  public native int num_children();

  public native @ByVal Status Accept(TypeVisitor visitor);

  /** \brief A string representation of the type, including any children */
  
  ///
  public native @StdString String ToString();

  /** \brief A string name of the type, omitting any child fields
   * 
   *  \note Experimental API
   *  @since 0.7.0 */
  
  ///
  public native @StdString String name();

  /** \brief Return the data type layout.  Children are not included.
   * 
   *  \note Experimental API */
  public native @ByVal DataTypeLayout layout();

  /** \brief Return the type category */
  public native @Cast("arrow::Type::type") int id();
}