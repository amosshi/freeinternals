/*
 * AttributeRuntimeInvisibleAnnotations.java    11:13 AM, April 28, 2014
 *
 * Copyright  2014, FreeInternals.org. All rights reserved.
 * Use is subject to license terms.
 */
package org.freeinternals.format.classfile.attribute;

import org.freeinternals.commonlib.core.PosDataInputStream;
import org.freeinternals.commonlib.core.FileFormatException;
import org.freeinternals.format.classfile.ClassFile;
import org.freeinternals.format.classfile.JavaSEVersion;
import org.freeinternals.format.classfile.u2;

/**
 * The {@code RuntimeInvisibleAnnotations} attribute is similar to the
 * {@code RuntimeVisibleAnnotations} attribute, except that the annotations
 * represented by a {@code RuntimeInvisibleAnnotations} attribute must not be
 * made available for return by reflective APIs, unless the Java Virtual Machine
 * has been instructed to retain these annotations via some
 * implementation-specific mechanism such as a command line flag. In the absence
 * of such instructions, the Java Virtual Machine ignores this attribute.
 *
 * The {@code RuntimeInvisibleAnnotations} attribute has the following format:
 * <pre>
 * RuntimeInvisibleAnnotations_attribute {
 *    u2         attribute_name_index;
 *    u4         attribute_length;
 *
 *    u2         num_annotations;
 *    annotation annotations[num_annotations];
 *}
 * </pre>
 *
 * @author Amos Shi
 * @since Java 5
 * @see <a
 * href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.17">
 * VM Spec: The RuntimeInvisibleAnnotations Attribute
 * </a>
 */
public class AttributeRuntimeInvisibleAnnotations extends AttributeRuntimeAnnotations {

    AttributeRuntimeInvisibleAnnotations(final u2 nameIndex, final String type, final PosDataInputStream posDataInputStream) throws java.io.IOException, FileFormatException {
        super(nameIndex, type, posDataInputStream, ClassFile.Version.Format_49_0, JavaSEVersion.Version_5_0);
    }
}
