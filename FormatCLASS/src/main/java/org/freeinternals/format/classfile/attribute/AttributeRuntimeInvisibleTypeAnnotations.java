package org.freeinternals.format.classfile.attribute;

import java.io.IOException;
import org.freeinternals.commonlib.core.PosDataInputStream;
import org.freeinternals.commonlib.core.FileFormatException;
import org.freeinternals.format.classfile.ClassFile;
import org.freeinternals.format.classfile.JavaSEVersion;
import org.freeinternals.format.classfile.u2;

/**
 * The RuntimeInvisibleTypeAnnotations attribute records run-time invisible
 * annotations on types used in the corresponding declaration of a class, field,
 * or method, or in an expression in the corresponding method body. The
 * RuntimeInvisibleTypeAnnotations attribute also records annotations on type
 * parameter declarations of generic classes, interfaces, methods, and
 * constructors.
 *
 * The RuntimeInvisibleTypeAnnotations attribute has the following format:
 * <pre>
 *   RuntimeInvisibleTypeAnnotations_attribute {
 *     u2              attribute_name_index;
 *     u4              attribute_length;
 *
 *     u2              num_annotations;
 *     type_annotation annotations[num_annotations];
 *   }
 * </pre>
 *
 * @author Amos Shi
 * @since Java 8
 * @see <a
 * href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.7.21">
 * VM Spec: The RuntimeInvisibleTypeAnnotations Attribute
 * </a>
 */
public class AttributeRuntimeInvisibleTypeAnnotations extends AttributeRuntimeTypeAnnotations {

    public AttributeRuntimeInvisibleTypeAnnotations(u2 nameIndex, String name, PosDataInputStream posDataInputStream) throws IOException, FileFormatException {
        super(nameIndex, name, posDataInputStream, ClassFile.Version.Format_52_0, JavaSEVersion.Version_8);
    }
}
