/*
 * ConstantLongInfo.java    4:43 AM, August 5, 2007
 *
 * Copyright  2007, FreeInternals.org. All rights reserved.
 * Use is subject to license terms.
 */
package org.freeinternals.format.classfile.constant;

import java.io.IOException;
import javax.swing.tree.DefaultMutableTreeNode;
import org.freeinternals.commonlib.core.BytesTool;
import org.freeinternals.commonlib.core.PosDataInputStream;
import org.freeinternals.commonlib.ui.JTreeNodeFileComponent;
import org.freeinternals.format.classfile.ClassFile;
import org.freeinternals.format.classfile.JavaSEVersion;

/**
 * The class for the {@code CONSTANT_Long_info} structure in constant pool. The
 * {@code CONSTANT_Long_info} structure has the following format:
 *
 * <pre>
 *    CONSTANT_Long_info {
 *        u1 tag;
 * 
 *        u4 high_bytes;
 *        u4 low_bytes;
 *    }
 * </pre>
 *
 * @author Amos Shi
 * @see
 * <a href="https://docs.oracle.com/javase/specs/jvms/se12/html/jvms-4.html#jvms-4.4.5">
 * VM Spec: The CONSTANT_Long_info Structure
 * </a>
 */
public class ConstantLongInfo extends CPInfo {

    public static final int RAW_DATA_SIZE = 8;
    public static final int LENGTH = 9;

    //private u4 high_bytes;
    //private u4 low_bytes;
    public final byte[] rawData;
    public final long longValue;

    ConstantLongInfo(final PosDataInputStream posDataInputStream) throws IOException {
        super(CPInfo.ConstantType.CONSTANT_Long.tag, true, ClassFile.Version.Format_45_3, JavaSEVersion.Version_1_0_2);
        super.startPos = posDataInputStream.getPos() - 1;
        super.length = LENGTH;

        this.rawData = posDataInputStream.getBuf(posDataInputStream.getPos(), RAW_DATA_SIZE);
        this.longValue = posDataInputStream.readLong();
    }

    @Override
    public String getName() {
        return ConstantType.CONSTANT_Long.name();
    }

    @Override
    public String getDescription() {
        return String.format("%s: Start Position: [%d], length: [%d], value: [%d].",
                this.getName(), this.startPos, this.length, this.longValue);
    }
    
    @Override
    public String toString(CPInfo[] constant_pool) {
        return String.valueOf(this.longValue);
    }

    @Override
    public void generateTreeNode(DefaultMutableTreeNode parentNode, ClassFile classFile) {
        parentNode.add(new DefaultMutableTreeNode(new JTreeNodeFileComponent(
                this.startPos + 1,
                4,
                "high_bytes - value: " + this.longValue + " - " + BytesTool.getByteDataHexView(this.rawData)
        )));
        parentNode.add(new DefaultMutableTreeNode(new JTreeNodeFileComponent(
                this.startPos + 5,
                4,
                "low_bytes"
        )));
    }
}
